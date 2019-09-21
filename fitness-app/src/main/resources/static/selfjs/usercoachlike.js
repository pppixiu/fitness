var listCoachUrl = '/user/coachlist';
var pageSize = 8;
var pageNum = 1;

//初始化blog数据
function getuserblog() {
    var url = listCoachUrl + '?pageIndex=' + pageNum + '&pageSize=' + pageSize;
    var html = '';
    $
        .getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var blogList = data.data;
                    blogList
                        .map(function (item, index) {
                            html += '<div class="col-md-3" style="margin-bottom: 20px;padding-right: 2px;">\n' +
                                '\t\t\t\t\t\t<div class="radis shadow" style="margin-left: 1px; margin-right: 1px; padding-bottom: 2px; height: auto">\n' +
                                '\t\t\t\t\t\t\t<div style="text-align: center; padding-left: 4px; padding-right: 4px">\n' +
                                '\t\t\t\t\t\t\t\t<img class="head_img" src="'+ item.imageurl +'" alt="" width="160px" height="160px">\n' +
                                '\t\t\t\t\t\t\t\t<ul style="list-style: none; margin-bottom: 10px">\n' +
                                '\t\t\t\t\t\t\t\t\t<li style="float: left; width: 100%">\n' +
                                '\t\t\t\t\t\t\t\t\t\t<a href="course-detail.html" style=""><h2 style="font-size: 25px; text-align: left;margin-top: 10px; margin-bottom: 10px;float: left; width: 50%; margin-right: 0;">'+ item.name +'</h2></a>\n' +
                                '\t\t\t\t\t\t\t\t\t\t<h4 class="t-button" style="margin-top: 5px;float: right;">\n' +
                                '\t\t\t\t\t\t\t\t\t\t\t<a href="#"><span class="label label-default">取消收藏</span></a>\n' +
                                '\t\t\t\t\t\t\t\t\t\t</h4>\n' +
                                '\t\t\t\t\t\t\t\t\t</li>\n' +
                                '\t\t\t\t\t\t\t\t\t<li>\n' +
                                '\t\t\t\t\t\t\t\t\t\t<span>价格'+ item.price +':&nbsp;&nbsp; </span>\n' +
                                '\t\t\t\t\t\t\t\t\t\t<span>学习人数： '+ item.count +'</span>\n' +
                                '\t\t\t\t\t\t\t\t\t</li>\n' +
                                '\t\t\t\t\t\t\t\t</ul>\n' +
                                '\t\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t</div>'
                        });
                    $('#coach-button').html('<button class="corner-button" onclick="nextPage()">\n' +
                        '                    <span>加载更多</span>\n' +
                        '                </button>');
                } else {
                    html = '<div style="height: 550px; text-align: center; line-height: 550px; font-size: 20px;" >没有关注教练</div>';
                    $('#coach-button').html('');
                }
                $('#coach-list').html(html);
                pageNum += 1;
            });
}

function addItems(pageSize, pageIndex) {
    // 生成新条目的URL
    var url = listCoachUrl + '?pageIndex=' + pageNum + '&pageSize=' + pageSize;
    var html = '';
    loading = true;
    $
        .getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var blogList = data.data;
                    blogList
                        .map(function (item, index) {
                            html += '<div class="col-md-3" style="margin-bottom: 20px;padding-right: 2px;">\n' +
                                '\t\t\t\t\t\t<div class="radis shadow" style="margin-left: 1px; margin-right: 1px; padding-bottom: 2px; height: auto">\n' +
                                '\t\t\t\t\t\t\t<div style="text-align: center; padding-left: 4px; padding-right: 4px">\n' +
                                '\t\t\t\t\t\t\t\t<img class="head_img" src="'+ item.imageurl +'" alt="" width="160px" height="160px">\n' +
                                '\t\t\t\t\t\t\t\t<ul style="list-style: none; margin-bottom: 10px">\n' +
                                '\t\t\t\t\t\t\t\t\t<li style="float: left; width: 100%">\n' +
                                '\t\t\t\t\t\t\t\t\t\t<a href="course-detail.html" style=""><h2 style="font-size: 25px; text-align: left;margin-top: 10px; margin-bottom: 10px;float: left; width: 50%; margin-right: 0;">'+ item.name +'</h2></a>\n' +
                                '\t\t\t\t\t\t\t\t\t\t<h4 class="t-button" style="margin-top: 5px;float: right;">\n' +
                                '\t\t\t\t\t\t\t\t\t\t\t<a href="#"><span class="label label-default">取消收藏</span></a>\n' +
                                '\t\t\t\t\t\t\t\t\t\t</h4>\n' +
                                '\t\t\t\t\t\t\t\t\t</li>\n' +
                                '\t\t\t\t\t\t\t\t\t<li>\n' +
                                '\t\t\t\t\t\t\t\t\t\t<span>价格:&nbsp;&nbsp;&nbsp;&nbsp; '+ item.price +'</span>\n' +
                                '\t\t\t\t\t\t\t\t\t\t<span>学习人数：&nbsp;&nbsp; '+ item.count +'</span>\n' +
                                '\t\t\t\t\t\t\t\t\t</li>\n' +
                                '\t\t\t\t\t\t\t\t</ul>\n' +
                                '\t\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t</div>'
                        });
                } else {
                    $('#coach-button').html('<div class="col-md-12" style="font-size: 30px; text-align: center; background-color: white">\n' +
                        '                   no more\n' +
                        '                </div>');
                }

                $('#coach-list').append(html);
                pageNum += 1;
            });
}

function nextPage() {
    addItems(pageSize, pageNum);
}

$(function () {
    getuserblog();
});
