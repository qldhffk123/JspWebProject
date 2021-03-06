package com.dailyT.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Script {
	
	public static void ajaxJson(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			

			PrintWriter out = response.getWriter();
			 
			out.println(msg);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ajaxText(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			 
			out.println(msg);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void back(String msg, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			 
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("history.back();");
			out.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void href(String msg, String uri ,HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			 
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println("location.href='"+uri+"';");
			out.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void href(String uri ,HttpServletResponse response) {
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			 
			out.println("<script>");
			out.println("location.href='"+uri+"';");
			out.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
