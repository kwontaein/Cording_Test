import java.util.PriorityQueue;

public class MoreSpicy {
    //scoville 에서 가장 작은 수와 두번째로 작은 수 *2 를 더하는 것을 반복
    //모든 음식의 스코빌 지수가 k 이상이 되게 만들어야 함.
    public int solution(int[] scoville, int K) {
        // 최소 힙 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 스코빌 배열을 최소 힙에 모두 삽입
        for (int s : scoville) {
            minHeap.offer(s);
        }

        int answer = 0;

        // 가장 작은 값이 K보다 작으면 반복
        while (minHeap.peek() < K) {
            // 원소가 하나 남았는데도 K 이상을 못 만든 경우 -1 반환
            if (minHeap.size() < 2) {
                return -1;
            }

            // 가장 작은 두 개의 값을 꺼내서 새로운 스코빌 지수 계산
            int firstMin = minHeap.poll();
            int secondMin = minHeap.poll();
            int newScoville = firstMin + (secondMin * 2);

            // 새로 계산된 스코빌 지수를 힙에 삽입
            minHeap.offer(newScoville);
            answer++;
        }

        return answer;
    }
}
