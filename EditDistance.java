package Project2_java.src.algo;

public class EditDistance {
    public static int levenshtein(String a, String b) {
        int n = a.length(), m = b.length();
        int[] prev = new int[m + 1];
        for (int j = 0; j <= m; j++) prev[j] = j;
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) curr[j] = prev[j - 1];
                else curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
            }
            prev = curr;
        }
        return prev[m];
    }
}
