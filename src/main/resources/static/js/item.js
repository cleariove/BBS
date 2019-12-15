function insertItem()
{
    pushItem(null,"/item/manage/insert");
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
                success:function (data)
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
    pushItem(itemId,"/item/manage/update");
}

function manageItem(itemId)
{
    location.href = "/item/manage?itemId="+itemId;
}

function pushItem(itemId,url)
{
    let jsonData =
        {
            "itemId":itemId,
            "itemName":$("#itemName").val(),
            "itemDescription":$("#itemDescription").val(),
            "manager":$("#itemManager").val(),
        };
    if(jsonData.itemDescription !== '' && jsonData.itemName !== '')
    {
        $.ajax(
            {
                type:"post",
                url:url,
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
}
