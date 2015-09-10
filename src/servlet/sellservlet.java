package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tableClass.sell;

/**
 * Servlet implementation class sellservlet
 */
@WebServlet("/sellservlet")
public class sellservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sellservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String goods = request.getParameter("idgoods");
		session.setAttribute("idgoods", goods);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String goods = request.getParameter("idgoods");
		String quan = request.getParameter("quantity");
		String cashier = request.getParameter("idcashier");
		if (goods != null && quan != null && cashier != null) {

			int idgoods = Integer.parseInt(goods);
			int quantity = Integer.parseInt(quan);
			int idcashier = Integer.parseInt(cashier);
			if (quantity > 0) {
				sell.increaseSell(idgoods, idcashier, quantity);
			} else {
				session.setAttribute("message", "销售数值必须大于0");
			}
		}else{
			session.setAttribute("message", "输入只能为编号");
		}

		response.sendRedirect("cashier.jsp");
		
		//doGet(request, response);
	}

}
