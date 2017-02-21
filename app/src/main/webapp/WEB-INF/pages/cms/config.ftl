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
                <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">配置项操作</span></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <div class="panel-body">
                        <h4>查询配置项列表</h4>
                        <form role="form" style="width:800px;">
                            <div class="form-group">
                                <input type="button" onclick="queryConfigs();" value="查询配置项列表"/>
                            </div>
                        </form>
                        <hr/>
                        <h4>查询实验详情</h4>
                        <form role="form" style="width:800px;">
                            <div class="form-group">
                                <label for="configId">配置项ID</label>
                                <input type="text" class="form-control" value="" size="50" id="configId"/>
                            </div>
                            <div class="form-group">
                                <label for="queryResult">返回结果</label>
                                <div id="queryResult"></div>
                            </div>
                            <div class="form-group">
                                <input type="button" onclick="queryConfig();" value="查询实验详情"/>
                            </div>
                        </form>
                        <hr/>
                        <h4>保存配置</h4>
                        <form role="form" style="width:800px;">
                            <div class="form-group">
                                <label for="saveContent">配置信息</label>
                                <div id="saveContent"></div>
                            </div>
                            <div class="form-group">
                                <input type="button" onclick="saveConfig();" value="保存配置"/>
                            </div>
                        </form>
                        <hr/>
                        <h4>删除配置</h4>
                        <form role="form" style="width:800px;">
                            <div class="form-group">
                                <label for="delConfigId">配置项ID</label>
                                <input type="text" class="form-control" value="" size="50" id="delConfigId"/>
                            </div>
                            <div class="form-group">
                                <input type="button" onclick="deleteConfig();" value="删除配置"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
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
            window.open("/ant/conf/queryAllConfig.do", "_blank");
        }
        function queryConfig() {
            $.ajax({
                url: "/ant/conf/queryConfig.json",
                data: {
                    configId: $("#configId").val()
                },
                dataType: "text",
                success: function (result) {
                    //$("#queryResult").val(result);
                    queryResult.setText(result);
                }
            });
        }
        function saveConfig() {
            $.ajax({
                url: "/ant/conf/save",
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
                url: "/ant/conf/deleteTargetConf",
                data: {
                    antId: $("#delConfigId").val()
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
