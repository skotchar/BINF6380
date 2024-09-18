package Lab2;
import java.util.Random;

//This code is chatgpt for comparing 
public class test {
    public static String[] SHORT_NAMES = { "A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V" };
    public static String[] FULL_NAMES = { "alanine", "arginine", "asparagine", "aspartic acid", "cysteine", "glutamine", "glutamic acid", "glycine", "histidine", "isoleucine", "leucine", "lysine", "methionine", "phenylalanine", "proline", "serine", "threonine", "tryptophan", "tyrosine", "valine" };

    public static void main(String[] args) {
        Random rand = new Random();
        int score = 0;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 30000;  // 30 seconds timer

        while (System.currentTimeMillis() < endTime) {
            int randomIndex = rand.nextInt(FULL_NAMES.length);
            System.out.println("What is the one-letter code for: " + FULL_NAMES[randomIndex]);
            
            String userInput = System.console().readLine().toUpperCase();
            if (userInput.equals(SHORT_NAMES[randomIndex])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong answer! The quiz is over.");
                break;
            }
        }

        System.out.println("Your score: " + score);
    }
}
