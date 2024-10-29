import java.util.LinkedList;

public class Cache {
    //cacheSize 만큼의 배열에 cities를 차례대로 넣는데, 가득 차있는 경우엔 제일 먼저 넣은 도시를 지우고, 새로운 도시 맨 뒤에 넣는다.
    //근데 배열이 가득 찬 상태에서, 새로 추가할 도시가 이미 배열에 있는 경우에는, 시간이 1 걸리고 아닌 경우엔 시간이 5 걸린다.
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            //이미 리스트에 포함된 도시라면
            if (list.contains(city)) {
                //앞에 있던거 지우고
                list.remove(city);
                //맨뒤에 추가
                list.add(city);
                //꽉 차지 않았다면
                answer += 1;
            } else {
                if (cacheSize != 0) {
                    if (list.size() == cacheSize) {
                        list.removeFirst();
                    }
                    list.add(city);
                }
                answer += 5;
            }
        }
        System.out.println(answer);

        return answer;
    }
}
