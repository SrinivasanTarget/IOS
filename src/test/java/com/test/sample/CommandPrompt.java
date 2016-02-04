package com.test.sample;

/**
 * Command Prompt - this class contains method to run windows and mac commands  
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandPrompt {

	Process p;
	ProcessBuilder builder;

	/**
	 * This method run command on windows and mac
	 * 
	 * @param strings
	 *            to run
	 */
	public String runCommand(String command) throws InterruptedException, IOException {
		p = Runtime.getRuntime().exec(command);

		// get std output
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		String allLine = "";
		int i = 1;
		while ((line = r.readLine()) != null) {
			System.out.println(i+". "+line);
			allLine = allLine + "" + line + "\n";
			if (line.contains("Console LogLevel: debug"))
				break;
			i++;
		}
		return allLine;
	}

	public static void main(String[] args) throws Exception {
		CommandPrompt cmd = new CommandPrompt();
		String appium="/usr/bin/local/appium";
		String output = cmd.runCommand(appium);
		System.out.println(output);
	}
}