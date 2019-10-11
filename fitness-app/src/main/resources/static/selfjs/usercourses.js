var listCoachUrl = '/user/courselist';
var pageSize = 8;
var pageNum = 1;

//初始化blog数据
function getuserblog(e) {
    var url = listCoachUrl + '?userId=' + e + '&pageIndex=' + pageNum + '&pageSize=' + pageSize;
    var html = '';
    $
        .getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var blogList = data.data;
                    blogList
                        .map(function (item, index) {
                            html += '\t<div class="col-md-12 shadow radis" style="background-color: white; margin-bottom: 20px;">\n' +
                                '\t\t\t\t\t\t<div class="col-md-3" style="padding-top: 8px; padding-bottom: 10px; text-align: right">\n' +
                                '\t\t\t\t\t\t\t<img src="'+ item.url +'" alt="" width="200px" height="150px">\n' +
                                '\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t\t<div class="col-md-9"  style="padding-top: 20px;">\n' +
                                '\t\t\t\t\t\t\t<a href="/course/courseInfo/?courseId='+item.id+'"><h2 style="font-size: 25px; text-align: left;margin-bottom: 10px;  width: 50%; margin-right: 0;">'+ item.title +'</h2></a>\n' +
                                '\t\t\t\t\t\t\t<p>'+ item.desc +'</p>\n' +
                                '\t\t\t\t\t\t\t<span style="margin-top: 2%;float: left;">'+ item.count +' 人已购买&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n' +
                                '\t\t\t\t\t\t\t<h3 class="t-button" style="float: right; margin-top: 0%">\n' +
                                '\t\t\t\t\t\t\t\t<a href="/course/courseInfo/?courseId='+item.id+'"><span class="label label-success">继续学习</span></a>\n' +
                                '\t\t\t\t\t\t\t</h3>\n' +
                                '\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t</div>'
                        });
                    // $('#course-button').html('<button class="corner-button" onclick="nextPage()">\n' +
                    //     '                    <span>加载更多</span>\n' +
                    //     '                </button>');
                } else {
                    html = '<div style="height: 550px; text-align: center; line-height: 550px; font-size: 20px;" >没有关注教练</div>';
                    $('#course-button').html('');
                }
                $('#course-list').html(html);
                pageNum += 1;
            });
}

// 废弃
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
                            html += '\t<div class="col-md-12 shadow radis" style="background-color: white; margin-bottom: 20px;">\n' +
                                '\t\t\t\t\t\t<div class="col-md-3" style="padding-top: 8px; padding-bottom: 10px; text-align: right">\n' +
                                '\t\t\t\t\t\t\t<img src="'+ item.url +'" alt="" width="200px" height="150px">\n' +
                                '\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t\t<div class="col-md-9"  style="padding-top: 20px;">\n' +
                                '\t\t\t\t\t\t\t<a href="/course/courseInfo/?courseId='+item.id+'"><h2 style="font-size: 25px; text-align: left;margin-bottom: 10px;  width: 50%; margin-right: 0;">'+ item.title +'</h2></a>\n' +
                                '\t\t\t\t\t\t\t<p>'+ item.desc +'</p>\n' +
                                '\t\t\t\t\t\t\t<span style="margin-top: 2%;float: left;">'+ item.count +' 人已购买&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n' +
                                '\t\t\t\t\t\t\t<h3 class="t-button" style="float: right; margin-top: 0%">\n' +
                                '\t\t\t\t\t\t\t\t<a href="/course/courseInfo/?courseId='+item.id+'"><span class="label label-success">继续学习</span></a>\n' +
                                '\t\t\t\t\t\t\t</h3>\n' +
                                '\t\t\t\t\t\t</div>\n' +
                                '\t\t\t\t\t</div>'
                        });
                } else {
                    $('#course-button').html('<div class="col-md-12" style="font-size: 30px; text-align: center; background-color: white">\n' +
                        '                   no more\n' +
                        '                </div>');
                }

                $('#course-list').append(html);
                pageNum += 1;
            });
}

//废弃
function nextPage() {
    addItems(pageSize, pageNum);
}

$(function () {
    var result = getQueryVariable("userId");
    getuserblog(result);
});

/**
 * 获取传参userId
 * @param variable
 * @returns {*}
 */
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}
