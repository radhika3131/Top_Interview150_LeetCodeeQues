package GraphQues;
import java.util.*;

public class OptimizedWordLadder {

    private static Set<String> wordSet ;
    public static  int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        //// Base case: If beginWord == endWord, return 1 immediately
        if (beginWord.equals(endWord)) {
            return 1; // Already transformed, no steps needed
        }

         // Initialize the word set with the given word list
        wordSet = new HashSet<>(wordList);
          //if the endWOrd is not present in the wordList, then return 0 as no Word ladder exists
          if(!wordSet.contains(endWord)) 
          {
            return 0;
          }

          
        

          //Two queues for implementing bidirectional BFS - will maintain current frontier of the word at each level of the BFS from respective starting point
          Queue<String> queueBegin = new ArrayDeque<>();
          Queue<String> queueEnd = new ArrayDeque<>();

          // Map to track the number of steps taken from BW & EW to any word encountered during search
          Map<String, Integer> visitedBegin = new HashMap<>();
          Map<String, Integer> visitedEnd = new HashMap<>();

          // Initialize both queues and Maps
          queueBegin.offer(beginWord);
          queueEnd.offer(endWord);
          visitedBegin.put(beginWord, 1);
          visitedEnd.put(endWord, 1);



          //Perform BFS until one of the queue is empty
          while(!queueBegin.isEmpty() && !queueEnd.isEmpty())
          {
            // Always extend the smaller queue in the current iteration
            int result = queueBegin.size() <= queueEnd.size() ? extendQueue(visitedBegin,visitedEnd,queueBegin) : extendQueue(visitedEnd,visitedBegin,queueEnd);

            // if connection is found , then return the total length
            if(result != -1)
            {
                return result;
            }
          }

          //if path not found
          return 0;

    }


    private static int extendQueue(Map<String , Integer> visitedOne , Map<String , Integer> visitedTwo , Queue<String> queue)
    {
        // Process ech word in the current layer
        for(int i = queue.size() ; i> 0 ; --i)
        {
            String currWord = queue.poll();
            int currStep = visitedOne.get(currWord);
            char[] chars = currWord.toCharArray();
            //Replace each acharcter with new words
            for(int j =0 ; j<chars.length ; ++j)
            {
                char OrgChar = chars[j];
                for(char ch = 'a'; ch <= 'z' ; ++ch )
                {

                    if (ch == OrgChar) continue;

                        chars[j] = ch;
                        String newWord = new String(chars);

                        // skip if the new word is not in wordSet or already visited
                        if(!wordSet.contains(newWord) || visitedOne.containsKey(newWord))
                        {
                            continue;
                        }

                        // if newWord is presnt in the other visited map , a path is found
                        if(visitedTwo.containsKey(newWord))
                        {
                            return  currStep + visitedTwo.get(newWord);
                        }

                        // otherwise

                               queue.offer(newWord);
                             visitedOne.put(newWord, currStep + 1);
                                

                }

                // Restore the orginal char
                chars[j] = OrgChar;
            }
        }
        return -1;
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
            new String[]{"a", "c", "a,b,c"}                      // Expected: 2
            
        );

        // Run test cases
        int testNumber = 1;
        for (String[] testCase : testCases) {
            String beginWord = testCase[0];
            String endWord = testCase[1];
            List<String> wordList = Arrays.asList(testCase[2].split(","));
            int result = ladderLength(beginWord, endWord, wordList);
            System.out.println("Test " + testNumber + ": " + result);
            testNumber++;
        }
    }

}
