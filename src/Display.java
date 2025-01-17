import java.util.ArrayList;
public class Display{

    public static String hangman;
    public static void printGameState(String guessedWord, int remainingAttempts, ArrayList<Character> guessedLetters){

        switch(remainingAttempts){
            case 7: hangman =
                     "--------"+
                    "\n|" +
                    "\n|" +
                    "\n|" +
                    "\n|" +
                    "\n|" +
                    "\n|";
                    break;
            case 6: hangman =
                     "--------"+
                    "\n|      |" +
                    "\n|" +
                    "\n|" +
                    "\n|" +
                    "\n|" +
                    "\n|";
                    break;
            case 5: hangman =
                     "--------"+
                    "\n|      |" +
                    "\n|      O" +
                    "\n|" +
                    "\n|" +
                    "\n|" +
                    "\n|";
                    break;
            case 4: hangman =
                     "--------"+
                    "\n|      |" +
                    "\n|      O" +
                    "\n|      |" +
                    "\n|" +
                    "\n|" +
                    "\n|";
                    break;
            case 3: hangman =
                     "--------"+
                    "\n|      |" +
                    "\n|      O" +
                    "\n|     /|" +
                    "\n|" +
                    "\n|" +
                    "\n|";
                    break;
            case 2: hangman =
                     "--------"+
                    "\n|      |" +
                    "\n|      O" +
                    "\n|     /|\\" +
                    "\n|" +
                    "\n|" +
                    "\n|";
                    break;
            case 1: hangman =
                     "--------"+
                    "\n|      |" +
                    "\n|      O" +
                    "\n|     /|\\" +
                    "\n|     /" +
                    "\n|" +
                    "\n|";
                    break;
            case 0: hangman =
                     "--------"+
                    "\n|      |" +
                    "\n|      O" +
                    "\n|     /|\\" +
                    "\n|     / \\" +
                    "\n|" +
                    "\n|";
                    break;

        }
        System.out.println(hangman);
        System.out.println(guessedWord);
        System.out.print("Guessed Letters: ");
        for(Character c: guessedLetters){
            System.out.printf("%c ", c);
        }
        System.out.println();
    }

    public static void printWinMessage(String wordToGuess){
        System.out.printf("You correctly guessed '%s'!%n", wordToGuess);
    }

    public static void printLoseMessage(String wordToGuess){
        System.out.printf("You lose. The word was: %s%n", wordToGuess);
    }

    public static void printScore(int score, int round){
        System.out.printf("Your score for round %d is %d%n", round, score);
    }



}
