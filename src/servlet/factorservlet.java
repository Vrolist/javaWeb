package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tableClass.factor;
import tableClass.sell;

/**
 * Servlet implementation class factorservlet
 */
@WebServlet("/factorservlet")
public class factorservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public factorservlet() {
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
		String status = request.getParameter("method");
		if("delete".equals(status))
		 { this.delete(request,response);
		 }
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goods = request.getParameter("idgoods");
		int idgoods = Integer.parseInt(goods);
		if(factor.deleteFactor(idgoods)){
			//session.setAttribute("message", "添加成功");
		}
		else{
			//session.setAttribute("message", "添加失败");
		}
		response.sendRedirect("buyer.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		String fac = request.getParameter("idfactor");
		String goods = request.getParameter("idgoods");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String principal = request.getParameter("principal");
		if (fac != null && goods != null) {

			int idfactor = Integer.parseInt(fac);
			int idgoods = Integer.parseInt(goods);
			if (factor.insertFactor(idfactor, idgoods, name, address, principal)) {
				session.setAttribute("message", "添加成功");
			} else {
				session.setAttribute("message", "添加失败");
			}

		} else {
			session.setAttribute("message", "输入只能为编号");
		}

		response.sendRedirect("buyer.jsp");
	}

}
