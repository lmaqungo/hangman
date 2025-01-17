import java.util.List;
import java.nio.file.*;
import java.io.IOException;

public class WordProvider {
    private List<String> wordList;

    public WordProvider(){
        String path = "C:\\Users\\Luyanda\\Development\\Java\\Hangman\\src\\words.txt";
        try{
            wordList = Files.readAllLines(Paths.get(path));
        } catch (IOException e){
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
    public String getRandomWord(){
        return wordList.get((int) Math.round(Math.random() * (wordList.size()-1)));
        // didn't know you could explicitly cast primitives like this
    }


}
