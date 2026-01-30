import java.util.*;



public class RobotHazardAuditor {

    
    static class RobotSafetyException extends Exception {

        public RobotSafetyException(String msg) {
            super(msg);
        }
    }

//calculate hazard risk here
   
    public double CalculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      String machineryState)
            throws RobotSafetyException {


        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    " must be 0.0-1.0"
            );
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    " density must be 1-20"
            );
        }

        double machineRiskFactor;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        }
        else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        }
        else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        }
        else {
            throw new RobotSafetyException(
                    "Unsupported machinery state"
            );
        }




        double risk =
                ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);

        return risk;
    }



    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter Arm Precision(0.0 - 1.0):");
            double precision = sc.nextDouble();

            System.out.println("Enter Worker Density(1 - 20):");
            int density = sc.nextInt();

        sc.nextLine(); 

            System.out.println("Enter Machinery State(Worn/Faulty/Critical):");
            String state = sc.nextLine();


            RobotHazardAuditor auditor = new RobotHazardAuditor();

            double score =
                    auditor.CalculateHazardRisk(precision, density, state);

            System.out.println("Robot Hazard Risk Score: " + score);

        }
        catch (RobotSafetyException e) {

            System.out.println(e.getMessage());
        }
        catch (Exception e) {

            System.out.println("Unexpected error occurred");
        }

        sc.close();
    }
}