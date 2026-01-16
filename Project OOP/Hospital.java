public class Hospital {
    // Variables
    private String hospitalName;
    private String address;
    private String contactNumber;

    // Constructor
    public Hospital(String hospitalName, String address, String contactNumber) {
        this.hospitalName = hospitalName;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    // Mutators
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    // Accessors
    public String getHospitalName() {
        return hospitalName;
    }
    public String getAddress() {
        return address;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    // Method to display information
    public void displayInformation() {
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
    }
}
