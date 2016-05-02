package org.docksidestage.app.ws;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chichi1091 on 2016/05/02.
 */
@ServerEndpoint("/wschat")
public class WsChatAction {
    static Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(String message) {
        for(Session s : sessions){
            s.getAsyncRemote().sendText(message);
        }
    }

    @OnOpen
    public void open(Session sess){
        sessions.add(sess);
    }
    @OnClose
    public void close(Session sess){
        sessions.remove(sess);
    }
}
