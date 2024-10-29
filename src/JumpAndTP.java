public class JumpAndTP {
    //점프한 칸 수 만큼 베터리 소모
    //점프로 이동하거나, 현재 위치 * 2 만큼 TP
    //베터리를 최소한으로 사용하는 경우 찾기
    public int solution(int n) {
        //2로 나눈 나머지가 0 이 아닐 경우 ans + 1 하고 n - 1
        //2로 나눈 나머지가 0 일 경우 ans 는 그대로, n = n / 2
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                ans += 1;
                n -= 1;
            }
        }
        return ans;
    }
}
