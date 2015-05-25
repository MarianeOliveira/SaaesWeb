package br.com.saaes.api.filter;

import br.com.saaes.util.JPAUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "filterJPA")
public class FiltroJPA implements  Filter{

    public static final String EM = "em";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
     
        try {
            request.setAttribute(EM, JPAUtil.getEm());
            chain.doFilter(request, response);
        } catch (Throwable throwable) {
        }
    }

    @Override
    public void destroy() {
       
    }

    
    
}
