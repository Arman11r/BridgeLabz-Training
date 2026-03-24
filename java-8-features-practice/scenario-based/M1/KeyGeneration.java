
import java.util.Scanner;

public class KeyGeneration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String regex = "^[a-zA-Z]{6,}$";
		int num = sc.nextInt();
		sc.nextLine();
		for(int j=0;j<num;j++) {
		String input = sc.nextLine();
		if (input.matches(regex)) {
			String inputlower = input.toLowerCase();
			StringBuilder sb = new StringBuilder(inputlower);
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < sb.length(); i++) {
				int ascii = sb.charAt(i);
				if (ascii % 2 == 0) {
					// System.out.println(sb.charAt(i));
					sb.deleteCharAt(i);
					i--;
				}
			}
			sb.reverse();
			String temp = sb.toString();
			String upper = sb.toString().toUpperCase();
			for (int i = 0; i < temp.length(); i++) {
				if (i % 2 == 0) {
					sb2.append(upper.charAt(i));
				} else {
					sb2.append(temp.charAt(i));
				}
			}
			System.out.println(sb2.toString());
		}

		else {
			System.out.println(isvalid(input));
		}
	}
	}
	
	public static String isvalid(String input) {
		String numreg = ".*\\d.*";
		String special = ".*\\W.*";
		if(input.length()<6) {
			return "Invalid Input (length < 6)";
		}
		else if(input.contains(" ")) {
			return "Invalid Input (contains space)";
		}
		else if(input.matches(numreg)){
			return "Invalid Input (contains digits)";
		}
		else if(input.matches(special)) {
			return "Invalid Input (contains special character)";
		}
		else if(input.isEmpty()){
			return "Invalid Input (empty string)";
		}
		else {
			return "i Dont know :(";
		}
		
	}

}

