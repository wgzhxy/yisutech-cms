<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>CMS管理系统</h1>
<h2>sling 创建</h2>

<form method="POST" action="http://localhost:8080/sling/some/new/content/testNew" enctype="multipart/form-data">
    <input type="text" name="title" value="测试一下"/> <br/>
    <textarea type="text" name="text" tips="这是内容，请输入"></textarea> <br/>
    <input type="submit" value="创建内容">
</form>

<h2>sling 创建用户</h2>
<form method="POST" action="http://localhost:8080/sling/system/userManager/user.create.html" enctype="multipart/form-data">
    <input type="text" name=":name" value="wgzhxy"/> <br/>
    <input type="text" name="pwd" value="111111"/> <br/>
    <input type="text" name="pwdConfirm" value="111111"/> <br/>
    <input type="text" name="anyproperty1" value="value1"/> <br/>
    <input type="submit" value="创建用户">
</form>

<h2>sling </h2>

</body>
</html>