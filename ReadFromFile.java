import java.io.*;
import java.util.*;

public class ReadFromFile {
    /**
     * Array list containing people from input file 
     */
    ArrayList<Person> people;
    /**
     * scanner for reading file
     */
    Scanner sc;

    /**
     * Default Constructor
     */
    public ReadFromFile() throws IOException{
        people = new ArrayList<Person>();
        //open scanner to read through input file, use "" delimiter to seperate words
        sc = new Scanner(new FileReader("input.txt")).useDelimiter("\\s*\"\\s*");
    }

    /**
     * Checks to see if word can be parsed to integer
     * @param word word to parse to integer
     * @return bool 
     */
    boolean isInteger(String word){
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("cannot be parsed to integer");
        }
        return false;
    }

    /**
     * Reads through file and builds an ArrayList of each person 
     * @return list of Persons extracted from fule 
     */
    public ArrayList<Person> get_list_of_people_from_file(){
        Person p = new Person(); 
        //p counter is used to keep track of which attribute is being checked
        int p_counter = 0;

        //loop through each word
        while (sc.hasNext()) {
            //get next word
            String next_word = sc.next();
            //make sure word is not a comma
            if (!next_word.equals(",") && next_word.matches(".*\\w.*")){
                //if is integer, then last attribute
                if (isInteger(next_word)){
                    //convert age to integer and set the age of person p
                    Integer age = Integer.parseInt(next_word);
                    p.set_age(age);

                    //now that all information is there, set the full address attribute of p
                    p.set_full_adress();

                    //add person p to list of people, reset p and p_counter to accomadaye a new person
                    people.add(p);
                    p = new Person();
                    p_counter = 0;
                }
                else {
                    switch(p_counter){
                        //set attribute of p depending on what the current value of p counter is 
                        case 0: p.set_first_name(next_word);
                        case 1: p.set_last_name(next_word);
                        case 2: 
                            String address = next_word.replace(".", "");
                            address = address.replace (",", "");
                            p.set_address(address);
                        case 3: p.set_city(next_word);
                        case 4: p.set_state(next_word);
                        default: 
                    }
                    p_counter++;
                }
            }
        }
        sc.close();

        return people;

    }
    
}
