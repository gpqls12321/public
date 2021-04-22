<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script type="text/javascript" src="js/member.js"></script>

</head>
<body>
<h2>회원 탈퇴</h2>
<form action="delete_form.bizpoll" method="post" name="frm">

        <input type="reset" value="취소" class="cancel">
        <input type="button" value="탈퇴" class="submit" onclick="deletemem();"/> 

</form>
</body>
</html>