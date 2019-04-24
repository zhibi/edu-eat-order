<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="home"/>
<#assign navTitle='预约 ' + business.name />
<link href="/plugins/mui/css/mui.picker.min.css" rel="stylesheet"/>
<script src="/plugins/mui/js/mui.picker.min.js"></script>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
    <form class="mui-input-group" style="margin-top: 8px" action="/order/send" method="post">
        <input type="hidden" name="businessId" value="${business.id}">
        <div class="mui-input-row">
            <label>联系电话：</label>
            <input type="text" name="phone" class="mui-input-clear" required data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row">
            <label>就餐人数：</label>
            <input type="number" name="num" value="1" class="mui-input-clear" required data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row">
            <label>就餐时间：</label>
            <input type="text" name="orderTime" readonly id="orderTime" class="mui-input-clear" required
                   data-input-clear="5"><span
                    class="mui-icon mui-icon-clear mui-hidden"></span>
        </div>
        <div class="mui-input-row" style="margin: 10px 5px;height: auto">
            <textarea name="remark" rows="5" placeholder="就餐备注"></textarea>
        </div>

        <#list foodList as item>
            <div class="mui-input-row mui-checkbox mui-right">
                <label>${item.name}</label>
                <input name="foods" value="${item.id}" type="checkbox">
            </div>
        </#list>

        <div class="mui-button-row">
            <button type="submit" class="mui-btn mui-btn-primary">发布</button>&nbsp;&nbsp;
        </div>
    </form>
</div>
</body>
<script>
    (function ($) {
        $.init();
        document.getElementById("orderTime").addEventListener('tap', function () {
                var options = {
                    "type": "hour",
                    "customData": {
                        "h": [{"text": "上午", "value": "上午"},
                            {"text": "下午", "value": "下午"},
                            {"text": "晚上", "value": "晚上"}
                        ]
                    },
                    "labels": ["年", "月", "日", "时段", "分"]
                };
                var picker = new $.DtPicker(options);
                picker.show(function (rs) {
                    /*
                     * rs.value 拼合后的 value
                     * rs.text 拼合后的 text
                     * rs.y 年，可以通过 rs.y.vaue 和 rs.y.text 获取值和文本
                     * rs.m 月，用法同年
                     * rs.d 日，用法同年
                     * rs.h 时，用法同年
                     * rs.i 分（minutes 的第二个字母），用法同年
                     */
                    jQuery('#orderTime').val(rs.text);
                    /*
                     * 返回 false 可以阻止选择框的关闭
                     * return false;
                     */
                    /*
                     * 释放组件资源，释放后将将不能再操作组件
                     * 通常情况下，不需要示放组件，new DtPicker(options) 后，可以一直使用。
                     * 当前示例，因为内容较多，如不进行资原释放，在某些设备上会较慢。
                     * 所以每次用完便立即调用 dispose 进行释放，下次用时再创建新实例。
                     */
                    picker.dispose();
                });
            },
            false
        );
    })(mui);
    var err = "${errorMessage!}";
    if (err.length > 0) {
        mui.alert(err, '提示');
    }
</script>
</html>