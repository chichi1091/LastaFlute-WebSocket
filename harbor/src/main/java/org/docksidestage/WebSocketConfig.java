package org.docksidestage;

import org.apache.tomcat.websocket.server.Constants;
import org.apache.tomcat.websocket.server.WsContextListener;
import org.docksidestage.app.ws.WsChatAction;

import javax.servlet.ServletContextEvent;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;

/**
 * Created by chichi1091 on 2016/05/02.
 */
public class WebSocketConfig extends WsContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        ServerContainer sc =
                (ServerContainer) sce.getServletContext().getAttribute(
                        Constants.SERVER_CONTAINER_SERVLET_CONTEXT_ATTRIBUTE);
        try {
            sc.addEndpoint(WsChatAction.class);
        } catch (DeploymentException e) {
            throw new IllegalStateException(e);
        }
    }
}
