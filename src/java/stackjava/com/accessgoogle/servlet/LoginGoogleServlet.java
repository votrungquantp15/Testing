package stackjava.com.accessgoogle.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import stackjava.com.accessgoogle.common.GooglePojo;
import stackjava.com.accessgoogle.common.GoogleUtils;
@WebServlet("/login-google")
public class LoginGoogleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String ERROR="login.jsp";
  private static final String SUCCESS="user.jsp";
  public LoginGoogleServlet() {
    super();
  }
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String url = ERROR;
      try {
          String code = request.getParameter("code");
    if (code == null || code.isEmpty()) {
//      RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//      dis.forward(request, response);
        url = ERROR;
    } else {
//      String accessToken = GoogleUtils.getToken(code);
//      GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
//      request.setAttribute("id", googlePojo.getId());
//      request.setAttribute("name", googlePojo.getName());
//      request.setAttribute("email", googlePojo.getEmail()); 
        
        
      url = SUCCESS;
    }
      } catch (Exception e) {
          log("Error at Login GG servlet: " +e.toString());
      }finally{
          request.getRequestDispatcher(url).forward(request, response);
      }
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
