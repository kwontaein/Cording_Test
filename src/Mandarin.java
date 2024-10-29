import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Mandarin {
    //k개의 귤을 넣을건데
    //배열에서 최소한의 종류로만 채우고 싶다
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int sum = 0; // 고를 귤의 개수
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int cnt;
        for (int i : tangerine) {
            //i가 변할 때마다 key 변경
            if (hashMap.containsKey(i)) {
                // 이미 존재하면 기존 값에 1을 더함
                cnt = hashMap.get(i) + 1;
            } else {
                // 존재하지 않으면 1로 설정
                cnt = 1;
            }
            hashMap.put(i, cnt);
        }
        //value 빼서
        ArrayList<Integer> valueList = new ArrayList<>(hashMap.values());
        //내림차순
        Collections.sort(valueList, Collections.reverseOrder());
        //반복 돌면서 값을 더해 나감
        for (int v : valueList) {
            if (sum + v >= k) {
                answer++;
                break;
            } else {
                sum += v;
                answer++;
            }
        }

        return answer;
    }
}
