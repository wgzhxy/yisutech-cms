<!DOCTYPE html>
<html lang="en">

<head>
    <!-- header -->
    <#include "/console/comm/header.html">
        </head>

<body>
<script>
    with (document)with (body)with (insertBefore(createElement("script"), firstChild))setAttribute("exparams", "category=&userid=&aplus&yunid=&&trid=0bb0beaf14792012159683753e&asid=AQAAAAC/0SpY6zfgPQAAAABhLkqoX5y7LA==", id = "tb-beacon-aplus", src = (location > "https" ? "//g" : "//g") + ".alicdn.com/alilog/mlog/aplus_v2.js")
</script>
<div id="wrapper">
    <!-- menu -->
    <#include "/console/comm/menu.html">

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h4 class="page-header"><span style="color:darkgray; font-family:微软雅黑">个人视图</span></h4>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-wrapper -->
</div>
<!-- footer -->
<#include "/console/comm/footer.html">
    <script>
        $("#but2").click(function () {
            $.ajax({
                url: "/ant/conf/queryConfig.jsonp",
                data: {
                    configId: 1
                },
                type: "get",
                async: false,
                dataType: "jsonp",
                success: function (json) {
                    alert(json.success);
                },
                error: function (e) {
                    alert("error" + e);
                }
            });
        });
    </script>

</body>
</html>
