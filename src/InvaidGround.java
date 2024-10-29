public class InvaidGround {
    //2차원 배열에서 한칸씩 내려오며 값을 더할 건데
    //그 합의 최대 값을 찾아야 함
    //바로 아래 칸으로는 갈 수 없음
    //바로 아래 칸 이외의 칸들 중, 최대값을 찾아서 해당 칸으로 이동?
    // or dfs
    public int solution(int[][] land) {
        int rows = land.length;

        // 첫 번째 행부터 마지막 행까지 반복하며 DP를 계산
        for (int i = 1; i < rows; i++) {
            // 각 열에 대해 바로 아래 칸을 제외한 값 중 최대값을 찾아 더함
            land[i][0] += Math.max(Math.max(land[i - 1][1], land[i - 1][2]), land[i - 1][3]);
            land[i][1] += Math.max(Math.max(land[i - 1][0], land[i - 1][2]), land[i - 1][3]);
            land[i][2] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][3]);
            land[i][3] += Math.max(Math.max(land[i - 1][0], land[i - 1][1]), land[i - 1][2]);
        }

        // 마지막 행의 값들 중 최대값이 최종 답
        int answer = Math.max(Math.max(land[rows - 1][0], land[rows - 1][1]),
                Math.max(land[rows - 1][2], land[rows - 1][3]));

        return answer;
    }

}
