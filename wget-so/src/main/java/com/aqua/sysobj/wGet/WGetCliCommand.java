/*
 * Copyright 2005-2010 Ignis Software Tools Ltd. All rights reserved.
 */
package com.aqua.sysobj.wGet;

import com.aqua.sysobj.conn.CliCommand;

public class WGetCliCommand extends CliCommand{
	public WGetCliCommand(String command) {
		super();
		setCommands(new String[] { command });
		addErrors("command not found");
		addErrors("failed: Name or service not known");
		addErrors("failed: Invalid argument");
		addErrors("failed: No route to host");
		addErrors("failed: ");	
		addErrors("ERROR");
		addErrors("Not Found");
	}
}
