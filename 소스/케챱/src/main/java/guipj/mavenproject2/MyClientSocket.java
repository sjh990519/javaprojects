/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipj.mavenproject2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 이주혁
 */
public class MyClientSocket {

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public MyClientSocket(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            printInfo();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void receive() {
        try {
            System.out.println("[서버] " + in.readLine());
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    public void send(String msg) {
        out.println(msg);
        out.flush();
        System.out.println("[클라이언트] " + msg);
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void printInfo() {
        System.out.println(">> 서버 접속에 성공했습니다.");
        System.out.println("        서버 주소 : " + socket.getInetAddress());
        System.out.println("        서버 포트번호 : " + socket.getPort());
        System.out.println("        클라이언트 포트번호 : " + socket.getLocalPort() + "\n\n");
    }

    public static void main(String[] args) {
        MyClientSocket client = new MyClientSocket("192.168.0.7", 7070);
        System.out.println("서버에게 보낼 메시지 입력 >> ");
        Scanner s = new Scanner(System.in);
        String msg = s.nextLine();
        client.send(msg);
        client.receive();
        client.close();
    }
}
