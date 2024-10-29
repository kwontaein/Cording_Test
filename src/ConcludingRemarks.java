import java.util.HashSet;
import java.util.Set;

public class ConcludingRemarks {
    //n명이서 진행한 끝말잇기 단어들 words
    //몇번째 사람이 언제 탈락했는지를 확인해야함.
 /*   public int[] solution(int n, String[] words) {
        //1 중복 체크
        //set에 넣으면서 사이즈가 변하지 않으면 중복인걸로 인지?
        //2 앞 단어의 마지막 글자와 뒷 단어의 첫 글자가 일치하는지 확인해야함

        char beforeStringLast = words[0].charAt(words[0].length() - 1);
        Set<String> strings = new HashSet<>();

        int cnt = 0;
        int stringsSize = strings.size();

        boolean isAble = true;

        for (String s : words) { //배열돌면서
            strings.add(s); //set에 추가

            if (cnt == 0) { //맨처음 스킵
                cnt++;
                continue;
            }

            if (stringsSize == strings.size()) { // 만약 set 크기가 변하지 않았다면 중복값인 것.
                cnt++;
                isAble = false;
                break;
            }

            if (beforeStringLast != s.charAt(0)) { //이전 단어와 연결되지 않는 단어인 경우
                cnt++;
                isAble = false;
                break;
            }

            stringsSize = strings.size();
            beforeStringLast = s.charAt(s.length() - 1);

            cnt++; // 횟수 추가
        }


        int[] answer;

        if (isAble) {
            answer = new int[]{0, 0};
        } else {
            int result = cnt % n;
            if (result == 0) {
                result = n;
            }
            answer = new int[]{result, ((cnt / n) + (cnt % n))};
        }

        return answer;
    }*/


    public int[] solution(int n, String[] words) {
        // 끝말잇기 규칙을 준수하는지 검사
        Set<String> strings = new HashSet<>();
        char beforeStringLast = words[0].charAt(words[0].length() - 1);

        strings.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];

            // 중복된 단어인 경우
            if (!strings.add(currentWord)) {
                int player = (i % n) + 1;
                int round = (i / n) + 1;
                return new int[]{player, round};
            }

            // 앞 단어의 마지막 글자와 현재 단어의 첫 글자가 맞지 않는 경우
            if (beforeStringLast != currentWord.charAt(0)) {
                int player = (i % n) + 1;
                int round = (i / n) + 1;
                return new int[]{player, round};
            }

            // 현재 단어의 마지막 글자를 저장
            beforeStringLast = currentWord.charAt(currentWord.length() - 1);
        }

        // 탈락자가 없는 경우
        return new int[]{0, 0};
    }
}
