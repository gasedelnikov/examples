
package Java.XXX_OLD.Chats.Ping1;

/**
 *
 * @author g_sedelnikov
 */
public class start {
    
    public static void start(String[] args) {
        String hostname = "";
        int port = 0;
        
        if (args.length < 2){
            showUsage();
            System.exit(0);
        }
        else{
            hostname = args[0];
            port = Integer.parseInt(args[1]);
        }

        EchoClient client = new EchoClient(hostname, port);
        client.start();
    }
    

    public static void showUsage(){
        System.out.println("Usage: java EchoClient [hostname] [portNo]");
    }    
    
    
}
