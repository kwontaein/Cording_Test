import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Process {
    // 문서의 우선순위와 원래 인덱스를 저장할 클래스
    class Document {
        int priority; // 우선순위
        int index; // 인덱스

        Document(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        int answer = 0;

        // 모든 문서를 큐에 추가 (우선순위와 위치를 함께 저장)
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            Document current = queue.poll(); // 첫 번째 문서 가져오기

            // 현재 문서보다 우선순위가 높은 문서가 있는지 확인
            boolean hasHigherPriority = false;
            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                // 우선순위가 높은 문서가 있으면 현재 문서를 다시 큐의 뒤로 보냄
                queue.add(current);
            } else {
                // 그렇지 않으면 현재 문서를 인쇄
                answer++;
                if (current.index == location) {
                    // 인쇄된 문서가 목표 문서라면 순서 반환
                    return answer;
                }
            }
        }

        return answer; // 모든 문서가 인쇄되었을 때의 순서
    }
}
