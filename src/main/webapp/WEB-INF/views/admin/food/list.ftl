<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<body>
<#assign active='foodList'/>
<#include "../include/common-top.ftl"/>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
    <#include "../include/common-menu.ftl"/>
        <div class="main-content">
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-search">
                            <form role="form" class="form-inline clearfix" id="form" action="">
                                <div class="input-group col-xs-3">
                                    <span class="input-group-addon">名字</span>
                                    <input type="text" class="form-control" name="name" value="${name!}">
                                </div>
                            </form>
                            <div class="form-tool btn-group">
                                <button class="btn btn-sm btn-success" form="form">
                                    <i class="icon-search"></i>搜索
                                </button>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>名字</th>
                                    <th>分类</th>
                                    <th>原价</th>
                                    <th>价格</th>
                                    <th>添加时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as item>
                                <tr>
                                    <td>${item.name}</td>
                                    <td>${item.category}</td>
                                    <td>${item.oldprice!0?string('#0.00')}</td>
                                    <td>${item.price?string('#0.00')}</td>
                                    <td>${item.addtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <#if item.status == 0>
                                                <a class="btn btn-xs btn-success" href="/admin/food/updateStatus/${item.id}">上架</a>
                                            <#else >
                                                <a class="btn btn-xs btn-danger" href="/admin/food/updateStatus/${item.id}">下架</a>
                                            </#if>
                                            <a class="btn btn-xs btn-info" href="/admin/food/detail/${item.id}">
                                                <i class="icon-edit bigger-120"></i>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                                </#list>
                                </tbody>
                            </table>
                        <#include "../include/table-page.ftl"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<#include "../include/resource-script.ftl"/>

</html>

