public class Person {
    // Variables
    private String name;
    private int age;
    private String gender;
    private String address;

    // Constructor
    public Person(String name, int age, String gender, String address){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    // Mutator
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setAddress(String address){
        this.address = address;
    }

    // Accessor
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    public String getAddress(){
        return address;
    }

}

