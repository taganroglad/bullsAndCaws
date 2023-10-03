import java.util.ArrayList;
import java.util.Arrays;

public class WordGameEnglish extends AbstractGame {
    public WordGameEnglish() {
        super(new ArrayList<>(Arrays.asList(
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
        )));
    }

    @Override
    ArrayList<String> generateCharList() {
        return new ArrayList<>(alphabet);
    }
}
