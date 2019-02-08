package server;

import basis.Server;

import java.util.HashMap;
import java.util.Map;

public class MyServer extends Server {
    private Map<String, String> usernames;


    public MyServer() {
        super(2000);
        usernames = new HashMap<>();
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        send(pClientIP,pClientPort, "requestname");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        sendToAll(pClientIP+":"+pClientPort+"> "+pMessage);
    }

    @Override
    public void processClosedConnection(String pClientIP, int pClientPort) {
        sendToAll("DER HUANSOHN RENNT WEG");
    }
}
