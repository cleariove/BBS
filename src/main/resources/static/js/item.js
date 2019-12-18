function insertItem(id)
{
    var itemName=$("#itemName").val();
    var itemDescription=$("#itemDescription").val();
    if(itemName !== "" && itemDescription !== "")
    {
        $.ajax(
            {
                type:"post",
                url:"/item/manage/insert",
                data:
                    {
                        "itemName":itemName,
                        "itemDescription":itemDescription,
                        "manager":id,
                    },
                success:function (data)
                {
                    location.href = data;
                },
                error:function ()
                {
                    alert("未知错误");
                }
            }
        )
    }
    else
        alert("请填写完整名称与简介")
}

function clickInputFile()
{
    document.getElementById("itemFile").click();
}

function checkImgType(element)
{
    if (element.value == "")
    {
        alert("请上传图片");
        return false;
    }
    else
    {
        if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(element.value))
        {
            alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
            element.value = "";
            return false;
        }
    }
    return true;
}

function uploadItemIcon(itemId)
{
    if(checkImgType(document.getElementById("itemFile")))
    {
        var formData = new FormData();
        formData.append("itemId",itemId);
        //这个地方$("#file")得到的是jquery对象，变为$("#file")[0]后为dom对象
        formData.append("itemFile",$("#itemFile")[0].files[0]);
        $.ajax(
            {
                data:formData,
                type:"post",
                url:"/item/manage/upload",
                processData: false,
                contentType: false,
                success:function ()
                {
                    location.reload();
                },
                error:function ()
                {
                    alert("未知错误");
                }
        }
    )}
}

function deleteItem(itemId)
{
    if(confirm("删除后无法找回！是否删除？"))
    {
        $.ajax(
            {
                url:"/item/manage/delete",
                data:{"itemId":itemId},
                type: "post",
                success:function (data)
                {
                    location.href = data;
                },
                error:function ()
                {
                    alert("未知错误");
                }
            }
        )
    }
}

function updateItem(itemId)
{
    let jsonData =
        {
            "itemId":itemId,
            "itemName":$("#itemName").val(),
            "itemDescription":$("#itemDescription").val(),
            "manager":$("#itemManager").val(),
        };
    $.ajax(
        {
            type:"post",
            url:"/item/manage/update",
            data:jsonData,
            success:function (data)
            {
                location.href = data;
            },
            error:function ()
            {
                alert("未知错误");
            }
        }
    )
}

// function manageItem(itemId)
// {
//     location.href = "/item/manage?itemId="+itemId;
// }