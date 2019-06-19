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
             
			//含有\n的字符串输出到 .txt 记事本 会转义  具体表现是 光标过一个字符需要 两次 因为有\n 但是却看不到
			//所以采用  \\n的方式 可以保留 \n字符 以便在网页中ECharts的换行 
 			 result = a+"\\n"+b;
			
			 return result;
		}else{
			return temp;
			
		}
		
		
		
		
	}

}
