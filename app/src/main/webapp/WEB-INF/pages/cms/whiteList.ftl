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
                <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">设备白名单</span></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row"><div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading"></div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="qDeviceId">设备ID</label>
                        <input type="text" class="form-control" id="qDeviceId" style="size: 80px;"
                               placeholder="请输入设备ID">
                    </div>
                    <div class="form-group">
                        <label for="queryResult">返回结果</label>
                        <div id="queryResult"></div>
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="queryAntGroup();" value="查询设备白名单"/>
                    </div>
                </form>
                <hr/>
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="aDeviceId">设备ID</label>
                        <input type="text" class="form-control" id="aDeviceId" style="size: 80px;"
                               placeholder="请输入设备ID">
                    </div>
                    <div class="form-group">
                        <label for="queryResult">Ant分组</label>
                        <div id="content"></div>
                        <label>实&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;验:&nbsp;&nbsp;</label>
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="saveAntGroup();" value="追加分组"/>
                    </div>
                </form>
                <hr/>
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="dDeviceId">设备ID</label>
                        <input type="text" class="form-control" id="dDeviceId" style="size: 80px;"
                               placeholder="请输入设备ID">
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="deleteAntGroup();" value="清除分组"/>
                    </div>
                </form>
            </div>
            </div></div>
        </div>
    </div>
    <!-- /.panel-body -->
</div>
    <!-- footer -->
<#include "/console/comm/footer.html">
    <script type="application/javascript">

        var queryResult, content;
        $(document).ready(function () {
            var options = {mode: 'view', modes: ['code', 'form', 'text']};
            var optionsEdit = {mode: 'tree', modes: ['code', 'form', 'text', 'tree', 'view']};
            queryResult = new JSONEditor(document.getElementById('queryResult'), options);
            content = new JSONEditor(document.getElementById('content'), optionsEdit);
        });

        function queryWhiteList() {
            window.open("/ant/whitelist/device/queryDeviceIds.do", "_blank");
        }

        function queryAntGroups() {
            window.open("/ant/whitelist/device/queryAntGroups.do", "_blank");
        }

        function queryAntGroup() {
            $.ajax({
                url: "/ant/whitelist/device/queryAntGroup.json",
                data: {
                    deviceId: $("#qDeviceId").val()
                },
                dataType: "text",
                success: function (result) {
                    //$("#queryResult").val(result);
                    queryResult.setText(result);
                }
            });
        }

        function saveAntGroup() {
            $.ajax({
                url: "/ant/whitelist/device/appendAntGroup.json",
                type: "POST",
                data: {
                    deviceId: $("#aDeviceId").val(),
                    antGroups: content.getText()
                },
                dataType: "text",
                success: function (result) {
                    alert(result);
                }
            });
        }

        function deleteAntGroup() {
            $.ajax({
                url: "/ant/whitelist/device/deleteDeviceFromWhiteList.json",
                data: {
                    deviceId: $("#dDeviceId").val()
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
