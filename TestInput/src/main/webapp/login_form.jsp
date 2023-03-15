<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<!-- 입력 데이터를 서블릿 매핑 이름 Login인 서블릿으로 전송 -->
	<form name="frmInput" method="get" action="tl">
		<!-- 텍스트 박스에 입력된 id를 user_id로 전송 -->
		아이디  :<input type="text" name="user_id"><br>
		<!-- 비밀번호를 user_pw로 전송 -->
		비밀번호:<input type="password" name="user_pw"><br>
		생년월일:<input type="text" name="user_birth"><br>
		성별:<input type="text" name="user_gender"><br><br>
		<!-- name 속성이 sub 라는 이름으로 모두 같다. -->
		<input type="submit" value="전송">  
		<!-- 전송 을 클릭하면 매핑 이름이 action에 설정한 input 서블릿으로 전송된다. --> 
		<input type="reset" value="초기화">
	</form>
</body>
</html>