/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifraturesemplici;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.Instant;
/**
 *
 * @author ema05
 */
public class InterfacciaMenu extends JFrame implements ActionListener {
  
   JPanel p;
   JButton server,client,esci;
   ButtonGroup gruppoBottoni;
   JLabel etichettaContatore;
   JTextField indirizzoServer,indirizzoClient;
   String indirizzoS;
   ServerSocket ss;
   public Socket s;

   public InterfacciaMenu(){
       
         super("Interfaccia Menu");
         p = new JPanel();
         server = new JButton("Collegati come Secret Inbox");
         client = new JButton("Collegati al Secret Inbox");
         indirizzoServer = new JTextField();
         indirizzoServer.setPreferredSize(new Dimension(100,20));
         indirizzoClient = new JTextField();
         indirizzoClient.setPreferredSize(new Dimension(100,20));
         esci = new JButton("Esci");
         gruppoBottoni = new ButtonGroup();
         etichettaContatore = new JLabel("Contatore");
         indirizzoServer = new JTextField(10);
         gruppoBottoni.add(esci);
         gruppoBottoni.add(server);
         gruppoBottoni.add(client);
         p = (JPanel) this.getContentPane();
         p.setLayout(new FlowLayout());
         p.add(server);
         p.add(indirizzoServer);
         p.add(client);
         p.add(indirizzoClient);
         p.add(esci);
         server.addActionListener(this);
         client.addActionListener(this);
         esci.addActionListener(this);
         try{
         indirizzoS = InetAddress.getLocalHost().getHostAddress();
         indirizzoServer.setText(indirizzoS);
         indirizzoServer.setEditable(false);
         }catch(Exception ex){}
         p.setBackground(Color.blue);
         this.setBounds(100, 100, 800, 100);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        int valIncremento,valDecremento;
        InetAddress ip = null;
        String indirizzoServer;
        
        //incremento contatore
        if (esci == e.getSource()){
           dispose();
        }
        //decremento contatore
	if (client == e.getSource()) {
            
            uniscitiInbox();
	}
        if(server == e.getSource()){
           
            ospitaMessaggi();
            
        }
	
     
    }
    
    
    
    
    public void ospitaMessaggi(){
        try {
            
            ss = new ServerSocket(50002);
            ss.setSoTimeout(30000);
            s = ss.accept();
         /*   
           PrintWriter outServer = new PrintWriter(s.getOutputStream(), true);
            String msg = "ok:";
            outServer.println(msg);*/
            
            new InterfacciaSecretI(this);
          
            
        }catch(SocketTimeoutException te){
            JOptionPane.showMessageDialog(null,"Connessione fallita");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
     public void uniscitiInbox(){
         try {
            s = new Socket(indirizzoClient.getText(), 50002);
            /*PrintWriter outServer = new PrintWriter(s.getOutputStream(), true);
            String clienMsg = "Ok:";
            outServer.println(clienMsg);*/
            
            new InterfacciaSecretS(this);

         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
        
        
    }
     
     
     
     
}
