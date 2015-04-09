package br.com.saaes.app.util;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.Cookie;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;

/**
 *
 * @author
 */
public class TabViewMB implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Tempo máximo em que a aba fica selecionada como padrão
     */
    public static final Long MAX_AGE = TimeUnit.SECONDS.convert(2, TimeUnit.MINUTES);

    private static Integer TEMPO_ABA;

    private String cookieId;
    private Integer activeIndex = 0;

    private Cookie cookie;


    @PostConstruct
    public void startTab() {
        if (TEMPO_ABA == null) {
            TEMPO_ABA = MAX_AGE > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.valueOf((MAX_AGE.toString()));
        }
        Cookie[] cookies = JsfUtil.getCurrentHttpServletRequest().getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equalsIgnoreCase(getCookieId())) {
                cookie = c;
                activeIndex = Integer.valueOf(c.getValue());
                break;
            }
        }
    }

    //Registra a tab da pagina cadastro no cookie e quando abrir ou atualizar, volta p mesma
    public void onTabChange(TabChangeEvent evt) {
        TabView tabView = (TabView) evt.getTab().getParent();
        activeIndex = tabView.getActiveIndex();
        cookie = new Cookie(getCookieId(), activeIndex.toString());
        cookie.setDomain("http://localhost:8080/");
        cookie.setPath("/saaes");
        cookie.setMaxAge(TEMPO_ABA); //
        cookie.setSecure(false);
        JsfUtil.getCurrentHttpServletResponse().addCookie(cookie);
    }

    @PreDestroy
    public void endTab() {
        cookie.setMaxAge(5);
        JsfUtil.getCurrentHttpServletResponse().addCookie(cookie);
    }

    /* GETTERS AND SETTERS */
    public Cookie getCookie() {
        return cookie;
    }

    public String getCookieId() {
        if (cookieId == null) {
            cookieId = "tabView_ativa";
        }
        return cookieId;
    }

    public Integer getActiveIndex() {
        if ( activeIndex == null ){
            activeIndex = 0;
        }
        return activeIndex;
    }

    public void setActiveIndex(Integer activeIndex) {
        this.activeIndex = activeIndex;
    }
}
