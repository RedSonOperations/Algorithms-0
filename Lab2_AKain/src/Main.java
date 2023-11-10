import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filePath = "/Users/aleckain/java-projects/Lab2_AKain/input-files/Required Input-1.txt";
        String filePath2 = "/Users/aleckain/java-projects/Lab2_AKain/input-files/Additional_Input_AlecKain_Lab1.txt";
        // File I/O, reading in each non-null line as an input
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            	int numOperators=numOperators(line, 0);
            	int numOperands=numOperands(line, 0);
            	// Check if the lines contain errors or provide context
            	if (line.contains(" ")) {
                    System.out.println("Error! Invalid prefix expression (contains spaces): " + line);
                } 
                else if (line.matches(".*\\d.*")) {
                    // The line contains at least one digit
                    System.out.println("Error! Invalid prefix expression (contains a digit, not a proper character operand): " + line);
                }
                else {
                	if(numOperators==numOperands-1) {
                		System.out.println("Input: "+line+"\tOutput: "+PrefixToPostfixConversion(line)); 
                	}
                	else if(numOperators==numOperands) {
                		System.out.println("Error! Invalid prefix expression (stack has less than two elements before popping): " + line);
                	}
                	else {
                		System.out.println("Error! Invalid prefix expression (final stack size not equal to 1): "+line);
                	}
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
            String line;
            while ((line = br.readLine()) != null) {
            	int numOperators=numOperators(line, 0);
            	int numOperands=numOperands(line, 0);
            	// Check if the lines contain errors or provide context
            	if (line.contains("Additional Test Cases provided by Alec Kain:")) {
            		System.out.println("Additional Test Cases provided by Alec Kain:");
            	}
                else if (line.contains(" ")) {
                    System.out.println("Error! Invalid prefix expression (contains spaces): " + line);
                } 
                else if (line.matches(".*\\d.*")) {
                    // The line contains at least one digit
                    System.out.println("Error! Invalid prefix expression (contains a digit, not a proper character operand): " + line);
                }
                else {
                	if(numOperators==numOperands-1) {
                		System.out.println("Input: "+line+"\tOutput: "+PrefixToPostfixConversion(line)); 
                	}
                	else if(numOperators==numOperands) {
                		System.out.println("Error! Invalid prefix expression (stack has less than two elements before popping): " + line);
                	}
                	else {
                		System.out.println("Error! Invalid prefix expression (final stack size not equal to 1): "+line);
                	}
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String PrefixToPostfixConversion(String input) {
        char[] operators = {'+', '-', '*', '/', '$', '*', '%', '^'};
        
        if (input.isEmpty()) {
            return "";
        }
        
        char current = input.charAt(0);
        boolean isOperator = false;

        // Check if current is any of the operators
        for (char operator : operators) {
            if (current == operator) {
                isOperator = true;
                break;
            }
        }

        // If it's an operand, return it
        if (!isOperator) {
            return String.valueOf(current);
        } 
        else {
        	
            // Recursively convert the sub-expressions
            String left = PrefixToPostfixConversion(input.substring(1));
            String right = PrefixToPostfixConversion(input.substring(left.length() + 1));
            return left + right + current;
        }
        
        
    }
    
    private static int numOperators(String input, int operatorCount) {
        for(int i=0; i<input.length(); i++) {
        	char current = input.charAt(i);
        	if(current=='+'||current=='-'||current=='*'||current=='/'||current=='$'||current=='*'||current=='%'||current=='^') {
        		operatorCount+=1;
        	}
        }
    	return operatorCount;
    }
    private static int numOperands(String input, int operatorCount) {
        for(int i=0; i<input.length(); i++) {
        	char current = input.charAt(i);
        	if(current!='+'&&current!='-'&&current!='*'&&current!='/'&&current!='$'&&current!='*'&&current!='%'&&current!='^') {
        		operatorCount+=1;
        	}
        }
    	return operatorCount;
    }
}

