package info2soft.qa;

import javax.swing.text.ParagraphView;
import java.util.Map;
import java.util.Properties;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/8/5 15:44
 */
public abstract class Adaptor {
	protected Properties prop = null;

	public Adaptor() {
	}

	public void init(Properties prop){
		this.prop = prop;
	}

	public abstract void start() throws Exception;
	public abstract void stop() throws Exception;
	public abstract Object openURL(String var1);
	public abstract Object openURL(String var1, Map var2);
	public abstract Object openURL(String var1,Map var2,boolean var3,boolean var4);
	public abstract void closeBrowser();
	public abstract Object getSelenium();
	public static Adaptor getInstance() throws Exception {
		String selenium_version = System.getProperty("selenium_version");
		return "3".equals(selenium_version)?(Adaptor)Class.forName("info2soft.qa.v3.V3Adaptor").newInstance():(Adaptor)Class.forName("info2soft.qa.v2.V2Adaptor").newInstance();
	}
}
