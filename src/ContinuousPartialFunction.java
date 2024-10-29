import java.util.*;

public class ContinuousPartialFunction {
    //배열 내부의 값으로 나올수 있는 모든 경우의 합을 구하자
    public int solution(int[] elements) {
        Set<Integer> sumList = new HashSet<>();
        //선입선출 구조로 하나씩 밀면서 진행
        Queue<Integer> queue = new LinkedList();

        for (int element : elements) {
            queue.offer(element); // 요소를 Queue에 추가
        }
        int cnt = 0;

        while (cnt != elements.length) {
            int temp = queue.poll();
            int nowSum = temp;
            sumList.add(nowSum);
            for (int j : queue) {
                nowSum += j;
                sumList.add(nowSum);
            }
            queue.add(temp);
            cnt++;
        }
        int answer = sumList.size();
        return answer;
    }
}
