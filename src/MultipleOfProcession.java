public class MultipleOfProcession {

    //행렬의 곱 구하기
    //arr1의 한 열과
    //arr2의 한 행의 곱 구하기
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int rowArr1 = arr1.length;
        int colsArr1 = arr1[0].length;
        int colsArr2 = arr2[0].length;
        // 결과 행렬의 크기는 arr1의 행 개수 x arr2의 열 개수
        int[][] answer = new int[rowArr1][colsArr2];

        // 첫 번째 for문: 행렬 arr1의 각 행을 반복
        for (int i = 0; i < rowArr1; i++) {
            // 두 번째 for문: 행렬 arr2의 각 열을 반복
            for (int j = 0; j < colsArr2; j++) {
                // 결과 행렬의 [i][j] 요소 초기화
                answer[i][j] = 0;
                // 세 번째 for문: 행렬 arr1의 열과 행렬 arr2의 행을 곱해서 더함
                for (int k = 0; k < colsArr1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                    // arr1의 i번째 행의 k번째 요소와 arr2의 k번째 행의 j번째 요소를 곱하여 결과에 더함
                }
            }
        }
        return answer;
    }
}
