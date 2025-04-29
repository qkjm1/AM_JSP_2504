<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body>
	<h2>회원가입</h2>

	<a href="../home/main">메인으로 이동</a>

	<script type="text/javascript">
	function JoinForm__submit(form) {
	let loginId = form.loginId.value.trim();
	let loginPw = form.loginPw.value.trim();

	if (loginId.length == 0) {
		alert('아이디 써');
		form.loginId.focus();
		return;
	}
	if (loginPw.length == 0) {
		alert('비번 써');
		form.loginPw.focus();
		return;
	}

	if (loginPwConfirm.length == 0) {
		alert('비번 확인 써');
		form.loginPwConfirm.focus();
		return;
	}

	if (loginPw != loginPwConfirm) {
		alert('비번 일치 x');
		return;
	}

	if (form.name.value.trim().length == 0) {
		alert('이름 써');
		form.name.focus();
		return;
	}

	form.submit();

}
	</script>


	<form onsubmit="signForm__submit(this); return false;" action="doSign"
		method="POST">
		<div>
			아이디 : <input autocomplete="off" type="text" placeholder="아이디 입력"
				name="loginId" />
		</div>
		<div>
			비밀번호 : <input autocomplete="off" type="text" placeholder="비밀번호 입력"
				name="loginPw" />
		</div>

		<button type="submit">로그인</button>
	</form>

</body>
</html>