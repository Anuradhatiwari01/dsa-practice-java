class Solution {
    public int minMoves(String[] classroom, int energy) {

        int rows = classroom.length;
        int cols = classroom[0].length();

        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;

        // Find S and count litter
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (cell == 'L') {
                    litterCount++;
                }
            }
        }

        if (litterCount == 0) {
            return 0;
        }

        // Give every litter cell an ID
        int[][] litterId = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                litterId[i][j] = -1;
            }
        }

        int id = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = id++;
                }
            }
        }

        int fullMask = (1 << litterCount) - 1;

        // BFS state = {row, col, energy, mask, moves}
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {
            startRow, startCol, energy, 0, 0
        });

        boolean[][][][] visited =
            new boolean[rows][cols][energy + 1][1 << litterCount];

        visited[startRow][startCol][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int currentEnergy = current[2];
            int mask = current[3];
            int moves = current[4];

            // All litter collected
            if (mask == fullMask) {
                return moves;
            }

            for (int d = 0; d < 4; d++) {

                int newRow = row + dr[d];
                int newCol = col + dc[d];

                // Outside grid
                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols) {
                    continue;
                }

                // Wall
                if (classroom[newRow].charAt(newCol) == 'X') {
                    continue;
                }

                // No energy to move
                if (currentEnergy == 0) {
                    continue;
                }

                // Moving costs 1 energy
                int newEnergy = currentEnergy - 1;

                char cell = classroom[newRow].charAt(newCol);

                // Reset energy
                if (cell == 'R') {
                    newEnergy = energy;
                }

                // Update litter mask
                int newMask = mask;

                if (cell == 'L') {
                    int litterNumber = litterId[newRow][newCol];
                    newMask = mask | (1 << litterNumber);
                }

                // Add new state if not visited
                if (!visited[newRow][newCol][newEnergy][newMask]) {

                    visited[newRow][newCol][newEnergy][newMask] = true;

                    queue.offer(new int[] {
                        newRow,
                        newCol,
                        newEnergy,
                        newMask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}
