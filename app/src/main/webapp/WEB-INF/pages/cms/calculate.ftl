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
                <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">实验操作计算</span></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row"><div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
            </div>
            <div class="panel-body">
                <h4>Ant下发计算</h4>
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="deviceId">设备ID</label>
                        <input type="text" class="form-control" id="deviceId" placeholder="请输入设备ID">
                    </div>
                    <div class="form-group">
                        <label for="condition">条件</label>
                        <textarea class="form-control" rows="2" cols="80" id="condition"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="queryResult">返回结果</label>
                        <div id="queryResult"></div>
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="allocateAndTarget();" value="提交计算"/>
                    </div>
                </form>
                <hr/>
                <h4>Ant下发条件验证</h4>
                <form role="form" style="width:800px;">
                    <div class="form-group">
                        <label for="expression">表达式</label>
                        <textarea class="form-control" rows="2" cols="80" id="expression"
                                  placeholder="请输入条件表达式"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="condition_check">表达式变量集合</label>
                        <textarea class="form-control" rows="2" cols="80" id="condition_check"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="saveContent">返回结果</label>
                        <div id="saveContent"></div>
                    </div>
                    <div class="form-group">
                        <input type="button" onclick="checkCondition();" value="检查条件"/>
                    </div>
                </form>
            </div>
        </div>
        </div></div>
    </div>
</div>

<!-- footer -->
<#include "/console/comm/footer.html">

<script type="application/javascript">

    var retResult, retCheck;
    $(document).ready(function () {
        var options = {mode: 'view', modes: ['code', 'form', 'text']};
        retResult = new JSONEditor(document.getElementById('queryResult'), options);
        retCheck = new JSONEditor(document.getElementById('saveContent'), options);
    });

    function allocateAndTarget() {
        $.ajax({
            url: "/ant/cal/allocateAndTarget.json",
            data: {
                deviceId: $("#deviceId").val(),
                condition: $("#condition").val()
            },
            dataType: "text",
            success: function (result) {
                // create the editor
                retResult.setText(result);
                //$("#queryResult").val(resuuult);
            }
        });
    }

    function checkCondition() {
        $.ajax({
            url: "/ant/cal/allocateAndCondition.json",
            type: "POST",
            data: {
                condition: $("#condition_check").val(),
                expression: $("#expression").val()
            },
            dataType: "text",
            success: function (result) {
                retCheck.setText(result);
                //$("#saveContent").val(result);
            }
        });
    }
</script>

</body>

</html>
