package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Executor extends Thread{
    Socket socket;
    public Executor(Socket socket){
        super();
        this.socket = socket;
    }

    public void run(){
        try {
            Scanner scan = new Scanner(socket.getInputStream());
            PrintStream printout = new PrintStream(socket.getOutputStream());
            int id = scan.nextInt();
            int seat = scan.nextInt();
            printout.println(seat + " was booked!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void checkingSeat(int id, int seat){
        for (Bus bus:Server.buses) {
            if (bus.getId()==id){
                if (bus.getSeats()[seat]==true){
                    System.out.println("The seat is already occupied!");
                }else{
                    bus.getSeats()[seat] = true;
                }
            }
        }
    }
}
