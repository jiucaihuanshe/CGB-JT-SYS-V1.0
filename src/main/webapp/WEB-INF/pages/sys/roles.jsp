<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* function doFindPageObject() {
		//alert("查询");
		//document.location.href="doFindPageObject.do";
	} */
	function doFindPageObject() {
		//1.获取ajax 请求对象
		//2.发送请求
		//3.处理响应，异步刷新
	}
</script>
</head>
<body>
	<h1>检测Spring MVC环境</h1>
	<button onclick="doFindPageObject()" value="doQuery" >doQuery</button>
	<!-- 将服务端返回的数据呈现在此位置 -->
	<div id="container">
		${data}
	</div>
</body>
</html>