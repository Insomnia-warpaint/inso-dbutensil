package com.dbuntensil.layout;

import java.awt.Frame;
import java.awt.HeadlessException;

import com.dbuntensil.layout.utils.WUtils;

public class WLayout extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2231945347810891143L;

    private int width;
    private int height;
    
    
	public WLayout() throws HeadlessException {
		this.width = 800;
		this.height = 600;
	}


	public WLayout(int width, int height) throws HeadlessException {
		this.width = width;
		this.height = height;
	}


	public void createFrame() {
		wdoInit();
		
	}
	
	
	private void wdoInit() {
		this.setLocation(WUtils.xCenter(getWdoWidth()), WUtils.yCenter(getWdoHeight()));
		setSize(getWdoWidth(), getWdoHeight());
		setVisible(true);
	}


	protected void setWdoWidth(int x) {
		this.width = x;
	}
	
	
	protected void setWdoHeight(int y) {
		this.height = y;
	}
	
	
	private int getWdoWidth() {
		
		return width;
	}

	private int getWdoHeight() {
		
		return height;
	}

	
	
	
	

}
