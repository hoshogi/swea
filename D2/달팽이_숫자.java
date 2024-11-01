/*
Title   : 달팽이 숫자
Author  : Hoseok Lee
Date    : 2024/01/31

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq
https://github.com/hoshogi
*/

import java.io.*;

class Solution {
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            int row = 0, col = 0, direction = 0;
            int n = Integer.parseInt(br.readLine());

            int[][] board = new int[n][n];
            for (int i = 1; i <= n * n; i++) {
                board[row][col] = i;

                int tempRow = row + dr[direction];
                int tempCol = col + dc[direction];

                if (tempRow < 0 || tempRow >= n || tempCol < 0 || tempCol >= n)
                    direction = (direction + 1) % 4;
                else if (board[tempRow][tempCol] != 0)
                    direction = (direction + 1) % 4;

                row += dr[direction];
                col += dc[direction];
            }

            result.append("#").append(t).append("\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    result.append(board[i][j]).append(" ");
                result.append("\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
