package chain;

import java.sql.Timestamp;



public class Block {
	
	int iIndex;              //����
	String sProof;           //������֤����������������棬��ʵ����һ��������֤����ȷ�ĳ���
	String sPreviousHash;    //ǰһ�������Hashֵ
	Timestamp tsCreateTime;  //���鴴��ʱ���
	
	/*���ݿ�
    *
    * �û�ÿ����һ�������õ�ϵͳ10ԪǮ�Ľ�����ͬʱ��Ӯ��ǰ��һ���û���2ԪǮ
    * ������ͬʱ��Ҫ��¼�Լ����û����ͻش����һ��������û���
    *
    * */
   String sSender;           //�ش����һ��������û���
   String sRecipient;        //�ش����ǰ���������û���
   final int iMoneyAward=10; //ϵͳ����������̶�
   final int iMoneyWin=2;    //Ӯȡ����������̶�
	
   public Block(int i,String proof,String hash,Timestamp c,String sender,String recipient){
	    this.iIndex = i;
	    this.sProof = proof;
	    this.sPreviousHash = hash;
	    this.tsCreateTime = c;
	    this.sSender = sender;
	    this.sRecipient = recipient;
   }

}
