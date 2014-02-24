package ms;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Master等待CacheServer的连接请求，并创建接收线程。
 * 端口号：5700
 * 与CacheServer中的FeedbackToMaster对应。
 */

public class ReceiveFromCache {
	
	public static void main(String[] args) throws InterruptedException{
	     msReceiveFromCache();
	}

	public static void msReceiveFromCache() throws InterruptedException {
		try {
			System.out.println("Waiting for cache server connection...");
			ServerSocket serverSocket = new ServerSocket(5700);
			Socket connectToCache = null;
			
			while(true) {
				connectToCache = serverSocket.accept();
				new ReFromCacheThread(connectToCache);
				Thread.sleep(1000);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
