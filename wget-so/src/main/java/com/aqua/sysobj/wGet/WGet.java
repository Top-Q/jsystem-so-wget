package com.aqua.sysobj.wGet;

import jsystem.framework.system.SystemObjectImpl;

import com.aqua.sysobj.conn.ConnectivityManager;
import com.aqua.sysobj.wGet.basic.WGetBasic;
/**
 * 
 * @author Keren Kinsbursky & Yehudit Nadav
 *     GNU Wget is a free utility for non-interactive download of files from
       the Web.  It supports HTTP, HTTPS, and FTP protocols, as well as
       retrieval through HTTP proxies.

       Wget is non-interactive, meaning that it can work in the background,
       while the user is not logged on.  This allows you to start a retrieval
       and disconnect from the system, letting Wget finish the work.  By con-
       trast, most of the Web browsers require constant user's presence, which
       can be a great hindrance when transferring a lot of data.

       Wget can follow links in HTML and XHTML pages and create local versions
       of remote web sites, fully recreating the directory structure of the
       original site.  This is sometimes referred to as ``recursive download-
       ing.''  While doing that, Wget respects the Robot Exclusion Standard
       (/robots.txt).  Wget can be instructed to convert the links in down-
       loaded HTML files to the local files for offline viewing.

       Wget has been designed for robustness over slow or unstable network
       connections; if a download fails due to a network problem, it will keep
       retrying until the whole file has been retrieved.  If the server sup-
       ports regetting, it will instruct the server to continue the download
       from where it left off.
 */

public class WGet extends SystemObjectImpl{
	
	public ConnectivityManager conn;
	public WGetBasic basic;
	
	public void init() throws Exception{
		super.init();
	}

}
