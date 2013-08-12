

package com.millcreeksoftware.imglister;

/**
 * Immutable login class.
 * 
 * @author Mike Bryant
 */
public class LoginData {
	/**
	 * The user name.
	 */
	private String userName = "";
	
	/**
	 * The base directory for the user's images.
	 */
	private String baseDir = "";
	
	
	
	/**
	 * Constructor.
	 * 
	 * @param userName
	 * @param baseDir
	 */
	public LoginData(String userName, String baseDir) {
		super();
		this.userName = userName;
		this.baseDir = baseDir;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * @return the baseDir
	 */
	public String getBaseDir() {
		return this.baseDir;
	}
	
}
