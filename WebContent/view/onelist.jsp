<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<style type="text/css">
#bbs table {
	width: 700px;
	margin: 0 auto;
	margin-top: 20px;
	border: 1px solid black;
	border-collapse: collapse;
	font-size: 14px;
}

#bbs table caption {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 10px;
}

#bbs table th {
	text-align: center;
	border: 1px solid black;
	padding: 4px 10px;
}

#bbs table td {
	text-align: left;
	border: 1px solid black;
	padding: 4px 10px;
}

.no {
	width: 15%
}

.subject {
	width: 30%
}

.writer {
	width: 20%
}

.reg {
	width: 20%
}

.hit {
	width: 15%
}

.title {
	background: lightsteelblue
}

.odd {
	background: silver
}
.comment {
	border: 1px solid black;
	width: 600px;
	margin: 0px auto;
	padding: 5px 50px;
}
</style>

<script type="text/javascript">
	function update_go(f) {
		f.action = "/MyController?cmd=update";
		f.submit();
	}
	function delete_go(f) {
		f.action = "/MyController?cmd=delete";
		f.submit();
	}
	function list_go(f) {
		f.action = "/MyController?cmd=list";
		f.submit();
	}
	function comment_go(f) {
		f.action = "/MyController?cmd=c_write";
		f.submit();
	}
	function c_delete(f) {
		f.action = "/MyController?cmd=c_delete";
		f.submit();
	}
</script>

</head>
<body>
	<div id="bbs">
		<form method="post">
			<table summary="게시판 내용 보기">
				<caption>게시판 내용 보기</caption>
				<tbody>
					<tr>
						<th>제목:</th>
						<td>${bvo.subject}</td>
					</tr>
					<tr>
						<th>이름:</th>
						<td>${bvo.writer}</td>
					</tr>
					<tr>
						<th>내용:</th>
						<td><script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
							<textarea name="content" readonly><pre>${bvo.content}</pre></textarea>
							<script>
								CKEDITOR.replace('content');
							</script></td>
					</tr>
					<tr>
						<th>첨부파일:</th>
							<c:choose>
								<c:when test="${empty bvo.file_name}">
									<td> 첨부파일 없음 </td>
								</c:when>
								<c:otherwise>
									<td>
										<img alt="" src="upload/${bvo.file_name}" style="width: 100px;">
										<a href="view/download.jsp?path=upload&file_name=${bvo.file_name}">${bvo.file_name}</a>
									</td>
								</c:otherwise>
							</c:choose>
					</tr>

					<tr>
						<td colspan="2">
							<input type="button" value="수정" onclick="update_go(this.form)">
							<input type="button" value="삭제" onclick="delete_go(this.form)">
							<input type="button" value="목록" onclick="list_go(this.form)">
							<input type="hidden" value="${cPage}" name="cPage">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	<br><hr><br>
	
	<!-- 댓글 입력 창 -->
	<div class="comment">
		<form method="post">
			<p> 이름 : <input type="text" name="writer" size="15"> </p>
			<p> 내용 : <br> 
				<textarea rows="4" cols="40" name="content"></textarea>
			</p>
			<p> 비밀번호 : <input type="password" name="pwd" size="15"> </p>
			<input type="button" value="댓글 저장" onclick="comment_go(this.form)"> 
			<!-- b_idx hidden -->
			<input type="hidden" name="b_idx" value="${bvo.b_idx}">
			<input type="hidden" value="${cPage}" name="cPage">
		</form>
	</div>
	
	<br><hr><br>
	
	<!-- 댓글 출력 -->
	<div style="display: table; margin: 0 auto;">
		<c:forEach var="k" items="${c_list}">
			<div style="border: 1px solid black; width: 400px; margin: 20px; padding: 20px;">
				<form method="post">
					<p> 이름 : ${k.writer} </p>
					<p> 날짜 : ${k.write_date.substring(0,10)} </p>
					<p> 내용 : <pre>${k.content}</pre> </p>
				<!-- 댓글 삭제 -->
					<input type="button" value="댓글 삭제" onclick="c_delete(this.form)">
					<input type="hidden" name="c_idx" value="${k.c_idx}">
					<input type="hidden" name="b_idx" value="${k.b_idx}">
					<input type="hidden" value="${cPage}" name="cPage">
				</form>
			</div>
			<hr>
		</c:forEach>
	</div>
</body>
</html>

