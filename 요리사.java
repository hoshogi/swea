/*
Title   : 요리사
Author  : Hoseok Lee
Date    : 2024/02/18

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
https://github.com/hoshogi
*/

import java.io.*;
import java.util.StringTokenizer;

class Solution {

    private static int foodNum;
    private static int result;
    private static int tasteDifference;
    private static int[] combList1, combList2;
    private static int[][] synergy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            foodNum = Integer.parseInt(br.readLine());
            synergy = new int[foodNum][foodNum];
            combList1 = new int[foodNum / 2];
            combList2 = new int[foodNum / 2];
            result = 20_000 * 16 * 16;

            for (int i = 0; i < foodNum; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < foodNum; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0, 0);
            answer.append("#").append(t).append(" ").append(result).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static void combination(int count, int start) {
        if (count == foodNum / 2) {
            int index1 = 0, index2 = 0;
            for (int i = 0; i < foodNum; i++) {
                if (index1 < foodNum / 2 && combList1[index1] == i) {
                    index1++;
                    continue;
                }
                combList2[index2++] = i;
            }
            tasteDifference = 0;

            for (int i = 0; i < foodNum / 2; i++) {
                for (int j = 0; j < foodNum / 2; j++) {
                    tasteDifference += synergy[combList1[i]][combList1[j]] - synergy[combList2[i]][combList2[j]];
                }
            }
            result = Math.min(result, Math.abs(tasteDifference));
            return;
        }

        for (int  i = start; i < foodNum; i++) {
            combList1[count] = i;
            combination(count + 1, i + 1);
        }
    }
}