import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public abstract class AbstractGame implements Game {
    private static final Logger LOGGER = Logger.getLogger(AbstractGame.class.getName());
    private List<String> history = new ArrayList<>();
    protected List<String> alphabet;
    protected int maxTry;
    private GameStatus GameStatus;

    public AbstractGame(List<String> alphabet) {
        try {
            FileHandler fileHandler = new FileHandler("game_log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.alphabet = alphabet;
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        
    }

    @Override
    public Answer inputValue(String value) {
        history.add(value);
        LOGGER.info("Input Value: " + value);

        int bull = 0;
        int cow = 0;
       

        LOGGER.info("Answer: " + bull + " bulls, " + cow + " cows");

        return new Answer(bull, cow, maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return GameStatus;
        
    }

    public List<String> getHistory() {
        return history;
    }

    public void restart() {
        
    }

    abstract ArrayList<String> generateCharList();
}
