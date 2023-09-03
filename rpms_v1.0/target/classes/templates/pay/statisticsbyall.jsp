<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色管理</title>
<style type="text/css" title="currentStyle" media="screen">
     @import url(../css/maincss1.css);
	 @import url(../css/mainborder1.css);
</style>
<script src="../js/valentine.js" type="text/javascript"></script>
<script src="../js/information.js" type="text/javascript"></script>
</head>

<body onload="startit();">
<div id="icon">fourthfire</div>
<div id="userinfo">
<h5>欢迎</h5>
<h5></h5>
<h5><a href="../Out.do">注销</a></h5>
<h5><a href="../Out.do">退出</a></h5>
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

<li class="bannerli" onmouseover="show(1);"><h5><a href="#">管理员管理</a></h5>
<ul class="bannerchild" id="banner1">
<li><a href="../role/roleList.html">角色管理</a></li>
<li><a href="../power/PowerList.do">权限管理</a></li>
<li><a href="../rp/rolePowerList.html">角色权限管理</a></li>
<li><a href="../user/userList.html">用户管理</a></li>
<li><a href="../backup/backup.html">数据管理</a></li>
</ul>
</li>

<li class="bannerli" onmouseover="show(2);"><h5><a href="#" >楼栋管理</a></h5>
<ul class="bannerchild" id="banner2">
<li><a href="../build/buildAdd.html">增加楼栋</a></li>
<li><a href="../build/buildList.html">删除楼栋</a></li>
<li><a href="../build/buildList.html">查询楼栋</a></li>
<li><a href="../build/buildList.html">修改楼栋</a></li>
</ul>
</li>
<li class="bannerli" onmouseover="show(3);"><h5><a href="#">房间管理</a></h5>
<ul class="bannerchild" id="banner3">
<li><a href="../room/roomAdd.html">增加房间</a></li>
<li><a href="../room/roomList.html">删除房间</a></li>
<li><a href="../room/roomList.html">查询房间</a></li>
<li><a href="../room/roomList.html">修改房间</a></li>
</ul>
</li>
<li class="bannerli" onmouseover="show(4);"><h5><a href="#">业主管理</a></h5>
<ul class="bannerchild" id="banner4">
<li><a href="../owner/ownerAdd.ftl">增加业主</a></li>
<li><a href="../owner/ownerList.ftl">修改业主</a></li>
<li><a href="../owner/ownerList.ftl">查询业主</a></li>
<li><a href="../owner/ownerList.ftl">删除业主</a></li>
</ul>
</li>
<li class="bannerli" onmouseover="show(5);"><h5><a href="#">业主成员</a></h5>
<ul class="bannerchild" id="banner5">
<li><a href="../member/memberAdd.ftl">增加成员</a></li>
<li><a href="../member/memberList.ftl">修改成员</a></li>
<li><a href="../member/memberList.ftl">查询成员</a></li>
<li><a href="../member/memberList.ftl">删除成员</a></li>
</ul>
</li>
<li class="bannerli" onmouseover="show(6);">
<h5><a href="#">收费项目</a></h5>
<ul class="bannerchild" id="banner6">
<li><a href="../charge/chargeAdd.html">增加项目</a></li>
<li><a href="../charge/chargeList.html">修改项目</a></li>
<li><a href="../charge/chargeList.html">查询项目</a></li>
<li><a href="../charge/chargeList.html">删除项目</a></li>
</ul>
</li>
<li class="bannerli" onmouseover="show(7);"><h5><a href="#">业主缴费</a></h5>
<ul class="bannerchild" id="banner7">
<li><a href="../pay/PayList.do">业主缴费</a></li>
<li><a href="../pay/PayList.do">缴费单查询</a></li>
<li><a href="../pay/PayList.do">修改收费记录</a></li>
<li><a href="../pay/PreStat.do">缴费统计</a></li>
<li><a href="../pay/PayList.do">删除缴费</a></li>
</ul>
</li>

<li class="bannerli" onmouseover="show(8);"><h5><a href="#">物资类别</a></h5>
<ul class="bannerchild" id="banner8">
<li><a href="../type/TypePreAdd.do">添加物资类别</a></li>
<li><a href="../type/TypeList.do">修改物资类别</a></li>
<li><a href="../type/TypeList.do">查询物资类别</a></li>
<li><a href="../type/TypeList.do">删除物资类别</a></li>
</ul>
</li>

<li class="bannerli" onmouseover="show(9);"><h5><a href="#">物资设备</a></h5>
<ul class="bannerchild" id="banner9">
<li><a href="../material/MaterialPreAdd.do">入库</a></li>
<li><a href="../material/MaterialList.do">出库</a></li>
<li><a href="../material/MaterialList.do">查询物资</a></li>
<li><a href="../material/MaterialPreAdd.do">添加物资</a></li>
<li><a href="../material/MaterialList.do">修改物资</a></li>
<li><a href="../material/MaterialList.do">删除物资</a></li>
</ul>
</li>

</ul>
</div>
<div id="main">
<form name="form" method="post" action="PreStat.do">
<div id="index">
 </div>
<div id="table">
<table>
<caption>添加收费单</caption>
<thead>
</thead>
<tbody>
<tr>
<td>
<img src=${filePath } width=500 height=300 border=0 usemap=${filename }/>
</td>
</tr>

</tbody>
<tfoot>
               <tr>
                 <td colspan="1">
                  <ul>
                     <li><input name="addnews" type="button" value="返回"  class="button" onmouseout="this.className='button';" onmouseover="this.className='buttondown';" onclick="window.location='PreStat.do'"/></li>
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
<li><a href="../welcome.jsp">首页</a></li>
<li><a href="../connectMang.jsp">联系管理员</a></li>
<li><a href="../project.jsp">项目说明</a></li>
<li><a href="../about.jsp">关于我们</a></li>
<li><a href="../onlinehelp.jsp">在线帮助</a></li>
</ul>

</div>

</body>
</html>
