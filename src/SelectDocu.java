import java.util.Arrays;
import java.util.List;

public class SelectDocu {
    public int solution(String word) {
        // 모음 리스트: 순서대로 'A', 'E', 'I', 'O', 'U'를 저장해 놓은 리스트
        List<Character> vowels = Arrays.asList('A', 'E', 'I', 'O', 'U');

        // 각 자리의 가중치를 나타내는 배열
        // 첫 번째 자리는 781, 두 번째 자리는 156, 세 번째 자리는 31, 네 번째 자리는 6, 다섯 번째 자리는 1
        // 이는 각각 해당 자리의 문자가 고정되었을 때 이후 자리에서 가능한 모든 경우의 수를 반영한 값
        // 가중치 계산은 781 = 5^4 + 5^3 + 5^2 + 5 + 1 로 계산됨 (각 자리마다 5가지 선택 가능)
        int[] weights = {781, 156, 31, 6, 1};

        // 단어의 위치를 누적 계산하기 위한 변수
        int position = 0;

        // 입력된 단어의 각 문자에 대해 반복
        for (int i = 0; i < word.length(); i++) {
            // i번째 자리의 문자 추출
            char ch = word.charAt(i);

            // 현재 문자가 'A', 'E', 'I', 'O', 'U' 중에서 몇 번째인지 인덱스를 찾음
            int index = vowels.indexOf(ch);

            // 위치 계산: (문자의 인덱스 * 해당 자리의 가중치) + 1
            // index는 현재 자리의 문자 위치 (0부터 시작)이며, weights[i]는 해당 자리의 가중치
            // +1은 각 단어가 1부터 시작하기 때문에 추가해주는 값
            position += index * weights[i] + 1;
        }

        // 최종 위치 반환
        return position;
    }
}
