public class Room {
    // Attributes
    private String roomNO;
    private int roomCapacity;
   
    public Room(String roomNO, int roomCapacity) {
 
        this.roomNO = roomNO;
        this.roomCapacity = roomCapacity;
    }

    public void setRoomNO(String roomNO) {
        this.roomNO = roomNO;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getRoomNO() {
        return roomNO;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void displayRoomInfo(){
        System.out.println("\n================(Room Information)==============\n");
        System.out.println("Room No.: "+roomNO);
        System.out.println("Room Capacity: "+roomCapacity);
        System.out.println("\n================================================");
    }
}

