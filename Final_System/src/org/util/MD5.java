package org.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
	public  static String makeMD5(String password){
		MessageDigest md;
		   try {
		    // ����һ��MD5���ܼ���ժҪ
		    md = MessageDigest.getInstance("MD5");
		    // ����md5����
		    md.update(password.getBytes());
		    // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
		    // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
		    String pwd = new BigInteger(1, md.digest()).toString(15);
		    
		    return pwd;
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   return password;
		}
	
	public static void main(String args[]){
		makeMD5("123456");
	}
	

	

}
