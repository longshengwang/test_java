package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestPipedIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sender t1 = new Sender();

		Receiver t2 = new Receiver();

		PipedOutputStream out = t1.getOutputStream();

		PipedInputStream in = t2.getInputStream();

		try {
			// �ܵ�����
			out.connect(in);

			/**
			 * Thread���START������ ʹ���߳̿�ʼִ�У�Java ��������ø��̵߳� run ������
			 * ����������̲߳��������У���ǰ�̣߳��ӵ��÷��ظ� start ����������һ���̣߳�ִ���� run ��������
			 * �������һ���߳��ǷǷ��ġ��ر��ǵ��߳��Ѿ�����ִ�к󣬲���������������
			 */
			t1.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] buf = new byte[1024];
			try {
				int len = in.read(buf);
				System.out.println(new String(buf, 0, len));
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			t2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Sender extends Thread {

	/*
	 * PipedOutputStream�ࣺ ���Խ��ܵ���������ӵ��ܵ�������������ͨ�Źܵ����ܵ�������ǹܵ��ķ��Ͷˡ� ͨ����������ĳ���߳�д��
	 * PipedOutputStream ���� ���������̴߳����ӵ� PipedInputStream ��ȡ��
	 * �������������������ʹ�õ����̣߳���Ϊ�������ܻ���ɸ��߳������� ���ĳ���߳��������ӵĹܵ��������ж�ȡ�����ֽڣ�
	 * �����̲߳��ٴ��ڻ״̬����ùܵ�����Ϊ���� �ٻ� ״̬��
	 */
	private PipedOutputStream out = new PipedOutputStream();

	public PipedOutputStream getOutputStream() {
		return out;
	}

	/**
	 * ��Ϊ����̳���Thread�࣡���Ա����дrun���� ������߳���ʹ�ö����� Runnable ���ж�����ģ� ����ø� Runnable
	 * ����� run ���������򣬸÷�����ִ���κβ��������ء�
	 * 
	 */
	public void run() {
		String strInfo = "hello my Hzw";
		try {
			out.write(strInfo.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Receiver extends Thread {

	/*
	 * PipedInputStream��: �ܵ�������Ӧ�����ӵ��ܵ���������ܵ��������ṩҪд��ܵ�����������������ֽڡ� ͨ����������ĳ���̴߳�
	 * PipedInputStream �����ȡ�� ���������߳̽���д�뵽��Ӧ�� PipedOutputStream��
	 * �������������������ʹ�õ����̣߳���Ϊ�������������̡߳� �ܵ�����������һ�������������ڻ������޶��ķ�Χ�ڽ���������д�������뿪��
	 * ��������ӹܵ�������ṩ�����ֽڵ��̲߳��ٴ��ڣ�����Ϊ�ùܵ����𻵡�
	 */
	private PipedInputStream in = new PipedInputStream();

	/*
	 * ���ʵ������
	 */
	public PipedInputStream getInputStream() {
		return in;
	}

	public void run() {
		byte[] buf = new byte[1024];
		try {
			int len = in.read(buf);
			System.out.println(new String(buf, 0, len));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
