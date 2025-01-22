import java.util.*;

public class SnakesAndLadders {

    
        private static int boardSize;
    
        // Method to find the shortest path to reach the last square
        public static  int snakesAndLadders(int[][] board) {
            boardSize = board.length;
            Deque<Integer> queue = new ArrayDeque<>(); // Queue to perform BFS
            queue.offer(1); // Starting from the first square
            boolean[] visited = new boolean[boardSize*boardSize + 1]; // track the squares that are visited
            visited[1] = true;
            int moves = 0; // Moves counter


            //This loop will perform the BFS to reach the last Square
            while(!queue.isEmpty())
            {
                for(int i = queue.size(); i>0 ; --i) // for iterating over the current level
                {
                    int curr = queue.poll(); // Get the current square
                    if(curr == boardSize*boardSize) // check if we have reached the end
                    {
                        return moves;
                    }

                    // Explore the next possible 6 moves
                    for(int k = curr + 1; k<= Math.min(curr + 6 , boardSize * boardSize); ++k)
                    {
                        int[] post = convertToPosition(k); // convert square number to board coordinates
                        int next = k; // next square


                        // checking if there's a snake/ladder in the sqaue
                        if(board[post[0]][post[1]] != -1)
                        {
                               next = board[post[0]][post[1]]; // go to new square
                        }

                        //if not visited , mark as visited and add to  the queue
                        if(!visited[next])
                        {
                            visited[next] = true;
                            queue.offer(next);

                        }
                    }
                }

                moves++; //  Increment move count after finishing one level in BFS
            }
            return -1; // Return -1 if it's impossible to reach the end
            
        }
    
        // Convert the square number to board coordinates (i, j)
        private static int[] convertToPosition(int squareNum) {
            int row = (squareNum - 1) / boardSize;
            int col = (squareNum - 1) % boardSize;
            // In even rows (from the top), the order is right to left
            if (row % 2 == 1) {
                col = boardSize - 1 - col; 
            }
            // Convert row to the actual row in the board from the bottom
            return new int[] {boardSize - 1 - row, col};
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
          
    
            System.out.println("Enter the number of test cases:");
            int testCases = scanner.nextInt();
    
            for (int t = 1; t <= testCases; t++) {
                System.out.println("Enter the size of the board (n):");
                int n = scanner.nextInt();
                int[][] board = new int[n][n];
                System.out.println("Enter the board values row by row (-1 for empty, or the destination square for snakes/ladders):");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        board[i][j] = scanner.nextInt();
                    }
                }
    
                // Solve the problem for the current board
                int result = snakesAndLadders(board);
                System.out.println("Test Case #" + t + ": Minimum moves = " + result);
            }
    
            scanner.close();
        }
    

}
