<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  	<form class="form-inline" id="queryForm">
	  
	  <div class="form-group mx-sm-3 mb-2">
	     <select id="inputState" class="form-control" id="complaintype" name="complaintype">
	        <option value="">请选择投诉类型</option>
	     	<c:forEach items="${complainList }" var="item">
	     		<c:if test="${item.articleId==article.id}">
			        <option value="${item.complaintype }" selected="selected">${item.complaintype=="A"?"涉及黄色":item.complaintype=="B"?"涉及暴力":item.complaintype=="C"?"涉及宗教政策":item.complaintype=="D"?"涉及国家安全":item.complaintype=="F"?"涉及抄袭":"其它" }</option>
	     		</c:if>
	     		<c:if test="${item.articleId!=article.id }">
			        <option value="${item.complaintype }">${item.complaintype=="A"?"涉及黄色":item.complaintype=="B"?"涉及暴力":item.complaintype=="C"?"涉及宗教政策":item.complaintype=="D"?"涉及国家安全":item.complaintype=="F"?"涉及抄袭":"其它" }</option>
	     		</c:if>
	     	</c:forEach>
	      </select>
	  </div>
	  <div class="form-group mx-sm-3 mb-2">
	   	 次数大于<input type="text" id="min" name="min" value="${complain.min }" class="form-control">
	  </div>
	  <div class="form-group mx-sm-3 mb-2">
	   	 次数小于<input type="text" id="max" name="max" value="${complain.max }" class="form-control">
	  </div>
	  <input type="hidden" name="pageNum" value="1">
	  <button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	</form>
  
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">标题</th>
      <th scope="col">投诉类型</th>
      <th scope="col" onclick="desc(1)">投诉次数</th>
      <th scope="col">投诉详情</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${pageInfo.list }" var="item">
       <tr>
	      <th scope="row">${item.id }</th>
	      <td>${item.title }</td>
	      <td>${item.complaintype=="A"?"涉及黄色":item.complaintype=="B"?"涉及暴力":item.complaintype=="C"?"涉及宗教政策":item.complaintype=="D"?"涉及国家安全":item.complaintype=="F"?"涉及抄袭":"其它" }</td>
	      <td>${item.tousuCnt }</td>
	      <td><button type="button" class="btn btn-primary" onclick="toshow('${item.id}')">详情</button></td>
	      <td>
	      	<c:if test="${item.tousuCnt>=50 }">
	      		<button type="button" class="btn btn-primary" onclick="status('${item.id}')">禁止</button>
	      	</c:if>
	      </td>
	    </tr>
   	</c:forEach>
  </tbody>
</table>
<jsp:include page="../common/page.jsp"></jsp:include>
<div class="alert alert-danger" role="alert" style="display: none"></div>
<script>
function query(){
	var min=$("#min").val();
	var max=$("#max").val();
	if(max!=null && max!=""){
		if(min>max){
			$(".alert").html('最大数不能大于最小数');
			$(".alert").show();
			return;
		}
	}
	
	var params = $("form").serialize();
	reload(params);
}


function gotoPage(pageNo){
	$("[name=pageNum]").val(pageNo);
	query();
}

function toshow(id){
	alert(id);
	window.open("/admin/tousushow?articleId="+id);
}

function status(id){
	alert(id);
	$.post(
		"/admin/article/update/status3",
		{id:id},
		function(flag){
			if(flag){
				alert("禁用成功");
			}else{
				alert("禁用失败");
			}
		}
	)
}

function desc(id){
	var params = $("form").serialize();
	reload();
}

function view(id){
	window.open("/article/"+id+".html");
}

</script>