import java.io.*;
import java.util.*;

public class CodeDriver {
    public CodeDriver() throws IOException {
        //make an array to represent each person in the file 
        ArrayList<Person> people = new ArrayList<Person>();
        //open scanner to read through input file, use "" delimiter to seperate words
        Scanner sc = new Scanner(new FileReader("input.txt")).useDelimiter("\\s*\"\\s*");

        //hashtable to store unique house addresses
        Hashtable<String, Home> house_addresses = new Hashtable<>();

        ReadFromFile file_reader = new ReadFromFile(sc);
        people = file_reader.get_list_of_people_from_file();

        HouseAddressTable households = new HouseAddressTable(people, house_addresses);
        house_addresses = households.get_house_address_table();

        InfoWriter write_to_file = new InfoWriter(people, house_addresses);
        write_to_file.write_info_to_file();
    }
}
