package br.com.saaes.jsf.mb;

import br.com.saaes.autenticacao.Autenticacao;
import br.com.saaes.app.util.JsfUtil;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import br.com.saaes.modelo.T900Usuario;
//import br.com.saaes.modelo.T900UsuarioPK;
import br.com.saesdb.util.JPAUtil;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author f4679646
 */
@ManagedBean
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String USUARIO = "usuario";

    private EntityManager em;
    private String nomeUsuario;
    private String senhaUsuario;
    private HttpSession session;
    FacesContext context = FacesContext.getCurrentInstance();
    @PostConstruct
    public void init() {
        em = JPAUtil.getEm();
        session = (HttpSession) context.getExternalContext().getSession(true);
    }

    public void login() {
        
    }
    
    public void sair() throws IOException{
        session = (HttpSession) context.getExternalContext().getSession(false);  
        if(null != session){
          session.invalidate();
           FacesContext.getCurrentInstance().getExternalContext().redirect( context.getExternalContext().getRequestContextPath() + "/login.xhtml");
         }
    }
    public void entrar() throws IOException {
        if (null != nomeUsuario) {
            T900Usuario usuario = new Autenticacao().validaT900Usuario(nomeUsuario, senhaUsuario);

            //verifica se é nulo
            //senao, verifica a senha
            if ( null != usuario ) {
                session.setAttribute(USUARIO, usuario);
                FacesContext.getCurrentInstance().getExternalContext().redirect( context.getExternalContext().getRequestContextPath() + "/index.xhtml");
            } else {
                JsfUtil.addAlertMessage("Usuário inválido");
            }

        }

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) throws NoSuchAlgorithmException {
        this.senhaUsuario = senhaUsuario;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

}
