package info2soft.qa.util;

import java.awt.*;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/6/4 9:15
 */
public class ScreenCapture {
	private static String fImgDir = "";

	public ScreenCapture() {
	}

	public static void printScreen(String fileName){
		Rectangle size = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		printScreen(fileName,size);

	}

	public static void printScreen(String fileName,Rectangle screenSize){

	}
}
