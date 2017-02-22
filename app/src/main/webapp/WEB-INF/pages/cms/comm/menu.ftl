<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="../home/index.html?type=index">易速云内容管理系统 v1.0</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-tasks fa-fw"></i>
                <#if pubEnv == "online">
                    线上环境
                    <#elseif pubEnv == "pre">
                        预发环境
                        <#elseif pubEnv == "daily">
                            日常环境
                </#if>
                <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="http://abtest-daily.alibaba-inc.com" target="_blank"><i class="fa fa-align-left fa-fw"></i>
                    日常环境</a>
                </li>
                <li><a href="http://preabtest.alibaba-inc.com" target="_blank"><i class="fa fa-align-right fa-fw"></i>
                    预发环境</a>
                </li>
                <li><a href="http://abtest.alibaba-inc.com" target="_blank"><i class="fa fa-bars fa-fw"></i> 线上环境</a>
                </li>
            </ul>
            <!-- /.dropdown-tasks -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-bell fa-fw"></i> 消息<i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="#">
                        <div>
                            <i class="fa fa-comment fa-fw"></i> 评论
                            <span class="pull-right text-muted small">4 分钟前 </span>
                        </div>
                    </a>
                </li>
            </ul>
            <!-- /.dropdown-alerts -->
        </li>
        <!-- /.dropdown -->
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> 用户<i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户信息</a>
                </li>
                <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                </li>
                <li class="divider"></li>
                <li><a href="../home/loginOut.html"><i class="fa fa-sign-out fa-fw"></i> 注销</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="搜索...">
                        <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                    </div>
                    <!-- /input-group -->
                </li>
                <li>
                    <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 文档库<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="../home/charts.html?type=2"> 资源查询</a>
                        </li>
                        <li>
                            <a href="../home/charts.html?type=1"> 新增资源</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="../home/manageAntList.html?type=manageAntList"><i class="fa fa-edit fa-fw"></i> 工作流</a>
                </li>
                <li>
                    <a href="../home/manageAntList.html?type=manageAntList"><i class="fa fa-edit fa-fw"></i> 用户中心</a>
                </li>
                <li>
                    <a href="＃"><i class="fa fa-dashboard fa-fw"></i> 用户管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="../home/reports.html?type=reports"> 用户新增</a>
                        </li>
                        <li>
                            <a href="../home/autoReports.html?type=autoReports"> 用户组管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="../home/manageAntList.html?type=manageAntList"><i class="fa fa-edit fa-fw"></i> 角色管理</a>
                </li>
                <li>
                    <a href="../home/manageAntList.html?type=manageAntList"><i class="fa fa-edit fa-fw"></i> 字典管理</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i> 系统设置<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="../home/config.html?type=config"> 配置管理</a>
                        </li>
                        <li>
                            <a href="../home/resource.html?type=resource"> 字典管理</a>
                        </li>
                        <li>
                            <a href="../home/cache.html?type=cache"> 缓存管理</a>
                        </li>
                    </ul>
                    <!-- /.nav-second-level -->
                </li>
                <li>
                    <a href="＃"><i class="fa fa-dashboard fa-fw"></i> 机构/部门管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="../home/reports.html?type=reports"> 机构管理</a>
                        </li>
                        <li>
                            <a href="../home/autoReports.html?type=autoReports"> 部门管理</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="＃"><i class="fa fa-dashboard fa-fw"></i> 企业私有云同步<span class="fa arrow"></span></a>
                </li>
            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>