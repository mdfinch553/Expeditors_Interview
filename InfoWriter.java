import java.util.*;
import java.io.*;

public class InfoWriter{
    /**
     * Array list containing people from input file 
     */
    ArrayList<Person> people;
    /**
     * Hashtable mapping house addresses to instances of homes
     */
    Hashtable<String, Home> house_addresses;

     /**
     * Default Constructor
     */
    public InfoWriter(){
        people = new ArrayList<Person>();
        house_addresses = new Hashtable<>();
    }

    /**
     *  Parameterized Constructor
     *  @param p an arraylist of people
     *  @param h a hashtable mapping addresses and homes
     */
    public InfoWriter(ArrayList<Person> p, Hashtable<String, Home> h){
        people = p;
        house_addresses = h;
    }

    /**
     *  Creates a string that describes information about people over 18 in list 
     *  @return a string representation of persons above the age of 18
     */
    String get_person_info(){
        //sort the list of people based on last name then first name
        SortPeople person_sorter = new SortPeople(people);
        person_sorter.quicksort_people(0, people.size()-1);

        //use string builder to build a string about person information 
        StringBuilder all_person_info = new StringBuilder();
        for (int i = 0; i < people.size(); i++) {
            Integer age = people.get(i).get_age();

            //if age is > 18 add information to string
            if (age > 18){
                String person_info = people.get(i).get_all_person_info();  
                all_person_info.append(person_info);
                all_person_info.append("\n");
            }
        }
        return all_person_info.toString();
    }

    /**
     *  Creates a string that describes information about each unique house 
     *  @return a string representation of each home object
     */
    String get_home_info(){
        StringBuilder all_home_info = new StringBuilder();
        Set<String> house_address_keys = house_addresses.keySet();
        for (String key : house_address_keys) {
            String house_info = house_addresses.get(key).get_all_home_info();    
            all_home_info.append(house_info);
            all_home_info.append("\n");
        }
        return all_home_info.toString();
    }

    /**
     *  Use FileWriter class to write information to file 
     */
    public void write_info_to_file(){
        String all_home_info = get_home_info();
        String all_person_info = get_person_info();
        try {
            FileWriter homeWriter = new FileWriter("output.txt");
            homeWriter.write("Households and Number of Occupants:\n");
            homeWriter.write("\n");
            homeWriter.write(all_home_info);
            homeWriter.write("\n");
            homeWriter.write("Occupants over 18:\n");
            homeWriter.write("\n");
            homeWriter.write(all_person_info);
            homeWriter.write("\n");
            homeWriter.close();
          } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
          }
    }
}