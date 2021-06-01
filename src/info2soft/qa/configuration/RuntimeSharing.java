package info2soft.qa.configuration;

import java.util.Properties;
import java.util.Set;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/6/1 10:17
 */
public class RuntimeSharing {
	public RuntimeSharing() {
	}

	public static Properties systemProperties(){
		return System.getProperties();
	}


	public static void main(String[] args) {
		Properties prop = systemProperties();
		System.out.println(prop);
		Set<String> keySet = prop.stringPropertyNames();
		System.out.println("=====================");
		System.out.println(keySet);
		System.out.println("=====================");
		String separatorStr = prop.getProperty("file.separator");
		System.out.println(separatorStr);
	}
}
