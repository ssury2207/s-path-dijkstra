import java.util.*;
public class Dijkstra {
    public static class Pair{
        int a; int b;
        public Pair(int a, int b){
            this.a = a ; 
            this.b = b;
        }
        public int getA(){
            return a;
        }
        public int getB(){
            return b;
        }
    }
    //will find the shortest path from source node to other nodes
    public static void findShortestPath( ArrayList<Pair>[] graph, int source, int n){
        int dist[] = new int[n+1];
        //currently every node is at the infinite distance
        Arrays.fill( dist, Integer.MAX_VALUE);
        //little different configuration of PQ 
        //it is dist, node not to get confused with the graph config
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> Integer.compare( a.getA(), b.getA() ) );
        //dist from source to source is always 0
        dist[source] = 0;
        pq.add( new Pair(0, source) );

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int currDist = p.getA();
            int currNode = p.getB();

            for( Pair newPair : graph[currNode] ){
                //do mind this is graph 
                int curr_new_node = newPair.getA();
                int curr_new_weight = newPair.getB();
                //if I want to go from currNode to curr_new_node the distance is 
                //currDist + curr_new_weight < dist[curr_new_node]
                if( currDist + curr_new_weight < dist[curr_new_node] ){
                    dist[curr_new_node] =  currDist + curr_new_weight;
                    pq.add( new Pair (dist[curr_new_node], curr_new_node ));
                }
            }

        }
        
        System.out.println("----------------");
        for(int i=1; i<=n; i++){
            System.out.println(i+" ---> "+dist[i]);
        }

    }
     
    public static void main (String [] args){
       int source = 2;  
       //node connection //cost 
       int config[][] = { {2,1,1},{2,3,1},{3,4,1} };
       int n = 4;//number of nodes
       int m = config.length;
       ArrayList<Pair>[] graph = new ArrayList[n+1];
       for(int i=0; i<=n; i++){
        graph[i] = new ArrayList<>();
       }
       for(int i=0 ;i<m; i++){
        int node = config[i][0];
        int neighbour = config[i][1];
        int cost = config[i][2];
        //add node, cost
        graph[node].add( new Pair(neighbour, cost ));
       }
        findShortestPath(graph, source, n);
 

    }
}
