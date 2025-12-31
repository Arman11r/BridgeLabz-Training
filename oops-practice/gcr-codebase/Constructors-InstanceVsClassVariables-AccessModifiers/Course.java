class Course {

    // course name
    String courseName;

    // duration in months
    int duration;

    // course fee
    double fee;

    // common institute name
    static String instituteName = "BridgeLabz";

    // constructor
    Course(String name, int duration, double fee) {
        this.courseName = name;
        this.duration = duration;
        this.fee = fee;
    }

    // showing course details
    void displayCourseDetails() {
        System.out.println(courseName + " " + duration + " " + fee);
    }

    // updating institute name
    static void updateInstituteName(String name) {
        instituteName = name;
    }
}