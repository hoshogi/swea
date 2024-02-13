/*
Title   : 규영이와 인영이의 카드게임
Author  : Hoseok Lee
Date    : 2024/02/13

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0
https://github.com/hoshogi
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    private static int gyooWin, gyooLose;
    private static int[] gyooCards, inCards;
    private static int[] permList;
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            gyooWin = 0;
            gyooLose = 0;
            gyooCards = new int[9];
            inCards = new int[9];
            permList = new int[9];
            isSelected = new boolean[9];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                gyooCards[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(gyooCards);

            int gyooIndex = 0;
            int inIndex = 0;

            for (int i = 1; i <= 18; i++) {
                if (gyooIndex < 9 && gyooCards[gyooIndex] == i) {
                    gyooIndex++;
                    continue;
                }
                inCards[inIndex++] = i;
            }
            permutation(0);
          
            answer.append("#").append(t).append(" ").append(gyooWin).append(" ").append(gyooLose).append("\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static void permutation(int count) {
        if (count == 9) {
            int total = 0;

            for (int i = 0; i < 9; i++) {
                if (gyooCards[i] > inCards[permList[i]]) {
                    total += gyooCards[i] + inCards[permList[i]];
                    continue;
                }
                total -= gyooCards[i] + inCards[permList[i]];
            }
            if (total > 0)
                gyooWin++;
            else if (total < 0)
                gyooLose++;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (isSelected[i])
                continue;
            isSelected[i] = true;
            permList[count] = i;
            permutation(count + 1);
            isSelected[i] = false;
        }
    }
}
