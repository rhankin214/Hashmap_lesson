import java.util.ArrayList;
import java.util.function.*;

public class Main {

    public static void main(String [] args){
        Function<Integer, Integer> hash_func1 = a -> a * 0;

        Hashmap<Integer> map1 = new Hashmap<Integer>(hash_func1, 5);
        Integer[] map1_elements = {0, 1, 2, 3, 4};

        map1.insert_multiple(map1_elements);

        map1.print_buckets();

        map1.print_speed();

        Function<Integer, Integer> hash_func2 = a -> a/4;

        Hashmap<Integer> map2 = new Hashmap<Integer>(hash_func2, 5);

        map2.insert_multiple(map1_elements);

        map2.print_buckets();

        map2.print_speed();


        Hashmap<Integer> overtaxedHashmap = new Hashmap<Integer>(hash_func2, 5);

        for(int i = 0; i < 100; i++){
            overtaxedHashmap.insert(i);
        }

        overtaxedHashmap.print_buckets();
        overtaxedHashmap.print_speed();
       
    }
    
}
