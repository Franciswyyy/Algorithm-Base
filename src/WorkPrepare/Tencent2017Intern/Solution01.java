package WorkPrepare.Tencent2017Intern;

import java.util.Scanner;

/*
    刪除最少的使得回文串最长？
 */
public class Solution01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String tmp = new StringBuffer(str).reverse().toString();
            char[] strChar = str.toCharArray();
            char[] strTmp = tmp.toCharArray();
            System.out.println(helper(strChar, strTmp));
        }
    }

    private static int helper(char[] str, char[] tmp){
        int len = str.length;

        int[][] dp = new int[len+1][len+1];

        for(int i = 0; i <= len; i ++){
            dp[0][i] = 0;
        }
        for(int i = 0; i <= len; i ++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= len; i ++){
            for(int j = 1; j <= len; j ++){
                if(str[i-1] == tmp[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return len - dp[len][len];
    }

}
