
package Github.udp;

import java.io.IOException;
import java.net.*;
import java.util.*;
/**
 * �����Լ��Ŀͻ���
 * 1�������ͻ���+ �˿�
 * 2��׼������---->�ֽ�����  �ֽ����������
 * 3����������͵ĵص㼰�˿ڣ�
 * 4������
 * 5,�ͷ���Դ
 */
public class client {
		public static void main(String[] args) throws IOException{
			//1�������ͻ���+ �˿�
			DatagramSocket client = new DatagramSocket(6666);
			//2��׼������
			Scanner s = new Scanner(System.in);
			String msg = s.next();
			byte[] data = msg.getBytes();
			//3����������͵ĵص㼰�˿ڣ�
			//DatagramSocket(byte[] buf,int lenth,InetSockettAddress address)
			DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
			//4������
			client.send(packet);
			//5,�ͷ���Դ
			client.close();
		}
}
