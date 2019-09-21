var likecount ;

/**
 * 获取传参
 * @param variable
 * @returns {*}
 */
function query(variable){
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){
            return pair[1];}
    }
    return(false);
}

$(function () {
    var result = query("coachId");
    coachInfo(result);
});

/**
 * 获取参数
 * @param e
 */
function coachInfo(e) {
    var coachInfoUrl = '/coach/coachInfo?coachId='+e;
    var url = coachInfoUrl;

    $.getJSON(
        url,
        function (data,index) {
            if (data.code == "0") {
                var info = data.data;
                likecount = info[0].count;
                $('#coach-name').text(info[0].coachname);
                $('#coach-desc').text(info[0].coachdesc);
                $('#coach-count').text(info[0].count);

                var bloghtml = '';
                var imagehtml = '';
                var coursehtml = '';
                info[0]
                    .map(function (item, index) {
                        bloghtml += '<div class="col-md-4"> '
                             + '<div class="card card-background" style="background-image: url(/images/blog07.jpg)">'
                             + '<div class="table">'
                             + ' <h6 class="category text-info">博文</h6>'
                             + '<p class="card-description">'
                             + item.coachblogs.blogContent
                             + '</p>'
                             + '<a href="#" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i> 查看详情</a>'
                             + '</div> </div> </div>'
                             + '<div class="col-md-4"> <div class="card card-background" style="background-image: url(/images/blog07.jpg)">'
                             + '<div class="table"> <h6 class="category text-info">图片</h6> </div></div></div>'
                             + '<div class="col-md-4">'
                             + '<div class="card card-background" style="background-image: url(/images/blog07.jpg)">'
                             + '<div class="table">'
                             + '<h6 class="category text-info">课程</h6>'
                             + '<h3 class="card-caption">'
                             + item.courses.courseTitle
                             + '</h3>'
                             + '<p class="card-description">'
                             + item.courses.courseDesc
                             + '</p>'
                             + '<a href="#" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i>查看详情</a>'
                             + '</div> </div> </div>'
                    });
                $('#coachinfo-show').html(html);
            }
        });
}


/**
 * 点赞
 */
function likefuncation(){
    likecount += 1;
}