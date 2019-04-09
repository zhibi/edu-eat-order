var config = {
    isShowCatList : false
};

$(function(){
    /*
     * @Desc: 自定义表单组件
     * @Date: 2015-07-18
     */
    (function customFormPackage() {
        // 复选框
        $('label.checkbox').change(function(){
            var _this = $(this);
            _this.find('input[type=checkbox]').is(':checked') ? _this.addClass('checked') : _this.removeClass('checked');
        });
    })();
	
	$('#dLabel').mouseover(function() {
		$('.dropdown').addClass('open');
	});

	$('[data-toggle="tooltip"]').tooltip();
	$('[data-toggle="popover"]').popover();

	if(is_diff_date) {
    	if(uid && !is_full_info) {
        	$('#modalUnfullInfo').modal('show');
        	$('#index-info-tip').click(function() {
        		$('#modalUnfullInfo').modal('hide');
        		var _uri = $(this).attr('data-uri');
        		window.location.href = _uri;
        	});
    	}
	}

    // 显示全部分类
    (function showAllCat() {
        var catLayer = $('#header .cat-layer'),
            allCatLi = $('#header .all-cat li'),
            allCat = $('#header .all-cat'),
            catTitle = $('#header .all-cat > h3'),
            catList = $('#header .cat-list'),
            _timer;

        allCatLi.hover(function(){
            var _this = $(this);
            clearTimeout(_timer);
            catLayer.removeClass('hidden');
            catLayer.find('.item:eq('+ _this.index() +')').show().siblings('.item').hide();
        },function(){
            _timer = setTimeout(function(){ catLayer.addClass('hidden'); },100);
        });
        catLayer.hover(function(){ clearTimeout(_timer); },function(){ $(this).addClass('hidden'); });

        catTitle.click(function(){
            if( config.isShowCatList ) return;
            catList.hasClass('hidden') ? catList.removeClass('hidden') : catList.addClass('hidden');
        });
        
        if(curcat && curcat != 'index') {
        	allCat.hover(function(){
        		catList.removeClass('hidden');
        		//catList.hasClass('hidden') ? catList.removeClass('hidden') : catList.addClass('hidden');
        	},function(){
                _timer = setTimeout(function(){ catList.addClass('hidden'); },100);
            });
        }
        
    })();


    // 搜索
    (function searchHandler() {
        var searchBar = $('#header .search-bar');
        searchBar.find('li').click(function(){
            var _this = $(this);
            if( _this.hasClass('active') ) return false;
            _this.addClass('active').siblings('li.active').removeClass('active');
            if( parseInt(_this.attr('data-type')) === 1 ) {
                searchBar.find('.search-input').attr('placeholder','搜索你想要的自由人信息...');
                searchBar.find('input[name="type"]').val(1);
            }
            if( parseInt(_this.attr('data-type')) === 2 ) {
                searchBar.find('.search-input').attr('placeholder','搜索你想要的项目组信息...');
                searchBar.find('input[name="type"]').val(2);
            }
        });
    })();

});

function tipMsg(msg){
    $("#m-msg").html(msg);
    $("#modalMsg").modal("show");
}


$.fn.onlyNum = function () {
    $(this).keypress(function (event) {
        var eventObj = event || e;
        var keyCode = eventObj.keyCode || eventObj.which;
        if ((keyCode >= 48 && keyCode <= 57)||keyCode==8)//8是删除
            return true;
        else
            return false;
    }).focus(function () {
        //禁用输入法
        this.style.imeMode = 'disabled';
    }).bind("paste", function () {
        //获取剪切板的内容
        var clipboard = window.clipboardData.getData("Text");
        if (/^\d+$/.test(clipboard))
            return true;
        else
            return false;
    });
};

$.fn.onlyDouble = function () {
    var flag = true;
    var first = true;
    $(this).keypress(function (event) {
        var eventObj = event || e;
        var keyCode = eventObj.keyCode || eventObj.which;
        if ((keyCode >= 48 && keyCode <= 57)||keyCode==8){
            first = false;
            return true;
        }//8是删除 46是小数点{
        else if(keyCode == 46 && flag && !first){
            flag = false;
            return true;
        }
        return false;
    }).focus(function () {
        //禁用输入法
        this.style.imeMode = 'disabled';
    }).bind("paste", function () {
        //获取剪切板的内容
        var clipboard = window.clipboardData.getData("Text");
        if (/^\d+$/.test(clipboard))
            return true;
        else
            return false;
    });
};