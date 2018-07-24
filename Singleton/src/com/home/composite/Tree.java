package com.home.composite;

import java.util.Enumeration;
import java.util.Vector;

public class Tree {
	TreeNode root=null;
	
	public Tree(String name) {
		super();
		root=new TreeNode(name);
	}

	public static void main(String[] args) {
		Tree tree = new Tree("A");  
        TreeNode nodeB = new TreeNode("B");  
        TreeNode nodeC = new TreeNode("C");  
        TreeNode nodeD = new TreeNode("D");  
        
        nodeB.add(nodeC);
        nodeB.add(nodeD);
        tree.root.add(nodeB);  
        System.out.println("build the tree finished!");  
        
        Enumeration<TreeNode> childrens = nodeB.getChildren();
        while(childrens.hasMoreElements()) {
        	System.out.println(childrens.nextElement().getName());
        }
     }

}
