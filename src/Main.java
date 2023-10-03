import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose the game language (russian/english): ");
        String languageChoice = scanner.nextLine();

        Game game;
        if (languageChoice.equalsIgnoreCase("russian")) {
            game = new WordGameRussian();
        } else {
            game = new WordGameEnglish();
        }

        System.out.print("Choose the game type (numbers/letters): ");
        String typeChoice = scanner.nextLine();

        if (typeChoice.equalsIgnoreCase("numbers")) {
            game = new NumberGame();
        }

        game.start(5, 1);

        while (game.getGameStatus() != GameStatus.WIN && game.getGameStatus() != GameStatus.LOSE) {
            Answer answer = game.inputValue(scanner.nextLine());
            System.out.println("Answer: " + answer);
        }

        System.out.println("Game Status: " + game.getGameStatus());

        // Добавьте код для проверки, хочет ли пользователь перезапустить игру
        System.out.print("Do you want to play again? (y/n): ");
        String restartChoice = scanner.nextLine();

        if (restartChoice.equalsIgnoreCase("n")) {
            System.out.println("Goodbye!");
        }
    }
}
