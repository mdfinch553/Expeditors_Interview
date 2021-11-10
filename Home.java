import java.util.ArrayList;

public class Home {
    /**
     * Adress of home
     */
    String address; 
    /**
     * List of names of occupants 
     */
    ArrayList<String> first_names;
    /**
     * Number of occupants in the home
     */
    int num_people_in_house;

    /**
     *  Set the value of address variable
     *  @param value string to set address to
     */
    public void set_address(String value){
        address = value;
    }

     /**
     *  Add name to list of first names and increment the total number of people in the house
     *  @param value string passed into construtor
     */
    public void add_to_names(String value){
        first_names.add(value);
        num_people_in_house++;

    }

    /**
     *  Creates a string that describes all the information about the house, including the address and the number of people 
     *  @return a string representation of all the attributes of the Home object
     */
    public String get_all_home_info(){
        StringBuilder home_info = new StringBuilder();
        home_info.append("Home address: ");
        home_info.append(address);
        home_info.append(" ");
        home_info.append("Number of people in home: ");
        home_info.append(num_people_in_house);
        return home_info.toString();
    }

    /**
     * Default Constructor
     */
    public Home(){
        address = ""; 
        first_names = new ArrayList<String>();
        num_people_in_house = 0;
    }

    /**
     *  Parameterized Constructor
     *  @param address_value a string representing the address
     */
    public Home(String address_value){
        address = address_value; 
        first_names = new ArrayList<String>();
        num_people_in_house = 0;
    }

}
