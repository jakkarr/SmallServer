package server;


import basis.Server;

public class ChatServer extends Server {

    final String ENDE = "*bye*";

    public ChatServer() {
      super(2000);
    }

    public void processNewConnection(String pClientIP, int pClientPort) {
      this.send(pClientIP, pClientPort, "Willkommen " + pClientIP + " auf Port "
        + pClientPort + " bei unserem chat!");
      this.sendToAll(pClientIP + " " + pClientPort + " hat sich angemeldet.");
    }

    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
      if (pMessage.equals(ENDE))
        this.closeConnection(pClientIP, pClientPort);
      else
        this.sendToAll(pClientIP + " " + pClientPort + ": " + pMessage);
    }
    
    public void processClosedConnection(String pClientIP, int pClientPort) {
      this.send(pClientIP, pClientPort, pClientIP + " " + pClientPort +
      " Danke fuer die Teilnahme an unserem Chat.");
      this.sendToAll(pClientIP + " " + pClientPort + " hat sich abgemeldet.");
      this.send(pClientIP, pClientPort, ENDE);
    }
}
