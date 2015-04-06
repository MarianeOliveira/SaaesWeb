package br.com.saaes.jsf.mb;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.autenticacao.Autenticacao;
import br.com.saaes.facade.FacUtil;
import static br.com.saaes.jsf.mb.Login.USUARIO;
import br.com.saaes.modelo.T900Usuario;
import br.com.saesdb.dao.DAO;
import br.com.saesdb.util.JPAUtil;
import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author f4679646
 */
@ManagedBean
public class CadastroUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private T900Usuario novoUsuario;
       private T900Usuario usuarioSession;
    private String confirmaSenha;
    private EntityManager em;
    private HttpSession session;
    FacesContext context = FacesContext.getCurrentInstance();

    private final Calendar calendar = Calendar.getInstance();

    @PostConstruct
    public void init() {
        this.em = JPAUtil.getEm();
        this.novoUsuario = new T900Usuario();
        session =  (HttpSession) context.getExternalContext().getSession(true);

    }

    public void cadastraUsuario() {
        try {
            em.getTransaction().begin();
            novoUsuario.setSenha(Autenticacao.criptografa(novoUsuario.getSenha(), "MD5"));
            novoUsuario.setAtivo(Boolean.TRUE);
            novoUsuario.setDtInc(calendar.getTime());

            DAO.save(novoUsuario, novoUsuario.getId(), em, Boolean.TRUE);

            em.getTransaction().commit();

            JsfUtil.addSuccessMessage("Usuário cadastrado com Sucesso!");

            session.setAttribute(USUARIO, novoUsuario);
            FacesContext.getCurrentInstance().getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/index.xhtml");

        } catch (Exception ex) {
            JsfUtil.addErrorMessage("Erro ao cadastrar usuário!");
        }

    }
   
    
    
    public void isSenha() {
        if (confirmaSenha.equals(novoUsuario.getSenha())) {
            JsfUtil.addAlertMessage("Senhas OK");
        } else {
            JsfUtil.addAlertMessage("Senhas não são iguais");
        }
    }

    public T900Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(T900Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public T900Usuario getUsuarioSession() {
       usuarioSession = (T900Usuario) session.getAttribute(USUARIO);
        return usuarioSession;
    }

    public void setUsuarioSession(T900Usuario usuarioSession) {
        this.usuarioSession = usuarioSession;
    }
    
    

}
