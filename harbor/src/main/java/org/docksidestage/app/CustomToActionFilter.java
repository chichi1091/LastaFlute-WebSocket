package org.docksidestage.app;

import org.lastaflute.web.servlet.filter.LastaToActionFilter;
import org.lastaflute.web.servlet.filter.RequestRoutingFilter;
import org.lastaflute.web.servlet.filter.hook.FilterHook;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Deque;

/**
 * Created by chichi1091 on 2016/05/02.
 */
public class CustomToActionFilter extends LastaToActionFilter {
    protected RequestRoutingFilter createRequestRoutingFilter() {
        return new CustomRoutingFilter();
    }

    protected void viaInsideHookDeque(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Deque<FilterHook> deque)
            throws IOException, ServletException {

        viaEmbeddedFilter(request, response, chain);
    }
}
