<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投诉用户页</title>
</head>
<body>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">文章编号</th>
      <th scope="col">标题</th>
      <th scope="col">投诉人</th>
      <th scope="col">投诉时间</th>
      <th scope="col">投诉类型</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${list}" var="item">
       <tr>
	      <th scope="row">${item.id }</th>
	      <td>${item.title }</td>
	      <td>${item.nickname }</td>
	      <td>${item.tousuTime }</td>
	      <td>${item.complaintype=="A"?"涉及黄色":item.complaintype=="B"?"涉及暴力":item.complaintype=="C"?"涉及宗教政策":item.complaintype=="D"?"涉及国家安全":item.complaintype=="F"?"涉及抄袭":"其它" }</td>
	    </tr>
   	</c:forEach>
  </tbody>
</table>
</body>
</html>