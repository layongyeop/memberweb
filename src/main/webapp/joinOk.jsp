<%@page import="com.layongyeop.exe.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 체크</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDao mdao = new MemberDao();
		int resultInt = mdao.joinMember(id, pw, name, email);
		
		if(mdao.idCheck(id)==1){
			
		
	%>	
			<script type="text/javascript">
			
			alert('이미 가입된 아이디입니다.');
			history.go(-1);
			</script>
		
	<%
		}
		else if(resultInt == 1){
	%>
			<script type="text/javascript">
			
			alert('회원 가입 성공');
			document.location.href="login.jsp";
			</script>
			 
			
	<% 
		}
		else{
	%>
			<script type="text/javascript">
			
			alert('회원 가입 실패');
			document.location.href="join.jsp";
			</script>
	<% 
		}
		
	
	
	
	%>

</body>
</html>