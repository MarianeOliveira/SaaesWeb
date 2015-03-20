package br.com.saaes.jsf.mb;

import br.com.saesdb.util.JPAUtil;
import java.io.Serializable;
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
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String USUARIO = "usuario";

    private EntityManager em;
    private String teste = "Consultas";

    @PostConstruct
    public void init() {
        em = JPAUtil.getEm();
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

}
