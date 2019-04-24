<!DOCTYPE html>
<html lang="en">
<#include "common/head.ftl"/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "common/header.ftl"/>
<div class="mui-content">
  <form id="register" class="mui-input-group" action="/register" method="post">
    <div class="mui-input-row">
      <label>手机号</label>
      <input name="phone" type="text" class="mui-input-clear mui-input" placeholder="请输入手机号">
    </div>
    <div class="mui-input-row">
      <label>昵称</label>
      <input name="name" v type="text" class="mui-input-clear mui-input" placeholder="请输入昵称">
    </div>
    <div class="mui-input-row">
      <label>密码</label>
      <input name='password' v type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
    </div>
    <div class="mui-input-row">
      <label>确认密码</label>
      <input name='password2' required type="password" class="mui-input-clear mui-input" placeholder="请输入确认密码">
    </div>
    <div class="mui-input-row">
      <label>验证码</label>
      <input name='verifyCode' required type="text" class="mui-input" style="    width: 100px;float: left;">
      <img src="/helper/verify" width="90px" height="40px" style="float: right" onclick="$(this).attr('src',$(this).attr('src')+'?ss='+Math.random())">
    </div>
  </form>

  <div class="mui-content-padded">
    <button style="padding:8px" form="register" type="submit" class="mui-btn mui-btn-block mui-btn-primary">注册
    </button>
    <div class="link-area"><a href="/login">登录</a></div>
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