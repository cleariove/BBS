
function insertComment() {
    var topicId = document.getElementById("topicId").value;
    alert(topicId);
    var commentContent = document.getElementById("commentContent").value;
    var commentTo = document.getElementById("topicManager").value;
    var date = getDate();
    var data={
        "commentId":"111",
        "commentFrom":"2",
        "commentTo":commentTo,
        "content":commentContent,
        "date":date,
        "topicId":topicId
    };
    $.ajax({
        url:"/topic/comment",
        data:JSON.stringify(data),
        contentType : "application/json",              //发送至服务器的类型   
        dataType : "json",                                     //预期服务器返回类型  
        type:"post",
        success:function (data) {
            alert(data);
        }
    });

}