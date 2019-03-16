import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Person> directory;
    private String myNumber;


    public MobilePhone(String myNumber){
        this.myNumber=myNumber;
        this.directory=new ArrayList<>();
    }
    public boolean addPerson(Person nPerson){
        if(findPerson(nPerson.getName()) >= 0){
            System.out.println(nPerson.getName() + " values has already exist in directory.");
            return false;
        }

        this.directory.add(nPerson);
        return true;
    }
    public int findPerson(Person findingPerson){
        return this.directory.indexOf(findingPerson);
        //Kişi nesnesi bu rehberde varsa index değeri döndürülecek.
    }
    public int findPerson(String name){
        for(int i =0;i<this.directory.size();i++){
            Person currentPersonObject = this.directory.get(i); // o anki kişi nesnesi
            if(currentPersonObject.getName().equals(name)){
                    return i;}

        }
        return -1;
    }

    public Person personInquire(String name){
        int position =findPerson(name);
        if(position>=0){
            return directory.get(position);
        }
        return null;
    }
    public boolean deletePerson(Person dPerson){
       int position = findPerson(dPerson);
       if(position<0){
           System.out.println("There is no such a person");
           return false;
       }
       this.directory.remove(dPerson);
       return true;
    }
    public boolean updatePerson(Person oldPerson,Person newPerson){
        int position = findPerson(oldPerson);
        if(position<0){
            System.out.println("No registered contacts.");
            return false;
        }
        directory.set(position,newPerson);
        System.out.println(oldPerson.getName() + " values changed " +
                newPerson.getName());
        return true;
    }
    public void allDirectory(){
        System.out.println("\n ********* ALL DIRECTORY ********");
        if(directory.size()==0){
            System.out.println("No registered contacts!!\n\n");
            return;
        }
        for(int i=0;i<this.directory.size(); i++){
            System.out.println((i+1) + "- " +directory.get(i).getName() +
                    " ->" + directory.get(i).getTelNumber());
        }
    }


}
