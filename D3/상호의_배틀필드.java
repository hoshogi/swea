/*
Title   : 상호의 배틀필드
Author  : Hoseok Lee
Date    : 2024/02/15

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LyE7KD2ADFAXc
https://github.com/hoshogi
*/

import java.io.*;
import java.util.StringTokenizer;

class Solution {

    private static int h, w;
    private static int row, col;
    private static int direction;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            for (int i = 0; i < h; i++) {
               String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = str.charAt(j);
                    if (board[i][j] == '^' || board[i][j] == '>' || board[i][j] == 'v' || board[i][j] == '<') {
                        direction = directionToIndex(board[i][j]);
                        row = i;
                        col = j;
                        board[i][j] = '.';
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            String orders = br.readLine();
            for (int i = 0; i < n; i++) {
                char order = orders.charAt(i);

                if (orderToIndex(order) < 4) {
                    direction = orderToIndex(order);
                    int tempRow = row + dr[direction];
                    int tempCol = col + dc[direction];

                    if (tempRow < 0 || tempRow >= h || tempCol < 0 || tempCol >= w)
                        continue;
                    if (board[tempRow][tempCol] == '.') {
                        row = tempRow;
                        col = tempCol;
                    }
                    continue;
                }
                shoot(row, col);
            }

            answer.append("#").append(t).append(" ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (i == row && j == col) {
                        answer.append(indexToDirection(direction));
                        continue;
                    }
                    answer.append(board[i][j]);
                }
                answer.append("\n");
            }
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static int directionToIndex(char direction) {
        switch (direction) {
            case '^':
                return 0;
            case '>':
                return 1;
            case 'v':
                return 2;
            case '<':
                return 3;
        }
        return -1;
    }

    private static int orderToIndex(char order) {
        switch (order) {
            case 'U':
                return 0;
            case 'R':
                return 1;
            case 'D':
                return 2;
            case 'L':
                return 3;
        }
        return 4;
    }

    private static void shoot(int r, int c) {
        while (true) {
            int tempRow = r + dr[direction];
            int tempCol = c + dc[direction];

            if (tempRow < 0 || tempRow >= h || tempCol < 0 || tempCol >= w)
                return;
            if (board[tempRow][tempCol] == '*') {
                board[tempRow][tempCol] = '.';
                return;
            }
            if (board[tempRow][tempCol] == '#')
                return;
            r = tempRow;
            c = tempCol;
        }
    }

    private static String indexToDirection(int index) {
        switch (index) {
            case 0:
                return "^";
            case 1:
                return ">";
            case 2:
                return "v";
            case 3:
                return "<";
        }
        return "";
    }
}
