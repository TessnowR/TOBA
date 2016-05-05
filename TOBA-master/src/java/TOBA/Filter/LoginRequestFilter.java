/*
    Filter that logs all requests to the LoginServlet
 */
package TOBA.Filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginRequestFilter implements Filter {
    
    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        ServletContext sc = filterConfig.getServletContext();
        
       
        String logString = filterConfig.getFilterName() + " | ";
        logString += "Servlet path: " + httpRequest.getServletPath() + " | ";
        
        
        
        
        sc.log(logString);
        
        chain.doFilter(httpRequest, response);
        
    }
    
    @Override
    public void destroy() {
        filterConfig = null;
    }
}
