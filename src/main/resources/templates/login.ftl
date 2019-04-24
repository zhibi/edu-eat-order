<!DOCTYPE html>
<html lang="en">
<#include "common/head.ftl"/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "common/header.ftl"/>
<div class="mui-content">
    <form id="login" class="mui-input-group" action="/login" method="post">
        <div class="mui-input-row">
            <label>手机号</label>
            <input name="phone" required type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
        </div>
        <div class="mui-input-row">
            <label>密码</label>
            <input name='password' required type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
        </div>
    </form>

    <div class="mui-content-padded">
        <button style="padding:8px" form="login" type="submit" class="mui-btn mui-btn-block mui-btn-primary">登录</button>
        <div class="link-area">
            <a href="/register">注册账号</a>
            <a href="#" onclick="mui.alert('请联系管理员','提示')">忘记密码</a>
        </div>
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