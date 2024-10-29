import java.util.Arrays;

public class TargetNumber {
    //숫자의 배열이 주어졌을 때, 그 수들의 합과 차로 target 을 만들자
    //dfs / bfs
    //2개 ~ 20개
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    // DFS 메서드
    private int dfs(int[] numbers, int target, int index, int sum) {
        // 모든 숫자를 다 사용했을 때
        if (index == numbers.length) {
            // 합계가 타겟과 같으면 1을 반환하여 경우의 수를 추가
            return sum == target ? 1 : 0;
        }

        // 현재 숫자를 더하거나 빼는 두 가지 경우에 대해 재귀 호출
        return dfs(numbers, target, index + 1, sum + numbers[index])
                + dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
