<section class="breadcrumb">
    <a href="/">首页</a>
    <i>&gt;</i>
    <span>${business.name}</span>
</section>
<section class="basicinfo">
    <div class="b-img fl">
        <img width="198" height="120" src="${business.icon!}" data-src="${business.icon!}">
    </div>
    <div class="b-info fl">
        <div class="one-line">
            <h2>${business.name}</h2>
        </div>
        <dl>
            <dt><i class="icon icon-time"></i>接单时间:&nbsp;</dt>
            <dd class="bussinessStatus">
                <span>07:00-20:00</span><strong class="doing">营业中</strong></dd>
        </dl>
        <dl>
            <dt><i class="icon icon-address"></i>商户地址:&nbsp;</dt>
            <dd>
                ${business.address!}
            </dd>
        </dl>
        <dl>
            <dt><i class="icon icon-phone"></i>商户电话:&nbsp;</dt>
            <dd>
                ${business.phone!}
            </dd>
        </dl>
    </div>
    <div class="b-cost fr">
        <div class="b-value"><strong class="b-num">${business.category!}</strong></div>
        <p class="b-label">分类</p>
    </div>
    <div class="b-divider fr"></div>
    <div class="b-price fr">
        <div class="b-value"><strong class="b-num">${business.startNum}</strong></div>
        <p class="b-label">点赞次数</p>
    </div>
    <div class="b-divider fr"></div>
    <div class="b-price fr">
        <div class="b-value">
            <strong class="b-num">${business.orderNum}</strong>
            <span class="num-unit"></span></div>
        <p class="b-label">预约次数</p>
    </div>
    <div class="b-divider fr"></div>
    <div class="b-totime fr">
        <div class="b-value">
            <strong class="b-num">${business.commendNum}</strong>
            <span class="num-unit"></span></div>
        <p class="b-label">评论次数</p>
    </div>
</section>