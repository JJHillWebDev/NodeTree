import java.util.*;

/**
	This class creates a Balanced Binary Search Tree
	@author Jeremy Hill
    @version 12.0.2
 */
public class BalancedTree<T> 
{
 	/**
	 *  The stringToTree method converts a string into a binary search tree.
	 *  @param arr Array of generic type.
	 *  @param start The first element.
	 *  @param end The second element.
	 *  @return A node with the middle element of the array.
 	 */
	public Node<T> stringToTree(T[] arr, int start, int end) 
	{
		//base case
		if (start > end) 
		{
			return null;
		}

		//find middle element 
		int mid = ((start + end + 1) / 2);

		Node<T> node = new Node<T>(arr[mid]);

		//construct left subtree
		node.left = stringToTree(arr, start, mid - 1);
		//construct right subtree
		node.right = stringToTree(arr, mid + 1, end);

		return node;
	}

	/**
	 *  The getTreeHeight method finds and returns the height of the tree.
	 *  @param head The head node of the tree.
	 *  @return The height of the tree.
 	 */
	public int getTreeHeight(Node<T> head) 
	{
		if (head == null) 
		{
			return 0;
		} 
		else 
		{
			return 1 + Math.max(getTreeHeight(head.left), 
								getTreeHeight(head.right));
		}
	}

	/**
	 *  The printTree method prints a formated tree to the screen.
	 *  @param root The tree's root node.
 	 */
	public void printTree(Node<T> root) 
	{
		Queue<Node<T>> rootsQueue = new LinkedList<Node<T>>();
		Queue<Node<T>> levelQueue = new LinkedList<Node<T>>();
		levelQueue.add(root);

		int treeHeight = getTreeHeight(root);
		int firstGap;
		int internalGap;
		int secInternalGap;

		while (true) 
		{
			System.out.println("");

			internalGap = (int) (Math.pow(2, treeHeight + 1) - 1);
			secInternalGap = internalGap;
			firstGap = internalGap / 2;

			boolean firstLevel = true;

			while (!levelQueue.isEmpty()) 
			{
				internalGap = secInternalGap;
				Node<T> currNode = levelQueue.poll();

				if (currNode != null) 
				{
					if (firstLevel) 
					{
						while (firstGap > 0) 
						{
							System.out.format("%s", " ");
							firstGap--;
						}

						firstLevel = false;
					} 
					else 
					{
						while (internalGap > 0) 
						{
							internalGap--;
							System.out.format("%s", " ");
						}
					}

					System.out.format("%2s", currNode.data);
					rootsQueue.add(currNode);
				}
			}

			--treeHeight;

			while (!rootsQueue.isEmpty()) 
			{
				Node<T> currNode = rootsQueue.poll();

				if (currNode != null) 
				{
					levelQueue.add(currNode.left);
					levelQueue.add(currNode.right);
				}
			}

			if (levelQueue.isEmpty())
			{
				break;
			}
		}
	}	
}