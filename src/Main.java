public class Main {
    public static void main(String[] args) {
        WordProvider wordProvider = new WordProvider();
        Game game = new Game(wordProvider.getRandomWord());
        System.out.println("Welcome to Hang man");
        while(true){
            Display.printGameState(game.getGuessedWord(), game.getRemainingAttempts(), game.getGuessedLetters());
            if(!game.isGameOver()){
                game.guessLetter(InputHandler.getLetterFromUser());
            } else if (game.isWordGuessed()) {
                // won game, try again?
                Display.printWinMessage(game.getWordToGuess());
                Display.printScore(game.getScore(), game.getRound());
                if(InputHandler.playAgain()){
                    game.restart(wordProvider.getRandomWord());
                    continue;
                }else{
                    System.out.println("Exiting");
                    break;
                }

            }else{
                // Lost game, try again?
                Display.printLoseMessage(game.getWordToGuess());
                Display.printScore(game.getScore(), game.getRound());
                if(InputHandler.playAgain()){
                    game.restart(wordProvider.getRandomWord());
                    continue;
                }else{
                    System.out.println("Exiting");
                    break;
                }

            }

        }

    }




}