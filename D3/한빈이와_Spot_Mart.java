/*
Title   : 한빈이와 Spot Mart
Author  : Hoseok Lee
Date    : 2024/02/06

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
https://github.com/hoshogi
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            int result = -1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int snackLen = Integer.parseInt(st.nextToken());
            int maxWeight = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = snackLen - 1;

            int[] snacks = new int[snackLen];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < snackLen; i++)
                snacks[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(snacks);

            while (left < right) {
                if (snacks[left] + snacks[right] <= maxWeight) {
                    result = Math.max(result, snacks[left] + snacks[right]);
                    left++;
                    continue;
                }
                right--;
            }
            answer.append("#").append(t).append(" ").append(result).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
