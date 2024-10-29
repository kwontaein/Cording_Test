public class FarJump {
    //dp 알고리즘
    public long solution(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            n2 = (n0 + n1) % 1234567;
            n0 = n1;   // n1을 업데이트 (이전 두 수의 합)
            n1 = n2;      // n0은 이전의 n1 값으로 업데이트
        }
        answer = n2;
        return answer;
    }
}
