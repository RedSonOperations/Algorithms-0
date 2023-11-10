/**
 * BinaryToHex - A Java class that converts a user-input binary string with 4 fractional bits into its respective hexadecimal value.
 * Function 2 in assignment description.
 * Author: Alec Kain
 *
 * This class takes a binary string as input and converts it into a hexadecimal string. It does this by splitting
 * the input binary string into groups of 4 bits each and then converting each group into its equivalent hexadecimal value.
 *
 * 
 */
public class BinaryToHex {
	private String binaryString;
	
	//constructor for initialization of binary string set by user input in main function
	BinaryToHex(String binaryString){
		this.setBinaryString(binaryString);
	}

	/*bin2Hex() takes a binary string as input and converts it into a hexadecimal string. It does this by splitting
	 the input binary string into groups of 4 bits each and then converting each group into its equivalent hexadecimal value.
	 */
	public String bin2Hex(String binString) {
	    String[] groupArr = new String[binString.length() / 4];
	    int[] hexArr = new int[binString.length() / 4];
	    char[] hexChars = new char[binString.length() / 4];
	    String hexString="0x";
	    
	    //separating the string into groups of 4, appending them to group array, groupArr
	    for (int i = 0; i < binString.length(); i += 4) {
	        groupArr[i / 4] = binString.substring(i, i + 4);
	    }
	    
	    //getting the decimal values of each of the groups, appending them to hex array, hexArr
	    for (int i = 0; i < groupArr.length; i++) {
	        int hex = 0;
	        
	        for (int j = 0; j < groupArr[i].length(); j++) {
	            if (groupArr[i].charAt(j) == '1') {
	                switch (j) {
	                    case 0:
	                        hex += 8;
	                        break;
	                    case 1:
	                        hex += 4;
	                        break;
	                    case 2:
	                        hex += 2;
	                        break;
	                    case 3:
	                        hex += 1;
	                        break;
	                }
	            }
	            hexArr[i] = hex;
	        }
	    }
	    
	    //converting each hex array value into respective hexadecimal value, appending to hexChars array
	    for (int i = 0; i<hexArr.length; i++) {
	        switch (hexArr[i]) {
			case 10:
				hexChars[i]='A';
				break;
			case 11:
				hexChars[i]='B';
				break;
			case 12:
				hexChars[i]='C';
				break;
			case 13:
				hexChars[i]='D';
				break;
			case 14:
				hexChars[i]='E';
				break;
			case 15:
				hexChars[i]='F';
				break;
			default:
				hexChars[i]=(char)(hexArr[i] + '0');
				break;
			}
	        
	    }
	    
	    for(char s : hexChars) {
	    	hexString+=s;
	    }
	    
	    return hexString;
	}


	public String getBinaryString() {
		return binaryString;
	}


	public void setBinaryString(String binaryString) {
		this.binaryString = binaryString;
	}
}
