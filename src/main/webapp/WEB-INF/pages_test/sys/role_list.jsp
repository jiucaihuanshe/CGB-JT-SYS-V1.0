<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table border="1" cellpadding="1" cellspacing="1">
	<thead>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>note</th>
		</tr>
	</thead>
	<thead id="tabBodyId">

	</thead>
</table>
<script type="text/javascript">
	$(function(){
		doGetObject();
	})
	function doGetObject(){
		//jquery提供的ajax函数
		$.ajax({
			url:"doFindPageObject.do",
			dataType:"json",//期望的返回的数据格式
			data:{"pageCurrent":1},//提交的数据
			success:function(result){//服务端响应ok回调此函数
				doSetTableBody(result);//result用于接收服务端返回的数据。
			},
			error:function(result){//服务端响应失败
				console.log(result);
			},
			//数据是否需要缓冲，false不缓存
			cache:false 
		});
	}
	function doSetTableBody(data){
		//console.log(data);//array
		var tBody=$("#tabBodyId");
		//迭代data
		for(var i in data){
			var tr =$("<tr></tr>");//构建tr对象
			tr.append("<td>"+data[i].id+"</td>");
			tr.append("<td>"+data[i].name+"</td>");
			tr.append("<td>"+data[i].note+"</td>");+
			//将tr追加到tbody
			tBody.append(tr);
		}
	}
</script>
