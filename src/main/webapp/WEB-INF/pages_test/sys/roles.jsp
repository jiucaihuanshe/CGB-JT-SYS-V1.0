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
	function getRequestObject() {
		if (window.XMLHttpRequest) {
			// Opera, Safari, Mozilla, Chrome,Internet Explorer 7, and IE 8.
			return (new XMLHttpRequest());
		} else if (window.ActiveXObject) {
			// Version for Internet Explorer 5.5 and 6
			return (new ActiveXObject("Microsoft.XMLHTTP"));
		} else {
			//Fails on older and nonstandard browsers.
			return (null);
		}
	}

	function doFindPageObject() {
		//1.获取ajax 请求对象
		var request = getRequestObject();
		//2.发送请求
		//2.1设置响应处理函数
		request.onreadystatechange = function() {
			//3.处理响应，异步刷新
			handleResponse(request)
		};
		//2.2初始化get请求参数
		var url = "doFindPageObject.do?pageCurrent=1";
		request.open("GET", url, true);
		//2.3发送异步请求
		request.send(null);//get请求此方法中不传数据
	}
	function handleResponse(request) {
		// 4 means response from server is complete
		if (request.readyState == 4 && request.status == 200) {
			//alert(request.responseText);
			htmlInsert("container", request.responseText);
		}
	}
	function htmlInsert(id, htmlData) {
		document.getElementById(id).innerHTML = htmlData;
	}
</script>
</head>
<body>
	<h1>检测Spring MVC环境</h1>
	<button onclick="doFindPageObject()" value="doQuery">doQuery</button>
	<!-- 将服务端返回的数据呈现在此位置 -->
	<div id="container"></div>
</body>
</html>