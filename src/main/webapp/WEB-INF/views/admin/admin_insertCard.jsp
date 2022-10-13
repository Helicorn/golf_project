<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*, java.util.*, javax.sql.*, javax.naming.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/admin_insertCard.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/common.css" />
<br/>

<%-- 관리자페이지-스코어카드 입력 본문 --%>
<script src="/resources/js/jquery.js"></script>

<script>	

	$('#summon_image').on('click',function(){
		document.write("<img src=/resources/upload/");
	});
</script>

<article class="adminInsertCard_main">
<br>
	<form method="post" action="admin_insertCard2.do">
		<div>
			<div id="imginfo_wrap">
			아이디 : <input type="text" name="id" size="14">
			방문날짜 : <input type="text" id="admin_playdate" readonly value="방문 날짜를 선택하세요" size="14">	
					<input type="date" name="playdate" class="sc_date" id="sc_playdate" onchange="document.getElementById('admin_playdate').value = this.value">
					<input type="submit" value="확인하기">
			</div>
			<br>
		</div>
	</form>
	
</article>

