
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WordLengths {
    public void countWordLengths(FileResource resource, int counts[]) {
        //loop through words from file resource using words method
        for(String word : resource.words()) {
            //for each word get the length of the word
            int wordlength = word.length();
            if (wordlength != -1) {
                //check if char at first & last index is a letter
                if (Character.isLetter(word.charAt(0)) && Character.isLetter(word.charAt(wordlength-1))) {
                    //store the count in array counts at index which equals the length of the word
                    counts[wordlength] += 1;
                    //System.out.println("wordlength = " + wordlength);
                }
                if (Character.isLetter(word.charAt(0)) == false || Character.isLetter(word.charAt(wordlength-1)) == false) {
                    //if char at first or last index is not a letter, subtract 1 from the word length
                    counts[wordlength-1] += 1;
                    //System.out.println("wordlength = " + wordlength);
                }
            } 
            System.out.println("done counting wordlengths");
        }
        //loop through the counts array and print
        for( int i = 0; i < counts.length; i++) {
            System.out.println("count of words with " + i + " length is " + counts[i]);
        }
    }
    
    public int indexOfMax(int values[]) {
        //this method returns the index position of the largest element in values
        int indexOfMax = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > indexOfMax) {
                indexOfMax = values[i];
            }
        }
        return indexOfMax;
    }
    
    
    public void testCountWordLengths() {
        //create a FileResource
        FileResource resource = new FileResource("data/smallHamlet.txt");
        //create an integer array of counters with 31 memory locations
        int[] counts = new int[31];
        //call countWordLengths passing in the fileresource and integer array of counters
        countWordLengths(resource, counts);
        //call indexOfMax papssing in the int array counts used in countOfWordLengths
        System.out.println("indexOfMax = " + indexOfMax(counts));
    }
    
}
