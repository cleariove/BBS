var xmlHttp = false;

function initAJAX() {
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                window.alert("不支持ajax")
            }
        }
    }
}

function creatTopic() {
    var title = document.getElementById("title");
    var content =  document.getElementById("content")
    $.ajax({
        url:"web/TopicController",
        type:"post",
        data:{
           "title":title,
            "content":content
        },
        success:function (data) {

        }
    });

}