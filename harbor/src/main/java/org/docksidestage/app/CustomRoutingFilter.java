package org.docksidestage.app;

import org.lastaflute.web.servlet.filter.RequestRoutingFilter;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chichi1091 on 2016/05/02.
 */
public class CustomRoutingFilter extends RequestRoutingFilter {
    @Override
    protected boolean isExtensionUrlPossible(HttpServletRequest request, String requestPath) {
        String upgrade = request.getHeader("Upgrade");
        if("websocket".equals(upgrade)) return true;
        return super.isExtensionUrlPossible(request, requestPath);
    }
}
