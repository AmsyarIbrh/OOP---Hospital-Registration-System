/*
 *   1. Abdul Azim Bin Anuar Veera   (A21EC0001)
 *   2. Muhamad Amsyar Bin Ibrahim   (A21EC0058) 
 *   3. Ayesha Imelda Binti Rohaizan (A21EC0164)
 */

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;  // To handle errors
import java.util.Vector;

public class HospitalRegistrationSystemApplication {
    public static void main(String[] args) {
        int adminChoice = 0;
        int patientChoice = 0;
        int doctorChoice = 0;
        int userChoice = 99;    // random number to initialize the system
        Vector<Patient> patientVector = new Vector<Patient>();
        Vector<Doctor> doctorVector = new Vector<Doctor>();
        Vector<Room> roomVector = new Vector<Room>();
        Hospital hospital = new Hospital("Oculent Care Hospital", "Ara Damansara", "05-9297655");

        Scanner inp = new Scanner(System.in);  // to make a Scanner object;
        Patient patientObj;
        MedicalRecord medRecord;
        Doctor doctorObj;

        // As for now, there will be only one admin managing the system. 
        Admin adminObj = new Admin("Ismail Bin Ahmad", 34, "Male", "Jalan Wong Ah Jang, 25200, Kuantan, Pahang", "A001");
        
        Room roomObj1=new Room("R001",5);
        Room roomObj2=new Room("R002",5);
        Room roomObj3=new Room("R003",5);
        roomVector.add(roomObj1);
        roomVector.add(roomObj2);
        roomVector.add(roomObj3);



        // Getting the list of patient from the text file
        File patientFileInput = new File("Patient.txt");
        try{
            Scanner scanner = new Scanner(patientFileInput);
            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] value = line.split(",");
            
                String name = value[0].trim();
                int age = Integer.parseInt(value[1].trim());
                String gender = value[2].trim();
                String address = value[3].trim();
                String patientId = value[4].trim();
                String insurance = value[5].trim();
                String medRecordId = value[6].trim();
                String diagnosis = value[7].trim();
                String test = value[8].trim();
                String notes = value[9].trim();
            
                medRecord = new MedicalRecord(medRecordId, diagnosis, test, notes);
                patientObj = new Patient(name, age, gender, address, patientId, insurance, medRecord);
                patientVector.add(patientObj);

            } 
            scanner.close();
        } catch(FileNotFoundException message){
            System.out.println("File not found");
        }

        File doctorFileInput = new File("Doctor.txt");
        try{
            Scanner scanner = new Scanner(doctorFileInput);
            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] value = line.split(",");
            
                String name = value[0].trim();
                int age = Integer.parseInt(value[1].trim());
                String gender = value[2].trim();
                String address = value[3].trim();
                String doctorId = value[4].trim();
                String specialization = value[5].trim();
                String department = value[6].trim();
            
                doctorObj = new Doctor(name, age, gender, address, doctorId, specialization, department);
                doctorVector.add(doctorObj);
            } 
            scanner.close(); 
        } catch(FileNotFoundException message){
            System.out.println("File not found");
        }

        welcomeMessage();
        pauseScreen();
        clearScreen();

        boolean loginStatus = false;
    
        do{
            userChoice = chooseUserPage(inp);  // User decide either want to login as admin or patient
            switch(userChoice){
                case 1:{// Admin page
                            loginStatus = loginAdminPage(inp);
                            while(loginStatus != false){         
                                    adminChoice = AdministratorPage(inp, adminObj);
                                    switch(adminChoice){
                                        case 1: { //adminChoice 1 - Display admin information
                                                    clearScreen();
                                                    adminObj.displayInformation();
                                                    pauseScreen();
                                                    break;
                                        }
                                        case 2: { //adminChoice 2 - Add a new patient
                                                    addPatientPage();
                                                    patientObj = enterPatientInformation(inp);
                                                    patientVector.add(patientObj);
                                                    //adminObj.addPatient(patientObj);
                                                    System.out.println("Patient added successfully");
                                            break;
                                        }
                                        case 3: { //adminChoice 3 - Delete a patient
                                                    deletePatientPage();
                                                    for(int i = 0; i < patientVector.size(); i++){
                                                        System.out.println("\t\t" + (i+1) + ". Patient: " + patientVector.get(i).getName());
                                                    }
                                                    System.out.print("\n\t\tEnter the index that you want to delete: ");
                                                    int deletePatient = inp.nextInt();

                                                    patientVector.remove((deletePatient-1));
                                                    System.out.println("\n\t\tDeleteing patient information. Please wait ");
                                                    pauseScreen();
                                                    System.out.println("\n\t\tPatient has been deleted successfully");
                                                    pauseScreen();
                                                    
                                            break;
                                        }
                                        case 4: { //adminChoice 4 - Add a new doctor
                                                    addDoctorPage();
                                                    doctorObj = enterDoctorInformation(inp);
                                                    doctorVector.add(doctorObj);
                                                    //adminObj.addDoctor(doctorObj);
                                                    System.out.println("Doctor added successfully");
                                            break;
                                        }
                                        case 5: { //adminChoice 5 - Delete a doctor
                                            
                                                    deleteDoctorPage();
                                                    for(int i = 0; i < doctorVector.size(); i++){
                                                        System.out.println("\t\t" + (i+1) + ". Doctor: " + doctorVector.get(i).getName());
                                                    }

                                                    System.out.print("\n\t\tEnter the index that you want to delete: ");
                                                    int deleteDoctor = inp.nextInt();
                                                    doctorVector.remove(deleteDoctor-1);
                                                    System.out.println("\n\t\tDeleteing doctor information. Please wait ");
                                                    pauseScreen();
                                                    System.out.println("\n\t\tDoctor has been deleted successfully");
                                                    pauseScreen();
                                            break;
                                        }
                                        case 6: { //adminChoice 6 - Display all patient  
                                            clearScreen();
                                            for(int i = 0; i < patientVector.size(); i++){
                                                System.out.println("\n\t\t\t\t\t     (" + (i+1) + ")");
                                                patientVector.get(i).displayInformation();
                                                
                                            }
                                            pauseScreen();
                                            break;
                                        }
                                        case 7: { //adminChoice 7 - Display all doctor
                                            clearScreen();
                                            for(int i = 0; i <doctorVector.size();i++){
                                                System.out.println("\n\t\t\t\t\t     (" + (i+1) + ")");
                                                doctorVector.get(i).displayInformation();
                                            }
                                            pauseScreen();
                                            break;
                                        }
                                        case 8: { //adminChoice 8 - Return to userPage
                                                    System.out.println("\n\t\tReturn to the login page");
                                                    loginStatus = false;
                                            break;
                                        }
                                        default:{ //default of adminChoice
                                                    System.out.println("\n\t\tWrong input. Please try again.");
                                                    pauseScreen();
                                            break;
                                        }
                                    }   //end of adminChoice
                        }   // End of while loop of Admin
                            break;
                }
                case 2:{// Patient page
                            clearScreen();
                            System.out.println("\t\t===========================================================");
                            System.out.println("\t\t=                    Patient Login Page                   =");
                            System.out.println("\t\t===========================================================");
                            System.out.print("\t\t\tPatient ID : ");
                            inp.nextLine();
                            String patientID = inp.nextLine();
                            System.out.print("\t\t\tPassword   : ");
                            String password = inp.nextLine();
                            int index = getIndex(patientVector, patientID);
                            loginStatus = loginPatient(patientVector, patientID, password);
                                if (loginStatus) {
                                    while (loginStatus) {
                                        patientChoice = patientPage(inp);

                                        if (patientChoice == 1) {
                                            // Display Patient Information
                                            clearScreen();
                                            patientVector.get(index).displayInformation();
                                            pauseScreen();
                                        } 
                                        else if (patientChoice == 2) {
                                        // Schedule Appointment
                                        clearScreen();
                                        System.out.println("\t\t===========================================================");
                                        System.out.println("\t\t=                  Schedule Appointment                   =");
                                        System.out.println("\t\t===========================================================");

                                        System.out.print("\n\t\tEnter the date (MM/DD/YYYY) : ");
                                        inp.nextLine();
                                        String date = inp.nextLine();

                                        System.out.print("\t\tEnter the time (HH:MM)      : ");
                                        String time = inp.nextLine();

                                        // Display the list of available doctors
                                        System.out.println("\t\tAvailable Doctors:");
                                        for (int i = 0; i < doctorVector.size(); i++) {
                                            Doctor doctor = doctorVector.get(i);
                                            System.out.println("\t\t\t  " + (i + 1) + ". " + doctor.getName());
                                        }

                                        System.out.print("\n\t\tEnter the number of the doctor: ");
                                        int doctorchoice = inp.nextInt();
                                        inp.nextLine(); // Consume the newline character

                                        Doctor selectedDoctor = doctorVector.get(doctorchoice - 1);

                                        // Display the list of available rooms
                                        System.out.println("\n\t\tAvailable Rooms:");
                                        for (int i = 0; i < roomVector.size(); i++) {
                                            
                                            System.out.println("\t\t\t  " + (i + 1) + ". Room No.: " + roomVector.get(i).getRoomNO());
                                        }

                                        System.out.print("\n\t\tEnter the number of the room: ");
                                        int roomChoice = inp.nextInt();
                                        inp.nextLine(); // Consume the newline character

                                        Room selectedRoom = roomVector.get(roomChoice - 1);

                                        // Create a new appointment object
                                        Appointment appointment = new Appointment(selectedDoctor, time, date);
                                        appointment.setHospobj(hospital);
                                        appointment.getRoom().add(selectedRoom);

                                        // Add the appointment to the patient's list of appointments
                                        patientVector.get(index).addAppointment(appointment);

                                        System.out.println("\t\t\tScheduling the appointment. Please Wait");
                                        inp.nextLine();
                                        System.out.println("\t\t\tAppointment scheduled successfully!");
                                        pauseScreen();
                                        }
                                            else if (patientChoice == 3) {
                                                    System.out.println("\t\tReturning to the user page");
                                                    loginStatus = false;
                                            } 
                                            else {
                                                    System.out.println("\t\tWrong input. Please try again.");
                                                    pauseScreen();
                                            }
                                    }
                                } 
                                 else {
                                            System.out.println("Invalid login credentials. Returning to the user page.");
                                            pauseScreen();
                                         }
                            break;
                }
                case 3:{// Doctor page

                            clearScreen();
                            System.out.println("\t\t===========================================================");
                            System.out.println("\t\t=                    Doctor Login Page                   =");
                            System.out.println("\t\t===========================================================");
                            System.out.print("\n\t\t\tDoctor ID    : ");
                            inp.nextLine();
                            String doctorID = inp.nextLine();
                            System.out.print("\t\t\tPassword     : ");
                            String password = inp.nextLine();
                            int index = getIndexx(doctorVector, doctorID);
                            loginStatus = loginDoctor(doctorVector, doctorID, password);

                            if(loginStatus){
                                while(loginStatus){
                                    doctorChoice = doctorPage(inp);
                                    switch(doctorChoice){
                                        case 1:{
                                                // Display Patient Information
                                                clearScreen();
                                                System.out.println("\t\t===========================================================");
                                                System.out.println("\t\t=                 Create Medical Record                  =");
                                                System.out.println("\t\t===========================================================");
                                                
                                                // Prompt for medical record details
                                                System.out.print("\n\t\tEnter Record ID : ");
                                                String recordID = inp.nextLine();  // Consume the newline character
                                                recordID = inp.nextLine();
                                                System.out.print("\t\tEnter Diagnosis : ");
                                                String diagnosis = inp.nextLine();
                                                System.out.print("\t\tEnter Tests     : ");
                                                String tests = inp.nextLine();
                                                System.out.print("\t\tEnter Notes     : ");
                                                String notes = inp.nextLine();

                                                // Create a new medical record object
                                                MedicalRecord medicalRecord = new MedicalRecord(recordID, diagnosis, tests, notes);

                                                // Assign the medical record to the patient
                                                patientVector.get(index).setMedicalRecord(medicalRecord);

                                                System.out.println("\n\t\t\tMedical Record created successfully!");
                                                pauseScreen();

                                                break;
                                        }
                                        case 2:{
                                                clearScreen();
                                                // Get the patient's medical record
                                                MedicalRecord medicalRecord = patientVector.get(index).getMedicalRecord();

                                                if (medicalRecord == null) 
                                                {
                                                    System.out.println("\n\t\tNo Medical Record found for the patient.");
                                                } 
                                                else 
                                                {
                                                    // Display the medical record details
                                                    medicalRecord.displayMedicalRecord();
                                                }

                                                List<Appointment> appointments = patientVector.get(index).getAppointments();

                                                if (appointments.isEmpty()) {
                                                    System.out.println("\n\t\tNo Appointments scheduled for the patient.");
                                                } else {
                                                    System.out.println("\n\t\tAppointments:");
                                                    for (Appointment appointment : appointments) {
                                                        appointment.displayAppInfo();
                                                    }
                                                }
                                                pauseScreen();

                                            break;
                                        }
                                        case 3:{
                                            clearScreen();
                                            System.out.println("\t\t===========================================================");
                                            System.out.println("\t\t=                Update Medical Record                   =");
                                            System.out.println("\t\t===========================================================");

                                            // Get the patient's medical record
                                            MedicalRecord medicalRecord = patientVector.get(index).getMedicalRecord();

                                            if (medicalRecord == null) {
                                                System.out.println("\nNo Medical Record found for the patient.");
                                            } 
                                            else {
                                            // Prompt for new medical record details
                                            System.out.print("\n\t\tEnter new Diagnosis : ");
                                            String newDiagnosis = inp.nextLine();  // Consume the newline character
                                            newDiagnosis = inp.nextLine();
                                            System.out.print("\t\tEnter new Tests     : ");
                                            String newTests = inp.nextLine();
                                            System.out.print("\t\tEnter new Notes     : ");
                                            String newNotes = inp.nextLine();

                                            // Update the medical record details
                                            medicalRecord.setDiagnosis(newDiagnosis);
                                            medicalRecord.setTests(newTests);
                                            medicalRecord.setNotes(newNotes);

                                            System.out.println("\n\t\tMedical Record updated successfully!");
                                            }
                                             pauseScreen();
                                            break;
                                        }
                                        case 4:{
                                            clearScreen();
                                            System.out.println("\t\t===========================================================");
                                            System.out.println("\t\t=                Delete Medical Record                   =");
                                            System.out.println("\t\t===========================================================");

                                            // Get the patient's medical record
                                            MedicalRecord medicalRecord = patientVector.get(index).getMedicalRecord();

                                            if (medicalRecord == null) {
                                                System.out.println("\n\t\tNo Medical Record found for the patient.");
                                            } 
                                            else {
                                            // Delete the medical record
                                                patientVector.get(index).setMedicalRecord(null);
                                                System.out.println("\n\t\tMedical Record deleted successfully!");
                                            }
                                            pauseScreen();
                                                    break;
                                        }
                                        case 5:{
                                             System.out.println("\n\t\tReturn to the login page");
                                                    loginStatus = false;
                                            break;
                                        }
                                                default:{
                                                    System.out.println("\n\t\tInvalid input. Please try again");
                                                }
                                            }
                                        }
                                    }
                            break;
                }
                case 4:{// Exiting the system
                            System.out.println("\n\n\t\tExiting the system. Please wait");
                            exitDisplay();
                            System.exit(0);
                            break;
                }
                default:{ //Wrong input. Try again
                    System.out.println("\n\n\t\tWrong input, please try again.");
                            break;
                }
            }   //end of user Switch Case
        }while(userChoice != 4);
                     
    }//end of main function


        // Enter information for new Patient
        public static Patient enterPatientInformation(Scanner scanner){
            Patient newPatient;
            MedicalRecord medRecord = new MedicalRecord(null, null, null, null);
            String name = "", gender = "", address = "", patientId = "",insurance = "";
            int age = 0;
            boolean status = false;
            while(status == false){
                try{
                    scanner.nextLine();
                    System.out.print("\t\tPatient name      : ");
                    name = scanner.nextLine();
                    System.out.print("\t\tPatient age       : ");
                    age = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character
                    System.out.print("\t\tPatient gender    : ");
                    gender = scanner.nextLine();
                    System.out.print("\t\tPatient address   : ");
                    address = scanner.nextLine();
                    System.out.print("\t\tPatient Id        : ");
                    patientId = scanner.nextLine();
                    System.out.print("\t\tPatient insurance : ");
                    insurance = scanner.nextLine();

                    status = true;
                }
                catch(Exception e){
                    System.out.println("Wrong input. Try again");
                }
            }
            newPatient = new Patient(name, age, gender, address, patientId, insurance, medRecord);
             return newPatient; 
             
        }
        
        // Enter information for new Doctor
        public static Doctor enterDoctorInformation(Scanner scanner ){
            Doctor newDoctor;
            String name = "", gender = "", address = "", doctorId = "", specialization = "", department = "";
            int age = 0;
            boolean status = false;
            while(status == false){
                try{
                    scanner.nextLine();
                    System.out.print("\t\tDoctor name           : ");
                    name = scanner.nextLine();
                    System.out.print("\t\tDoctor age            : ");
                    age = scanner.nextInt();
                    scanner.nextLine();  // Consume the remaining newline character
                    System.out.print("\t\tDoctor gender         : ");
                    gender = scanner.nextLine();
                    System.out.print("\t\tDoctor address        : ");
                    address = scanner.nextLine();
                    System.out.print("\t\tDoctor Id             : ");
                    doctorId = scanner.nextLine();
                    System.out.print("\t\tDoctor specialization : ");
                    specialization = scanner.nextLine();
                    System.out.print("\t\tDoctor department     : ");
                    department = scanner.nextLine();
                    status = true;
                }catch(Exception e){
                    System.out.println("Wrong input.Please try again");
                }
            }
            newDoctor = new Doctor(name, age, gender, address, doctorId, specialization, department);
            return newDoctor;
        }
        
        // Check whether the entered id and password is correct or not
        //      If correct - return true
        //      If wrong   - return false 
        public static boolean loginPatient(Vector<Patient> patientVector, String patientID, String password){   
            String correctPassword = "";
            String str1;
            String str2 = "1234";
            //System.out.println(correctEmail);
            //System.out.println(correctPassword);
            

            for(int i = 0; i < patientVector.size(); i++){
                if(patientID.equals(patientVector.get(i).getPatientId())){
                    str1 =  patientVector.get(i).getPatientId();
                    correctPassword = str1 + str2;
                }
            }

            
            // nanti gantikan email ni dengan email and password yg betul utk patient
            if(password.equals(correctPassword)){
                System.out.println("\n\n\t\tLogin Successful. Redirecting to the Dashboard. Please wait");
                pauseScreen();
                return true;
            }
            else{
                System.out.println("\n\n\t\t\tTry again. Please enter the correct credentials");   
                pauseScreen();
                return false; }
        }

        
        // Check whether the entered id and password is correct or not
        //      If correct - return true
        //      If wrong   - return false 
        public static boolean loginDoctor(Vector<Doctor> doctorVector, String doctorID, String password){      
            String correctPassword = "";
            String str1;
            String str2 = "1234";
            //System.out.println(correctEmail);
            //System.out.println(correctPassword);
            

            for(int i = 0; i < doctorVector.size(); i++){
                if(doctorID.equals(doctorVector.get(i).getDoctorId())){
                    str1 =  doctorVector.get(i).getDoctorId();
                    correctPassword = str1 + str2;
                }
            }

            
            // nanti gantikan email ni dengan email and password yg betul utk patient
            if(password.equals(correctPassword)){
                System.out.println("\n\n\t\tLogin Successful. Redirecting to the Dashboard. Please wait");
                pauseScreen();
                return true;
            }
            else{
                System.out.println("\n\n\t\t\tTry again. Please enter the correct credentials");   
                pauseScreen();
                return false; }
        }
        
        // Get the Patient index in the vector
        public static int getIndex(Vector<Patient> pVector, String pId){
            int index = -1;
              for(int i = 0; i < pVector.size();i++){
                  if(pId.equals(pVector.get(i).getPatientId())){
                      index = i;
                  }
                  else{}
              }
              return index;
          }
  
        // Get the Doctor index in the vector
        public static int getIndexx(Vector<Doctor> dVector, String dId){
            int index = -1;
              for(int i = 0; i < dVector.size();i++){
                  if(dId.equals(dVector.get(i).getDoctorId())){
                      index = i;
                  }
                  else{}
              }
              return index;
          }
  

        public static boolean loginAdminPage(Scanner scanner){    
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                 Administrator Login Page                =");
            System.out.println("\t\t===========================================================");
            System.out.print("\n\t\t\tEmail    : ");
            scanner.nextLine();
            String email = scanner.nextLine();
            System.out.print("\t\t\tPassword : ");
            String password = scanner.nextLine();
            if(email.equals("ismail@gmail.com") && password.equals("ismail1234")){
                System.out.println("\n\n\t\tLogin Successful. Redirecting to the Dashboard. Please wait");
                pauseScreen();
                return true;
            }
            else{
                System.out.println("\n\n\t\t\tTry again. Please enter the correct credentials");   
                pauseScreen();
                return false; }
        }

        public static void addPatientPage(){
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                     Add Patient Page                    =");
            System.out.println("\t\t===========================================================");
        }
        public static void addDoctorPage(){
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                     Add Doctor Page                     =");
            System.out.println("\t\t===========================================================");
        }
        public static void deletePatientPage(){
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                   Delete Patient Page                   =");
            System.out.println("\t\t===========================================================");
        }
        public static void deleteDoctorPage(){
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                   Delete Doctor Page                    =");
            System.out.println("\t\t===========================================================");
        }

        public static int chooseUserPage(Scanner scanner){
            int temp;
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                Welcome to the User Page                 =");
            System.out.println("\t\t===========================================================");
            System.out.println("\t\tPlease choose which user you want to log in as:");
            System.out.println("\t\t[1] Admin");
            System.out.println("\t\t[2] Patient");
            System.out.println("\t\t[3] Doctor");
            System.out.println("\t\t[4] Exit");
            System.out.print("\t\tPlease enter your choice: ");
            temp = scanner.nextInt();
            return temp;
        }

        public static void welcomeMessage(){   // nanti edit content dalam ni
            System.out.println("\t\t   ==============================================================================");
            System.out.println("\t\t   =                  Welcome to the Hospital Management System                 =");
            System.out.println("\t\t   =                                                                            =");
            System.out.println("\t\t   = This system allows you to manage various aspects of a hospital, including: =");
            System.out.println("\t\t   =            - Managing doctor and patient records                           =");
            System.out.println("\t\t   =            - Scheduling appointments                                       =");
            System.out.println("\t\t   =            - Viewing medical history                                       =");
            System.out.println("\t\t   =                                                                            =");   
            System.out.println("\t\t   ==============================================================================");
        }

        public static int AdministratorPage(Scanner scanner, Admin adminObj) {
            clearScreen();
            System.out.println("\t\t\t\t Hello " + adminObj.getName());
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=            Welcome to the Administrator Page            =");
            System.out.println("\t\t===========================================================");
            System.out.println("\t\tHere is the list of what the administrator can do");
            System.out.println("\t\t[1] Display Admin Information");
            System.out.println("\t\t[2] Add Patient");
            System.out.println("\t\t[3] Delete Patient");
            System.out.println("\t\t[4] Add Doctor");
            System.out.println("\t\t[5] Delete Doctor");
            System.out.println("\t\t[6] View all patient");
            System.out.println("\t\t[7] View all doctor");
            System.out.println("\t\t[8] Return");
            System.out.print("\t\tPlease enter your choice: ");

            int choice = scanner.nextInt();
            return choice;
            // Consume the newline character
        }

  
        public static int patientPage(Scanner scanner) {
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                Welcome to the Patient Page              =");
            System.out.println("\t\t===========================================================");
            System.out.println("\t\tHere is the list of what the patient can do");
            System.out.println("\t\t[1] Display Patient Information");
            System.out.println("\t\t[2] Schedule Appointment");
            System.out.println("\t\t[3] Return");
            System.out.print("\t\tPlease enter your choice: ");

            int choice = scanner.nextInt();
            return choice;
        }

       
        public static int doctorPage(Scanner scanner) {
            clearScreen();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t=                Welcome to the Doctor Page              =");
            System.out.println("\t\t===========================================================");
            System.out.println("\t\tHere is the list of what the doctor can do");
            System.out.println("\t\t[1] Create Medical Records");
            System.out.println("\t\t[2] View Medical Records");
            System.out.println("\t\t[3] Update Medical Records");
            System.out.println("\t\t[4] Delete Medical Records");
            System.out.println("\t\t[5] Return");

            System.out.print("\t\tPlease enter your choice: ");

            int choice = scanner.nextInt();
            return choice;
        }

        private static void exitDisplay(){
            clearScreen();
            System.out.println("\n");
            System.out.println("\t\t   =====================================================================");
            System.out.println("\t\t   =                                                                   =");            
            System.out.println("\t\t   =                   Thank you for using the sytem                   =");
            System.out.println("\t\t   =      This system is brought to you by:                            =");
            System.out.println("\t\t   =           1. Abdul Azim Bin Anuar Veera   (A21EC0001)             =");
            System.out.println("\t\t   =           2. Muhamad Amsyar Bin Ibrahim   (A21EC0058)             =");
            System.out.println("\t\t   =           3. Ayesha Imelda Binti Rohaizan (A21EC0164)             =");
            System.out.println("\t\t   =                                                                   =");   
            System.out.println("\t\t   =====================================================================");
            
        }

        // Clear screen
        private static void clearScreen() {
            System.out.print("\033[H\033[2J"); // ANSI escape sequence to clear console screen
            System.out.flush();
        }

        // Pause screen
        private static void pauseScreen() {
            System.out.println("Press Enter to continue...");
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}