/*
Title   : 암호생서기
Author  : Hoseok Lee
Date    : 2024/02/02

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
https://github.com/hoshogi
*/

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            Integer.parseInt(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 8; i++) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; ; i++) {
                dq.addLast(dq.peekFirst() - (i % 5) - 1);
                dq.pollFirst();
                if (dq.peekLast() <= 0) {
                    dq.pollLast();
                    dq.addLast(0);
                    break;
                }
            }
            
            answer.append("#").append(t).append(" ");
            dq.stream().forEach(num -> answer.append(num).append(" "));
            answer.append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
