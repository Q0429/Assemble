package com.q0429.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	boolean execute(HttpServletRequest request, HttpServletResponse response);
	
}
