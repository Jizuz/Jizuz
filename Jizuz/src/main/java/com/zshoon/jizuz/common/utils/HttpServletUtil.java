package com.zshoon.jizuz.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <Description> <br> 
 *  
 * @author Jizuz<br>
 * @version 1.0<br>
 * @CreateDate 2017年8月29日<br>
 * @since V1.0<br>
 * @see com.zshoon.common.utils<br>
 */
public class HttpServletUtil {
	
	/**
	 * cookie default max age
	 */
	private final static int COOKIE_MAX_AGE = 60 * 60 * 24 * 30;
	
	/**
	 * Description: 内容添加到session<br> 
	 * @author qiu.pengfei<br>
	 * @param request
	 * @param key
	 * @param val <br>
	 */
	protected static void addSession(HttpServletRequest request, String key, Object val) {
		request.getSession().setAttribute(key, val);
	}
	
	/**
	 * Description: session中按键取值<br> 
	 * @author qiu.pengfei<br>
	 * @param request
	 * @param key
	 * @return <br>
	 */
	protected static Object getSession(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	
	/**
	 * Description: 设置cookie<br> 
	 * @author qiu.pengfei<br>
	 * @param request
	 * @param response
	 * @param name
	 * @param value <br>
	 */
    protected static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath(request.getContextPath() + "/");
        response.addCookie(cookie);
    }

    /**
     * Description: 设置cookie<br> 
     * @author qiu.pengfei<br>
     * @param request
     * @param response
     * @param name
     * @param value
     * @param maxAge <br>
     */
    protected void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, Integer maxAge) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        if (null != maxAge) {
            cookie.setMaxAge(maxAge);
        }
        cookie.setPath(request.getContextPath() + "/");
        response.addCookie(cookie);
    }
    
    /**
	 * Description: 添加一个新Cookie
	 * 
	 * @author qiu.pengfei
	 * @param response HttpServletResponse
	 * @param cookie Cookie
	 */
	public static void addCookie(HttpServletResponse response, Cookie cookie) {
		if (cookie != null)
			response.addCookie(cookie);
	}

	/**
	 * Description: 添加一个新Cookie
	 * 
	 * @author qiu.pengfei
	 * @param response HttpServletResponse
	 * @param cookieName String
	 * @param cookieValue String
	 * @param domain String
	 * @param httpOnly boolean
	 * @param maxAge int
	 * @param path String
	 * @param secure boolean
	 */
	public static void addCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, String domain,
			boolean httpOnly, int maxAge, String path, boolean secure) {
		if (StringUtil.isNotEmpty(cookieName)) {
			if (cookieValue == null)
				cookieValue = "";

			Cookie newCookie = new Cookie(cookieName, cookieValue);
			if (domain != null)
				newCookie.setDomain(domain);

			newCookie.setHttpOnly(httpOnly);

			if (maxAge > 0)
				newCookie.setMaxAge(maxAge);

			if (path == null)
				newCookie.setPath(request.getContextPath() + "/");
			else
				newCookie.setPath(path);

			newCookie.setSecure(secure);

			addCookie(response, newCookie);
		}
	}

	/**
	 * Description: 添加一个新Cookie
	 * 
	 * @author qiu.pengfei
	 * @param response HttpServletResponse
	 * @param cookieName String
	 * @param cookieValue String
	 * @param domain String
	 */
	public static void addCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, String domain) {
		addCookie(request, response, cookieName, cookieValue, domain, true, COOKIE_MAX_AGE, request.getContextPath() + "/", false);
	}
    
    /**
	 * Description: 根据Cookie名获取对应的Cookie
	 * 
	 * @author qiu.pengfei
	 * @param request HttpServletRequest
	 * @param cookieName String
	 * @return Cookie
	 */
	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookieName == null || cookieName.equals(""))
			return null;

		for (Cookie c : cookies) {
			if (c.getName().equals(cookieName))
				return (Cookie) c;
		}
		return null;
	}

	/**
	 * Description: 根据Cookie名获取对应的Cookie值
	 * 
	 * @author qiu.pengfei
	 * @param request HttpServletRequest
	 * @param cookieName String
	 * @return String
	 */
	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		Cookie cookie = getCookie(request, cookieName);
		if (cookie == null)
			return null;
		else
			return cookie.getValue();
	}

    /**
     * Description: 移除cookie<br> 
     * @author qiu.pengfei<br>
     * @param request
     * @param response
     * @param name <br>
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath() + "/");
        response.addCookie(cookie);
    }
	
    /**
	 * 根据cookie名修改指定的cookie
	 * 
	 * @author qiu.pengfei
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param cookieName String
	 * @param cookieValue String
	 * @param domain String
	 */
	public static void editCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
			String cookieValue,String domain) {
		Cookie c = getCookie(request, cookieName);
		if (c != null && cookieName != null && !cookieName.equals("") && c.getName().equals(cookieName)) {
			addCookie(request, response, cookieName, cookieValue, domain);
		}
	}
}
