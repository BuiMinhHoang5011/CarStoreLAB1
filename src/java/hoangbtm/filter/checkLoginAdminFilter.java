/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoangbtm.filter;

import hoangbtm.dto.AccountDTO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hoang
 */
@WebFilter(filterName = "checkLoginAdminFilter", urlPatterns = {"/admin-home","/list-car","/add-new-car","/delete-car","/update-car","/add-new-category","/add-new-discount"})
public class checkLoginAdminFilter implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public checkLoginAdminFilter() {
    }    
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        AccountDTO account = (AccountDTO) session.getAttribute("account");
        if(account != null){
            if(account.getRoll_id() == 2
                    ){ // da login
                chain.doFilter(request, response);
            }else{
                res.sendRedirect("error-page");
            }
        }else{
            res.sendRedirect("login");
        }
        
        
    }


    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
    }


    @Override
    public void init(FilterConfig filterConfig) {        
    }

    /**
     * Return a String representation of this object.
     */
   
}
