package org.esupportail.tomcat;

import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.Manager;
import org.apache.catalina.Session;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;


public final class ChangeSessionIdValve extends ValveBase {
    protected String loginPath = null;

    public void setLoginPath(String loginPath) {
	this.loginPath = loginPath;
    }

    public void invoke(Request request, Response response) throws
	IOException, ServletException {
	Session session = request.getSessionInternal(true);
	String requestURI = request.getDecodedRequestURI();

	if (session != null && loginPath != null &&
	    requestURI.equals(loginPath)) {
	    Manager manager = request.getContext().getManager();
	    manager.changeSessionId(session);
	    request.changeSessionId(session.getId());
	}
	getNext().invoke(request, response);
    }
}
