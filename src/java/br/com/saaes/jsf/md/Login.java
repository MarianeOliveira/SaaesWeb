package br.com.saaes.jsf.md;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.autenticacao.Autenticacao;
import br.com.saaes.facade.FacUtil;
import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.util.JPAUtil;
import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MARI
 */
@ManagedBean
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String USUARIO_KEY = "usuario";

    private EntityManager em;
    private String nomeUsuario;
    private String senhaUsuario;

    @PostConstruct
    public void init() {
        em = JPAUtil.getEm();

    }

    public void entrar() throws IOException, NoSuchAlgorithmException {
        if (null == FacUtil.getSession()) {
            FacUtil.setSession(true);
        }
        try {
            if (null != nomeUsuario || !nomeUsuario.equals("")) {
                T900Usuario usuario = new Autenticacao().validaT900Usuario(nomeUsuario, senhaUsuario, em);
                //verifica se é nulo
                //senao, verifica a senha
                if (null != usuario) {

                    FacUtil.setAtributoSessao(USUARIO_KEY, usuario);
                    FacUtil.redirectPag("/index.xhtml");
                } else {
                    JsfUtil.addAlertMessage("Usuário ou senha inválidos");
                }
            } else {
                JsfUtil.addAlertMessage("Informe os dados para entrar");
            }
        } catch (Exception e) {
            JsfUtil.addAlertMessage("Erro ao entrar");
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
