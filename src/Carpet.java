import java.util.ArrayList;
import java.util.List;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        //1. 총 넓이 = a * b 인  a 와 b를 찾는다.
        //2. a-2 * b-2 의 값 =  노랑의 값 인 값을 찾는다.
        //3. 그 중 큰 수를 가로로, 작은 수를 세로로 놓는다.

        int n = brown + yellow;
        int[] answer = {};
        // n의 약수 쌍을 구하기
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) { // i가 n의 약수이면
                if (((i - 2) * ((n / i) - 2)) == yellow) {
                    System.out.println(i + " , " + n / i);
                    answer = new int[]{Math.max(i, n / i), Math.min(i, n / i)};
                }
            }
        }
        return answer;
    }
}
