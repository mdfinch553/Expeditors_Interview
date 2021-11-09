import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    public static boolean isInteger(String word){
        try {
            Integer.parseInt(word);
            return true;
        } catch (NumberFormatException e) {
            
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //make an array to represent each person in the file 
        ArrayList<Person> people = new ArrayList<Person>();
        //open scanner to read through input file, use "" delimiter to seperate words
        Scanner sc = new Scanner(new FileReader("input.txt")).useDelimiter("\\s*\"\\s*");
        //default person to get info from file
        Person p = new Person(); 
        //p counter is used to keep track of which attribute is being checked
        int p_counter = 0;

        //hashtable to store unique house addresses
        Hashtable<String, Home> house_addresses = new Hashtable<>();



        //loop through each word
        while (sc.hasNext()) {
            //get next word
            String next_word = sc.next();
            //make sure word is not a comma
            if (!next_word.equals(",") && next_word.matches(".*\\w.*")){
                //if is integer, then last attribute
                System.out.println(next_word);
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
                            System.out.println(address);
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

        //go through each person and check their adress against the hash table. If in hash table, add to home object, else, return nothing 
        for (int i = 0; i < people.size(); i++){
            String address = people.get(i).get_full_adress();
            String name = people.get(i).get_first_name();
            System.out.println(address);
            System.out.println(name);
            System.out.println(house_addresses.containsKey(address));
            if (house_addresses.containsKey(address)){
                System.out.println("HELLO");
                house_addresses.get(address).add_to_names(name);
            }
            else {
                Home h = new Home(address);
                h.add_to_names(name);
                house_addresses.put(address, h);
            }
        }

        StringBuilder all_home_info = new StringBuilder();
        Set<String> house_address_keys = house_addresses.keySet();
        for (String key : house_address_keys) {
            String house_info = house_addresses.get(key).get_all_home_info();    
            all_home_info.append(house_info);
            all_home_info.append("\n");
        }

        System.out.println(all_home_info);

        StringBuilder all_person_info = new StringBuilder();
        for (int i = 0; i < people.size(); i++) {
            Integer age = people.get(i).get_age();
            if (age > 18){
                String person_info = people.get(i).get_all_person_info();  
                all_person_info.append(person_info);
                all_person_info.append("\n");
            }
        }
        System.out.println(all_person_info);

        try {
            FileWriter homeWriter = new FileWriter("output.txt");
            homeWriter.write("Households and Number of Occupants:\n");
            homeWriter.write("\n");
            homeWriter.write(all_home_info.toString());
            homeWriter.write("\n");
            homeWriter.write("Occupants over 18:\n");
            homeWriter.write("\n");
            homeWriter.write(all_person_info.toString());
            homeWriter.write("\n");
            homeWriter.close();
          } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
          }
    }
}