package web;

import java.util.ResourceBundle;

public class PageManager {
	private static final String BUNDLE_NAME = "myConfig";
	private static PageManager instance;
	private ResourceBundle resourceBundle;
	
	public static final String ADMIN_PAGE = "ADMIN_PAGE";
	public static final String INDEX_PAGE = "INDEX_PAGE";
	public static final String LOGIN_PAGE = "LOGIN_PAGE";
	public static final String ERROR_PAGE = "ERROR_PAGE";
	public static final String CATALOG_PAGE = "CATALOG_PAGE";
	public static final String CUSTOMER_PAGE = "CUSTOMER_PAGE";
	public static final String MANAGER_PAGE = "MANAGER_PAGE";
	public static final String CART_PAGE = "CART_PAGE";
	public static final String MAIN_PAGE = "MAIN_PAGE";
	public static final String LIST_PAGE = "LIST_PAGE";
	public static final String REGISTRATION_PAGE = "REGISTRATION_PAGE";
	public static final String INFO_PAGE = "INFO_PAGE";
	public static final String HELP_PAGE = "HELP_PAGE";
	public static final String CONTACT_PAGE = "CONTACT_PAGE";
	public static final String EDIT_PAGE = "EDIT_PAGE";
	public static final String USERS_PAGE = "USERS_PAGE";
	
	public static PageManager getInstance(){
		if (instance == null){
			instance = new PageManager();
			try{
			instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
			}catch (Exception e){
				System.out.println("NO " + e);
			}
		}
		return instance;
	}
	
	public String getProperty(String key){
		return (String) resourceBundle.getObject(key);
	}

}
