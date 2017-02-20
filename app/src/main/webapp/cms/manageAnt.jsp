<!DOCTYPE html>
<html lang="en">

<head>
    <!-- header -->
    <#include "/console/comm/header.html">
</head>

<body>

<div id="wrapper">
    <!-- menu -->
    <#include "/console/comm/menu.html">

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">实验操作</span></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <div class="row"><div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <input type="button" onclick="query();" value="查询实验列表"/>
                <form>
                    <ul>
                        <li><span>实验ID: &nbsp;&nbsp;&nbsp;</span><input id="antId" type="text" value="" size="50"/></li>
                        <Li><span>返回结果: </span><textarea rows="2" cols="80" id="queryResult"></textarea></Li>
                        <li><input type="button" onclick="queryAnt()" value="查询实验详情"/></Li>
                    </ul>
                </form>
                <form>
                    <textarea rows="2" cols="80" id="saveContent"></textarea>
                    <input type="button" onclick="saveAnt()" value="保存实验"/>
                </form>
                <form>
                    <span>实验ID</span>
                    <input type="text" value="" size="50" id="pubAntId"/>
                    <input type="button" onclick="publish();" value="发布实验"/>
                </form>
                <form>
                    <span>实验ID</span>
                    <input type="text" value="" size="50" id="pauseAntId"/>
                    <input type="button" onclick="pause();" value="暂停实验"/>
                </form>
                <form>
                    <span>实验ID</span>
                    <input type="text" value="" size="50" id="restartAntId"/>
                    <input type="button" onclick="restart();" value="重启实验"/>
                </form>
                <form>
                    <span>实验ID</span>
                    <input type="text" value="" size="25" id="releaseAntId"/>
                    <span>分组ID</span>
                    <input type="text" value="" size="13" id="releaseGroupId"/>
                    <input type="button" onclick="release()" value="转正实验"/>
                </form>
                <form>
                    <span>实验ID</span>
                    <input type="text" value="" size="50" id="closeAntId"/>
                    <input type="button" onclick="closeAnt();" value="结束实验"/>
                </form>
                <form>
                    <span>实验ID</span>
                    <input type="text" value="" size="50" id="delAntId"/>
                    <input type="button" onclick="deleteAnt();" value="删除实验"/>
                </form>
                <form>
                    <span>实验ID</span>
                    <input type="text" value="" size="50" id="preAntId"/>
                    <input type="button" onclick="preToOnlineAnt();" value="发布到线上"/>
                </form>
            </div>
        </div>
        </div></div>
    </div>
</div>

<!-- footer -->
<#include "/console/comm/footer.html">

<script type="application/javascript">
    function query() {
        window.open("/ant/base/queryAllAnt.do?currentUser=75769", "_blank");
    }
    function saveAnt() {
        $.ajax({
            url: "/ant/base/save",
            type: "GET",
            data: {
                config: $("#saveContent").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
    function publish() {
        $.ajax({
            url: "/ant/action/publish",
            data: {
                antId: $("#pubAntId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
    function release() {
        $.ajax({
            url: "/ant/action/release",
            data: {
                antId: $("#releaseAntId").val(),
                groupId: $("#releaseGroupId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
    function pause() {
        $.ajax({
            url: "/ant/action/pause",
            data: {
                antId: $("#pauseAntId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
    function restart() {
        $.ajax({
            url: "/ant/action/restart",
            data: {
                antId: $("#restartAntId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
    function closeAnt() {
        $.ajax({
            url: "/ant/action/close",
            data: {
                antId: $("#closeAntId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
    function deleteAnt() {
        $.ajax({
            url: "/ant/action/delete",
            data: {
                antId: $("#delAntId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function preToOnlineAnt() {
        $.ajax({
            url: "/ant/action/preToOnlineAnt",
            data: {
                antId: $("#preAntId").val()
            },
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function queryAnt() {
        $.ajax({
            url: "/ant/base/queryAnt",
            data: {
                antId: $("#antId").val()
            },
            dataType: "text",
            success: function (result) {
                $("#queryResult").val(result);
            }
        });
    }
</script>
</body>

</html>
