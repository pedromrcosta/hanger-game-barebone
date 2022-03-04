import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String guess = "";
        String word = "picha";
        int letters = word.length();
        String[] lettersGuessed = new String[word.length()];
        boolean found = false;
        //P I C H A
        //_ _ _ _ _
        //_ _ _ H _

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < lettersGuessed.length; i++) {
            lettersGuessed[i] = "_";
            System.out.print(lettersGuessed[i] + " ");
        }

        while (letters != 0) {
            found = false;
            guess = scanner.nextLine();

            if (guess.length() > 1) {
                if (guess.equals(word)) {
                    break;
                }
                System.out.println("Failed to guess word");
                continue;
            }

            if (word.indexOf(guess) > -1) {
                for (int i = 0; i < lettersGuessed.length; i++) {
                    if (lettersGuessed[i].equals(guess)) {
                        System.out.println("JA ENCONTRASTE ESSA LETRA BURRO");
                        found = true;
                    }
                }

                if (!found) {
                    lettersGuessed[word.indexOf(guess)] = guess;
                    letters--;
                }

                for (int i = 0; i < lettersGuessed.length; i++) {
                    System.out.print(lettersGuessed[i] + " ");
                }

                System.out.println();
            }
        }

        System.out.println("YOU WIN");
    }


}
