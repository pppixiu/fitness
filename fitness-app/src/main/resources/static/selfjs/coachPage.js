var coachId;
$(function () {
    var result = getQueryVariable("coachId");
    coachInfo(result);

});

/**
 * 获取传参
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

/**
 * 获取参数
 * @param e
 */
function coachInfo(e) {
    var id = e;
    var coachInfoUrl = '/coach/coachShow?coachId='+id;
    var coachBlogUrl = '/blog/getuserblogbyuserid?pageIndex=0&pageSize=3&userId='+id;
    var coachCourseUrl = '/coach/coachCourse?coachId='+id;
    var coachImageUrl = '/coach/coachImage?coachId='+id;

    /*加载基本信息*/
    $.getJSON(
        coachInfoUrl,
        function (data) {
            if (data.code == "0") {
                var info = data.data;
                likecount = info[0].count;
                $('#coach-name').text(info[0].coachname);
                $('#coach-desc').text(info[0].coachdesc);
                $('#coach-count').text(info[0].count);
            }
        });

    /*加载博客*/
    $.getJSON(
        coachBlogUrl,
        function (data) {
            if (data.code == "0") {
                var blogList = data.data;
                var bloghtml = '';
                blogList
                    .map(function (item, index) {
                        bloghtml += '<div class="col-md-4" style="overflow: hidden;">'
                            + '<div class="card card-background" style="background-image:  url('
                            +  item.imageUrl
                            + ')">'
                            + '<div class="table" style="height: 300px;overflow: hidden;">'
                            + '<h3 class="card-caption">BLOG</h3>'
                            + '<p class="card-description">'
                            + item.blogContent
                            + '</p>'
                            + '<a href="#" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i> 查看详情 </a>'
                            + '</div> </div> </div>';
                    });
                $('#blog-show').html(bloghtml);
            }
        });

    /*加载图片*/
    $.getJSON(
        coachImageUrl,
        function (data) {
            if (data.code == "0") {
                var imageList = data.data;
                var imagehtml = '';
                imageList
                    .map(function (item, index) {
                        imagehtml += '<div class="col-md-4">'
                            + '<div class="card card-background" style="background-image: url("images/blog07.jpg")">'
                            + '<div class="table" style="height: 300px; overflow: hidden;">'
                            + '</div> </div> </div>'
                    });
                $('#image-show').html(imagehtml);

            }
        });

    /*加载课程*/
    $.getJSON(
        coachCourseUrl,
        function (data) {
            if (data.code == "0") {
                var courseList = data.data;
                var coursehtml = '';
                courseList
                    .map(function (item, index) {
                        coursehtml += '<div class="col-md-4" style="overflow: hidden">'
                            + '<div class="card card-background" style="background-image: url('
                            + item.url
                            + ')">'
                            + '<div class="table" style="overflow: hidden; height: 300px;">'
                            + '<h6 class="category text-info">COURSE</h6>'
                            + '<h3 class="card-caption">'
                            + item.title
                            + '</h3>'
                            + '<a href="#" class="btn btn-danger btn-round"> <i class="fa fa-align-left"></i> 查看详情 </a>'
                            + '</div> </div> </div>'
                    });
                $('#course-show').html(coursehtml);
            }
        });
}