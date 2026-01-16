public class MedicalRecord {
    // Variables
    private String recordID;
    private String diagnosis;
    private String tests;
    private String notes;

    // Constructor
    public MedicalRecord(String recordID, String diagnosis, String tests, String notes) {
        this.recordID = recordID;
        this.diagnosis = diagnosis;
        this.tests = tests;
        this.notes = notes;
    }

    // Mutators
    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public void setTests(String tests) {
        this.tests = tests;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    // Accessors
    public String getRecordID() {
        return recordID;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public String getTests() {
        return tests;
    }
    public String getNotes() {
        return notes;
    }

    public void displayMedicalRecord() {
    System.out.println("\t\t===========================================================");
    System.out.println("\t\t=                 Medical Record Operations               =");
    System.out.println("\t\t===========================================================");
    System.out.println("\n\t\tRecord ID   : " + this.recordID);
    System.out.println("\t\tDiagnosis   : " + this.diagnosis);
    System.out.println("\t\tTest        : " + this.tests);
    System.out.println("\t\tNotes       : " + this.notes);

    }

}

