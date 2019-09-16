package hashtable;

import java.util.HashSet;
import java.util.*;

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
}
