
/*<!DOCTYPE html>
<html>
<head>
    <title>Customer Search</title>
</head>
<body>
    <h2>Customer Search</h2>
    <form action="CustomerSearchServlet" method="get">
        <label for="customerNumber">Customer Number:</label>
        <input type="text" id="customerNumber" name="customerNumber" required>
        <button type="submit">Search</button>
    </form>
</body>
</html>
*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CustomerSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get customer number parameter from the request
        String customerNumber = request.getParameter("customerNumber");

        // TODO: Perform database search using customer number and retrieve customer details
        // For simplicity, let's assume you have a CustomerDAO class to interact with the database
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.getCustomerByNumber(customerNumber);

        // Set response content type
        response.setContentType("text/html");

        // Output customer details in the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (customer != null) {
            out.println("<h2>Customer Details</h2>");
            out.println("<p>Customer Number: " + customer.getCustomerNumber() + "</p>");
            out.println("<p>Name: " + customer.getName() + "</p>");
            out.println("<p>Email: " + customer.getEmail() + "</p>");
            // Add more details as needed
        } else {
            out.println("<h2>Customer not found</h2>");
        }
        out.println("</body></html>");
    }
}
