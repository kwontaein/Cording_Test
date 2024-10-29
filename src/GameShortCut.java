import java.util.LinkedList;
import java.util.Queue;

public class GameShortCut {
    //5*5 지도에서 0은 막힌 곳 1은 뚫린 곳이므로
    //1로만 다니면서 골로 들어갈 수 있는 최단 경로 찾기
    //길이 없으면 -1
    //bfs 정석 문제
    private static final int[] dx = {-1, 1, 0, 0}; // x축: 상(-1), 하(+1)
    private static final int[] dy = {0, 0, -1, 1}; // y축: 좌(-1), 우(+1)

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    //왔던 길을 제외한 나머지 상하좌우 중 1의 위치로 이동하는 코드 작성 후 재귀
    public int bfs(int[][] map) {
        int n = map.length;    // 맵의 행 길이
        int m = map[0].length; // 맵의 열 길이

        // 방문 여부를 확인하는 배열
        boolean[][] visited = new boolean[n][m];

        // BFS를 위한 큐 (x, y 좌표와 현재까지의 거리를 저장)
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 시작점 (0,0)에서 출발 (거리 1부터 시작)
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2]; // 현재까지의 거리

            // 목표 지점 (마지막 위치) 도달하면 거리를 반환
            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 맵 범위 내에 있고, 이동 가능한 1인 곳이며, 아직 방문하지 않은 곳일 때
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true; // 방문 처리
                    queue.add(new int[]{nextX, nextY, distance + 1}); // 거리 증가 후 큐에 추가
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우 -1 반환
        return -1;
    }
}
