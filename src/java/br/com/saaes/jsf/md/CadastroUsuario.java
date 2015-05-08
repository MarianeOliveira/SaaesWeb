package br.com.saaes.jsf.md;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.autent.Autenticacao;
import br.com.saaes.facade.FacUtil;

import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.dao.DAO;
import static br.com.saaes.facade.FacUtil.USUARIO_KEY;
import br.com.saaes.util.JPAUtil;
import java.io.Serializable;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

/**
 *
 * @author f4679646
 */
@ManagedBean
public class CadastroUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private T900Usuario novoUsuario;
    private String confirmaSenha;
    private EntityManager em;

    private final Calendar calendar = Calendar.getInstance();

    @PostConstruct
    public void init() {
        this.em = JPAUtil.getEm();
        this.novoUsuario = new T900Usuario();

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

            FacUtil.setSession(Boolean.TRUE);
            FacUtil.setAtributoSessao(USUARIO_KEY, novoUsuario);
            FacUtil.redirectPag("/index.xhtml");

        } catch (Exception ex) {
            JsfUtil.addErrorMessage("Erro ao cadastrar usuário!");
        }

    }

    public String setNomeReduzido(String nome) {
        String nomeReduzido = "";
        int count = 0;
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) == ' ') {
                count++;
            }
            if (count < 2) {
                nomeReduzido = nomeReduzido + nome.charAt(i);
            }
        }
//        String sobreNome = nome.substring(nome.indexOf(" ") + 1, nome.length());
//        nomeReduzido = nome.substring(0, nome.indexOf(" ")) + " " + sobreNome.substring(0, sobreNome.indexOf(" "));
        return nomeReduzido;
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

}
