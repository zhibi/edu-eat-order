<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>在线预约</title>
    <link rel="stylesheet" type="text/css" href="/front/index_files/main_a79c03f.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/cartAlert_69d76b3.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/common_4840c98.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/citybar_2daccc1.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/landing_26d4e9b.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/muti_60d05dd.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/registerDialog_77e55d3.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/userInfo_11c5a6b.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/search_cae56fa.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/addressEditDialog_be19f67.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/search_b1f3d15.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/nav_92fb35c.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/shoplist_b2c246e.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/shopcard_93f9a30.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/dishcard_d331747.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/backtop_e064524.css">
    <link rel="stylesheet" type="text/css" href="/front/index_files/footer_bf9a09d.css">
</head>
<body>
<#include "include/header.html"/>

<div id="content" class="clearfix" style="min-height: 610px;">
    <style type="text/css">
        /*widget.sg*/
        input::-ms-clear {
            display: none;
        }

        .filter-search .f-input {
            line-height: 30px;
        }
    </style>

    <div class="main">
        <div class="filter-category clearfix">
            <div class="acrossLine"></div>
            <ul class="clearfix">
                <li class="active">金牌商家</li>
            </ul>
        </div>
        <section class="shop-list" id="shop-list">
            <div class="list-wrap">
                <div class="list clearfix">
                    <ul class="shopcards-list">
                        <#list businessList as item>
                            <li class="list-item shopcard  online" onclick="location.href='/business/detail/${item.id}'">
                                <div class="shopimg">
                                    <img width="228" height="140"
                                         src="${item.icon!}">
                                </div>
                                <div class="title">${item.name}
                                    <span class="cert-icon"><img src="/front/index_files/certificated_s.png"></span>
                                </div>
                                <div class="info f-info clearfix">
                                    <div class="f-col"><span class="item-value">${item.address!}</span></div>
                                </div>
                                <div class="info f-info clearfix">
                                    <div class="f-col"><span class="item-value">${item.phone!}</span></div>
                                </div>
                                <div class="feature"></div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </section>


        <div class="filter-category clearfix">
            <div class="acrossLine"></div>
            <ul class="clearfix">
                <li class="active">推荐菜品</li>
            </ul>
        </div>
        <section class="shop-list" id="shop-list">
            <div class="list-wrap">
                <div class="list clearfix">
                    <ul class="shopcards-list">
                        <#list foodList as item>
                            <li class="list-item shopcard  online" onclick="location.href='/business/detail/${item.businessId}'">
                                <div class="shopimg">
                                    <img width="228" height="140"
                                         src="${item.icon!}">
                                </div>
                                <div class="title">${item.name}
                                    <span class="cert-icon"><img src="/front/index_files/certificated_s.png"></span>
                                    <span class="f-col f-sale">&nbsp;&nbsp;${item.businessName!}</span>
                                </div>
                                <div class="info f-info clearfix">
                                    <div class="f-col f-price"><span class="item-label">原价:</span> <span
                                                class="item-value">¥${item.oldPrice!}</span>
                                    </div>
                                    <div class="f-col f-cost"><span class="item-label">现价:</span> <span
                                                class="item-value">¥${item.price!}</span>
                                    </div>
                                </div>
                                <div class="feature"></div>
                            </li>
                        </#list>
                    </ul>
                </div>
            </div>
        </section>
    </div>

</div>
</body>
</html>