
package com.millcreeksoftware.imglister;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @author Mike Bryant
 */
public class DisplayThumbnailServlet extends HttpServlet {
    
	/**
	 * Thumbnail width, in pixels.
	 */
	private final int THUMBNAIL_WIDTH = 125;
	
	/**
	 * Thumbnail height, in pixels.
	 */
    private final int THUMBNAIL_HEIGHT = 125;
    
    
	/**
	 * Serial
	 */
	private static final long serialVersionUID = -7848096577575528118L;

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

	/**
	 * Displays thumbnail of the requested file.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fileName = request.getParameter("fileName");
		OutputStream outputStream = response.getOutputStream();
		Thumbnails.of(fileName)
	        .size(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT)
	        .outputFormat("jpg")
	        .toOutputStream(outputStream);
	}

}
