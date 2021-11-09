import java.util.*; 

public class SortPeople {
    ArrayList<Person> people;
    public SortPeople(){
        people = new ArrayList<Person>();
    }
    public SortPeople(ArrayList<Person> p){
        people = p;
    }
    int partition(int low_index, int high_index){
        Person pivot_point = people.get(high_index);
        int i = low_index - 1;
        for (int j = low_index; j < high_index;  j++){
            Person curr_instance = people.get(j);
            if (pivot_point.compare_to_other_person(curr_instance)){
                i++; 
                Collections.swap(people, i, j);
            }
        }
        Collections.swap(people, i + 1, high_index);
        return (i + 1);
    }
   public void quicksort_people(int low_index, int high_index){
        if (low_index < high_index){
            int partition_index = partition(low_index, high_index);
            quicksort_people(low_index, partition_index - 1); 
            quicksort_people(partition_index + 1, high_index);
        }
    }
}