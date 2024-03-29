/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hashtable;

import java.util.Set;

import static hashtable.HashTable.*;

public class App {
    public static void main(String[] args) {

        HashTable ht = new HashTable(1024);
        ht.set("Hashirama", "1st Hokage");
        ht.set("Tobirama", "2nd Hokage");
        ht.set("Hiruzen", "3rd Hokage");
        ht.set("Minato", "4th Hokage");
        ht.set("Tsunade", "5th Hokage");
        ht.set("Kakashi", "6th Hokage");
        ht.set("Naruto", "7th Hokage");

        System.out.println( "Has Hiruzen ... " + ht.has("Hiruzen") );
        System.out.println( "Get Naruto " + ht.get("Naruto") );
        System.out.println( "Get Hiruzen " + ht.get("Hiruzen") );
        System.out.println( "Has Danzo ... " + ht.has("Danzo") );

        //repeatedword
        String test = "The current Hokage is Naruto, the 7th Hokage.";
        Set<String> repeated = RepeatedWord(test);
        System.out.println("input : " + test);
        System.out.println("output : " + repeated);

        //treeIntersection
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

        //leftjoin
        HashTable synonym = new HashTable(1024);
        synonym.set("Pride", "Superbia");
        synonym.set("Envy", "Invidia");
        synonym.set("Gluttony", "Overheating");
        synonym.set("Lust", "Luxuria");
        synonym.set("Wrath", "Anger");
        synonym.set("Greed", "Rapacity");
        synonym.set("Sloth", "Lazy");


        HashTable antonym = new HashTable(1024);
        antonym.set("Pride", "Humility");
        antonym.set("Envy", "Compassion");
        antonym.set("Gluttony", "Moderation");
        antonym.set("Lust", "Chastity");
        antonym.set("Wrath", "Joy");
        antonym.set("Greed", "Generous");
        antonym.set("Sloth", "Vigor");



    }
}
