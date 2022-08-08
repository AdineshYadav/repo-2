import java.util.ArrayList;
import java.util.Scanner;

//Generic tree can have variable number of children
public class GenericTree {

    Scanner sc = new Scanner(System.in);

    //only generic tree class can use this private class
    private class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();

    }
    private Node root;

    //making the constructor
    public GenericTree(){
        construct(null , -1);
    }

    //function for constructing the data
    private Node construct(Node parent , int ith ){

        //prompt
        if(parent == null){
            System.out.println("Enter the data for root node");
        }
        else {
            System.out.println("Enter the data for " + ith + " child of " + parent.data + "?");
        }
        //take input from the user
        int item = sc.nextInt();
        //create a new node
        Node newNode = new Node();
        //update the data
        newNode.data = item;
        //prompt
        System.out.println("Enter the number of children for "+ newNode.data + "?");
        //taking input for children
        int nOfChildren = sc.nextInt();

        //loop for the number of children
         for(int i = 0 ; i < nOfChildren ; i++){

              Node child = construct(newNode,i);
              //child node will be added to the arraylist of the parent node
             newNode.children.add(child);
         }
         //when the node will be returned it will create the link between the child and the parent node
        //after that loop will run for the another child node formation
         return newNode;


    }
    public void display(){
        System.out.println("----------------------------------");
        display(root);
        System.out.println("----------------------------------");
    }

    public int size(){
        return size(root);
    }

    //Recursive function for displaying the generic tree
     private void display(Node node){
        String str = node.data + "->";

        // loop for the child node present in the arrayList of the parent node
        for(Node child : node.children){
            str += child.data + " ";
        }
        str += ".";
        System.out.println(str);

        //smaller problem
        for(Node child : node.children){
            display(child);
        }

    }

    //Function for finding the size of the generic tree (no. of nodes)
    private int size(Node node){

        int totalSize = 0;

        //recursive call for every child present in the node
        for(Node child : node.children){
            //it will return the size of the respected subtree
            int childSize = size(child);
            //the size of the subtree will be added to the total size of the tree
            totalSize += childSize;
        }
        return totalSize+1;
    }

    //Function to find the max node
    private int max(Node node){
        int totalMax = node.data;

        //comparison within the subtree and assigning the maximum value
        for(Node child : node.children){
            int childMax = max(child);

            if(childMax > totalMax){
                totalMax = childMax;
            }
        }
        return totalMax;
    }

    //Function for finding the node in binary tree
    public boolean find(Node node , int item){
        if(node.data == item){
            return true;
        }

        for(Node child : node.children){
            boolean childFind = find(child , item);
           if(childFind){
               return true;
           }
        }
        return false;
    }

    public int height(Node node){
        int totalHeight = -1;
        for(Node child : node.children){
            int childHeight = height(child);
            if(childHeight > totalHeight){
                totalHeight = childHeight;
            }
        }
        return totalHeight+1;
    }
}
