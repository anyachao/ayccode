package chain;

import java.io.File;
import java.io.FileOutputStream;

public class Util {
	
	static final String  sIPPre="192.168.2.";                
	//�Ծ������ڵĵ��Խ���ɨ�裬�ҵ�����������ص�����
	 
	   static final String  sDataFileDir="c://blockchain";     //���ش洢·��
	  
	   //�������ȡ���������ݵ������ļ�
	   public static void DowloadData(){
	 
	      //��������ļ�Ŀ¼�������ھʹ���
	        File dirFile = new File(sDataFileDir);
	        boolean bFile   = dirFile.exists();
	      if(!bFile ){
	         bFile = dirFile.mkdir();
	         //���´����ı����ļ�����дһ��������
	         try{
	            FileOutputStream out = new FileOutputStream(new File(dirFile+"//data.txt"));
	            out.write((BlockChain.CreateFirstBlock().toString()+"\r\n").getBytes());
	            out.close();
	         }catch(Exception e){ 
	         }
	      }
	     
	     
	      //ɨ���ܱߵĽڵ㣬�ҵ�����������ص�����
	      int iLastLen=0;
	      String sLastChain="";
	      for(int i=0;i<255;i+=1){
	         String sThisURL="http://"+sIPPre+i+":8080/blockchain/chain.jsp";
	        
	         System.out.println(sThisURL);
	        
	         String sChain=BlockChain.httpRequest(sThisURL);
	        
	         if(sChain!=""){
	            System.out.println(sChain);
	            String sTemp[]=sChain.split("##");
	            if(sTemp.length>iLastLen){
	                iLastLen=sTemp.length;
	                sLastChain=sChain;
	            }
	         }
	      }
	     
	      try{
	         if(sLastChain!=""){
	            FileOutputStream out = new FileOutputStream(new File(dirFile+"//data.txt"));
	            //System.out.println("before:"+sLastChain);
	            sLastChain=sLastChain.replace("##", "\r\n");
	            //System.out.println("after:"+sLastChain);
	            out.write((sLastChain+"\r\n").getBytes());
	            out.close();
	         }
	      }catch(Exception e){ 
	      }
	     
	   }

}
