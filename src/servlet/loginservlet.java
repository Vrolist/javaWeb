package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import basicClass.buyer;
import basicClass.cashier;
import basicClass.manager;
import basicClass.storagemanager;


/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String func = request.getParameter("select");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		if(session.getAttribute("id")!=null){
			response.sendRedirect("index.jsp");
		}
		
		else if (func.equals("cashier")) {
			try {
				if(cashier.login(cashier.getDb(), name, pwd)){

					session.setAttribute("user", cashier.newcashier(name, pwd));
					session.setAttribute("job", "cashier".toString());
					response.sendRedirect("cashier.jsp");
				}
				else {
					response.sendRedirect("error.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(func.equals("manager")){
			try {
				if(manager.login(manager.getDb(), name, pwd)){
					session.setAttribute("user", manager.newmanager(name, pwd));
					session.setAttribute("job", "manager".toString());
					response.sendRedirect("manager.jsp");
				}
				else{
					response.sendRedirect("error.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (func.equals("buyer")) {
			try {
				if(buyer.login(buyer.getDb(),name, pwd)){
					session.setAttribute("user", buyer.newbuyer(name, pwd));
					session.setAttribute("job", "buyer".toString());
					response.sendRedirect("buyer.jsp");
				}
				else{
					response.sendRedirect("error.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (func.equals("storagemanager")) {
			try {
				if(buyer.login(storagemanager.getDb(), name, pwd)){
					session.setAttribute("user", storagemanager.newstoragemanager(name, pwd));
					session.setAttribute("job", "storagemanager".toString());
					response.sendRedirect("storagemanager.jsp");
				}
				else{
					response.sendRedirect("error.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
