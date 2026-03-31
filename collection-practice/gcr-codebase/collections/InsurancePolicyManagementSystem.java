import java.time.LocalDate;
import java.util.*;

// main class
public class InsurancePolicyManagementSystem {

    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        // creating policies
        Policy p1 = new Policy(
                "P101",
                "Arman Ahmed",
                LocalDate.now().plusDays(20),
                "Health",
                5000
        );

        Policy p2 = new Policy(
                "P102",
                "Rohan",
                LocalDate.now().plusDays(60),
                "Auto",
                7000
        );

        Policy p3 = new Policy(
                "P103",
                "Karan",
                LocalDate.now().plusDays(10),
                "Home",
                8000
        );

        // duplicate policy (same policy number)
        Policy duplicate = new Policy(
                "P101",
                "Duplicate User",
                LocalDate.now().plusDays(90),
                "Health",
                9000
        );

        // adding policies
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(duplicate); // wont be added

        // display all unique policies
        System.out.println("\nAll Unique Policies (HashSet):");
        manager.displayAll(manager.getHashSet());

        // insertion order
        System.out.println("\nInsertion Order (LinkedHashSet):");
        manager.displayAll(manager.getLinkedHashSet());

        // sorted by expiry
        System.out.println("\nSorted by Expiry Date (TreeSet):");
        manager.displayAll(manager.getTreeSet());

        // expiring within 30 days
        System.out.println("\nPolicies Expiring Within 30 Days:");
        manager.displayExpiringSoon();

        // coverage type filter
        System.out.println("\nHealth Coverage Policies:");
        manager.displayByCoverage("Health");

        // performance comparison
        Policy testPolicy = new Policy(
                "P999",
                "Test User",
                LocalDate.now().plusDays(120),
                "Auto",
                10000
        );

        manager.performanceTest(testPolicy);
    }
}

/* ===================== POLICY CLASS ===================== */

class Policy implements Comparable<Policy> {

    // policy details
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    // constructor
    public Policy(String policyNumber,
                  String policyHolderName,
                  LocalDate expiryDate,
                  String coverageType,
                  double premiumAmount) {

        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // getters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    // uniqueness based on policy number
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return policyNumber.equals(other.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    // sorting by expiry date for TreeSet
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    // display
    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolder='" + policyHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premium=" + premiumAmount +
                '}';
    }
}

/* ===================== POLICY MANAGER ===================== */

class PolicyManager {

    // different sets
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    // add policy
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // display all
    public void displayAll(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    // policies expiring in 30 days
    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (Policy p : hashSet) {
            if (!p.getExpiryDate().isBefore(today)
                    && p.getExpiryDate().isBefore(limit)) {
                System.out.println(p);
            }
        }
    }

    // coverage filter
    public void displayByCoverage(String type) {
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // performance comparison
    public void performanceTest(Policy testPolicy) {

        System.out.println("\n--- Performance Comparison ---");

        long start, end;

        // HashSet
        start = System.nanoTime();
        hashSet.add(testPolicy);
        hashSet.contains(testPolicy);
        hashSet.remove(testPolicy);
        end = System.nanoTime();
        System.out.println("HashSet Time: " + (end - start) + " ns");

        // LinkedHashSet
        start = System.nanoTime();
        linkedHashSet.add(testPolicy);
        linkedHashSet.contains(testPolicy);
        linkedHashSet.remove(testPolicy);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Time: " + (end - start) + " ns");

        // TreeSet
        start = System.nanoTime();
        treeSet.add(testPolicy);
        treeSet.contains(testPolicy);
        treeSet.remove(testPolicy);
        end = System.nanoTime();
        System.out.println("TreeSet Time: " + (end - start) + " ns");
    }

    // getters
    public Set<Policy> getHashSet() {
        return hashSet;
    }

    public Set<Policy> getLinkedHashSet() {
        return linkedHashSet;
    }

    public Set<Policy> getTreeSet() {
        return treeSet;
    }
}