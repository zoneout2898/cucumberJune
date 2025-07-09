import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletionStage;

public class wsConnectionPractice {

    public static void main(String[] args) throws InterruptedException {
    	 HttpClient client = HttpClient.newHttpClient();

         WebSocket webSocket = client.newWebSocketBuilder()
             .buildAsync(URI.create("wss://fstream.binance.com/ws/bnbusdt@aggTrade"), new WebSocket.Listener() {

                 @Override
                 public void onOpen(WebSocket webSocket) {
                     System.out.println("🔗 Connected to WebSocket server");
                     webSocket.sendText("Hello WebSockekkkt!", true);
                     System.out.println("📨 Sent: Hello WebSocket!");
                     webSocket.request(1); // Start listening
                 }

                 @Override
                 public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
                     System.out.println("📩 Received: " + data);
                     return null;
                 }

                 @Override
                 public void onError(WebSocket webSocket, Throwable error) {
                     System.out.println("❌ Error: " + error.getMessage());
                 }
             }).join(); // Wait until connected

         // Continue doing other things in main thread
         for (int i = 0; i < 5; i++) {
             System.out.println("🕒 Main thread working... " + (i + 1));
             try {
                 Thread.sleep(1000); // Simulate other work
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
Thread.sleep(20000);
         System.out.println("✅ Main thread done.");
     
    }
}
