package A2;
import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        WGraph mst = new WGraph() ;
        List < Edge > edgelist = g.listOfEdgesSorted() ;
        DisjointSets a = new DisjointSets(g.getNbNodes()) ;
        int index = 0 ;
        while( mst.getNbNodes() != g.getNbNodes()) {
        	Edge e = edgelist.get(index) ;
        	if ( IsSafe( a , e ) ){
        		mst.addEdge( e ); 
        		a.union( e.nodes[0], e.nodes[1] ) ;
        	}
        	index++ ;
        }
        return mst ; 
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){

        return p.find (e.nodes[0]) != p.find (e.nodes[1]) ;
       
    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
