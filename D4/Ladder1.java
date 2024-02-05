/*
Title   : Ladder1
Author  : Hoseok Lee
Date    : 2024/01/30

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh
https://github.com/hoshogi
*/

import java.io.*;
import java.util.StringTokenizer;

class Solution {

	private static final int MAX = 100;
	private static final int T = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= T; i++) {
			br.readLine();
			int[][] board = new int[MAX][MAX];
			int[] dc = {-1, 1};
			boolean[] direction = {true, false};
			int row = MAX, col = MAX;
			boolean up = true;
			boolean left = true;

			for (int j = 0; j < MAX; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < MAX; k++) {
					board[j][k] = Integer.parseInt(st.nextToken());
					if (board[j][k] == 2) {
						row = j;
						col = k;
					}
				}
			}

			while (true) {
				if (row == 0) {
					sb.append("#").append(i).append(" ").append(col).append("\n");
					break;
				}

				if (up) {
					boolean directionChanged = false;

					for (int j = 0; j < 2; j++) {
						int tempCol = col + dc[j];

						if (tempCol < 0 || tempCol >= MAX)
							continue;
						if (board[row][tempCol] == 1) {
							left = direction[j];
							up = false;
							col = tempCol;
							directionChanged = true;
							break;
						}
					}

					if (!directionChanged)
						row--;
					continue;
				}

				if (board[row - 1][col] == 1) {
					up = true;
					row--;
					continue;
				}

				if (left)
					col--;
				else
					col++;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}