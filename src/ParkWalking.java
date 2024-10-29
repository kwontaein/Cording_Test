class ParkWalking {
    public int[] solution(String[] park, String[] routes) {

        /*
         Main 코드
         Scanner s = new Scanner(System.in);
        String park2 = s.nextLine().replaceAll("[\"\\[\\]]", "");
        String route = s.nextLine().replaceAll("[\"\\[\\]]", "");

        int[] result;

        ParkWalking solution = new ParkWalking();
        result = solution.solution(park2.split(","), route.split(","));
        System.out.println(Arrays.toString(result));
        */

        int startX = 0, startY = 0;

        // 시작 위치 찾기
        for (String str : park) {
            if (str.contains("S")) {
                startX = str.indexOf("S");
                break;
            }
            startY++;
        }

        for (String move : routes) {
            String[] parts = move.split(" ");
            char direction = parts[0].charAt(0);
            int steps = Integer.parseInt(parts[1]);

            // 이동량 설정
            int deltaX = 0, deltaY = 0;
            if (direction == 'W' || direction == 'E') {
                deltaX = (direction == 'W') ? -steps : steps;
            } else {
                deltaY = (direction == 'N') ? -steps : steps;
            }

            int newX = startX + deltaX;
            int newY = startY + deltaY;

            // 유효한 위치 검사
            if (newX >= 0 && newX < park[0].length() && newY >= 0 && newY < park.length) {
                boolean isBlocked = false;
                for (int i = Math.min(startX, newX); i <= Math.max(startX, newX); i++) {
                    if (park[startY].charAt(i) == 'X') {
                        isBlocked = true;
                        break;
                    }
                }
                for (int j = Math.min(startY, newY); j <= Math.max(startY, newY); j++) {
                    if (park[j].charAt(startX) == 'X') {
                        isBlocked = true;
                        break;
                    }
                }
                if (!isBlocked) {
                    startX = newX;
                    startY = newY;
                }
            }
        }
        return new int[]{startY, startX};
    }
}
