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
                    <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">Ant管理</span></h4>
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
                                                        <#elseif ant.antBase.status == "ready">
                                                            待发布
                                                            <#elseif ant.antBase.status == "pause">
                                                                暂停
                                                                <#elseif ant.antBase.status == "prepause">
                                                                    预发暂停
                                                                    <#elseif ant.antBase.status == "close">
                                                                        关闭
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
                                                    查看分组 <span class="caret"></span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <#list ant.groups as group>
                                                        <li style="margin-left: 10px;">
                                                            ${group.antGroup.name}
                                                            <#if group.antGroup.id?if_exists>
                                                                （${ant.antBase.id}/${group.antGroup.id})
                                                                <#else>
                                                                    ${group.antGroup.id}
                                                            </#if>
                                                        </li>
                                                    </#list>
                                                </ul>
                                            </div>
                                        </td>
                                        <td>
                                            <!-- Single button -->
                                            <div class="btn-group">
                                                <form role="form">
                                                    <#if ant.antBase.status == "publish">
                                                        <#if ant.type == "expt">
                                                            <button type="button" class="btn btn-default"
                                                                    style="background: #ade5ff;cursor:pointer"
                                                                    onclick="exptToDy('${ant.antBase.id}');">
                                                                转定投
                                                            </button>
                                                        </#if>
                                                        <button type="button" class="btn btn-default"
                                                                style="background: #ade5ff;cursor:pointer"
                                                                onclick="pause('${ant.antBase.id}');">
                                                            暂停
                                                        </button>
                                                        <button type="button" class="btn btn-default"
                                                                style="background: #ade5ff;cursor:pointer"
                                                                onclick="closeAnt('${ant.antBase.id}');">
                                                            结束
                                                        </button>
                                                        <#if pubEnv == "pre">
                                                            <button type="button" class="btn btn-default"
                                                                    style="background: #ade5ff;cursor:pointer"
                                                                    onclick="preToOnlineAnt('${ant.antBase.id}');">
                                                                同步线上
                                                            </button>
                                                        </#if>
                                                        <#elseif ant.antBase.status == "prepublish">
                                                            <button type="button" class="btn btn-default"
                                                                    style="background: #ade5ff;cursor:pointer"
                                                                    onclick="publish('${ant.antBase.id}');">
                                                                发布
                                                            </button>
                                                            <button type="button" class="btn btn-default"
                                                                    style="background: #ade5ff;cursor:pointer"
                                                                onclick="pause('${ant.antBase.id}');">
                                                                预发暂停
                                                        </button>
                                                        <button type="button" class="btn btn-default"
                                                                style="background: #ade5ff;cursor:pointer"
                                                                onclick="closeAnt('${ant.antBase.id}');">
                                                            结束
                                                        </button>
                                                            <#elseif ant.antBase.status == "release">
                                                            <button type="button" class="btn btn-default"
                                                                    style="background: #ade5ff;cursor:pointer"
                                                                    onclick="closeAnt('${ant.antBase.id}');">
                                                                结束
                                                            </button>
                                                                <#elseif ant.antBase.status == "ready">
                                                                    <#if pubEnv == "online">
                                                            <button type="button" class="btn btn-default"
                                                                    style="background: #ade5ff;cursor:pointer"
                                                                    onclick="previewPublishAnt('${ant.antBase.id}');">
                                                                预发布
                                                            </button>
                                                                    </#if>
                                                                    <button type="button" class="btn btn-default"
                                                                            style="background: #ade5ff;cursor:pointer"
                                                                            onclick="publish('${ant.antBase.id}');">
                                                                        发布
                                                                    </button>
                                                                    <button type="button" class="btn btn-default"
                                                                            style="background: #ade5ff;cursor:pointer"
                                                                            onclick="deleteAnt('${ant.antBase.id}');">
                                                                        删除
                                                                    </button>
                                                                    <#elseif ant.antBase.status == "pause" || ant.antBase.status == "prepause">
                                                                        <button type="button" class="btn btn-default"
                                                                                style="background: #ade5ff;cursor:pointer"
                                                                                onclick="restart('${ant.antBase.id}');">
                                                                            重启
                                                                        </button>
                                                                        <button type="button" class="btn btn-default"
                                                                                style="background: #ade5ff;cursor:pointer"
                                                                                onclick="closeAnt('${ant.antBase.id}');">
                                                                            结束
                                                                        </button>
                                                                        <#elseif ant.antBase.status == "close">
                                                                            <button type="button"
                                                                                    class="btn btn-default"
                                                                                    style="background: #ade5ff;cursor:pointer"
                                                                                    onclick="deleteAnt('${ant.antBase.id}');">
                                                                                删除
                                                                            </button>
                                                                            <#else>
                                                    </#if>
                                                </form>
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
    <script type="application/javascript">

        function publish(antId) {
            if (window.confirm('你确定发布实验吗？')) {
            $.ajax({
                url: "/ant/action/publish",
                data: {
                    antId: antId
                },
                dataType: "text",
                success: function (result) {
                    deallResult(result);
                }
            });
        }
        }

        function pause(antId) {
            if (window.confirm('你确定暂停实验吗？')) {
            $.ajax({
                url: "/ant/action/pause",
                data: {
                    antId: antId
                },
                dataType: "text",
                success: function (result) {
                    deallResult(result);
                }
            });
        }
        }

        function restart(antId) {
            if (window.confirm('你确定重发布实验吗？')) {
            $.ajax({
                url: "/ant/action/restart",
                data: {
                    antId: antId
                },
                dataType: "text",
                success: function (result) {
                    deallResult(result);
                }
            });
        }
        }

        function closeAnt(antId) {
            if (window.confirm('你确定结束实验吗？')) {
                $.ajax({
                    url: "/ant/action/close",
                    data: {
                        antId: antId
                    },
                    dataType: "text",
                    success: function (result) {
                        deallResult(result);
                    }
                });
        }
        }

        function deleteAnt(antId) {
            if (window.confirm('你确定删除实验吗？')) {
                $.ajax({
                    url: "/ant/action/delete",
                    data: {
                        antId: antId
                    },
                    dataType: "text",
                    success: function (result) {
                        deallResult(result);
                    }
                });
        }
        }

        function preToOnlineAnt(antId) {
            if (window.confirm('你确定同步实验配置吗？')) {
                $.ajax({
                    url: "/ant/action/preToOnlineAnt",
                    data: {
                        antId: antId
                    },
                    dataType: "text",
                    success: function (result) {
                        deallResult(result);
                    }
                });
            }
        }

        function previewPublishAnt(antId) {
            if (window.confirm('你确定同步实验配置吗？')) {
                $.ajax({
                    url: "/ant/action/previewPublishAnt",
                    data: {
                        antId: antId
                    },
                    dataType: "text",
                    success: function (result) {
                        deallResult(result);
                    }
                });
            }
        }

        function exptToDy(antId, groupId) {
            if (window.confirm('你确定同步实验配置吗？')) {
                $.ajax({
                    url: "/ant/action/exptToDy",
                    data: {
                        antId: antId,
                        groupId: groupId
                    },
                    dataType: "text",
                    success: function (result) {
                        deallResult(result);
                    }
                });
            }
        }

        function deallResult(result) {
            if (result != null) {
                var retObj = eval('(' + result + ')');
                if (retObj.success && retObj.ret == 0) {
                    window.location.reload();
            } else {
                    alert(retObj.msg);
            }
            } else {
                alert("请求异常，请联系管理员！");
            }
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
