package org.util;

public class AddEnter {
	public static void main(String args[]){
		AddEnter temp = new AddEnter();
		String tempString = "aaabbbccc";
		System.out.println(temp.AddAnEnter(tempString));
	}
	
	public String AddAnEnter(String temp){
		String result = null;
		int i = temp.length();
		
		if(i>=9){
			String a=temp.substring(0,i/2);
			
			String b=temp.substring(i/2,temp.length());

			 result = a+"\n"+b;
	
			
			 return result;
		}else{
			return temp;
			
		}
		
		
		
		
	}
	public String txtAddAnEnter(String temp){
		String result = null;
		int i = temp.length();
		
		if(i>=9){
			String a=temp.substring(0,i/2);
			
			String b=temp.substring(i/2,temp.length());
             
			//����\n���ַ�������� .txt ���±� ��ת��  ��������� ����һ���ַ���Ҫ ���� ��Ϊ��\n ����ȴ������
			//���Բ���  \\n�ķ�ʽ ���Ա��� \n�ַ� �Ա�����ҳ��ECharts�Ļ��� 
 			 result = a+"\\n"+b;
			
			 return result;
		}else{
			return temp;
			
		}
		
		
		
		
	}

}
