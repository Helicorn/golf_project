<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
	김지인 이사 시작합니다 :)
	
	김종혁도 이사 시작합니다 :)
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href='<c:url value='/yeyag/yeyag_list'/>' role="button" class="btn btn-outline-info">골프장목록 들어가기</a><br/>
<a href='<c:url value='/yeyag/field_search'/>' role="button" class="btn btn-outline-info">골프장 검색 들어가기</a><br/>
<a href='<c:url value='/yeyag/yeyag_main'/>' role="button" class="btn btn-outline-info">골프장 상세페이지 들어가기</a>
</body>
</html>
