import java.util.Arrays;

public class CallList {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        // 2. 인접한 두 전화번호만 비교하여 접두어 여부 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false; // 접두어 관계가 있을 경우 false 반환
            }
        }
        return true;
    }
}
