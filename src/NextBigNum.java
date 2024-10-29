public class NextBigNum {
    public int solution(int n) {
        String str1 = Integer.toBinaryString(n).replace("0", "");
        int answer = n + 1;
        while (!str1.equals(Integer.toBinaryString(answer).replace("0", ""))) {
            answer++;
        }
        return answer;
    }
}
