import java.io.*;
import java.util.*;


public class main {     

     // No collaborators
    public static void main(String[] args) {
    //TODO:build the hash table and insert keys using the insertKeyArray function.
 
    	
        int[] array = {12, 345, 13, 4, 5, 6, 65, 34, 85, 9, 10};
        
        Chaining hashTableWithChaining = new Chaining(6, -1, 5);
        Open_Addressing hashTableWithOpenAddressing = new Open_Addressing(6, -1, 5);

        int collisionsWithChaining = hashTableWithChaining.insertKeyArray(array);
        int collisionsWithOpenAddressing = hashTableWithOpenAddressing.insertKeyArray(array);

        String newLine = System.getProperty("line.separator");
        System.out.println("This is the array used for testing the functions: " + Arrays.toString(array));
        System.out.println(newLine);
        
        System.out.println("Number of collisions with chaining: " + collisionsWithChaining);
        
        System.out.println(newLine);
        System.out.println("Number of collisions with open addressing: " + collisionsWithOpenAddressing);
        

        System.out.println(newLine);
        
        int collisions_removal = hashTableWithOpenAddressing.removeKey(85);
        System.out.println("Remove key 85");
        System.out.println(newLine);
        System.out.println("Number of collisions when removing key: " + collisions_removal);
        System.out.println(newLine);
        System.out.println("The updated array after key has been removed: ");
        System.out.println(newLine);
        for (int key : hashTableWithOpenAddressing.Table) {
            System.out.println(key);
        }
        System.out.println(newLine);
        System.out.println("The key has been successfully removed");

		
		
		
		
    }
}