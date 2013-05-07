package com.aqua.sysobj.wGet.basic;

import junit.framework.SystemTestCase;
import com.aqua.sysobj.wGet.WGetManager;

public class WGetBasicTest extends SystemTestCase {
	WGetManager wgetManager;
	
	public void setUp() throws Exception{
		wgetManager = (WGetManager) system.getSystemObject("wgetManager");
	}
	
	public void testSendCapFileBasic() throws Exception {
		wgetManager.wGets[0].basic.get("ftp://127.0.0.1/bla10.bin");
	}
	
	public void testSendCapFileBasicNoBlock() throws Exception {
		wgetManager.wGets[0].basic.getNonBlock("ftp://127.0.0.1/bla10.bin");
		sleep(5000);
	}
}
