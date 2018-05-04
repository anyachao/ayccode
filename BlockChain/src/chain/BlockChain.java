package chain;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;




public class BlockChain {
	
	//�����洢����
	private List<Block> lBlockchain;   
	        
	  
	public BlockChain(){
	     
	}
	
	//�����¿�
	public static Block NewBlock(int i,String proof,String hash,Timestamp c,String sender,String recipient){
	   Block bRet=null;
	     
	   //�����ﴴ��һ���¿�
	   bRet = new Block(i,proof,hash,c,sender,recipient);
	     
	   return bRet;
	}
	
	//��ʼ��Ĵ�������������һ���飬�����ǹ̶�����Ϣ
	//�߼�����˵��ֻ������������Ʒ�ĵ�һ���û���һ��������ʱ�򣬲Ż���Ҫ����������
	public static Block CreateFirstBlock(){
	   try{
	      Timestamp t=new Timestamp((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("2018-01-01 01:01:01").getTime());
	      return NewBlock(0,"�������","",t,"","");
	   }catch(Exception e){
	      return null;
	   }
    }
	  
	//Hash һ����
	public static String Hash(Block block){
	   String sHash=null;
	     
	   //������Hash һ����
	   String s=block.sPreviousHash+block.sProof+block.sRecipient+block.sSender+block.tsCreateTime.toString();
	   
	   sHash = MD5(s);
	     
	   return sHash;
	}
	
	//MD5����
	public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // ���MD5ժҪ�㷨�� MessageDigest ����
            java.security.MessageDigest mdInst = java.security.MessageDigest.getInstance("MD5");
            // ʹ��ָ�����ֽڸ���ժҪ
            mdInst.update(btInput);
            // �������
            byte[] md = mdInst.digest();
            // ������ת����ʮ�����Ƶ��ַ�����ʽ
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
	
	//������֤��
	//��֤��ǰ�ĳ����Ƿ���Ϲ���
	//pre ǰһ������
	//cur ��һ������
	public static boolean ValidProof(String pre,String cur){
	     
	   //��֤��������ͷһ�����ǲ�����һ����������һ����
	   if(cur.charAt(0)!=pre.charAt(pre.length()-1)){
	      return false;
	   }
	     
	   //��֤�Ƿ��ǳ���
	   //http://chengyu.t086.com/chaxun.php?q=%B9%E2%C3%F7%D5%FD%B4%F3&t=ChengYu
	   String content=httpRequest("http://chengyu.t086.com/chaxun.php?q="+cur+"&t=ChengYu");
	   if(content.indexOf("û���ҵ�����������صĳ���")!=-1 || content.indexOf("������̫��")!=-1){
	      return false;
	   }
	     
	   return true;
	}
	
	//��ȡ��������,�����жϳ���������
	public static String httpRequest(String urls){
    	StringBuffer sb = new StringBuffer();
    	try {
            URL url = new URL(urls);
            URLConnection conn = url.openConnection();// ������
            InputStream is = conn.getInputStream();// ��ȡ������
            // URLConnection is =url.openStream();//��д
            Scanner sc = new Scanner(is, "GBK");// ɨ���������������sc��,���뷽ʽ GBK
            
            while (sc.hasNextLine()) {// �ж��Ƿ������һ��
      //        System.out.println(sc.nextLine());// �����ǰ������
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
