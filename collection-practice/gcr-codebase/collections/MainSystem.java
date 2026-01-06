import java.time.LocalDate;
import java.util.*;


class InsurancePolicy {

    // policy details
    String policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    // constructor
    InsurancePolicy(String policyNumber, String holderName,
                    LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;





        this.expiryDate = expiryDate;
        this.coverageType = coverageType;


        this.premium = premium;
    }
}

class InsuranceSystem {

    // hashmap for fast lookup
    Map<String, InsurancePolicy> policyMap = new HashMap<>();

    // linkedhashmap for insertion order
    Map<String, InsurancePolicy> insertionOrderMap = new LinkedHashMap<>();

    // treemap sorted by expiry date
    TreeMap<LocalDate, InsurancePolicy> expiryMap = new TreeMap<>();

    // add policy
    void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy
            
        );
        expiryMap.put(policy.expiryDate, policy);
    }

    // get policy by number
    InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // policies expiring in next 30 days
    void policiesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (InsurancePolicy p : policyMap.values()) {
            if (!p.expiryDate.isBefore(today) && !p.expiryDate.isAfter(limit)) {
                System.out.println(p.policyNumber + " expiring on " + p.expiryDate);
            }
        }
    }

    // policies by holder
    void policiesByHolder(String name) {
        for (InsurancePolicy p : policyMap.values()) {
            if (p.holderName.equalsIgnoreCase(name)) {
                System.out.println(p.policyNumber + " for" + p.holderName);
            }
        }
    }

    // remove expired policies
    void removeExpired() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, InsurancePolicy>> it = policyMap.entrySet().iterator();
        while (it.hasNext()) {
            InsurancePolicy p = it.next().getValue();
            if (p.expiryDate.isBefore(today)) {
                it.remove();
            }
        }
    }
}


class VotingSystem {

    // hashmap for votes
    Map<String, Integer> votes = new HashMap<>();

    // cast vote
    void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    // show sorted result
    void showSortedResult() {
        TreeMap<String, Integer> sorted = new TreeMap<>(votes);
        System.out.println(sorted);
    }

    // show insertion order
    void showInsertionOrder() {
        Map<String, Integer> linked = new LinkedHashMap<>(votes);
        System.out.println(linked);
    }
}


class ShoppingCart {

    // hashmap for price
    Map<String, Double> priceMap = new HashMap<>();

    // linkedhashmap for order
    Map<String, Double> orderMap = new LinkedHashMap<>();

    // add item
    void addItem(String item, double price) {
        priceMap.put(item, price);
        orderMap.put(item, price);
    }

    // display sorted by price
    void showSortedByPrice() {
        TreeMap<Double, String> sorted = new TreeMap<>();

        for (Map.Entry<String, Double> e : priceMap.entrySet()) {
            sorted.put(e.getValue(), e.getKey());
        }

        System.out.println(sorted);
    }
}


class BankingSystem {

    // hashmap for accounts
    Map<String, Double> accounts = new HashMap<>();

    // queue for withdrawals
    Queue<String> withdrawQueue = new LinkedList<>();

    // add account
    void addAccount(String accNo, double balance) {
        accounts.put(accNo, balance);
    }

    // request withdrawal
    void requestWithdraw(String accNo) {
        withdrawQueue.add(accNo);
    }

    // process withdrawal
    void processWithdrawals(double amount) {
        while (!withdrawQueue.isEmpty()) {
            String acc = withdrawQueue.poll();
            double bal = accounts.get(acc);

            if (bal >= amount) {
                accounts.put(acc, bal - amount);
                System.out.println(acc + " withdraw success");
            } else {
                System.out.println(acc + "insufficient balance");
            }
        }
    }

    // sort by balance
    void sortByBalance() {
        TreeMap<Double, String> sorted = new TreeMap<>();

        for (Map.Entry<String, Double> e : accounts.entrySet()) {
            sorted.put(e.getValue(), e.getKey());
        }

        System.out.println(sorted);
    }
}


public class MainSystem {

    public static void main(String[] args) {

        // insurance demo
        InsuranceSystem ins = new InsuranceSystem();
        ins.addPolicy(new InsurancePolicy("P1", "arman",
                LocalDate.now().plusDays(20), "health", 5000));
        ins.addPolicy(new InsurancePolicy("P2", "bhaskar",
                LocalDate.now().plusDays(60), "auto", 3000));

        ins.policiesExpiringSoon();

        // voting demo
        VotingSystem vote = new VotingSystem();
        vote.vote("A");
        vote.vote("B");
        vote.vote("A");
        vote.showSortedResult();

        // shopping cart demo
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("applee", 50);
        cart.addItem("bananana", 20);
        cart.showSortedByPrice();

        // banking demo
        BankingSystem bank = new BankingSystem();
        bank.addAccount("ACCOUNT1", 1000);
        bank.addAccount("ACCOUNT2", 500);
        bank.requestWithdraw("ACCOUNT1");
        bank.requestWithdraw("ACCOUNT2");
        bank.processWithdrawals(600);
        bank.sortByBalance();
    }
}