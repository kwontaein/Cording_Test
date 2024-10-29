public class KnumDecimal {
    //양의 정수 n
    // k진수로 변환 후
    // 변환된 수 안에 조건에 맞는 소수 찾기
    // 소수 양쪽에 0 이 있는 경우
    // 소수의 한쪽에만 0이 있고 한쪽엔 아무것도 없는경우 ex) 02 / 20
    // 양쪽에 아무것도 없는 경우
    public int solution(int n, int k) {
        int answer = 0;
        String str = toBaseN(n, k);
        System.out.println(str);
        String[] strs = str.split("0");
        for (String s : strs) {
            if (s.isEmpty()) {
                continue;
            }
            if (isDecimal(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
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

    //소수인지 검사
    public static boolean isDecimal(long a) {
        if (a == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
