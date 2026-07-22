/**
 * Solve Tower of Hanoi
 * Print all steps required to move N disks from Source to Destination.
 *
 * Rules:
 * 1. Only one disk can be moved at a time
 * 2. A larger disk cannot be placed on a smaller disk
 * 3. All disks start at source rod and need to be moved to destination rod
 *
 * Example:
 * Input: N = 3
 * Output:
 * Move disk 1 from A to C
 * Move disk 2 from A to B
 * Move disk 1 from C to B
 * ...
 */
public class TowerOfHanoi {

    /**
     * Solves Tower of Hanoi problem recursively
     * @param n number of disks
     * @param source source rod
     * @param destination destination rod
     * @param auxiliary auxiliary rod
     */
    public static void solveHanoi(int n, char source, char destination, char auxiliary) {
        // Base case: if there's only one disk, move it directly
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Step 1: Move n-1 disks from source to auxiliary using destination as temporary
        solveHanoi(n - 1, source, auxiliary, destination);

        // Step 2: Move the largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from auxiliary to destination using source as temporary
        solveHanoi(n - 1, auxiliary, destination, source);
    }

    /**
     * Alternative approach that counts the steps
     * @param n number of disks
     * @param source source rod
     * @param destination destination rod
     * @param auxiliary auxiliary rod
     * @return number of moves
     */
    public static int countMoves(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return 1;
        }

        int moves = 0;

        // Move n-1 disks from source to auxiliary
        moves += countMoves(n - 1, source, auxiliary, destination);

        // Move largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moves++;

        // Move n-1 disks from auxiliary to destination
        moves += countMoves(n - 1, auxiliary, destination, source);

        return moves;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Tower of Hanoi with N = 2 disks:");
        System.out.println("==============================");
        solveHanoi(2, 'A', 'C', 'B');
        System.out.println();

        // Test case 2
        System.out.println("Tower of Hanoi with N = 3 disks:");
        System.out.println("==============================");
        solveHanoi(3, 'A', 'C', 'B');
        System.out.println();

        // Test case 3 - Count moves
        System.out.println("Tower of Hanoi with N = 4 disks (with move count):");
        System.out.println("=================================================");
        int moves = countMoves(4, 'A', 'C', 'B');
        System.out.println("Total moves: " + moves);
        System.out.println("Expected: " + ((1 << 4) - 1) + " (2^4 - 1)");
        System.out.println();

        // Test case 4
        System.out.println("Tower of Hanoi with N = 1 disk:");
        System.out.println("==============================");
        solveHanoi(1, 'A', 'C', 'B');
        System.out.println();

        // Print formula for number of moves
        System.out.println("Number of moves required for N disks: 2^N - 1");
        System.out.println("N=1: " + ((1 << 1) - 1));
        System.out.println("N=2: " + ((1 << 2) - 1));
        System.out.println("N=3: " + ((1 << 3) - 1));
        System.out.println("N=4: " + ((1 << 4) - 1));
        System.out.println("N=5: " + ((1 << 5) - 1));
    }
}