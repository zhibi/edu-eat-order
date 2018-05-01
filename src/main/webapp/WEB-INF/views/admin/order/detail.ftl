<!DOCTYPE html>
<html lang="en">
<#include "../include/resource-head.ftl"/>
<#assign active='orderList'/>
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
                                    <i class="icon-plus"></i>订单详情
                                </h4>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main">
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-success">订单号:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.orderno!}</span>
                                    </div>
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-primary">订单发起时间:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.addtime?string('yyyy-MM-dd HH:mm:ss')}</span>
                                    </div>
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-primary">订单用户:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.username!}</span>
                                    </div>
                                <#if orderModel.paytime??>
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-info">订单支付时间:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.paytime?string('yyyy-MM-dd HH:mm:ss')}</span>
                                    </div>
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-warning">收货人:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.receiveuser!}</span>
                                    </div>
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-info">收货地址:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.receiveuser!}</span>
                                    </div>
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-info">联系方式:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.phone!}</span>
                                    </div>
                                    <div class="step-content row-fluid position-relative">
                                        <label class="label label-danger">收货备注:</label>&nbsp;&nbsp;&nbsp;
                                        <span>${orderModel.remark!}</span>
                                    </div>
                                </#if>
                                    <div class="step-content row-fluid position-relative pull-right">
                                        <label class="label label-danger">订单总价:</label>&nbsp;&nbsp;&nbsp;
                                        <span class="text-red">${orderModel.total?string('#0.00')}</span>
                                    </div>
                                </div>
                                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>菜品名</th>
                                        <th>价格</th>
                                        <th>数量</th>
                                        <th>总价</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list orderModel.orderItemModelList as item>
                                    <tr>
                                        <td>${item.foodName!}</td>
                                        <td>${item.foodPrice?string('#0.00')}</td>
                                        <td>${item.count}</td>
                                        <td>${item.price?string('#0.00')}</td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
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
</html>

