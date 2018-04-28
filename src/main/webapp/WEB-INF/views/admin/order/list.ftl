<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<body>
<#assign active='orderList'/>
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
                                    <span class="input-group-addon">订单号</span>
                                    <input type="text" class="form-control" name="orderno" value="${orderno!}">
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
                                    <th>订单号</th>
                                    <th>用户名</th>
                                    <th>总价</th>
                                    <th>发起时间</th>
                                    <th>支付时间</th>
                                    <th>收货人</th>
                                    <th>收货地址</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as item>
                                <tr>
                                    <td>${item.orderno}</td>
                                    <td>${item.username}</td>
                                    <td>${item.total?string('#0.00')}</td>
                                    <td>${item.addtime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                    <td><#if item.paytime??>${item.paytime?string('yyyy-MM-dd HH:mm:ss')}<#else>
                                        未支付</#if></td>
                                    <td><#if item.paytime??>${item.receiveuser!}<#else>未支付</#if></td>
                                    <td><#if item.paytime??>${item.receiveaddress!}<#else>未支付</#if></td>
                                    <td>
                                        <#if 1 == item.status!>
                                            <span class="label label-sm label-info">已支付</span>
                                        <#elseif item.status ==0>
                                            <span class="label label-sm label-warning">未支付</span>
                                        </#if>
                                    </td>
                                    <td>
                                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                            <a class="btn btn-xs btn-success" onclick="tipMsg('${item.remark!}')">备注</a>
                                            <a class="btn btn-xs btn-primary" href="/admin/order/detail/${item.id}">详情</a>
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

