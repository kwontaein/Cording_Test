import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        // 유저별 신고당한 횟수 저장
        Map<String, Integer> reportCounts = new HashMap<>();//신고된 유저 목록
        Set<String> uniqueReports = new HashSet<>();//누가 누구 신고했는지
        for (String r : report) { //신고 돌면서
            String[] reported = r.split(" ");
            String reporter = reported[0];//신고자
            String reportedUser = reported[1];//피신고자
            String combined = reporter + "-" + reportedUser; //문자열로 합침
            if (!uniqueReports.contains(combined)) {//중복제거
                reportCounts.put(reportedUser, reportCounts.getOrDefault(reportedUser, 0) + 1);//신고된 유저 목록에 추가
                uniqueReports.add(combined);//누가 누구 신고했는지 중복 없이 저장
            }
        }

        // k번 이상 신고된 유저 찾기
        Set<String> kReportedUsers = new HashSet<>(); //정지될 사용자 목록
        for (Map.Entry<String, Integer> entry : reportCounts.entrySet()) {//신고된 유저 목록에서
            if (entry.getValue() >= k) {//3번 이상 신고먹으면
                kReportedUsers.add(entry.getKey());//정지목록에 추가
            }
        }

        // 각 유저별 신고한 유저 수 계산
        Map<String, Set<String>> reportUsers = new HashMap<>(); //유저별 정지시킨 유저 수
        for (String r : report) {//신고목록
            String[] reported = r.split(" "); //나누고
            String reporter = reported[0];//신고자
            String reportedUser = reported[1];//피신고자
            if (kReportedUsers.contains(reportedUser)) {//정지목록에 피신고자 있으면
                reportUsers.computeIfAbsent(reporter, k1 -> new HashSet<>()).add(reportedUser);//신고자가 정지시킨 유저 목록에 추가
            }
        }

        // 정답 배열 구성
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];//유저 이름 꺼내서
            if (reportUsers.containsKey(user)) {//목록에 있다면
                answer[i] = reportUsers.get(user).size();//정지시킨 유저 수 받아서 배열 저장
            }
        }

        return answer;
    }
}
