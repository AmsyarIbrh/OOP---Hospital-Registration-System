public class Doctor extends Person{
    // Variables
    private String doctorId;
    private String specialization;
    private String department;

    // Constructor
    public Doctor(String name, int age, String gender, String address,              // Argument for Person class
                  String doctorId, String specialization, String department)        // Argument for Doctor class
    {         
            super(name, age, gender, address);  // Constructor for Person
            this.doctorId = doctorId;
            this.specialization = specialization;
            this.department = department;
    }

    // Mutator
    public void setDoctorId(String doctorId){
        this.doctorId = doctorId;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    // Accessor
    public String getDoctorId(){
        return doctorId;
    }
    public String getSpecialization(){
        return specialization;
    }
    public String getDepartment(){
        return department;
    }

    public void displayInformation(){
        System.out.println("\t\t===========================================================");
        System.out.println("\t\t=                Personal Information Page                =");
        System.out.println("\t\t===========================================================");
        System.out.println("\n\t\t Here is the information about " + super.getName());
        System.out.println("\t\tPatient name   : " + super.getName());
        System.out.println("\t\tAge            : " + super.getAge());
        System.out.println("\t\tGender         : " + super.getGender());
        System.out.println("\t\tAddress        : " + super.getAddress());
        System.out.println("\t\tDoctor ID      : " + doctorId);
        System.out.println("\t\tSpecialization : " + specialization);
        System.out.println("\t\tDepartment     : " + department);
    }


}

