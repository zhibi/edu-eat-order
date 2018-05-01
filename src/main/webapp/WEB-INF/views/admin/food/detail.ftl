<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='foodList'/>
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
                                    <i class="icon-leaf"></i>修改餐品
                                </h4>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="step-content row-fluid position-relative">
                                        <form class="form-horizontal" action="/admin/food/updateFood" method="post"
                                              enctype="multipart/form-data" >
                                            <input type="hidden" name="id" value="${food.id!}"/>
                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">餐品名称</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100" name="name" required
                                                           value="${food.name!}"/>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label
                                                        class="col-xs-12 col-sm-3 control-label no-padding-right">餐品原价</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100 double" name="oldprice" value="${food.oldprice!}"/>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label
                                                        class="col-xs-12 col-sm-3 control-label no-padding-right">餐品价钱</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100 double" name="price" required
                                                           value="${food.price?string('#0.00')}"/>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">状态</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <select class="width-95 " name="status">
                                                        <option value="0"
                                                                <#if food.status??&&food.status==0>selected="selected"</#if>>
                                                            上架
                                                        </option>
                                                        <option value="1"
                                                                <#if food.status??&&food.status==1>selected="selected"</#if>>
                                                            下架
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">所属分类</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <select class="width-95" name="category" >
                                                    <#list categoryList as item>
                                                        <option value="${item.name}" <#if food.category == item.name>selected</#if>>${item.name}</option>
                                                    </#list>
                                                    </select>
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
    uploadFile("icon",<#if food.icon??>"${food.icon!}"<#else>null</#if>);

</script>
</html>

