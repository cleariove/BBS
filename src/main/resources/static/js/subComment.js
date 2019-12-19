

function insertSubComment() {
    var topicId = document.getElementById("subCommentId").value;
    alert(topicId);
    var subCommentContent = document.getElementById("subCommentContent").value;
    var subCommentTo = document.getElementById("").value;
    var date = getDate();
    var data = {
        "subCommentId": "111",
        "subCommentFrom": "2",
        "subCommentTo": subCommentTo,
        "content": subCommentContent,
        "date": date,
        "commentId": topicId
    };
    $.ajax({
        url: "/subComment",
        data: JSON.stringify(data),
        contentType: "application/json",              //发送至服务器的类型   
        dataType: "json",                                     //预期服务器返回类型  
        type: "post",
        success: function (data) {
            alert(data);
        }
    });
}

function getSubComment(commentId,topicId) {
    $.ajax({
        url: "/subComment/" + commentId,
        data: {},
        contentType: "application/json",              //发送至服务器的类型   
        dataType: "json",                                     //预期服务器返回类型  
        type: "GET",
        success: function (data) {
            var subCommentList = "<div class=\"topic-inner-list\">";

            for (var i in data) {
                var subCommentId = data[i].subCommentId;
                var subCommentFrom = data[i].subCommentFrom;
                var subCommentTo = data[i].subCommentTo;
                var ToCommentId = data[i].commentId;
                var content = data[i].content;

                subCommentList += "<div class=\"topic-inner\">\n" +
                    "        <div class=\"row\">\n" +
                    "                <span >" + "用户" + subCommentFrom + "</span>" +
                    "&nbsp;&nbsp;To&nbsp;&nbsp;" + "<span>" + "用户" + subCommentTo + "&nbsp;：" + "</span>" +
                    "<span>" + content + "</span>" +
                    "         </div>\n" +
                    "                 <div id=\"sub" + subCommentId + "\" class=\"info-bottom\">\n" +
                    "                    <a style=\"float: right\" onclick=\"subCommentModel(" + subCommentFrom + "," + commentId + "," + topicId + "," + subCommentId + ")\">回复</a>\n" +
                    "                </div>" +
                    "</div>"
            }
            subCommentList = "<a  onclick='cancelSubList(" + commentId + "," + topicId + ")' >收起回复</a>" + subCommentList;
            document.getElementById("comment" + commentId).innerHTML = subCommentList;
        }

    });
}

function cancelSubList(commentId,topicId) {
    document.getElementById("comment"+commentId).innerHTML="";
    var list=" <a onclick='getSubComment("+commentId+","+topicId+")' >展开回复</a>"
    document.getElementById("comment"+commentId).innerHTML =list;

}





function commentModel(subCommentFrom,commentId,topicId) {
    document.getElementById(commentId).innerHTML="";

     var list=("<form action=\"/subComment\" method=\"POST\">\n" +
        "                                    <input type=\"hidden\" name=\"subCommentTo\" value=\""+subCommentFrom+"\">\n" +
        "                                    <input type=\"hidden\" name=\"commentId\" value=\""+commentId+"\">\n" +
             "<input type=\"hidden\" name=\"topicId\" value=\""+topicId+"\">\n"+
    "                                    <div class=\"commentModel\">\n" +
        "                                        <div class=\" form-default\">\n" +
        "                                           <div class=\"form-group\">\n" +
        "                                              <input name=\"content\" class=\"form-control\" rows=\"1\">\n" +
        "                                               <input class=\"btn btn-secondary btn-width-lg\" type=\"submit\" value=\"回复\">\n" +
             "<a style='float: right' onclick='cancelReply("+subCommentFrom+","+commentId+","+topicId+")'>收起</a>"+
        "                                           </div>\n" +
        "                                        </div>\n" +
        "                                    </div>"
    );

     document.getElementById(commentId).innerHTML=list;
}

function cancelReply(subCommentFrom,commentId,topicId) {
    document.getElementById(commentId).innerHTML="";
    var list="<a  style=\"float: right\" onclick='commentModel("+subCommentFrom+","+commentId+","+topicId+")' >回复</a>";
    document.getElementById(commentId).innerHTML=list;
}


function subCommentModel(subCommentFrom,commentId,topicId,subCommentId) {
    document.getElementById("sub"+subCommentId).innerHTML="";

    var list=("<form action=\"/subComment\" method=\"POST\">\n" +
        "                                    <input type=\"hidden\" name=\"subCommentTo\" value=\""+subCommentFrom+"\">\n" +
        "                                    <input type=\"hidden\" name=\"commentId\" value=\""+commentId+"\">\n" +
        "<input type=\"hidden\" name=\"topicId\" value=\""+topicId+"\">\n"+
        "                                    <div class=\"commentModel\">\n" +
        "                                        <div class=\" form-default\">\n" +
        "                                           <div class=\"form-group\">\n" +
        "                                              <input name=\"content\" class=\"form-control\" rows=\"1\">\n" +
        "                                               <input class=\"btn btn-secondary btn-width-lg\" type=\"submit\" value=\"回复\">\n" +
        "<a style='float: right' onclick='subCancelReply("+subCommentFrom+","+commentId+","+topicId+","+subCommentId+")'>收起</a>"+
        "                                           </div>\n" +
        "                                        </div>\n" +
        "                                    </div>"
    );

    document.getElementById("sub"+subCommentId).innerHTML=list;
}

function subCancelReply(subCommentFrom,commentId,topicId,subCommentId) {
    document.getElementById("sub"+subCommentId).innerHTML="";
    var list="<a  style=\"float: right\" onclick='subCommentModel("+subCommentFrom+","+commentId+","+topicId+","+subCommentId+")' >回复</a>";
    document.getElementById("sub"+subCommentId).innerHTML=list;
}