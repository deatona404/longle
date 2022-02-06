package longle.src.lngl;
//package longle;
/**
 * This class explores the basic function of the guessing game.
 */
@SuppressWarnings("unused")
public class Prototype{

    // instance variables -----------------------------------------------------
    private String word;
    private int length;
    private int allowedGuesses;
    private int guesses;
    

    // constants --------------------------------------------------------------
    public static final String BAD_LENGTH = "*WRONG LENGTH*";
    public static final String NO_GUESSES = "*NO GUESSES LEFT*";
    public static final String BAD_READ = "*COULD NOT LOCATE WORD";


    // constructor ------------------------------------------------------------
    public Prototype(String word, int length){
        this.word = word;
        this.length = length;

        guesses = 0;
        allowedGuesses = length + 1;
        // adjust allowed guesses if needed
    }

    // methods ----------------------------------------------------------------
    
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
        if(!isValidLength(userGuess)){
            return BAD_LENGTH;
        }
        if(!hasGuessesLeft()){
            return NO_GUESSES;
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
        this.guesses++;
        return str;
    }

    /**
     * Returns the number of guesses remaining.
     * @return
     *      the guesses remaining
     */
    public int guessesLeft(){
        return allowedGuesses - guesses;
    }

    /**
     * Checks if the user has any remaining guesses.
     * @return
     *          <code>true</code> if guesses remain, else <code>false</code>
     */
    public boolean hasGuessesLeft(){
        return guesses < allowedGuesses;
    }


    /**
     * Returns true if the word is solved. 
     * @param guessReturn
     *          guess after being filtered through the guess() method
     * @return
     *      <code>true</code> if solved, else <code>false</code>.
     */
    public boolean solved(String guessReturn){
        for(int i = 0; i < guessReturn.length(); i++){
            if(guessReturn.charAt(i) != '@'){
                return false;
            }
        }

        return true;
    }

    /**
     * 
     * @param userGuess
     *          the user's guess to check validity of
     * @return
     *          <code>true</code> if guess is valid, else <code>false</code>
     */
    public boolean isValidLength(String userGuess){
        if(userGuess.length() != word.length()){
            return false;
        }
        return true;
    }

    /**
     * Checks if the given parameter is a valid word for the game.
     * @param userGuess
     *          word to check
     * @return
     *          <code>true</code> if word is valid, else <code>false</code>
     */
    public boolean isValidWord(String userGuess){
        /* if word list for length L does not contain the userGuess,
        *  then return false. @ rebecca deal with this
        */
        return true; // temporary
    }

}