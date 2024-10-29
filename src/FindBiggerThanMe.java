import java.util.*;

public class FindBiggerThanMe {
    public int[] solution(int[] numbers) {
        return bigger(numbers);
    }

    public int[] bigger(int[] numbers) {
        int[] reArr = new int[numbers.length];
        Stack<Integer> stack = new Stack<>(); // 인덱스를 저장하는 스택

        // 배열의 끝부터 역순으로 탐색.
        for (int i = numbers.length - 1; i >= 0; i--) {

            // 스택에 있는 인덱스의 값이 현재 값보다 작거나 같으면 삭제.
            while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
                stack.pop();
            }

            // 스택이 비어있다면 오른쪽에 큰 수가 없다는 뜻.
            // 반환할 배열에 저장
            reArr[i] = stack.isEmpty() ? -1 : numbers[stack.peek()];

            // 현재 인덱스를 스택에 저장.
            stack.push(i);
        }

        return reArr;
    }
}
