import java.util.ArrayList;
import java.util.function.*;

public class Hashmap<T> {
    
    int bucket_count;
    ArrayList<ArrayList<T>> buckets;
    Function<T, Integer> hash_func;

    //constructor

    public Hashmap(Function<T, Integer> f, int bucket_count){
        hash_func = f;
        buckets = new ArrayList<ArrayList<T>>();
        this.bucket_count = bucket_count;

        for(int i = 0; i < bucket_count; i++){
            buckets.add(new ArrayList<T>());
        }
    }
    
    public void insert(T element){
        //TODO: how do we insert to the hash table?
    }

    public void find(){
        //TODO: how do we find an element in a hash table?
    }

    public void remove(){
        //TODO: how do we remove an element in a hash table?
    }

    public void rehash(int new_bucket_count){
        //TODO: how do we rehash?

    }

    public void insert_multiple(T[] list){
        for(T item : list){
            insert(item);
        }

    }

    public void print_buckets(){
        for(ArrayList<T> bucket : buckets){
            System.out.print("[");
            for(T item : bucket){
                System.out.print(" " + item + ",");
            }
            System.out.print("]\n");

        }
    }

    public void print_speed(){
        float av_speed = 0;
        int used_buckets = 0;

        for(ArrayList<T> bucket : buckets){
            if (bucket.size() > 0){
                used_buckets += 1;
                av_speed += (bucket.size()+1)/2;
            }
        }
        av_speed /= used_buckets;

        System.out.println("On average, you'll check " + av_speed + " elements to find something in this table.");
    }
    
}
