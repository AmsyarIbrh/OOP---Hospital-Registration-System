import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    // Variables
    private String patientId;
    private String insurance;
    private MedicalRecord medicalRecord = null;
    private List<Appointment> appointments;


    // To know whether the patient has insurance or not
    // Or boleh jgk kalau nak letak nama insurance company yang dia registered

    // private medicalRecord medicalRecord;    // KIV DULU VARIABLES NI

    // Constructor
    public Patient(String name, int age, String gender, String address,              // Argument for Person class
                        String patientId, String insurance, MedicalRecord medicalRecord)//, medicalRecord medicalRecord) // KIV SEMULA PASAL MEDICALRECORD, 
    {
        super(name, age, gender, address);
        this.patientId = patientId;
        this.insurance = insurance;
        this.medicalRecord = medicalRecord;
        this.appointments = new ArrayList<>();
        //medicalRecord();
    }

    // Mutator
    public void setPatientId(String patientId){
        this.patientId = patientId;
    }
    public void setInsurance(String insurance){
        this.insurance = insurance;
    }
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    // Accessor
    public String getPatientId(){
        return patientId;
    }
    public String getInsurance(){
        return insurance;
    }
     public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

     public List<Appointment> getAppointments() {
        return appointments;
    }

     public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    
    public void displayInformation(){
        System.out.println("\t\t===========================================================");
        System.out.println("\t\t=                Personal Information Page                =");
        System.out.println("\t\t===========================================================");
        System.out.println("\n\t\t Here is the information about " + super.getName());
        System.out.println("\t\tPatient name : " + super.getName());
        System.out.println("\t\tAge          : " + super.getAge());
        System.out.println("\t\tGender       : " + super.getGender());
        System.out.println("\t\tAddress      : " + super.getAddress());
        System.out.println("\t\tPatient ID   : " + patientId);
        System.out.println("\t\tInsurance    : " + insurance);
        
        if(medicalRecord.getRecordID() == null){
            System.out.println("\n\t\tNo Medical Record History");
        }else{
            System.out.println("\n\t\tMedical Record History");
            System.out.println("\t\tMedical Record ID : " + medicalRecord.getRecordID());
            System.out.println("\t\tDiagnosis         : " + medicalRecord.getDiagnosis());
            System.out.println("\t\tTests             : " + medicalRecord.getTests());
            System.out.println("\t\tNotes             : " + medicalRecord.getNotes());
        }        
    }


}

