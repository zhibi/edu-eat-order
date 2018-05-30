<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='businessAdd'/>
<body>
<#include "../include/common-top.ftl"/>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
    <#include "../include/common-menu.ftl"/>
        <div class="main-content">
            <div class="page-content">
                <div class="col-xs-12">
                    <div class="row-fluid">
                        <div class="widget-box">
                            <div class="widget-header widget-header-blue widget-header-flat">
                                <h4 class="lighter">
                                    <i class="icon-plus"></i>添加商家信息
                                </h4>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="step-content row-fluid position-relative">
                                        <form class="form-horizontal" action="/admin/business/save" method="post" enctype="multipart/form-data">
                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">登录名</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100" name="username"/>
                                                </div>
                                            </div><div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">商家名</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100" name="name"/>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label
                                                        class="col-xs-12 col-sm-3 control-label no-padding-right">联系方式</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100"  required name="phone" />
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">商家地址</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100" required name="address" />
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">配送费用</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100" required name="free" />
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">密码</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="password" class="width-100" required name="password"  />
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">商家公告</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <textarea  class="width-100" required name="notice"  ></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">展示图</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="file" id="icon" class="width-100" name="icons"/>
                                                </div>
                                            </div>


                                            <hr/>
                                            <div class="row-fluid wizard-actions">
                                                <button class="btn" type="reset">重置</button>
                                                <button class="btn btn-success" type="submit">提交</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.page-content -->
        </div>
        <!-- /.main-content -->
    </div>
    <!-- /.main-container -->
</body>
<#include "../include/resource-script.ftl"/>
<script type="text/javascript">
    uploadFile("icon",null);


</script>
</html>

