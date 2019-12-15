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
