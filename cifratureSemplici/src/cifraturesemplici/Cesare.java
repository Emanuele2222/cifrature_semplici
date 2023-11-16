/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifraturesemplici;
import java.util.Scanner;
/**
 *
 * @author ema05
 */
public class Cesare {
    
       
    public static String cifraMessaggio(String mess, int key){
    
        char [] vettoreChar = mess.toCharArray();
        int lunghezza = mess.length();
        char [] vettoreChar2 = new char [lunghezza];
        
        for(int i = 0; i < lunghezza; i++){
            
            vettoreChar[i] += key;
            
        }
          
        String messCifrato = String.valueOf(vettoreChar);
        
        return messCifrato;
    }
    
    public static String decifraMessaggio(String mess, int key){
    
        char [] vettoreChar = mess.toCharArray();
        int lunghezza = mess.length();
        char [] vettoreChar2 = new char [lunghezza];
        char space; 
        
        for(int i = 0; i < lunghezza; i++){
            
            vettoreChar[i] -= key;
            space = vettoreChar[i];
            
            if(space == '\u001d'){
                space = ' ';
            }
            
            vettoreChar[i] = space;
            
        }
          
        String messDecifrato = String.valueOf(vettoreChar);
        
        return messDecifrato;
    }
    
    
    public static String bruteForce(String mess){
        
        String controlloDuePunti = "";
        int key = 0;
        String messDecifrato = "";
        
        int lunghezza = mess.length();
        char [] vettoreChar2 = new char [lunghezza];
        char space; 
        
         while(!controlloDuePunti.equals(": ")){
            
             char [] vettoreChar = mess.toCharArray();
            for(int i = 0; i < lunghezza; i++){

                vettoreChar[i] -= key;

                space = vettoreChar[i];

                if(space == '\u001d'){
                    space = ' ';
                }

                vettoreChar[i] = space;

            }

             messDecifrato = String.valueOf(vettoreChar);
             controlloDuePunti = messDecifrato.substring(4,6);

               key ++;
         }
       
        return messDecifrato;
    }
    
    
    
    
    
    
    }
    

