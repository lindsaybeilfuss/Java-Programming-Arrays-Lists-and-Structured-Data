// Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. 
// This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, 
// starting with the first character, and key2 is used to encrypt every other character, starting with the second character. 
// For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. 


import edu.duke.*;
import java.io.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            //use toUpperCase as index wont be found if currChar is lowercase
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            //If currChar is in the alphabet
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

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        System.out.println("shifted1 = " + shiftedAlphabet1);
        String shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        System.out.println("shifted2 = " + shiftedAlphabet2);
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            //check if i is even or odd using modulo, check if currChar is in alphabet
            if (i%2 == 0) {
                if (idx != -1){
                    char newChar = shiftedAlphabet1.charAt(idx);               
                    if (Character.isLowerCase(currChar)) {
                        newChar = Character.toLowerCase(newChar);
                    }
                    encrypted.setCharAt(i, newChar);
                }            
            }
            
            else if (i%2 != 0){
                if (idx != -1){
                    char newChar = shiftedAlphabet2.charAt(idx);               
                    if (Character.isLowerCase(currChar)) {
                        newChar = Character.toLowerCase(newChar);
                    }
                    encrypted.setCharAt(i, newChar);
                }                
            } 
            }   
        return encrypted.toString();
        }
           
    
    public void testCaesar() {
        //int key = 15;
        int key1 = 23;
        int key2 = 2;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        
        String message = ("Just a test string with lots of eeeeeeeeeeeeeeeees");
        //String encrypted = encrypt(message, key);
        String encryptedTwoKeys = encryptTwoKeys(message, key1, key2);
        //System.out.println(encrypted);
        System.out.println(encryptedTwoKeys);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
    }
}