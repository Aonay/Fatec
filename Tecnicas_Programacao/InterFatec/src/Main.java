import java.util.*;

public class Main {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int P = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        
        char[][] grid = new char[X][Y];
        int[][] monsters = new int[X][Y];
        int startX = 0, startY = 0;
        int endX = 0, endY = 0;
        
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                grid[i][j] = sc.next().charAt(0);
                if (grid[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'K') {
                    endX = i;
                    endY = j;
                } else if (Character.isDigit(grid[i][j])) {
                    monsters[i][j] = Character.getNumericValue(grid[i][j]);
                }
            }
        }
        
        int steps = bfs(P, grid, monsters, startX, startY, endX, endY);
        
        if (steps == -1) {
            System.out.println("N");
        } else {
            System.out.println(steps);
        }
    }
    
    public static int bfs(int P, char[][] grid, int[][] monsters, int startX, int startY, int endX, int endY) {
        int X = grid.length;
        int Y = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, P});
        boolean[][] visited = new boolean[X][Y];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int power = current[2];
            
            if (x == endX && y == endY) {
                return grid[x][y] == 'K' ? P - power : -1;
            }
            
            if (grid[x][y] == '#' || power == 0) {
                continue;
            }
            
            visited[x][y] = true;
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if (newX >= 0 && newX < X && newY >= 0 && newY < Y && !visited[newX][newY]) {
                    if (grid[newX][newY] == 'K' || grid[newX][newY] == '.' || (Character.isDigit(grid[newX][newY]) && power >= monsters[newX][newY])) {
                        int newPower = (Character.isDigit(grid[newX][newY])) ? Math.max(power, monsters[newX][newY]) : power;
                        queue.add(new int[]{newX, newY, newPower});
                    }
                }
            }
        }
        
        return -1;
    }
}