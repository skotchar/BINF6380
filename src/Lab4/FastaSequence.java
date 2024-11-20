package Lab4;

import java.io.*;
import java.util.*;

public class FastaSequence {
    private String header;
    private String sequence;


    public FastaSequence(String header, String sequence) {
        this.header = header;
        this.sequence = sequence;
    }
    public String getHeader() {
        return header;
    }

    public String getSequence() {
        return sequence; 
    }

    public float getGCRatio() {  
        int gc = 0;
        String sequence = getSequence();
        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (c == 'G' || c == 'C') {
                gc++;
            }
        }
        return (float) gc / sequence.length();
    }

    
    public static List<FastaSequence> readFastaFile(String filepath) throws Exception {
        List<FastaSequence> fastaList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filepath));

        String header = null;
        String sequence = ""; 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith(">")) {
                if (header != null) {
                    fastaList.add(new FastaSequence(header, sequence));
                }
                header = line.substring(1).trim(); 
                sequence = ""; 
            } else {
                sequence += line.trim();
            }
        }
        if (header != null) {
            fastaList.add(new FastaSequence(header, sequence));
        }

        scanner.close();
        return fastaList;
    }

    private static int numBases(String sequence, char base) {
        int count = 0;
        for (char c : sequence.toCharArray()) {
            if (c == base) {
                count++;
            }
        }
        return count;
    }
    
    public static void writeTableSummary(List<FastaSequence> list, File outputFile) throws Exception {BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        writer.write("sequenceID\tnumA\tnumC\tnumG\tnumT\tsequence\n");

        for (FastaSequence fs : list) {
            String sequence = fs.getSequence();
            int numA = numBases(sequence, 'A');
            int numC = numBases(sequence, 'C');
            int numG = numBases(sequence, 'G');
            int numT = numBases(sequence, 'T');

            writer.write(String.format("%s\t%d\t%d\t%d\t%d\t%s\n", fs.getHeader(), numA, numC, numG, numT, sequence));
        }

        writer.close();
    }
    
    
    
    
    
    
    
    public static void main(String[] args) throws Exception
    {
         List<FastaSequence> fastaList = FastaSequence.readFastaFile("/Users/saiber/git/BINFProgramming/src/Lab4/test.fasta");
         for( FastaSequence fs : fastaList){
             System.out.println(fs.getHeader());
             System.out.println(fs.getSequence());
             System.out.println(fs.getGCRatio());
          }
         File myFile = new File("/Users/saiber/git/BINFProgramming/src/Lab4/newfile.txt");
         writeTableSummary( fastaList,  myFile);
    }

}