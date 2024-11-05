import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFee {
    //자동차 객체 생성

    /**
     * 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원) - fees
     * 180	       5000	        10	       600
     * <p>
     * <p>
     * <p>
     * <p>
     * 시간   차량 번호   입출여부 --records
     * 05:30    0000    IN
     * o6:00    0000    OUT
     * <p>
     * <p>
     * 출차된 내역이 없다면, 23:59에 출차된 것으로 간주
     *
     * @param fees
     * @param records
     * @return
     */
    public int[] solution(int[] fees, String[] records) {

        //다시, 이용시간 + 차량 번호만 저장
        //후 요금 계산
        int[] answer = {};
        //차번호 + 시간 저장
        HashMap<String, Integer> hashMap = new HashMap<>();
        //차번호 + 요금 저장
        HashMap<String, Integer> result = new HashMap<>();
        for (String s : records) {
            String[] str = s.split(" ");
            int time = timeCalculate(str[0]);
            String carNum = str[1];

            if (str[2].equals("IN")) { //입차인경우
                hashMap.put(carNum, time);
            } else if (str[2].equals("OUT")) { //출차인경우
                //리스트에서 번호가 일치하는 차 시간 불러와서 빼기
                time -= hashMap.get(carNum);
                hashMap.remove(carNum); // 목록에서 삭제

            /*    //만약 이전에 들어온 적이 있다면?
                if (result.containsKey(carNum)) {
                    //요금 추가
                    result.put(carNum, result.get(carNum) + calculateFees(time, fees[0], fees[1], fees[2], fees[3]));
                } else {
                    //시간으로 돈 계산 후 결과 목록에 추가
                    result.put(carNum, calculateFees(time, fees[0], fees[1], fees[2], fees[3]));
                }*/
            }
        }

        if (!hashMap.isEmpty()) { //만약 출차하지 않은 차량이 있다면, 마감시간까지의 가격 계산
            hashMap.forEach((carNum, time) -> {
                time = timeCalculate("23:59") - time;
               /* if (result.containsKey(carNum)) {
                    //요금 추가
                    result.put(carNum, result.get(carNum) + calculateFees(time, fees[0], fees[1], fees[2], fees[3]));
                } else {
                    //시간으로 돈 계산 후 결과 목록에 추가
                    result.put(carNum, calculateFees(time, fees[0], fees[1], fees[2], fees[3]));
                }*/
            });
            //마감시간
        }
        result.forEach((carNum, price) -> {
            System.out.println("CarNum : " + carNum + " , Price : " + price);
        });
        return answer;
    }

    //기록 시간 계산
    private int timeCalculate(String s) {
        String[] str = s.split(":");
        return (Integer.parseInt(str[0]) * 60) + Integer.parseInt(str[1]);
    }

    //가격 계산

    /**
     * @param usedTime      사용시간
     * @param leastTime     기본제공시간
     * @param price         기본가격
     * @param increaseTime  요금 증가 빈도
     * @param increasePrice 빈도당 증가 요금
     * @return
     */
    private int calculateFees(int usedTime, int leastTime, int price, int increaseTime, int increasePrice) {
        int mTime;
        int finalPrice = price;
        if (usedTime <= leastTime) { //기본제공시간 이내에 출차한 경우
            return finalPrice; //기본요금
        } else {
            //추가로 사용한 시간
            mTime = usedTime - leastTime;
            //(추가로 사용한 시간 / 요금 증가 빈도) * 증가요금
            finalPrice += (mTime / increaseTime) * increasePrice;
            //나누어 떨어지지 않으면 올림 처리 (최소요금 1번 추가)
            if (mTime % increaseTime != 0) {
                finalPrice += increasePrice;
            }
        }
        return finalPrice;
    }

}
