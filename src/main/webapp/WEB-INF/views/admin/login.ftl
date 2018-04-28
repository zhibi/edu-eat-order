<!DOCTYPE html>
<html>
<#include "include/resource-head.ftl"/>
<body class="login-layout">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="center">
                        <h1>
                            <i class="icon-leaf green"></i>  <span
                                class="white">管理系统</span>
                        </h1>
                    </div>
                    <div class="space-6"></div>
                    <div class="position-relative">
                        <div id="login-box"
                             class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger">
                                        <i class="icon-coffee green"></i>登录信息
                                    </h4>
                                    <div class="space-6"></div>
                                    <form action="/admin/login" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                <input name="username" type="text" class="form-control"
                                                       placeholder="用户名"/>
                                                <i class="icon-user"></i>
												</span>
                                            </label>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input name="password" type="password" class="form-control"
                                                           placeholder="密码"/>
                                                    <i class="icon-lock"></i>
												</span>
                                            </label>

                                            <div class="space"></div>

                                            <div class="clearfix">
                                                <button type="submit"
                                                        class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="icon-key"></i>登&nbsp;&nbsp;录
                                                </button>
                                            </div>
                                            <div class="space-4"></div>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "include/resource-script.ftl"/>
</body>
</html>
