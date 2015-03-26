package br.com.saaes.facade;

import static br.com.saaes.jsf.md.Login.USUARIO;
import br.com.saaes.modelo.T900Usuario;
import br.com.saesdb.dao.DAO;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */
public class FacUtil {

    private static HttpSession session;
    private static FacesContext context = FacesContext.getCurrentInstance();

    private T900Usuario usuarioSession;

    public static T900Usuario t900UsuarioNome(String nome, EntityManager em) {
        return DAO.getSingleResultFromFromNamedQuery(T900Usuario.BUSCA_USUARIO, T900Usuario.class, em, nome);
    }

    public T900Usuario getUsuarioSession() {
        usuarioSession = (T900Usuario) session.getAttribute(USUARIO);
        return usuarioSession;
    }

    public void setUsuarioSession(T900Usuario usuarioSession) {
        this.usuarioSession = usuarioSession;
    }

    public static HttpSession getSession(boolean ativa) {
        session = (HttpSession) context.getExternalContext().getSession(ativa);
        return session;
    }

    public static FacesContext getContext() {
        return context;
    }

}
