<%@page import="com.layongyeop.exe.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<%
		String sessionId = (String) session.getAttribute("memberId");
		
		MemberDao dao = new MemberDao();
		int resultFlag =  dao.withdraw(sessionId);
		if(resultFlag == 1 ){
			session.invalidate();
	%>
		<script type="text/javascript">
		alert("회원탈퇴성공");
		document.location.href="login.jsp";
		</script>
	<%
			
		}else{
	
	%>
		<script type="text/javascript">
		alert("회원탈퇴실패 다시 시도해주세요");
		history.go(-1);
		</script>
	<%
		}
	%>
</body>
</html>