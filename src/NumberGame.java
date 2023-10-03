import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGame extends AbstractGame {
    private String computerWord;
    private GameStatus gameStatus = GameStatus.INIT;
    private Scanner scanner = new Scanner(System.in);

    public NumberGame() {
        super(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        super.start(sizeWord, maxTry);
        computerWord = generateWord(sizeWord);
        System.out.println("I've chosen a " + sizeWord + "-digit number. Try to guess it!");
    }

    private String generateWord(int sizeWord) {
        List<String> digits = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        Random random = new Random();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(digits.size());
            word.append(digits.get(randomIndex));
            digits.remove(randomIndex);
        }

        return word.toString();
    }

    @Override
    public Answer inputValue(String value) {
        if (gameStatus == GameStatus.WIN || gameStatus == GameStatus.LOSE) {
            // Игра уже завершена, не обрабатываем новые вводы
            return new Answer(0, 0, maxTry);
        }

        List<String> computerDigits = Arrays.asList(computerWord.split(""));
        List<String> playerDigits = Arrays.asList(value.split(""));

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < computerDigits.size(); i++) {
            if (computerDigits.get(i).equals(playerDigits.get(i))) {
                bull++;
            } else if (computerDigits.contains(playerDigits.get(i))) {
                cow++;
            }
        }

        maxTry--;

        if (bull == computerWord.length()) {
            gameStatus = GameStatus.WIN;
        } else if (maxTry == 0) {
            gameStatus = GameStatus.LOSE;
        }

        return new Answer(bull, cow, maxTry);
    }
    @Override
    public void play() {
        System.out.println("Let's start the game!");
        start(5, 10); // Здесь укажите желаемое количество цифр и попыток
    
        while (gameStatus != GameStatus.WIN && gameStatus != GameStatus.LOSE) {
            System.out.print("Enter your guess: ");
            String playerGuess = scanner.nextLine();
            Answer answer = inputValue(playerGuess);
            System.out.println("Answer: " + answer);
    
            if (gameStatus == GameStatus.WIN) {
                System.out.println("Congratulations! You've won!");
            } else if (gameStatus == GameStatus.LOSE) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + computerWord);
            }
        }
    }
    

    @Override
    ArrayList<String> generateCharList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateCharList'");
    }
}
