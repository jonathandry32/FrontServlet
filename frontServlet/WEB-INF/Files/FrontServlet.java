import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FrontServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String url=request.getRequestURL().toString();
            String[] url_=url.split("/");
            url="";
            for (int i=4;i<url_.length;i++) {
                url+=url_[i];
            }
            String requete=request.getQueryString();
            if (requete!=null) {
                url=url+"?"+requete;
            }
            request.setAttribute("url",url);
            RequestDispatcher dispat=request.getRequestDispatcher("control.jsp");
            dispat.forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}