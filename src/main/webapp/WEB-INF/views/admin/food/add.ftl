<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='foodAdd'/>
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
                                    <i class="icon-plus"></i>添加餐品
                                </h4>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="step-content row-fluid position-relative">
                                        <form class="form-horizontal" action="/admin/food/save" method="post"
                                              enctype="multipart/form-data" >
                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">餐品名称</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100" name="name" required/>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label
                                                        class="col-xs-12 col-sm-3 control-label no-padding-right">餐品原价</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100 double" name="oldprice"/>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label
                                                        class="col-xs-12 col-sm-3 control-label no-padding-right">餐品价钱</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="text" class="width-100 double" name="price" required/>
                                                </div>
                                            </div>
                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">状态</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <select class="width-100 " name="status">
                                                        <option value="0">上架</option>
                                                        <option value="1">下架</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">分类</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <select class="width-100" name="category" >
                                                        <#list categoryList as item>
                                                            <option value="${item.name}" >${item.name}</option>
                                                        </#list>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">添加展示图</label>
                                                <div class="col-xs-12 col-sm-5">
                                                    <input type="file" id="icon" class="width-100" name="icons" multiple/>
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <label class="col-xs-12 col-sm-3 control-label no-padding-right">描述</label>
                                                <div class="col-xs-12 col-sm-5">
														<textarea class="autosize-transition form-control" name="descript"></textarea>
                                                </div>
                                            </div>

                                            <div class="form-group has-info">
                                                <div class="col-xs-1"></div>
                                                <div class="col-xs-12 col-sm-10">
                                                    <textarea id="editor" name="content" style="width: 100%;"></textarea>
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
    uploadMostFile("icon");
    uploadFile("img",null);


</script>
</html>

