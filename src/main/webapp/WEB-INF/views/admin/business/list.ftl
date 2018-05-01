<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<body>
<#assign active='businessList'/>
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
                                    <span class="input-group-addon">登录名</span>
                                    <input type="text" class="form-control" name="username" value="${username!}">
                                </div><div class="input-group col-xs-3">
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
                                    <th>登录名</th>
                                    <th>商家名</th>
                                    <th>联系方式</th>
                                    <th>商家地址</th>
                                    <th>配送费用</th>
                                    <th>注册时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as item>
                                <tr>
                                    <td>${item.username}</td>
                                    <td>${item.name}</td>
                                    <td>${item.phone}</td>
                                    <td>${item.address}</td>
                                    <td>${item.free}</td>
                                    <td>${item.addtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <a class="btn btn-xs btn-info" href="/admin/business/detail/${item.id}">
                                                <i class="icon-edit bigger-120"></i>
                                            </a>

                                            <a class="btn btn-xs btn-info" onclick="if(confirm('确定要删除吗？')){location.href='/admin/business/del/${item.id}'}">
                                                删除
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

