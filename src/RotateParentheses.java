import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateParentheses {
    //옆으로 한칸씩 밀면서 괄호가 올바르게 지정된 문자열의 갯수 찾기
    public int solution(String s) {
        //queue 로 밀면서 검사
        //stack 으로 괄호가 올바른지 검사
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();

        int answer = 0;
        //queue 에 추가
        for (char c : chars) {
            queue.offer(c);
        }

        //홀수 자리면 틀린 것이므로 오류!
        if (chars.length % 2 != 0) {
            return answer;
        }

        for (int i = 0; i < chars.length; i++) {
            boolean isOk = true;
            for (char c : queue) {
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {
                    //닫힌 괄호를 만났는데 stack 이 비었다면 정지
                    if (stack.empty()) {
                        isOk = false;
                        break;
                    }
                    //그 외
                    if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else { // 닫힌 괄호를 만났는데 앞의 괄호가 다른 괄호라면
                        isOk = false;
                        break;
                    }
                }
            }
            if (stack.empty() && isOk) {
                answer++;
            }
            queue.offer(queue.poll());
        }

        return answer;
    }
}
