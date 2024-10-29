public class FindBigInString {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        for (String i : arr) {
            max = Math.max(Integer.parseInt(i), max);
            min = Math.min(Integer.parseInt(i), min);
        }
        String answer = min + " " + max;
        return answer;
    }
}
