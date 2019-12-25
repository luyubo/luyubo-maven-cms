<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<form class="form-inline">
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="text" value="${link.text }" class="form-control" placeholder="请输入网站名">
	  </div>
	  <input type="hidden" name="pageNum" value="${pageInfo.pageNum}">
	  <button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	</form>
	
	<table class="table">
  <thead>
    <tr>
      <th><input type="checkbox" id="chkALL"></th>
      <th scope="col">#</th>
      <th scope="col">名称</th>
      <th scope="col">URL</th>
      <th scope="col">创建时间</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${pageInfo.list }" var="item">
       <tr>
	    <th><input type="checkbox" value="${item.id }" name="chk_list"></th>
	      <th scope="row">${item.id }</th>
	      <td>${item.text }</td>
	      <td>${item.url }</td>
	      <td>
	      	 <fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd"/>
	      </td>
	      <td>
	      	<input type="hidden" name="delId" id="delId">
	      	<button type="button" class="btn btn-primary" onclick="edit('${item.id}');">编辑</button>
	      </td>
	    </tr>
   	</c:forEach>
  </tbody>
</table>

	<div class="row">
		<div class="col-2">
			<button type="button" class="btn btn-danger" onclick="delAlert();">删除</button>
			<button type="button" class="btn btn-danger" onclick="add();">添加</button>
		</div>
		<div class="col-10">
			<jsp:include page="../common/page.jsp"></jsp:include>
		</div>
	</div>

	<div class="alert alert-danger" role="alert" style="display: none"></div>

<div class="modal" tabindex="-1" role="dialog" id="delModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">确认框</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        	你确认删除选择的数据吗？
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="batchDel();">确认删除</button>
      </div>
    </div>
  </div>
</div>
<script src="/public/js/checkbox.js"></script>
<script>
var delId = null;
//添加
function add(){
	openPage("/admin/link/edit");
}
//编辑
function edit(id){
	openPage("/admin/link/edit?id="+id);
}
//分页
function gotoPage(pageNo){
	$("[name=pageNum]").val(pageNo);
	query();
}
//删除提示
function delAlert(){
	var ids = getCheckboxIds();
	if(ids==""){
		$(".alert").html("请选择要删除的记录");
		$(".alert").show();
		return;
	}
	$('#delModal').modal('show')
}
//批量删除
function batchDel(){
	var ids = getCheckboxIds();
	console.log(ids);
	$.post("/admin/link/delByIds",{ids:ids},function(res){
		$('#delModal').modal('hide')
		reload();
	})
}
//查询
function query(){
	var params = $("form").serialize();
	reload(params);
}
</script>