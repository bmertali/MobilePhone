/*
            Write an application that can make some features of a mobile phone.
            This application;
            Should be able to add a new person , to questioning , delete and update persons.
            Check to see if a contact is added or updated.
            Must be exit,list contacts,add new contact , update contact , delete person.
            CLUE:You can create a contact class, and you can create a class that has an
            Arraylist that holds all the contacts and create a class called Mobile Phone.
        */
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static MobilePhone mphone = new MobilePhone("555 555 55 55");

    public static void main(String[] args) {



       startPhone();
        showMenu();
        boolean exit = false;
        while (!exit){
            System.out.println("Choice = (Press 6 to see the menu)");
            int choice = scan.nextInt();

            switch (choice){

                case 0:
                    System.out.println("Exit is done");
                    exit=true;
                    break;
                case 1:
                    mphone.allDirectory();
                    break;
                case 2:
                    addPersonFunction();
                    break;
                case 3:
                    personInquireFunction();
                    break;
                case 4:
                    deletePersonFunction();
                    break;
                case 5:
                    updatePersonFuction();
                    break;
                case 6:
                    showMenu();
                    break;
                 default:
                     System.out.println("Make a proper choice.Try again!");
                     break;
            }
        }


    }

    private static void updatePersonFuction() {
        System.out.println("Name of the person to be updated?");
        String name = scan.next();
        Person findingPerson = mphone.personInquire(name);
        if(findingPerson==null){
            System.out.println("No records found.");
            return;
        }
        System.out.println("New name :");
        String newName = scan.next();
        System.out.println("New telephone number =");
        String newNumber = scan.next();

        mphone.updatePerson(findingPerson,Person.Creating(newName,newNumber));
    }

    private static void deletePersonFunction() {
        System.out.println("Name of the person to be deleted?");
        String name = scan.next();
        Person findingPerson = mphone.personInquire(name);
        if(mphone.deletePerson(findingPerson)){
            System.out.println("Deletion was succeed");
        }
        
    }

    private static void personInquireFunction() {
        System.out.println("Enter the contact name = ");
        String name=scan.next();
        Person findingPerson = mphone.personInquire(name);
        if(findingPerson==null){
            System.out.println("No records for " + name);
            return;
        }
        System.out.println("Found person =" + findingPerson.getName() + " ->" +
                findingPerson.getTelNumber());
    }

    private static void addPersonFunction() {
        System.out.println("New person's name is =");
        String name = scan.next();
        System.out.println("New person's telephone =");
        String number = scan.next();


        mphone.addPerson(Person.Creating(name,number));
    }

    private static void startPhone() {
        System.out.println("Telephone is starting...");
    }

    private static void showMenu() {
        System.out.println("*********MENU*************");
        System.out.println( "0-EXIT \n" +
                            "1-LIST ALL CONTACTS \n" +
                            "2-ADD A NEW PERSON \n" +
                            "3-FIND PERSON \n" +
                            "4-DELETE CONTACT \n" +
                            "5-UPDATE CONTACTS \n" +
                            "6-SHOW THE MENU \n" );
    }
}
