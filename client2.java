package Github.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class client2 {
	public static void main(String[] args) throws IOException{
		//1�������ͻ���+ �˿�
		DatagramSocket client = new DatagramSocket(6666);
		//2��׼������
		double num = 12.12;
		byte[] data = convert(num);
		//3����������͵ĵص㼰�˿ڣ�
		//DatagramSocket(byte[] buf,int lenth,InetSockettAddress address)
		DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
		//4������
		client.send(packet);
		//5,�ͷ���Դ
		client.close();
	}
	/**
	 * �ֽ����� ����Դ + Data�����
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException{
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		//DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());
		dos.writeDouble(num);
		dos.flush();//ˢ��
		//��ȡ����
		data = bos.toByteArray();
		dos.close();
		return data;
	}


}
