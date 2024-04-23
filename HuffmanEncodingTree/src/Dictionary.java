import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
	public Object [][] dictArr = new Object [26][2];
	
	public Dictionary(Object [][] dictArr) {
		this.dictArr=dictArr;
	}
	/*adds character as key and frequency of character in string as value for max 26 lines, 
	as there are 26 letters in the alphabet*/
	private void add(char key, int value, int i) {
		dictArr[i][0]=key;
		dictArr[i][1]=value;
	}
	//populates 26-index dictionary with character as the key and frequency as the value per dictionary index 
	//reads from parameter filePath, file is 'FreqTable-1.txt' downloaded from main project Canvas page
	public void populateFromFreqFile(String filePath) {
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        int i = 0;
	        while ((line = br.readLine()) != null && i < 26) {
	            String[] parts = line.split(" - ");
	            char letter = parts[0].charAt(0);
	            int frequency = Integer.parseInt(parts[1]);
	            Object[] pair = {letter, frequency};
	            dictArr[i] = pair;
	            i++;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void printDictionary() {
        for (Object[] pair : dictArr) {
            System.out.println("Letter: " + pair[0] + ", Frequency: " + pair[1]);
        }
    }
}
