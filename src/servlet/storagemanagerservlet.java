package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tableClass.storage;

/**
 * Servlet implementation class storagemanagerservlet
 */
@WebServlet("/storagemanagerservlet")
public class storagemanagerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public storagemanagerservlet() {
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
		String quan = request.getParameter("quantity");
		String sel = request.getParameter("sell");
		if (goods != null) {
			int idgoods = Integer.parseInt(goods);
			int quantity = Integer.parseInt(quan);
			float sell = Float.parseFloat(sel);
			if (storage.haveGoods(idgoods)) {
				storage.increaseQuantity(idgoods, quantity);
				session.setAttribute("message", "成功入库");
			} else {
				storage.insertNewCargo(idgoods, quantity, sell);
				session.setAttribute("message", "成功入库，新增一条记录");
			}
		}
		response.sendRedirect("storagemanager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
