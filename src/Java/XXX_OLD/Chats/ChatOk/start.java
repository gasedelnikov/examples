
package Java.XXX_OLD.Chats.ChatOk;

import java.io.IOException;


/**
 *
 * @author g_sedelnikov
 */
public class start{
    public static String host = "192.168.56.1";
    public static int port = 9900;
    
    public void startClient() throws IOException{
        ChatClient cl1  = new ChatClient(host, port);
        cl1.run();    
    }

    
    public static void startServ() throws IOException {
        ChatServer serv = new ChatServer(port);
        serv.run();
    }
}