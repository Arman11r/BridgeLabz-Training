class ZaraEmployeeBonus {

    // this method generate salary and years of service

    static double[][] generateEmployeeData() {
        // 2D array to hold salary and years of service

        double[][] data = new double[10][2];

        // loop for 10 employees

        for (int i = 0; i < 10; i++) {

            // generating random 5 digit salary
            data[i][0] = 10000 + (int)(Math.random() * 90000);


            // generating random years of service (1 to 10)

            data[i][1] = 1 + (int)(Math.random() * 10);
        }
        // returning generated data
        return data;
    }

    // this method calculate bonus and new salary
    static double[][] calculateBonus(double[][] oldData) {

        double[][] newData = new double[10][2];

        // loop for each employee
        for (int i = 0; i < 10; i++) {
            // getting old salary and years
            double salary = oldData[i][0];

            double years = oldData[i][1];
            double bonus;

            // checking years of service
            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }
            // calculating new salary
            double newSalary = salary + bonus;


            // storing new salary and bonus
            newData[i][0] = newSalary;
            newData[i][1] = bonus;
        }
        // returning new data
        return newData;
    }

    // this method calculate totals and display result

    static void calculateAndDisplayTotals(double[][] oldData,
                                          double[][] newData) {
                                            // totals initialization
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        // printing table heading
        System.out.println("OldSalary\tYears\tBonus\tNewSalary");

                                            // iterating through employees

        for (int i = 0; i < 10; i++) {
            // getting data
            double oldSalary = oldData[i][0];
            double years = oldData[i][1];
            double bonus = newData[i][1];

            double newSalary = newData[i][0];
            // updating totals

            totalOldSalary = totalOldSalary + oldSalary;

            totalNewSalary = totalNewSalary + newSalary;

            totalBonus = totalBonus + bonus;

            // printing employee data
            System.out.println(
                    oldSalary + "\t" +
                    years + "\t" +
                    bonus + "\t" +
                    newSalary
            );
        }

        // printing final totals
        System.out.println("\nTotal Old Salary: " + totalOldSalary);



        // printing total bonus
        System.out.println("Total Bonus Paid: " + totalBonus);


            // printing total new salary
        System.out.println("Total New Salary: " + totalNewSalary);

    }
    // main method



    public static void main(String[] args) {

        // getting random salary and years
        double[][] employeeData = generateEmployeeData();

        // calculating bonus and new salary


        double[][] updatedData = calculateBonus(employeeData);

        // calculating totals and printing
        calculateAndDisplayTotals(employeeData, updatedData);
    }



    // end of main method
}