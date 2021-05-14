/**
	This class tests the BalancedTree class
	@author Jeremy Hill
    @version 12.0.2
 */
public class TreeDriver
{
	static Node root;	//holds the tree's root node

	public static void main(String[] args) 
	{
		BalancedTree<String> tree = new BalancedTree<String>();
		String arr[] = new String[] { "A", "B", "C", "D", "E", "F", "G", 
									"H", "I", "J", "K", "L", "M", "N"};
		int n = arr.length;
		root = tree.stringToTree(arr, 0, n - 1);
		tree.printTree(root);
	}
}