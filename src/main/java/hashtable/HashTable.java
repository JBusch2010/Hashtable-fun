package hashtable;

import java.util.HashSet;
import java.util.*;

import static hashtable.Node.newNode;

public class HashTable {

    private Node[] map;

    public HashTable (int size) {
        map = new Node[size];
    }

    // hash()
    private int hash (String key) {
        int hashValue = 0;
        char[] letters = key.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            hashValue += letters[i];
        }

        hashValue = (hashValue * 599) % map.length;
        return hashValue;
    }

    // set()
    public void set (String key, String value) {

        // set a var (int) of the hash(key)
        int hashKey = hash(key);

        System.out.println(key + " " + hashKey);

        // If map[hashvalue] is a thing ... do the linked list thing
        // Otherwise, just add the node.
        if (this.map[hashKey] == null) {
            map[hashKey] = new Node(key, value) {
            };
        } else {
            Node temp = map[hashKey];
            map[hashKey] = new Node(key, value);
            map[hashKey].setNext(temp);
        }

    }

    // get()
    public String get (String key) {
        // hash the key (should give me the same thing)
        // if the hash table has that key, send back the value from the node.
        int hashKey = hash(key);
        if (this.map[hashKey] != null) {
            // Actually go through the list and check the actual value
            // (do as I said, not as I did)
            return map[hashKey].value;
        }

        return null;
    }

    // has()
    public boolean has (String key) {
        int hashKey = hash(key);
        // Actually go through the list and check the actual value
        // (do as I said, not as I did)
        return map[hashKey] != null;
    }

    //https://javarevisited.blogspot.com/2015/07/how-to-find-duplicate-words-in-string-java.html

    public static Set<String> RepeatedWord(String input){

        // checking if null or empty
        if(input == null || input.isEmpty()){

            // returning empty or null set
            return Collections.emptySet();
        }

        // creating new set for the repeated word
        Set<String> repeated = new HashSet<>();

        // creating spaces in the string
        String[] words = input.split("\\s+");

        Set<String> set = new HashSet<>();

        for(String word : words){
            if(!set.add(word)){
                repeated.add(word);
            }
        }

        //returning set of repeated word
        return repeated;
    }

    //https://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/
    static void treeIntersection(Node root1, Node root2){
        Stack<Node> stack1 = new Stack<Node> ();
        Stack<Node> s1 = new Stack<Node> ();
        Stack<Node> s2 = new Stack<Node> ();

        while (true){

            //push the Nodes of the first tree in stack s1
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }

            //push the Node of the second tree in s2
            else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            }

            // both root1 and root2 are null here
            else if (!s1.isEmpty() && !s2.isEmpty()){
                root1 = s1.peek();
                root2 = s2.peek();

                // if current keys in two trees are the same
                if (root1.nkey == root2.nkey){
                    System.out.print(root1.nkey + " ");
                    s1.pop();
                    s2.pop();

                    // move to the inorder successor
                    root1 = root1.right;
                    root2 = root2.right;
                }

                else if (root1.nkey < root2.nkey){
                    s1.pop();
                    root1 = root1.right;

                    //root 2 is set to null because we need new Nodes of tree 1
                    root2 = null;
                }

                else if (root1.nkey > root2.nkey){
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }
            // both root and both stacks are empty
            else break;
        }


    }

    // for in order traversal
    public static void inOrder (Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    // for adding new nodes
    public static Node add (Node node, int nkey){

        // if the tree is empty return a new node;
        if (node == null)
            return newNode (nkey);

        // other wise, recur down the tree
        if (nkey < node.nkey)
            node.left = add(node.left, nkey);
        else if (nkey > node.nkey)
            node.right = add(node.right, nkey);

        // return the Node pointer
        return node;
    }
}
