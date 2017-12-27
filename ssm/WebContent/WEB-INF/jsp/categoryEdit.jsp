<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
 
<title>编辑分类</title>
 
<div class="workingArea">
 
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li class="active">编辑分类</li>
    </ol>
 
    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑分类</div>
        <div class="panel-body">
            <table class="editTable">
                <tr>
                    <td>分类名称</td>
                    <td><input  id="name" name="name" type="text" class="form-control"></td>
                </tr>
                <tr class="submitTR">
                    <td colspan="2" align="center">
                        <input type="hidden" name="id" id="id" value="${id}">
                        <button onclick="update()" class="btn btn-success">提 交</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script>
    $(function(){
 		
        $("#editForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;
 
            return true;
        });
    });
    window.onload = function() {
    	var editId = $("#id").val();
        $.ajax({
    		type:"post",
    		url:"<%=basePath%>"+"Category/admin_category_editList",
    		data:{
    			id:editId
    		},
    		async: false,
    		dataType:"json",
    		success:function(msg){
    			$("#name").val(msg.data.name);
    		},
    		error:function(){
    			alert("failed");
    		}, 
    		done: function(msg){
    			alert(msg);
    		}
    	});
        
    }
    function update() {
    	var editId = $("#id").val();
    	var editName = $("#name").val();
    	$.ajax({
    		type:"post",
    		url:"<%=basePath%>"+"Category/admin_category_update",
    		data:{
    			id:editId,
    			name:editName
    		},
    		async: false,
    		dataType:"json",
    		success:function(msg){
    			alert(msg.msg);
    			window.location.href="<%=basePath%>"+"/Category/listCategory"; 
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

























