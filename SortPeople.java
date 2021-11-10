import java.util.*; 

public class SortPeople {
    /**
     * Array list containing people from input file 
     */
    ArrayList<Person> people;

     /**
     * Default Constructor
     */
    public SortPeople(){
        people = new ArrayList<Person>();
    }

    /**
     *  Parameterized Constructor
     *  @param p an arraylist of people
     */
    public SortPeople(ArrayList<Person> p){
        people = p;
    }

    /**
     *  Get the partition point to use in quicksort 
     *  @param low_index
     *  @param high_index 
     */
    int partition(int low_index, int high_index){
        Person pivot_point = people.get(high_index);
        int i = low_index - 1;
        for (int j = low_index; j < high_index;  j++){
            Person curr_instance = people.get(j);
            //compare people by first and last names, if greater, then swap
            if (pivot_point.compare_to_other_person(curr_instance)){
                i++; 
                Collections.swap(people, i, j);
            }
        }
        //do additional swaping
        Collections.swap(people, i + 1, high_index);
        //return pivot point 
        return (i + 1);
    }

    /**
     *  Quicksort algorthm to sort people by last name then first name
     *  @param low_index
     *  @param high_index 
     */
   public void quicksort_people(int low_index, int high_index){
        if (low_index < high_index){
            int partition_index = partition(low_index, high_index);
            quicksort_people(low_index, partition_index - 1); 
            quicksort_people(partition_index + 1, high_index);
        }
    }
}