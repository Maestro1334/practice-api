package nl.inholland.practiceapi.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(2)
public class LargeRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        int size = servletRequest.getContentLength();
        if (size > 50) {
            throw new ServletException(String.format("Request of size %d was too large to handle and has been rejected", size));
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
