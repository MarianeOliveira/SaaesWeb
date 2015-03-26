package br.com.saaes.jsf.md;

import br.com.saesdb.util.JPAUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

/**
 *
 * @author f4679646
 */
@ManagedBean
public class Acessos implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String USUARIO = "usuario";

    private EntityManager em;
    private String teste = "Acessos";

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
