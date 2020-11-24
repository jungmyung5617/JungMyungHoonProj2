<%@page import="model.BBSDao"%>
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
    <title>BBS</title>

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
  	<jsp:include page="/Template/ProjectTop.jsp"/>
    <div class="container">
    	<div class="page-header">
    		<h1>게시판</h1>
    		<div>
    			<a href="<c:url value="/Project/Write.kosmo"/>" class="btn btn-primary";/>글쓰기</a>
    		</div>
    		<table class="table table-striped">
			<thead>
				<tr>
					<th width="15%">번호</th>
					<th width="45%">제목</th>
					<th width="20%">작성자</th>
					<th width="20%">작성일</th>
				</tr>
				<c:if test="${list==null }">
				<tr style="background-color: white" align="center">
					<td colspan="5">등록된 글이 없어요</td>
				</tr>
				</c:if>
				<c:if test="${list!=null }">
					<c:forEach var="item" items="${list}" varStatus="loop">
					<tr>
						<td> ${item.no}</td>
						<td><a href="<c:url value="/Project/View.kosmo?no=${item.no}"/>">${item.title}</a></td>
						<td> ${item.name}</td>
						<td> ${item.postDate}</td>
					</tr>
					</c:forEach>
				</c:if>
			</thead>
			</table>
    	</div>    
    </div>
	
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    
    <script src="<c:url value="/bootstrap/js/bootstrap.min.js"/>"></script>
  </body>
</html>