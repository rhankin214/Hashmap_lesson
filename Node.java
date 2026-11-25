import java.util.ArrayList;

public class Node {
    String name;
    ArrayList<String> neighbors;
    ArrayList<Integer> distances;



    public Node(String name){
        this.name = name;

        neighbors = new ArrayList<String>();
        distances = new ArrayList<Integer>();
    }

    public Node(String name, String[] neighbors, int[] distances){
        this.name = name;

        this.neighbors = new ArrayList<String>();
        this.distances = new ArrayList<Integer>();

        for(int i = 0; i < neighbors.length; i++){
            this.neighbors.add(neighbors[i]);
            this.distances.add(distances[i]);
        }
    }

    public void addConnection(String neighbor, int distance){
        neighbors.add(neighbor);
        distances.add(distance);

    }



    public int distanceTo(String B){
        if(neighbors.contains(B)){
            return distances.get(neighbors.indexOf(B));
        } else {
            return -1;
        }
    }
    
}
