<!DOCTYPE html>
<html lang="en">
<#include "common/head.ftl"/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "common/foot-menu.ftl"/>
<#include "common/header.ftl"/>
<div class="mui-content">
    <div class="mui-content-padded" style="margin: 5px;">
        <div class="mui-input-row mui-search">
            <form>
                <input type="search" class="mui-input-clear" placeholder="" data-input-clear="1" name="name"
                       data-input-search="1"><span class="mui-icon mui-icon-clear mui-hidden"></span><span
                        class="mui-placeholder"><span class="mui-icon mui-icon-search"></span><span></span></span>
            </form>
        </div>
    </div>
    <div id="slider" class="mui-slider" style="height: 200px">
        <div class="mui-slider-group mui-slider-loop" style="transform: translate3d(-356px, 0px, 0px) translateZ(0px);">
            <!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
            <div class="mui-slider-item mui-slider-item-duplicate">
                <a href="#">
                    <img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3943723512,1898909937&fm=27&gp=0.jpg">
                </a>
            </div>
            <!-- 第一张 -->
            <div class="mui-slider-item">
                <a href="#">
                    <img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1319382472,2538609854&fm=27&gp=0.jpg">
                </a>
            </div>
            <!-- 第二张 -->
            <div class="mui-slider-item">
                <a href="#">
                    <img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2769300651,2935943791&fm=27&gp=0.jpg">
                </a>
            </div>
            <!-- 第三张 -->
            <div class="mui-slider-item">
                <a href="#">
                    <img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2106539881,3507107709&fm=27&gp=0.jpg">
                </a>
            </div>
            <!-- 第四张 -->
            <div class="mui-slider-item">
                <a href="#">
                    <img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=626071842,1243389150&fm=27&gp=0.jpg">
                </a>
            </div>
            <!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
            <div class="mui-slider-item mui-slider-item-duplicate">
                <a href="#">
                    <img src="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3943723512,1898909937&fm=27&gp=0.jpg">
                </a>
            </div>
        </div>
        <div class="mui-slider-indicator">
            <div class="mui-indicator mui-active"></div>
            <div class="mui-indicator"></div>
            <div class="mui-indicator"></div>
            <div class="mui-indicator"></div>
        </div>
    </div>
    <#list businessList as item>
        <div class="mui-card">
            <div class="mui-card-header">${item.name}</div>
            <div class="mui-card-content">
                <img src="${item.icon}" width="100%">
            </div>
            <div class="mui-card-footer">
                <a class="mui-card-link" href="/order/send/${item.id!}">预定 ${item.orderNum} </a>
                <a class="mui-card-link" href="/comment/${item.id!}">评论 ${item.commendNum} </a>
                <a class="mui-card-link" href="/business/detail/${item.id}">详情</a>
            </div>
        </div>
    </#list>

</div>
<script>
    //获得slider插件对象
    var gallery = mui('.mui-slider');
    gallery.slider({
        interval: 5000//自动轮播周期，若为0则不自动播放，默认为0；
    });
</script>
</body>
</html>