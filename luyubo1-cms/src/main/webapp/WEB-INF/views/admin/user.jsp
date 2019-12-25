<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  	<form class="form-inline">
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="username" value="${user.username}" class="form-control" placeholder="请输入登录名">
	  </div>
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="nickname" value="${user.nickname}" class="form-control" placeholder="请输入昵称">
	  </div>
	  <input type="hidden" name="pageNum">
	  <button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	</form>
  
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">登录名称</th>
      <th scope="col">用户昵称</th>
      <th scope="col">是否禁用</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${pageInfo.list }" var="user">
    	<tr>
    		<th scope="row">${user.id }</th>
    		<td>${user.username }</td>
    		<td>${user.nickname }</td>
    		<td>
    			${user.locked==1?'禁用':'启用' }
    		</td>
    		<td>
    			<c:if test="${user.locked==0 }">
    				<button type="button" class="btn btn-primary" onclick="locked('${user.id}')">禁用</button>
    			</c:if>
    			<c:if test="${user.locked==1 }">
    				<button type="button" class="btn btn-primary" onclick="unLocked('${user.id}')">启用</button>
    			</c:if>
    		</td>
    	</tr>
    </c:forEach>
  </tbody>
</table>
<jsp:include page="../common/page.jsp"></jsp:include>

<script>
function locked(id){
	$.post('/admin/user/locked',{userId:id},function(res){
		if(res){
			reload();
		}
	})
}

function unLocked(id){
	$.post('/admin/user/unLocked',{userId:id},function(res){
		if(res){
			reload();
		}
	})
}

function gotoPage(pageNo){
	$("[name=pageNum]").val(pageNo);
	console.log(pageNo);
	query();
}
	
	function query(){
		var params = $("form").serialize();
		reload(params);
	}
</script>