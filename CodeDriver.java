import java.io.*;
import java.util.*;
/**
 * Object that runs the program 
 */
public class CodeDriver {
    /**
     * Public constructor. Runs the program when and instance of CodeDriver is created by main 
     */
    public CodeDriver() throws IOException {
        //make an array to represent each person in the file 
        ArrayList<Person> people = new ArrayList<Person>();

        //hashtable to store unique house addresses
        Hashtable<String, Home> house_addresses = new Hashtable<>();

        //read infor from file and get list of people
        ReadFromFile file_reader = new ReadFromFile();
        people = file_reader.get_list_of_people_from_file();

        //get the table of unique homes, addresses, and numbers of occupants 
        HouseAddressTable households = new HouseAddressTable(people, house_addresses);
        house_addresses = households.get_house_address_table();

        //write information to file
        InfoWriter write_to_file = new InfoWriter(people, house_addresses);
        write_to_file.write_info_to_file();
    }
}
