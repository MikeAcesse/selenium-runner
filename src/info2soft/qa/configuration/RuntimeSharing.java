package info2soft.qa.configuration;

import sun.net.www.http.HttpCaptureOutputStream;

import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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

	public static final Map sharedData(){
		Properties globalProperties = systemProperties();
		String SHARED_DATA_REPOSITORY_NAME = "Automation_Session_Shared_Data";
		Object objSharedDataRepository = globalProperties.get(SHARED_DATA_REPOSITORY_NAME);
		if(objSharedDataRepository == null){
			objSharedDataRepository = new ConcurrentHashMap<>();
			globalProperties.put(SHARED_DATA_REPOSITORY_NAME,objSharedDataRepository);
		}
		return (Map) objSharedDataRepository;
	}

	public static final void dumpSharedData(){
		System.out.println(sharedData());
	}

	public static Object getShareData(String key){
		Object value = sharedData().get(key);
		return value;
	}

	public static void removeSharedData(String key){
		try {
			sharedData().remove(key);
		} catch (Exception e) {
		}
	}

	public static String getSharedString(String key){
		return (String)getShareData(key);
	}

	private static String defaultString(String str){
		return str !=null ? str : "";
	}

	public static boolean getSharedBoolean(String key){
		String strValue = defaultString(String.valueOf(getShareData(key))).trim().toLowerCase();
		return "true".endsWith(strValue);
	}
	
	public static void putSharedString(String key,String value){
		setSharedData(key,value);
	}

	private static void setSharedData(String key, Object obj) {
		sharedData().put(key,obj);
	}

	public static void setSharedDataForCurrentThread(String user_key,Object obj){
		String key = threadSafeSharedDataKey(user_key);
		setSharedData(key,obj);
	}

	public static Object getSharedDataForCurrentThread(String user_key){
		String key = threadSafeSharedDataKey(user_key);
		return getShareData(key);
	}



	private static long currentThreadId(){
		long threadId = Thread.currentThread().getId();
		return threadId;
	}

	public static String threadSafeSharedDataKey(String user_key){
		String key = "Thread_"+currentThreadId()+"_"+user_key;
		return key;
	}

	public static void main(String[] args) {
	   boolean result = "true".endsWith("true");
		System.out.println(result);
		System.out.println(currentThreadId());

	}
}
