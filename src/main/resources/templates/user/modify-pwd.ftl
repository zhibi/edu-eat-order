<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="user"/>
<#assign navTitle= '修改密码'/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
    <form id="user" class="mui-input-group" action="/user/modifyPwd" method="post">
        <div class="mui-input-row">
            <label>原密码</label>
            <input type="password" required name="pwd" class="mui-input-clear mui-input" placeholder="原密码">
        </div>
        <div class="mui-input-row">
            <label>新密码</label>
            <input name='pwd2' required type="password" class="mui-input-clear mui-input" >
        </div>
        <div class="mui-input-row">
            <label>确认密码</label>
            <input name='pwd3' required type="password" class="mui-input-clear mui-input" >
        </div>
    </form>

    <div class="mui-content-padded">
        <button style="padding:8px" form="user" type="submit" class="mui-btn mui-btn-block mui-btn-primary">修改</button>
    </div>
</div>
</body>
<script>
    var err = "${errorMessage!}";
    if (err.length > 0) {
        mui.alert(err, '提示');
    }
</script>
</html>