package com.demo.bst;

import com.demo.Node.Node;

public class BinarySearchTree {
	private Node root;
	
	// add node
	public void addNode(int data) {
		root = insert(root, data);
	}
	
	private Node insert(Node root, int data) {
		if(root == null) {
			root = new Node(data);
			return root;
		}
		
		if(data < root.data) {
			root.left = insert(root.left, data);
		}
		else if(data > root.data) {
			root.right = insert(root.right, data);
		}
		else {
			System.out.println("duplicate value not allowed "  +  data);
		}
		return root;
	}
	
	// remove node
	public void removeNode(int data) {
		root = delete(root, data);
	}

	private Node delete(Node root, int data) {
		if(root == null) {
			System.out.println("valule not found" + data);
			return root;
		}
		
		if(data < root.data) {
			root.left = delete(root.left, data);
		}
		else if(data > root.data) {
			root.right = delete(root.right, data);
		}
		else{
			// node found - 3 possible cases
			
			// case 1 - node with no child (leaf)
			if(root.left == null && root.right == null) {
				return null;
			}
			// case 2 - node with only one child
			else if(root.left ==null) {
				return root.right;
			}
			else if(root.right == null) {
				return root.left;
			}
			root.data = findMin(root.right);
			root.right=delete(root.right, root.data);
		}
		return root;
	}
	
	private int findMin(Node root) {
		int min = root.data;
		while(root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
	
	// display - traversal methods
	
	public void inorder() {
		System.out.print("Inorder: ");
        inorderTraversal(root);
        System.out.println();
	}
	
	private void inorderTraversal(Node root) {
        if (root != null) {
        	inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }
	
	public void preorder() {
        System.out.print("Preorder: ");
        preorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postordertraversal(root);
        System.out.println();
    }

    private void postordertraversal(Node root) {
        if (root != null) {
        	postordertraversal(root.left);
        	postordertraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
}
