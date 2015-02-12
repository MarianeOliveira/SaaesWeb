package br.com.saesdb.api.filter;


import br.com.saaes.jsf.mb.login;
import br.com.saaes.modelo.T900Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FiltroSeguranca implements Filter {
    HttpSession session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    /* Verifica se a sessao esta registrada, caso nao redireciona para pagina de login */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession = httpServletRequest.getSession();
        
        T900Usuario usuario = (T900Usuario) httpSession.getAttribute( login.USUARIO );
        
        if ( null == usuario ){
            redirecionaParaLogin(httpServletRequest, httpServletResponse);
            return;
        }
        
        chain.doFilter(request, response);
    }

    private void redirecionaParaLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        if ( !httpServletRequest.getRequestURI().endsWith("login.xhtml") ) {
            String location = httpServletRequest.getContextPath() + "/login.xhtml";
            httpServletResponse.sendRedirect( location );
        }
    }
    
    @Override
    public void destroy() {
        
    }

}
