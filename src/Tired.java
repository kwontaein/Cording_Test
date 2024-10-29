public class Tired {
    //todo 다시 공부
    private static int maxDungeons = 0; // 최대 탐험할 수 있는 던전 수

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length]; // 방문 여부 체크 배열
        backtrack(k, dungeons, visited, 0); // 백트래킹 시작
        return maxDungeons;
    }

    // 백트래킹을 통한 탐험 함수
    private static void backtrack(int currentFatigue, int[][] dungeons, boolean[] visited, int count) {
        maxDungeons = Math.max(maxDungeons, count); // 탐험한 던전 수 업데이트
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && currentFatigue >= dungeons[i][0]) { // 아직 방문하지 않았고 탐험 가능하면
                visited[i] = true; // 해당 던전을 탐험
                backtrack(currentFatigue - dungeons[i][1], dungeons, visited, count + 1); // 소모 피로도 차감 후 재귀 호출
                visited[i] = false; // 탐험을 마치고 되돌아오기 (다른 경로 탐색을 위해)
            }
        }
    }
}
