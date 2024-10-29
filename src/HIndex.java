import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HIndex {
    //논문 중, h회 이상 인용된 것이 h개 이상 인 h의 최대값을 찾자.
    //ㅋㅋ 아
    public int solution(int[] citations) {
        int answer = 0;
        int cnt = 0;
        Arrays.sort(citations);
        //h 인덱스는 배열의 길이를 벗어날 수 없음.
        // i를 h 인덱스라 가정, 조건 검사
        for (int i = 0; i <= citations.length; i++) {
            //배열 내부 값과 비교
            for (int j = 0; j < citations.length; j++) {
                //조건에 해당하는 값들 카운트
                if (i <= citations[j]) {
                    cnt++;
                }
            }
            //갯수가 h개 이상이면 answer 수정
            if (i <= cnt) {
                answer = i;
            }
            cnt = 0;
        }
        System.out.println(answer);
        return answer;
    }
}
