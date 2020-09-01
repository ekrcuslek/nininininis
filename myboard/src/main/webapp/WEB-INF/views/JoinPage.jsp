<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width">
  <link rel="stylesheet" href="resources/css/join.css">
  <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <title>회원가입</title>
  
</head>
<body>
<section class="join-form">
  <h1>회원가입</h1>
  <form action="api/join.do" method="post" id="userForm">
    <div class="int-area">
      <input type="text" name="userId" id="userId" autocomplete="off" required>
      <label for="userId">아이디</label>
    </div>
    <div class="int-area">
      <input type="text" name="userPw" id="userPw" autocomplete="off" required>
      <label for="userPw">비번</label>
    </div>
    <div class="int-area">
      <input type="text" name="userName" id="userName" autocomplete="off" required>
      <label for="userName">이름</label>
    </div>
    <div class="int-area">
      <input type="text" name="userTel" id="userTel" autocomplete="off" required>
      <label for="userTel">전번</label>
    </div>
    <div class="int-area">
      <input type="text" name="userIdentity" id="userIdentity" autocomplete="off" required>
      <label for="userIdentity">학번</label>
    </div>
    <div class="btn-area">
      <button type="submit" id="btn">가입</button>
    </div>
  </form>
</section>
<script src="resources/js/join.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>
<script src="resources/js/additional-methods.min.js"></script>
<script src="resources/js/messages_ko.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
$('#userId').keyup(function() {
	$.ajax({
		url:"checkid",
		type:"POST",
		data:{
			"userId":$('#userId').val()
		},
		success:function(result) {
			if(result == "yes") {
				$('#userId').next('label').text('가능');
				$('#btn').removeAttr("disabled","disabled");
				$('#btn').css("background","#166cea");
			} else {
 				$('#userId').next('label').text('중복');
 				$('#btn').attr("disabled","disabled");
 				$('#btn').css("background","gray");
			}
		}
		})	
});

$('#userForm button[type=submit]').click(addMember);


function addMember(e){
	e.preventDefault();
	var userId = document.getElementById("userId").value;
	var userPw = document.getElementById("userPw").value;
	var userName = document.getElementById("userName").value;
	var userTel = document.getElementById("userTel").value;
	var userIdentity = document.getElementById("userIdentity").value;
	if (userId == "" || userId == null) {
		swal({title: "주의",text: "아이디를 입력해주세요",icon: "warning"});
		return;
	}
	if (userPw == "" || userPw == null) {
		swal({title: "주의",text: "비밀번호를 입력해주세요",icon: "warning"});
		return;
	}
	if (userName == "" || userName == null) {
		swal({title: "주의",text: "이름를 입력해주세요",icon: "warning"});
		return;
	}
	if (userTel == "" || userTel == null) {
		swal({title: "주의",text: "전화번호를 입력해주세요",icon: "warning"});
		return;
	}
	if (userIdentity == "" || userIdentity == null) {
		swal({title: "주의",text: "학번을 입력해주세요",icon: "warning"});
		return;
	}
		
	var userData = $("#userForm").serialize();
	var url = $('#userForm').attr("action");
	//if(!($('#userForm').valid())) {return false;}
	
	$.ajax({
		type:"POST",
		url:url,
		data: userData,
		dataType:'json',
		error:onError,
		success:onSuccess});
}
function onError() {

	
}

function onSuccess(data) {
	swal({
        title: data.userId +"님 환영합니다",
        text: "홈페이지로 이동합니다",
        icon: "success"
    }).then(function() {
        window.location = "../myboard/";
    });
}



</script>
</body>
</html>
