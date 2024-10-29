import java.util.*;

public class RollCakeCut {
    //동일한 종류 갯수(가짓수)의 토핑을 원함
    //배열을 잘랐을 때, 각 부분 별로 놓인 토핑의 종류 갯수가 같아야 한다
    //공평하게 나눌수 없다면 0 반환
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> leftSet = new HashSet<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        // 우측에 있는 모든 토핑 종류와 개수를 먼저 저장합니다.
        for (int top : topping) {
            rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);
        }

        // 왼쪽 집합에 토핑을 하나씩 추가하고, 오른쪽 맵에서 제거
        for (int top : topping) {
            leftSet.add(top); // 왼쪽 집합에 토핑 추가
            rightMap.put(top, rightMap.get(top) - 1);

            // 토핑의 개수가 0이 되면, 해당 토핑을 오른쪽 맵에서 제거
            if (rightMap.get(top) == 0) {
                rightMap.remove(top);
            }

            // 왼쪽과 오른쪽의 서로 다른 토핑 종류 개수가 같으면 answer 증가
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }

}
