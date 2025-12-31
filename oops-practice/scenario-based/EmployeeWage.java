class EmployeeWage {

    // constant values
    static final int ABSENT = 0;
    static final int PART_TIME = 1;
    static final int FULL_TIME = 2;
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOUR = 8;
    static final int PART_TIME_HOUR = 4;
    static final int WORKING_DAYS = 20;
    static final int TOT_WORKING_HOURS = 100;

    // instance variables
    int totalWage = 0;
    int totalHours = 0;
    int totalDays = 0;

    // checking employee attendance
    public int Attendance() {

        // random value for attendance
        int attendance = (int) (Math.random() * 3);
        return attendance;
    }

    // calculating daily wage
    public int calculateDailyWage() {

        int hours = 0;
          int empType = Attendance();
        // deciding work hours
        switch (empType) {

            case FULL_TIME:
                hours = FULL_DAY_HOUR;
                break;

            case PART_TIME:
                hours = PART_TIME_HOUR;
                break;

            default:
                hours = 0;
        }

        // returning daily wage
        return hours * WAGE_PER_HOUR;
    }

    // calculating monthly wage
    public void calculateMonthlyWage() {

        // loop for month
        while (totalHours < TOT_WORKING_HOURS && totalDays < WORKING_DAYS) {

            totalDays++;

            // check attendance
            int empType = Attendance();

            int dailyHours = 0;

            // setting hours based on type
            switch (empType) {

                case FULL_TIME:
                    dailyHours = FULL_DAY_HOUR;
                    break;

                case PART_TIME:
                    dailyHours = PART_TIME_HOUR;
                    break;

                default:
                    dailyHours = 0;
            }

            // adding daily values
            totalHours = totalHours + dailyHours;
            totalWage = totalWage + (dailyHours * WAGE_PER_HOUR);
        }
    }


    public void displayResult() {

        System.out.println("tot working day: " + totalDays);
        System.out.println("total working hour : " + totalHours);
        System.out.println("total monthly wages:  " + totalWage);
    }

    // main method
    public static void main(String[] args) {

        System.out.println("welcome to employee wage computation program!!");

       
        EmployeeWage emp = new EmployeeWage();

        // calculate wage
        emp.calculateMonthlyWage();
        emp.calculateDailyWage();
        emp.Attendance ();
        

        // display final output

        emp.displayResult();
    }
}