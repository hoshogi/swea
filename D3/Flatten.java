/*
Title   : Flatten
Author  : Hoseok Lee
Date    : 2024/01/30

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh
https://github.com/hoshogi
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	
	private static StringBuilder sb = new StringBuilder("");
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		for (int i = 1; i <= 10; i++) {
			int[] count = new int[101];
			int dump = Integer.parseInt(br.readLine());
			int minHeight = 100;
			int maxHeight = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine().toString());
			while (st.hasMoreTokens()) {
				int height = Integer.parseInt(st.nextToken());
				
				count[height]++;
				
				minHeight = Math.min(minHeight, height);
				maxHeight = Math.max(maxHeight, height);
			}
			
			for (int j = 0; j < dump; j++) {
				if (maxHeight == minHeight) {
					break;
				}
				
				count[maxHeight]--;
				count[maxHeight - 1]++;
				count[minHeight]--;
				count[minHeight + 1]++;
				if (count[maxHeight] == 0)
					maxHeight--;
				if (count[minHeight] == 0)
					minHeight++;
			}
			sb.append("#").append(i).append(" ").append(maxHeight - minHeight).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}