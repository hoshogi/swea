/*
Title   : 정사각형 방
Author  : Hoseok Lee
Date    : 2024/02/07

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc
https://github.com/hoshogi
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

    private static int n;
    private static int maxRoomMove, startRoomNum;
    private static int[][] board, result;
    private static Room[] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            result = new int[n][n];
            rooms = new Room[n * n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    board[i][j] = num;
                    result[i][j] = 1;
                    rooms[i * n + j] = new Room(i, j, num);
                }
            }

            maxRoomMove = 1;
            startRoomNum = 1_000_000;

            Arrays.sort(rooms, (o1, o2) -> Integer.compare(o1.num, o2.num) * -1);
            Arrays.stream(rooms).forEach(room -> checkRoom(room));
            answer.append("#").append(t).append(" ").append(startRoomNum).append(" ").append(maxRoomMove).append("\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    private static void checkRoom(Room room) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int tempRow = room.row + dr[i];
            int tempCol = room.col + dc[i];

            if (tempRow < 0 || tempRow >= n || tempCol < 0 || tempCol >= n)
                continue;
            if (board[tempRow][tempCol] == room.num - 1) {
                result[tempRow][tempCol] = result[room.row][room.col] + 1;
                if (result[tempRow][tempCol] >= maxRoomMove) {
                    maxRoomMove = result[tempRow][tempCol];
                    startRoomNum = board[tempRow][tempCol];
                }
            }
        }
    }

    private static class Room {

        int row;
        int col;
        int num;

        public Room(int row, int col, int num) {
            this.row = row;
            this.col = col;
            this.num = num;
        }
    }
}
