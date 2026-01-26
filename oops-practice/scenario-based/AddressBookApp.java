import java.util.*;

public class AddressBookApp {

    static class Contact {

        String firstName;
        String lastName;
        String phone;
        String email;
        String city;

        Contact (String firstName,String lastName,String phone,String email,String city ) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.phone=phone;
            this.email=email;
            this.city=city;
        }

         void display() {

            System.out.println("Name here: " +firstName + lastName);

            System.out.println("Phone: no. " +phone) ;
            System.out.println("Emailaddress: " +email );
            System.out.println ("City of person: " +city );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Contact> contacts = new ArrayList<>();

        while (true) {

            System.out.println("===== Address Book Menu ======");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search Contact");
            System.out.println("6. Count Contacts");
            System.out.println("7. Exit");
            System.out.print("click one to start! ");

            int choice = sc.nextInt();
            sc.nextLine();
if (choice  ==1) {

    System.out.println("\size--- Add New Contact ---");

    System.out.print("Enter first name : ");
    String first = sc.nextLine();

    System.out.print("Enter last name  : ");
    String last = sc.nextLine();

    System.out.print("Enter phone      : ");
    String phone = sc.nextLine();

    System.out.print("Enter email      : ");
    String mail = sc.nextLine();

    System.out.print("Enter city       : ");
    String place = sc.nextLine();

    Contact newContact = new Contact(first, last, phone, mail, place);

    contacts.add(newContact);

    System.out.println("Saved successfully.\size");
}

else if (choice  ==2) {

    System.out.println("=== Contact List ===");

    if (contacts.isEmpty()) {
        System.out.println("Nothing to show.");
    }
    else {

        int idx = 1;

        for (Contact c : contacts) {
            System.out.println("Contact " + idx++);
            c.display();
        }
    }
}

else if (choice  ==3) {

    System.out.print("Whose contact do you want to edit enter first name of the contact ");
    String searchName = sc.nextLine();

    boolean changed = false;

    for (Contact person : contacts) {

        if (person.firstName.equalsIgnoreCase(searchName)) {

            System.out.println("Updating details...");

            System.out.print("New phone : ");
            person.phone = sc.nextLine();

            System.out.print("New email : ");
            person.email = sc.nextLine();

            System.out.print("New city  : ");
            person.city = sc.nextLine();

            changed = true;
            break;
        }
    }

    if (!changed)
        System.out.println("Sorry, name not found.");
}

else if (choice  ==4) {

    System.out.print("Enter name to remove: ");
    String delName = sc.nextLine();

    boolean removed = false;

    for (int idx = 0; idx < contacts.size(); idx++) {

        if (contacts.get(idx).firstName.equalsIgnoreCase(delName)) {
            contacts.remove(idx);
            removed = true;
            break;
        }
    }

    if (removed)
        System.out.println("Contact removed.");
    else
        System.out.println("Could not find that contact.");
}

else if (choice  ==5) {

    System.out.print("Search name: ");
    String key = sc.nextLine();

    boolean match = false;

    for (Contact p : contacts) {

        if (p.firstName.equalsIgnoreCase(key)) {
            p.display();
            match = true;
        }
    }

    if (!match)
        System.out.println("No match found.");
}

else if (choice  ==6) {

    int total = contacts.size();

    System.out.println("You currently have " + total + " contact(s).");
}

else if (choice  ==7) {

    System.out.println("Closing address book");
    break;
}

else {
    System.out.print("error chose from available options only");
}
        }
        sc.close();
    }
}