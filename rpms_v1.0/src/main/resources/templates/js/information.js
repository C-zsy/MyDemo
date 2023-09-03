function checkbuild() {
    var buildName = document.form1.buildName.value;
    if (buildName == null || buildName == "") {
        alert(buildName);
        alert("楼栋名不能为空！");
        document.form1.buildName.focus();
        return false;
    }
    var buildStart = document.form1.buildStart.value;
    if (buildStart == null || buildStart == "") {
        alert(buildName);
        alert("开工日期不能为空！请重新输入！");
        document.form1.buildStart.focus();
        return false;
    }
    var buildFinish = document.form1.buildFinish.value;
    if (buildFinish == null || buildFinish == "") {
        alert("竣工日期不能为空！请重新输入！");
        document.form1.buildFinish.focus();
        return false;
    } else if (buildFinish < buildStart) {
        alert("请确定竣工日期！");
        document.form1.buildFinish.focus();
        return false;
    } else if (buildFinish == buildStart) {
        alert("请确定竣工日期！");
        document.form1.buildFinish.focus();
        return false;
    }
    var buildLeak = document.form1.buildLeak.value;
    if (buildLeak == null || buildLeak == "") {
        alert("漏洞信息不能为空！");
        document.form1.buildLeak.focus();
        return false;
    }
    var buildArea = document.form1.buildArea.value;
    if (buildArea == null || buildArea == "") {
        alert("建筑面积不能为空！");
        document.form1.buildArea.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(buildArea)) {
        alert("建筑面积数据类型应该为浮点数！");
        document.form1.buildArea.focus();
        return false;
    }

}

function checkcharge() {
    var chargeName = document.form1.chargeName.value;
    if (chargeName == null || chargeName == "") {
        alert("收费项目名不能为空！");
        document.form1.chargeName.focus();
        return false;
    }
    var chargeUnit = document.form1.chargeUnit.value;
    if (chargeUnit == null || chargeUnit == "") {
        alert("收费标准不能为空！");
        document.form1.chargeUnit.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(chargeUnit)) {
        alert("收费标准的数据类型应该为浮点数！");
        document.form1.chargeUnit.focus();
        return false;
    }
}

function checkowner() {
    alert("213");
    var text1 = document.form1.ownerName.value;
    if (text1 == null || text1 == "" || (/\n\s*\r/).exec(text1)) {
        alert("姓名不能为空！请重新输入！");
        document.form1.ownerName.focus();
        return false;
    }
    var text2 = document.form1.ownerNative.value;
    if (text2 == null || text2 == "" || (/\n\s*\r/).exec(text2)) {
        alert("籍贯不能为空！请重新输入！");
        document.form1.native.focus();
        return false;
    }
    var text3 = document.form1.ownerPhone.value;
    if (text3 == null || text3 == "") {
        alert("联系电话不能为空！请重新输入！");
        document.form1.ownerPhone.focus();
        return false;
    }
    if (!(/\d{3}-\d{8}|\d{4}-\d{7}/).exec(text3) && !(/^[1-9]\d*$/).exec(text3)) {
        alert("联系电话不合法！");
        document.form1.ownerPhone.focus();
        return false;
    }
    var text4 = document.form1.ownerIden.value;
    if (text4 == null || text4 == "") {
        alert("身份证号不能为空！请重新输入！");
        document.form1.ownerIden.focus();
        return false;
    }
    if (!(/\d{15}|\d{18}/).exec(text4)) {
        alert("身份证号不合法！");
        document.form1.ownerIden.focus();
        return false;
    }
    var text5 = document.form1.ownerDen.value;
    if (text5 == null || text5 == "" || (/\n\s*\r/).exec(text5)) {
        alert("工作单位不能为空！请重新输入！");
        document.form1.ownerDen.focus();
        return false;
    }
    var text6 = document.form1.roomId.value;
    if (text6 == null || text6 == "") {
        alert("请选择房间！");
        document.form1.roomId.focus();
        return false;
    }
    var text7 = document.form1.roleId.value;
    if (text7 == null || text7 == "") {
        alert("请选择角色！");
        document.form1.roleId.focus();
        return false;
    }
}

function checkmember() {
    var text1 = document.form1.ownerId.value;
    if (text1 == null || text1 == "") {
        alert("请选择业主！");
        document.form1.ownerId.focus();
        return false;
    }
    var text2 = document.form1.memberName.value;
    alert("text2:" + text2);
    alert("memberName:" + memberName)
    if (text2 == null || text2 == "") {
        alert("姓名不能为空！请重新输入！");
        document.form1.memberName.focus();
        return false;
    }
    var text3 = document.form1.memberNative.value;
    if (text3 == null || text3 == "") {
        alert("籍贯不能为空！请重新输入！");
        document.form1.memberNative.focus();
        return false;
    }
    var text4 = document.form1.memberPhone.value;
    if (text4 == null || text4 == "") {
        alert("联系电话不能为空！请重新输入！");
        document.form1.memberPhone.focus();
        return false;
    }
    if (!(/\d{3}-\d{8}|\d{4}-\d{7}/).exec(text4) && !(/^[1-9]\d*$/).exec(text4)) {
        alert("联系电话不合法！");
        document.form1.memberPhone.focus();
        return false;
    }
    var text5 = document.form1.memberComp.value;
    if (text5 == null || text5 == "") {
        alert("工作单位不能为空！请重新输入！");
        document.form1.memberComp.focus();
        return false;
    }
}

function checktype() {
    var text1 = document.form1.name.value;
    if (text1 == null || text1 == "") {
        alert("类别名不能为空！请重新输入！");
        document.form1.name.focus();
        return false;
    }
}

function checkpayadd() {
    var text1 = document.form1.chargeId.value;
    if (text1 == null || text1 == "") {
        alert("请选择收费项目！");
        document.form1.chargeId.focus();
        return false;
    }
    var text2 = document.form1.payMoney.value;
    if (text2 == null || text2 == "") {
        alert("应收金额不能为空！请重新输入！");
        document.form1.payMoney.focus();
        return false;
    }
    if (!(/^\d+\.\d*$/).exec(text2)) {
        alert("应收金额格式不合法！");
        document.form1.payMoney.focus();
        return false;
    }
    var text3 = document.form1.payReceive.value;
    if (text3 == null || text3 == "") {
        alert("实收金额不能为空！请重新输入！");
        document.form1.payReceive.focus();
        return false;
    }
    if (text3 != 0.0) {
        alert("实收金额不正确！");
        document.form1.payReceive.focus();
        return false;
    }
    var text4 = document.form1.payLack.value;
    if (text4 == null || text4 == "") {
        alert("欠费金额不能为空！请重新输入！");
        document.form1.payLack.focus();
        return false;
    }
    if (text4 != text2) {
        alert("欠费金额不正确！");
        document.form1.payLack.focus();
        return false;
    }
    var text5 = document.form1.payDate.value;
    if (text5 == null || text5 == "") {
        alert("缴费日期不能为空！请重新输入！");
        document.form1.payDate.focus();
        return false;
    }
    var text6 = document.form1.ownerId.value;
    if (text6 == null || text6 == "") {
        alert("请选择业主！");
        document.form1.ownerId.focus();
        return false;
    }
    var text7 = document.form1.payState.value;
    if (text7 != 0) {
        confirm("请确定业主是否已缴费！");
        document.form1.payState.focus();
        return false;
    }
    var text8 = document.form1.payMonth.value;
    if (text8 == null || text8 == "") {
        alert("缴费月份不能为空！请重新输入！");
        document.form1.payMonth.focus();
        return false;
    }
}

function checkpaysend() {
    var text1 = document.form1.payMoney.value;
    if (text1 == null || text1 == "") {
        alert("应收金额不能为空！请重新输入！");
        document.form1.payMoney.focus();
        return false;
    }
    if (!(/^\d+\.\d*$/).exec(text1)) {
        alert("应收金额格式不合法！");
        document.form1.payMoney.focus();
        return false;
    }
    var text2 = document.form1.payReceive.value;
    if (text2 == null || text2 == "") {
        alert("实收金额不能为空！请重新输入！");
        document.form1.payReceive.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(text2)) {
        alert("实收金额格式不合法！");
        document.form1.payReceive.focus();
        return false;
    }
    if (text2 < text1) {
        alert("实收金额不正确！");
        document.form1.payReceive.focus();
        return false;
    }
    var text3 = document.form1.payLack.value;
    if (text3 == null || text3 == "") {
        alert("欠费金额不能为空！请重新输入！");
        document.form1.payLack.focus();
        return false;
    }
    if (text3 != 0.0) {
        alert("欠费金额不正确！");
        document.form1.payLack.focus();
        return false;
    }
    var text4 = document.form1.payDate.value;
    if (text4 == null || text4 == "") {
        alert("缴费日期不能为空！请重新输入！");
        document.form1.payDate.focus();
        return false;
    }
    var text5 = document.form1.payState.value;
    if (text5 != 1) {
        alert("请确定业主是否未缴费！");
        document.form1.payState.focus();
        return false;
    }
}

function checkpayupdate() {
    var text1 = document.form1.payMoney.value;
    if (text1 == null || text1 == "") {
        alert("应收金额不能为空！请重新输入！");
        document.form1.payMoney.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(text1)) {
        alert("应收金额格式不合法！");
        document.form1.payMoney.focus();
        return false;
    }
    var text2 = document.form1.payReceive.value;
    if (text2 == null || text2 == "") {
        alert("实收金额不能为空！请重新输入！");
        document.form1.payReceive.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(text2)) {
        alert("实收金额格式不合法！");
        document.form1.payReceive.focus();
        return false;
    }
    var text3 = document.form1.payLack.value;
    if (text3 == null || text3 == "") {
        alert("欠费金额不能为空！请重新输入！");
        document.form1.payLack.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(text3)) {
        alert("欠费金额格式不合法！");
        document.form1.payLack.focus();
        return false;
    }
}

function checkmaterialadd() {
    var text1 = document.form1.materialName.value;
    if (text1 == null || text1 == "") {
        alert("物资名称不能为空！请重新输入！");
        document.form1.materialName.focus();
        return false;
    }
    var text2 = document.form1.materialCount.value;
    if (text2 == null || text2 == "") {
        alert("物资数量不能为空！请重新输入！");
        document.form1.materialCount.focus();
        return false;
    }
    var text3 = document.form1.materialPrice.value;
    if (text3 == null || text3 == "") {
        alert("单价不能为空！请重新输入！");
        document.form1.materialPrice.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(text3)) {
        alert("单价格式不正确！");
        document.form1.materialPrice.focus();
        return false;
    }
    var text4 = document.form1.typeId.value;
    if (text4 == null || text4 == "") {
        alert("请选择物资类别！");
        document.form1.typeId.focus();
        return false;
    }
    var text5 = document.form1.materialInDate.value;
    if (text5 == null || text5 == "") {
        alert("入库日期不能为空！请重新输入！");
        document.form1.materialInDate.focus();
        return false;
    }
    var text6 = document.form1.materialOutDate.value;
    if (text6 == null || text6 == "") {
        alert("出库日期不能为空！请重新输入！");
        document.form1.materialOutDate.focus();
        return false;
    }
    var text7 = document.form1.materialStat.value;
    if (text7 != 1) {
        alert("请确定物资是否出库！");
        document.form1.materialStat.focus();
        return false;
    }

    function checkmaterialadd() {
        var text1 = document.form1.materialName.value;
        if (text1 == null || text1 == "") {
            alert("物资名称不能为空！请重新输入！");
            document.form1.materialName.focus();
            return false;
        }
        var text2 = document.form1.materialCount.value;
        if (text2 == null || text2 == "") {
            alert("物资数量不能为空！请重新输入！");
            document.form1.materialCount.focus();
            return false;
        }
        var text3 = document.form1.materialPrice.value;
        if (text3 == null || text3 == "") {
            alert("单价不能为空！请重新输入！");
            document.form1.materialPrice.focus();
            return false;
        } else if (!(/^\d+\.\d*$/).exec(text3)) {
            alert("单价格式不正确！");
            document.form1.materialPrice.focus();
            return false;
        }
        var text4 = document.form1.typeId.value;
        if (text4 == null || text4 == "") {
            alert("请选择物资类别！");
            document.form1.typeId.focus();
            return false;
        }
        var text5 = document.form1.materialInDate.value;
        if (text5 == null || text5 == "") {
            alert("入库日期不能为空！请重新输入！");
            document.form1.materialInDate.focus();
            return false;
        }
        var text6 = document.form1.materialOutDate.value;
        if (text6 == null || text6 == "") {
            alert("出库日期不能为空！请重新输入！");
            document.form1.materialOutDate.focus();
            return false;
        }
        var text7 = document.form1.materialStat.value;
        if (text7 != 1) {
            alert("请确定物资是否出库！");
            document.form1.materialStat.focus();
            return false;
        } else if (text5 != text6) {
            alert("请确定物资出库日期或物资是否出库！");
            document.form1.materialStat.focus();
            return false;
        }

    }
}

function checkmaterialupdate() {
    var text1 = document.form1.name.value;
    if (text1 == null || text1 == "") {
        alert("物资名称不能为空！请重新输入！");
        document.form1.name.focus();
        return false;
    }
    var text2 = document.form1.count.value;
    if (text2 == null || text2 == "") {
        alert("物资数量不能为空！请重新输入！");
        document.form1.count.focus();
        return false;
    }
    var text3 = document.form1.price.value;
    if (text3 == null || text3 == "") {
        alert("单价不能为空！请重新输入！");
        document.form1.price.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(text3)) {
        alert("单价格式不正确！");
        document.form1.price.focus();
        return false;
    }
    var text4 = document.form1.InDate.value;
    if (text4 == null || text4 == "") {
        alert("入库日期不能为空！请重新输入！");
        document.form1.InDate.focus();
        return false;
    }
    var text5 = document.form1.OutDate.value;
    if (text5 == null || text5 == "") {
        alert("出库日期不能为空！请重新输入！");
        document.form1.OutDate.focus();
        return false;
    }
    var text6 = document.form1.stat.value;
    if ((text4 == text5) && text6 == 0) {
        alert("请确定物资出库日期或物资是否出库！");
        document.form1.stat.focus();
        return false;
    } else if ((text4 != text5) && text6 == 1) {
        alert("请确定物资出库日期或物资是否出库！");
        document.form1.stat.focus();
        return false;
    } else if (text4 > text5) {
        alert("请确定物资出库日期！");
        document.form1.stat.focus();
        return false;
    }
}

function checkkey() {
    var oneway = document.forms[0].oneway.value;
    if (oneway == 0) {
        alert("请选择搜索类型！");
        document.forms[0].oneway.focus();
        return false;
    }
    var onetext = document.forms[0].onetext.value;
    if (onetext == null || onetext == "") {
        alert("请输入关键字！");
        document.forms[0].onetext.focus();
        return false;
    } else if (!(/[\u4e00-\u9fa5]/).exec(onetext) && !(/^\w+$/).exec(onetext) && !(/^\d+\.\d*$/).exec(onetext)) {
        alert("关键字格式不正确！");
        document.form1.onetext.focus();
        return false;
    }
}

function checkroom() {
    var buildid = document.form1.buildId.value;
    if (buildid == null || buildid == "") {
        alert("请选择楼栋！");
        document.form1.buildId.focus();
        return false;
    }

    var roomname = document.form1.roomName.value;
    if (roomname == null || roomname == "") {
        alert("房间名不能为空！");
        document.form1.roomName.focus();
        return false;
    }
    var roomdate = document.form1.roomDate.value;
    if (roomdate == null || roomdate == "") {
        alert("时间不能为空！");
        document.form1.roomDate.focus();
        return false;
    }

    var roomtype = document.form1.roomType.value;
    if (roomtype == null || roomtype == "") {
        alert("房型不能为空！");
        document.form1.roomType.focus();
        return false;
    }
    var roomarea = document.form1.roomArea.value;
    if (roomarea == null || roomarea == "") {
        alert("面积不能为空！");
        document.form1.roomArea.focus();
        return false;
    } else if (!(/^\d+\.\d*$/).exec(roomarea)) {
        alert("面积要是浮点数！");
        document.form1.roomArea.focus();
        return false;
    }
    var roomPercent = document.form1.roomPercent.value;
    if (roomPercent == null || roomPercent == "") {
        alert("得房率不能为空！");
        document.form1.roomPercent.focus();
        return false;
    } else if (roomPercent <= 0.0 || roomPercent >= 1.0) {
        alert("得房率要是大于0小于1的数！");
        document.form1.roomPercent.focus();
        return false;
    }
}

function checkpower() {
    var powername = document.form1.powerName.value;
    if (powername == null || powername == "") {
        alert("权限名不能为空！请填写！");
        document.form1.powerName.focus();
        return false;
    }
}

function checkrole() {
    var rolename = document.form1.roleName.value;
    if (rolename == null || rolename == "") {
        alert("角色名不能为空！请填写！");
        document.form1.roleName.focus();
        return false;
    }
}

function auth() {

    var username = document.form1.userName.value;
    //用户名验证
    if (username == null || username == "") {
        alert("很抱歉,用户名不能为空，请重新输入！");
        document.forms[0].userName.focus();
        return false;
    }

    //密码验证
    var pass = document.forms[0].pass.value;
    var passlength = document.forms[0].pass.value.length;
    if (pass == null || pass == "") {
        alert("很抱歉，密码不能为空，请重新输入！");
        document.forms[0].pass.focus();
        return false;
    }
    if (passlength < 6) {
        alert("很抱歉，密码不能少于6位，请重新输入！");
        document.forms[0].pass.focus();
        return false;
    }
    //业主号验证
    var ownerId = document.forms[0].ownerId.value;
    if (ownerId == null || ownerId == "") {
        alert("很抱歉，业主号不能为空，请重新输入！");
        document.forms[0].ownerId.focus();
        return false;
    }
}