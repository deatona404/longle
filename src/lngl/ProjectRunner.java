package longle.src.lngl;

import java.util.Scanner;
/**
 * Runs the Longle project.
 */
public class ProjectRunner {
    public static void main(String[] args){
        // do stuff
        String word = "kittens";
        Prototype game = new Prototype(word, word.length());


        Scanner input = new Scanner(System.in);
        boolean unsolved = true;
        while(unsolved){
            System.out.println("Enter your guess of length " + word.length() + ": ");
            String currGuess = input.nextLine();
            String hint = game.guess(currGuess);
            System.out.println(hint);
            if(game.solved(hint)){
                System.out.println("You've solved the word!");
                unsolved = false;
            }
        }
        
        input.close();

    }
    
}
