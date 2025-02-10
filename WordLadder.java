package GraphQues;

import java.util.*;

public class WordLadder {

    public static  int minTransf(String beginWord , String endWord, List<String> wordList)
    {
        Set<String> wordSet = new HashSet<>(wordList); // faster than list traversal

        if(!wordSet.contains(endWord)) return 0; //If endWord is not in wordList, no solution

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1; // Start with 1 as beginWord is counted


        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i<size ; i++)
            {
                String word = queue.poll();

                if(word.equals(endWord)) return steps ; //f we reach the end word , the return the steps


                char[] wordsintoChars = word.toCharArray();
                for(int j =0 ; j<wordsintoChars.length; j++)
                {
                    char OrgChar = wordsintoChars[j];

                    for(char x = 'a' ; x<= 'z'; x++)
                    {
                        if(x == OrgChar)
                        continue;

                        wordsintoChars[j] = x;
                        String newWord = new String(wordsintoChars);

                        if(wordSet.contains(newWord))
                        {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    wordsintoChars[j] = OrgChar; // This is crucial to ensure the next iteration starts with the correct original word.
                }
            }

            steps++;
        }

  return 0;
    }

    public static void main(String[] args) {
        // Define test cases
        List<String[]> testCases = Arrays.asList(
            new String[]{"hit", "cog", "hot,dot,dog,lot,log,cog"}, // Expected: 5
            new String[]{"hit", "cog", "hot,dot,dog,lot,log"},     // Expected: 0
            new String[]{"cat", "bat", "bat"},                    // Expected: 2
            new String[]{"lead", "gold", "load,goad,gold,lead"},  // Expected: 4
            new String[]{"abc", "xyz", "abd,acd,bcd,xyz"},        // Expected: 0
            new String[]{"same", "same", "same,came,lame"},       // Expected: 1
            new String[]{"cold", "warm", "cord,card,ward,warm"},  // Expected: 5
            new String[]{"a", "c", "a,b,c"},                      // Expected: 2
            new String[]{"start", "end", "smart,spart,spend,stend,end"}, // Expected: 5
            new String[]{"hit", "cog", "hot,dot,dog,lot,log,cog,hog,lit,kit,git,hit,cot"} // Expected: 5
        );

        // Run test cases
        int testNumber = 1;
        for (String[] testCase : testCases) {
            String beginWord = testCase[0];
            String endWord = testCase[1];
            List<String> wordList = Arrays.asList(testCase[2].split(","));
            int result = minTransf(beginWord, endWord, wordList);
            System.out.println("Test " + testNumber + ": " + result);
            testNumber++;
        }
    }
}
