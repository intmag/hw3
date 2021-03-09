import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int GUESSNUMSIZE = 9;
        playGuessNumber(GUESSNUMSIZE);
        playGuessWord();

    }

    private static void playGuessNumber(int size) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        boolean success = false;
        int hiddenNumber = random.nextInt(size + 1);
        System.out.println("Я загадал число, попробуйте его угадать");
        for (int i = 0; i < 3; i++) {
            System.out.print("Введите число: ");
            while (!sc.hasNextInt()) {
                System.out.println("Это не число!");
                System.out.print("Введите число: ");
                sc.next();
            }
            int num = sc.nextInt();
            if (num > hiddenNumber) {
                System.out.println("Введенное число больше загаданного.");
            }
            if (num < hiddenNumber) {
                System.out.println("Введенное число  меньше загаданного.");
            }
            if (num == hiddenNumber) {
                System.out.println("Вы угадали!");
                success = true;
                break;
            }
        }
        if (!success) {
            System.out.println("\nК сожалению вы не смогли угадать число за 3 попытки :(\nЧисло, которое задал компьютер: " + hiddenNumber);
        }
        sc.close();
    }

    private static void playGuessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int hiddenWordNum = random.nextInt(words.length);
        int winChars = 0;
        //System.out.println(words[hiddenWordNum]);
        boolean success = false;
        System.out.println("Компьютер загадал фрукт или овощь, попробуй его отгадать");
        Scanner sc = new Scanner(System.in);
        char[] letters = new char[15];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = '#';
        }
        while (!success) {
            System.out.println("Введите слово");
            String entred = sc.next();
            for (int i = 0; i < entred.length(); i++) {
                for (int j = 0; j < words[hiddenWordNum].length(); j++) {
                    if (entred.charAt(i) == words[hiddenWordNum].charAt(j) && letters[j] == '#') {
                        letters[j] = entred.charAt(i);
                        if (++winChars == words[hiddenWordNum].length()) {
                            success = true;
                            System.out.println("Поздравляю!!! Вы победили!");
                        }
                    }
                }
            }
            System.out.println(letters);
        }
        sc.close();
    }

}
