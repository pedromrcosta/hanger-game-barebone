import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static ArrayList<String> words;

    public static void main(String[] args) {

        words = readFile();
        Scanner scanner = new Scanner(System.in);
        String tryAgain = "";
        while (tryAgain != "NO") {
            startGame();
            System.out.println("PLAY AGAIN?");
            System.out.print("> ");
            tryAgain = scanner.nextLine().toUpperCase();
        }

    }

    public static void startGame() {
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        String guess = "";
        String wordToGuess = words.get((int)(Math.random() * words.size()));
        String[] lettersGuessed = new String[wordToGuess.length()];
        int letters = wordToGuess.length();

        for (int i = 0; i < lettersGuessed.length; i++) {
            if (wordToGuess.charAt(i) == ' ') {
                lettersGuessed[i] = " ";
                letters--;
            } else if (wordToGuess.charAt(i) == '-'){
                lettersGuessed[i] = "-";
                letters--;
            } else {
                lettersGuessed[i] = "_";
            }
        }

        while (letters != 0) {
            found = false;

            for (int i = 0; i < lettersGuessed.length; i++) {
                System.out.print(lettersGuessed[i] + " ");
            }
            System.out.println();

            System.out.print("> ");
            guess = scanner.nextLine();

            // input inválido
            if (guess.equals(null) || guess.equals("")) {
                continue;
            }

            // Se escreveu + que uma letra, está a tentar adivinhar a palavra
            if (guess.length() > 1) {
                if (guess.equals(wordToGuess)) {
                    break;
                }
                System.err.println("Failed to guess word");
                continue;
            }

            // Se for só uma letra, vai verificar se existe e se ainda não acertou
            if (wordToGuess.indexOf(guess) > -1) {
                // verificação se já encontrou letra
                for (int i = 0; i < lettersGuessed.length; i++) {
                    if (lettersGuessed[i].equals(guess)) {
                        System.err.println("You have already found that letter !");
                        found = true;
                        break;
                    }
                }

                // se acertou a letra e ainda não a tinha descoberto
                // então faz cenas
                if (!found) {
                    for (int i = 0; i < lettersGuessed.length; i++) {
                        if (wordToGuess.charAt(i) == guess.charAt(0)) {
                            lettersGuessed[i] = guess;
                            letters--;
                        }
                    }
                }
            }
        }

        System.out.println("=====================");
        System.out.println(">>>>>  YOU WIN  <<<<<");
        System.out.println("=====================");
    }

    public static ArrayList<String> readFile() {
        ArrayList<String> words = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/words.txt"));
            String line = "";
            words = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }

            System.out.println(words.size());
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }


}
