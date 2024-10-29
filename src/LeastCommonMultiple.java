public class LeastCommonMultiple {
    //배열의 최소공배수 구하기
    public int solution(int[] arr) {
        int max = arr[arr.length - 1];
        boolean isLeast = true;
        int answer = 0;
        while (isLeast) {//최소공배수 나올때까지
            answer += max;
            for (int i : arr) { //배열 돌면서 검사
                if (answer % i == 0) { // 제일 큰 값의 배수가 다른 모든 수로 나누어진다면
                    isLeast = false; //그 값이 최소공배수이다.
                } else { //하나라도 다르다면
                    isLeast = true; //다시 돌기
                    break;
                }
            }
        }
        return answer;
    }
}
