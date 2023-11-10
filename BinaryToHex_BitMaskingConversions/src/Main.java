/**
 * Main - The main java class that utilizes classes 'BinaryToHex' and 'toUpperLower' in order to convert a user-input binary 
 * number to hexadecimal format, and to convert uppercase letters to lowercase letters and vice versa (user-input letters), 
 * respectively.
 * 
 * Author: Alec Kain
 *
 * This class uses methods that inherit properties from the aforementioned classes in order to perform necessary calculations
 * and output solutions. 
 * 
 * method printLowerToUpper() requests a lowercase letter from the user and returns the uppercase version of it leveraging 
 * its class method 'toUpper()', which accepts the lowercase letter as its argument. 
 * 
 * method printUpperToLower() does the same thing, but vice versa (in reverse - from uppercase to lowercase), and leverages
 * its class method 'toLower()', which accepts the uppercase letter as its argument.
 * 
 * method printBin2Hex() requests a binary string from the user and returns its hexadecimal conversion. It leverages its
 * class method 'bin2Hex()', which accepts the binary number as its argument.
 * 
 */

import java.util.*;
public class Main {
	
	
	public static void main(String[] args) {
		printBin2Hex();
		printLowerToUpper();
		printUpperToLower();
	}
	
	public static void printBin2Hex() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a binary number to convert to hex: ");
		String binaryNumber = input.next();
		
		BinaryToHex bin2Hex = new BinaryToHex(binaryNumber);
		String hexVal=bin2Hex.bin2Hex(binaryNumber);
		
		System.out.println(hexVal);
	}
	
	public static void printLowerToUpper() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What lowercase letter would you like to convert to uppercase?: ");
		char letter = input.next().charAt(0);
		
		toUpperLower lowerLetter = new toUpperLower(letter);
		String upperLetter = lowerLetter.toUpper(letter);
		
		System.out.println(upperLetter);
	}
	
	public static void printUpperToLower() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What uppercase letter would you like to convert to lowercase?: ");
		char letter = input.next().charAt(0);
		
		toUpperLower upperLetter = new toUpperLower(letter);
		String lowerLetter = upperLetter.toLower(letter);
		
		System.out.println(lowerLetter);
	}

}
