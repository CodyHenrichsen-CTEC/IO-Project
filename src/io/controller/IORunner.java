package io.controller;

/**
 * The Runner class for the IO project
 * @author Cody Henrichsen
 * @version 1.0 13/12/2013 Basic Runner structure.
 */
public class IORunner
{
	public static void main(String [] args)
	{
		IOController ioAppController = new IOController();
		ioAppController.start();
	}
}
