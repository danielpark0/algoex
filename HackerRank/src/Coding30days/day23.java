package Coding30days;

import java.util.*;
import java.io.*;
class Node1{
    Node1 left,right;
    int data;
    Node1(int data){
        this.data=data;
        left=right=null;
    }
}
class day23{
    
    static int answer;
    
	public static int getHeight(Node1 root){
      //Write your code here
      
      answer = 0;
      
      find(root, 0);
      
      return answer;
    }
    
    static void find(Node1 node, int h){
        if(h>answer) answer = h;
        Node1 l = node.left;
        Node1 r = node.right;
        if(l!=null) find(l, h+1);
        if(r!=null) find(r, h+1);
    }

	public static Node1 insert(Node1 root,int data){
        if(root==null){
            return new Node1(data);
        }
        else{
            Node1 cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node1 root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            int height=getHeight(root);
            System.out.println(height);
        }	
}
