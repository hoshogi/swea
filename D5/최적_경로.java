/*
Title   : 최적 경로
Author  : Hoseok Lee
Date    : 2024/02/15

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15OZ4qAPICFAYD
https://github.com/hoshogi
*/

import java.io.*;
import java.util.StringTokenizer;

class Solution {

    private static int result;
    private static int customerNum;
    private static int[] servicePoint;
    private static int[][] customerPoint;
    private static int[] permList;
    private static boolean[] isSelected;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            customerNum = Integer.parseInt(br.readLine());
            servicePoint = new int[4];
            permList = new int[customerNum];
            isSelected = new boolean[customerNum];
            customerPoint = new int[customerNum][2];
            result = 200 * 12;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                servicePoint[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < customerNum; i++) {
                for (int j = 0; j < 2; j++) {
                    customerPoint[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            permutation(0);
            answer.append("#").append(t).append(" ").append(result).append("\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static void permutation(int count) {
        if (count == customerNum) {
            result = Math.min(result, getTotalDistance());
            return;
        }

        for (int i = 0; i < customerNum; i++) {
            if (isSelected[i])
                continue;
            permList[count] = i;
            isSelected[i] = true;
            permutation(count + 1);
            isSelected[i] = false;
        }
    }

    private static int getTotalDistance() {
        int total = 0;
        int prevX = servicePoint[0];
        int prevY = servicePoint[1];

        for (int i = 0; i < customerNum; i++) {
            total += Math.abs(prevX - customerPoint[permList[i]][0]) + Math.abs(prevY - customerPoint[permList[i]][1]);
            prevX = customerPoint[permList[i]][0];
            prevY = customerPoint[permList[i]][1];
        }
        total += Math.abs(prevX - servicePoint[2]) + Math.abs(prevY - servicePoint[3]);
        return total;
    }
}
