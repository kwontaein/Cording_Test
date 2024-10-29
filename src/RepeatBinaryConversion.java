public class RepeatBinaryConversion {
    public int[] solution(String s) {
        int a = 0;
        int b = 1;
        while (!s.equals("1")) {
            System.out.println(s);
            if (s.contains("0")) {
                int cnt = s.length();
                s = s.replace("0", "");
                a += cnt - s.length();
            } else {
                s = Integer.toBinaryString(s.length());
                b++;
            }
        }
        int[] answer = {b, a};
        return answer;
    }
}
