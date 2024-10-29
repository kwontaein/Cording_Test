import java.util.ArrayList;
import java.util.List;

public class SaleEvent {
    //원하는 물품을 전부 할인받자!
    //discount 에서 10일의 기간 안에 내가 원하는 물품이 모두 있는지 확인
    public int solution(String[] want, int[] number, String[] discount) {
        //discount 에서 하나씩 밀면서 10개씩 검사
        //List 에서 지워나가기 -> 다 비면 ok
        //다 돌았는데 안비었으면 다시 채우기
        List<String> wants = new ArrayList<>();
        List<String> wantTemp = new ArrayList<>();
        int answer = 0;

        //리스트에 저장하는 함수
        for (int i = 0; i < want.length; i++) {
            for (int j = 0; j < number[i]; j++) {
                wantTemp.add(want[i]);
                System.out.println(want[i]);
            }
        }
        for (int i = 0; i < discount.length - 9; i++) {
            wants.addAll(wantTemp);
            for (int j = i; j < i + 10; j++) {
                if (wants.contains(discount[j])) {
                    wants.remove(discount[j]);
                }
            }
            if (wants.isEmpty()) {
                answer++;
                continue;
            }
            wants.clear();
        }
        return answer;
    }
}
