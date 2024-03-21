import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import your.package.Patient;
import java.sql.*;

@WebServlet("/PatientServlet")
public class PatientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Patient> patients = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Connect to your database
            Class.forName("your.database.Driver");
            conn = DriverManager.getConnection("jdbc:your_database_connection_url", "username", "password");

            // Execute SQL query to retrieve patient information
            stmt = conn.createStatement();
            String sql = "SELECT * FROM patients";
            rs = stmt.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                int pno = rs.getInt("pno");
                String pname = rs.getString("pname");
                String paddress = rs.getString("paddress");
                int page = rs.getInt("page");
                String pdisease = rs.getString("pdisease");
                
                patients.add(new Patient(pno, pname, paddress, page, pdisease));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }

        // Set patients as an attribute and forward the request to the JSP page
        request.setAttribute("patients", patients);
        request.getRequestDispatcher("patient.jsp").forward(request, response);
    }
}
/*
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Information</title>
</head>
<body>

<h2>Patient Information</h2>

<table border="1">
    <thead>
        <tr>
            <th>Patient Number</th>
            <th>Name</th>
            <th>Address</th>
            <th>Age</th>
            <th>Disease</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td>${patient.pno}</td>
                <td>${patient.pname}</td>
                <td>${patient.paddress}</td>
                <td>${patient.page}</td>
                <td>${patient.pdisease}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
*/
