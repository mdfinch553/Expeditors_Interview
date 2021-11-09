import java.util.*;

public class HouseAddressTable {
    Hashtable<String, Home> house_addresses; 
    ArrayList<Person> people;

    public HouseAddressTable(){
        people = new ArrayList<Person>();
        house_addresses = new Hashtable<>();
    }
    public HouseAddressTable(ArrayList<Person> p, Hashtable<String, Home> h){
        people = p;
        house_addresses = h;
    }

    public Hashtable<String, Home> get_house_address_table(){
        for (int i = 0; i < people.size(); i++){
            String address = people.get(i).get_full_adress();
            String name = people.get(i).get_first_name();
            if (house_addresses.containsKey(address)){
                house_addresses.get(address).add_to_names(name);
            }
            else {
                Home h = new Home(address);
                h.add_to_names(name);
                house_addresses.put(address, h);
            }
        }
        return house_addresses;
    }
}
