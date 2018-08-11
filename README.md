# Okgo
Okgo二次封装，减少冗余代码，AES加密与解密，使用过Okgo的朋友应该知道Okgo虽然请求网络方便，但是每次写都要写一遍请求逻辑，我通过加密方式，统一回调，最后结果再解析，达到封装目的，感兴趣的朋友star一下，谢谢;

这里是提供一种思路，有的朋友接口返回并不是如下这种格式，但一般都是有code和msg，比如有page，pagesize等等，可以把除code和msg剩下的全部变成string，再返回单独解析，达到请求的封装目的，或者再写一套类似的封装，思路很简单，但效果真不错。

#简介
一般我们的接口返回为：
```java
{
    "code": 200,
    "msg": "SUCCESS",
    "data": []
}
```
或者
```java
  {
    "code": 200,
    "msg": "SUCCESS",
    "data": {
        "userid": 1,
        "nickname": "1",
        "mobile": "1",
        "image": "1",
        "level": 1,
    }
}
```
又或者
```java
{
    "code": 200,
    "msg": "SUCCESS",
    "data": [
        {
            "itemid": "1",
            "itemshorttitle": "123",
        },
        {
            "itemid": "2",
            "itemshorttitle": "123",
        },
        {
            "itemid": "3",
            "itemshorttitle": "123",
        },
        {
            "itemid": "4",
            "itemshorttitle": "123",
        }
    ]
}
```
封装思路是将data返回的json加密，变成string，最后返回到ui线程，最后再解析。具体流程：api包->params包->request包->MainActivity.class
暂时没有写成依赖包，感兴趣的朋友可以Issues咨询你的问题
