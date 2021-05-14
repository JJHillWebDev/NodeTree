/**
	This class creates a node for the BalancedTree class to use.
	@author Jeremy Hill
    @version 12.0.2
 */	
public class Node<T> 
{
	T data;			//holds node's data
	Node<T> left; 	//holds left child
	Node<T> right;	//holde right child

	public Node(T d) 
	{
		data = d;
		left = right = null;
	}
}