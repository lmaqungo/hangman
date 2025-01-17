import java.util.ArrayList;
public class Game {
    private String wordToGuess;
    private char[] guessedWord;
    private int remainingAttempts;
    private ArrayList<Character> guessedLetters;
    private int score;
    private int round;

    public Game(String wordToGuess){
        this.wordToGuess = wordToGuess;
        this.remainingAttempts = 7; // number of hangman body parts + rope
        guessedWord = new char[this.wordToGuess.length()];
        guessedLetters = new ArrayList<>();
        addclues();
        score = 0;
        round = 0;

    }

    public void guessLetter(char letter){
        char[] wordCharArray = wordToGuess.toCharArray();
        int counter = 0;
            // checks if letter is in already guessed letters
        if(guessedLetters.contains(letter)){
            System.out.printf("'%c' guessed already%n", letter);

        } // letter iterator
        else{
            for(int i = 0; i < wordCharArray.length;i++){
                if(letter==wordCharArray[i]){
                    if(letter == guessedWord[i]){
                        System.out.printf("'%c' already guessed in word!%n", letter);
                        break;
                    }else{
                        guessedWord[i] = letter;
                    }
                }else{
                    counter++;
                    if(counter==wordCharArray.length){
                        guessedLetters.add(letter);
                        remainingAttempts-=1;
                        break;
                    }
                }
            }
        }
    }

    public boolean isGameOver(){
        return isWordGuessed() || getRemainingAttempts()==0;
    }

    public String getWordToGuess(){
        return this.wordToGuess;
    }

    public void setWordToGuess(String wordToGuess){
        this.wordToGuess = wordToGuess;
    }

    public int getRemainingAttempts(){
        return remainingAttempts;
    }

    public String getGuessedWord(){
        StringBuilder guessedWordString = new StringBuilder();
        for(char letter: guessedWord){
            if (letter == '\u0000'){
                guessedWordString.append('_');
            } else{
                guessedWordString.append(letter);
            }
        }
        return guessedWordString.toString();
    }

    public void addclues() {
        char[] wordCharArray = wordToGuess.toCharArray();
        int clues;
        int wordLength = wordToGuess.length();
        if (wordLength <= 5) {
            clues = 1;
        } else if (wordLength <= 10) {
            clues = 2;
        } else {
            clues = 3;
        }

        for (int i = 0; i < wordLength; i++) {
            int randomIndex = (int) Math.round(Math.random() * (wordLength - 1));
            char randomLetter = wordCharArray[randomIndex];
            for (int j = 0; j < wordLength; j++) {
                if (wordCharArray[j] == randomLetter) {
                    guessedWord[j] = randomLetter;
                }
            }
            if (clues == 0) {
                break;
            }
            clues -= 1;
        } /* if there are multiple instances of a letter that is picked at random as a clue,
            then fill up all instances of it. Only use the next clue for the next letter.

        */

    }

    public ArrayList<Character> getGuessedLetters(){
        return guessedLetters;
    }

    public int getScore(){
        if(isGameOver()){
            score+=remainingAttempts;
        }
        return score;
    }

    public int getRound(){
        if(isGameOver()){
            round+=1;
        }
        return round;
    }

    public boolean isWordGuessed(){
        return getWordToGuess().equals(getGuessedWord());
    }

    public void restart(String newWordToGuess){
        setWordToGuess(newWordToGuess);
        this.remainingAttempts = 7; // number of hangman body parts + rope
        guessedWord = new char[this.wordToGuess.length()];
        guessedLetters = new ArrayList<>();
        addclues();

    }
}
