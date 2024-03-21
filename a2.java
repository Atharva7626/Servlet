import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ImplicitObjectsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set content type and get PrintWriter
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display current date and time using out implicit object
        out.println("<h1>Current Date and Time: " + new Date() + "</h1>");

        // Get header info using request implicit object
        out.println("<h2>User-Agent Header: " + request.getHeader("User-Agent") + "</h2>");

        // Add a cookie using response implicit object
        Cookie cookie = new Cookie("username", "john_doe");
        response.addCookie(cookie);
        out.println("<h2>Cookie added: " + cookie.getName() + " - " + cookie.getValue() + "</h2>");

        // Get parameter value defined in <init-param> using config implicit object
        String initParamValue = getServletConfig().getInitParameter("paramName");
        out.println("<h2>Init Parameter Value: " + initParamValue + "</h2>");

        // Get parameter value defined in <context-param> using application implicit object
        String contextParamValue = getServletContext().getInitParameter("contextParamName");
        out.println("<h2>Context Parameter Value: " + contextParamValue + "</h2>");

        // Display current session id using session implicit object
        out.println("<h2>Current Session ID: " + request.getSession().getId() + "</h2>");

        // Set and get attributes using pageContext implicit object
        pageContext.setAttribute("testAttribute", "testValue");
        out.println("<h2>Attribute set in pageContext: " + pageContext.getAttribute("testAttribute") + "</h2>");

        // Get the name of the generated servlet using page implicit object
        out.println("<h2>Generated Servlet Name: " + getClass().getName() + "</h2>");
    }
}
/*

<%@ page language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Implicit Objects Demo</title>
</head>
<body>
    <h1>Implicit Objects Demo</h1>
    <%-- out: Display current date and time --%>
    <p>Current Date and Time: <%= new Date() %></p>

    <%-- request: Get header info --%>
    <p>User-Agent Header: <%= request.getHeader("User-Agent") %></p>

    <%-- response: Add cookie --%>
    <% Cookie cookie = new Cookie("username", "john_doe"); %>
    <% response.addCookie(cookie); %>
    <p>Cookie added: <%= cookie.getName() %> - <%= cookie.getValue() %></p>

    <%-- config: Get parameter value defined in <init-param> --%>
    <p>Init Parameter Value: <%= config.getInitParameter("paramName") %></p>

    <%-- application: Get parameter value defined in <context-param> --%>
    <p>Context Parameter Value: <%= application.getInitParameter("contextParamName") %></p>

    <%-- session: Display current session id --%>
    <p>Current Session ID: <%= session.getId() %></p>

    <%-- pageContext: Set and get attributes --%>
    <% pageContext.setAttribute("testAttribute", "testValue"); %>
    <p>Attribute set in pageContext: <%= pageContext.getAttribute("testAttribute") %></p>

    <%-- page: Get the name of the generated servlet --%>
    <p>Generated Servlet Name: <%= page.getClass().getName() %></p>
</body>
</html>
*/
