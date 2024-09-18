package Lab2;

import java.util.Random;
import java.util.Scanner;

public class Lab2 {
	public static void main(String[] args) {
		//Amino Acids
		String[] shortName = 
			{ "A","R", "N", "D", "C", "Q", "E", 
			"G",  "H", "I", "L", "K", "M", "F", 
			"P", "S", "T", "W", "Y", "V" };
		
		String[] fullName = 
			{"alanine","arginine", "asparagine", 
			"aspartic acid", "cysteine",
			"glutamine",  "glutamic acid",
			"glycine" ,"histidine","isoleucine",
			"leucine",  "lysine", "methionine", 
			"phenylalanine", "proline", 
			"serine","threonine","tryptophan", 
			"tyrosine", "valine"};
		
		
        
        //System.out.println(answer);
        
        //Initialize score keeper and time
        int score = 0;
        long startTime = System.currentTimeMillis();
        
        System.out.println("Choose length of quiz in seconds: ");
        
        Scanner scan = new Scanner(System.in);
        int quizLen = scan.nextInt()*1000;
        
        //while loop for quiz
        while(System.currentTimeMillis() - startTime < quizLen) {
        	
        	//Create random number to get random amino acid
    		Random random = new Random(); 
            int randomNumber = random.nextInt(shortName.length); // Generates a number between 1 and 20
            String question = fullName[randomNumber];
            String answer = shortName[randomNumber];
            System.out.println(answer);
            
        	//Ask Question
            System.out.println("What is the abbreviation for " + question + "?");
            System.out.println("Enter quit to end quiz.");
            
    		String aString = System.console().readLine().toUpperCase();
    		
            double timeElapsed = (System.currentTimeMillis() - startTime) / 1000.0;

    		
    		if (aString.equals(answer)) {
    			score++;
    			System.out.println("right. Score:" + score + " seconds=" + timeElapsed);
    			
    		} else if(aString.equals("QUIT")) {
    			break;
    		} else {
    			System.out.println("WRONG should be " + answer);
    			break;
    		}
    		System.out.println();
    	    
        }
        
		//Final Output
		System.out.println("~ Test ends with score of: "+ score + " ~");

		
	}
} 