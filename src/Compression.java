import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {
    /**
     * 주어진 문자열을 LZW 알고리즘을 사용하여 압축하는 메서드.
     *
     * @param input 압축할 문자열 (알파벳만 포함된 문자열).
     * @return 압축된 데이터 (정수 리스트 형태).
     */
    public static List<Integer> solution(String input) {
        // 1. 사전 초기화: 알파벳 대문자 'A'부터 'Z'까지 26개의 패턴을 포함하는 사전을 생성
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            // A~Z 문자 각각에 대해 인덱스를 사전에 추가
            dictionary.put("" + (char) ('A' + i), i + 1);
        }

        // 압축을 위해 사용될 변수 선언
        String current = ""; // 현재 패턴을 저장
        List<Integer> compressedData = new ArrayList<>(); // 최종 압축된 데이터를 저장할 리스트
        int dictSize = 27; // 사전의 크기 (초기에는 27, A~Z로 구성됨)

        // 2. 입력 문자열을 순회하며 패턴을 탐색하고 압축 진행
        for (char symbol : input.toCharArray()) { // 입력 문자열의 각 문자에 대해 반복
            String currentPlusSymbol = current + symbol; // 현재 패턴에 새로운 문자를 추가하여 새로운 패턴 생성

            // 사전에 새로운 패턴이 존재하는지 확인
            if (dictionary.containsKey(currentPlusSymbol)) {
                current = currentPlusSymbol; // 사전에 존재할 경우, 현재 패턴을 확장된 패턴으로 갱신
            } else {
                // 사전에 존재하지 않을 경우, 현재 패턴의 코드 값을 결과 리스트에 추가
                compressedData.add(dictionary.get(current));

                // 새로운 패턴(current + symbol)을 사전에 추가하고 인덱스 증가
                dictionary.put(currentPlusSymbol, dictSize++);

                // 현재 패턴을 새로 들어온 문자로 갱신
                current = "" + symbol;
            }
        }

        // 마지막 패턴 처리: 현재 패턴이 비어 있지 않다면 그 코드 값을 결과 리스트에 추가
        if (!current.equals("")) {
            compressedData.add(dictionary.get(current));
        }

        // 압축된 데이터 리스트 반환
        return compressedData;
    }
}
