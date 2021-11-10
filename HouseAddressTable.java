import java.util.*;
/**
 * Object that represents the hashtable in whic information on unique houses is stored
 */
public class HouseAddressTable {
    /**
     * Hashtable mapping house addresses to instances of homes
     */
    Hashtable<String, Home> house_addresses; 
    /**
     * Array list containing people from input file 
     */
    ArrayList<Person> people;

    /**
     * Default Constructor
     */
    public HouseAddressTable(){
        people = new ArrayList<Person>();
        house_addresses = new Hashtable<>();
    }
    
    /**
     *  Parameterized Constructor
     *  @param p an arraylist of people
     *  @param h a hashtable mapping addresses and homes
     */
    public HouseAddressTable(ArrayList<Person> p, Hashtable<String, Home> h){
        people = p;
        house_addresses = h;
    }

    /**
     *  Method that iterates through list of people and builds the hash table with adresses and Home objects 
     * @return house_addresses: A hashtable mapping adresses to Home instances
     */
    public Hashtable<String, Home> get_house_address_table(){
        //iterate through list of people
        for (int i = 0; i < people.size(); i++){
            //Get name and address of current person
            String address = people.get(i).get_full_adress();
            String name = people.get(i).get_first_name();

            //if address already in hash table, add name of person to list of names in Home object 
            if (house_addresses.containsKey(address)){
                house_addresses.get(address).add_to_names(name);
            }
            //Otherwise, create a new instance in the table
            else {
                Home h = new Home(address);
                h.add_to_names(name);
                house_addresses.put(address, h);
            }
        }
        return house_addresses;
    }
}
