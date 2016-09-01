package com.ez.ez_home;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Ajay on 08-Dec-15.
 */
public class socketClientConnections implements Runnable {

    String serverIP;
    int serverPort;
    String onRelayNumber;

       public void run() {

        try {

            Socket sC = new Socket(serverIP, serverPort);

            DataOutputStream dOut = new DataOutputStream(sC.getOutputStream());


            // Message to Socket Server
            dOut.writeUTF(String.valueOf(onRelayNumber));

            DataInputStream dIn = new DataInputStream(sC.getInputStream());
            String serverResponse = dIn.readUTF();



        } catch (IOException e) {
            e.printStackTrace();

        }


    }
}