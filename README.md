# Jizuz
# springboot + thymeleaf + shiro + mybatis

# sql脚本
/*
Navicat MySQL Data Transfer

Source Server         : jizuz
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : jizuz

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-01-31 01:43:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `aid` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `star` int(32) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(2) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', 'static {} 静态代码块', '<p><span><span data-wiz-span=\"data-wiz-span\"><b><span data-wiz-span=\"data-wiz-span\">static{}</span></b><span class=\"Apple-converted-space\">&nbsp;</span>&nbsp;</span></span><span><span data-wiz-span=\"data-wiz-span\">会在类被加载的时候执行且仅会被执行一次，一般用来初始化静态变量和调用静态方法。</span></span></p><div><span><span data-wiz-span=\"data-wiz-span\"><br></span></span></div><div><p><span><strong>1、static{}语句块执行的时机，即</strong>类被加载准确含义:</span></p><p><span>　　（1）用Class.forName()显示加载的时候;</span></p><p><span>　　（2）实例化一个类的时候，如将main()函数的内容改为:Test t=new Test();//这种形式其实和1相比，原理是相同的，都是显示的加载这个类，读者可以验证Test t=new Test();和Test t=(Test)Class.forName().newInstance();这两条语句效果相同。</span></p><p><span>　　（3）调用类的静态方法的时候，如将main()函数的内容改为:Test.display();</span></p><p><span>　　（4）调用类的静态变量的时候，如将main()函数的内容改为:System.out.println(Test.X);</span></p><p><span>&nbsp;</span></p><p><strong>　　总体来说就这四种情况，但是我们特别需要注意一下两点:</strong></p><p><span>　　（1）调用类的静态常量的时候，是不会加载类的，即不会执行static{}语句块，读者可以自己验证一下(将main()函数的内容改为System.out.println(Test.Y);)，你会发现程序只输出了一个200；(这是java虚拟机的规定，当访问类的静态常量时，如果编译器可以计算出常量的值，则不会加载类，否则会加载类)</span></p><p><span>　　（2）用Class.forName()形式的时候，我们也可以自己设定要不要加载类，如将Class.forName(\"Test\")改为&nbsp;Class.forName(\"Test\",false,StaticBlockTest.class.getClassLoader())，你会发现程序什么都没有输出，即Test没有被加载，static{}没有被执行。</span></p><div><br></div><p><strong>2、static{}语句块的执行次序</strong></p><p><span><strong>　　</strong>（1）当一个类中有多个static{}的时候，按照static{}的定义顺序，从前往后执行；</span></p><p><span><strong>　　</strong>（2）先执行完static{}语句块的内容，才会执行调用语句；</span></p><p><span>　　（3）如果静态变量在定义的时候就赋给了初值(如 static int X=100)，那么赋值操作也是在类加载的时候完成的，并且当一个类中既有static{}又有static变量的时候，同样遵循“先定义先执行”的原则；<br></span></p><p><span>&nbsp; &nbsp; &nbsp;</span><span>（4）访问静态常量，如果编译器可以计算出常量的值，则不会加载类。即如果A类的静态常量值是通过B类的静态常量赋值，则不加载，否则需要加载A类。</span></p></div>', 'Jizuz', '2018-01-29', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('2', 'Stateful/Stateless', '<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    <span style=\"font-size: 18px;\"><span style=\"color: green;\"><span style=\"font-size: 16px;\"><strong>基本概念</strong></span></span></span><br/><strong>有状态</strong>就是有数据存储功能。<span style=\"color: green;\">有状态对象(Stateful Bean)，就是有实例变量的对象</span>&nbsp;，可以保存数据，是非线程安全的。在不同方法调用间不保留任何状态。<br/><strong>无状态</strong>就是一次操作，不能保存数据。<span style=\"color: green;\">无状态对象(Stateless Bean)，就是没有实例变量的对象</span>&nbsp;.不能保存数据，是不变类，是线程安全的。\r\n</p>\r\n<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    <br/>\r\n</p>\r\n<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    <span style=\"font-size: 18px;\"><span style=\"color: green;\"><span style=\"font-size: 16px;\"><strong>总结</strong></span></span></span><br/><span style=\"color: green;\">Stateless无状态用单例Singleton模式，Stateful有状态就用原型Prototype模式。</span>&nbsp;<br/><span style=\"color: green;\">Stateful 有状态是多线程编码的天敌，所以在开发中尽量用Stateless无状态，无状态是不变(immutable)模式的应用，有很多优点：不用管线程和同步的问题</span>&nbsp;，如果值是不可变的，程序不用担心多个线程改变共享状态，所以可以避免线程竞争的bugs. 因为没有竞争，就不用用locks等机制，所以无状态的不变机制，也可以避免产生死锁现象。<br/><br/><span style=\"color: green;\">国外一些哥们的观点</span><br/>Immutable objects may not be altered after their creation. So: Yes, they are some kind of stateless.As immutable objects can not be changed, there is no need for locking - reading access to objects is always threadsafe (when not modifying variables). Therefore, real immutable objects are always threadsafe.<br/><br/><span style=\"font-size: 16px;\"><span style=\"color: green;\"><span style=\"font-size: 12px;\">Rod Johnson的观点</span></span></span><br/>Stateless or Stateful?<br/>Service objects will usually be stateless. Stateless service layers are highly scalable: They pose no replication issues and there is no need to allocate additional resources for every client. (Remember that one of<br/>the key motivations of a middle tier is to share resources between multiple clients.) It is also much easier for stateless service layers to support remote clients, if necessary. A stateless service layer is one concession of object orientation that I find not too painful.<br/>... ...\r\n</p>\r\n<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    If possible, design applications to use a stateless service layer. Hold state in the web tier, rather than in the business logic tier, if possible.<br/>\r\n</p>\r\n<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    <br/>\r\n</p>\r\n<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    Java代码<br/>\r\n</p>\r\n<ol style=\"line-height: 1.4em; margin-bottom: 1.5em; font-size: 1em; padding: 0px;\" class=\" list-paddingleft-2\">\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            <strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">class</span>&nbsp;</strong>&nbsp;StatefulBean&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">int</span>&nbsp;</strong>&nbsp;state; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;由于多线程环境下，user是引用对象，是非线程安全的</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;</strong>&nbsp;User&nbsp;user; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">int</span>&nbsp;</strong>&nbsp;getState()&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">return</span>&nbsp;</strong>&nbsp;state; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">void</span>&nbsp;</strong>&nbsp;setState(&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">int</span>&nbsp;</strong>&nbsp;state)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">this</span>&nbsp;</strong>.state&nbsp;=&nbsp;state; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;</strong>&nbsp;User&nbsp;getUser()&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">return</span>&nbsp;</strong>&nbsp;user; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">void</span>&nbsp;</strong>&nbsp;setUser(User&nbsp;user)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">this</span>&nbsp;</strong>.user&nbsp;=&nbsp;user; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            } &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            <strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">class</span>&nbsp;</strong>&nbsp;StatelessBeanService&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;虽然有billDao属性，但billDao是没有状态信息的，是Stateless&nbsp;Bean.</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;BillDao&nbsp;billDao; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;</strong>&nbsp;BillDao&nbsp;getBillDao()&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">return</span>&nbsp;</strong>&nbsp;billDao; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">void</span>&nbsp;</strong>&nbsp;setBillDao(BillDao&nbsp;billDao)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">this</span>&nbsp;</strong>.billDao&nbsp;=&nbsp;billDao; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;</strong>&nbsp;List&lt;User&gt;&nbsp;findUser(String&nbsp;Id)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            <strong><span style=\"color: rgb(127, 0, 85);\">return</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">null</span>&nbsp;</strong>; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            }&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n</ol>\r\n<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    <br/><span style=\"font-size: 18px;\"><span style=\"color: green;\"><span style=\"font-size: 16px;\">单例模式中的有状态和无状态:</span>&nbsp;</span></span><br/><span style=\"color: green;\">单例类可以是有状态的（stateful），一个有状态的单例对象一般也是可变（mutable）单例对象</span>&nbsp;。 有状态的可变的单例对象常常当做状态库（repositary）使用。比如一个单例对象TaskCache（Spring中配为singleton）可以 持有一个AtomicLong类型的属性，用来给一个系统提供一个数值惟一的序列号码，作为任务通迅管理的ID生成器。同时，一个单例类也可以持有一个聚 集，从而允许存储多个状态，如示例中的ExpiringMap缓存任务列表。<br/>代码示例：\r\n</p>\r\n<p>\r\n    Java代码\r\n</p>\r\n<ol style=\"line-height: 1.4em; margin-bottom: 1.5em; font-size: 1em; padding: 0px;\" class=\" list-paddingleft-2\">\r\n    <li>\r\n        <p>\r\n            <strong><span style=\"color: rgb(127, 0, 85);\">import</span>&nbsp;</strong>&nbsp;java.util.concurrent.atomic.AtomicLong; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            <strong><span style=\"color: rgb(127, 0, 85);\">import</span>&nbsp;</strong>&nbsp;org.apache.mina.util.ExpiringMap; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            <strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">class</span>&nbsp;</strong>&nbsp;TaskCache&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;请求超时</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">private</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">short</span>&nbsp;</strong>&nbsp;requestTimeout; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;这个缓存Map是线程安全,并且有定时超时功能</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">private</span>&nbsp;</strong>&nbsp;ExpiringMap&lt;String,&nbsp;Object&gt;&nbsp;tasksMap&nbsp;=&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">new</span>&nbsp;</strong>&nbsp;ExpiringMap&lt;String,&nbsp;Object&gt;(); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;线程安全的原子类,示例有状态的单例类</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">private</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">static</span>&nbsp;</strong>&nbsp;AtomicLong&nbsp;seqNo&nbsp;=&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">new</span>&nbsp;</strong>&nbsp;AtomicLong(&nbsp;<span style=\"color: rgb(192, 0, 0);\">1</span>&nbsp;); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;示例有状态的单例类</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;</strong>&nbsp;Long&nbsp;nextSeqNo()&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">return</span>&nbsp;</strong>&nbsp;seqNo.getAndIncrement(); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">void</span>&nbsp;</strong>&nbsp;setRequestTimeout(&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">short</span>&nbsp;</strong>&nbsp;requestTimeout)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">this</span>&nbsp;</strong>.requestTimeout&nbsp;=&nbsp;requestTimeout; &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;启动过期检测</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">void</span>&nbsp;</strong>&nbsp;startExpiring()&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tasksMap.getExpirer().setTimeToLive(requestTimeout); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tasksMap.getExpirer().startExpiringIfNotStarted(); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;停止过期检测</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">void</span>&nbsp;</strong>&nbsp;stopExpiring()&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tasksMap.getExpirer().stopExpiring(); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;取任务列表.</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;</strong>&nbsp;Object&nbsp;getTasks(String&nbsp;key)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">return</span>&nbsp;</strong>&nbsp;tasksMap.get(key); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;去除任务列表.</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;</strong>&nbsp;Object&nbsp;removeTasks(String&nbsp;key)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">return</span>&nbsp;</strong>&nbsp;tasksMap.remove(key); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(0, 130, 0);\">//&nbsp;添加任务列表.</span>&nbsp;&nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong><span style=\"color: rgb(127, 0, 85);\">public</span>&nbsp;&nbsp;&nbsp;<span style=\"color: rgb(127, 0, 85);\">void</span>&nbsp;</strong>&nbsp;addTasks(String&nbsp;key,&nbsp;Object&nbsp;value)&nbsp;{ &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;tasksMap.put(key,&nbsp;value); &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            &nbsp;&nbsp;&nbsp;&nbsp;} &nbsp;&nbsp;\r\n        </p>\r\n    </li>\r\n    <li>\r\n        <p>\r\n            } &nbsp;\r\n        </p>\r\n    </li>\r\n</ol>\r\n<p style=\"font-size: 14px; font-variant-numeric: normal; font-variant-east-asian: normal; white-space: normal; text-size-adjust: auto; padding-bottom: 0px; line-height: 25px; font-family: Helvetica, Tahoma, Arial, sans-serif; padding-top: 0px;\">\r\n    <span style=\"color: green;\">单例类也可以是没有状态的（stateless）</span>&nbsp;，仅用做提供工具性函数的对象。既然是为了提供工具性函数，也就没有必要创建多个实例，因此使用单例模式很合适。平常的单例类都是没有状态的，这里就不示例了。一个没有状态的单例类也就是不变（Immutable）单例类。关于不变模式，请参考&nbsp;<a href=\"http://www.javaeye.com/topic/959751\" target=\"_blank\" style=\"color: rgb(16, 138, 198);\"><span style=\"color: rgb(0, 102, 153);\">http://www.javaeye.com/topic/959751</span>&nbsp;</a>\r\n</p>\r\n<p>\r\n    <br/>\r\n</p>', 'Jizuz', '2018-01-29', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('3', 'Runnable & Callable', '<p>Java中使用并发编程的时候，我们通常会实现两个接口：<strong>Runnable</strong>和<strong>Callable</strong>；</p><p>这两个接口的区别在于：</p><p>&nbsp;&nbsp;&nbsp;&nbsp;Runnable接口里的run()方法返回的是void类型，通常不需要线程处理返回结果时使用；<br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;Callable接口里的call()方法返回任何合法类型，在处理需要线程返回结果时使用；</p><pre><span>public interface </span>Callable&lt;<span>V</span>&gt; {<br>    <span>/**<br></span><span> &nbsp; &nbsp; * Computes a result, or throws an exception if unable to do so.<br></span><span> &nbsp; &nbsp; *<br></span><span> &nbsp; &nbsp; * </span><span>@return </span><span>computed result<br></span><span> &nbsp; &nbsp; * </span><span>@throws </span><span>Exception if unable to compute a result<br></span><span> &nbsp; &nbsp; */<br></span><span> &nbsp; &nbsp;</span><span>V </span><span>call</span>() <span>throws </span>Exception<span>;<br></span>}</pre><p><br></p><p>ex1.Runnable</p><pre><span>import</span><span> </span>java.util.ArrayList<span>;<br></span><span>import </span>java.util.concurrent.ExecutorService<span>;<br></span><span>import </span>java.util.concurrent.Executors<span>;<br></span><span>import </span>java.util.concurrent.Future<span>;<br></span><span><br></span><span>/**<br></span><span> * Created by jizuz on 17-4-1.<br></span><span> */<br></span><span>public class </span>RunnableTask <span>implements </span>Runnable{<br>    <span>public void </span><span>run</span>() {<br>        System.<span>out</span>.println(<span>\"ok, runnable!\"</span>)<span>;<br></span><span> &nbsp; &nbsp;</span>}<br><br>    <span>public static void </span><span>main</span>(String args[]) {<br>        ExecutorService executor = Executors.<span>newSingleThreadExecutor</span>()<span>;<br></span><span> &nbsp; &nbsp; &nbsp; &nbsp;</...', 'Jizuz', '2018-01-29', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('4', '苏宁', '<strong>苏宁金融</strong> 金融研发中心 <em>商旅产品开发部</em>', 'Jizuz', '2018-01-30', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('5', 'python', '<strong>PYTHON</strong> 核心编程', 'Jizuz', '2018-01-30', '0', 'A', '2');

-- ----------------------------
-- Table structure for t_photo
-- ----------------------------
DROP TABLE IF EXISTS `t_photo`;
CREATE TABLE `t_photo` (
  `oid` bigint(32) NOT NULL,
  `tid` bigint(32) NOT NULL COMMENT '主题',
  `path` varchar(255) DEFAULT NULL COMMENT '图片在服务器路径',
  `author` varchar(255) DEFAULT NULL COMMENT '图片作者',
  `date` date DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL COMMENT '图片描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_photo
-- ----------------------------
INSERT INTO `t_photo` VALUES ('1', '1', '/img/bg.jpg', 'Jizuz', '2018-01-24', '背景');
INSERT INTO `t_photo` VALUES ('2', '2', 'img/photos/IMG_20180126141792512.JPG', 'Jizuz', '2018-01-24', '南京');
INSERT INTO `t_photo` VALUES ('3', '2', 'img/photos/IMG_20180126142032134.JPG', 'jizuz', '2018-01-24', '南京');
INSERT INTO `t_photo` VALUES ('4', '2', 'img/photos/IMG_20180126143108267.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('5', '3', 'img/photos/IMG_20180126143117687.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('6', '3', 'img/photos/IMG_20180130233111243.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('7', '4', 'img/photos/IMG_20180130233345658.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('8', '4', 'img/photos/IMG_20180130233452987.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('9', '4', 'img/photos/IMG_20180130233509876.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('10', '4', 'img/photos/IMG_20180130233634647.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('11', '4', 'img/photos/IMG_20180130233723257.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('12', '3', 'img/photos/IMG_20180130233836746.jpg', 'Jizuz', '2018-01-30', null);
INSERT INTO `t_photo` VALUES ('13', '3', 'img/photos/IMG_20180130233912547.jpg', 'Jizuz', '2018-01-30', null);
INSERT INTO `t_photo` VALUES ('17', '2', 'img/photos/IMG_20180131012056974.jpg', 'Jizuz', '2018-01-31', '新的');
INSERT INTO `t_photo` VALUES ('18', '2', 'img/photos/IMG_20180131012348392.jpg', 'Jizuz', '2018-01-31', '斯柯达');
INSERT INTO `t_photo` VALUES ('19', '2', 'img\\photos\\IMG_20180131012348392.jpg', 'Jizuz', '2018-01-31', '大学');
INSERT INTO `t_photo` VALUES ('20', '2', 'img\\photos\\IMG_20180131012348392.jpg', 'Jizuz', '2018-01-31', '当时');

-- ----------------------------
-- Table structure for t_photo_theme
-- ----------------------------
DROP TABLE IF EXISTS `t_photo_theme`;
CREATE TABLE `t_photo_theme` (
  `tid` bigint(32) NOT NULL,
  `theme` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_photo_theme
-- ----------------------------
INSERT INTO `t_photo_theme` VALUES ('1', '系统', 'A', null);
INSERT INTO `t_photo_theme` VALUES ('2', '南京', 'A', null);
INSERT INTO `t_photo_theme` VALUES ('3', '青海', 'A', null);
INSERT INTO `t_photo_theme` VALUES ('4', '镇江', 'A', null);

-- ----------------------------
-- Table structure for t_state
-- ----------------------------
DROP TABLE IF EXISTS `t_state`;
CREATE TABLE `t_state` (
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_state
-- ----------------------------
INSERT INTO `t_state` VALUES ('A', '可用');
INSERT INTO `t_state` VALUES ('X', '失效');

-- ----------------------------
-- Table structure for t_time_axis
-- ----------------------------
DROP TABLE IF EXISTS `t_time_axis`;
CREATE TABLE `t_time_axis` (
  `id` int(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `time_point` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_time_axis
-- ----------------------------
INSERT INTO `t_time_axis` VALUES ('1', '', '这是第一条！', 'Jizuz', '2018-01-17 23:02:43');
INSERT INTO `t_time_axis` VALUES ('2', '第二条', '这是第二条！', 'Jizuz', '2018-01-17 23:03:30');
INSERT INTO `t_time_axis` VALUES ('3', null, '这是第三条！', 'Jizuz', '2018-01-17 23:05:02');
INSERT INTO `t_time_axis` VALUES ('4', null, '这是第四条！', 'Jizuz', '2018-01-17 23:05:06');
INSERT INTO `t_time_axis` VALUES ('5', null, '这是第五条！', 'Jizuz', '2018-01-17 23:05:12');
INSERT INTO `t_time_axis` VALUES ('6', null, '这是第六条！', 'Jizuz', '2018-01-17 23:05:16');

-- ----------------------------
-- Table structure for u_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('1', 'view', '可查看');
INSERT INTO `u_permission` VALUES ('2', 'edit', '可编辑');
INSERT INTO `u_permission` VALUES ('3', 'delete', '可删除');
INSERT INTO `u_permission` VALUES ('4', 'add', '可增加');
INSERT INTO `u_permission` VALUES ('5', 'upload', '可上传');
INSERT INTO `u_permission` VALUES ('6', 'download', '可下载');

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `u_role` VALUES ('2', 'member', '会员');
INSERT INTO `u_role` VALUES ('3', 'visitor', '游客');

-- ----------------------------
-- Table structure for u_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role_permission
-- ----------------------------
INSERT INTO `u_role_permission` VALUES ('1', '1', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '2', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '3', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '4', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '5', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '6', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '1', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '2', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '4', 'A', null);
INSERT INTO `u_role_permission` VALUES ('3', '1', 'A', null);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `uid` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `home_address` varchar(255) DEFAULT NULL,
  `now_address` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('10000', 'Jizuz', '仇鹏飞', '111111', '1992-07-04', '男', '18251901820', 'qpf123@outlook.com', '江苏.南通', '江苏.南京', '苏宁金融');
INSERT INTO `u_user` VALUES ('10001', 'Laoga', '葛沁阳', '111111', '1993-04-18', '男', '18251901682', 'ge.qinyang@zshoon.com', '江苏.常州', '江苏.南京', '亚信科技');

-- ----------------------------
-- Table structure for u_user_role
-- ----------------------------
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_role
-- ----------------------------
INSERT INTO `u_user_role` VALUES ('10000', '1', 'A', '');
INSERT INTO `u_user_role` VALUES ('10001', '2', 'A', null);
