package br.com.saaes.jsf.md;

import br.com.saaes.app.util.JsfUtil;
import br.com.saaes.dao.DAO;
import br.com.saaes.modelo.T700avaliacao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "relatorio")
@ViewScoped
public class Relatorio {
    private List<T700avaliacao> t700Avaliacaolist;
    @PostConstruct
    public void init() {
         this.t700Avaliacaolist = DAO.getFromNamedQuery(T700avaliacao.FIND_ALL, T700avaliacao.class, JsfUtil.getEm());
    }

    public List<T700avaliacao> getT700Avaliacaolist() {
        return t700Avaliacaolist;
    }

    public void setT700Avaliacaolist(List<T700avaliacao> t700Avaliacaolist) {
        this.t700Avaliacaolist = t700Avaliacaolist;
    }
}
