package user;

public class Student {
	
	private String StuNum;
	private String Name;
	private String TelNum;
	private String QQNum;
	private String Mail;
	
	public String getStuNum() {
		return StuNum;
	}
	public void setStuNum(String stuNum) {
		StuNum = stuNum;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTelNum() {
		return TelNum;
	}
	public void setTelNum(String telNum) {
		TelNum = telNum;
	}
	public String getQQNum() {
		return QQNum;
	}
	public void setQQNum(String qQNum) {
		QQNum = qQNum;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	
	 public String getEncoding(String str) 
	    {    
	        String encode;
			
		encode = "UTF-16";   		
	        try 
		{    
	            if(str.equals(new String(str.getBytes(), encode))) 
		    {   
	                return encode;    
	            }    
	        } 
		catch(Exception ex) {} 
			
		encode = "ASCII";    
	        try 
		{    
	            if(str.equals(new String(str.getBytes(), encode)))
		    {    
	                return "字符串<< " + str + " >>中仅由数字和英文字母组成，无法识别其编码格式";    
	            }    
	        } 
		catch(Exception ex) {}    
			
		encode = "ISO-8859-1";    
	        try 
		{    
	            if(str.equals(new String(str.getBytes(), encode))) 
		    {    
	                return encode;    
	            }    
	        } 
		catch(Exception ex) {}    
			
		encode = "GB2312";    
	        try 
		{    
	            if(str.equals(new String(str.getBytes(), encode))) 
		    {    
	                return encode;    
	            }    
	        } 
		catch(Exception ex) {} 
			
		encode = "UTF-8";    
	        try 
		{    
	            if(str.equals(new String(str.getBytes(), encode))) 
		    {    
	                return encode;    
	            }    
	        } 
		catch(Exception ex) {}    
	        
	        /*
		 *......待完善
		 */
			
	        return "未识别编码格式";    
	    }  
	
}
