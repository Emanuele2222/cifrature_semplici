/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifraturesemplici;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ema05
 */
public class InterfacciaSecretI extends JFrame implements ActionListener{
    
     JPanel p;
    JButton decripta, esci;
    JComboBox messaggiRicevuti;
    ButtonGroup gruppoBottoni;
    ButtonGroup gruppo1;
    JLabel testoLable,chiaveLable,nomeAgenteLable,criptatiLable;
    JTextField  nomeAgente, chiave;
    JTextArea testoMess;
    JRadioButton cesare;
    JRadioButton vigenere;
    JRadioButton cesareBf;
    String indirizzoS;
    ServerSocket ss;
    public Socket s;
    AscoltaMessaggi threadAscoltaMessaggi;
    private InterfacciaMenu interfaccia;
    JScrollPane scroll;

    public InterfacciaSecretI(InterfacciaMenu interfaccia) {
        
        super("Interfaccia SecretI");
        this.interfaccia = interfaccia;
        p = new JPanel();
        
        //p = (JPanel) this.getContentPane();
        p.setLayout(null);
        criptatiLable = new JLabel("Messaggi criptati:");
        criptatiLable.setForeground(Color.white);
        criptatiLable.setBounds(10, 20, 300, 70);
        messaggiRicevuti = new JComboBox();
        messaggiRicevuti.setBounds(120, 20, 300, 70);
        threadAscoltaMessaggi = new AscoltaMessaggi(this, interfaccia);
        System.out.println("partito il thread");
        threadAscoltaMessaggi.start();
        cesare = new JRadioButton("Cesare");
        cesare.setBounds(60, 230, 70, 20);
        cesare.setSelected(true);
        vigenere = new JRadioButton("Vigenere");
        vigenere.setBounds(150, 230, 80, 20);
        cesareBf = new JRadioButton("Brute force Cesare");
        cesareBf.setBounds(250, 230, 140, 20);
        testoLable = new JLabel("Messaggio decriptato:");
        testoLable.setForeground(Color.white);
        testoLable.setBounds(10, 100, 130, 20);
        testoMess = new JTextArea();
        testoMess.setBounds(140, 100, 350, 70);
        
        
       /* nomeAgenteLable = new JLabel("nome agente:");
         nomeAgenteLable.setForeground(Color.white);
         nomeAgenteLable.setBounds(20, 130, 100, 20);
        nomeAgente = new JTextField();
        nomeAgente.setBounds(100, 130, 100, 20);*/
        
        chiaveLable = new JLabel("Chiave:");
        chiaveLable.setForeground(Color.white);
        chiaveLable.setBounds(10, 190, 100, 20);
        chiave = new JTextField();
        chiave.setBounds(70, 190, 100, 20);
        esci = new JButton("Esci");
        esci.setBounds(170, 270, 80, 20);
        decripta = new JButton("Decripta");
        decripta.setBounds(20, 270, 100, 20);
        gruppoBottoni = new ButtonGroup();
        gruppoBottoni.add(esci);
        gruppoBottoni.add(decripta);
        gruppo1 = new ButtonGroup();
        gruppo1.add(cesare);
        gruppo1.add(vigenere);
        gruppo1.add(cesareBf);
        p.add(testoLable);
        p.add(testoMess);
        p.add(criptatiLable);
        p.add(chiaveLable);
        p.add(chiave);
        p.add(cesare);
        p.add(vigenere);
        p.add(cesareBf);
        p.add(messaggiRicevuti);
        p.add(decripta);
        p.add(esci);
        //p.add(scroll);
        add(p);
       // invia.addActionListener(this);
        esci.addActionListener(this);
        decripta.addActionListener(this);
        try {
            indirizzoS = InetAddress.getLocalHost().getHostAddress();

        } catch (Exception ex) {
        }
        p.setBackground(Color.blue);
        this.setBounds(100, 100, 800, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (esci == e.getSource()){
           dispose();
        }
        //decremento contatore
	if (decripta == e.getSource()) {
            
            decriptaMessaggio();
            
	}

    }
    
    void decriptaMessaggio(){
        
        String messaggioCriptato,messaggioDecriptato = ""; 
        
        messaggioCriptato = messaggiRicevuti.getSelectedItem().toString();
        
      //  System.out.println("messaggio criptatoo:" + messaggioCriptato);
        
        if(cesare.isSelected()){
            int chiave1 = Integer.parseInt(chiave.getText());
            messaggioDecriptato = Cesare.decifraMessaggio(messaggioCriptato, chiave1);
            
        }
        
        if(vigenere.isSelected()){
            
            messaggioDecriptato = Vigenere.decifraMessaggio(messaggioCriptato, chiave.getText());
            
        }
        
        if (cesareBf.isSelected()){
            
             messaggioDecriptato = Cesare.bruteForce(messaggioCriptato);
        
        
        }
        
        testoMess.setText(messaggioDecriptato);
    }
    
}
