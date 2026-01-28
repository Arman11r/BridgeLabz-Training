import java.util.*;
public class LexicalTwist {



    public static String reversed(String one,String two){
            StringBuilder oneBuilder = new StringBuilder(one);
            StringBuilder twoBuilder = new StringBuilder(two);
            for (int i = 0; i < one.length(); i++) {
                if(one.charAt(i)=='a' || one.charAt(i)=='e' || one.charAt(i)=='i' || one.charAt(i)=='o' || one.charAt(i)=='u' ||
                   one.charAt(i)=='A' || one.charAt(i)=='E' || one.charAt(i)=='I' || one.charAt(i)=='O' || one.charAt(i)=='U') {
                    oneBuilder.setCharAt(i, '@');
                }
                
            }

            return oneBuilder.reverse().toString().toLowerCase();
        }

    public static String notreversed(String str){
        StringBuilder sb = new StringBuilder(str);
        StringBuilder helper = new StringBuilder();
        StringBuilder secondhelper = new StringBuilder();
        sb.toString().toUpperCase();
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count+=1;
                helper.append(c);
            }
            else{
                secondhelper.append(c);
            }
            

        }
        if(sb.length()/2 <  count ){
            return helper.substring(0, Math.min(2, helper.length())).toUpperCase();
        }
        else{
            return secondhelper.substring(0, Math.min(2, secondhelper.length())).toUpperCase();
        }

    }
    
    




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String one = sc.nextLine();
        String two = sc.nextLine();
        StringBuilder sb = new StringBuilder(one);
        StringBuilder sb2 = new StringBuilder(two);
        if(sb.toString().equals(sb2.reverse().toString())){
            String result = reversed(one, two);
            System.out.println(result);
        }
        
        else{
            String result = notreversed(one + two);
            System.out.println(result);
        }
        sc.close();
    }

    
        
    }

