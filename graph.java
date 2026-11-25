import java.util.HashMap;

import java.util.PriorityQueue;

import java.util.ArrayList;

public class graph {
    private HashMap<String, Node> stops;

    public graph(){
        stops = new HashMap<String, Node>();
    }

    public void connectTwo(String a, String b, int distance){
        stops.get(a).addConnection(b, distance);

        stops.get(b).addConnection(a, distance);
    }

    public void add_Node(Node N){
        stops.put(N.name, N);
    }

    public int checkDistanceOfNeighbors(String A, String B){
        Node a = stops.get(A);
        Node b = stops.get(B);

        if(a.distanceTo(B) != -1){
           return a.distanceTo(B);
        } else if (b.distanceTo(A) != -1) {
            return b.distanceTo(A);
        } else {
            return -1;
        }
    }

    public void printDistances(){
        for(Node n : stops.values()){
            System.out.print(n.name + ": ");
            for(String neighbor : n.neighbors){
                System.out.print(neighbor + "-" + n.distanceTo(neighbor) + ", ");
            }
            System.out.println();
        }
    }


    public int QuickestAtoB(String A, String B){
        HashMap<String, Integer> shortestDistances = new HashMap<String, Integer>();

        HashMap<String, String> bestPrevStop = new HashMap<String, String>();

        PriorityQueue<String> queue = new PriorityQueue<String>((a, b) -> shortestDistances.get(a) - shortestDistances.get(b));
        shortestDistances.put(A, 0);
        queue.add(A);


        while(queue.size() != 0){
        
            String name = queue.remove();

            Node stop = stops.get(name);

            int pathSoFar = shortestDistances.get(name);
            
            for(String neighbor : stop.neighbors){
                
                int distanceToNode = stop.distanceTo(neighbor);

                if(shortestDistances.containsKey(neighbor)){

                    if(shortestDistances.get(neighbor) > pathSoFar + distanceToNode){
                        System.out.println(neighbor + " is the best path to " + stop.name);
                        shortestDistances.put(neighbor, pathSoFar + distanceToNode);
                        
                        bestPrevStop.put(neighbor, stop.name);
                        queue.add(neighbor);
                    }

                } else {
                    System.out.println(neighbor + " is the best path to " + stop.name);
                    shortestDistances.put(neighbor, pathSoFar + distanceToNode);
                    bestPrevStop.put(neighbor, stop.name);
                    queue.add(neighbor);
                }
            }
        }

        ArrayList<String> bestPath = new ArrayList<String>();

        bestPath.add(0, B);


        while(bestPath.get(0) != A){
            String current_stop = bestPath.get(0);
            String next_stop = bestPrevStop.get(current_stop);
            bestPath.add(0, next_stop);
        }

        //for(String step : bestPath){
        //    System.out.print(step + "->");
        //}

        return shortestDistances.get(B);
        
    }
}
