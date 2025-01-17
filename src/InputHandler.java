import java.util.Scanner;
public class InputHandler {
    public static char getLetterFromUser(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Input a letter: ");
            String inputLetter = scanner.next().trim().toLowerCase();
            if (inputLetter.length()==1 && inputLetter.matches("[a-z]+")){
                return inputLetter.charAt(0);
            }else{
                System.out.println("Enter a letter!");
            }

        }

    }

    public static boolean playAgain(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Would you like to play again? 'y' or 'n': ");
            String response = scanner.next().trim().toLowerCase();
            if(response.equals("y")){
                return true;
            } else if (response.equals("n")){
                return false;
            } else{
                System.out.println("Select 'y' or 'n'!");
            }
        }
    }
}
