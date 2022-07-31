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
}
