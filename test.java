public class test {

    public static void main (String [] args){
        Node a = new Node("Rome");

        Node b = new Node("Greece");

        Node c = new Node("New York");

        Node d = new Node("Budapest");

        Node e = new Node("Beijing");

        Node f = new Node("Los Angeles");

        graph x = new graph();

        x.add_Node(a);
        x.add_Node(b);
        x.add_Node(c);
        x.add_Node(d);
        x.add_Node(e);
        x.add_Node(f);
        a.addConnection(b.name, 10);
        a.addConnection(c.name, 5);
        c.addConnection(d.name, 5);
        b.addConnection(d.name, 20);
        d.addConnection(e.name, 10);
        e.addConnection(f.name, 10);
        
        System.out.println(x.QuickestAtoB("Rome", "Los Angeles"));




        System.out.println(a.distanceTo("Greece"));

        String[] names = {"Rome", "Greece"};
        int[] distances = {20, 30};


        x.add_Node(a);
        x.add_Node(b);
        x.add_Node(c);
        x.printDistances();

        System.out.println(x.QuickestAtoB("Rome", "Greece"));
    }
    
}
