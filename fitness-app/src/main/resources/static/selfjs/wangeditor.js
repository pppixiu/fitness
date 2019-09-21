$(function () {
    $('#submit').click(function () {
        //开启debug模式
        editor.customConfig.debug = true;
// 关闭粘贴内容中的样式
        editor.customConfig.pasteFilterStyle = false
// 忽略粘贴内容中的图片
        editor.customConfig.pasteIgnoreImg = true

// 上传图片到服务器
        editor.customConfig.uploadFileName = 'file'; //设置文件上传的参数名称
        editor.customConfig.uploadImgServer = '/blog/upload'; //设置上传文件的服务器路径
        editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024; // 将图片大小限制为 3M
//自定义上传图片事件
        editor.customConfig.uploadImgHooks = {
            customInsert: function (insertImg, result, editor) {
                // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
                // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
                // 插入图片到editor
                editor.cmd.do('insertHtml', '<img alt="错了" src="http://' + result.data[0] + '" style="max-width:100%;"/>')
            }
        }
    });
});

