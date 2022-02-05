package longle.src.lngl;
//package longle;
/**
 * This class explores the basic function of the guessing game.
 */
public class Prototype{

    private String word;
    private int length;
    private int allowedGuesses;
    private int guesses;

    private String badStr = "*BAD*";


    public Prototype(String word, int length){
        this.word = word;
        this.length = length;

        guesses = 0;
        allowedGuesses = length + 1;
        // do stuff if necessary?
    }

    /**
     * Gets the puzzle's secret word.
     * @return the secret word
     */
    public String getWord(){
        return this.word;
    }

    /**
     * Gets the length of the word puzzle.
     * @return the length of the word puzzle.
     */
    public int getLength(){
        return this.length;
    }

    /**
     * Gets the total allowed guesses for this word.
     * @return the allowed guesses
     */
    public int getAllowedGuesses(){
        return this.allowedGuesses;
    }

    /**
     * Gets the number of guesses the user has used.
     * @return number of guesses so far
     */
    public int getGuesses(){
        return this.guesses;
    }
    
 
    /**
     * Allows the user to guess a word. Returns a string formatted so that
     * an @ is used if the letter is contained within the word and has the 
     * correct position, a % is used if the letter is contained within the
     * word, and a # is used if the letter is not within the word.
     * @param userGuess
     *          the word the user guesses
     * @return
     *          returns a string representing guess accuracy.
     */
    public String guess(String userGuess){
        if(isValidGuess(userGuess)){
            return badStr;
        }
        String str = "";
        for(int i = 0; i < word.length(); i++){
            if(userGuess.charAt(i) == word.charAt(i)){
                str += "@";
            }
            else if(word.contains(userGuess.substring(i, i + 1))){
                str += "%";
            }
            else{
                str += "#";
            }
        }

        return str;
    }
    /**
     * Returns true if the word is solved. 
     * @param guessReturn
     *          guess after being filtered through the guess() method
     * @return
     *      true if solved, else false.
     */
    public boolean solved(String guessReturn){
        for(int i = 0; i < guessReturn.length(); i++){
            if(guessReturn.charAt(i) != '@'){
                return false;
            }
        }

        return true;
    }

    public boolean isValidGuess(String userGuess){
        if(userGuess.length() != word.length()){
            return false;
        }
        /* if word list for length L does not contain the userGuess,
        *  then return false. @ rebecca deal with this
        */

        return true;
    }

}