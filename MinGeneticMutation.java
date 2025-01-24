package GraphQues;

// Import statements for the HashSet, HashMap, and LinkedList
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


//
class Pair<K,V>{

    private K key;
    private V value;

    public Pair(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }

}

public class MinGeneticMutation {

    //Function for finding the minimum mutation required to transfor start gene into end gene

    public static int minimumMutation(String start, String end, String[] bank)
    {
        // Create a set from the give bank array 
        Set<String> bankSet = new HashSet<>();

        for (String gene: bank)
        {
            bankSet.add(gene);
        }

        // Intialize queue to perform BFS
        Deque<Pair<String,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(start,0)); // Intializing queue with start string and count of muattaion with 0

        // Dict map for holding possible muation for each gene character with other 3 char
        Map<Character, String> mutationMap = new HashMap<>(4);
        mutationMap.put('A', "TCG");
        mutationMap.put('T', "ACG");
        mutationMap.put('C', "ATG");
        mutationMap.put('G', "ATC");

        //Loop through until queue is empty
        while(!queue.isEmpty())
        {
            Pair<String, Integer> current = queue.poll();
            String currentGene = current.getKey();
            int currentCount = current.getValue();
        
        
        // check if current gene matches the end gene , then return the number of count/step
        if(end.equals(currentGene))
        {
            return currentCount;
        }

        //Iterate through all characters of the current Gene
        for(int i =0; i<currentGene.length() ; i++)
        {
            // Explore each possible mutation based on the mapping
            for(char mutation : mutationMap.get(currentGene.charAt(i)).toCharArray())
            {
                  // construct the new mutated gene
                  String mutatedGene = currentGene.substring(0,i) + mutation + currentGene.substring(i,1);
            

            //if mutated gene is in the bank
            if(bankSet.contains(mutatedGene))
            {
                // Add the mutated gene with an incremented step count into the queue
                queue.offer(new Pair<>(mutatedGene, currentCount + 1));
                // Remove the mutated gene from the set to prevent revisiting
                bankSet.remove(mutatedGene);
            }

        }
        }
        
        
    }
// if no muation leads to the end gene
return -1;
}

public static void main(String[] args) {
   
    // Test Case 1
    String start1 = "AACCGGTT";
    String end1 = "AAACGGTA";
    String[] bank1 = {
        "AACCGGTA",
        "AACCGCTA",
        "AAACGGTA"
    };
    System.out.println("Test Case 1:");
    System.out.println("Minimum mutations required: " + minimumMutation(start1, end1, bank1));
    
    // Test Case 2
    String start2 = "AAAAACCC";
    String end2 = "AACCCCCC";
    String[] bank2 = {
        "AAAACCCC",
        "AAACCCCC",
        "AACCCCCC"
    };
    System.out.println("\nTest Case 2:");
    System.out.println("Minimum mutations required: " + minimumMutation(start2, end2, bank2));
    
    // Test Case 3
    String start3 = "AACCGGTT";
    String end3 = "AACCGGTA";
    String[] bank3 = {
        "AACCGGTA"
    };
    System.out.println("\nTest Case 3:");
    System.out.println("Minimum mutations required: " + minimumMutation(start3, end3, bank3));

    // Test Case 4 (No possible transformation)
    String start4 = "AACCGGTT";
    String end4 = "CCCCGGTT";
    String[] bank4 = {
        "AACCGGTA",
        "AACCGCTA",
        "AAACGGTA"
    };
    System.out.println("\nTest Case 4:");
    System.out.println("Minimum mutations required: " + minimumMutation(start4, end4, bank4));

    // Test Case 5 (Empty bank)
    String start5 = "AACCGGTT";
    String end5 = "AACCGGTA";
    String[] bank5 = {};
    System.out.println("\nTest Case 5:");
    System.out.println("Minimum mutations required: " + minimumMutation(start5, end5, bank5));
}




}
