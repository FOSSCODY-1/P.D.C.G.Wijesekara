//Graph implementation using adjacency list representation
package graphimplementation;

import java.io.*;
import java.util.*;

//This class represent a directed graph using adjacency list representation
public class GraphImplementation 
{
    private int V; //Number of vertices
    private LinkedList<Integer> graph[]; //array list for adjacency list
    
    //constructor
    public GraphImplementation(int v) 
    {
        V=v;
        graph=new LinkedList[v];
        for(int i=0; i<v; ++i)
        {
            graph[i]=new LinkedList();
        }
        
    }
    
    //Adding an edge into the graph
    public void addEdge(int tail, int head )
    {
        graph[tail].add(head); // add head to tail's list
    }
    
    //Breadth First Traversal from a given vertex s
    public void BFS(int s)
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
   public void DFSUtil(int v, boolean visited[])
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
    public void DFS(int v)
    {
        //Mark all the vertices as visited, false by default
        boolean visited[]=new boolean[V];
        
        //recursive call DFSUtil for every vertex
        DFSUtil(v, visited);
    }
    
    //Function to print the adjacency list representation of graph
    public void displayGraph(GraphImplementation graphE)
    {
        System.out.println("\nDisplay the graph");
        //System.out.println("\n");
        for(int v=0; v< graphE.V; v++)
        {
            System.out.println("Adjacency list of vertex "+v);
            System.out.println("head");
            for(Integer pCrawl:graphE.graph[v])
            {
                System.out.println(" -> " +pCrawl);
            }
            System.out.println("\n");
        }
    }
    
    //Main function
    public static void main(String[] args) 
    {
        Scanner t = new Scanner(System.in);
        
        //Get number of vertices as user input
        System.out.println("Insert Number of Vertices : ");
        int x= t.nextInt();
        
        
        GraphImplementation g = new GraphImplementation(x); //creating an instance of class named as g
        
        int tail, head, i=1;
        
        while(i!=0)
        {
            System.out.println("Enter 1 to insert an edge.");
            System.out.println("Enter 2 to get the BFS.");
            System.out.println("Enter 3 to get the DFS.");
            System.out.println("Enter 4 to Display the graph");
            System.out.println("Enter 0 to exit.");
            
            i=t.nextInt();
        
            switch(i)
            {
                case 1:
                    System.out.println("Insert tail of the edge : ");
                    tail=t.nextInt();
                    System.out.println("Insert head of the edge : ");
                    head=t.nextInt();
                    g.addEdge(tail, head);
                    break;

                case 2:
                    System.out.println("Enter the starting vertex : ");

                    System.out.println("\nFollowing is Breadth First Traversal "+"(starting from vertex 2)");
                    //Call the BFS function
                    g.BFS(2);
                    break;

                case 3:
                    System.out.println("\nFollowing is Depth First Traversal "+"(starting from vertex 2)");
                    //Call the DFS function
                    g.DFS(2);
                    break;

                case 4:
                    //Print the graph
                    g.displayGraph(g);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default :
                    System.out.println("\nEnter a valid option.");
            }
            
        }
        
           
//        GraphImplementation g = new GraphImplementation(5);
//        
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//        System.out.println("\nFollowing is Breadth First Traversal "+"(starting from vertex 2)");
//        //Call the BFS function
//        g.BFS(2);    
//        
//        System.out.println("\nFollowing is Depth First Traversal "+"(starting from vertex 2)");
//        //Call the DFS function
//        g.DFS(2);                   
//        
//        //Print the graph
//        g.displayGraph(g);
    }
}
