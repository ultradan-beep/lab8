import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;


        dfs(0, rooms, visited);


        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        return true; // All rooms visited
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                visited[key] = true;
                dfs(key, rooms, visited);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1)); // Room 0
        rooms1.add(Arrays.asList(2)); // Room 1
        rooms1.add(Arrays.asList(3)); // Room 2
        rooms1.add(new ArrayList<>()); // Room 3
        System.out.println("Test Case 1: " + solution.canVisitAllRooms(rooms1)); // Output: true

        // Test Case 2
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1)); // Room 0
        rooms2.add(Arrays.asList()); // Room 1
        rooms2.add(Arrays.asList(0, 3)); // Room 2
        rooms2.add(Arrays.asList(2)); // Room 3
        System.out.println("Test Case 2: " + solution.canVisitAllRooms(rooms2)); // Output: false

        // Test Case 3
        List<List<Integer>> rooms3 = new ArrayList<>();
        rooms3.add(Arrays.asList(1)); // Room 0
        rooms3.add(Arrays.asList(0)); // Room 1
        rooms3.add(Arrays.asList(3)); // Room 2
        rooms3.add(Arrays.asList(2)); // Room 3
        System.out.println("Test Case 3: " + solution.canVisitAllRooms(rooms3)); // Output: false
    }
}
