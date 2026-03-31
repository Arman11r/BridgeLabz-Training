class CountingSortAges {

    public static void main(String[] args) {

        // student ages between 10 to 18
        int[] ages = {12, 15, 10, 14, 18, 13, 15} ;

        int minAge = 10;
        int maxAge = 18;

        int[] count = new int[maxAge - minAge + 1];

        // counting frequency
        for (int age : ages) 
            {
            count[age - minAge] ++ ;
        }


        int index = 0;

        // building sorted array

        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0) 
                {

                ages[index++] = i + minAge;
                count[i]--;
            }
        }

        // printing sorted ages
        for (int value : ages) {
            System.out.print(value + " ");
        }
    }
}