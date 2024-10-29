import java.util.*;

public class Clothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // 의상 종류별 개수 저장
        for (String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        int result = 1;

        // 각 종류마다 (개수 + 1) (입지 않는 경우 포함)
        for (int count : map.values()) {
            result *= (count + 1);
        }

        // 아무것도 입지 않는 경우는 제외해야 함
        return result - 1;
    }
}
