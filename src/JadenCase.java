public class JadenCase {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        String answer = "";
        boolean isBeforeBlank = true;
        for (char c : arr) {
            if (c == ' ') {
                answer += c;
                isBeforeBlank = true;
            } else {
                if (isBeforeBlank) {
                    answer += Character.toUpperCase(c);
                } else {
                    answer += Character.toLowerCase(c);
                }
                isBeforeBlank = false;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
