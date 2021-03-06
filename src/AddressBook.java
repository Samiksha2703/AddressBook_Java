import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    public int indexValue = 1;
    public HashMap<Integer, Contact> contacts = new HashMap<>();
    public HashMap<String, AddressBookList> addressBookList = new HashMap<String, AddressBookList>();
    public static Scanner sc = new Scanner(System.in);
    static AddressBook addressbook = new AddressBook();


    public void menu() {
        int choice = 1;
        do {
            System.out.println("Enter your choice" +
                    "\n1. Add Contact" +
                    "\n2. Edit Contact" +
                    "\n3. Delete Contact" +
                    "\n4. Create New AddressBook" +
                    "\n5. Search Person By City" +
                    "\n6. Search Person By City" +
                    "\n7. Count Person By City" +
                    "\n8. Count Person By State" +
                    "\n9. Sort Person by First Name" +
                    "\n10. Sort Person by City" +
                    "\n11. Sort Person by State" +
                    "\n12. Sort Person by Zip" +
                    "\n0. Exit");
            int userInput = sc.nextInt();
            switch (userInput) {
                case 1:
                    addressbook.addContact();
                    break;
                case 2:
                    addressbook.editContact();
                    break;
                case 3:
                    addressbook.deleteContact();
                    break;
                case 4:
                    addressbook.createNewAddressBook();
                    break;
                case 5:
                    addressbook.searchPersonByCity();
                    break;
                case 6:
                    addressbook.searchPersonByState();
                    break;
                case 7:
                    addressbook.countPersonByCity();
                    break;
                case 8:
                    addressbook.countPersonByState();
                    break;
                case 9:
                    addressbook.sortPersonByFirstname();
                    break;
                case 10:
                    addressbook.sortPersonByCity();
                    break;
                case 11:
                    addressbook.sortPersonByState();
                    break;
                case 12:
                    addressbook.sortPersonByZipCode();
                    break;
                default:
                    System.out.println("You press exit.\nThank You!");
                    choice = 0;
                    break;
            }
        }
        while (choice != 0);
    }

    public void addContact() {
        System.out.println("Enter Number of person you want to add");
        int numOfPerson = sc.nextInt();
        for (int add = 1; add <= numOfPerson; add++) {
            System.out.println("\nPerson : " + add + " Enter First Name");
            String first = sc.next();
            sc.nextLine();
            System.out.println("Person : " + add + " Enter Last Name");
            String last = sc.next();
            sc.nextLine();
            System.out.println("Person : " + add + " Enter Address");
            String address = sc.next();
            sc.nextLine();
            System.out.println("Person : " + add + " Enter City");
            String city = sc.nextLine();
            System.out.println("Person : " + add + " Enter State");
            String state = sc.next();
            sc.nextLine();
            System.out.println("Person : " + add + " Enter Zip Code");
            int zip = sc.nextInt();
            System.out.println("Person : " + add + " Enter Phone Number");
            long phone = sc.nextLong();
            System.out.println("Person : " + add + " Enter E-mail");
            String email = sc.next();
            if (addressbook.check(first)) {
                add--;
                continue;
            }
            Contact contact = new Contact(first, last, address, city, state, zip, phone, email);
            contacts.put(indexValue, contact);
            indexValue++;
        }
        System.out.println("\nContacts added Successfully");
    }

    public Boolean check(String checkName) {
        if (contacts.isEmpty())
            return false;
        else {
            Iterator<Integer> itr = contacts.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(checkName)) {
                    System.out.println("\nAdd contact again with different first name.");
                    return true;
                }
            }
        }
        return false;
    }

    public void editContact() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Enter the first name to edit contact.");
            String name = sc.next();
            Iterator<Integer> itr = contacts.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(name)) {
                    System.out.println("\nEnter First Name to Edit");
                    String first = sc.next();
                    sc.nextLine();
                    System.out.println("Enter Last Name to Edit");
                    String last = sc.next();
                    sc.nextLine();
                    System.out.println("Enter Address to Edit");
                    String address = sc.next();
                    sc.nextLine();
                    System.out.println("Enter City to Edit");
                    String city = sc.nextLine();
                    System.out.println("Enter State to Edit");
                    String state = sc.next();
                    sc.nextLine();
                    System.out.println("Enter Zip Code to Edit");
                    int zip = sc.nextInt();
                    System.out.println("Enter Phone Number to Edit");
                    long phone = sc.nextLong();
                    System.out.println("Enter E-mail to Edit");
                    String email = sc.next();
                    Contact contact = new Contact(first, last, address, city, state, zip, phone, email);
                    contacts.put(key, contact);
                    System.out.println("Contact edited with given first name : " + name);
                }
            }
        }
    }

    public void deleteContact() {
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Enter the first name to delete contact.");
            String name = sc.next();
            Iterator<Integer> itr = contacts.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                if (contacts.get(key).firstName.equals(name)) {
                    contacts.remove(key);
                    System.out.println("Contact deleted with first name : " + name);
                }
            }
        }
    }

    public void createNewAddressBook() {
        System.out.println("Enter the name for Address Book");
        String addressBookName = sc.next();
        AddressBookList addressBookListobj = new AddressBookList(addressBookName);
    }

    public void searchPersonByCity() {
        System.out.println("Enter the city to search person.");
        String cityName = sc.next();
        System.out.println("Person Search by " + cityName);
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithCity = new Hashtable();
        conatactlist.stream().filter(n -> n.city.contains(cityName)).forEach(contactlist -> dictWithCity.put(contactlist.firstName, cityName));
        for (Enumeration i = dictWithCity.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    public void searchPersonByState() {
        System.out.println("Enter the state to search person.");
        String stateName = sc.next();
        System.out.println("Person Search by " + stateName);
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        Dictionary dictWithState = new Hashtable();
        conatactlist.stream().filter(n -> n.state.contains(stateName)).forEach(contactlist -> dictWithState.put(contactlist.firstName, stateName));
        for (Enumeration i = dictWithState.keys(); i.hasMoreElements(); ) {
            System.out.println(i.nextElement());
        }
    }

    public void countPersonByState() {
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((Contact C) -> C.getState(),Collectors.counting())));
    }

    public void countPersonByCity() {
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        System.out.println(conatactlist.stream().collect(Collectors.groupingBy((Contact C) -> C.getCity(),Collectors.counting())));
    }

    public void sortPersonByFirstname(){
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (Contact cont : conatactlist){
            System.out.println(cont.getFirstName() + " " +cont.getLastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(Contact::getFirstName));
        conatactlist.forEach((Contact cont) -> System.out.println(cont.getFirstName() + " " + cont.getLastName()));
    }

    public void sortPersonByCity(){
        System.out.println("---Sort by City---");
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (Contact cont : conatactlist){
            System.out.println(cont.getCity() + " : " + cont.getFirstName() + " " + cont.getLastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(Contact::getCity));
        conatactlist.forEach((Contact cont) -> System.out.println(cont.getCity() + " : " +cont.getFirstName() + " " + cont.getLastName()));
    }

    public void sortPersonByState(){
        System.out.println("---Sort by State---");
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (Contact cont : conatactlist){
            System.out.println(cont.getState() + " : " +cont.getFirstName() + " "+ cont.getLastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(Contact::getState));
        conatactlist.forEach((Contact cont) -> System.out.println(cont.getState() + " : " + cont.getFirstName() + " " + cont.getLastName()));
    }

    public void sortPersonByZipCode(){
        System.out.println("---Sort by ZipCode---");
        Collection<Contact> values = contacts.values();
        ArrayList<Contact> conatactlist
                = new ArrayList<>(values);
        System.out.println("Contact list before sorting the list");
        for (Contact cont : conatactlist){
            System.out.println(cont.getZip() + " : " +cont.getFirstName() + " "+ cont.getLastName());
        }
        System.out.println("Contact list after sorting the list");
        conatactlist.stream();
        conatactlist.sort(Comparator.comparing(Contact::getZip));
        conatactlist.forEach((Contact cont) -> System.out.println(cont.getZip() + " : " +cont.getFirstName() + " " + cont.getLastName()));
    }


    public static void main(String[] args) {
        System.out.println("-----Welcome to Address Book Program-----\n");
        addressbook.menu();
    }
}


