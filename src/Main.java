import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String guess = "";
        String word = "picha";
        int letters = word.length();

        Scanner scanner = new Scanner(System.in);


        System.out.println("WORD TO GUESS: " + letters);

        while (letters != 0) {
            guess = scanner.nextLine();

            if (guess.length() > 1) {
                if (guess.equals(word)) {
                    break;
                }
                System.out.println("Failed to guess word");
                continue;
            }

            if (word.indexOf(guess) > -1) {
                System.out.println("Found a letter");
                letters--;
            } 
        }

        System.out.println("YOU WIN");
    }

}
