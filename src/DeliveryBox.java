import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeliveryBox {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subBelt = new Stack<>();
        int box = 1; // 컨테이너 벨트에서 꺼낼 상자의 번호

        for (int target : order) {
            // 컨테이너 벨트에서 트럭에 실을 상자가 나올 때까지 보조 벨트에 저장
            while (box <= target) {
                subBelt.push(box);
                box++;
            }

            // 트럭에 실어야 하는 상자가 보조 벨트의 맨 위에 있다면 트럭에 싣기
            if (!subBelt.isEmpty() && subBelt.peek() == target) {
                subBelt.pop();
                answer++;
            } else {
                break; // 원하는 상자를 실을 수 없으면 종료
            }
        }
        return answer;
    }
    //틀린 코드
   /* public int solution(int[] order) {
        int answer = 1;

        List<Integer> subBelt = new ArrayList<>(); //서브 값을 저장할 벨트
        List<Integer> usedBelt = new ArrayList<>(); //서브 값을 저장할 벨트
        int before = order[0];
        int index = 1;

        //처음 값을 만나기 이전까지의 값을 sub에 저장
        for (int i = 0; i < before; i++) {
            subBelt.add(i);
        }
        // System.out.println("order[index] : " + order[0]);

        while (index < order.length) {
            //그 다음 값이 이전 값보다 큰지 작은지 확인,
            //System.out.println("order[index] : " + order[index]);
            if (order[index] < before) {  //작다면
                int lastSub = subBelt.get(subBelt.size() - 1); //서브 목록에서 제일 마지막 값 가져오기
                if (order[index] == lastSub) {// sub의 제일 마지막 값인지 확인 후
                    subBelt.remove(Integer.valueOf(lastSub)); // 맞으면 서브에서 제거
                    usedBelt.add(Integer.valueOf(lastSub));
                    answer++; //결과 추가
                } else {//아니라면 종료
                    // System.out.println("break! : " + lastSub);
                    break;
                }
            } else { //크다면
                //sub에 현재 값부터 다음 값까지 저장 --여기가 문제네 싯팔
                usedBelt.add(order[index]);
                for (int i = before + 1; i < order[index]; i++) {
                    if (!usedBelt.contains(i)) {
                        subBelt.add(i);
                    }
                }
                //후 값 추가
                answer++;
            }
            before = order[index]; //이전 값 업데이트
            index++;
        }

        return answer;
    }*/
}
