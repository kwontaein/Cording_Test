import java.util.*;

public class Tuple {
    //문자열 내부 집합을 쪼개고
    //집합의 갯수가 적은것부터 큰 순으로 비교하면서 수 추가
    public int[] solution(String s) {
        // 주어진 문자열을 쪼갠다
        s = s.substring(2, s.length() - 2); // 양쪽 끝 중괄호 제거
        String[] strs = s.split("\\},\\{"); // },{ 기준으로 분리

        // 문자열을 원소 개수 기준으로 정렬
        Arrays.sort(strs, Comparator.comparingInt(a -> a.split(",").length));
        List<String> strings = new ArrayList<>();
        int[] answer = new int[strs.length];
        int index = 0; // answer 배열의 인덱스

        // 정렬된 결과로 튜플 생성
        for (String str : strs) {
            String[] str2 = str.split(",");
            for (String st : str2) {
                if (!strings.contains(st)) { // 이미 추가되지 않은 원소라면
                    strings.add(st); // 중복 방지를 위해 리스트에 추가
                    answer[index++] = Integer.parseInt(st); // answer 배열에 추가
                }
            }
        }
        return answer;
    }
}
