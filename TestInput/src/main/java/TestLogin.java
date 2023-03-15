import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestLogin
 */
@WebServlet("/tl")
public class TestLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public TestLogin() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("서블릿 호출");
		// 한글처리
        request.setCharacterEncoding("UTF-8");
 
        // 컨텍스트 페스 경로가져오기
        String context = request.getContextPath();
        // DAO생성
        inputDAO dao = new inputDAO();
        // 폼에서 입력 받은 데이터를 DTO에 저장
 
        String id = request.getParameter("user_id");
        String pw = request.getParameter("user_pw");
        //int birth = Integer.parseInt(request.getParameter("user_birth"));
        String birth = request.getParameter("user_birth");
        String gen = request.getParameter("user_gender");
        
        System.out.println(id+" "+pw+" "+birth+" "+gen);
        inputDTO dto = new inputDTO(id, pw, birth, gen);
 
        // 테이블에 저장
        dao.userInsert(dto);
 
        // 페이지 이동
        response.sendRedirect(context + "/login_form.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*request.setCharacterEncoding("utf-8");     //전송된 데이터를 UTF-8로 인코딩
        String user_id=request.getParameter("user_id"); 
        String user_pw=request.getParameter("user_pw"); //getParameter 메서드로 input태그의 name속성 값으로 전송된 값을 받아옴
        System.out.println("아이디:"+user_id);
        System.out.println("비밀번호:"+user_pw);*/
	}

}
