package Github.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class server2 {
	public static void main(String[] args) throws IOException{
		//1,������������ + �˿�
		DatagramSocket serve = new DatagramSocket(8888);
		//2,׼����������
		byte[] container = new byte[1024];
		//3,��װ�ɰ�DatagramPacket(byte[] buf,int length)
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4,��������
		serve.receive(packet);
		//5����������
		byte[] data = packet.getData();
		double res = convert(data);
		System.out.println(res);
		//6,�ͷ���Դ
		serve.close();
	}
	/**
	 * �ֽ����� + Date ������
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();//�Ѿ����ֽ�������dis�������
		dis.close();
		return num;
	}

}
