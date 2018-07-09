package cn.nc.crm.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.nc.crm.constant.JdbcConstant;

public class JdbcConfig {

	private String DRIVERMANAGER;
	private String URL;
	private String USERNAME;
	private String PASSWORD;



	public static JdbcConfig getIntance() {
		return ConfigTon.config;
	}

	public static class ConfigTon {
		public static JdbcConfig config = new JdbcConfig();
	}


	static {

		Properties pro = null;
		InputStream in  = null;

		try {
			pro = new Properties();

			in =  JdbcConfig.class.getClassLoader().getResourceAsStream("/jdbc.properties");
			pro.load(in);

			getIntance().setDRIVERMANAGER(pro.getProperty(JdbcConstant.DRIVERMANAGER));
			getIntance().setURL(pro.getProperty(JdbcConstant.URL));
			getIntance().setUSERNAME(pro.getProperty(JdbcConstant.USERNAME));
			getIntance().setPASSWORD(pro.getProperty(JdbcConstant.PASSWORD));


		} catch (IOException e) {
			throw new RuntimeException("配置文件异常");
		}

	}

	public String getDRIVERMANAGER() {
		return DRIVERMANAGER;
	}






	public void setDRIVERMANAGER(String dRIVERMANAGER) {
		DRIVERMANAGER = dRIVERMANAGER;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
}