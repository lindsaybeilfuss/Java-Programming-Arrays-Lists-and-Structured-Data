
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarBreaker {
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
                System.out.println("maxindex is " + maxIndex);
            }
        }
        return maxIndex;
    }
    
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        //call countLetters on the encrypted message and store values in freqs array
        int[] freqs = countLetters(encrypted);
        //values from freqs array to maxIndex
        int maxDex = maxIndex(freqs);
        System.out.println("maxDex is " + maxDex);
        //find the distance from this location to index of e, which is 4
        int dkey = maxDex - 4;
        System.out.println("dkey is "+ dkey);
        if (maxDex < 4) {
            //wrap around from 26 to find the shift used for e
            dkey = 26 - (4-maxDex);
            System.out.println("dkey is " + dkey);
        }
        //if value of dkey was used to encrypt then we return the decrypted string
        return cc.encrypt(encrypted,26-dkey);
    }
    
    public String halfOfString(String message, int start) {
        String halfString = "";
        for (int i = start; i < message.length(); i+=2) {
            halfString = halfString + message.charAt(i);
        }       
        return halfString;
    }
    
    public int getKey(String s) {        
        // call method countLetters to get an array of the letter frequencies in String s
        int [] key = countLetters(s);
        // call method maxIndex to get the index of the largest letter frequency
        // this only leads to the location of the encrypted letter 'e' so find the distance from this location to index of e, which is 4
        int maxDex = maxIndex(key);  
        System.out.println("maxDex is " + maxDex);
        int dkey = maxDex - 4;
        System.out.println("dkey is " + dkey);
        //// if Max index is less than 4, wrap around from 26 to find the shift used for e
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }

    public String decryptTwoKeys(String encrypted) {
        String evenLetters = halfOfString(encrypted, 0);
        System.out.println("halfstring even " + evenLetters);
        String oddLetters = halfOfString(encrypted, 1);
        System.out.println("halfstring odd " + oddLetters);
        int keyEvenLetters = getKey(evenLetters);
        int keyOddLetters = getKey(oddLetters);
        System.out.println("key for even letters is " + keyEvenLetters);
        System.out.println("key for odd letters is " + keyOddLetters);
        CaesarCipher cc = new CaesarCipher();
        return cc.encryptTwoKeys(encrypted, 26 - keyEvenLetters, 26 - keyOddLetters);
    }
    
    public void testDecrypt() {
       
        //FileResource fileResource = new FileResource();
        //String encrypted = fileResource.asString();
        String encrypted = ("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
        System.out.println("Encrypted message:\n" + encrypted);
        System.out.println("decrypted message = " + decrypt(encrypted));
    }
    
    public void testhalfOfString() {
        String halfString = halfOfString("Qbkm Zgis", 0);
        String halfString1 = halfOfString("Qbkm Zgis", 1);
        System.out.println(halfString);
        System.out.println(halfString1);
    }
    
    public void testdecryptTwoKeys() {
        //FileResource fileResource = new FileResource();
        //String encrypted = fileResource.asString();
        String encrypted = ("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu");
        System.out.println("Encrypted message:\n" + encrypted);
        System.out.println("decrypted message = " + decryptTwoKeys(encrypted));
    }
}
