package client;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 13.06.2006
  * @author
  */
public class CClient extends JFrame {
  // Anfang Variablen

  // Anfang Attribute
  final String ENDE="*bye*";
  private ChatClient hatChatClient;
  private JLabel jLabel1 = new JLabel();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JButton jButton2 = new JButton();
  private JScrollPane jScrollPanejTextArea1 = new JScrollPane();
  private JTextArea jTextArea1 = new JTextArea("");
  private JLabel jLabel2 = new JLabel();
  private JTextField jTextField2 = new JTextField();
  private JButton jButton3 = new JButton();
  // Ende Attribute

  // Ende Variablen

  public CClient(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { System.exit(0); }
    });
    int frameWidth = 514;
    int frameHeight = 373;
    setSize(frameWidth, frameHeight);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    jLabel1.setBounds(16, 16, 40, 16);
    jLabel1.setText("Server");
    jLabel1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    cp.add(jLabel1);
    jTextField1.setBounds(64, 16, 121, 24);
    jTextField1.setText("");
    cp.add(jTextField1);
    jButton1.setBounds(200, 16, 110, 24);
    jButton1.setText("Anmelden");
    cp.add(jButton1);
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setBounds(328, 16, 110, 24);
    jButton2.setText("Beenden");
    cp.add(jButton2);
    jButton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jScrollPanejTextArea1.setBounds(8, 48, 438, 241);
    jTextArea1.setText("");
    jScrollPanejTextArea1.setViewportView(jTextArea1);
    cp.add(jScrollPanejTextArea1);
    jLabel2.setBounds(8, 304, 56, 16);
    jLabel2.setText("Nachricht");
    jLabel2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    cp.add(jLabel2);
    jTextField2.setBounds(72, 304, 249, 24);
    jTextField2.setText("");
    cp.add(jTextField2);
    jButton3.setBounds(328, 304, 110, 25);
    jButton3.setText("Abschicken");
    cp.add(jButton3);

    jButton3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    // Ende Komponenten

    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden

  // Anfang Ereignisprozeduren
  public void jButton1ActionPerformed(ActionEvent evt) {
    String lServerIP=jTextField1.getText();
    if (lServerIP.length()>0) {
       hatChatClient=new ChatClient(lServerIP, jTextArea1);
    }
  }

  public void jButton2ActionPerformed(ActionEvent evt) {
     hatChatClient.close();
  }

  public void jButton3ActionPerformed(ActionEvent evt) {
    String lNachricht=jTextField2.getText();
    if (lNachricht.length()>0) {
      hatChatClient.send(lNachricht);
    }
  }

  // Ende Ereignisprozeduren

  public static void main(String[] args) {
    new CClient("CClient");
  }
  // Ende Methoden
}

