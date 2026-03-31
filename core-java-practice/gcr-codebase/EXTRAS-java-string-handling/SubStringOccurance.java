import java.util.Scanner;

class SubStringOccurance {

    public static void main(String[] args) {

        // scanner for taking input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String mainText = sc.nextLine();

        System.out.print("Enter substring to count: ");
        String subText = sc.nextLine();

        int count = 0;
        int index = 0;

        // loop till substring not found
        while (true) {

            // finding position of substring from current index
            
            index = mainText.indexOf(subText, index);

            // if substring not found then stop
            if (index == -1)
                 {
                break;
            }

            // substring found so increase count
            count++;

            // moving index forward to avoid same match
            index = index + subText.length();
        }

        // printing final count

        System.out.println("Occurrences. : " + count);

        sc.close();
    }
}