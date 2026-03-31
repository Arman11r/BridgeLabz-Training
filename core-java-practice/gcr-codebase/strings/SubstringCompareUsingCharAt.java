import java.util.Scanner;

public class SubstringCompareUsingCharAt {
    // create substring using charAt
	static String makeSubstringCharAt(String text , int start , int end)
	{
		String sub = "";
		int i = start;
		while(i < end)
		{
			char ch = text.charAt(i);
			sub = sub + ch;
			i++;
		}
		return sub;
	}
    // compare two strings using charAt
	static boolean compareUsingCharAt(String a , String b)
	{
		if(a.length() != b.length())
			return false;

		int i=0;
		for(  ; i < a.length(); i++)
		{
			char c1 = a.charAt(i);
			char c2 = b.charAt(i);
			if(c1 != c2)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
        //variable
		String text = "";

		int start = 0;
		int end = 0;
            //syso for input
		System.out.print("enter text: ");
		text = sc.next();

		System.out.print("enter start index: ");
		start = sc.nextInt();

		System.out.print("enter end index: ");
		end = sc.nextInt();
        // getting length of text
		int len = text.length();
		// if index wrong ask again little
		while(start < 0 || start >= len)

		{   // syso for invalid start
			System.out.print("start index invalid, enter again: ");
			start = sc.nextInt();
		}
		while(end < start || end > len)
		{   // syso for invalid end
			System.out.print("end index invalid, enter again: ");
			end = sc.nextInt();
		}
        // getting substring by both methods
		String sub1 = makeSubstringCharAt(text , start , end);
		String sub2 = text.substring(start , end);
            // comparing both substrings
		boolean sameSub = compareUsingCharAt(sub1 , sub2);
		System.out.println("substring by charAt: " + sub1);

		 System.out.println("substring by substring(): " + sub2);
		System.out.println("both substring same: " + sameSub);
        //sc close
		sc.close();
	}
}
