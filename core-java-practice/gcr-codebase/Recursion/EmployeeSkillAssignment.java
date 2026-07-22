import java.util.ArrayList;
import java.util.List;

/**
 * Employee Skill Assignment
 * An employee can work on multiple projects.
 * Given an array of employee skill scores, find all possible project teams
 * whose total skill score equals a target value.
 *
 * Example:
 * Input: [2, 3, 5, 7]
 * Target = 10
 * Output:
 * [3, 7]
 * [2, 3, 5]
 */
public class EmployeeSkillAssignment {

    /**
     * Finds all subsets of skills that sum to target value
     * @param skills array of skill scores
     * @param target the target sum
     * @return list of all subsets that sum to target
     */
    public static List<List<Integer>> findSkillTeams(int[] skills, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (skills == null || skills.length == 0) {
            return result;
        }
        findSkillTeamsHelper(skills, target, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * Helper method for recursion
     * @param skills array of skill scores
     * @param target remaining target sum
     * @param index current index
     * @param currentTeam current team being built
     * @param result list to store all valid teams
     */
    private static void findSkillTeamsHelper(int[] skills, int target, int index,
                                             List<Integer> currentTeam, List<List<Integer>> result) {

        // Base case 1: if target is 0, we found a valid team
        if (target == 0) {
            result.add(new ArrayList<>(currentTeam));
            return;
        }

        // Base case 2: if target is negative or we've exhausted all skills, return
        if (target < 0 || index == skills.length) {
            return;
        }

        // Include current skill and recurse
        currentTeam.add(skills[index]);
        findSkillTeamsHelper(skills, target - skills[index], index + 1, currentTeam, result);

        // Exclude current skill and recurse
        currentTeam.remove(currentTeam.size() - 1);
        findSkillTeamsHelper(skills, target, index + 1, currentTeam, result);
    }

    public static void main(String[] args) {
        // Test case 1: Basic example
        int[] skills1 = { 2, 3, 5, 7 };
        int target1 = 10;
        System.out.println("Input: [2, 3, 5, 7]");
        System.out.println("Target: " + target1);
        System.out.println("Output:");
        List<List<Integer>> result1 = findSkillTeams(skills1, target1);
        for (List<Integer> team : result1) {
            System.out.println(team);
        }
        System.out.println();

        // Test case 2: Single element subset
        int[] skills2 = { 5, 3, 8, 2 };
        int target2 = 5;
        System.out.println("Input: [5, 3, 8, 2]");
        System.out.println("Target: " + target2);
        System.out.println("Output:");
        List<List<Integer>> result2 = findSkillTeams(skills2, target2);
        for (List<Integer> team : result2) {
            System.out.println(team);
        }
        System.out.println();

        // Test case 3: No valid subsets
        int[] skills3 = { 1, 2, 3 };
        int target3 = 10;
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Target: " + target3);
        System.out.println("Output:");
        List<List<Integer>> result3 = findSkillTeams(skills3, target3);
        if (result3.isEmpty()) {
            System.out.println("No valid teams found");
        } else {
            for (List<Integer> team : result3) {
                System.out.println(team);
            }
        }
        System.out.println();

        // Test case 4: Multiple valid subsets
        int[] skills4 = { 1, 1, 2, 2, 3 };
        int target4 = 4;
        System.out.println("Input: [1, 1, 2, 2, 3]");
        System.out.println("Target: " + target4);
        System.out.println("Output:");
        List<List<Integer>> result4 = findSkillTeams(skills4, target4);
        for (List<Integer> team : result4) {
            System.out.println(team);
        }
        System.out.println();

        // Test case 5: All elements needed
        int[] skills5 = { 2, 3, 5 };
        int target5 = 10;
        System.out.println("Input: [2, 3, 5]");
        System.out.println("Target: " + target5);
        System.out.println("Output:");
        List<List<Integer>> result5 = findSkillTeams(skills5, target5);
        for (List<Integer> team : result5) {
            System.out.println(team);
        }
    }
}