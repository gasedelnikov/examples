package Java.XXX_OLD.Chats.Ping1;

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
public class EchoClient {

    private String hostname;
    private int port;
    private Socket clientSocket;
    static public BufferedReader inFromUser, inFromServer;
    static public DataOutputStream outToServer;
    private double averageTime = 0;
    private int count = 0;

    public EchoClient(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
        try {
            this.clientSocket = new Socket(this.hostname, this.port);
        } catch (UnknownHostException e) {
            System.out.println("Connection Error: unknown host");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Connection Error: connection refused");
            System.exit(1);
        }
        try{
            this.inFromUser   = new BufferedReader( new InputStreamReader(System.in));
            this.outToServer  = new DataOutputStream(this.clientSocket.getOutputStream());
            this.inFromServer = new BufferedReader( new InputStreamReader(this.clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error on Initializing echoclient");
            System.exit(1);
        }
    }

    public void start(){
        System.out.println("Connecting to " + hostname + " with port No " + port);
        String msgSend;
        try {
            while ((msgSend = inFromUser.readLine()) != null){
                // sendMessage asynchronous
                sendMessage(msgSend, new Callback(){
                    // callback function and calculate the average time
                    public void callback(long timeUsed, String msgReceived){
                        averageTime = (count * averageTime + (timeUsed)) / (count + 1);
                        ++count;
                        System.out.println(msgReceived + 
                            " rtt=" +  (double)Math.round(timeUsed * 100)/100    + " ms" +
                            " artt=" + (double)Math.round(averageTime * 100)/100 + " ms");

                    }
                });    
            }
        } catch (IOException e) {
            System.out.println("Error on reading message from user");
        }
    }

    private void sendMessage(String message, Callback cb){
        Thread sendMessageThread = new Thread(new SendMessageRequest(message, cb));
        sendMessageThread.start();
    }



}
    