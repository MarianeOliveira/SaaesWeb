package br.com.saaes.facade;

import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.dao.DAO;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

/**
 *
 * @author
 */
public class FacUtil {

    protected static HttpSession session;
    protected static FacesContext context;

    @PostConstruct
    public void init() {
        setSession(Boolean.TRUE);
        context = FacesContext.getCurrentInstance();
    }

    public static T900Usuario t900UsuarioNome(String nome, EntityManager em) {
        return DAO.getSingleResultFromFromNamedQuery(T900Usuario.BUSCA_USUARIO, T900Usuario.class, em, nome);
    }
    
    public static void redirectPag(String pag) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + pag);
    }

    public static HttpSession getSession(boolean ativa) {
        session = (HttpSession) context.getExternalContext().getSession(ativa);
        return session;
    }

    public static void setSession(boolean o) {
                session = (HttpSession) getContext().getExternalContext().getSession(o);
    }

    public static final void setAtributoSessao(String nome, Object o) {
        session.setAttribute(nome, o);

    }

    public static final FacesContext getContext() {
        if (null == context) {
            context = FacesContext.getCurrentInstance();
        }
        return context;
    }

    public static HttpSession getSession() {
        return session;
    }

}