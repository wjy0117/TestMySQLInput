import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class inputDAO {
	//DB
	public Connection dbConn() {
		Connection conn = null;
		try {
			//String url = "jdbc:mysql://localhost:3306/root";
			String url = "jdbc:mysql://localhost/user_db?characterEncoding=UTF-8&serverTimezone=UTC";
			String id = "root";
			String pw = "1234";
			
			//String driver = "com.mysql.jdbc.Driver";
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("db 접속 성공");
		}catch(Exception e) {
			System.out.println("db 접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	//입력할 값 리스트
	public ArrayList<inputDTO> userlist() {
		ArrayList<inputDTO> list = new ArrayList<inputDTO>();
		Connection conn = null; // DB접속 객체
		PreparedStatement pstmt = null; // SQL실행객체
		ResultSet rs = null; // 결과셋 처리 객체
		try {
		    conn = dbConn(); // db연결 키
		    String sql = "select * from user_table";
		    pstmt = conn.prepareStatement(sql); // sql을 실행시키는 객체 만들어짐
		    rs = pstmt.executeQuery(); // 실행 후 결과 값이 rs에 넘어옴
		    
		    while (rs.next()) { // 결과셋.next(); 다음 레코드가 있으면 true
		    	inputDTO dto = new inputDTO();
		        dto.setId(rs.getString("user_id"));
		        dto.setPw(rs.getString("user_pw"));
		        //dto.setBirth(rs.getInt("user_birth"));
		        dto.setBirth(rs.getString("user_birth"));
		        dto.setGender(rs.getString("user_gender"));
	
		        // ArrayList에 추가
		        list.add(dto);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally { // 오픈한 역순으로 닫기작업 실행
		    // resultset= > statement=> connection
		    try {
		        if (rs != null) {
		            rs.close();
		        }
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }
		    try {
		        if (pstmt != null) {
		            pstmt.close();
		        }
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }
		    try {
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }
		}
		return list;
	}
	//삽입
	
	public void userInsert(inputDTO dto) {
		Connection conn = null; // DB접속 객체
		PreparedStatement pstmt = null; // SQL실행객체
		try{
		    conn=dbConn();
		    String sql="insert into user_table(user_id, user_pw, user_birth, user_gender)"+" values(?,?,?,?)";
		    
		    //sql 실행객체 생성
		    pstmt=conn.prepareStatement(sql);
		    
		    //? 에 입력될 값 매핑
		    pstmt.setString(1, dto.getId());
		    pstmt.setString(2, dto.getPw());
		    //pstmt.setInt(3, dto.getBirth());
		    pstmt.setString(3, dto.getBirth());
		    pstmt.setString(4, dto.getGender());
		    
		    //executeQuery() select 명령어
		    //executeUpdate select 이외 명령어
		    pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		    //리소스 정리작업
		    try {
		        if (pstmt != null) {
		            pstmt.close();
		        }
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }
		    try {
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }   
		}
	}
}