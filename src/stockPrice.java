import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class stockPrice {
    //초 단위로 기록된 주식가격이 담긴 배열 prices
    //가격이 떨어지지 않은 기간은 몇 초인지 return
    public List<Integer> solution(int[] prices) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;

            //마지막은 무조건 0
            if (i == prices.length - 1) {
                cnt = 0;
                list.add(cnt);
                break;
            }

            for (int j = i + 1; j < prices.length; j++) { //수가 작아지는 경우를 만나면 스탑
                cnt++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }

            list.add(cnt);
        }
        return list;
    }
}
