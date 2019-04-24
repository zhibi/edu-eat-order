<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="user"/>
<#assign navTitle= '个人信息'/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
    <form id="user" class="mui-input-group" action="/user/update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <div class="mui-input-row">
            <label>手机号</label>
            <input type="text" readonly class="mui-input-clear mui-input" placeholder="请输入账号" value="${user.phone}">
        </div>
        <div class="mui-input-row">
            <label>昵称</label>
            <input name='name' required type="text" class="mui-input-clear mui-input" value="${user.name!}">
        </div>
        <div class="mui-input-row">
            <label>微信</label>
            <input name='wx' required type="text" class="mui-input-clear mui-input" value="${user.wx!}">
        </div>
        <div class="mui-input-row">
            <label>邮箱</label>
            <input name='email' required type="email" class="mui-input-clear mui-input" value="${user.email!}">
        </div>
    </form>

    <div class="mui-content-padded">
        <button style="padding:8px" form="user" type="submit" class="mui-btn mui-btn-block mui-btn-primary">修改</button>
        <a  href="/logout" style="padding:8px"  type="button" class="mui-btn mui-btn-block mui-btn-primary">退出登录</a>
        <a href="/user/modifyPwd">修改密码</a>
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