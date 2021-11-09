public class Person {
    String first_name; 
    String last_name;
    String address; 
    String city; 
    String state;
    String full_adress; 
    Integer age; 
    public Person(){
        first_name = ""; 
        last_name = "";
        address = ""; 
        full_adress = "";
        city = ""; 
        state = "";
        age = 0; 
    }
    public void set_first_name(String name){
        first_name = name;
    }
    public String get_first_name(){
        return first_name;
    }
    public void set_last_name(String name){
        last_name = name;
    }
    public void set_address(String value){
        address = value;
    }
    public void set_city(String value){
        city = value;
    }
    public void set_state(String value){
        state = value;
    }
    public void set_age(Integer value){
        age = value;
    }
    public Integer get_age(){
        return age;
    }
    public void set_full_adress(){
        StringBuilder build_adress = new StringBuilder();
        build_adress.append(address.toLowerCase());
        build_adress.append(" ");
        build_adress.append(city.toLowerCase());
        build_adress.append(" ");
        build_adress.append(state.toLowerCase());
        full_adress = build_adress.toString();
    }
    public String get_full_adress(){
        return full_adress;
    }
    public String get_all_person_info(){
        StringBuilder person_info = new StringBuilder();
        person_info.append(first_name);
        person_info.append(" ");
        person_info.append(last_name);
        person_info.append(" ");
        person_info.append(full_adress);
        person_info.append(" ");
        person_info.append(age.toString());
        person_info.append(" ");
        return (person_info.toString());
    }
}
