/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifraturesemplici;

/**
 *
 * @author ema05
 */

public class Vigenere {
    
    
   public static String cifraMessaggio(String mess, String key){ 
    
   
    char vettoreChar[] = mess.toCharArray();
    char vettoreKeyChar[] = key.toCharArray();
    int j = 0;
    int vettoreInt[];
    int vettoreKeyInt[] = new int [vettoreChar.length];
    for(int i = 0; i < vettoreKeyChar.length; i++){
        
        vettoreKeyInt[i] = vettoreKeyChar[i];
        
    }
    
    for (int i = 0; i < vettoreChar.length; i++) {
            vettoreChar[i] += vettoreKeyInt[j];
            j += 1;
           
            if (j == vettoreKeyChar.length) {
                j = 0;
            }
           
        }
    
    String messCifrato = String.valueOf(vettoreChar); 
    return messCifrato;
    
   }
    
    public static String decifraMessaggio(String mess, String key){ 
     
    char space;
    char vettoreChar[] = mess.toCharArray();
    char vettoreKeyChar[] = key.toCharArray();
    int j = 0;
    int vettoreKeyInt[] = new int [vettoreChar.length];
    for(int i = 0; i < vettoreKeyChar.length; i++){
        
        vettoreKeyInt[i] = vettoreKeyChar[i];
        
    }
    
    for (int i = 0; i < vettoreChar.length; i++) {
            vettoreChar[i] -= vettoreKeyInt[j];
            j += 1;
              space = vettoreChar[i];
            if (j == vettoreKeyChar.length) {
                j = 0;
            }
             if(space == '\u001d'){
                space = ' ';
            }
            
            vettoreChar[i] = space;
        }
    
    String messdeCifrato = String.valueOf(vettoreChar); 
    return messdeCifrato;
   }
    
   /* public static String bruteForce(String mess, String key){ 
     
    char space;
    char vettoreChar[] = mess.toCharArray();
    char vettoreKeyChar[] = key.toCharArray();
    int j = 0;
    int vettoreKeyInt[] = new int [vettoreChar.length];
    for(int i = 0; i < vettoreKeyChar.length; i++){
        
        vettoreKeyInt[i] = vettoreKeyChar[i];
        
    }
    
    for (int i = 0; i < vettoreChar.length; i++) {
            vettoreChar[i] -= vettoreKeyInt[j];
            j += 1;
              space = vettoreChar[i];
            if (j == vettoreKeyChar.length) {
                j = 0;
            }
             if(space == '\u001d'){
                space = ' ';
            }
            
            vettoreChar[i] = space;
        }
    
    String messdeCifrato = String.valueOf(vettoreChar); 
    return messdeCifrato;
   }*/
    
    
    
    /*
    //BOZZA BRUTE FORCE VIGENERE: VARIE PROBLEMATICHE DA RISOLVERE
    public static String trovaChiave(String mess){
        char space;
        int j = 0; 
        char vettoreChar[] = mess.toCharArray();
        char vettoreKeyChar[] = "1234: ".toCharArray();
        int [] vettoreKeyInt = new int[vettoreKeyChar.length];
        for(int i = 0; i < vettoreKeyChar.length; i++){
        
        vettoreKeyInt[i] = vettoreKeyChar[i];
        
    }
        
         for (int i = 0; i < vettoreChar.length; i++) {
            vettoreChar[i] -= vettoreKeyInt[j];
            j += 1;
              space = vettoreChar[i];
            if (j == vettoreKeyChar.length) {
                j = 0;
            }
             if(space == '\u001d'){
                space = ' ';
            }
            
            vettoreChar[i] = space;
        }
        
        String chiave = String.valueOf(vettoreChar);
        
        return chiave;
        
    }*/
}

   