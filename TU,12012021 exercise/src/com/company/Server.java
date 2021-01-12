package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {

    static List<Bus> buses;

    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(1234);
        while(true){
            Socket socket = server.accept();
            new Executor(socket).start();
        }

    }
}
