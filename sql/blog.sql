CREATE DATABASE IF NOT EXISTS blog DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

use blog;

create table if not exists article
(
    id int auto_increment
        primary key,
    title varchar(500) not null comment '文章标题',
    md_content text null comment 'markdown格式文章内容',
    html_content text null comment 'html格式文章内容',
    date datetime default CURRENT_TIMESTAMP not null comment '文章生成时间'
)
    comment '文章表';

create table if not exists message
(
    id int auto_increment comment '主键'
        primary key,
    a_id int not null comment '文章id（关联article的id）',
    content text null comment '留言内容',
    critics varchar(16) null comment '评论人',
    date datetime default CURRENT_TIMESTAMP not null comment '留言日期'
)
    comment '留言表';

create table if not exists user
(
    id int(50) auto_increment comment '主键'
        primary key,
    username varchar(50) not null comment '用户名',
    password varchar(50) not null comment '密码',
    email varchar(32) null comment '电子邮箱',
    sex char(10) not null comment '性别',
    imgUrl varchar(100) null comment '头像图片地址',
    hobby varchar(100) null comment '爱好'
)
    comment '用户表';


INSERT INTO article (id, title, md_content, html_content, date) VALUES (1, 'Java异常处理', '### Java异常处理
* try catch 捕获
* throw 直接抛出', '<h3 id="h3-java-"><a name="Java异常处理" class="reference-link"></a><span class="header-link octicon octicon-link"></span>Java异常处理</h3><ul>
<li>try catch 捕获</li><li>throw 直接抛出</li></ul>
', '2019-12-18 15:02:11');
INSERT INTO article (id, title, md_content, html_content, date) VALUES (2, '如何使用markdown发表文章', '### 如何发表文章

* 这里采用markdown的方式查询
* 建议学习mdrkdown的使用发法进行博客的发布', '<h3 id="h3-u5982u4F55u53D1u8868u6587u7AE0"><a name="如何发表文章" class="reference-link"></a><span class="header-link octicon octicon-link"></span>如何发表文章</h3><ul>
<li>这里采用markdown的方式查询</li><li>建议学习mdrkdown的使用发法进行博客的发布</li></ul>
', '2019-12-18 15:08:08');
INSERT INTO article (id, title, md_content, html_content, date) VALUES (4, '《吊打面试官》系列-ConcurrentHashMap & Hashtable', '作为一个在互联网公司面一次拿一次Offer的面霸，打败了无数竞争对手，每次都只能看到无数落寞的身影失望的离开，略感愧疚（请允许我使用一下夸张的修辞手法）。
于是在一个寂寞难耐的夜晚，我痛定思痛，决定开始写互联网技术栈面试相关的文章，希望能帮助各位读者以后面试势如破竹，对面试官进行360°的反击，吊打问你的面试官，让一同面试的同僚瞠目结舌，疯狂收割大厂Offer！
所有文章的名字只是我的噱头，我们应该有一颗谦逊的心，所以希望大家怀着空杯心态好好学，一起进步。

作者：敖丙
链接：https://juejin.im/post/5df8d7346fb9a015ff64eaf9
来源：掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。', '<p>作为一个在互联网公司面一次拿一次Offer的面霸，打败了无数竞争对手，每次都只能看到无数落寞的身影失望的离开，略感愧疚（请允许我使用一下夸张的修辞手法）。<br>于是在一个寂寞难耐的夜晚，我痛定思痛，决定开始写互联网技术栈面试相关的文章，希望能帮助各位读者以后面试势如破竹，对面试官进行360°的反击，吊打问你的面试官，让一同面试的同僚瞠目结舌，疯狂收割大厂Offer！<br>所有文章的名字只是我的噱头，我们应该有一颗谦逊的心，所以希望大家怀着空杯心态好好学，一起进步。</p>
<p>作者：敖丙<br>链接：<a href="https://juejin.im/post/5df8d7346fb9a015ff64eaf9">https://juejin.im/post/5df8d7346fb9a015ff64eaf9</a><br>来源：掘金<br>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。</p>
', '2019-12-18 23:00:28');
INSERT INTO article (id, title, md_content, html_content, date) VALUES (5, '2019年Dubbo你掌握的如何？快看看这30道高频面试题！', 'Dubbo是一个分布式服务框架，致力于提供高性能和透明化的RPC远程服务调用方案，以及SOA服务治理方案。简单的说，dubbo就是个服务框架，如果没有分布式的需求，其实是不需要用的，只有在分布式的时候，才有dubbo这样的分布式服务框架的需求，并且本质上是个服务调用的东东，说白了就是个远程服务调用的分布式框架（告别Web Service模式中的WSdl，以服务者与消费者的方式在dubbo上注册）。

作者：程序员追风
链接：https://juejin.im/post/5df9f055f265da339772a761
来源：掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。', '<p>Dubbo是一个分布式服务框架，致力于提供高性能和透明化的RPC远程服务调用方案，以及SOA服务治理方案。简单的说，dubbo就是个服务框架，如果没有分布式的需求，其实是不需要用的，只有在分布式的时候，才有dubbo这样的分布式服务框架的需求，并且本质上是个服务调用的东东，说白了就是个远程服务调用的分布式框架（告别Web Service模式中的WSdl，以服务者与消费者的方式在dubbo上注册）。</p>
<p>作者：程序员追风<br>链接：<a href="https://juejin.im/post/5df9f055f265da339772a761">https://juejin.im/post/5df9f055f265da339772a761</a><br>来源：掘金<br>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。</p>
', '2019-12-18 23:03:29');
INSERT INTO article (id, title, md_content, html_content, date) VALUES (6, 'Java中真的只有值传递么？', '关于Java是值传递还是引用传递，网上有不一样的说法。
> 基本类型或基本类型的包装类以及String是值传递，引用类型是引用传递。
> Java中只有值传递

值传递：基本类型的变量在被传递给方法时，传递的是该变量的值（即复制自己的值传递给方法）。

引用传递：引用类型的变量在被传递给方法时， 传递的是该变量的引用（即自己所指向的内存地址）。', '<p>关于Java是值传递还是引用传递，网上有不一样的说法。</p>
<blockquote>
<p>基本类型或基本类型的包装类以及String是值传递，引用类型是引用传递。<br>Java中只有值传递</p>
</blockquote>
<p>值传递：基本类型的变量在被传递给方法时，传递的是该变量的值（即复制自己的值传递给方法）。</p>
<p>引用传递：引用类型的变量在被传递给方法时， 传递的是该变量的引用（即自己所指向的内存地址）。</p>
', '2019-12-18 23:05:14');
INSERT INTO article (id, title, md_content, html_content, date) VALUES (7, '这道面试题我真不知道面试官想要的回答是什么', '面试是一个很奇怪的过程，都是拧螺丝的。但是问的都是如何造火箭，一个敢问，一个敢答。

面试不可怕，可怕的是你get不到面试官的点。

更可怕的是，你觉得你知道答案，但不是面试官想要的。

最可怕的是，面试官也不知道这题的答案是什么', '<p>面试是一个很奇怪的过程，都是拧螺丝的。但是问的都是如何造火箭，一个敢问，一个敢答。</p>
<p>面试不可怕，可怕的是你get不到面试官的点。</p>
<p>更可怕的是，你觉得你知道答案，但不是面试官想要的。</p>
<p>最可怕的是，面试官也不知道这题的答案是什么</p>
', '2019-12-18 23:07:09');
INSERT INTO article (id, title, md_content, html_content, date) VALUES (8, 'SpringBoot就这一篇全搞定', '> 文章收集在 GitHub JavaEgg 中，欢迎star+指导
JavaEgg——《“Java技术员”成长手册》，包含Java基础、框架、存储、搜索、优化、分布式等必备知识，N线互联网开发必备技能兵器谱。

## 1、Spring Boot 简介

简化Spring应用开发的一个框架；
整个Spring技术栈的一个大整合；
J2EE开发的一站式解决方案；

### 2、微服务

微服务：架构风格（服务微化）
一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；
单体应用：ALL IN ONE
微服务：每一个功能元素最终都是一个可独立替换和独立升级的软件单元； 详细参照微服务文档

### 3、环境准备

jdk1.8：Spring Boot 推荐jdk1.7及以上；java version "1.8.0_112"
maven3.x：maven 3.3以上版本；Apache Maven 3.3.9
IntelliJIDEA、STS
SpringBoot 2.2.2.RELEASE； 统一环境；

#### 3.1、MAVEN设置；
给maven 的settings.xml配置文件的proﬁles标签添加
```xml
<profile>
    <id>jdk‐1.8</id>
    <activation>
    <activeByDefault>true</activeByDefault>
    <jdk>1.8</jdk>
    </activation>
	<properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
    </properties>
</profile>
```', '<blockquote>
<p>文章收集在 GitHub JavaEgg 中，欢迎star+指导<br>JavaEgg——《“Java技术员”成长手册》，包含Java基础、框架、存储、搜索、优化、分布式等必备知识，N线互联网开发必备技能兵器谱。</p>
</blockquote>
<h2 id="h2-1-spring-boot-"><a name="1、Spring Boot 简介" class="reference-link"></a><span class="header-link octicon octicon-link"></span>1、Spring Boot 简介</h2><p>简化Spring应用开发的一个框架；<br>整个Spring技术栈的一个大整合；<br>J2EE开发的一站式解决方案；</p>
<h3 id="h3-2-"><a name="2、微服务" class="reference-link"></a><span class="header-link octicon octicon-link"></span>2、微服务</h3><p>微服务：架构风格（服务微化）<br>一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；<br>单体应用：ALL IN ONE<br>微服务：每一个功能元素最终都是一个可独立替换和独立升级的软件单元； 详细参照微服务文档</p>
<h3 id="h3-3-"><a name="3、环境准备" class="reference-link"></a><span class="header-link octicon octicon-link"></span>3、环境准备</h3><p>jdk1.8：Spring Boot 推荐jdk1.7及以上；java version “1.8.0_112”<br>maven3.x：maven 3.3以上版本；Apache Maven 3.3.9<br>IntelliJIDEA、STS<br>SpringBoot 2.2.2.RELEASE； 统一环境；</p>
<h4 id="h4-3-1-maven-"><a name="3.1、MAVEN设置；" class="reference-link"></a><span class="header-link octicon octicon-link"></span>3.1、MAVEN设置；</h4><p>给maven 的settings.xml配置文件的proﬁles标签添加</p>
<pre><code class="lang-xml">&lt;profile&gt;
    &lt;id&gt;jdk‐1.8&lt;/id&gt;
    &lt;activation&gt;
    &lt;activeByDefault&gt;true&lt;/activeByDefault&gt;
    &lt;jdk&gt;1.8&lt;/jdk&gt;
    &lt;/activation&gt;
    &lt;properties&gt;
        &lt;maven.compiler.source&gt;1.8&lt;/maven.compiler.source&gt;
        &lt;maven.compiler.target&gt;1.8&lt;/maven.compiler.target&gt;
        &lt;maven.compiler.compilerVersion&gt;1.8&lt;/maven.compiler.compilerVersion&gt;
    &lt;/properties&gt;
&lt;/profile&gt;
</code></pre>
', '2019-12-19 21:36:19');
INSERT INTO message (id, a_id, content, critics, date) VALUES (1, 8, '这篇文章系的很好，希望博主有续集', '游客6gtl1l7x', '2019-12-20 01:30:53');
INSERT INTO message (id, a_id, content, critics, date) VALUES (2, 8, '博主很用心写得很好，但是还没写完，希望继续写下去', '游客ydn4c4ny', '2019-12-20 01:36:11');
INSERT INTO message (id, a_id, content, critics, date) VALUES (3, 8, '希望可以和博主加个QQ讨论哈这个问题，这个问题确实困扰了我很久了。', '游客19ghw1iz', '2019-12-20 11:00:47');
INSERT INTO message (id, a_id, content, critics, date) VALUES (4, 8, '博主写的太棒了，很赞，会持续关注你写的文章！', '游客xcht60k4', '2019-12-20 11:05:38');
INSERT INTO message (id, a_id, content, critics, date) VALUES (5, 8, '希望博主继续加油', '游客haprquyf', '2019-12-20 11:08:52');
INSERT INTO message (id, a_id, content, critics, date) VALUES (6, 7, '很遗憾的告诉你，我就是那天的面试官，我也不知道我自己要问你什么。', '游客mh7000v7', '2019-12-20 14:34:07');
INSERT INTO message (id, a_id, content, critics, date) VALUES (7, 7, '没事，下次你会知道的', '游客3xq03s3b', '2019-12-20 14:45:14');
INSERT INTO message (id, a_id, content, critics, date) VALUES (8, 7, '加油，你是最棒的', '游客zlckio95', '2019-12-20 14:49:30');
INSERT INTO message (id, a_id, content, critics, date) VALUES (9, 7, '要相信你自己，你一定会知道的。', '游客q30jce3t', '2019-12-20 14:50:26');
INSERT INTO message (id, a_id, content, critics, date) VALUES (10, 7, '你在我眼中是最美的', '游客e9c6lqba', '2019-12-20 14:59:20');
INSERT INTO message (id, a_id, content, critics, date) VALUES (11, 6, '确定java只有值传递', '游客xbtlcpoj', '2019-12-20 15:15:39');
INSERT INTO message (id, a_id, content, critics, date) VALUES (12, 4, '你确定真的可以吊打面试官么？', '游客47pajyhq', '2019-12-20 15:50:57');
INSERT INTO message (id, a_id, content, critics, date) VALUES (13, 8, '用来测试分页的插件', '游客m1lihauu', '2019-12-21 01:28:43');
INSERT INTO message (id, a_id, content, critics, date) VALUES (14, 7, '你是最棒的，加油，下一次就轮到你问面试官了', '游客d6doilos', '2019-12-21 02:02:12');
INSERT INTO message (id, a_id, content, critics, date) VALUES (15, 5, 'dubbo我已经精通了', '游客eumlm7zf', '2019-12-24 00:30:52');
INSERT INTO message (id, a_id, content, critics, date) VALUES (16, 4, '大家好，我是面试官，欢迎大家来吊打我', '游客xt2xjqse', '2019-12-24 02:18:30');
INSERT INTO message (id, a_id, content, critics, date) VALUES (17, 4, '大家好，我希望大家可以吊打我', '游客yfsz8330', '2019-12-24 02:18:52');
INSERT INTO user (id, username, password, email, sex, imgUrl, hobby) VALUES (1, 'yinhao', '123456', 'yinhao@163.com', '男', '/img/avatar.jpg', '英雄联盟 看书 跑步');