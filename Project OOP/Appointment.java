
import java.util.*;

public class Appointment {

    private String time;
    private String date;
    private Hospital hospobj;
    /**
     * @return the hospobj
     */
    public Hospital getHospobj() {
        return hospobj;
    }

    /**
     * @param hospobj the hospobj to set
     */
    public void setHospobj(Hospital hospobj) {
        this.hospobj = hospobj;
    }

    Vector<Room> room=new Vector<Room>();
    /**
     * @return the room
     */
    public Vector<Room> getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Vector<Room> room) {
        this.room = room;
    }

    Vector<Doctor> doc=new Vector<Doctor>();

    public Appointment(Doctor doctor, String time, String date) {
        this.doc.add(doctor);
        this.time = time;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void displayAppInfo(){
        System.out.println("Date: "+date);
        System.out.println("Time: "+time);
        System.out.println("Hospital: "+hospobj.getHospitalName());
        System.out.println("Address: "+hospobj.getAddress());
        System.out.println("Contact: "+hospobj.getContactNumber());
        System.out.println("Doctor: "+doc.get(0).getName());
        System.out.println("Room No.: "+room.get(0).getRoomNO());
    }
}
