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
                                    <input type="text" class="form-control" name="orderNo" value="${orderNo!}">
                                </div>
                                <div class="input-group col-xs-3">
                                    <span class="input-group-addon">预约人</span>
                                    <input type="text" class="form-control" name="userName" value="${userName!}">
                                </div>
                                <div class="input-group col-xs-3">
                                    <span class="input-group-addon">预约商家</span>
                                    <input type="text" class="form-control" name="businessName"
                                           value="${businessName!}">
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
                                    <th>商家</th>
                                    <th>预约人数</th>
                                    <th>联系方式</th>
                                    <th>价格</th>
                                    <th>预约时间</th>
                                    <th>支付时间</th>
                                    <th>下单时间</th>
                                    <th>备注</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list pageInfo.list as item>
                                    <tr>
                                        <td>${item.orderNo}</td>
                                        <td>${item.userName!}</td>
                                        <td>${item.businessName!}</td>
                                        <td>${item.num!}</td>
                                        <td>${item.phone!}</td>
                                        <td>${item.total?string('#0.00')}</td>
                                        <td>${item.orderTime!}</td>
                                        <td><#if item.payTime??>${item.payTime?string('yyyy-MM-dd HH:mm:ss')}<#else>未支付</#if></td>
                                        <td>${item.addTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td>${item.remark!}</td>
                                        <td>${item.status!}</td>
                                        <td>
                                            <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                                                <a class="btn btn-xs btn-success"
                                                   onclick="updateStatus('${item.id!}','${item.status}')">修改状态</a>
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
<div class="modal fade bs-example-modal-sm" id="status" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改状态</h4>
            </div>
            <div class="modal-body">
                <form id="orderForm" class="form-horizontal" method="post" action="/admin/order/update">
                    <input type="hidden" name="id" id="orderId">
                    <div class="input-group has-success col-xs-6" style="margin: 10px auto;">
                        <span class="input-group-addon" style="width: 90px;">状态:</span>
                        <select  class="form-control" name="status" id="orderStatus">
                            <option value="预约">预约</option>
                            <option value="已支付">已支付</option>
                            <option value="预约完成">预约完成</option>
                            <option value="取消">取消</option>
                        </select>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" form="orderForm">修改</button>
            </div>
        </div>
    </div>
</div>
<script>
    function updateStatus(id,status) {
        $("#orderId").val(id);
        $("#orderStatus").val(status);
        $("#status").modal("show");
    }
</script>

</html>

