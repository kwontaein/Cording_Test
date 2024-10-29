public class FibonacciNumbers {
    public int solution(int n) {
        // 맨 앞은 0, 1 그 이후의 값들은 앞의 두 수의 합
        int n0 = 0;
        int n1 = 1;

        int answer = 0;

        for (int i = 2; i <= n; i++) {
            answer = (n0 + n1) % 1234567;
            n0 = n1;
            n1 = answer;
        }

        return answer;
    }
}
