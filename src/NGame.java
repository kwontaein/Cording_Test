public class NGame {
    //숫자를 n 진수로 한자리씩 출력하는데
    //말해야 하는 갯수 t
    //인원수 m
    //내 순서 p
    public String solution(int n, int t, int m, int p) {
        StringBuilder str = new StringBuilder(); // 전체 숫자를 n진수로 변환하여 저장할 문자열
        int i = 0;

        // str의 길이가 내가 말해야 할 숫자 개수(t) * 인원수(m)를 초과할 때까지 반복
        while (str.length() < t * m) {
            str.append(toBaseN(i, n)); // i를 n진수로 변환하여 str에 추가
            i++;
        }

        StringBuilder answer = new StringBuilder(); // 정답 문자열

        // p번째 위치에 해당하는 문자만 정답에 추가
        for (int j = 0; j < t; j++) {
            answer.append(str.charAt(j * m + p - 1)); // 1번째가 p 위치이므로 p-1을 인덱스로 사용
        }

        return answer.toString(); // 결과 문자열 반환
    }

    //n진법 변환
    public static String toBaseN(int number, int base) {
        if (number == 0) {
            return "0"; // 예외 처리: 0일 때는 "0" 반환
        }

        StringBuilder result = new StringBuilder();
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // n진법 변환을 위한 나눗셈 반복
        while (number > 0) {
            int remainder = number % base;
            result.append(digits[remainder]);
            number /= base;
        }

        return result.reverse().toString(); // 결과를 역순으로 반환
    }
}
