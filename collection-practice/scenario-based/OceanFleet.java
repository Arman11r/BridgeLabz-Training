import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vessel {

    private String vesselid;
    private String vesselname;
    private double averagespeed;
    private String vesseltype;

    public Vessel(String vesselid, String vesselname, double averagespeed, String vesseltype) {
        this.vesselid = vesselid;
        this.vesselname = vesselname;
        this.averagespeed = averagespeed;
        this.vesseltype = vesseltype;
    }

    public String getVesselid() {
        return vesselid;
    }

    public String getVesselname() {
        return vesselname;
    }

    public double getAveragespeed() {
        return averagespeed;
    }

    public String getVesseltype() {
        return vesseltype;
    }
}


class VesselUtil {

    // ✅ initialize list
    private List<Vessel> vesselList = new ArrayList<>();

    public Vessel getVesselbyid(String id) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselid().equals(id)) {
                return vessel;
            }
        }
        return null;
    }


    public void addvesselpreformace(Vessel vessel){
        vesselList.add(vessel);
    }

    public List<Vessel> getHighPreformanceVessels(){

        List<Vessel> highPerfVessels = new ArrayList<>();
        double max = 0;

        for (Vessel vess : vesselList) {
            max = Math.max(max, vess.getAveragespeed());
        }

        for (Vessel vessel : vesselList) {
            if (vessel.getAveragespeed() == max) {
                highPerfVessels.add(vessel);
            }
        }

        return highPerfVessels;
    }
}



public class OceanFleet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

      
        VesselUtil vesselUtil = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String input = sc.nextLine();
            String[] details = input.split(":");

            Vessel vessel =
                    new Vessel(details[0], details[1],
                            Double.parseDouble(details[2]), details[3]);

          
            vesselUtil.addvesselpreformace(vessel);
        }

         System.out.print("Enter Vessel ID to check speed: ");
				String id = sc.nextLine();

				Vessel vessel = vesselUtil.getVesselbyid(id);
				if (vessel != null) {
					System.out.println(vessel.getVesselid() + "|" + vessel.getVesselname() + "|"
							+ vessel.getVesseltype() + "|" + vessel.getAveragespeed() + " knots");
				} else {
					System.out.println("Vessel not found.");
				}

        System.out.println("High Performance Vessels:");

        List<Vessel> highPerfVessels = vesselUtil.getHighPreformanceVessels();

        for (Vessel vessell : highPerfVessels) {
            System.out.println(
                    vessell.getVesselid() + " "
                    + vessell.getVesselname() + " "
                    + vessell.getAveragespeed() + " "
                    + vessell.getVesseltype());
        }

        sc.close();
    }
}