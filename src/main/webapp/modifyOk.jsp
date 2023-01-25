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
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw =	request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		MemberDao dao = new MemberDao();
		int modify = dao.modify(id, pw, name, email);
		
		if(modify==1){
			
			MemberDto dto = dao.getMemberInfo(id);
	%>
		<h2>수정된 정보</h2>
		<hr>
			아이디 : <%=dto.getId() %><br>
			이름 : <%=dto.getName() %><br>
			이메일 : <%= dto.getEmail() %><br>
	    	가입일 : <%= dto.getJointime() %>
	<%	
		}
		else{	
	%>
		<script type="text/javascript">
		alert("정보 수정 실패 다시시도해주세요");
		history.go(-1);
		</script>
	<%		
		}
	%>
</body>
</html>