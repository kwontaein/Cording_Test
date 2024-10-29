import java.util.*;

public class RecoChat {
    //노드 클래스 정의 (위치 + 깊이)
    class Node {
        int[] position;
        int depth;

        Node(int[] position, int depth) {
            this.position = position;
            this.depth = depth;
        }
    }

    public int solution(String[] board) {
        int answer = 0;
        char[][] newBoard = rewind2(board);
        int[] locateR = robot(newBoard);
        int[] locateG = locateG(newBoard);
        answer = queue(newBoard, locateR, locateG);
        System.out.println(answer);
        return answer;
    }

    //queue 검사
    private int queue(char[][] newBoard, int[] locateR, int[] locateG) {
        Queue<Node> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // 큐에 BFS를 시작 할 노드 번호를 넣어줍니다.
        q.offer(new Node(locateR, 0));
        visited.add(Arrays.toString(locateR)); // 시작 노드를 방문 처리

        while (!q.isEmpty()) {
            // 큐에서 맨 앞 노드 꺼내기
            Node currentNode = q.poll();
            int[] nodeIndex = currentNode.position;
            int currentDepth = currentNode.depth;

            System.out.println("nodeIndex : " + nodeIndex[0] + "-" + nodeIndex[1]);
            // 갈 수 있는 다른 노드 찾기
            List<int[]> arr = addNode(nodeIndex[0], nodeIndex[1], newBoard);

            // 큐에 방문 가능 좌표 추가
            for (int[] able : arr) {

                String key = Arrays.toString(able);

                if (able[0] == locateG[0] && able[1] == locateG[1]) {
                    return currentDepth + 1;
                }

                if (!visited.contains(key)) {
                    q.add(new Node(able, currentDepth + 1));
                    visited.add(key); // 큐에 추가할 때 방문 처리
                }
            }
        }

        return -1;
    }

    //다른 좌표 찾기
    private List<int[]> addNode(int y, int x, char[][] board) {
        List<int[]> nodes = new ArrayList<>();
        addToQueueIfValid(x, y, 1, 0, board, nodes);//오
        addToQueueIfValid(x, y, -1, 0, board, nodes);//왼
        addToQueueIfValid(x, y, 0, 1, board, nodes);//아
        addToQueueIfValid(x, y, 0, -1, board, nodes);//위
        return nodes;
    }

    private void addToQueueIfValid(int x, int y, int dx, int dy, char[][] board, List<int[]> nodes) {
        int prevY = y;
        int prevX = x;
        int cnt = 0;
        if (dx != 0) {
            cnt = board[0].length;
        } else if (dy != 0) {
            cnt = board.length;
        }

        for (int i = 1; i <= cnt; i++) {


            int newY = y + (i * dy);
            int newX = x + (i * dx);

            if (newY < 0 || newY >= board.length || newX < 0 || newX >= board[0].length) {
                System.out.println("정지 : [" + newY + "," + newX + "]");
                break;
            }

            boolean hitObstacle = (board[newY][newX] == 'D');
            boolean hitEdge = (dy != 0 && (newY == board.length - 1 || newY == 0)) || (dx != 0 && (newX == board[0].length - 1 || newX == 0));


            if (hitObstacle) {
                System.out.println("[" + prevY + "," + prevX + "]");
                nodes.add(new int[]{prevY, prevX});
                break;
            } else if (hitEdge) {

                System.out.println("[" + newY + "," + newX + "]");
                nodes.add(new int[]{newY, newX});
                break;
            }

            prevY = newY;
            prevX = newX;
        }
    }

    //2차원 배열화
    public char[][] rewind2(String[] board) {
        char[][] newChar = new char[board.length][board[0].length()];
        int cnt = 0;
        for (String str : board) {
            newChar[cnt] = str.toCharArray();
            cnt++;
            System.out.println(str);
        }
        return newChar;
    }

    //R의 위치 받기
    public int[] robot(char[][] board) {
        int x = 0;
        int y = 0;
        outerLoop:
        for (char[] chars : board) {
            for (char c : chars) {
                if (c == 'R') break outerLoop; // 'R'을 찾으면 두 루프 모두 종료
                x++;
            }
            y++;
        }
        System.out.println("R 위치");
        System.out.println("y : " + y + " / x : " + (x % board[0].length == 0 ? board[0].length : x % board[0].length));
        return new int[]{y, x % board[0].length == 0 ? 0 : x % board[0].length};
    }

    //G의 위치 받기
    public int[] locateG(char[][] board) {
        int x = 0;
        int y = 0;
        outerLoop:
        for (char[] chars : board) {
            for (char c : chars) {
                if (c == 'G') break outerLoop;
                x++;
            }
            y++;
        }
        System.out.println("G 위치");
        System.out.println("y : " + y + " / x : " + (x % board[0].length == 0 ? board[0].length : x % board[0].length));
        return new int[]{y, x % board[0].length == 0 ? board[0].length : x % board[0].length};
    }

}

/*
모범답안
import java.util.*;

class Solution {
    static int n, m, sx, sy, ex, ey;
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int bfs(){
        Queue<int[]> q = new LinkedList<int[]>();
        visit[sx][sy] = true;
        q.add(new int[]{sx, sy, 0});

        while(!q.isEmpty()){
            int[] point = q.poll();

            int x = point[0];
            int y = point[1];
            int dist = point[2];

            if(x==ex && y==ey) return dist;

            for(int i=0;i<4;i++){
                int nextX = x;
                int nextY = y;

                for(int k=1;k<=Math.max(n, m);k++){
                    nextX+=dx[i];
                    nextY+=dy[i];

                    if(nextX<0 || nextX>=n || nextY<0 || nextY>=m || map[nextX][nextY] =='D') {
                        nextX-=dx[i];
                        nextY-=dy[i];
                        break;
                    }
                }

                if(visit[nextX][nextY]) continue;

                visit[nextX][nextY] = true;
                q.add(new int[]{nextX, nextY, dist+1});
            }
        }

        return -1;
    }

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        map = new char[n][m];
        visit = new boolean[n][m];

        for(int i=0;i<n;i++) {
            map[i] = board[i].toCharArray();
            for(int j=0;j<m;j++) {
                if(map[i][j] == 'R'){
                    sx = i;
                    sy = j;
                }
                else if(map[i][j] == 'G'){
                    ex = i;
                    ey = j;
                }
            }
        }

        return bfs();
    }
}

 */
