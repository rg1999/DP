import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
        solve();
    }

    static boolean check(int[] given, int i) {
        boolean less = true;
        if (i < 5) {
            for (int j = 0; j < i; j++) {
                if (given[i] >= given[j]) {
                    less = false;
                    break;
                }
            }
        } else {
            for (int j = i - 5; j < i; j++) {
                if (given[i] >= given[j]) {
                    less = false;
                    break;
                }
            }
        }
        return less;
    }

    static void solve() throws IOException {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(inp.readLine());
        for (int t = 0; t < testCase; t++) {
            int size = Integer.parseInt(inp.readLine());
            int[] given = new int[size];
            String[] s1 = inp.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                given[i] = Integer.parseInt(s1[i]);
            }
            int count = 0;
            for (int i = 0; i < size; i++) {
                boolean less = check(given, i);
                if (less) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}