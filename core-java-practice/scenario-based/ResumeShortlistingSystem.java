

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class InvalidResumeException extends Exception {
    public InvalidResumeException(String msg) {
        super(msg);
    }
}



class Resume {

    private String name;
    private double cpi;
    private Set<String> skills;

    public Resume(String name, double cpi, Set<String> skills) throws InvalidResumeException {

        if (name == null || name.isEmpty() || skills == null || skills.isEmpty()) {
            throw new InvalidResumeException("Resume must have name and at least one skill");
        }

        this.name = name;
        this.cpi = cpi;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public double getCpi() {
        return cpi;
    }

    public Set<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return name + " | CPI: " + cpi + " | Skills: " + skills;
    }
}


class SkillComparator implements Comparator<Resume> {

    private Set<String> requiredSkills;

    public SkillComparator(Set<String> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    @Override
    public int compare(Resume r1, Resume r2) {

        int match1 = countMatch(r1.getSkills());
        int match2 = countMatch(r2.getSkills());

        return match2 - match1; 
    }

    private int countMatch(Set<String> skills) {
        int count = 0;

        for (String s : skills) {
            if (requiredSkills.contains(s)) {
                count++;
            }
        }
        return count;
    }
}



class JobPortal {

    private List<Resume> resumes = new ArrayList<>();

    public void addResume(Resume r) {
        resumes.add(r);
    }

    public void shortlist(Set<String> requiredSkills) {

        Collections.sort(resumes, new SkillComparator(requiredSkills));

        System.out.println("=== Shortlisted Resumes ===");

        for (Resume r : resumes) {
            System.out.println(r);
        }
    }
}



public class ResumeShortlistingSystem {

    public static void main(String[] args) {

        try {

            JobPortal portal = new JobPortal();

            portal.addResume(new Resume("Arman", 8.2,
                    new HashSet<>(Arrays.asList("Java", "Spring", "SQL"))));

            portal.addResume(new Resume("Riya", 9.1,
                    new HashSet<>(Arrays.asList("Python", "ML", "SQL"))));

            portal.addResume(new Resume("Karan", 7.5,
                    new HashSet<>(Arrays.asList("Java", "React", "AWS"))));


            // recruiter requirement
            Set<String> required = new HashSet<>(Arrays.asList("Java", "SQL", "AWS"));

            portal.shortlist(required);

        } catch (InvalidResumeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}