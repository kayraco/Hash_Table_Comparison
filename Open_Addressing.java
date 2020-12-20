import java.io.*;
import java.util.*;

// No collaborators
public class Open_Addressing {
     public int m; // number of SLOTS AVAILABLE
     public int A; // the default random number
     int w;
     int r;
     public int[] Table;
     
 
     protected Open_Addressing(int w, int seed, int A) {

         this.w = w;
         this.r = (int) (w-1)/2 +1;
         this.m = power2(r);
         if (A==-1){
            this.A = generateRandom((int) power2(w-1), (int) power2(w),seed);
         }
        else{
            this.A = A;
        }
         this.Table = new int[m];
         for (int i =0; i<m; i++) {
             Table[i] = -1;
         }
         
     }
                 /** Calculate 2^w*/
     public static int power2(int w) {
         return (int) Math.pow(2, w);
     }
     
     public static int generateRandom(int min, int max, int seed) {     
         Random generator = new Random(); 
                 if(seed>=0){
                    generator.setSeed(seed);
                 }
         int i = generator.nextInt(max-min-1);
         return i+min+1;
     }
     public int helper_hash (int key) {
         // TODO: implement this and change the return statement
         return ((int)(A*key) % power2(w) >> (w-r)) ;
     }
     
        /**Implements the hash function g(k)*/
        public int probe(int key, int i) { 
            //TODO: implement this function and change the return statement.
        	//System.out.print((helper_hash(key) + i) % power2(w));
        	
        	return (helper_hash(key)+i) % power2(r);
     }
     
     /**Inserts key k into hash table. Returns the number of collisions encountered*/
       
        public int insertKey(int key){
            //TODO : implement this and change the return statement.
        	int collisions = -1;
        	do {
        		collisions++;
        		int index = probe(key, collisions);
        		// if the position is available, (i.e. if position is "-1"), insert the key
        		if(Table[index] == -1) {
        			Table[index] = key;
        			break;
        		}
        		//there cannot be more than m-1 collisions
        	}while(collisions < m); 
        	//return the collisions
            return collisions;   
        }
        
        /**Sequentially inserts a list of keys into the HashTable. Outputs total number of collisions */
        public int insertKeyArray (int[] keyArray){
            int collision = 0;
            for (int key: keyArray) {
                collision += insertKey(key);
            }
            return collision;
        }
            
         /**Removes key k into hash table. Returns the number of collisions encountered*/
        public int removeKey(int key){
            //TODO: implement this and change the return statement
        	int i =0;
            for (; i < m; i++) {
                int h = probe(key, i);
                if (Table[h] == key) {
                    Table[h] = -1;
                    return i;
                }
            }
            //the key to be removed doesnt exist in the array 
            return m;
        }
}
