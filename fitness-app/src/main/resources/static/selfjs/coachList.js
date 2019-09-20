$(function () {
    var tagId = 0;
    var rowIndex = 0;
    var sortId = 0;
    var coachName = 'empty';

    window.onload = function(){
        var obj_lis = document.getElementById("tag-show").getElementsByTagName("li");
        for(i=0;i<obj_lis.length;i++){
            obj_lis[i].onclick = function(){
                alert(this.innerHTML);
            }
        }
    };

    var tagUrl = '/coach/tag';
    var coachListUrl = '/coach?tagId='+tagId+'&rowIndex='+rowIndex+'&sortId='+sortId+'&coachName='+coachName;
    function gettaglist() {
        var tagurl = tagUrl;
        $.getJSON(
            tagurl,
            function (data) {
                if(data.code == "0"){
                    var tagList = data.data;
                    var html = "";
                    tagList.map(function (item,index) {
                        html += '<li class="tag-id"><a href="coachList.html?tagId='
                             + item.tagId
                             + '"'
                             + 'value="'
                             + item.tagId
                             + '">'
                             + item.tagName
                             + '</a></li>'
                    });
                    $('#tag-show').html(html);
                }
            })
    }

    function getcoachlist() {
        var url = coachListUrl;

        $.getJSON(
            url,
            function (data) {
                if (data.code == "0") {
                    var coachList = data.data;
                    var html = '';
                    coachList
                        .map(function (item, index) {
                            html += '<div style="width: 300px;height:auto;" href="coachPage.html?coachId='
                                + item.id
                                + '">'
                                + '<div class="card card-product">'
                                + '<div class="card-image">'
                                + '<a href="coachPage.html?coachId='
                                + item.id
                                +'"> <img class="img" src="images/coachList/blog04.jpeg"> </a></div>'
                                + '<div class="table">'
                                + '<h6 class="category text-rose">'
                                + item.count
                                + '</h6>'
                                + '<h4 class="card-caption">'
                                + '<a href="coachPage.html?coachId='
                                + item.id
                                + '">'
                                + item.name
                                + '</a></h4>'
                                + '<div class="card-description">'
                                + item.desc
                                + '</div>'
                                + '<div class="ftr">'
                                + '<div class="price">'
                                + '<h4>$'
                                + item.price
                                + '</h4></div>'
                                + '<div class="stats">'
                                + '<button type="button" rel="tooltip" title="" class="btn btn-just-icon btn-simple btn-warning"'
                                + 'data-original-title="Saved to Wishlist"><i class="fa fa-shopping-cart"></i></button>'
                                + '</div>'
                                + '</div>'
                                + '</div>'
                                + '</div>'
                                + '</div>'
                        });
                    $('#coach-list').html(html);
                }
            });
    }
    getcoachlist();
    gettaglist();
});
