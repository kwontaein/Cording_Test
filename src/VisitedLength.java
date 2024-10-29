import java.util.HashSet;
import java.util.Set;

public class VisitedLength {

    /**
     * 로봇의 이동 경로에서 중복되지 않은 이동 거리 수를 계산하는 메서드.
     *
     * @param dirs 이동 경로 문자열 (U, D, L, R으로 이루어짐)
     * @return 중복되지 않은 이동 거리 수
     */
    public int solution(String dirs) {
        int answer = 0;

        // 방문한 경로를 저장할 Set
        Set<String> visitedPaths = new HashSet<>();

        // 초기 위치 (6, 6)
        int nowX = 5;
        int nowY = 5;

        // 이동
        for (char c : dirs.toCharArray()) {
            int nextX = nowX;
            int nextY = nowY;

            // 경계에 닿았을 때 무효 처리
            if (c == 'U' && nowY > 0) {
                nextY -= 1;
            } else if (c == 'D' && nowY < 10) {
                nextY += 1;
            } else if (c == 'L' && nowX > 0) {
                nextX -= 1;
            } else if (c == 'R' && nowX < 10) {
                nextX += 1;
            }

            // 경로 기록 (중복되지 않은 경로일 경우 answer 증가)
            if (nextX != nowX || nextY != nowY) { // 이동한 경우에만 처리
                String path1 = nowX + "," + nowY + "-" + nextX + "," + nextY;
                String path2 = nextX + "," + nextY + "-" + nowX + "," + nowY;
                //양방향 이동 중복 불가를 위해, path 두개 저장
                if (!visitedPaths.contains(path1) && !visitedPaths.contains(path2)) {
                    visitedPaths.add(path1);
                    visitedPaths.add(path2);
                    answer++; // 새로운 경로일 경우만 answer 증가
                }

                // 위치 갱신
                nowX = nextX;
                nowY = nextY;
            }
        }

        return answer;
    }
}
