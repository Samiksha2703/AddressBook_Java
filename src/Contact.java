public class Contact {

        private final String firstName;
        private final String lastName;
        private final String address;
        private final String city;
        private final String state;
        private final long zip;
        private final long phoneNumber;
        private final String email;

        public Contact(String firstName, String lastName, String address, String city, String state, long zip, long phoneNumber, String email){
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
            return "First Name : " +this.firstName + " Last Name : " +this.lastName + " Address : " +this.address + " City : " +city + " State : " +this.state + " Zip : " +this.zip + " Phone Number : " +this.phoneNumber + " Email : " +this.email;
        }
    }
