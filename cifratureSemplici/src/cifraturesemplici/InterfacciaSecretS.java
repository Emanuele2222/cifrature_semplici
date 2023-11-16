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
public class InterfacciaSecretS extends JFrame implements ActionListener {

    JPanel p;
    JButton invia, esci;
    ButtonGroup gruppoBottoni;
    ButtonGroup gruppo1;
    JLabel testoLable,chiaveLable,nomeAgenteLable;
    JTextField  nomeAgente, chiave;
    JTextArea testoMess;
    JRadioButton cesare;
    JRadioButton vigenere;
    String indirizzoS;
    ServerSocket ss;
    public Socket s;
    private InterfacciaMenu interfaccia; 

    public InterfacciaSecretS(InterfacciaMenu interfaccia) {

        super("Interfaccia SecretS");
        p = new JPanel();
        //p = (JPanel) this.getContentPane();
        p.setLayout(null);
        this.interfaccia = interfaccia;
        cesare = new JRadioButton("Cesare");
        cesare.setBounds(60, 210, 70, 20);
        cesare.setSelected(true);
        vigenere = new JRadioButton("Vigenere");
        vigenere.setBounds(150, 210, 80, 20);
        testoLable = new JLabel("Messaggio:");
        testoLable.setForeground(Color.white);
        testoLable.setBounds(20, 20, 90, 20);
        testoMess = new JTextArea();
        testoMess.setBounds(90, 20, 300, 70);
        
        nomeAgenteLable = new JLabel("nome agente:");
         nomeAgenteLable.setForeground(Color.white);
         nomeAgenteLable.setBounds(20, 130, 100, 20);
        nomeAgente = new JTextField();
        nomeAgente.setBounds(100, 130, 100, 20);
        
        chiaveLable = new JLabel("chiave:");
         chiaveLable.setForeground(Color.white);
         chiaveLable.setBounds(20, 170, 100, 20);
        chiave = new JTextField();
        chiave.setBounds(90, 170, 100, 20);
        esci = new JButton("Esci");
        esci.setBounds(190, 270, 80, 20);
        invia = new JButton("Invia");
        invia.setBounds(20, 270, 80, 20);
        gruppoBottoni = new ButtonGroup();
        gruppoBottoni.add(esci);
        gruppoBottoni.add(invia);
        gruppo1 = new ButtonGroup();
        gruppo1.add(cesare);
        gruppo1.add(vigenere);
        p.add(testoLable);
        p.add(testoMess);
        p.add(nomeAgenteLable);
        p.add(nomeAgente);
        p.add(chiaveLable);
        p.add(chiave);
        p.add(cesare);
        p.add(vigenere);
        p.add(invia);
        p.add(esci);
        add(p);
       // invia.addActionListener(this);
        esci.addActionListener(this);
        invia.addActionListener(this);
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
       System.out.println("entrato");
             
        if (esci == e.getSource()){
           dispose();
        }
        
        //decremento contatore
	if (invia == e.getSource() && testoMess.getText().equals("") == false && chiave.getText().equals("") == false) {//cambiata condizione!!!
            
            inviaMessaggio();
            
	}

    }
    
    
    private void inviaMessaggio(){
        
        String messaggioCompleto,messaggioCifrato;
        
        messaggioCompleto = nomeAgente.getText() + ": " + testoMess.getText();
        if(cesare.isSelected()){
           int chiave1 = Integer.parseInt(chiave.getText());
           messaggioCifrato =  Cesare.cifraMessaggio(messaggioCompleto,chiave1 );
        }
        else{
            messaggioCifrato = Vigenere.cifraMessaggio(messaggioCompleto, chiave.getText());
        }
        
         try {
            PrintWriter outClient = new PrintWriter(interfaccia.s.getOutputStream(), true);
            outClient.println(messaggioCifrato);
           System.out.println(messaggioCifrato);
        } catch (Exception e) {
        }
    }
    
    
}


//PULISCI MASCHERA!!!!!!