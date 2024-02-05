/*
Title   : 암호문1
Author  : Hoseok Lee
Date    : 2024/02/05

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14w-rKAHACFAYD
https://github.com/hoshogi
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            List<String> passwords = new LinkedList<>();
            int passwordLen = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < passwordLen; i++) {
                String password = st.nextToken();
                passwords.add(password);
            }

            br.readLine();
            String[] orders = br.readLine().split("I");
            for (int i = 1; i < orders.length; i++) {
                st = new StringTokenizer(orders[i]);
                int index = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());
                for (int j = 0; j < len; j++) {
                    String num = st.nextToken();
                    passwords.add(index++, num);
                }
            }

            answer.append("#").append(t).append(" ");
            passwords.stream()
                    .limit(10)
                    .forEach(password ->
                            answer.append(password).append(" "));
            answer.append("\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}
