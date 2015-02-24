package br.com.saesdb.api.filter;

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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /* Verifica se a sessao esta registrada, caso nao redireciona para pagina de Login */
    @Override

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (response instanceof HttpServletResponse && request instanceof HttpServletRequest) {

            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            HttpSession httpSession = httpServletRequest.getSession();

            T900Usuario usuario = (T900Usuario) httpSession.getAttribute("usuario");

            if (usuario == null) {
                if (!httpServletRequest.getRequestURI().endsWith("login.xhtml")) {
                    String location = httpServletRequest.getContextPath() + "/login.xhtml";
                    httpServletResponse.sendRedirect(location);
                    return;
                }
            }
            if (usuario != null) {
                if (!httpServletRequest.getRequestURI().endsWith("index.xhtml") && !httpServletRequest.getRequestURI().endsWith("logout.xhtml")) {
                    String location = httpServletRequest.getContextPath() + "/index.xhtml";
                    httpServletResponse.sendRedirect(location);
                    return;
                }
            }
            try {
                chain.doFilter(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void destroy() {

    }

}
