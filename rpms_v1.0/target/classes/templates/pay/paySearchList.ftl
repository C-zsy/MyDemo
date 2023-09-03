<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>角色管理</title>
    <style type="text/css" title="currentStyle" media="screen">
        @import url(../css/maincss1.css);
        @import url(../css/mainborder1.css);
    </style>
    <script src="../js/valentine.js" type="text/javascript"></script>
    <script src="../js/information.js" type="text/javascript"></script>
    <script>
        function pageData(pageIndex) {
            document.getElementById("pageIndex").value = pageIndex;
            document.getElementById("pageSize").value = 3;
            // document.getElementById("form1").submit();
        }

        function clearData(pageSize) {
            location.href = 'queryPayList?pageIndex=1&amp;pageSize=' + pageSize;
        }

        function choosePageSize() {
            var v = document.getElementById("ps").value;
            // document.getElementById("pageSize").value = v;
            // document.getElementById("pageIndex").value = 1;
            location.href = 'queryPayList?pageIndex=1&pageSize=' + v.toString();
            // document.getElementById("form2").submit();

        }
    </script>
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
        <form name="form1" method="post" action="paySearchList?pageIndex=1&pageSize=5" onsubmit="return checkkey()">
            <span class="style3">查询条件：</span>
            <select name="oneway">
                <option value="0">--请选择--</option>
                <option value="1">收费项目名</option>
                <option value="２">用户名</option>
            </select>
            <input type="text" name="onetext" value="请输入关键字" id="txt1" onfocus="selectText();"/>
            <input type="submit" name="Submit" value="查询"/>
        </form>
        <form name="form2" method="post" action="payDelete" onsubmit="return befSubmit();">
            <div id="table">
                <table id="ec_table">
                    <caption>缴费单列表</caption>
                    <thead>
                    <tr>
                        <th>选中</th>
                        <th onclick="sortTable('ec_table',1,'string')">收费项目名</th>
                        <th onclick="sortTable('ec_table',2,'float')">应收金额</th>
                        <th onclick="sortTable('ec_table',3,'float')">实收金额</th>
                        <th onclick="sortTable('ec_table',4,'float')">欠费金额</th>
                        <th onclick="sortTable('ec_table',5,'string')">收费时间</th>
                        <th onclick="sortTable('ec_table',6,'string')">业主</th>
                        <th onclick="sortTable('ec_table',7,'string')">缴费状态</th>
                        <th onclick="sortTable('ec_table',8,'string')">缴费月份</th>
                        <th>修改缴费单</th>
                        <th>用户缴费</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list searchList as list>
                        <tr onmousemove="this.className='lightup';" onmouseout="this.className='lightdown';">
                            <td><input name="checkone" type="checkbox" value=""/></td>
                            <td>
                                <#if "${list.chargeId}" == 1>
                                    水电费
                                </#if>
                                <#if "${list.chargeId}" == 2>
                                    物业费
                                </#if>
                                <#if "${list.chargeId}" == 3>
                                    停车费
                                </#if>
                                <#if "${list.chargeId}" == 4>
                                    管理费
                                </#if>
                                <#if "${list.chargeId}" == 5>
                                    保护费
                                </#if>

                            </td>
                            <td>${list.payMoney}</td>
                            <td>${list.payReceive}</td>
                            <td>${list.payLack}</td>
                            <td>${list.payDate}</td>
                            <td>
                                <#if "${list.ownerId}" == 1001>
                                    setsuna
                                </#if>
                                <#if "${list.ownerId}" == 1002>
                                    kazusa
                                </#if>
                                <#if "${list.ownerId}" == 1003>
                                    koharu
                                </#if>
                                <#if "${list.ownerId}" == 1004>
                                    mari
                                </#if>
                                <#if "${list.ownerId}" == 1005>
                                    chiaki
                                </#if>
                            </td>
                            <td>
                                <#if "${list.payState}" == 0>
                                    未缴费
                                </#if>
                                <#if "${list.payState}" == 1>
                                    已缴费
                                </#if>
                            </td>
                            <td>
                                ${list.payMonth}
                            </td>
                            <td><a href="payUpdate">edit</a></td>
                            <td><a href="paySend">缴费</a></td>
                        </tr>
                    </#list>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td width="60">
                            <input onclick="javascript: top.location.href='queryPayList?pageIndex=1&pageSize=${pageSize}'"
                                   type="button" value="首页"/>
                        </td>
                        <td width="60">
                            <#if pageIndex!=1>
                                <input onclick="javascript: top.location.href='queryPayList?pageIndex=1&pageSize=${pageSize}'"
                                       type="button" value="上一页"/>
                            </#if>
                        </td>
                        <td width="60">
                            <#if pageIndex!=totalPage>
                                <input onclick="javascript: top.location.href='queryPayList?pageIndex=1&pageSize=${pageSize}'"
                                       type="button" value="下一页"/>
                            </#if>
                        </td>
                        <td width="60">
                            <input onclick="javascript: top.location.href='queryPayList?pageIndex=1&pageSize=${pageSize}'"
                                   type="button" value="尾页"/>
                        </td>
                        <td>总的数量:${totalCount}</td>
                        <td>当前页:${pageIndex}</td>
                        <td>总的页数:${totalPage}</td>
                        <td colspan="5">每页最大条数:
                            <select id="ps" onchange="choosePageSize()">
                                <option value="3" <#if pageSize == 3>selected="selected"</#if>>3</option>
                                <option value="5" <#if pageSize == 5>selected="selected"</#if>>5</option>
                                <option value="10" <#if pageSize == 10>selected="selected"</#if>>10</option>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="11">
                            <ul>
                                <li><input name="addnews" type="button" value="添加缴费"
                                           onclick="window.location='payAdd.html'" class="button"
                                           onmouseout="this.className='button';"
                                           onmouseover="this.className='buttondown';"/></li>
                                <li><input name="sumselect" type="button" value="全部选择" class="button"
                                           onmouseout="this.className='button';"
                                           onmouseover="this.className='buttondown';" onclick="checkAll();"/></li>
                                <li><input name="delete" type="submit" value="删除收费" class="button"
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

</body>
</html>
