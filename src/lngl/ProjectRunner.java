package longle.src.lngl;

import java.util.Scanner;
/**
 * Runs the Longle project.
 */
@SuppressWarnings("unused")
public class ProjectRunner {
    public static void main(String[] args){
        // create scanner for basic input until gui is running
        Scanner input = new Scanner(System.in);

        // ask for length difficulty 
        System.out.println("What length word would you like to guess?");
        int desiredLength = input.nextInt();
        input.nextLine();
        String fileToSearch = "./longle/src/" + desiredLength + "Letter.txt";
        
        // Initialize game and word selector
        WordSelect selector = new WordSelect(fileToSearch);
        String word = selector.getWord();
        Prototype game = new Prototype(word, word.length());
        

        // allows the user to guess until they run out of guesses :)
        boolean unsolved = true;
        while(unsolved){
            System.out.println("LEN " + word.length() + " | guess "+ (game.getGuesses() + 1) + ": ");
            String currGuess = input.nextLine();
            String hint = game.guess(currGuess, fileToSearch);
            System.out.println(hint);
            if(game.solved(hint)){
                System.out.println("You've solved the word!");
                unsolved = false; 
            }
            else if(!game.hasGuessesLeft()){
                System.out.println("You failed. The word was: " + word);
                break;
            }
        }
        
        input.close();

    }
    
}
