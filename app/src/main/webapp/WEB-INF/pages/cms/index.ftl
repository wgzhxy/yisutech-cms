<!DOCTYPE html>
<html lang="en">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>A/B实验管理时平台 － 天猫持续改进平台</title>
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
</body>
</html>