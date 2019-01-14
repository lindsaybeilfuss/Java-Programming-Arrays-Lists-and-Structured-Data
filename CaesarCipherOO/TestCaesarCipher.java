import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class TestCaesarCipher {
    public int[] countLetters(String message) {
        //this method returns an array of counts for each char in the message passed in
        //scan message char by char using for loop
        String alphabet = ("abcdefghijklmnopqrstuvwxyz");
        int[ ] letterCounts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            //find where each character occurs at index in alphabet
            int idx = alphabet.indexOf(ch);
            if (idx != -1) {
                //use index to increment one of the 26 letter counters
                letterCounts[idx] += 1;
            }       
        }
        //loop through the counts array and print
        //for( int i = 0; i < letterCounts.length; i++) {
            //System.out.println("count of letters per index " + i + " is " + letterCounts[i]);
        //}
        return letterCounts;
    }
    
    public int maxIndex(int values[]) {
        //this method returns the index position of the largest element in values
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    public String breakCaesarCipher(String input){
    //this method determines which key was used to encrypt the message, creates a CaesarCipher object with the key, and decrypts the message
    int[] letterCounts = countLetters(input);
    int maxDex = maxIndex(letterCounts);
    int dkey = maxDex - 4;
    if (maxDex < 4) {
        dkey = 26 - (4 - maxDex);
    }
    CaesarCipher cc = new CaesarCipher(dkey);
    return cc.decrypt(input);
    }
    
    public void simpleTests(){
        //read in a file as a String
        FileResource fileResource = new FileResource();
        String x = fileResource.asString();
        //create a CaesarCipher object with key
        CaesarCipher cc = new CaesarCipher(16);
        //encrypt String read in using CaesarCipher object, print encrypted string, decrypt the encrypted string using the decrypt method
        String encrypted = cc.encrypt(x);
        System.out.println("encrypted string is "+ encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("decrypted string is " + decrypted);
        String breakCaesar = breakCaesarCipher(encrypted);
        System.out.println("breakCaesarCipher results ="  + breakCaesar);
        
    }
}
