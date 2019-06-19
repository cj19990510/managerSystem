package org.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class alter {
	public void put(HttpServletResponse response,String str) throws IOException {
		response.setContentType("text/html; charset=UTF-8"); // зЊТы
		PrintWriter out = response.getWriter();
		out.flush();
		out.println("<script>");
		out.println("alert('"+str+"');");
		out.println("history.back();");
		out.println("</script>");
	}
}
