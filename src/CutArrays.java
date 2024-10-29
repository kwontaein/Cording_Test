public class CutArrays {
    //n*n 크기의 2차원 배열 만들고
    // 1 2 3
    // 2 2 3
    // 3 3 3
    //이렇게 채우고
    //1차원 배열로 바꾸고
    // arr[left] ~ arr[right] 만 남기고 지운 후 return
    public int[] solution(int n, long left, long right) {
        // 범위 내의 요소의 개수를 구함
        int size = (int) (right - left + 1);
        int[] answer = new int[size];

        // left부터 right까지의 요소를 바로 계산해서 answer에 저장
        for (long i = left; i <= right; i++) {
            // (i / n)번째 행에서의 값과 (i % n)번째 열에서의 값 중 더 큰 값을 저장
            answer[(int) (i - left)] = (int) (Math.max(i / n, i % n) + 1);
        }

        return answer;
    }
}
