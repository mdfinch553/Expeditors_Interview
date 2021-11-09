import java.util.ArrayList;

public class Home {
    String address; 
    ArrayList<String> first_names;
    int num_people_in_house;
    public void set_address(String value){
        address = value;
    }
    public void add_to_names(String value){
        first_names.add(value);
        System.out.print(num_people_in_house);
        num_people_in_house++;
        System.out.print("THIS IS BEING CALLED");
        System.out.println(num_people_in_house);

    }
    public String get_all_home_info(){
        StringBuilder home_info = new StringBuilder();
        home_info.append("Home address: ");
        home_info.append(address);
        home_info.append(" ");
        home_info.append("Number of people in home: ");
        home_info.append(num_people_in_house);
        return home_info.toString();
    }

    public Home(){
        address = ""; 
        first_names = new ArrayList<String>();
        num_people_in_house = 0;
    }
    public Home(String value){
        address = value; 
        first_names = new ArrayList<String>();
        num_people_in_house = 0;
    }

}
