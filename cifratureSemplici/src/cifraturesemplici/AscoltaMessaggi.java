/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifraturesemplici;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author ema05
 */
public class AscoltaMessaggi extends Thread {
    InterfacciaSecretI chiamante;
    Socket s;
    InterfacciaMenu interfaccia;
            
    public AscoltaMessaggi(InterfacciaSecretI chiamante, InterfacciaMenu interfaccia) {
        this.chiamante = chiamante;
        this.s = chiamante.s;
        this.interfaccia = interfaccia;
    }
    
    public void run(){
        System.out.println("entrato nella run");
         while (true) {
             System.out.println("entrato nel while");
            try {
                
                BufferedReader inClient = new BufferedReader(new InputStreamReader(interfaccia.s.getInputStream()));
                String msg = inClient.readLine();
                System.out.println(msg);
                chiamante.messaggiRicevuti.addItem(msg);
                 System.out.println("aggiunto");
                
                
            }catch(Exception ex){
                System.out.println("entrato in errore");
                System.out.println(ex.getMessage());
                 System.out.println(ex.getStackTrace());
                 break;
            }
        
    }
    
    
    
    
}
}