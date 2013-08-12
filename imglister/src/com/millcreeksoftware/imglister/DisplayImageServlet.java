

package com.millcreeksoftware.imglister;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @author Mike Bryant
 */
public class DisplayImageServlet extends HttpServlet {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 6296483943695780848L;


	/**
	 * Returns the image file.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileName = request.getParameter("fileName");
		response.setContentLength( (int) new File(fileName).length() );
		
	    InputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
	    OutputStream outputStream = response.getOutputStream();
	    try {
	        writeFileToOutput(inputStream, outputStream);
	    } finally {
	        finalizeImg(inputStream, outputStream);
	    }
	}

	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	private void writeFileToOutput(InputStream inputStream, OutputStream outputStream) throws IOException {
	    byte[] b = new byte[32 * 1024];
	    int count;
	    while ((count = inputStream.read(b)) != -1) {
	        outputStream.write(b, 0, count);
	    }
	}
	
	
	private void finalizeImg(InputStream inputStream, OutputStream outputStream) throws IOException {
	    try {
	        outputStream.flush();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    inputStream.close();
	}
	
}
