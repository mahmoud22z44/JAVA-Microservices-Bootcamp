package pck03;

public class Q1_Q2_Q17_Q18_Q19 {

	public static void main(String[] args) {
		// question 1
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World");
//------------------------------------------------------------
		// question 2
		int i = 0;
//		for loop
//		incremental loop
		for (i = 0; i < 10; i++) {
			System.out.println("Hello World");
		}
//		decremental loop
		for (i = 10; i > 0; i--) {
			System.out.println("Hello World");
		}
//		while loop
//		incremental loop
		i = 0;
		while (i++ < 10) {
			System.out.println("Hello World");
		}
//		decremental loop
		i = 10;
		while (i-- > 0) {
			System.out.println("Hello World");
		}
//------------------------------------------------------		
//		Question17
		char[] arr = { 'a', 'b', 'c', 'a', 'b', 'd', 'r', 'c' };
		int counterOfa = 0;
		int counterOfc = 0;
		for (i = 0; i < arr.length; i++) {
			if ('a' == arr[i]) {
				counterOfa++;
			}
			if ('c' == arr[i]) {
				counterOfc++;
			}
		}
		System.out.println("How many ‘a’ char inside the array? " + counterOfa);
		System.out.println("How many ‘a’ or 'c' char inside the array? " + (counterOfa + counterOfc));
//---------------------------------------------------------------------
//		Question18
		String name = "John Bryce";
		int counter = 0;
		char[] namePerson = name.toCharArray();
		for (i = 0; i < namePerson.length; i++) {
			if (namePerson[i] == 'h') {
				counter++;
			}
		}
		System.out.println("How many ‘h’ letters inside the string? " + counter);

//------------------------------------------------------------------
//Question19
		String str = "Sara Shara Shir Cameach";
		char[] text = str.toCharArray();
		int countLetter = 0;
		for (i = 0; i < text.length; i++) {
			if (text[i] == 'a' || text[i] == 'e'|| text[i] == 'i'|| text[i] == 'o'|| text[i] == 'u') {
				countLetter++;
			}
		}
		System.out.println("How many Vowels (A,E,I,O,U) letters inside the string? "+countLetter);
	}
}
