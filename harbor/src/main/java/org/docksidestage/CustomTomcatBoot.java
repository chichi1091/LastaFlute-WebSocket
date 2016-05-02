package org.docksidestage;

import org.apache.catalina.Globals;
import org.apache.catalina.Context;
import org.dbflute.tomcat.TomcatBoot;

import javax.servlet.ServletException;
import java.io.File;


/**
 * Created by chichi1091 on 2016/05/02.
 */
public class CustomTomcatBoot extends TomcatBoot {
    public CustomTomcatBoot(int port, String contextPath) {
        super(port, contextPath);
    }

    @Override
    protected void setupWebappContext() {
        try {
            final String warPath = prepareWarPath();
            if (warPath.endsWith(".war")) {
                server.addWebapp(contextPath, warPath);
                if (!isUnpackWARsDisabled()) {
                    prepareUnpackWARsEnv();
                }
            } else {
                final String webappPath = prepareWebappPath();
                final String docBase = new File(webappPath).getAbsolutePath();
                final Context context = server.addWebapp(contextPath, docBase);
                context.addApplicationListener(WebSocketConfig.class.getName());
                final String webXmlPath = prepareWebXmlPath(webappPath);
                context.getServletContext().setAttribute(Globals.ALT_DD_ATTR, webXmlPath);
            }
        } catch (ServletException e) {
            throw new IllegalStateException("Failed to set up web context.", e);
        }
    }

}
