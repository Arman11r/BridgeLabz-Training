import java.util.Scanner;
public class ExpressionTagScoring {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	sc.nextLine();
	for(int j=0;j<n;j++) {
		String line = sc.nextLine();
	while(line.contains("[")) {
		int start = line.indexOf("[");
		int end = line.indexOf("]");
		if(end == -1 || end < start) {
			line = line.substring(0, start) + "ERROR";
			break;
		}
		String aa = line.substring(start+1,end);
		String ch = check(aa);
		if(ch.equals("ERROR")) {
			line = line.substring(0, start) + "ERROR";
			break;
		}
		String a = line.substring(start+1,end);
		String[] split = a.split(":",2);
		String[] s = split[1].split(",");
		
		if(split[0].equals("SUM")) {
			String check = check(line);
			if(check.equals("ERROR")) {
				line = line.substring(0, start) + "ERROR";
			}
			int sum=0;
			for(int i=0;i<s.length;i++) {
				sum+=Integer.parseInt(s[i]);	
			}
			line = line.substring(0, start) + sum + line.substring(end + 1);
		}
		else if(split[0].equals("MUL")) {
			String check = check(line);
			if(check.equals("ERROR")) {
				line = line.substring(0, start) + check + line.substring(end + 1);
			}
			int product=1;
			for(int i=0;i<s.length;i++) {
				product*=Integer.parseInt(s[i]);	
			}
			line = line.substring(0, start) + product + line.substring(end + 1);
		}
		else if(split[0].equals("MAX")) {
			String check = check(line);
			if(check.equals("ERROR")) {
				line = line.substring(0, start) + check + line.substring(end + 1);
			}
			int max=0;
			for(int i=0;i<s.length;i++) {
				if(max<Integer.parseInt(s[i])) {
					max = Integer.parseInt(s[i]);
				}				
			}
			line = line.substring(0, start) + max + line.substring(end + 1);
		}
		else if(split[0].equals("MIN")) {

			String check = check(line);
			if(check.equals("ERROR")) {
				line = line.substring(0, start) + check + line.substring(end + 1);
			}
			int min=Integer.MAX_VALUE;
			for(int i=0;i<s.length;i++) {
				if(min>Integer.parseInt(s[i])) {
					min = Integer.parseInt(s[i]);
				}
			}
			line = line.substring(0, start) + min + line.substring(end + 1);
		}
	
	}
	System.out.println(line);
	}
	}
	public static String check(String a){
	    if(!a.contains(":")) return "ERROR";
	    String[] split = a.split(":",2);
	    String[] s = split[1].split(",");
	    for(int i=0;i<s.length;i++) {
	        if(s[i].length() > 1 && s[i].startsWith("0")) {
	            return "ERROR";
	        }
	    }
	    return "OK";
	}
	}