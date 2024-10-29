import java.util.Arrays;
import java.util.Stack;

public class RemoveByDual {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 스택의 최상단 문자가 현재 문자와 같다면 스택에서 제거 (연속된 문자를 지우기)
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        // 스택이 비어있으면 모든 문자가 연속된 쌍으로 제거된 것이므로 1 반환
        return stack.isEmpty() ? 1 : 0;
    }
}
