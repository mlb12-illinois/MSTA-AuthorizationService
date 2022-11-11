package mst_auth_client;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import mst_auth_library.MSTAException;
import mst_auth_library.MST_Auth_BaseClientWrapper;
import mst_auth_library.MST_Auth_BaseServlet;
import mst_auth_library.MST_Auth_ClientWrapper;
import mst_auth_library.MST_Auth_Servlet;
import mst_auth_library.MST_Auth_Microservice;

public class MSTA_Auth  extends MST_Auth_Microservice{
	public MSTA_Auth() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws IOException, MSTAException  {
		String input;
		if (trustedbody == null)	// as of now, will not be null
			input = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		else input = trustedbody;
		try {
		  TimeUnit.MILLISECONDS.sleep(500);	// add a little wait, to see if root will end
		}
		catch (JSONException | InterruptedException ie) {
			throw(new MSTAException (": InterruptedException" + ie));		
		}						  
		response.getWriter().append(input);
	}
}
