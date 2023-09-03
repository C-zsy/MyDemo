<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎</title>
    <style type="text/css" title="currentStyle" media="screen">
        @import url(css/login.css);
    </style>
    <script language="javascript" type="text/javascript">
        function selectType() {
            var sele1 = document.getElementById("type1");
            var sele2 = document.getElementById("type2");
            var check1 = document.getElementById("check1");
            var check2 = document.getElementById("check2");
            if (check1.checked) {
                sele1.className = "style1down";
                sele2.className = "style2";
            } else if (check2.checked) {
                sele1.className = "style1";
                sele2.className = "style2down";
            } else {
                sele1.className = "style1";
                sele2.className = "style2";
            }
        }
    </script>
</head>

<body>
<div id="top"></div>
<div id="main">
    <form name="form" method="post" action="welcome">
        <div id="image"></div>
        <div id="login">
            <table>
                <tr>
                    <td><p id="loginname"></p></td>
                    <td><input name="userName" type="text" value="admin" class="textin"/></td>
                </tr>
                <tr>
                    <td><p id="password"></p></td>
                    <td><input name="userPassword" type="password" value="admin" class="textin"/></td>
                </tr>
                <tr>
                <tr>
                    <td>${msg}</td>
                </tr>
                <td colspan="2">
                    <input name="login" type="submit" value="" class="loginbutton"
                           onmouseover="this.className='loginbuttonover'" onmouseout="this.className='loginbutton'"
                           onmousedown="this.className='loginbuttondown'"/>
                    <input name="register" type="button" value=""  class="registerbutton"
                           onmouseover="this.className='registerbuttonover'"
                           onmouseout="this.className='registerbutton'"
                           onmousedown="this.className='registerbuttondown'" onclick="javascript: top.location.href='register' "/>

                </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<div id="foot">
</div>
</body>
</html>