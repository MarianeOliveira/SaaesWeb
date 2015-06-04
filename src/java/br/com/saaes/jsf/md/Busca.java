package br.com.saaes.jsf.md;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.app.util.TabViewMB;
import br.com.saaes.dao.DAO;
import br.com.saaes.facade.FacUtil;
import br.com.saaes.modelo.T200ies;
import br.com.saaes.modelo.T300cursos;
import br.com.saaes.modelo.T400docente;
import br.com.saaes.modelo.T500coordenador;
import br.com.saaes.modelo.T600bibliografia;
import br.com.saaes.modelo.T700avaliacao;
import br.com.saaes.modelo.T900Usuario;
import br.com.saaes.util.JPAUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name = "busca")
@ViewScoped
public class Busca extends TabViewMB implements Serializable {

    EntityManager em;
    private T900Usuario usuario = (T900Usuario) FacUtil.getSession().getAttribute("usuario");

    private Integer abaAtiva = 0;
    private List<T200ies> t200list;
    private List<T300cursos> t300List;
    private List<T300cursos> t300ListSelds;
    private List<T400docente> t400DocenteList;
    private List<T600bibliografia> t600BibliList;
    private List<T700avaliacao> t700Avaliacaolist;

    private T200ies t200IesSeld;
    private T300cursos t300CursoSeld;
    private T300cursos t300Curso;
    private T400docente t400DocenteSeld;
    private T700avaliacao t700AvaliacaoSeld;
    private T500coordenador t500CoordenadoCurso;
    private List<T400docente> t400DocentesCurso;

    private T700avaliacao t700NovaAvaliacao;

    @PostConstruct
    public void init() {
        this.em = JPAUtil.getEm();
        this.t300List = DAO.getFromNamedQuery(T300cursos.FIND_ALL, T300cursos.class, em);
        this.t200list = DAO.getFromNamedQuery(T200ies.FIND_ALL, T200ies.class, em);
        //this.t700Avaliacaolist = DAO.getFromNamedQuery(T700avaliacao.FIND_ALL, T700avaliacao.class, em);

        t200IesSeld = new T200ies();
        t300Curso = new T300cursos();
        t700NovaAvaliacao = new T700avaliacao();
        t700Avaliacaolist = new ArrayList<>();
        t400DocenteList = new ArrayList<>();
    }

    /**
     * Seleciona IES
     *
     * @param event
     */
    public void onSelectIes() {
        this.t300ListSelds = DAO.getFromNamedQuery(T300cursos.FIND_IES, T300cursos.class, em, t200IesSeld);
        this.t400DocenteList = DAO.getFromNamedQuery(T400docente.FIND_IES, T400docente.class, em, t200IesSeld);
        this.t700Avaliacaolist = DAO.getFromNamedQuery(T700avaliacao.FIND_BY_T200, T700avaliacao.class, em, t200IesSeld);
    }

    /**
     * Seleciona Avaliacao
     *
     * @param event
     */
    public void onSelectAvaliacao() {
            this.t700Avaliacaolist = DAO.getFromNamedQuery(T700avaliacao.FIND_BY_T300, T700avaliacao.class, em, t300Curso);
            this.t300ListSelds = DAO.getFromNamedQuery(T300cursos.FIND_ID, T300cursos.class, em, t300Curso.getId());
    }
    
    public void selectT400Docente(SelectEvent event){
        t400DocenteSeld = (T400docente) event.getObject();
        t300CursoSeld = null;
        t700AvaliacaoSeld = null;
    }
    
    public void selectT700Avaliacao(SelectEvent event){
        t700AvaliacaoSeld = (T700avaliacao) event.getObject();
        t300CursoSeld = null;
        t400DocenteSeld = null;
    }
    
    public void selectT300Curso(SelectEvent event){
        t300CursoSeld = (T300cursos) event.getObject();
        t400DocenteSeld = null;
        t700AvaliacaoSeld = null;
    }

    /**
     * Insere novo Coordenador
     */
    public void realizarAvaliacao() {
        try {
            if (null != t700NovaAvaliacao) {
                em.getTransaction().begin();

                DAO.save(t700NovaAvaliacao, t700NovaAvaliacao.getT700avaliacaoPK(), em, Boolean.TRUE);
                em.getTransaction().commit();

                this.t700Avaliacaolist.add(t700NovaAvaliacao);
                t700NovaAvaliacao = new T700avaliacao();
                JsfUtil.addSuccessMessage("Coordenandor inserido com sucesso!");

            } else {
                JsfUtil.addAlertMessage("Informe um Nome para cadastrar");
            }
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Não foi possível inserir novo Coordenador!");
        }
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

    public List<T700avaliacao> getT700Avaliacaolist() {
        return t700Avaliacaolist;
    }

    public void setT700Avaliacaolist(List<T700avaliacao> t700Avaliacaolist) {
        this.t700Avaliacaolist = t700Avaliacaolist;
    }

    public T700avaliacao getT700NovaAvaliacao() {
        return t700NovaAvaliacao;
    }

    public void setT700NovaAvaliacao(T700avaliacao t700NovaAvaliacao) {
        this.t700NovaAvaliacao = t700NovaAvaliacao;
    }

    public List<T300cursos> getT300ListSelds() {
        return t300ListSelds;
    }

    public void setT300ListSelds(List<T300cursos> t300ListSelds) {
        this.t300ListSelds = t300ListSelds;
    }

    public List<T400docente> getT400DocentesCurso() {
        return t400DocentesCurso;
    }

    public void setT400DocentesCurso(List<T400docente> t400DocentesCurso) {
        this.t400DocentesCurso = t400DocentesCurso;
    }

    public T500coordenador getT500CoordenadoCurso() {
        return t500CoordenadoCurso;
    }

    public void setT500CoordenadoCurso(T500coordenador t500CoordenadoCurso) {
        this.t500CoordenadoCurso = t500CoordenadoCurso;
    }

    public List<T400docente> getT400DocenteList() {
        return t400DocenteList;
    }

    public void setT400DocenteList(List<T400docente> t400DocenteList) {
        this.t400DocenteList = t400DocenteList;
    }

    public T400docente getT400DocenteSeld() {
        return t400DocenteSeld;
    }

    public void setT400DocenteSeld(T400docente t400DocenteSeld) {
        this.t400DocenteSeld = t400DocenteSeld;
    }

    public T300cursos getT300Curso() {
        return t300Curso;
    }

    public void setT300Curso(T300cursos t300Curso) {
        this.t300Curso = t300Curso;
    }

    public T700avaliacao getT700AvaliacaoSeld() {
        return t700AvaliacaoSeld;
    }

    public void setT700AvaliacaoSeld(T700avaliacao t700AvaliacaoSeld) {
        this.t700AvaliacaoSeld = t700AvaliacaoSeld;
    }

}
