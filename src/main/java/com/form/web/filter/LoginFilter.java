package com.form.web.filter;

import com.form.SystemConstants;
import com.form.model.User;
import org.apache.commons.lang.xwork.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * URL Filter
 */
public class LoginFilter implements Filter {
    //All rights does not require the request url to determine fragment
    private List<String> ingoreUrls = new ArrayList<String>();

    public void init(FilterConfig filterConfig) throws ServletException {
        String ignoreStr = filterConfig.getInitParameter("ignoreUrl");
        if (StringUtils.isNotEmpty(ignoreStr)) {
            String igs[] = ignoreStr.split(",");
            for (String ig : igs) {
                ingoreUrls.add(ig.trim());
            }
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        StringBuffer buffer = httpRequest.getRequestURL();//get requet url
        String queryString = httpRequest.getQueryString();//get request paramter
        String wonderUrl = URLEncoder.encode(httpRequest.getRequestURI() + "?" + httpRequest.getQueryString(), "UTF-8");
        if (StringUtils.isNotEmpty(queryString)) {
            buffer.append("?");
            buffer.append(queryString);
        }
        String fullUrl = buffer.toString();//client user Browser request full URL
        //Need to check whether the user is logged in, there is no need to check requests, such as requests for pictures, request CSS, JS or JVM internal requests initiated the request for the page
        boolean checkPermission = true;
        for (String ingoreUrl : ingoreUrls) {
            if (fullUrl.indexOf(ingoreUrl) != -1) {//Client requests the URL string, including the need to check whether the login string fragments do not need to check permissions
                checkPermission = false;
                break;
            }
        }
        if (!checkPermission) {//Do not need to check login, direct release
            filterChain.doFilter(servletRequest, servletResponse);
        } else {    //Need to check the authority to determine whether the user has logged
            User loginUser = (User) httpRequest.getSession().getAttribute(SystemConstants.SESSION_USER);
            if (loginUser == null) {
                //If it is blocked, then the first record of the request to the address of the last to jump over the next login.
                httpRequest.getSession().setAttribute(SystemConstants.SESSION_URL, fullUrl);
                //session expired
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp?wonderUrl=" + wonderUrl);
                return;
            } else {
                filterChain.doFilter(httpRequest, httpResponse);
            }
        }
    }

    public void destroy() {
    }
}
