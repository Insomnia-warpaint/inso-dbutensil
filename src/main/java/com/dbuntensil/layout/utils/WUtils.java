package com.dbuntensil.layout.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class WUtils {
	
	private static Toolkit kit;
	
	static {
		 kit = Toolkit.getDefaultToolkit();
	}

	public static int  xCenter(int currentX) {
		Dimension screenSize = kit.getScreenSize();
		System.out.println("currentX : " + currentX);
		System.out.println("screenSize.width : " + screenSize.width);
		return screenSize.width / 2  - currentX / 2;
	}
	
	public static int  yCenter(int currentY) {
		Dimension screenSize = kit.getScreenSize();
		System.out.println("currentY : " + currentY);
		System.out.println("screenSize.height : " + screenSize.height);
		return screenSize.height / 2 - currentY / 2;
	}
	
	
}
