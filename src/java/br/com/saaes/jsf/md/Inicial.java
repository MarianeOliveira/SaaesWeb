package br.com.saaes.jsf.md;

import br.com.saaes.facade.FacUtil;
import br.com.saaes.modelo.T900Usuario;
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
public class Inicial implements Serializable {

    private static final long serialVersionUID = 1L;
    private HttpSession session;
    private T900Usuario usuario;
     FacesContext context = FacesContext.getCurrentInstance();


    public Inicial() {
    }

    @PostConstruct
    public void init() {
        session = FacUtil.getSession();

        if (null != session) {
                usuario = (T900Usuario) FacUtil.getSession().getAttribute("usuario");

        }
    }
    public void abrirNova(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/avaliacao.xhtml");
   
//            FacUtil.redirectPag("/avaliacao.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarExistente(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(context.getExternalContext().getRequestContextPath() + "/busca.xhtml");
   
//            FacUtil.redirectPag("/buscar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public T900Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(T900Usuario usuario) {
        this.usuario = usuario;
    }

}
