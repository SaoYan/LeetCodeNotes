// Dynamic Programming
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0)
            return "";

        boolean dp[][] = new boolean[s.length()][s.length()];
        int stringLen = s.length();
        int begin = 0, end = 0;
        for (int len = 1; len <= stringLen; len++) {
            for (int i = 0; i < stringLen - len + 1; i++) {
                int j = i + len - 1;
                if (len <= 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        begin = i;
                        end = j;
                    }
                }
                else {
                    if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin,end+1);
    }
}
