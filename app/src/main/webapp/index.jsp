<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>A/B实验管理时平台 － 天猫持续改进平台</title>
<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="../vendor/morrisjs/morris.css" rel="stylesheet">
<link rel="icon" href="/favicon.ico" type="image/x-icon"/>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<body>
<h1>CMS管理系统</h1>
<h2>sling 创建</h2>

<form method="POST" action="http://localhost:8080/sling/some/new/content/testNew" enctype="multipart/form-data">
    <input type="text" name="title" value="测试一下"/> <br/>
    <textarea type="text" name="text" tips="这是内容，请输入"></textarea> <br/>
    <input type="submit" value="创建内容">
</form>

<h2>sling 创建用户</h2>
<form method="POST" action="http://localhost:8080/sling/system/userManager/user.create.html"
      enctype="multipart/form-data">
    <input type="text" name=":name" value="wgzhxy"/> <br/>
    <input type="text" name="pwd" value="111111"/> <br/>
    <input type="text" name="pwdConfirm" value="111111"/> <br/>
    <input type="text" name="anyproperty1" value="value1"/> <br/>
    <input type="submit" value="创建用户">
</form>

<h2>sling </h2>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>
</body>
</html>