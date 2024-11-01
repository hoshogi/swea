/*
Title   : 파리 퇴치
Author  : Hoseok Lee
Date    : 2024/02/01

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
https://github.com/hoshogi
*/

import java.io.*;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] sum = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    sum[i][j] += sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i = m; i <= n; i++) {
                for (int j = m; j <= n; j++) {
                    result = Math.max(result, sum[i][j] - sum[i - m][j] - sum[i][j - m] + sum[i - m][j - m]);
                }
            }

            answer.append("#").append(t).append(" ").append(result).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}

