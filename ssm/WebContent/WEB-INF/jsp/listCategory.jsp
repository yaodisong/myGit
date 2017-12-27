<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<div style="width:500px;margin:0px auto;text-align:center"> 
	<table align='center' border='1' cellspacing='0'>
	    <tr>
	        <td>id</td>
	        <td>name</td>
	        <td>操作</td>
	    </tr>
	    <c:forEach items="${cs}" var="c" varStatus="st">
	        <tr>
	            <td>${c.id}</td>
	            <td>${c.name}</td>
	            <td>编辑</td>
	            <td>删除</td> 
	        </tr>
	    </c:forEach>
	</table>
	<div style="text-align:center">
	        <a href="?start=0">首  页</a>
	        <a href="?start=${page.start-page.count}">上一页</a>
	        <a href="?start=${page.start+page.count}">下一页</a>
	        <a href="?start=${page.last}">末  页</a>
	</div>
</div>
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<style>
	.success>th{
		text-align:center;
	}
</style>
 
<title>分类管理</title>
 
<div class="workingArea">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>
     
    <div class="listDataTableDiv">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead align="center">
                <tr class="success">
                    <th align="center">ID</th>
                    <th align="center">图片</th>
                    <th align="center">分类名称</th>
                    <th align="center">属性管理</th>
                    <th align="center">产品管理</th>
                    <th align="center">编辑</th>
                    <th align="center">删除</th>
                </tr>
            </thead>
            <tbody align="center">
                <c:forEach items="${cs}" var="c">
                 
                <tr>
                    <td>${c.id}</td>
                    <td><img height="40px" src="img/category/${c.id}.jpg"></td>
                    <td>${c.name}</td>
                         
                    <td><a href="admin_property_list?cid=${c.id}"><span class="glyphicon glyphicon-th-list"></span></a></td>                    
                    <td><a href="admin_product_list?cid=${c.id}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>                   
                    <td><a href="admin_category_edit?id=${c.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" onclick="del(${c.id})" ><span class="   glyphicon glyphicon-trash"></span></a></td>
     
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     
    <div class="pageDiv">
        <%@include file="../include/admin/adminPage.jsp" %>
    </div>
     
    <!-- <div class="panel panel-warning addDiv">
      <div class="panel-heading">新增分类</div>
      <div class="panel-body">
            <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input  id="name" name="name" type="text" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>分类圖片</td>
                        <td>
                            <input id="categoryPic" accept="image/*" type="file" name="image" />
                        </td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>
                </table>
            </form>
      </div>
    </div> -->
    <div class="panel panel-warning addDiv">
      <div class="panel-heading">新增分类</div>
      <div class="panel-body">
          <table class="addTable">
              <tr>
                  <td>分类名称</td>
                  <td><input  id="name" name="name" type="text" class="form-control"></td>
              </tr>
              <tr class="submitTR">
                  <td colspan="2" align="center">
                      <button onclick="add()" class="btn btn-success">提 交</button>
                  </td>
              </tr>
          </table>
      </div>
    </div>
    
     
</div>
<script>
/* $(function(){
     
    $("#addForm").submit(function(){
        if(!checkEmpty("name","分类名称"))
            return false;
        if(!checkEmpty("categoryPic","分类图片"))
            return false;
        return true;
    });
}); */
function add(){
	if(!checkEmpty("name","分类名称")){
		return;
	}  
	var categoryName=$("#name").val();
	$.ajax({
		type:"post",
		url:"<%=basePath%>"+"Category/admin_category_add",
		data:{
			categoryName:categoryName
		},
		dataType:"json",
		success:function(msg){
			alert(msg.msg); 
			window.location.reload();
		},
		error:function(){
			alert("failed");
		}
	});
}
function del(id){
	$.ajax({
		type:"post",
		url:"<%=basePath%>"+"Category/admin_category_delete",
		data:{
			id:id
		},
		dataType:"json",
		success:function(msg){
			alert(msg.msg); 
			window.location.reload();
		},
		error:function(){
			alert("failed");
		}, 
		done: function(msg){
			alert(msg);
		}
	});
}
</script>
<%@include file="../include/admin/adminFooter.jsp"%>































