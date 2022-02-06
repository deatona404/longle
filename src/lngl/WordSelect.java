package longle.src.lngl;

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
@SuppressWarnings("unused")
public class WordSelect {
    String fileName;
    int length; //length of file

    /**
     * Constructor for WordSelect
     * @param file the file to be read, corresponding to how long the word is, in letters.
     */
    public WordSelect(String file) {
        this.fileName = file;
        length = 0;
        // try{
        // Scanner scan = new Scanner(new File(fileName)); //i hate scanners
        // }
        // catch (Exception e){
        //     System.out.println("Error locating file in WordSelect constructor");
        // }
        this.lengthOfFile();
        this.getWord();
    }
    /**
     * Calculates the length of the file in lines.
     */
    public void lengthOfFile() {
        Scanner reader;
        try{
            reader = new Scanner(new File(fileName));
            while (reader.hasNextLine()){
                reader.nextLine();
                length++;
            }
        reader.close();
        }
        catch (FileNotFoundException e){
             System.out.println("Error locating file in lengthOfFile");
        }
    }
    /**
     * Gets the word from the file on the line that the random number generates
     */
    public String getWord() {
        Random rand = new Random();
        int index = rand.nextInt(length);
        String word;
        try{
            word = Files.readAllLines(Paths.get(fileName)).get(index);
            return word;
        }
        catch (Exception e){
            System.out.println("Error reading file for random generation");
        }
        return Prototype.BAD_READ;
    }
}
