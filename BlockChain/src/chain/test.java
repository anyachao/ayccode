package chain;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String string = httpRequest("http://chengyu.t086.com/chaxun.php?q=r4r4&t=ChengYu");
		System.out.println(string);
		System.out.println(string.indexOf("û���ҵ�����������صĳ���"));

	}
	
	//��ȡ��������
    public static String httpRequest(String urls){
    	StringBuffer sb = new StringBuffer();
    	try {
            URL url = new URL(urls);
            URLConnection conn = url.openConnection();// ������
            InputStream is = conn.getInputStream();// ��ȡ������
            // URLConnection is =url.openStream();//��д
            Scanner sc = new Scanner(is, "GBK");// ɨ���������������sc��,���뷽ʽ GBK
            
            while (sc.hasNextLine()) {// �ж��Ƿ������һ��
      //          System.out.println(sc.nextLine());// �����ǰ������
                sb.append(sc.nextLine());
            }
            sc.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }	
		return sb.toString();
	}

}
