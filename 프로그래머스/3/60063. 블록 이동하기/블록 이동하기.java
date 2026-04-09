import java.util.*;
class Robot {
    Point left;
    Point right;
    int time;
    int vertical;
    Robot(Point left, Point right, int time, int vertical) {
        this.left = left;
        this.right = right;
        this.time = time;
        this.vertical = vertical;
    }
}
class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static boolean[][][][] visited;
    private static boolean canGo(int lnx, int lny, int rnx, int rny, int n) {
        return 0 <= lnx && 0 <= lny && lnx < n && lny < n && 0 <= rnx && 0 <= rny && rnx < n && rny < n;
    }
    
    private static boolean isBlank(int[][] board, int lnx, int lny, int rnx, int rny) {
        return board[lnx][lny] == 0 && board[rnx][rny] == 0;        
    }
    
    private static int bfs(int[][] board, int n) {
        Queue<Robot> queue = new ArrayDeque<>();
        queue.offer(new Robot(new Point(0,0), new Point(0,1), 0, 0));
        int answer = 0;
                
        while(!queue.isEmpty()) {
            Robot robot = queue.poll();
            
            if (!canGo(robot.left.x, robot.left.y, robot.right.x, robot.right.y, n)) continue;
            
            if (!isBlank(board, robot.left.x, robot.left.y, robot.right.x, robot.right.y)) continue;
            
            if (visited[robot.left.x][robot.left.y][robot.right.x][robot.right.y]) continue;
            
            if ((robot.left.x == n - 1 && robot.left.y == n - 1) || (robot.right.x == n - 1 && robot.right.y == n - 1)) {
                answer = robot.time;
                break;
            }
            
            visited[robot.left.x][robot.left.y][robot.right.x][robot.right.y] = true;            
            
            for (int dir = 0; dir < 4; dir++) {
                int lnx = robot.left.x + dx[dir];
                int lny = robot.left.y + dy[dir];
                int rnx = robot.right.x + dx[dir];
                int rny = robot.right.y + dy[dir];
                
                queue.offer(new Robot(new Point(lnx, lny), new Point(rnx, rny), robot.time + 1, robot.vertical));
            }
            
            // 로봇 방향 수직이라면
            if (robot.vertical == 1) {
                if (robot.left.y - 1 >= 0 && isBlank(board, robot.left.x, robot.left.y - 1, robot.right.x, robot.right.y - 1)) {
                    queue.offer(new Robot(new Point(robot.left.x, robot.left.y), new Point(robot.left.x, robot.left.y - 1), robot.time + 1, 0));
                    queue.offer(new Robot(new Point(robot.right.x,robot.right.y), new Point(robot.right.x, robot.right.y - 1), robot.time + 1, 0));
                }
                if (robot.left.y + 1 < n && isBlank(board, robot.left.x, robot.left.y + 1, robot.right.x, robot.right.y + 1)) {
                    queue.offer(new Robot(new Point(robot.left.x, robot.left.y), new Point(robot.left.x, robot.left.y + 1), robot.time + 1, 0));
                    queue.offer(new Robot(new Point(robot.right.x, robot.right.y), new Point(robot.right.x, robot.right.y + 1), robot.time + 1, 0));
                }
            }
            else {
                if (robot.left.x - 1 >= 0 && isBlank(board, robot.left.x - 1, robot.left.y, robot.right.x - 1, robot.right.y)) {
                    queue.offer(new Robot(new Point(robot.left.x, robot.left.y), new Point(robot.left.x - 1, robot.left.y), robot.time + 1, 1));
                    queue.offer(new Robot(new Point(robot.right.x, robot.right.y), new Point(robot.right.x - 1, robot.right.y), robot.time + 1, 1));
                }
                if (robot.left.x + 1 < n && isBlank(board, robot.left.x + 1, robot.left.y, robot.right.x + 1, robot.right.y)) {
                    queue.offer(new Robot(new Point(robot.left.x, robot.left.y), new Point(robot.left.x + 1, robot.left.y), robot.time + 1, 1));
                    queue.offer(new Robot(new Point(robot.right.x, robot.right.y), new Point(robot.right.x + 1, robot.right.y), robot.time + 1, 1));
                }
            }
        }
        return answer;
    }

    public int solution(int[][] board) {
        visited = new boolean[board.length][board.length][board.length][board.length];
        return bfs(board, board.length);
    }
}