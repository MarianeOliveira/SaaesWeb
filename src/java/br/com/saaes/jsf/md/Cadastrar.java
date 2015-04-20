package br.com.saaes.jsf.md;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.app.util.TabViewMB;
import br.com.saaes.dao.DAO;
import br.com.saaes.facade.FacUtil;
import br.com.saaes.modelo.T200ies;
import br.com.saaes.modelo.T300cursos;
import br.com.saaes.modelo.T400docente;
import br.com.saaes.modelo.T400docentePK;
import br.com.saaes.modelo.T500coordenador;
import br.com.saaes.modelo.T500coordenadorPK;
import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.modelo.T901conceitos;
import br.com.saaes.modelo.T600bibliografia;
import br.com.saaes.util.JPAUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author
 */
@ManagedBean(name = "cadastrar")
@ViewScoped
public class Cadastrar extends TabViewMB implements Serializable {

    EntityManager em;
    private T900Usuario usuario = (T900Usuario) FacUtil.getSession().getAttribute("usuario");

    private Integer abaAtiva = 0;
    private List<T901conceitos> T901ConceitosList;
    private List<T300cursos> t300List;
    private List<T200ies> t200list;
    private List<T400docente> t400DocenteList;
    private List<T500coordenador> t500CoordList;
    private List<T600bibliografia> t600BibliList;

    private T200ies t200IesNova;
    private T300cursos t300NovoCurso;
    private T400docente t400NovoDocente;
    private T500coordenador t500NovoCoord;
    private T600bibliografia t600NovaBibliografia;

    private T300cursos t300CursoSeld;
    private T200ies t200IesSeld;

    @PostConstruct
    public void init() {
        this.em = JPAUtil.getEm();
        this.t300List = DAO.getFromNamedQuery(T300cursos.FIND_ALL, T300cursos.class, em);
        this.t200list = DAO.getFromNamedQuery(T200ies.FIND_ALL, T200ies.class, em);
        this.T901ConceitosList = DAO.getFromNamedQuery(T901conceitos.FIND_ALL, T901conceitos.class, em);
        this.t400DocenteList = DAO.getFromNamedQuery(T400docente.FIN_ALL, T400docente.class, em);
        this.t500CoordList = DAO.getFromNamedQuery(T500coordenador.FIN_ALL, T500coordenador.class, em);

        t200IesSeld = new T200ies();
        t300CursoSeld = new T300cursos();
        t200IesNova = new T200ies();
        t400NovoDocente = new T400docente();
        t300NovoCurso = new T300cursos();
    }

    /**
     * Seleciona IES
     *
     * @param event
     */
    public void onSelectIes(SelectEvent event) {
        this.t300List = DAO.getFromNamedQuery(T300cursos.FIND_IES, T300cursos.class, em, t200IesSeld.getId());
    }

    /**
     * Cadastra nova instituição
     */
    public void insereNovaIes() {
        try {
            if ( null != t200IesNova
                 && (!t200IesNova.getNome().equals("") && null != t200IesNova.getNome())
                 && (!t200IesNova.getCampus().equals("") && null != t200IesNova.getCampus()) ) {
                em.getTransaction().begin();
                
                t200IesNova.setT900Usuario(usuario);
                DAO.save(t200IesNova, t200IesNova.getId(), em, Boolean.TRUE);
                
                em.getTransaction().commit();
                
                this.t200list.add(t200IesNova);
                t200IesNova = new T200ies();
                JsfUtil.addSuccessMessage("Instituição inserida com sucesso!");

            } else {
                JsfUtil.addAlertMessage("Informe o Nome e o Campus para cadastrar");
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível inserir IES!");
        }
    }

    /**
     * Insere novo curso
     */
    public void insereNovoCurso() {
        try {
            if ( null != t300NovoCurso 
                 && (!t300NovoCurso.getNome().equals("") && null != t300NovoCurso.getNome()) ) {

                em.getTransaction().begin();
                t300NovoCurso.setT900Usuario(usuario);
                DAO.save(t300NovoCurso, t300NovoCurso.getId(), em, Boolean.TRUE);
                em.getTransaction().commit();
                t300NovoCurso = new T300cursos();
                JsfUtil.addSuccessMessage("Novo curso inserido com sucesso!");

                this.t300List = DAO.getFromNamedQuery(T300cursos.FIND_ALL, T300cursos.class, em);
            } else {
                JsfUtil.addAlertMessage("Informe o Nome e o Campus para cadastrar");
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível inserir novo curso!");
        }
    }

    /**
     * Insere novo Docente
     */
    public void insereNovoDocente() {
        try {
            if ( null != t400NovoDocente
                 && ( !t400NovoDocente.getNome().equals("") && null != t400NovoDocente.getNome() ) ) {
                em.getTransaction().begin();
                t400NovoDocente.setT900Usuario(usuario);
                T400docentePK t400pk = new T400docentePK();
                t400NovoDocente.setT400docentePK(t400pk);
                DAO.save(t400NovoDocente, t400NovoDocente.getT400docentePK(), em, Boolean.TRUE);
                em.getTransaction().commit();
                t400NovoDocente = new T400docente();
                JsfUtil.addSuccessMessage("Docente inserido com sucesso!");

                this.t400DocenteList = DAO.getFromNamedQuery(T400docente.FIN_ALL, T400docente.class, em);
            } else {
                JsfUtil.addAlertMessage("Informe um Nome para cadastrar");
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível inserir novo docente!");
        }
    }

    /**
     * Insere novo Coordenador
     */
    public void insereNovoCoordenador() {
        try {
             if ( null != t500NovoCoord 
                  && ( !t500NovoCoord.getNome().equals("") && null != t500NovoCoord.getNome() ) ) {
                em.getTransaction().begin();
                t500NovoCoord.setT900Usuario(usuario);
                T500coordenadorPK t500pk = new T500coordenadorPK();
                t500pk.setIdCurso(t300CursoSeld.getId());
                t500NovoCoord.setT500coordenadorPK(t500pk);
                DAO.save(t500NovoCoord, t500NovoCoord.getT500coordenadorPK(), em, Boolean.TRUE);
                em.getTransaction().commit();
                t500NovoCoord = new T500coordenador();
                JsfUtil.addSuccessMessage("Coordenandor inserido com sucesso!");

                this.t500CoordList.add(t500NovoCoord);

//                this.t500CoordList = DAO.getFromNamedQuery(T500coordenador.FIN_ALL, T500coordenador.class, em);
            } else {
                JsfUtil.addAlertMessage("Informe um Nome para cadastrar");
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível inserir novo Coordenador!");
        }
    }

    public void tabChange(TabChangeEvent evt) {
        TabView tabView = (TabView) evt.getTab().getParent();
        abaAtiva = tabView.getActiveIndex();
        t200IesSeld = new T200ies();
        t300CursoSeld = new T300cursos();
        t200IesNova = new T200ies();
        t400NovoDocente = new T400docente();
        t300NovoCurso = new T300cursos();
    }

    public T200ies getT200IesNova() {
        return t200IesNova;
    }

    public void setT200IesNova(T200ies t200IesNova) {
        this.t200IesNova = t200IesNova;
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

    public List<T200ies> getT200list() {
        return t200list;
    }

    public void setT200list(List<T200ies> t200list) {
        this.t200list = t200list;
    }

    public Integer getAbaAtiva() {
        return abaAtiva;
    }

    public void setAbaAtiva(Integer AbaAtiva) {
        this.abaAtiva = AbaAtiva;
    }

    public List<T300cursos> getT300List() {
        return t300List;
    }

    public void setT300List(List<T300cursos> t300List) {
        this.t300List = t300List;
    }

    public T200ies getT200IesSeld() {
        return t200IesSeld;
    }

    public void setT200IesSeld(T200ies t200IesSeld) {
        this.t200IesSeld = t200IesSeld;
    }

    public T900Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(T900Usuario usuario) {
        this.usuario = usuario;
    }

    public List<T400docente> getT400DocenteList() {
        return t400DocenteList;
    }

    public void setT400DocenteList(List<T400docente> t400DocenteList) {
        this.t400DocenteList = t400DocenteList;
    }

    public List<T500coordenador> getT500CoordList() {
        return t500CoordList;
    }

    public void setT500CoordList(List<T500coordenador> t500CoordList) {
        this.t500CoordList = t500CoordList;
    }

    public T400docente getT400NovoDocente() {
        return t400NovoDocente;
    }

    public void setT400NovoDocente(T400docente t400NovoDocente) {
        this.t400NovoDocente = t400NovoDocente;
    }

    public T500coordenador getT500NovoCoord() {
        return t500NovoCoord;
    }

    public void setT500NovoCoord(T500coordenador t500NovoCoord) {
        this.t500NovoCoord = t500NovoCoord;
    }

    public T300cursos getT300NovoCurso() {
        return t300NovoCurso;
    }

    public void setT300NovoCurso(T300cursos t300NovoCurso) {
        this.t300NovoCurso = t300NovoCurso;
    }

    public T300cursos getT300CursoSeld() {
        return t300CursoSeld;
    }

    public void setT300CursoSeld(T300cursos t300CursoSeld) {
        this.t300CursoSeld = t300CursoSeld;
    }

    public List<T600bibliografia> getT600BibliList() {
        return t600BibliList;
    }

    public void setT600BibliList(List<T600bibliografia> t600BibliList) {
        this.t600BibliList = t600BibliList;
    }

    public T600bibliografia getT600NovaBibliografia() {
        return t600NovaBibliografia;
    }

    public void setT600NovaBibliografia(T600bibliografia t600NovaBibliografia) {
        this.t600NovaBibliografia = t600NovaBibliografia;
    }

}
