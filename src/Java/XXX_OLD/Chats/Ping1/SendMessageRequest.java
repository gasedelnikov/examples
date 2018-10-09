package Java.XXX_OLD.Chats.Ping1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author g_sedelnikov
 */
public class SendMessageRequest  implements Runnable{

        private String message;
        private Callback cb;
        public SendMessageRequest(String message, Callback cb){
            this.message = message;
            this.cb = cb;
        }
        @Override
        public void run() {
            String msgReceived;
            long timeStart, timeEnd, timeUsed;
            try {
                timeStart = System.nanoTime();
                EchoClient.outToServer.writeBytes(this.message + '\n');
                msgReceived = EchoClient.inFromServer.readLine();
                timeEnd = System.nanoTime();
                // Calculate the time and get the output
                timeUsed = (timeEnd - timeStart) / 1000000;
                cb.callback(timeUsed, msgReceived);
            } catch (IOException e) {
                System.out.println("Error on sending message to server");
            }

        }

    }