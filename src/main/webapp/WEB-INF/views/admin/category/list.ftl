<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='categoryList'/>
<body>
<div class="main-container" id="main-container">
    <div class="main-container-inner">
    <#include "../include/common-menu.ftl"/>
        <div class="main-content">
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-search">
                            <form role="form" class="form-inline clearfix" id="form2" action="">

                                <div class="input-group col-xs-3">
                                    <span class="input-group-addon">分类名</span>
                                    <input type="text" class="form-control" name="name" value="${name!}">
                                </div>
                            </form>
                            <div class="form-tool btn-group">
                                <button class="btn btn-sm btn-success" form="form2">
                                    <i class="icon-search"></i>搜索
                                </button>
                                <button class="btn btn-sm btn-primary" onclick="location.href='/admin/category/add'">
                                    <i class="icon-plus"></i>添加
                                </button>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>名字</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as item>
                                <tr>
                                    <td>${item.name!}</td>
                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">

                                            <a class="btn btn-xs btn-danger" href="javascript:if(confirm('确定要删除吗？')){location.href = '/admin/category/del/${item.id}'}">删除</a>
                                            <#--<a class="btn btn-xs btn-primary" href="/admin/category/detail/${item.id}">详情</a>-->
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
</body>

<#include "../include/resource-script.ftl"/>
</html>

