import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    private static final String OUTPUT_PATH = "C:\\Users\\alecm\\Documents\\java-projects\\Lab4_AKain\\output-files\\";

	public static void main(String[] args) {
		int [] ord_50 = new int[50];
		int [] ord_1000 = new int[1000];
		int [] ord_2000 = new int[2000];
		int [] ord_5000 = new int[5000];
		int [] ord_10000 = new int[10000];
		int [] rev_ord_50 = new int[50];
		int [] rev_ord_1000 = new int[1000];
		int [] rev_ord_2000 = new int[2000];
		int [] rev_ord_5000 = new int[5000];
		int [] rev_ord_10000 = new int[10000];
		int [] rand_ord_50 = new int[50];
		int [] rand_ord_1000 = new int[1000];
		int [] rand_ord_2000 = new int[2000];
		int [] rand_ord_5000 = new int[5000];
		int [] rand_ord_10000 = new int[10000];
		
		String[] fileNames = {"ord_50.txt", "ord_1000.txt", "ord_2000.txt", "ord_5000.txt", "ord_10000.txt",
                "rev_ord_50.txt", "rev_ord_1000.txt", "rev_ord_2000.txt", "rev_ord_5000.txt", "rev_ord_10000.txt",
                "rand_ord_50.txt", "rand_ord_1000.txt", "rand_ord_2000.txt", "rand_ord_5000.txt", "rand_ord_10000.txt"};

		int[][] arrays = {ord_50, ord_1000, ord_2000, ord_5000, ord_10000,
		            rev_ord_50, rev_ord_1000, rev_ord_2000, rev_ord_5000, rev_ord_10000,
		            rand_ord_50, rand_ord_1000, rand_ord_2000, rand_ord_5000, rand_ord_10000};
		
		String filePath = "C:\\Users\\alecm\\Documents\\java-projects\\Lab4_AKain\\input-files\\";
		
		//read in each of 15 files in filePath
		//places values from each file into respective, name-matching array
		try {
		for (int i = 0; i < fileNames.length; i++) {
		  BufferedReader reader = new BufferedReader(new FileReader(filePath + fileNames[i]));
		  String line = reader.readLine();
		  String[] numbers = line.split(" ");
		  for (int j = 0; j < numbers.length; j++) {
		      arrays[i][j] = Integer.parseInt(numbers[j]);
		  }
		  reader.close();
		}
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		sortAllArrays(arrays, fileNames);
        	
	}
	//arrays sorted and results written to file
	private static void sortAllArrays(int[][] arrays, String[] fileNames) {
        for (int i = 0; i < arrays.length; i++) {
        	int [] clone1=arrays[i].clone();
        	int subStringIdx=fileNames[i].indexOf("x")-2;
        	String msg="";
            System.out.println("Array " + fileNames[i].substring(0, subStringIdx));
            
        	msg+=QuickSort.quickSortFirstPivot(clone1) + "\n";

            int [] clone2=arrays[i].clone();
            msg+=QuickSort.quickSortInsertion100(clone2) + "\n";

            int [] clone3=arrays[i].clone();
            msg+=QuickSort.quickSortInsertion50(clone3) + "\n";

            int [] clone4=arrays[i].clone();
            msg+=QuickSort.quickSortMedianOfThree(clone4) + "\n";
            
            int [] clone5=arrays[i].clone();
            msg+=MergeSort.sort(clone5) + "\n";

            writeToFile(fileNames[i], msg);

        }
    }
	//writes to output file
	private static void writeToFile(String fileName, String data) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_PATH + fileName, true))) {
	        writer.write(data + "\n\n");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
	
	