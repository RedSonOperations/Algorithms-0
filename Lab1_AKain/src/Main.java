import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static Stack stack = new Stack(6);

    public static void main(String[] args) {
        String filePath = "/Users/aleckain/java-projects/Lab1_AKain/input-files/Required Input-1.txt";
        String filePath2 = "/Users/aleckain/java-projects/Lab1_AKain/input-files/Additional_Input_AlecKain_Lab1.txt";
        // File I/O, reading in each non-null line as an input
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Check if the lines contain errors or provide context
            	if (line.contains(" ")) {
                    System.out.println("Error! Invalid prefix expression (contains spaces): " + line);
                } 
                else if (line.matches(".*\\d.*")) {
                    // The line contains at least one digit
                    System.out.println("Error! Invalid prefix expression (contains a digit, not a proper character operand): " + line);
                }
                else {
                    PrefixToPostfixConversion(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filePath2))) {
            String line;
            while ((line = br.readLine()) != null) {
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
                    PrefixToPostfixConversion(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Prefix to Post-fix Conversion Algorithm, O(N) time complexity
    private static void PrefixToPostfixConversion(String input) {
        char[] operators = {'+', '-', '*', '/', '$', '*', '%', '^'};
        
        if (input.length() == 0) {
            throw new IllegalStateException("Cannot perform a prefix to postfix conversion on an empty string!");
        } 
        else {
            for (int i = input.length() - 1; i > -1; i--) {
                char current = input.charAt(i);
                boolean isOperator = false;

                // Check if current is any of the operators
                for (char operator : operators) {
                    if (current == operator) {
                        isOperator = true;
                        break; // Break the loop once an operator is found
                    }
                }

                // Push operand to stack
                if (!isOperator) {
                    stack.push(current);
                } else {
                    // Check if the stack has at least 2 elements before popping
                    if (stack.getLength() >= 2) {
                        stack.push(stack.pop().toString() + stack.pop().toString() + current);
                    } else {
                        System.out.println("Error! Invalid prefix expression (stack has less than two elements before popping): " + input);
                        stack.clear();
                        return; // Skip further processing for this input
                    }
                }
            }
            // If the stack's remaining size is 1, output the post-fix expression. If not, the prefix expression is invalid.
            if (stack.getLength() == 1) {
                System.out.println("Input: " + input + "\tOutput: " + stack.peek());
            } else {
                System.out.println("Error! Invalid prefix expression (final stack size not equal to 1): " + input);
            }
            stack.clear();
        }
    }
}
