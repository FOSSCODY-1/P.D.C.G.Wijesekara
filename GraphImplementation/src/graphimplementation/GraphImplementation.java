//Graph implementation using adjacency list representation
package graphimplementation;

import java.io.*;
import java.util.*;



//This class represent a directed graph using adjacency list representation
public class GraphImplementation {

    private int V; //Number of vertices
    private LinkedList<Integer> graph[]; //array list for adjacency list
    
    //constructor
    public GraphImplementation(int v) {
        V=v;
        graph=new LinkedList[v];
        for(int i=0; i<v; ++i)
        {
            graph[i]=new LinkedList();
        }
        
    }
    
    //Adding an edge into the graph
    void addEdge(int tail, int head ){
        graph[tail].add(head); // add head to tail's list
    }
    
    //Breadth First Traversal from a given vertex s
    void BFS(int s)
    {
        //Mark the current node as visited and enqueue it
        //By default set as false
        boolean visited[]=new boolean[V];
        
        //Creating a queue for BFS
        LinkedList<Integer> queue=new LinkedList<Integer>();
        
        //Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
        
        while (queue.size()!=0)
        {
            //Dequeue a vertes from queue nd print it 
            s=queue.poll();
            System.out.print(s+" ");
            
            //Get all adjacent vertices of the dequeued vertex s
            //mark the visited vertices and enqueue to the queue
            Iterator<Integer> i=graph[s].listIterator();
            while(i.hasNext())
            {
                int n=i.next();
                if(!visited[n])
                {
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    } 
    
    //Deapth First Search traversal
    
    //recursive util function used in DFS traversal
    void DFSUtil(int v, boolean visited[])
    {
        //Mark the current node as visited and print it
        visited[v]=true;
        System.out.println(v+" ");
        
        //Traverse the list in either direction, modify the list and
        //obtain the iterators current position in the list
        Iterator<Integer> i=graph[v].listIterator();
        while(i.hasNext())
        {
            int n=i.next();
            if(!visited[n])
                DFSUtil(n, visited);
        }
    }
    
    //The DFS traversal Function. Uses DFSUtil() recursively
    void DFS(int v)
    {
        //Mark all the vertices as visited, false by default
        boolean visited[]=new boolean[V];
        
        //recursive call DFSUtil for every vertex
        DFSUtil(v, visited);
    }
    
    
    
    
    //Main function
    public static void main(String[] args) 
    {
        GraphImplementation g = new GraphImplementation(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println("Following is Breadth First Traversal "+"(starting from vertex 2)");
        g.BFS(2);    
        
        System.out.println("Following is Depth First Traversal "+"(starting from vertex 2)");
        g.DFS(2);                   
        
        
    }
}

package graphimplementation;

/**
 *
 * @author chethani
 */
public class GraphImplementation {

    
    public static void main(String[] args) {
       
    }
}

