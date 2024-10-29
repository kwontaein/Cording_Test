import java.io.*;

public class brusport {
    public static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            prime = new boolean[2 * N + 1];
            get_prime();

            int cnt = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                // false = 소수
                if (!prime[i]) cnt++;
            }
            stringBuilder.append(cnt + "\n");
        }
        System.out.println(stringBuilder);
    }


    // 에라토스테네스의 체 알고리즘
    public static void get_prime() {
        // true = 소수아님 , false = 소수
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
