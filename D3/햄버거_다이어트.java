
/*
Title   : 햄버거 다이어트
Author  : Hoseok Lee
Date    : 2024/02/12

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT
https://github.com/hoshogi
*/

import java.io.*;
import java.util.StringTokenizer;

class Solution {

    private static int ingredientNum, calorieLimit;
    private static int totalScore, totalCalorie;
    private static int result;
    private static int[] scores, calories;
    private static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredientNum = Integer.parseInt(st.nextToken());
            calorieLimit = Integer.parseInt(st.nextToken());
            scores = new int[ingredientNum];
            calories = new int[ingredientNum];
            isSelected = new boolean[ingredientNum];
            result = 0;
            totalScore = 0;
            totalCalorie = 0;

            for (int i = 0; i < ingredientNum; i++) {
                st = new StringTokenizer(br.readLine());

                scores[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }
            subset(0);
            answer.append("#").append(t).append(" ").append(result).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static void subset(int count) {
        if (count == ingredientNum) {
            return;
        }

        subset(count + 1);
        if (totalCalorie + calories[count] <= calorieLimit) {
            totalCalorie += calories[count];
            totalScore += scores[count];
            result = Math.max(result, totalScore);
            subset(count + 1);
            totalCalorie -= calories[count];
            totalScore -= scores[count];
        }
    }
}