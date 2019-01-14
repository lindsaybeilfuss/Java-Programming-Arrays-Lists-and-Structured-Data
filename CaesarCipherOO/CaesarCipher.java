import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;



public class CaesarCipher {
    //data is encapsulated in CaesarrCipherobject, it will have the 2 fields(lives inside object not method) below and any code within class can refer to by name
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    //constructor(looks like method), or code that gets run to initialize  object when created using new. 
    //takes in key as parameter an initilizes alaphabet and shifted alphabet fields
    //constructor must be same name as class and cannot have any return type
    public CaesarCipher(int key) {
        //each CaesarCipher object contains a key, when you do new CaesarCipher you pass in the key and the object created stores that key inside itself
        //because the key is stored in the object, when you call encrypt you only pass in the message
        //this constructor method initializes all of the private fields of the CaesarCipher class
        alphabet = "ABCDEFGHIKJKLMNOPQERSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input) {
        //this method returns a string that is the input encrypted using the shifted alphabet
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i< encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            //System.out.println("currChar = " + currChar + "index = " + i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                //Get the idxth character of shiftedAlphabet (newChar)                
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }            
        }
            //Otherwise: do nothing, //Your answer is the String inside of encrypted
        return encrypted.toString();
    } 
    
    public String decrypt(String input) {
        //this method returns a string that is the encrypted string decrypted using the key associated with this CaesarCpher object
        CaesarCipher cc = new CaesarCipher(26-mainKey);
        String decrypted = cc.encrypt(input);
        return decrypted;
    } 
}
