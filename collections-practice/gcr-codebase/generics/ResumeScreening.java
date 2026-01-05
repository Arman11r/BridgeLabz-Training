import java.util.*;

// base job role
abstract class JobRole {
    String role;

    JobRole (String role ){
        this.role = role;
    }

    void showRole () {
        System.out.println("role  : " + role);
    }
}

// roles
class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer ");
    }
}

class DataScientist extends JobRole{
    DataScientist() {
        super("Data Scientist ");
    }
}

// resume class
class Resume<T extends JobRole>{
    T job;

    Resume(T job){
        this.job = job;
    }

    void process(){
        job.showRole();
    }
}

public class ResumeScreening{

    static void screenAll(List<? extends JobRole> list) {
        for (JobRole j : list) {
            j.showRole();
        }
    }

    public static void main(String[] args){

        Resume<SoftwareEngineer> r1 =
                new Resume<>(new SoftwareEngineer () );

        r1.process();

        List<JobRole> jobs = new ArrayList<> ();
        jobs.add(new SoftwareEngineer() );
        jobs.add(new DataScientist());

        screenAll(jobs) ;
    }
}