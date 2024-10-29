import java.util.Arrays;

public class LifeBoat {
    //보트를 최대한 적게 움직여서 모두를 구하자!
    //배열 순서대로 정렬해서 맨 앞 + 맨 뒤 값을 limit 과 비교 후
    //limit 보다 크다면 맨 앞 사람만 보내기, 아니라면 둘 같이 보내기.
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int big = people.length - 1;
        int small = 0;
        while (big != small) {
            System.out.println("people[big] : " + people[big] + " , people[small] : " + people[small]);
            System.out.println("big : " + big + " , small : " + small);

            if (big < 0 || small > big) {
                break;
            }

            if ((people[big] + people[small]) <= limit) {
                small += 1;
            }
            big -= 1;
            answer += 1;
        }

        if (big == small) {
            answer += 1;
        }
        System.out.println("answer : " + answer);

        return answer;
    }
}
