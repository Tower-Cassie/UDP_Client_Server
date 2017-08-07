
package Github.udp;

import java.io.IOException;
import java.net.*;
import java.util.*;
/**
 * 创建自己的客户端
 * 1，创建客户端+ 端口
 * 2，准备数据---->字节数组  字节数组输出流
 * 3，打包（发送的地点及端口）
 * 4，发送
 * 5,释放资源
 */
public class client {
		public static void main(String[] args) throws IOException{
			//1，创建客户端+ 端口
			DatagramSocket client = new DatagramSocket(6666);
			//2，准备数据
			Scanner s = new Scanner(System.in);
			String msg = s.next();
			byte[] data = msg.getBytes();
			//3，打包（发送的地点及端口）
			//DatagramSocket(byte[] buf,int lenth,InetSockettAddress address)
			DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
			//4，发送
			client.send(packet);
			//5,释放资源
			client.close();
		}
}
