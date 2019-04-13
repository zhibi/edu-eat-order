<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="order"/>
<#assign navTitle= '订单详情'/>
<style>

    h5 {
        padding-top: 8px;
        padding-bottom: 8px;
        text-indent: 12px;
    }

    .mui-table-view.mui-grid-view .mui-table-view-cell .mui-media-body {
        font-size: 15px;
        margin-top: 8px;
        color: #333;
    }
</style>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
    <ul class="mui-table-view">
        <li class="mui-table-view-cell">订单号：${order.orderNo!}</li>
        <li class="mui-table-view-cell">预定商家：${business.name!}</li>
        <li class="mui-table-view-cell">预定时间：${order.orderTime!}</li>
        <li class="mui-table-view-cell">预留电话：${order.phone!}</li>
        <li class="mui-table-view-cell">用餐人数：${order.num!}</li>
        <li class="mui-table-view-cell">下单时间：${order.addTime?string("yyyy-MM-dd HH:mm:ss")}</li>
        <li class="mui-table-view-cell">订单金额：${order.total!}</li>
        <#if order.status == '待支付'>
            <li class="mui-table-view-cell">
                优惠券：<#if coupon??>${coupon.species + '--' + coupon.money}元<#else>暂无优惠券</#if></li>
            <li class="mui-table-view-cell">
                待支付金额：<#if coupon??>${order.total - coupon.money}元<#else>${order.total!}元</#if></li>
            <li class="mui-table-view-cell">
                <button type="button" class="mui-btn mui-btn-primary" onclick="location.href='/order/pay/${order.id}'">
                    支付
                </button>
            </li>
        </#if>
    </ul>
</div>
</body>

</html>