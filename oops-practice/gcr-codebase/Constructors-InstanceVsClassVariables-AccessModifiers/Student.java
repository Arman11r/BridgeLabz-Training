class Student {

    // public roll number
    public int rollNumber;

    // protected name
    protected String name;

    // private cgpa
    private double cgpa;

    // setter for cgpa
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    // getter for cgpa
    public double getCgpa() {
        return cgpa;
    }
}

class PostgraduateStudent extends Student {

    // accessing protected members
    void display() {
        System.out.println(rollNumber + " " + name);
    }
}