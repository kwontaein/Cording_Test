import java.util.*;

public class ParkingFee {
    //자동차 객체 생성

    /**
     * @param fees    요금 정보
     * @param records 기록
     * @return
     */
    public int[] solution(int[] fees, String[] records) {

        //다시, 이용시간 + 차량 번호만 저장
        //후 요금 계산

        HashMap<String, Integer> inTimes = new HashMap<>();  // 차량 번호 + 입차 시간
        HashMap<String, Integer> totalTimes = new HashMap<>(); // 차량 번호 + 총 사용 시간
        HashMap<Integer, Integer> result = new HashMap<>(); // 차량 번호 + 요금


        for (String s : records) {
            String[] str = s.split(" "); //문자열 분리
            int time = timeCalculate(str[0]); //입차 시간 
            String carNum = str[1]; //차량 번호

            if (str[2].equals("IN")) { //입차인경우
                inTimes.put(carNum, time); //차량 저장
            } else if (str[2].equals("OUT")) { //출차인경우
                //주차장 사용 시간 계산 후 다시 저장 -- 내 코드
                /*time -= inTime.get(carNum);
                totalTimes.put(carNum, time);
                inTime.remove(carNum);*/

                //수정 코드
                int inTime = inTimes.remove(carNum);
                totalTimes.put(carNum, totalTimes.getOrDefault(carNum, 0) + (time - inTime)); // 사용 시간 누적

            }
        }

        /*if (!inTimes.isEmpty()) { //만약 출차하지 않은 차량이 있다면, 마감시간까지의 사용 시간 계산 후 다시 저장
            inTimes.forEach((carNum, time) -> {
                if (!totalTimes.isEmpty()) {
                    totalTimes.put(carNum, (totalTimes.get(carNum) + timeCalculate("23:59") - time));
                } else {
                    totalTimes.put(carNum, (timeCalculate("23:59") - time));
                }
            });
            //마감시간
        }*/ //--내코드


        // 출차하지 않은 차량의 시간 계산 --수정 코드
        inTimes.forEach((carNum, inTime) -> {
            int totalTime = totalTimes.getOrDefault(carNum, 0) + (timeCalculate("23:59") - inTime);
            totalTimes.put(carNum, totalTime);
        });

        totalTimes.forEach((carNum, usedTime) -> {
            result.put(Integer.parseInt(carNum), calculateFees(usedTime, fees[0], fees[1], fees[2], fees[3]));
        });

        return result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) // 차량 번호를 기준으로 정렬
                .mapToInt(Map.Entry::getValue) // 가격만 추출하여 int 배열로 변환
                .toArray(); // int 배열로 리턴
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
        if (usedTime <= leastTime) { //기본제공시간 이내에 출차한 경우
            return price; //기본요금
        } else {
             /* //추가로 사용한 시간
            int mTime = usedTime - leastTime;
            //(추가로 사용한 시간 / 요금 증가 빈도) * 증가요금
            price += (mTime / increaseTime) * increasePrice;
            //나누어 떨어지지 않으면 올림 처리 (최소요금 1번 추가)
            if (mTime % increaseTime != 0) {
                price += increasePrice;
            }*/ // 내코드

            int extraTime = usedTime - leastTime;
            return price + ((extraTime + increaseTime - 1) / increaseTime) * increasePrice; // 올림 처리 --수정코드
        }
    }

}
