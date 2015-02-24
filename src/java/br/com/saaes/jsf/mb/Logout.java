package br.com.saaes.jsf.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Logout implements Serializable {

    private static final long serialVersionUID = 1L;
    private EntityManager em;
    private HttpSession session;
    private String encerrado;
    FacesContext context = FacesContext.getCurrentInstance();


    @PostConstruct
    public void init() {
        encerrado = "Fim da sessão";

        session = (HttpSession) context.getExternalContext().getSession(false);
        if (null != session) {
            session.invalidate();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Logout() {
    }

    public String getEncerrado() {
        return encerrado;
    }

    public void setEncerrado(String encerrado) {
        this.encerrado = encerrado;
    }
}
