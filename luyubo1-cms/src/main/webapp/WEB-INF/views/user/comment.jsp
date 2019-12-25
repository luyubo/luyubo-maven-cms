<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<form class="form-inline" id="queryForm">
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="title" value="${comment.title }" class="form-control" placeholder="请输入文章标题">
	  </div>
	  <input type="hidden" name="pageNum" value="1">
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="created" value="${comment.created}" class="form-control" onclick="WdatePicker()" placeholder="请输入最早创建时间">
	  </div>
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="created1" value="${comment.created1}" class="form-control" onclick="WdatePicker()" placeholder="请输入最晚创建时间">
	  </div>
	  <button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	</form>
  	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col"><input type="checkbox" value="" id="chkALL" name="chkALL"></th>
      	  <th scope="col">id</th>
      	  <th scope="col">昵称</th>
	      <th scope="col">文章标题</th>
	      <th scope="col">评论内容</th>
	      <th scope="col">评论时间</th>
	      <th>操作</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach items="${pageInfo.list }" var="item">
       		<tr>
       			<th><input type="checkbox" value="${item.id }" name="chk_list"></th>
	      		<th scope="row">${item.id }</th>
	      		<th>
	      			${item.nickname }
	      			<c:if test="${USER_SESSION_ID!=null && USER_SESSION_ID.headimg!=null }">
						<a class="nav-link navbar-brand" href="#">
							<img src="${USER_SESSION_ID.headimg }" width="30" height="30" alt="">
						</a>
					</c:if>
				</th>
	      		<th>${item.title }</th>
	      		<th>${item.content }</th>
	      		<th>${item.created }</th>
	      		<th>
	      			<button type="button" class="btn btn-primary" onclick="view('${item.articleId}')">查看</button>
	      		</th>
       		</tr>
	  	</c:forEach>
	  </tbody>
	</table>
		
		<div class="row">
			<div class="col-2">
				<button type="button" class="btn btn-danger" onclick="delAlert();">删除</button>
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
<script type="text/javascript" src="/public/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
function query(){
	var params = $("form").serialize();
	reload(params);
}

function view(id){
	window.open("/article/"+id+".html");
}

function gotoPage(pageNo){
	$("[name=pageNum]").val(pageNo);
	query();
}

function delAlert(){
	var ids = getCheckboxIds();
	if(ids==""){
		$(".alert").html("请选择要删除的评论");
		$(".alert").show();
		return;
	}
	$('#delModal').modal('show')
}

function batchDel(){
	var ids = getCheckboxIds();
	console.log(ids);
	$.post("/comment/delByIds",{ids:ids},function(res){
		if(res.result){
			$("#queryForm #pageNum").val(1);
			$('#delModal').modal('hide');
			query();
		}else{
			$(".alert").html(res.message);
			$(".alert").show();
			$('#delModal').modal('hide');
		}
	});
}

</script>