<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>Join.jsp</title>

    <!-- 부트스트랩 -->
    
    <link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    	<div class="container">
			<div class="page-header">
			<h3>회원가입</h3>
			<div class="row">
				<div class="col-md-offset-1 col-md-10">
					<form class="form-horizontal" action="<c:url value="/Project/Join.kosmo"/>" method="post">
						<div class="form-group" >
							<label class="col-sm-2 control-label" >아이디</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요" name="id"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >암호</label>
							<div class="col-sm-4">
								<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="pwd"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >이름</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" placeholder="이름을 입력하세요" name="name"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >나이</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" placeholder="나이를 입력하세요" name="age"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >주소</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" placeholder="주소를 입력하세요" name="address"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >이메일</label>
							<div class="col-sm-4">
								<input type="email" class="form-control" placeholder="이메일을 입력하세요" name="email"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label" >전화번호</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" placeholder="전화번호를 입력하세요" name="phoneNumber"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">성별</label>
							<div class="col-sm-4">
								<div class="radio">
									<label><input type="radio" value="남자" name="gender"/>남자</label>
								</div>
								<div class="radio">
									<label><input type="radio" value="여자" name="gender"/>여자</label>
								</div>	
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">학력</label>
							<div class="col-sm-3">
								<select class="form-control input-sm" name="grade">
									<option>학력을 선택하세요</option>
									<option>초등학교</option>
									<option>중학교</option>
									<option>고등학교</option>
									<option>대학교</option>
								</select>						
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">자기소개</label>
							<div class="col-sm-10">
								<div class="row">
									<div class="col-sm-8">
										<textarea rows="5" class="form-control"></textarea>
									</div>							
								</div>						
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-4">
								<button class="btn btn-primary" type="submit">확인</button>
								<a href="<c:url value="/Home.jsp"/>" class="btn btn-primary"/>취소</a>
							</div>					
						</div>
						
					</form>
				</div>		
			</div>
	
		</div>
	</div>
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
  </body>
</html>