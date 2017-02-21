<!DOCTYPE html>
<html lang="en">

<head>
    <!-- header -->
    <#include "/console/comm/header.html">
        <link href="../jsoneditor/jsoneditor.css" rel="stylesheet" type="text/css">
        <script src="../jsoneditor/jsoneditor.js"></script>
</head>

<body>

<div id="wrapper">
    <!-- menu -->
    <#include "/console/comm/menu.html">

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">数据字典操作</span></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row"><div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <input type="button" onclick="queryConfigs();" value="查询数据字典列表"/>
                    </div>
                </form>
                <h4>查询资源</h4>
                <hr/>
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="configId">数据字典ID</label>
                        <input type="text" class="form-control" id="configId" style="size: 80px;"
                               placeholder="请输入数据字典ID">
                    </div>
                    <div class="form-group">
                        <label for="queryResult">返回结果</label>
                        <div id="queryResult"></div>
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="queryConfig();" value="查询数据字典详情"/>
                    </div>
                </form>
                <h4>(更新/新增)资源</h4>
                <hr/>
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="saveContent">资源内容</label>
                        <div id="saveContent"></div>
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="saveConfig();" value="保存"/>
                    </div>
                </form>
                <h4>删除资源</h4>
                <hr/>
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="delConfigId">资源ID</label>
                        <input type="text" class="form-control" id="delConfigId" style="size: 80px;"
                               placeholder="请输入资源ID">
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="deleteConfig();" value="删除"/>
                    </div>
                </form>
            </div>
        </div></div>
        </div>
    </div>
</div>

<!-- footer -->
<#include "/console/comm/footer.html">

<script type="application/javascript">

    var queryResult, saveContent;
    $(document).ready(function () {
        var options = {mode: 'view', modes: ['code', 'form', 'text']};
        var optionsEdit = {mode: 'tree', modes: ['code', 'form', 'text', 'tree', 'view']};
        queryResult = new JSONEditor(document.getElementById('queryResult'), options);
        saveContent = new JSONEditor(document.getElementById('saveContent'), optionsEdit);
    });

    function queryConfigs() {
        window.open("/ant/res/queryDicts.do", "_blank");
    }

    function queryConfig() {
        $.ajax({
            url: "/ant/res/queryDict",
            data: {
                id: $("#configId").val()
            },
            dataType: "text",
            success: function (result) {
                queryResult.setText(result)
                //$("#queryResult").val(result);
            }
        });
    }

    function saveConfig() {
        $.ajax({
            url: "/ant/res/saveDict",
            type: "POST",
            data: {
                config: saveContent.getText()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function deleteConfig() {
        $.ajax({
            url: "/ant/res/deleteDict",
            data: {
                id: $("#delConfigId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
</script>

</body>

</html>
