package Lab2;

import java.util.Random;

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
        long timeElapsed = (System.currentTimeMillis() - startTime)/1000;
        
        //while loop for quiz
        while(timeElapsed < 30) {
        	
        	//Create random number to get random amino acid
    		Random random = new Random();
            int randomNumber = random.nextInt(shortName.length); // Generates a number between 1 and 20
            String question = fullName[randomNumber];
            String answer = shortName[randomNumber];
            System.out.println(answer);
            
        	//Ask Question
            System.out.println("What is the abbreviation for " + question + "?");
    		String aString = System.console().readLine().toUpperCase();
    		
    		if (aString.equals(answer)) {
    			score++;
    			System.out.println("right. Score:" + score + " seconds=" + (System.currentTimeMillis())/1000);
    			
    		} else {
    			System.out.println("WRONG should be " + answer);
    			timeElapsed = 30;
    		}
    	    
        }
        
		//Final Output
		System.out.println("~ Test ends with score of: "+ score + " ~");

		
	}
} 