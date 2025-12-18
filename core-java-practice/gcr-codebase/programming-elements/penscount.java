public class penscount {
    //dividing 14 pens between 3 students equally and finding remaining pens
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;
        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;
        System.out.println("the pen per student is: " + pensPerStudent + " pens and the remaining pen not distributed is: " + remainingPens + " pen");

    }
}
