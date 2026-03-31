class SpringSeason {

    public static void main(String[] args) {

        

        // Convert command line arguments to integers
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Variable to store spring season result
        boolean isSpringSeason;

        // Check valid date range and spring season condition
        isSpringSeason =
                (month == 3 && day >= 20 && day <= 31) ||
                (month == 4 && day >= 1 && day <= 30) ||
                (month == 5 && day >= 1 && day <= 31) ||
                (month == 6 && day >= 1 && day <= 20);

        // Display resulthere
        if (isSpringSeason) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}