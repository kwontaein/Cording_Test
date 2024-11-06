import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {
    /**
     * @param skill       선행 스킬 순서
     * @param skill_trees 요청한 스킬 트리
     * @return 가능한 스킬 트리 갯수
     */
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        Queue<Character> queueTemp = new LinkedList<>();
        boolean isOk;

        for (char c : skill.toCharArray()) {
            queue.add(c);
        }
        queueTemp.addAll(queue);

        for (String s : skill_trees) {
            queue.addAll(queueTemp); //큐 다시 세팅
            isOk = true;
            for (char c : s.toCharArray()) {
                if (queue.isEmpty()) {
                    break;
                }

                if (queue.contains(c)) { //큐에 해당 값이 있고, 제일 앞에 값과 같으면
                    if (c == queue.peek()) {
                        queue.poll();
                    } else { //제일 앞의 값과 다르다면 break;
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) {
                answer++;
            }
            queue.clear(); //큐 비우기
        }
        return answer;
    }
}
