import java.io.*;
import java.net.http.HttpRequest;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletContext;



public class info extends HttpServlet
{
    public void service(HttpServletRequest rq,HttpServletResponse rs)throws ServletException,IOException
    {
        rs.setContentType("text/html");
        PrintWriter out=rs.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1> The servlet information ...</h1>");



        String ip=rq.getRemoteAddr();
        out.println("<h3> Ip Address  :"+ip+" </h3>");

        String p=rq.getProtocol();
        out.println("<h3> Protocol used  :"+p+" </h3>");

        String n=rq.getRemoteHost();
        out.println("<h3> Name of the host  :"+n+" </h3>");

        String se=rq.getServerName();
        out.println("<h3> Name of server used   :"+se+" </h3>");

        /*

        out.println("<h1>Currently Loaded Servlets:</h1>");

        // Get the ServletContext object
        ServletContext servletContext = getServletContext();

        // Get the Map of servlet registrations
        Map<String, ? extends ServletRegistration> servletRegistrations = servletContext.getServletRegistrations();

        // Iterate over the servlet registrations and print their names
        for (String servletName : servletRegistrations.keySet()) {
            out.println("<p>" + servletName + "</p>");
        }

        */
       String osName = System.getProperty("os.name");
       String osVersion = System.getProperty("os.version");
       String javaVersion = System.getProperty("java.version");
       //String serverInfo = getServletContext().getServerInfo();





        


        out.println("</body>");
        out.println("</html>");
    }
}



/*
  web.xml

  <web-app>
       <servlet>
                <servlet-name> info </servlet-name> 
                <servlet-class> info </servlet-class>  
       </servlet>
       <servlet-mapping>
                <servlet-name> info </servlet-name> 
                <url-pattern> /info/ * </url-pattern>  
       </servlet-mapping>
  </web-app>
 */

 /*

    a1.html


    <a href="info"> Click to view server Information </a>
  


  */