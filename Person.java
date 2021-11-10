public class Person {
    /**
     * Attributes of a person(
     */
    String first_name; 
    String last_name;
    String address; 
    String city; 
    String state;
    String full_adress; 
    Integer age; 

    /**
     * Default Constructor
     */
    public Person(){
        first_name = ""; 
        last_name = "";
        address = ""; 
        full_adress = "";
        city = ""; 
        state = "";
        age = 0; 
    }

    /**
     *  Set the value of first_name
     *  @param name string to set first_name to
     */
    public void set_first_name(String name){
        first_name = name;
    }

    /**
     *  get the value of first_name
     *  @return first name of person
     */
    public String get_first_name(){
        return first_name;
    }

    /**
     *  Set the value of last_name
     *  @param name string to set last name to
     */
    public void set_last_name(String name){
        last_name = name;
    }

    /**
     *  get the value of last_name
     *  @return last name of person
     */
    public String get_last_name(){
        return last_name;
    }

    /**
     *  Set the value of address
     *  @param value string to set address to
     */
    public void set_address(String value){
        address = value;
    }

    /**
     *  Set the value of city
     *  @param value string to set city to
     */
    public void set_city(String value){
        city = value;
    }

    /**
     *  Set the value of state
     *  @param value string to set state to
     */
    public void set_state(String value){
        state = value;
    }

    /**
     *  Set the value of age
     *  @param value string to set age to
     */
    public void set_age(Integer value){
        age = value;
    }

    /**
     *  get the value of age
     *  @return age of person
     */
    public Integer get_age(){
        return age;
    }

    /**
     *  Combine person's address, city, and state into one 
     *  large address
     */
    public void set_full_adress(){
        StringBuilder build_adress = new StringBuilder();
        build_adress.append(address.toLowerCase());
        build_adress.append(" ");
        build_adress.append(city.toLowerCase());
        build_adress.append(" ");
        build_adress.append(state.toLowerCase());
        full_adress = build_adress.toString();
    }

    /**
     *  get the full address of a person
     *  @return the full address
     */
    public String get_full_adress(){
        return full_adress;
    }

    /**
     *  Creates a string that describes all the information about a person
     *  @return a string representation of all the attributes of the Person object
     */
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

    /**
     *  Compares two people based on first name and last name
     *  @param other_person another person object 
     *  @return true if person's name is first alpabetically when compared with the other person 
     */
    public Boolean compare_to_other_person(Person other_person){
        String other_last_name = other_person.get_last_name();
        //last name higher alphabetically 
        if (last_name.compareTo(other_last_name) > 0){
            return true; 
        }
        //last names are same
        else if (last_name.compareTo(other_last_name) == 0){
            String other_first_name = other_person.get_first_name();
            //first name higher alphabetically 
            if (first_name.compareTo(other_first_name) > 0){
                return true;
            }
            else {
                return false; 
            }
        }
        //last name is lower alphabetically
        else {
            return false; 
        }
    }
}
