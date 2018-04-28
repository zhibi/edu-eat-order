/**
 * 上传文件的插件
 * name input 的id
 * imageSrc 图片的路径
 */
function uploadFile(name, imageSrc) {
    if (imageSrc == null) {
        $("#" + name).fileinput({
            showRemove: true,//显示移除按钮
            showUpload: false,
            language: 'zh',//语言
            uploadAsync: true,
            allowedPreviewTypes: ['image'],
            //allowedFileExtensions : [ 'png', 'jpg' ],//后缀
            showPreview: true,//预览
            elErrorContainer: "#errorBlock",
            browseClass: "btn btn-primary btn-sm", //按钮样式
            removeIcon: '<i></i>',
            browseIcon: '<i class=""></i>',
            previewFileIcon: '<i class=""></i>',
            removeClass: "btn btn-info btn-sm"
        });
    } else {
        $("#" + name).fileinput({
            showRemove: true,//显示移除按钮
            showUpload: false,
            language: 'zh',//语言
            uploadAsync: true,
            allowedPreviewTypes: ['image'],
            initialPreview: [
                '<img src=' + imageSrc + ' class="file-preview-image"/>'],
            showPreview: true,//预览
            elErrorContainer: "#errorBlock",
            browseClass: "btn btn-primary btn-sm", //按钮样式
            removeIcon: '<i></i>',
            browseIcon: '<i class=""></i>',
            previewFileIcon: '<i class=""></i>',
            removeClass: "btn btn-info btn-sm"
        });
    }
};