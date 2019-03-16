public class Person {

    private String name;
    private String telNumber;

    public Person(String name, String telNumber) {
        this.name = name;
        this.telNumber=telNumber;
    }

    public String getName() {
        return name;
    }

    public String getTelNumber() {
        return telNumber;
    }
    public static Person Creating(String name,String telNumber){
        return new Person(name,telNumber);
    }
    //We use static because we wanted to use this function without using a new object.
}
