package mst_auth_client;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import mst_auth_library.MSTAException;
import mst_auth_library.MST_Auth_BaseClientWrapper;
import mst_auth_library.MST_Auth_BaseServlet;
import mst_auth_library.MST_Auth_ClientWrapper;
import mst_auth_library.MST_Auth_Servlet;

public class MST_Auth_Client {
	private MST_Auth_BaseClientWrapper msta_library;
	public MST_Auth_Client() {
	}
	public void SetLibrary (MST_Auth_BaseClientWrapper MSTALibrary ) {
		msta_library = MSTALibrary;			
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws IOException, MSTAException  {
		// simulate a little work
		try {
		  TimeUnit.MILLISECONDS.sleep(500);	// add a little wait, to see if root will end
		}
		catch (JSONException | InterruptedException ie) {
			throw(new MSTAException (": InterruptedException" + ie));		
		}						  
		response.getWriter().append("AuthorizationService: PONG ");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws IOException, MSTAException  {
	    response.getWriter().append("doPost").append(request.getContextPath());
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws IOException, MSTAException  {
	    response.getWriter().append("doPut Served at: ").append(request.getContextPath());
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws IOException, MSTAException  {
	    response.getWriter().append("doDelete Served at: ").append(request.getContextPath());
	}
	public void callbackResponse(HttpResponse<String> parmmstresponse) {
		
	}
}
