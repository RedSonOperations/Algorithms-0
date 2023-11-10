/**
 * toUpperLower - A Java class that provides methods to convert a character to its uppercase and lowercase forms.
 * Function 1 in assignment description.
 * Author: Alec Kain
 *
 * This class accepts a user-provided character as input and uses methods to convert it to its uppercase or lowercase form
 * based on bitwise operations (bit masking). It utilizes binary formatting of ASCII characters
 * to perform these conversions efficiently.
 */
public class toUpperLower {
	private char character;
	
	//constructor for initialization of character provided by user input in main function
	toUpperLower(char character){
		this.setCharacter(character);
	}
	
	/* Method toUpper() accepts a user-provided lowercase character as input and uses methods to convert it to its uppercase form
	 based on bitwise operations (bit masking). It utilizes binary formatting of ASCII characters
	 to perform these conversions efficiently.
	 */
	public String toUpper(char character) {
		String binaryString=Integer.toBinaryString(character);
		int binaryInt = Integer.parseInt(binaryString, 2);
		
		return Character.toString((char) (binaryInt&~0x20));
	}
	
	/* Method toLower() accepts a user-provided uppercase character as input and uses methods to convert it to its lowercase form
	 based on bitwise operations (bit masking). It utilizes binary formatting of ASCII characters
	 to perform these conversions efficiently.
	 */
	public String toLower(char character) {
		String binaryString=Integer.toBinaryString(character);
		int binaryInt = Integer.parseInt(binaryString, 2);
		
		return Character.toString((char) (binaryInt|0x20));
	}

	public char getCharacter() {
		return character;
	}

	public void setCharacter(char character) {
		this.character = character;
	}

}
