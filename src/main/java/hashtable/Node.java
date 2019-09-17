package hashtable;

public class Node {

    public String key;
    public int nkey;
    public Node left;
    public Node right;
    public String value;
    public Node next;

    public Node () {

    }

    static Node newNode(int ele){
        Node temp = new Node();
        temp.nkey = ele;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    public void setNext(Node node) { this.next = node; }
    public void setKey(String key) { this.key = key; }
    public void setValue(String value) { this.value = value; }

    public Node(String key, String value) {
        setKey(key);
        setValue(value);
    }

}
