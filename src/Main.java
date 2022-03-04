import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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


        String guess = "";
        String word = words.get((int)(Math.random() * words.size()));
        word = words.get(3);
        int letters = word.length();
        String[] lettersGuessed = new String[word.length()];
        boolean found = false;
        //P I C H A
        //_ _ _ _ _
        //_ _ _ H _

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < lettersGuessed.length; i++) {
            if (word.charAt(i) == ' ') {
                lettersGuessed[i] = " ";
                letters--;
            } else if (word.charAt(i) == '-'){
                lettersGuessed[i] = "-";
                letters--;
            } else {
                lettersGuessed[i] = "_";
            }
        }

        System.out.println();


        while (letters != 0) {
            found = false;

            for (int i = 0; i < lettersGuessed.length; i++) {
                System.out.print(lettersGuessed[i] + " ");
            }
            System.out.println();

            guess = scanner.nextLine();
            if (guess.equals(null) || guess.equals("")) {
                continue;
            }

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
                    for (int i = 0; i < lettersGuessed.length; i++) {
                        if (word.charAt(i) == guess.charAt(0)) {
                            lettersGuessed[i] = guess;
                            letters--;
                        }
                    }
                }
            }
        }

        System.out.println(word);
    }


}
