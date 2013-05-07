/*
 * Copyright 2005-2010 Ignis Software Tools Ltd. All rights reserved.
 */
package com.aqua.sysobj.wGet.basic;

import jsystem.extensions.analyzers.text.FindText;

import com.aqua.sysobj.conn.CliApplication;
import com.aqua.sysobj.wGet.WGetCliCommand;

public class WGetBasic extends CliApplication {

	private boolean ignoreError = false;
	private boolean deleteAfter = false;

	public void get(String url) throws Exception {
		String wGetCommand;
		wGetCommand = "wget " + url + " --delete-after";
		WGetCliCommand cmd = new WGetCliCommand(wGetCommand);
		if (isIgnoreError()) {
			cmd.setIgnoreErrors(true);
			cmd.setTimeout(25000);
		}
		handleCliCommand("Uploading: " + url, cmd);

		// StationsManager sm = (StationsManager)system.getSystemObject("sm");
		// sm.stations[0].getCliSession().cliCommand(command, timeout)

		// Verify that the traffic sended correctly
		if (!isIgnoreError())
			analyze(new FindText("saved"));
	}

	public void saveGet(String url) throws Exception {
		String wGetCommand;
		wGetCommand = "wget " + url;
		WGetCliCommand cmd = new WGetCliCommand(wGetCommand);
		if (isIgnoreError()) {
			cmd.setIgnoreErrors(true);
			cmd.setTimeout(25000);
		}
		handleCliCommand("Uploading: " + url, cmd);

		if (!isIgnoreError())
			analyze(new FindText("saved"));
	}

	Thread worker = null;

	Exception exp = null;

	public void getNonBlock(final String url) throws Exception {
		exp = null;
		worker = new Thread() {
			public void run(){
				try {
					get(url);
				} catch (Exception e) {
					exp = e;
				}
			}
		};
		report.step("Strating sending cap file...");
		worker.start();
	}

	public void stop() throws Exception {
		WGetCliCommand cliCommand = new WGetCliCommand("\u0003");
		handleCliCommand("Ctrl+c", cliCommand);
	}

	public void killProcess() throws Exception {
		String cmdStr = "killall -9 wget";
		WGetCliCommand cmd = new WGetCliCommand(cmdStr);	
		handleCliCommand(cmdStr, cmd);
	}

	public boolean isIgnoreError() {
		return ignoreError;
	}

	public void setIgnoreError(boolean ignoreError) {
		this.ignoreError = ignoreError;
	}
	
	public boolean isDeleteAfter() {
		return deleteAfter;
	}

	public void setDeleteAfter(boolean deleteAfter) {
		this.deleteAfter = deleteAfter;
	}

}