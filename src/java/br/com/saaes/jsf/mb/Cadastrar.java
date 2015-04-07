package br.com.saaes.jsf.mb;

import br.com.saaes.modelo.T300ies;
import br.com.saaes.modelo.T901conceitos;
import br.com.saesdb.dao.DAO;
import br.com.saesdb.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author
 */
@ManagedBean(name = "cadastrar")
@ViewScoped
public class Cadastrar implements Serializable {

    
    EntityManager em;
    private List<T901conceitos> T901ConceitosList;
    private T300ies t300 = new T300ies();
    private T300ies usuario;

    @PostConstruct
    public void init() {
        this.em = JPAUtil.getEm();
        T901ConceitosList = DAO.getFromNamedQuery(T901conceitos.FIND_ALL, T901conceitos.class, em);
    }

    public void insereNovaIes() {
        try {
            if (null != t300) {
                em.getTransaction().begin();
                DAO.save(t300, t300.getId(), em, Boolean.TRUE);
                em.getTransaction().commit();
                t300 = new T300ies();
            }
        } catch (Exception e) {
        }
    }

    public T300ies getT300() {
        return t300;
    }

    public void setT300(T300ies t300) {
        this.t300 = t300;
    }

    public List<T901conceitos> getT901ConceitosList() {
        return T901ConceitosList;
    }

    public void setT901ConceitosList(List<T901conceitos> T901ConceitosList) {
        this.T901ConceitosList = T901ConceitosList;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public T300ies getUsuario() {
        return usuario;
    }

    public void setUsuario(T300ies usuario) {
        this.usuario = usuario;
    }

}
