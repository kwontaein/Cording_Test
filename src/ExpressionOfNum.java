public class ExpressionOfNum {
    public int solution(int n) {
        //연속된 자연수의 합으로 표현 가능한 n 의 갯수

        int sum = 0, answer = 0, start = 1;

        for (int i = 1; i <= n; i++) {

            sum += i;
            while (sum > n) {
                sum -= start;
                start++;
            }
            if (sum == n) {
                answer++;
            }
        }
        return answer;
    }
}
