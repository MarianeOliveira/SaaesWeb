package br.com.saaes.jsf.mb;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.app.util.TabViewMB;
import br.com.saaes.modelo.T200docente;
import br.com.saaes.modelo.T200docentePK;
import br.com.saaes.modelo.T201coordenador;
import br.com.saaes.modelo.T201coordenadorPK;
import br.com.saaes.modelo.T300ies;
import br.com.saaes.modelo.T400cursos;
import br.com.saaes.modelo.T901conceitos;
import br.com.saesdb.dao.DAO;
import br.com.saesdb.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author
 */
@ManagedBean(name = "cadastrar")
@ViewScoped
public class Cadastrar extends TabViewMB implements Serializable {

    EntityManager em;
//    private Integer abaAtiva = 0;
    private List<T901conceitos> T901ConceitosList;
    private List<T400cursos> t400List;
    private List<T300ies> t300list;
    private List<T200docente> t200DocenteList;
    private List<T201coordenador> t201CoordList;
    
    private T200docente t200NovoDocente;
    private T200docentePK t200PK;
    private T201coordenador t201NovoCoord;
    private T201coordenadorPK t201PK;
    private T400cursos t400NovoCurso;
    
    private T300ies t300IesNova;
    private T300ies t300IesSeld;

    @PostConstruct
    public void init() {
        this.em = JPAUtil.getEm();
        this.t400List = DAO.getFromNamedQuery(T400cursos.FIND_ALL, T400cursos.class, em);
        this.t300list = DAO.getFromNamedQuery(T300ies.FIND_ALL, T300ies.class, em);
        this.T901ConceitosList = DAO.getFromNamedQuery(T901conceitos.FIND_ALL, T901conceitos.class, em);
        this.t200DocenteList = DAO.getFromNamedQuery(T200docente.FIN_ALL, T200docente.class, em);
        this.t201CoordList = DAO.getFromNamedQuery(T201coordenador.FIN_ALL, T201coordenador.class, em);
        
        t300IesNova = new T300ies();
        t300IesSeld = new T300ies();
        t200NovoDocente = new T200docente();
        t400NovoCurso = new T400cursos();
    }
    
    public void onSelectIes(SelectEvent event){
        this.t400List = DAO.getFromNamedQuery(T400cursos.FIND_IES, T400cursos.class, em, t300IesSeld.getId());
    }

    public void insereNovaIes() {
        try {
            if (null != t300IesNova) {
                em.getTransaction().begin();
                DAO.save(t300IesNova, t300IesNova.getId(), em, Boolean.TRUE);
                em.getTransaction().commit();
                t300IesNova = new T300ies();
                JsfUtil.addSuccessMessage("Instituição inserida com sucesso!");
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível inserir IES!");
        }
    }
    

    public T300ies getT300IesNova() {
        return t300IesNova;
    }

    public void setT300IesNova(T300ies t300IesNova) {
        this.t300IesNova = t300IesNova;
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

    public List<T300ies> getT300list() {
        return t300list;
    }

    public void setT300list(List<T300ies> t300list) {
        this.t300list = t300list;
    }

//    public Integer getAbaAtiva() {
//        return abaAtiva;
//    }
//
//    public void setAbaAtiva(Integer AbaAtiva) {
//        this.abaAtiva = AbaAtiva;
//    }
//     public void tabChange(TabChangeEvent evt) {
//        TabView tabView = (TabView) evt.getTab().getParent();
//        abaAtiva = tabView.getActiveIndex();
//    }

    public List<T400cursos> getT400List() {
        return t400List;
    }

    public void setT400List(List<T400cursos> t400List) {
        this.t400List = t400List;
    }

    public T400cursos getT400NovoCurso() {
        return t400NovoCurso;
    }

    public void setT400NovoCurso(T400cursos t400NovoCurso) {
        this.t400NovoCurso = t400NovoCurso;
    }

    public T300ies getT300IesSeld() {
        return t300IesSeld;
    }

    public void setT300IesSeld(T300ies t300IesSeld) {
        this.t300IesSeld = t300IesSeld;
    }

    public List<T200docente> getT200DocenteList() {
        return t200DocenteList;
    }

    public void setT200DocenteList(List<T200docente> t200DocenteList) {
        this.t200DocenteList = t200DocenteList;
    }

    public List<T201coordenador> getT201CoordList() {
        return t201CoordList;
    }

    public void setT201CoordList(List<T201coordenador> t201CoordList) {
        this.t201CoordList = t201CoordList;
    }

    public T200docente getT200NovoDocente() {
        return t200NovoDocente;
    }

    public void setT200NovoDocente(T200docente t200NovoDocente) {
        this.t200NovoDocente = t200NovoDocente;
    }

    public T200docentePK getT200PK() {
        return t200PK;
    }

    public void setT200PK(T200docentePK t200PK) {
        this.t200PK = t200PK;
    }

    public T201coordenador getT201NovoCoord() {
        return t201NovoCoord;
    }

    public void setT201NovoCoord(T201coordenador t201NovoCoord) {
        this.t201NovoCoord = t201NovoCoord;
    }

    public T201coordenadorPK getT201PK() {
        return t201PK;
    }

    public void setT201PK(T201coordenadorPK t201PK) {
        this.t201PK = t201PK;
    }

}
