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
		System.out.println(string.indexOf("没有找到与您搜索相关的成语"));

	}
	
	//获取网络内容
    public static String httpRequest(String urls){
    	StringBuffer sb = new StringBuffer();
    	try {
            URL url = new URL(urls);
            URLConnection conn = url.openConnection();// 打开链接
            InputStream is = conn.getInputStream();// 获取数据流
            // URLConnection is =url.openStream();//缩写
            Scanner sc = new Scanner(is, "GBK");// 扫描数据流并存放在sc里,编码方式 GBK
            
            while (sc.hasNextLine()) {// 判断是否存在下一行
      //          System.out.println(sc.nextLine());// 输出当前行内容
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
