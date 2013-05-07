/*
 * Copyright 2005-2010 Ignis Software Tools Ltd. All rights reserved.
 */
package com.aqua.sysobj.wGet;

import systemobject.terminal.Prompt;
import com.aqua.sysobj.conn.CliConnectionImpl;
import com.aqua.sysobj.conn.Position;

public class WGetCliConnection extends CliConnectionImpl{
	public void init() throws Exception{
    	super.init();
    }
			
	public void connect() throws Exception{
    	super.connect();
    	//We will always work on temp directory
//		TestPcCliCommand cliCommand = new TestPcCliCommand("cd /tmp/");
//		command(cliCommand);		
    }
	
	public Prompt[] getPrompts(){
		
		Prompt[] prompts = new Prompt[3];
		
		prompts[0] = new Prompt();
		prompts[0].setCommandEnd(true);
		prompts[0].setPrompt("# ");
		
		prompts[1] = new Prompt();
		prompts[1].setPrompt("login as: ");
		prompts[1].setStringToSend(user);
		
		prompts[2] = new Prompt();
		prompts[2].setPrompt("password: ");
		prompts[2].setStringToSend(password);
					
		return prompts;
	}


	public Position[] getPositions() {
		// TODO Auto-generated method stub
		return null;
	}
}
