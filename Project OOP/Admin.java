
public class Admin extends Person {
    private String adminId;

    public Admin(String name, int age, String gender, String address,              // Argument for Person class
                        String adminId)//, medicalRecord medicalRecord) // KIV SEMULA PASAL MEDICALRECORD, 
    {
        super(name, age, gender, address);
        this.adminId = adminId;
    }

    public void setAdminId(String adminId){
        this.adminId = adminId;
    }
    public String getAdminId(){
        return adminId;
    }

    public void displayInformation(){
        System.out.println("\t\t===========================================================");
        System.out.println("\t\t=                Personal Information Page                =");
        System.out.println("\t\t===========================================================");
        System.out.println("\n\t\t Here is the information about " + super.getName());
        System.out.println("\t\tAdmin name : " + super.getName());
        System.out.println("\t\tAge        : " + super.getAge());
        System.out.println("\t\tGender     : " + super.getGender());
        System.out.println("\t\tAddress    : " + super.getAddress());
        System.out.println("\t\tAdmin ID   : " + adminId);
    }
}
