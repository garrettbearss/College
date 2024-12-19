// Garrett Bearss
// LinkedBST.java
// Uses Binary Search Tree

import java.util.ArrayList;
import java.util.List;

public class LinkedBST
{
	private TreeNode root;
	
	public LinkedBST()// Constructor
	{
		root = null;
	}
	
	public boolean addNode(Comparable obj)// Adds a node to the list
	{
		if(root == null)// If there is nothing in the search tree
		{
			root = new TreeNode(obj);
			return true;
		}
		else// Calls helper method
		{
			return helper(obj, root);
		}
	}
	
	private boolean helper(Comparable obj, TreeNode temp)// Adds a node containing the object
	{
		if(obj.compareTo(temp.getValue()) == 0)// If the tree contains the value
		{
			return false;
		}
		else if(obj.compareTo(temp.getValue()) < 0)// If the object's value is smaller than temps value
		{
			if(temp.getLeft() == null)// If there is nothing in temp's left
			{
				TreeNode Yeet = new TreeNode(obj);
				temp.setLeft(Yeet);
				return true;
			}
			else// If there is something in temp's left
			{
				return helper(obj, temp.getLeft());
			}
		}
		else// If the object's value is larger than temp's value
		{
			if(temp.getRight() == null)//If there is nothing in temp's right
			{
				TreeNode Yeet = new TreeNode(obj);
				temp.setRight(Yeet);
				return true;
			}
			else// If there is something in temp's right
			{
				return helper(obj, temp.getRight());
			}
		}
	}
    
    public List preOrder()// Root, Left, Right
    {
        ArrayList Garrett = new ArrayList();
        if(root != null)// Checks if there is nothing in the list
        {
            preOrderTraverse(root, Garrett);// Calls recursive method
        }
        return Garrett;
    }
    
    private void preOrderTraverse(TreeNode current, List list)// Root, Left, Right
    {
    	if(current != null)// Checks if current isn't null/ not at end of list
    	{
    		list.add(current.getValue());// Gets Root
            preOrderTraverse(current.getLeft(), list);// Gets Left through recursion
            preOrderTraverse(current.getRight(), list);// Gets Right through recursion
    	}
    }
	
	public List inOrder()// Left, Root, Right
	{
		ArrayList Garrett = new ArrayList();
		if(root != null)// Checks if there is nothing in the list
		{
			inOrderTraverse(root, Garrett);// Calls recursive method
		}
		return Garrett;
	}
	
	private void inOrderTraverse(TreeNode current, List list)// Left, Root, Right
	{
		if(current != null)// Checks if current isn't null/ not at end of list
        {
			inOrderTraverse(current.getLeft(), list);//Gets Left through recursion
        	list.add(current.getValue());// Gets Root
            inOrderTraverse(current.getRight(), list);// Gets Right through recursion
        }
	}
    
    public List postOrder()// Left, Right, Root
    {
        ArrayList Garrett = new ArrayList();
        if(root != null)// Checks if there is nothing in the list
        {
            postOrderTraverse(root, Garrett);// Calls recursive method
        }
        return Garrett;
    }
    
    private void postOrderTraverse(TreeNode current, List list)// Left, Right, Root
    {
        if(current != null)// Checks if current isn't null/ not at end of the list
        {
        	postOrderTraverse(current.getLeft(), list);// Gets Left through recursion
            postOrderTraverse(current.getRight(), list);// Gets Right through recursion
        	list.add(current.getValue());// Gets Root
        }
    }
    
    public boolean deleteNode(Comparable find)// Delete a node from the tree
    {
    	if(root == null)
    	{
    		return false;
    	}
    	else
    	{
    		return helper2(find, root, null);
    	}
    }
    
    private boolean helper2(Comparable delete, TreeNode current, TreeNode prev)// Delete a node from the tree
    {
    	if(delete.compareTo(current.getValue()) < 0)// If the value is located to the left
    	{
    		if(current.getLeft() == null)// If nothing is to the left
    		{
    			return false;
    		}
    		else// If something is to the left
    		{
    			return helper2(delete, current.getLeft(), current);
    		}
    	}
    	else if(delete.compareTo(current.getValue()) > 0)// If the value is located to the right
    	{
    		if(current.getRight() == null)// If nothing is to the right
    		{
    			return false;
    		}
    		else// If something is the the right
    		{
    			return helper2(delete, current.getRight(), current);
    		}
    	}
    	else// If you've found the value
    	{
    		if(prev == null)// If deleting the root
    		{
    			if(current.getLeft() != null)// If there is something located to the left of the root
    			{
    				if(current.getLeft().getRight() != null)// If there is something located to the right of the root
    				{
    					TreeNode big = current;// big follows current so that it can delete it
    					prev = current;
    					current = current.getLeft();
    					while(current.getRight() != null)// Trying to find the biggest value
    					{
    						big = current;
    						current = current.getRight();
    					}
    					if(current.getLeft() != null)// If there is a node attached to the biggest node
    					{
    						prev.setValue(current.getValue());// Takes the largest value and sets it where the deletion should occur
    						big.setRight(current.getLeft());// Sets big's right to the remaining node
    						return true;
    					}
    					else
    					{
    						prev.setValue(current.getValue());// Takes the largest value and sets it where the deletion should occur
    						big.setRight(null);// Sets big's right to nothing
    						return true;
    					}
    				}
                    else// Sets current to the highest value on the left and deletes that node
                    {
                        current.setValue(current.getLeft().getValue());
                        current.setLeft(current.getLeft().getLeft());
                        return true;
                    }
    			}
    			else if(current.getRight() != null)// If there is only something located to the right of the root
    			{
    				root = current.getRight();// Moves the root over
    				return true;
    			}
    			else// If there is nothing attached to the root
    			{
    				root = null;// Sets root to null
    				return true;
    			}
    		}
    		else if(current.getLeft() != null)// If there is something to the left
    		{
    			if(current.getRight() != null)// If there is something to the right
    			{
    				TreeNode big = current;
    				prev = current;
    				while(current.getRight() != null)// Trying to find the biggest value
    				{
    					big = current;
    					current = current.getRight();
    				}
    				if(current.getLeft() != null)// If there is something attached to the biggest node
    				{
    					prev.setValue(current.getLeft().getValue());// Takes the largest value and sets it where the deletion should occur
    					current.setLeft(null);// Gets rid of the dupe
    					return true;
    				}
    				else// If there is nothing attached 
    				{
    					prev.setValue(current.getValue());// Takes the largest value and sets it where the deletion should occur
    					big.setRight(null);// Gets rid of node
    					return true;
    				}
    			}
    			else// If there is only something to the left
    			{
    				if(delete.compareTo(prev.getValue()) < 0)// If the node being deleted is to the left of prev
    				{
    					prev.setLeft(current.getLeft());
    					return true;
    				}
    				else// If the node being deleted is to the right of prev
    				{
    					prev.setRight(current.getLeft());
    					return true;
    				}
    			}
    		}
    		else if(current.getRight() != null)// If there is only something to the right
    		{
                if(delete.compareTo(prev.getValue()) < 0)// If the value was to the left of prev
                {
                    prev.setLeft(current.getRight());
                    return true;
                }
                else// If the value was to the right of prev
                {
                    prev.setRight(current.getRight());
                    return true;
                }
    		}
    		else// If there is nothing attached to the delete value
    		{
    			if(delete.compareTo(prev.getValue()) < 0)// If the node in need of deleting is to the left
    			{
    				prev.setLeft(null);
    				return true;
    			}
    			else// If the node in need of deleting is to the right
    			{
    				prev.setRight(null);
    				return true;
    			}
    		}
    	}
    }
    
    public boolean search(Comparable key)// Searches for a value in the tree
    {
    	if(root == null)// If the tree has nothing in it
    	{
    		return false;
    	}
    	else// If the tree has something in it
    	{
    		return search(root, key);
    	}
    }
    
    private boolean search(TreeNode current, Comparable key)// Searches for a value in the tree
    {
    	if(current != null)// If current isn't null
    	{
    		if(key.compareTo(current.getValue()) == 0)// If you have found the value
    		{
    			return true;
    		}
    		else// If you haven't found the value
    		{
    			if(key.compareTo(current.getValue()) < 0)// If either the value is to the left
    			{
    				return search(current.getLeft(), key);
    			}
    			else// If the value is to the right
    			{
    				return search(current.getRight(), key);
    			}
    		}
    	}
    	else// If the tree is empty
    	{
    		return false;
    	}
    }
    
    public int countLeaf()// Counts the number of leaves in the search tree
    {
    	if(root == null)// If there is nothing in the tree
    	{
    		return 0;
    	}
    	else// If there is something in the tree
    	{
    		return countLeaf(root);
    	}
    }
    
    private int countLeaf(TreeNode current)// Counts the number of leaves in the search tree
    {
    	if(current != null)// If current isn't null
    	{
    		if(current.getLeft() == null && current.getRight() == null)// Checks if the node is a leaf
    		{
    			return 1;
    		}
    		else// Goes in both directions to find a leaf
    		{
    			return countLeaf(current.getLeft()) + countLeaf(current.getRight());
    		}	
    	}
    	else// If current is null
    	{
    		return 0;
    	}
    }
    
    public int findPath(Comparable find)// Finds the numer of branches it takes to get to a value
    {
    	if(root == null)// If there is nothing in the list
    	{
    		return -1;
    	}
    	else// If there is something in the list
    	{
    		return findPath(root, find);
    	}
    }
    
    private int findPath(TreeNode current, Comparable find)// Finds the number of branches it takes to get to a value
    {
    	if(find.compareTo(current.getValue()) == 0)// If you've found the value
    	{
    		return 0;
    	}
    	else// If tou haven't found the value
    	{
    		if(find.compareTo(current.getValue()) < 0)// If the value should be to the left
    		{
    			if(current.getLeft() != null)// If there is a left
    			{
    				if(findPath(current.getLeft(), find) == -1)// Checks to see if the value is in the search tree
    				{
    					return -1;
    				}
    				else// If there is a value in the tree
    				{
    					return findPath(current.getLeft(), find) + 1;
    				}
    			}
    			else// If there is no left
    			{
    				return -1;
    			}
    		}
    		else// If the value should be to the right
    		{
    			if(current.getRight() != null)// If there is a right
    			{
    				if(findPath(current.getRight(), find) == -1)// Checks to see if the value is in the search tree
    				{
    					return -1;
    				}
    				else// If there is a value in the tree
    				{	
    					return findPath(current.getRight(), find) + 1;
    				}
    			}
    			else// If there is no right
    			{
    				return -1;
    			}
    		}
    	}
    }
    
    public int countNode()// Counts total nodes in a list
    {
    	if(root == null)// If there is nothing in the list
    	{
    		return 0;
    	}
    	else// If there is something in the list
    	{
    		return countNode(root);
    	}
    }
    
    private int countNode(TreeNode current)// Counts total nodes in a list 
    {
    	if(current.getLeft() == null && current.getRight() == null)// If it is a leaf
    	{
    		return 1;
    	}
    	else if(current.getLeft() != null && current.getRight() != null)// If you're at a branch
    	{
    		return countNode(current.getLeft()) + countNode(current.getRight()) + 1;
    	}
    	else if(current.getLeft() != null)// If there is only a left
    	{
    		return countNode(current.getLeft()) + 1;
    	}
    	else// If there is only a right
    	{
    		return countNode(current.getRight()) + 1;
    	}
    }
}