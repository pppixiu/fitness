var E = window.wangEditor;
var editor = new E('#editor');

// 自定义菜单配置
editor.customConfig.menus = [
    'fontSize',  // 字号
    'fontName',  // 字体
    'underline',  // 下划线
    'foreColor',  // 文字颜色
    'backColor',  // 背景颜色
    'image',  // 插入图片
    'code',  // 插入代码
    'undo',  // 撤销
]

// 上传时间
//editor.customConfig.uploadImgTimeout = 50000;
// 隐藏“网络图片”tab
editor.customConfig.showLinkImg = false;
//开启debug模式
editor.customConfig.debug = true;
// 关闭粘贴内容中的样式
editor.customConfig.pasteFilterStyle = false
// 忽略粘贴内容中的图片
editor.customConfig.pasteIgnoreImg = true

// 上传图片到服务器
editor.customConfig.uploadFileName = 'file'; //设置文件上传的参数名称
editor.customConfig.uploadImgServer = '/blog/upload'; //设置上传文件的服务器路径
editor.customConfig.uploadImgMaxSize = 10 * 1024 * 1024; // 将图片大小限制为 10M

//自定义上传图片事件
editor.customConfig.uploadImgHooks = {
    customInsert: function (insertImg, result, editor) {
        // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
        // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
        // 插入图片到editor
        // editor.cmd.do('insertHtml', '<img src="' + result.data[0] + '" alt="错了"  style="max-width:100%;"/>')
        var url = result.data[0];
        insertImg(url);
    }
}
editor.create();
$('#editor').attr('style','heigth:auto');

// 向后台传入wangeditor内容
function submit() {

    // var blogContent = $("#editor").html();
    var blogContent = {blogContent : document.getElementById("editor").innerHTML}

    var blogContentUrl = '/blog/adduserblog' //?'
     //  +'blogContent='+ blogContent;
    $.ajax({
        url: "/blog/adduserblog",
        type: "post",
        contentType:'application/json',
        dataType : 'json',
        data : JSON.stringify(blogContent),
        success : function (data) {
            if (data.success){
                alert("成功")
            }
        }

    })

    // alert(blogContent)
}

