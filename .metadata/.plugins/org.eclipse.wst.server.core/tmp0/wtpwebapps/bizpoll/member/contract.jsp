<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<script type="text/javascript" src="js/member.js"></script>
<article>
	<h2>Join Us</h2>
	<form id="join" action="join_form.bizpoll" method="post" name="frm">
		좋은 샵입니다.
		<br><br>
		<textarea rows="15" cols="80">
			제 1장 총칙
			제 1조 (목적)
			...
			가나다라마바사 어쩌구 ...
			많이 애용해 주세요 ㅋㅋ
		</textarea>
		<br><br>
		<div style="text-align: center;">
			<input type="radio" name="okon1" checked="checked"> 동의함&nbsp;&nbsp;&nbsp;
			<input type="radio" name="okon1"> 동의 안함
		</div>
		<input type="button" value="Next" class="submit" onclick="go_next();" style="float: right;">
	</form>
</article>
<%@ include file="../footer.jsp"%>