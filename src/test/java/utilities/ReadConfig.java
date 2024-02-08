package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		try {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//Configuration//Config.properties");
			pro=new Properties();
			pro.load(file);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String getBaseUrl() {
		String baseUrl=pro.getProperty("baseurl");
		return baseUrl;
	}
	
	public String Uname() {
		String userName=pro.getProperty("username");
		return userName;
	}
	
	public String Pw() {
		String pass=pro.getProperty("password");
		return pass;
	}
	
	public String firefoxPath() {
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}
	
	public String chromePath() {
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	
	
	

}
