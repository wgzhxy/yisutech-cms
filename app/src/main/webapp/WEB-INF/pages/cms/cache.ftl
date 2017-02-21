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
                <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">Tair缓存</span></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading"></div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <h4>MDB缓存</h4>
                        <form role="form" style="width:800px;">
                            <div class="form-group">
                                <label for="qKey">缓存KEY</label>
                                <input type="text" class="form-control" id="qKey" placeholder="请输入KEY">
                            </div>
                            <div class="form-group">
                                <label for="content">返回结果</label>
                                <div id="content"></div>
                            </div>
                            <div class="form-group">
                                <input type="button" onclick="queryCache();" value="查询缓存"/>
                            </div>
                        </form>
                        <hr/>

                        <h4>LDB缓存</h4>
                        <form role="form" style="width:800px;">
                            <div class="form-group">
                                <label for="lKey">缓存KEY</label>
                                <input type="text" class="form-control" id="lKey" placeholder="请输入KEY">
                            </div>
                            <div class="form-group">
                                <label for="lcontent">返回结果</label>
                                <div id="lcontent"></div>
                            </div>
                            <div class="form-group">
                                <input type="button" onclick="lqueryCache();" value="查询缓存"/>
                            </div>
                        </form>
                        <form role="form" style="width:800px;">
                            <div class="form-group">
                                <label for="ldelKey">缓存KEY</label>
                                <input type="text" class="form-control" id="ldelKey" placeholder="请输入KEY">
                            </div>
                            <div class="form-group">
                                <input type="button" onclick="linvalidCache();" value="失效缓存"/>
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

    var content, lcontent;
    $(document).ready(function () {
        var options = {mode: 'view', modes: ['code', 'form', 'text']};
        content = new JSONEditor(document.getElementById('content'), options);
        lcontent = new JSONEditor(document.getElementById('lcontent'), options);
    });

    function queryCache() {
        $.ajax({
            url: "/ant/cache/queryCache.json",
            data: {
                keys: $("#qKey").val()
            },
            dataType: "text",
            success: function (result) {
                //$("#content").val(result);
                content.setText(result);
            }
        });
    }

    function invalidCache() {
        $.ajax({
            url: "/ant/cache/invalidCache.json",
            data: {
                keys: $("#delKey").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function lqueryCache() {
        $.ajax({
            url: "/ant/cache/lqueryCache.json",
            data: {
                keys: $("#lKey").val()
            },
            dataType: "text",
            success: function (result) {
                lcontent.setText(result);
                //$("#lcontent").val(result);
            }
        });
    }

    function linvalidCache() {
        $.ajax({
            url: "/ant/cache/linvalidCache.json",
            data: {
                keys: $("#ldelKey").val()
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
