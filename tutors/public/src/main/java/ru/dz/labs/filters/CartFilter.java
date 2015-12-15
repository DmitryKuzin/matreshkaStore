package ru.dz.labs.filters;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dz.labs.api.service.CartService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//import ru.dz.labs.api.service.TutorService;

/**
 * Created by kuzin on 09.12.2015.
 */
public class CartFilter implements Filter {
    boolean firstTime;
    boolean active=false;
    CartService cartService=null;
    private void initFilter(){
        if(cartService==null){
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("tutor-core.xml");
            cartService= (CartService) applicationContext.getBean("cartService");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        firstTime=true;
        String s=filterConfig.getInitParameter("Active");
        if(s!=null)
            active=s.toLowerCase().equals("true");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        initFilter();
        if(firstTime) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            Cookie[] cookies = request.getCookies();
            String cookieValue = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cart")) {
                        cookieValue = cookie.getValue();
                    }
                }
            }
            request.getSession().setAttribute("sessionCart", cookieValue);
            String attr= (String) request.getSession().getAttribute("test");
            if(attr!=null){
                request.getSession().setAttribute("test",attr+"!");
            }else {
                request.getSession().setAttribute("test", "cherepakha");
                request.getSession().setAttribute("carts",cartService.getAllCarts());
            }
            firstTime=false;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
