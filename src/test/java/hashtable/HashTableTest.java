package hashtable;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static hashtable.HashTable.*;
import static org.junit.Assert.*;

public class HashTableTest {

    private final static int size = 7;

    @Test
    public void isNullTest(){
        HashTable table = new HashTable(1024);
        table.has(" ");
    }

    @Test
    public void existsTest() {
        HashTable table = new HashTable(1024);
        table.set("Hashirama", "1st Hokage");
        table.set("Tobirama", "2nd Hokage");
        table.set("Hiruzen", "3rd Hokage");
        table.set("Minato", "4th Hokage");
        table.set("Tsunade", "5th Hokage");
        table.set("Kakashi", "6th Hokage");
        table.set("Naruto", "7th Hokage");

        table.has("Hashirama");
        System.out.println( "Has Hashirama ... " + table.get("Hashirama") );
    }

    @Test
    public void doesNotExist() {
        HashTable table = new HashTable(1024);
        table.set("Hashirama", "1st Hokage");
        table.set("Tobirama", "2nd Hokage");
        table.set("Hiruzen", "3rd Hokage");
        table.set("Minato", "4th Hokage");
        table.set("Tsunade", "5th Hokage");
        table.set("Kakashi", "6th Hokage");
        table.set("Naruto", "7th Hokage");

        table.has("Danzo");
        System.out.println( "Has Danzo ... " + table.has("Danzo") );
    }

    @Test
    public void repeatedWordTest() {
        String test = "The current Hokage is Naruto, the 7th Hokage.";
        Set<String> repeated = RepeatedWord(test);
        System.out.println("input : " + test);
        System.out.println("output : " + repeated);
    }

    @Test
    public void commonNodes() {
        Node root1 = null;
        root1 = add(root1, 5);
        root1 = add(root1, 1);
        root1 = add(root1, 10);
        root1 = add(root1, 0);
        root1 = add(root1, 4);
        root1 = add(root1, 7);
        root1 = add(root1, 9);

        Node root2 = null;
        root2 = add(root2, 10);
        root2 = add(root2, 7);
        root2 = add(root2, 20);
        root2 = add(root2, 4);
        root2 = add(root2, 9);

        System.out.println("Common Nodes: ");

        treeIntersection(root1, root2);
    }

}