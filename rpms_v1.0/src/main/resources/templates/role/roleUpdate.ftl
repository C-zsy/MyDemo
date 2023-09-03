<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>角色更新</title>
    <style type="text/css" title="currentStyle" media="screen">
        @import url(../css/maincss1.css);
        @import url(../css/mainborder1.css);
    </style>
    <script src="../js/valentine.js" type="text/javascript"></script>
    <script src="../js/information.js" type="text/javascript"></script>
    <script src="../js/birthday.js" type="text/javascript"></script>
</head>

<body onload="startit();">
<input type="hidden" id="resource" value="${user.roleResource}">
<div id="icon">fourthfire</div>
<div id="userinfo">
    <h5>欢迎 ${user.roleName}</h5>
    <h5></h5>
    <h5><a href="index">注销</a></h5>
    <h5><a href="index">退出</a></h5>
    <h5>现在时间</h5>
    <h5 id="hours"></h5>
    <h5>:</h5>
    <h5 id="minutes"></h5>
    <h5>:</h5>
    <h5 id="seconds"></h5>

</div>
<div id="topicon"></div>
<div id="center">
    <div id="banner">
        <div id="topimg"></div>
        <ul id="bannerul">

            <div id="li0" style="display: none">
                <li class="bannerli" onmouseover="show(1);"><h5><a href="#">管理员管理</a></h5>
                    <ul class="bannerchild" id="banner1">
                        <li><a href="roleList">角色管理</a></li>
                        <li><a href="powerList">权限管理</a></li>
                        <li><a href="rolePowerList">角色权限管理</a></li>
                        <li><a href="userList">用户管理</a></li>
                    </ul>
                </li>
            </div>

            <div id="li1" style="display: none">
                <li class="bannerli" onmouseover="show(2);"><h5><a href="#">楼栋管理</a></h5>
                    <ul class="bannerchild" id="banner2">
                        <li><a href="buildAdd">增加楼栋</a></li>
                        <li><a href="queryBuildList?pageIndex=1&pageSize=3">删除楼栋</a></li>
                        <li><a href="queryBuildList?pageIndex=1&pageSize=3">查询楼栋</a></li>
                        <li><a href="queryBuildList?pageIndex=1&pageSize=3">修改楼栋</a></li>
                    </ul>
                </li>
            </div>

            <div id="li2" style="display: none">
                <li class="bannerli" onmouseover="show(3);"><h5><a href="#">房间管理</a></h5>
                    <ul class="bannerchild" id="banner3">
                        <li><a href="roomAdd">增加房间</a></li>
                        <li><a href="queryRoomList?pageIndex=1&pageSize=3">删除房间</a></li>
                        <li><a href="queryRoomList?pageIndex=1&pageSize=3">查询房间</a></li>
                        <li><a href="queryRoomList?pageIndex=1&pageSize=3">修改房间</a></li>
                    </ul>
                </li>
            </div>

            <div id="li3" style="display: none">
                <li class="bannerli" onmouseover="show(4);"><h5><a href="#">业主管理</a></h5>
                    <ul class="bannerchild" id="banner4">
                        <li><a href="ownerAdd">增加业主</a></li>
                        <li><a href="queryOwnerList?pageIndex=1&pageSize=5">修改业主</a></li>
                        <li><a href="queryOwnerList?pageIndex=1&pageSize=5">查询业主</a></li>
                        <li><a href="queryOwnerList?pageIndex=1&pageSize=5">删除业主</a></li>
                    </ul>
                </li>
            </div>

            <div id="li4" style="display: none">
                <li class="bannerli" onmouseover="show(5);"><h5><a href="#">业主成员</a></h5>
                    <ul class="bannerchild" id="banner5">
                        <li><a href="memberAdd">增加成员</a></li>
                        <li><a href="queryMemberList?pageIndex=1&pageSize=5">修改成员</a></li>
                        <li><a href="queryMemberList?pageIndex=1&pageSize=5">查询成员</a></li>
                        <li><a href="queryMemberList?pageIndex=1&pageSize=5">删除成员</a></li>
                    </ul>
                </li>
            </div>

            <div id="li5" style="display: none">
                <li class="bannerli" onmouseover="show(6);">
                    <h5><a href="#">收费项目</a></h5>
                    <ul class="bannerchild" id="banner6">
                        <li><a href="chargeAdd">增加项目</a></li>
                        <li><a href="updateCharge">修改项目</a></li>
                        <li><a href="queryChargeList?pageIndex=1&pageSize=3">查询项目</a></li>
                        <li><a href="chargeDelete">删除项目</a></li>
                    </ul>
                </li>
            </div>

            <div id="li6" style="display: none">
                <li class="bannerli" onmouseover="show(7);"><h5><a href="#">业主缴费</a></h5>
                    <ul class="bannerchild" id="banner7">
                        <li><a href="queryPayList?pageIndex=1&pageSize=5">业主缴费</a></li>
                        <li><a href="queryPayList?pageIndex=1&pageSize=5">缴费单查询</a></li>
                        <li><a href="queryPayList?pageIndex=1&pageSize=5">修改收费记录</a></li>
                        <li><a href="queryPayList?pageIndex=1&pageSize=5">删除缴费</a></li>
                    </ul>
                </li>
            </div>

            <div id="li7" style="display: none">
                <li class="bannerli" onmouseover="show(8);"><h5><a href="#">物资类别</a></h5>
                    <ul class="bannerchild" id="banner8">
                        <li><a href="typeAdd">添加物资类别</a></li>
                        <li><a href="typeUpdate1">修改物资类别</a></li>
                        <li><a href="queryTypeList?pageIndex=1&pageSize=3">查询物资类别</a></li>
                        <li><a href="typeDelete">删除物资类别</a></li>
                    </ul>
                </li>
            </div>

            <div id="li8" style="display: none">
                <li class="bannerli" onmouseover="show(9);"><h5><a href="#">物资设备</a></h5>
                    <ul class="bannerchild" id="banner9">
                        <li><a href="insertGoods">入库</a></li>
                        <li><a href="deleteGoods">出库</a></li>
                        <li><a href="queryGoodsList?pageIndex=1&pageSize=3">查询物资</a></li>
                        <li><a href="insertGoods">添加物资</a></li>
                        <li><a href="updateGoods1">修改物资</a></li>
                    </ul>
                </li>
            </div>

        </ul>
    </div>
    <div id="main">
        <form name="roleUpdate" method="post" action="roleUpdate" onsubmit="return checkrole()">
            <div id="index">
            </div>
            <div id="table">
                <table>
                    <caption>角色修改</caption>
                    <thead>
                    </thead>
                    <tbody>
                    <input type="hidden" name="roleId" value="${roleUpdate.roleId}">
                    <tr>
                        <td>角色名</td>
                        <td><input name="roleName" type="text" value="${roleName}"/></td>
                        <td>请输入中文或英文</td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="3">
                            <ul>
                                <li><input name="updateRole" type="submit" value="修改" class="button"
                                           onmouseout="this.className='button';"
                                           onmouseover="this.className='buttondown';"/></li>
                                <li><input name="roelselect" type="reset" value="重置" class="button"
                                           onmouseout="this.className='button';"
                                           onmouseover="this.className='buttondown';"/></li>
                            </ul>
                        </td>
                    </tr>
                    </tfoot>

                </table>
            </div>
        </form>
    </div>
    <div id="foot">
        <ul>
            <li><a href="welcome">首页</a></li>
            <li><a href="connectMang">联系管理员</a></li>
            <li><a href="project">项目说明</a></li>
            <li><a href="about">关于我们</a></li>
            <li><a href="onlinehelp">在线帮助</a></li>
        </ul>

    </div>
</div>

</body>
</html>
