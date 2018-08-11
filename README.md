# Okgo
Okgo二次封装，减少冗余代码，AES加密与解密，使用过Okgo的朋友应该知道Okgo虽然请求网络方便，但是每次写都要写一遍请求逻辑，我通过加密方式，统一回调，最后结果再解析，达到封装目的，感兴趣的朋友star一下，谢谢

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
