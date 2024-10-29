public class Bracket {
    //n명이서 토너먼트
    //내가 a
    //b를 언제 만나나?
    public int solution(int n, int a, int b) {
        int answer = 0;

        // a와 b의 번호가 서로 같아질 때까지 반복
        while (a != b) {
            // 번호를 2로 나누어 다음 라운드 번호 계산 (올림처리)
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}
