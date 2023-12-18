package reverse;
//own, original O(N) implementation
public class Reverse {

	public static void main(String[] args) {
		int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		
		if(arr.length%2==0) {
			for(int i = arr.length-1; i>arr.length/2-1; i--) {
				int tmp = arr[i];
				arr[i]=arr[arr.length-1-i];
				arr[arr.length-1-i]=tmp;
			}
			for(int items: arr) {
				System.out.println(items);
			}
		}
		else {
			for(int i = arr.length-1; i>arr.length/2; i--) {
				int tmp = arr[i];
				arr[i]=arr[arr.length-1-i];
				arr[arr.length-1-i]=tmp;
			}
			for(int items: arr) {
				System.out.println(items);
			}
		}
		
	}

}
