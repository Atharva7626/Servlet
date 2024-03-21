import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML form for login
        out.println("<html><body>");
        out.println("<h2>Login</h2>");
        out.println("<form action='purchase' method='post'>");
        out.println("Username: <input type='text' name='username'><br>");
        out.println("Password: <input type='password' name='password'><br>");
        out.println("<input type='submit' value='Login'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

public class PurchaseServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get username from login
        String username = request.getParameter("username");

        // HTML form for book purchase
        out.println("<html><body>");
        out.println("<h2>Welcome, " + username + "!</h2>");
        out.println("<h3>Select Books to Purchase:</h3>");
        out.println("<form action='checkout' method='post'>");
        out.println("Book 1: <input type='checkbox' name='book1'><br>");
        out.println("Book 2: <input type='checkbox' name='book2'><br>");
        out.println("Book 3: <input type='checkbox' name='book3'><br>");
        out.println("<input type='submit' value='Purchase'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

public class CheckoutServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get selected books from purchase
        String book1 = request.getParameter("book1");
        String book2 = request.getParameter("book2");
        String book3 = request.getParameter("book3");

        // Calculate total cost
        int total = 0;
        if (book1 != null) total += 10;
        if (book2 != null) total += 15;
        if (book3 != null) total += 20;

        // Display total bill
        out.println("<html><body>");
        out.println("<h2>Thank You for Your Purchase!</h2>");
        out.println("<h3>Your Total Bill:</h3>");
        out.println("Book 1: $10<br>");
        out.println("Book 2: $15<br>");
        out.println("Book 3: $20<br>");
        out.println("<h3>Total: $" + total + "</h3>");
        out.println("</body></html>");
    }
}
