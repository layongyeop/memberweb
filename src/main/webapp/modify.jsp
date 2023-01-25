<%@page import="com.layongyeop.exe.MemberDto"%>
<%@page import="com.layongyeop.exe.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<%
		String sessionId = (String) session.getAttribute("memberId");
		MemberDao dao = new MemberDao();
		
		MemberDto dto = dao.getMemberInfo(sessionId);
	%>
	아이디 : <%=dto.getId() %><br>
	이름 : <%=dto.getName() %><br>
	가입일 : <%= dto.getJointime() %>
	
	<h2>회원 정보 수정</h2>
	<hr>
	<form action="modifyOk.jsp">
		아이디 : <input type="text" name="id" value="<%=dto.getId() %>" re><br><br>
		비밀번호 :<input type="password" name="pw"><br><br>
		이름 : <input type="text" name="name" value="<%=dto.getName() %>"><br><br>
		이메일 : <input type="text" name="email" value="<%=dto.getEmail() %>"><br><br>
		가입일 : <input type="text" name="jointime" value="<%=dto.getJointime() %>"><br><br>
	<input type="submit" value="정보수정">
	<input type="button" value="취소" onclick="javascript:window.location='main.jsp'">
	</form>
</body>
</html>