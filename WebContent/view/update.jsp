<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style type="text/css">
	#bbs table {
	    width:700px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
</style>

<script type="text/javascript">
	function update_ok(f) {
		// 유효성 검사
		var pwd = f.pwd.value;
		if(pwd == "") {
			alert("비밀번호를 입력하세요.");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
		
		if (f.pwd.value == "${bvo.pwd}") {
		// alerm 과 달리 confirm 은 Y/N 을 선택하며, 이에따라 제출값이 달라짐
			var chk = confirm("이대로 수정할까요?");
			if (chk == true) {
				f.action="/MyController?cmd=update_ok";
				f.submit();
			} else {
			// 'return false' 가 없으면 취소를 눌러도 삭제되는 오류 발생
				return false;
				history.go(-1);
			}
		} else {
			alert("비밀번호가 틀렸습니다.\n다시 입력해주세요.");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
	}
	
	function list_go() {
		location.href = "/MyController?cmd=list";
	}
</script>

</head>
<body>
	<div id="bbs">
	<form method="post" encType="multipart/form-data">
		<table summary="게시판 수정하기">
			<caption>게시판 수정하기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="subject" size="45" value="${bvo.subject}"/></td>
				</tr>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="writer" size="12" value="${bvo.writer}"/></td>
				</tr>
				<tr>
					<th>내용:</th>
					<td>
						<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
						<textarea name="content">${bvo.content}</textarea>
                		<script>
                        	CKEDITOR.replace( 'content' );
                		</script>
					</td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<td><input type="file" name="file_name"/>${bvo.file_name}</td>
				</tr>
				<tr>
					<th>비밀번호:</th>
					<td><input type="password" name="pwd" size="12"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="수정하기" onclick="update_ok(this.form)"/>
						<input type="reset" value="다시"/>
						<input type="button" value="목록" onclick="list_go()"/>
						<!-- 수정 시 파일 업로드 하지 않는 경우 f_name 사용 -->
						<input type="hidden" name="f_name" value="${bvo.file_name}">
						<input type="hidden" value="${cPage}" name="cPage">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>

