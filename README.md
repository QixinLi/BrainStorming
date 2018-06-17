# BrainStorming
jsp_servlet_dwr框架下的头脑风暴游戏

[项目网址](http://tnfb.goodmanlee.top/)

[个人博客](https://qixinli.github.io/)

*欢迎大家关注我的公众号*：liqixin1997

# 更新日记

### 2018/6/18
<li>处理了用户输入字符有可能导致json字符串无法识别的问题
<li>用户间发消息可以输入回车了
<li>现在查找好友、好友列表都能显示好友的自定义头像

### 2018/6/17
重大更新，加入好友功能。享受和好友一起游戏的乐趣。
<li>首页添加好友按钮，可以与自己的好友进行聊天（通过站内信的方式）
<li>允许用户自行搜索-添加好友
<li>被申请添加的用户可在站内信箱中直接选择是否与其建立好友关系
<li>更新了部分UI。默认头像终于不再是渣渣辉了
<li>收信箱有未读邮件时会有小红点通知

### 2018/5/22
<li>答题界面初始数值修改为“1”（而不是之前的“0"），表示当前题号（取代之前的‘表示当前得分’）
<li>此外，数值转变的时间修改为新的一题出现时（取代之前的‘当前题目答完时’）

### 2018/5/17
<li>优化用户反馈功能，添加反馈信息有效字符验证
<li>用户反馈、题目插入界面添加了返回主页的按钮
<li>主页添加注销按钮
<li>优化用户界面显示，解决了刷新时会闪烁的bug
<li>修复了用户发送消息中有尖括号导致json数据解析丢失的bug
<li>修正了由dwr.xml中的一处错误导致web servlet无法运行的bug

### 2018/5/14
<li>支持用户反馈提交到管理员的信箱

### 2018/5/5
<li>备案成功，添加底部备案号。并将地址映射至域名

### 2018/5/2
优化了一些细节，处理了一些bug
<li>管理员保存操作后自动返回主界面
<li>用户插入的题目通过后，来源显示其昵称，而不是用户名

### 2018/4/24
与[CC](https://github.com/336655asd)同学合作
<li>增加了消息处理功能(包括用户间消息的发送和接收)
<li>增加了管理员界面（主要用来审核用户插入的题目、查看用户反馈待添加）
<li>优化UI，解决了一些bug
<li>终于有README了

### 2018/4/19
<li>添加用户自定义头像的功能
<li>优化UI界面

### 2018/4/17
<li>增加领红包功能(需支持支付宝)
<li>优化分享功能

### 2018/4/10
该项目首次提交到github，还有很多做的不完善的地方，希望大家指出
<li>注册、登录功能
<li>用户自主插入题目功能
<li>用户反馈功能
<li>基于dwr框架的答题功能
<li>分数界面的分享功能
