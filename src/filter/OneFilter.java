package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 2019/10/14 22:42.
 */
public class OneFilter implements Filter {

    public OneFilter() {
        System.out.println("*********  " + getClass().getSimpleName() + ".Constructor  *********");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("~~" + getClass().getSimpleName() + ".init~~");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("~~" + getClass().getSimpleName() + ".doFilter~~");

        System.out.println("before");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after");

    }

    @Override
    public void destroy() {
        System.out.println("~~" + getClass().getSimpleName() + ".destroy~~");

    }
}
