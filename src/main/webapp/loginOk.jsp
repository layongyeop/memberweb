<%@page import="com.layongyeop.exe.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 체크</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		MemberDao dao = new MemberDao();
		
		int logincheck = dao.loginCheck(id, pw);
		
		if(logincheck == 1){
			session.setAttribute("memberId", id);
			session.setAttribute("ValidSession", "yes");
	%>
			<script type="text/javascript">
			alert('로그인 성공');
			document.location.href='main.jsp';
			</script>
	<%
			
			
		}else{
	%>
			<script type="text/javascript">
			alert('아이디 또는 비밀번호 오류입니다.');
			history.go(-1);
			</script>			
	<%
		}
	%>
</body>
</html>;