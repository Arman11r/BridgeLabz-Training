import java.util.*;


class CreatorStats {

    public String creatorName;
    public double[] weeklyLikes;

    public static List<CreatorStats> engagementBoard = new ArrayList<>();

    public CreatorStats(String name, double[] likes) {
        this.creatorName = name;
        this.weeklyLikes = likes;
    }
}



public class StreamBuzzApp {


    public void registerCreator(CreatorStats record) {
        CreatorStats.engagementBoard.add(record);
        System.out.println("Creator registered successfully");
    }



    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {

        Map<String, Integer> result = new HashMap<>();

        for (CreatorStats c : records) {

            int count = 0;

            for (double like : c.weeklyLikes) {
                if (like >= likeThreshold)
                    count++;
            }

            if (count > 0) {
                result.put(c.creatorName, count);
            }
        }

        return result;
    }



    public double calculateAverageLikes() {

        double sum = 0;
        int total = 0;

        for (CreatorStats c : CreatorStats.engagementBoard) {
            for (double like : c.weeklyLikes) {
                sum += like;
                total++;
            }
        }

        if (total == 0) return 0;

        return sum / total;
    }


  
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StreamBuzzApp app = new StreamBuzzApp();

        while (true) {

            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] likes = new double[4];

                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }

                    CreatorStats creator = new CreatorStats(name, likes);
                    app.registerCreator(creator);
                    break;


                case 2:
                    System.out.print("Enterlike threshold: ");
                    double threshold = sc.nextDouble();

                    Map<String, Integer> result =
                            app.getTopPostCounts(CreatorStats.engagementBoard, threshold);

                    if (result.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (String key : result.keySet()) {
                            System.out.println(key + " - " + result.get(key));
                        }
                    }
                    break;


                case 3:
                    double avg = app.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + avg);
                    break;


                case 4:
                    System.out.println("Logging offKeep Creating with StreamBuzz!");
                    return;


                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}