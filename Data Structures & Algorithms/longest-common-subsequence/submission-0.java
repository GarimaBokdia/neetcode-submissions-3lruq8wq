class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        We are trying to find the LCS of String A (text1) ending at index i and String B (text2) ending at index j.

1. The "Match" Case (Diagonal)
Scenario: The characters at i and j are the SAME.

Example: ...AB vs ...CB (Both end in 'B').

Logic: Since they match, this 'B' is definitely part of the common subsequence! We "lock it in".

Action: We add 1 to our count.

Next: Now we need to know the LCS of the strings before this 'B'.

We look at text1 without the 'B' (index i-1).

We look at text2 without the 'B' (index j-1).

This corresponds to the Diagonal Neighbor (dp[i-1][j-1]).

Formula: 1 + Diagonal

2. The "Mismatch" Case (Top or Left)
Scenario: The characters at i and j are DIFFERENT.

Example: ...ABC vs ...ABD ('C' vs 'D').

Logic: We can't match 'C' and 'D'. One of them (or both) is useless for this specific position. We have to make a choice to find the best possible previous result.

Option 1 (Delete 'C'): Assume 'C' is the useless one. We look at ...AB vs ...ABD. This is the cell Above (dp[i-1][j]).

Option 2 (Delete 'D'): Assume 'D' is the useless one. We look at ...ABC vs ...AB. This is the cell to the Left (dp[i][j-1]).

Action: We don't know which path is better, so we take the Maximum of both.

Formula: Math.max(Top, Left)
*/

    if(text1 == null || text2 == null)
        return 0;

    int M = text1.length();
    int N = text2.length();

    int[][] dp = new int[M+1][N+1];

    for(int i=1; i<=M ; i++){
        for(int j=1; j<=N ; j++){
            // If characters match (Note: strings are 0-indexed, so use i-1)
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                dp[i][j] = dp[i-1][j-1] + 1;
            }
            else{
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
        return dp[M][N];
    }
}