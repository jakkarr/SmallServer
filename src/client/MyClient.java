package client;

import javax.swing.*;

public class MyClient extends ChatClient {
    public MyClient(String serverIP, JTextArea pTextbereich) {
            super(serverIP, pTextbereich);
    }

    @Override
    public void processMessage(String pMessage) {
        String[] response = pMessage.split(" ");
        switch(response[0]){
            case "reqestname":
                JOptionPane.showInputDialog("Username bitte");
                break;
                default:
                    super.processMessage(pMessage);
        }

    }
}
