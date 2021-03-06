public class Contact {

        public final String firstName;
        public final String lastName;
        public final String address;
        public final String city;
        public final String state;
        public final int zip;
        public final long phoneNumber;
        public final String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }


    public Contact(String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber, String email){
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        public String toString(){
            return "First Name : " +this.firstName + "\nLast Name : " +this.lastName + "\nAddress : " +this.address + "\nCity : " +city + "\nState : " +this.state + "\nZip : " +this.zip + "\nPhone Number : " +this.phoneNumber + "\nEmail : " +this.email;
        }
    }
