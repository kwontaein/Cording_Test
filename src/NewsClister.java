import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NewsClister {
    //문자열을 두 글자 단위로 끊어서 집합 생성
    //두 집합의 합집합과 교집합을 구해서
    //교집합 / 합집합 * 65536 의 정수 부분만 출력
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();

        // 첫 번째 문자열에서 2글자 단위로 자른 후 집합에 추가
        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            if (!isContains(s)) {
                set1.add(s);
            }
        }

        // 두 번째 문자열에서 2글자 단위로 자른 후 집합에 추가
        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);
            if (!isContains(s)) {
                set2.add(s);
            }
        }

        // 교집합과 합집합 계산
        List<String> intersection = new ArrayList<>();
        List<String> temp = new ArrayList<>(set1);
        List<String> union = new ArrayList<>(set1);

        // 교집합 -> 수정필요 : retainAll 메소드는 중복 처리가 안됨
        //intersection.retainAll(set2);
        for (String s : set2) {
            if (temp.contains(s)) {
                intersection.add(s);  // 교집합에 추가
                temp.remove(s);
            }
        }

        // 합집합
        union.addAll(set2);
        for (String s : intersection) {
            union.remove(s); // 교집합 원소들 제거
        }

        int intersectionSize = intersection.size();
        int unionSize = union.size();

        // 자카드 유사도 계산
        double jaccardSimilarity = (unionSize == 0) ? 1.0 : (double) intersectionSize / unionSize;

        // 최종 값 계산
        return (int) (jaccardSimilarity * 65536);
    }

    // 특수문자, 공백, 숫자 포함 여부 확인
    public boolean isContains(String s) {
        return Pattern.compile("[^a-zA-Z]").matcher(s).find();
    }

}
