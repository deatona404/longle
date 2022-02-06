package lngl;

import java.util.*;
import java.io.*;

public class WordSelect {
    String file;
    String length; //length of file

    /**
     * Constructor for WordSelect
     * @param file the file to be read, corresponding to how long the word is, in letters.
     */
    public WordSelect(String file) {
        this.file = file;
        length = 0;
        Scanner scan = new Scanner(new File(file)); //i hate scanners
        this.lengthOfFile();
        this.getWord();
    }
    /**
     * Calculates the length of the file in lines.
     */
    public void lengthOfFile() {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null)
            length++;
        reader.close();
    }
    /**
     * Gets the word from the file on the line that the random number generates
     */
    public String getWord() {
        Random rand = new Random();
        int index = rand.nextInt(length);
        String word = Files.readAllLines(Paths.get(file)).get(index);
        return word;
    }
}
