package br.com.saaes.jsf.md;

import br.com.saaes.facade.FacUtil;
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
    private HttpSession session;
    private String encerrado;
    FacesContext context = FacesContext.getCurrentInstance();


    @PostConstruct
    public void init() {
        encerrado = "Fim da sessão";

        try {
            if (null != FacUtil.getSession()) {
                session = FacUtil.getSession();
                FacUtil.getSession().removeAttribute(FacUtil.USUARIO_KEY);
               if(session.getAttribute(FacUtil.USUARIO_KEY) == null){
                  FacUtil.redirectPag("/login.xhtml");
               }
            }
            
        } catch (Throwable e) {
            throw  new IllegalArgumentException("Error "+e.getMessage());
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
