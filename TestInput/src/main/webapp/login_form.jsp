<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<!-- �Է� �����͸� ���� ���� �̸� Login�� �������� ���� -->
	<form name="frmInput" method="get" action="tl">
		<!-- �ؽ�Ʈ �ڽ��� �Էµ� id�� user_id�� ���� -->
		���̵�  :<input type="text" name="user_id"><br>
		<!-- ��й�ȣ�� user_pw�� ���� -->
		��й�ȣ:<input type="password" name="user_pw"><br>
		�������:<input type="text" name="user_birth"><br>
		����:<input type="text" name="user_gender"><br><br>
		<!-- name �Ӽ��� sub ��� �̸����� ��� ����. -->
		<input type="submit" value="����">  
		<!-- ���� �� Ŭ���ϸ� ���� �̸��� action�� ������ input �������� ���۵ȴ�. --> 
		<input type="reset" value="�ʱ�ȭ">
	</form>
</body>
</html>