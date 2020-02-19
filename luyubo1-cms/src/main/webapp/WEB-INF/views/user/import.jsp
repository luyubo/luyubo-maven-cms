<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form class="form-inline" id="queryForm">
	<input type="text" value="${text }" name="text">
	<button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	<input type="hidden" name="pageNum" value="1">
</form>
  	<div style="margin-top: 18px;">
			<c:forEach items="${pageInfo.list }" var="item">
			  	<div class="media">
				 <a href="${item.url}">${item.text }</a>
				  <div class="media-body">
				 	 <fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd HH:mm:ss"/>
				 	 <a href="/user/deleteimport?id=${item.id }">删除</a>
				  </div>
				</div>
		  	</c:forEach>
	</div>
	<jsp:include page="../common/page.jsp"></jsp:include>
<script type="text/javascript">
	function gotoPage(pageNo){
		$("[name=pageNum]").val(pageNo);
		query();
	}
</script>