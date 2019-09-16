package hashtable;

import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;

public class HashTableTest {
    @Test
    public void repeatedWordTest(){
        Set<String> output = HashTable.RepeatedWord("The current Hokage is Naruto, the 7th Hokage.");
        assertTrue(output.contains("Hokage"));
    }
}