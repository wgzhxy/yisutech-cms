<!DOCTYPE html>
<html lang="en">

<head>
    <!-- header -->
    <#include "/console/comm/header.html">
        <!-- DataTables CSS -->
        <link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
        <!-- DataTables Responsive CSS -->
        <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
        </head>
<body>
<div id="wrapper">
    <!-- menu -->
    <#include "/console/comm/menu.html">

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">设备白名单配置管理</span></h4>
            </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <!-- 扫码功能 -->
                        <div class="panel-heading"></div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover"
                                   id="dataTablesList">
                                <thead>
                                <tr>
                                    <th>名称</th>
                                    <th>类型</th>
                                    <th>状态</th>
                                    <th>修改时间</th>
                                    <th>发布时间</th>
                                    <th>结束时间</th>
                                    <th>分组</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list ants as ant>
                                    <tr class="gradeA">
                                        <td>${ant.antBase.name}</td>
                                        <td>
                                            <#if ant.antBase.type == "expt">
                                                AB实验
                                                <#elseif ant.antBase.type == "dy">
                                                    定投
                                                    <#elseif ant.antBase.type == "pub">
                                                        灰度
                                                        <#else>
                                            </#if>
                                        </td>
                                        <td>
                                            <#if ant.antBase.status == "publish">
                                                已发布
                                                <#elseif ant.antBase.status == "prepublish">
                                                    预发布
                                                    <#elseif ant.antBase.status == "release">
                                                        已转正
                                                        <#else>
                                            </#if>
                                        </td>
                                        <td>
                                            <#if ant.antBase.gmtModified?if_exists>${ant.antBase.gmtModified?datetime}
                                            </#if>
                                        </td>
                                        <td>
                                            <#if ant.antBase.begin?if_exists>${ant.antBase.begin?datetime}</#if>
                                        </td>
                                        <td>
                                            <#if ant.antBase.end?if_exists>${ant.antBase.end?datetime}</#if>
                                        </td>
                                        <td class="center">
                                            <!-- Single button -->
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-default dropdown-toggle"
                                                        data-toggle="dropdown">
                                                    分组选择 <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <#list ant.groups as group>
                                                    <li>
                                                        <a style="color: #0d6aad;background: #ade5ff" target="_blank"
                                                           href="../h5/scanPage.html?groupIds=${group.antGroup.id}">${group.antGroup.name}</a>
                                                        <form role="form">
                                                            <div class="form-group">
                                                                <label for="utdid_${group.antGroup.id}">设备ID</label>
                                                                <input type="text" class="form-control"
                                                                       id="utdid_${group.antGroup.id}"
                                                                       placeholder="请输入设备号(utdid)">
                                                            </div>
                                                            <button type="button" class="btn btn-default"
                                                                    onclick="saveAntGroup('${group.antGroup.id}');">
                                                                提交
                                                            </button>
                                                        </form>
                                                    </li>
                                                    </#list>
                                                </ul>
                                            </div>
                                        </td>
                                        <td>
                                            <!-- Single button -->
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-default dropdown-toggle"
                                                        data-toggle="dropdown">
                                                    清除白名单 <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li>
                                                        <form role="form">
                                                            <div class="form-group">
                                                                <label for="del_utdid_${ant.antBase.id}">设备ID</label>
                                                                <input type="text" class="form-control"
                                                                       id="del_utdid_${ant.antBase.id}"
                                                                       placeholder="请输入设备号(utdid)">
                                                            </div>
                                                            <button type="button" class="btn btn-default"
                                                                    onclick="deleteAntGroup('${ant.antBase.id}');">
                                                                清除
                                                            </button>
                                                        </form>
                                                    </li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                    </div>
                        <!-- panel-body -->
                </div>
            </div>
        </div>
            <!-- panel-default -->
        </div>
</div>

<!-- footer -->
<#include "/console/comm/footer.html">

    <!-- DataTables JavaScript -->
    <script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

    <script type="application/javascript">

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
                    $("#queryResult").val(result);
                }
            });
        }

        function saveAntGroup(groupId) {
            $.ajax({
                url: "/ant/whitelist/device/appendAntGroupByGroupId.json",
                type: "POST",
                data: {
                    deviceId: $("#utdid_" + groupId).val(),
                    antGroupIds: groupId
                },
                dataType: "text",
                success: function (result) {
                    alert(result);
                }
            });
        }

        function deleteAntGroup(antId) {
            $.ajax({
                url: "/ant/whitelist/device/deleteAntGroup.json",
                data: {
                    deviceId: $("#del_utdid_" + antId).val(),
                    antIds: antId
                },
                dataType: "text",
                success: function (result) {
                    alert(result);
                }
        });
        }
    </script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
        $(document).ready(function () {
            $('#dataTablesList').DataTable({
                responsive: true,
                "paginate": true,
                "sort": false
            });
        });
    </script>
</body>
</html>
