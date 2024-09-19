public class KMP {
    // field
    private int[][] dp;
    private String pat;
    // constructor
    public KMP(String pat) {
        // const
        this.pat = pat;
        int M = pat.length;
        // data struct
        dp = new int[M][256]; // dp[state][char] = next-state
        // base case
        dp[0][pat.charAt(0)] = 1; // only pat[0] moves state from 0 to 1
        // var
        int xst = 0; // shadow state
        // state transfer
        for (int st = 1; st < M; st++) { // state of pat
            for (int ch = 0; ch < 256; ch++) { // char
                if (pat.charAt(st) == ch)
                    dp[st][ch] = st+1; // step state
                else
                    dp[st][ch] = dp[xst][ch]; // back state to shadow state with same char
            }
            xst = dp[xst][pat.charAt(st)]; // update shadow state
        }
    }
    // method
    public int search(String txt) {
        // const
        int M = pat.length;
        int N = txt.length;
        // var
        int st = 0;
        // loop txt
        for (int i = 0; i < N; i++) {
            st = dp[st][txt.charAt(i)];
            if (st == M) // reach ending state
                return i-M+1; // end-idx - len-pat + 1
        }
        // return fallback
        return -1;
    }
}
