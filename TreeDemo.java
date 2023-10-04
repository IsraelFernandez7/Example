
import java.util.ArrayList;
import java.util.Stack;

class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /*
	   pre-order traversal
	   Prints the value of every node preorder
	   */
	   public int[] preOrderTraversal(Node root){
		if (root == null) return new int[] { };

                Stack<Node> stack = new Stack<Node>();
                ArrayList<Integer> orderList = new ArrayList<Integer>();

                for (Node node = root;;)
                {
                    if (node == null)
                    {
                        if (stack.empty()) break;

                        node = stack.pop();
                        node = node.right;
                    }
                    else
                    {
                        orderList.add(node.value);
                        stack.push(node);
                        node = node.left;
                    }
                }

                int[] order = new int[orderList.size()];
                for (int i = 0; i < order.length; i++)
                {
                    order[i] = orderList.get(i);
                }

                return order;
           }
	   
	   /*
	   in-order traversal
	   */
	   public int[] inOrderTraversal(Node root){
              if (root == null) return new int[] { };

              Stack<Node> stack = new Stack<Node>();
              ArrayList<Integer> orderList = new ArrayList<Integer>();

              for (Node node = root;;)
              {
                  if (node == null)
                  {
                      if (stack.empty()) break;

                      node = stack.pop();
                      orderList.add(node.value);
                      node = node.right;
                  }
                  else
                  {
                      stack.push(node);
                      node = node.left;
                  }
              }

              int[] order = new int[orderList.size()];
              for (int i = 0; i < order.length; i++)
              {
                  order[i] = orderList.get(i);
              }

              return order;
          }
	  
           /*
	   post-order traversal
	   */
	  
	   public int[] postOrderTraversal(Node root){
                if (root == null) return new int[] { };

                Stack<Node> stack = new Stack<Node>();
                Stack<Integer> stackCtr = new Stack<Integer>();
                ArrayList<Integer> orderList = new ArrayList<Integer>();

                stack.push(root);
                stackCtr.push(0);

                while (!stack.empty())
                {
                    int ctr = stackCtr.pop();
                    Node node = stack.peek();

                    if (ctr == 0)
                    {
                        // First visit.
                        stackCtr.push(1);

                        if (node.left != null)
                        {
                            stack.push(node.left);
                            stackCtr.push(0);
                        }
                    }
                    else if (ctr == 1)
                    {
                        // Second visit.
                        // Left subtree done.
                        stackCtr.push(2);

                        if (node.right != null)
                        {
                            stack.push(node.right);
                            stackCtr.push(0);
                        }
                    }
                    else // ctr >= 2
                    {
                        // Third visit.
                        // Right subtree done.
                        stack.pop();
                        orderList.add(node.value);
                    }
                }

                int[] order = new int[orderList.size()];
                for (int i = 0; i < order.length; i++)
                {
                    order[i] = orderList.get(i);
                }

        return order;
		   
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a specific value
	   */
	   public boolean find(Node root, int key){
		 if(root == null)
                {
                   return false;
                }

                if(root.value == key)
                {
                     return true;
                }

                if(key < root.value)
                {
                   return find(root.left, key);
                }
                else
                {
                   return find(root.right, key);
                }
	   }
	   
	   
	   
	   /*
	   a method to find the node in the tree
	   with a smallest key
	   */
	   public int getMin(Node root, int key){
            if (key < root.value)
            {
                if (root.left == null)
                {
                    root.left = new Node(key);
                }

                root = root.left;
            }
                return key;
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root, int key){
                if (key > root.value)
                    {
                if (root.right == null)
                {
                    root.right = new Node(key);
                }

                root = root.right;
            }
                return key;
           }
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left, root.value);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemo{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
