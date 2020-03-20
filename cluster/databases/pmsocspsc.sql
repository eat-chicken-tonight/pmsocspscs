-- MySQL dump 10.13  Distrib 5.7.29, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: pmsocspsc
-- ------------------------------------------------------
-- Server version	5.7.29-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pm_finish_attach`
--

DROP TABLE IF EXISTS `pm_finish_attach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_finish_attach` (
  `attach_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `finish_info_id` int(11) DEFAULT NULL COMMENT '结题id',
  `attach_name` varchar(1000) DEFAULT NULL COMMENT '附件名称',
  `attach_path` varchar(1000) DEFAULT NULL COMMENT '附件路径',
  `attach_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`attach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='结题附件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_finish_attach`
--

LOCK TABLES `pm_finish_attach` WRITE;
/*!40000 ALTER TABLE `pm_finish_attach` DISABLE KEYS */;
INSERT INTO `pm_finish_attach` VALUES (3,4,'大赛项目汇总表.xlsx','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/2835914127262355613/大赛项目汇总表.xlsx',1),(4,NULL,'5.mitmf中间人攻击框架.pdf','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1055181270009673088/5.mitmf中间人攻击框架.pdf',0),(6,NULL,'04.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/42559550673328792/04.jpg',0),(7,NULL,'04.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/63680428158027500/04.jpg',0),(18,5,'cat.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1637590571062446135/cat.jpg',0),(24,6,'0ca45fb7418b6aef9d253529c4f7bc37 (4).jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/4195791933381684076/0ca45fb7418b6aef9d253529c4f7bc37 (4).jpg',0),(25,7,'53c4a3ad158f8.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/8819646787927127602/53c4a3ad158f8.jpg',0),(31,8,'53c4a3ad158f8.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/8819646787927127602/53c4a3ad158f8.jpg',0),(32,9,'5a096bd4c19ef.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/2206003236618764700/5a096bd4c19ef.jpg',0),(33,10,'9a39573284bc47f28bfc55f15adf0814.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/4771807004171865158/9a39573284bc47f28bfc55f15adf0814.jpg',0);
/*!40000 ALTER TABLE `pm_finish_attach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_finish_info`
--

DROP TABLE IF EXISTS `pm_finish_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_finish_info` (
  `finish_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `item_info_id` int(11) DEFAULT NULL COMMENT '立项项目id',
  `finish_info_status` int(11) DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  `finish_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`finish_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='结题信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_finish_info`
--

LOCK TABLES `pm_finish_info` WRITE;
/*!40000 ALTER TABLE `pm_finish_info` DISABLE KEYS */;
INSERT INTO `pm_finish_info` VALUES (4,3,1,1,0),(5,16,2,1,0),(6,17,2,2,0),(8,7,2,1,0),(9,16,0,1,0),(10,16,0,1,0);
/*!40000 ALTER TABLE `pm_finish_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_finish_info_retreat`
--

DROP TABLE IF EXISTS `pm_finish_info_retreat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_finish_info_retreat` (
  `retreat_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `finish_info_id` int(11) DEFAULT NULL COMMENT '结题申请Id',
  `retreat_advise` text COMMENT '回退意见',
  `retreat_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`retreat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='结题回退表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_finish_info_retreat`
--

LOCK TABLES `pm_finish_info_retreat` WRITE;
/*!40000 ALTER TABLE `pm_finish_info_retreat` DISABLE KEYS */;
INSERT INTO `pm_finish_info_retreat` VALUES (6,5,'1111111111111111111111111111111',0),(7,5,'22222222222222222222222222',0),(8,6,'teacher',0),(9,8,'ddddddddddddddd',0);
/*!40000 ALTER TABLE `pm_finish_info_retreat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_fund_info`
--

DROP TABLE IF EXISTS `pm_fund_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_fund_info` (
  `budget_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `register_cost` double DEFAULT NULL COMMENT '参赛注册费',
  `travel_cost` double DEFAULT NULL COMMENT '差旅费',
  `train_cost` double DEFAULT NULL COMMENT '培训费',
  `review_cost` double DEFAULT NULL COMMENT '评审费',
  `guide_cost` double DEFAULT NULL COMMENT '指导费',
  `leader_cost` double DEFAULT NULL COMMENT '领队费',
  `organize_cost` double DEFAULT NULL COMMENT '组织费',
  `consumables_cost` double DEFAULT NULL COMMENT '耗材费',
  `award_cost` double DEFAULT NULL COMMENT '奖金',
  `another_cost` double DEFAULT NULL COMMENT '其他费用',
  `total_cost` double DEFAULT NULL COMMENT '合计',
  `budget_info_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  `item_info_id` int(11) DEFAULT NULL,
  `finish_info_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`budget_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='经费预算/实际支出信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_fund_info`
--

LOCK TABLES `pm_fund_info` WRITE;
/*!40000 ALTER TABLE `pm_fund_info` DISABLE KEYS */;
INSERT INTO `pm_fund_info` VALUES (3,10000,3000,1000,3000,5000,400,2000,2000,30000,0,100000,0,3,NULL),(4,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,100000,0,4,NULL),(5,2000,2000,2000,2000,2000,2000,2000,2000,2000,2000,100000,0,5,NULL),(6,1,1,1,1,1,1,1,1,1,1,100000,0,6,NULL),(7,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,10000,0,7,NULL),(8,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,10000,0,8,NULL),(9,2000,1998,2000,2000,2000,2000,2000,2000,1996,2000,19994,0,9,NULL),(10,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,100000,0,10,NULL),(13,1,1,1,1,1,1,1,1,1,1,10,0,11,4),(14,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,10000,0,12,NULL),(15,1,1,1,1,1,1,1,1,1,1,10,0,13,NULL),(16,2,2,2,2,2,2,2,2,22,2,40,0,14,NULL),(17,5,5,55,5,5,5,5,5,55,5,150,0,16,NULL),(18,3,3,3,3,3,3,3,3,3,3,30,0,NULL,5),(19,1000,1000,1000,1000,1000,1000,1000,1000,2000,1000,11000,0,17,NULL),(20,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,30000,0,NULL,6),(21,5000,5000,5000,5000,5000,5000,5000,5000,5000,5000,50000,0,NULL,8),(22,3000,3000,3000,3000,3000,3000,3000,3000,3000,3000,30000,0,18,NULL),(23,10000,10000,11,11,10,11,11,11,11,11,20087,0,19,NULL),(24,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,100000,0,20,NULL),(25,2000,2000,2000,2000,2000,2000,2000,2000,1995,2000,19995,0,NULL,10);
/*!40000 ALTER TABLE `pm_fund_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_item_attach`
--

DROP TABLE IF EXISTS `pm_item_attach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_item_attach` (
  `attach_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_info_id` int(11) DEFAULT NULL COMMENT '项目立项id',
  `attach_name` varchar(1000) DEFAULT NULL COMMENT '附件名称',
  `attach_path` varchar(1000) DEFAULT NULL COMMENT '附件存放路径',
  `attach_is_del` int(11) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`attach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='附件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_item_attach`
--

LOCK TABLES `pm_item_attach` WRITE;
/*!40000 ALTER TABLE `pm_item_attach` DISABLE KEYS */;
INSERT INTO `pm_item_attach` VALUES (2,3,'04 (11).jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/4478556501874929925/04 (11).jpg',0),(3,4,'Association for Computing Machinery.pdf','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1335022146254504892/Association for Computing Machinery.pdf',0),(4,5,'Association for Computing Machinery.pdf','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1335022146254504892/Association for Computing Machinery.pdf',0),(5,6,'Association for Computing Machinery.pdf','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1335022146254504892/Association for Computing Machinery.pdf',0),(6,7,'Association for Computing Machinery.pdf','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1335022146254504892/Association for Computing Machinery.pdf',0),(12,9,'04 (2).jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/295794194601984837/04 (2).jpg',0),(13,8,'5.mitmf中间人攻击框架.pdf','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/3291027805771748566/5.mitmf中间人攻击框架.pdf',0),(15,11,'50a9ef0c01fb0.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/7289921613250274879/50a9ef0c01fb0.jpg',0),(18,12,'4-160PQ61502.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/6334051653149992546/4-160PQ61502.jpg',0),(20,14,'寒流来袭.mp3','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/48831577943580843/寒流来袭.mp3',0),(27,16,'50a9ef0c01fb0.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1366603192064963669/50a9ef0c01fb0.jpg',0),(28,17,'mozilla.pdf','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/4986524870404151448/mozilla.pdf',0),(29,18,'寒流来袭.mp3','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/1461920091711898486/寒流来袭.mp3',0),(30,20,'4-14120Q54144.jpg','/home/mikey/DATA/MIKEY/IDEAWorkSpace/PMSOCSPSC/target/8478142461216317469/4-14120Q54144.jpg',0);
/*!40000 ALTER TABLE `pm_item_attach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_item_info`
--

DROP TABLE IF EXISTS `pm_item_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_item_info` (
  `item_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `match_name` varchar(1000) DEFAULT NULL COMMENT '赛事名称',
  `match_unit` varchar(1000) DEFAULT NULL COMMENT '组赛单位',
  `match_type` int(11) DEFAULT NULL COMMENT '赛制：0：单人赛、1：团体赛',
  `user_id` bigint(20) DEFAULT NULL COMMENT '项目负责人',
  `match_start_time` date DEFAULT NULL COMMENT '竞赛起始日期',
  `match_end_time` date DEFAULT NULL COMMENT '竞赛结束日期',
  `match_major` varchar(1000) DEFAULT NULL COMMENT '专业',
  `host_unit` varchar(1000) DEFAULT NULL COMMENT '竞赛主办单位',
  `undertake_unit` varchar(1000) DEFAULT NULL COMMENT '竞赛承办单位',
  `item_info_time` date DEFAULT NULL COMMENT '申请立项日期',
  `match_sign` text COMMENT '论证组赛的目的和意义',
  `item_info_status` int(11) DEFAULT '0' COMMENT '审核状态',
  `item_info_finish` int(11) DEFAULT '0' COMMENT '是否已经结题',
  `item_info_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  `user_name` char(100) DEFAULT NULL COMMENT '负责人姓名',
  PRIMARY KEY (`item_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='项目立项申请表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_item_info`
--

LOCK TABLES `pm_item_info` WRITE;
/*!40000 ALTER TABLE `pm_item_info` DISABLE KEYS */;
INSERT INTO `pm_item_info` VALUES (3,'软件杯','南京组委会',0,1,'2019-12-02','2020-11-25','软件工程','南京组委会','南京组委会','2019-11-01','中国软件杯”由工业和信息化部、教育部、江苏省人民政府主办，本届参赛队伍覆盖千余所高校，其中普通本科高校600余所，高职院校200余所，211、985高校百余所，累计近万名大学生参赛。第八届大赛赛题更加贴近行业发展需求，贴近当前技术热点，涉及工业互联网，大数据、云计算、物联网、人工智能、虚拟现实、智能制造、信息安全等，以企业的技术难题作为出题素材，是“中国软件杯”的最大创意，推动了产教深度融合，赛题征集过程询问了300家企业，赛题全部来源于企业实际开发的需求，能够考察学生的实际操作能力与创新能力，提交的优秀作品也给企业的研发提供了参考。',2,1,0,'许传本'),(4,'ACM','ACM',1,1,'2019-11-14','2019-11-20','ACM','ACM','ACM','2019-11-21','2020 ACM General Election Slate Announcement\nIn accordance with the Constitution and Bylaws of the ACM, the Nominating Committee hereby submits the following slate of nominees for ACM\'s officers. In addition to the officers of the ACM, five Members at Large will be elected. ',0,0,0,'ACM'),(5,'Codeforces 竞赛','Codeforces 竞赛',1,1,'2019-11-28','2019-11-27','Codeforces 竞赛','俄罗斯Codeforces','俄罗斯Codeforces','2019-11-06','Codeforce 目前由 Telegram 赞助，是一个俄罗斯的在线判题网站，著名 ACM 选手 tourist 就在上面刷题，有不少国内外牛人。Codeforces 上举行的比赛一般有 4 种，分别是 Div.1，Div.2，Div.3 和 Educational Round，其中 Div 随着数字的增加难度依次下降，对于 Educational Codeforces Round 来说一般题目较多，采用扩展 ACM-ICPC 的模式，即提交代码立即出结果，错误一次计 10 分钟罚时。',0,0,0,'Codeforces 竞赛'),(6,'Kaggle','Kaggle',0,1,'2019-11-21','2019-11-26','Kaggle','Kaggle','Kaggle','2019-11-13','Kaggle 是全球最著名的数据建模和数据分析竞赛平台之一。数据挖掘领域的 ACM/ICPC，大部分的 Kaggle 比赛是 Data Mining(DM) 比赛。企业和研究者可在其上发布数据，用户竞赛以产生最好的模型。Kaggle 的标语是：Your Home for Data Science，可以窥见他们的追求。Kaggle 上的一些比赛（Featured 比赛等）是有金钱奖励的，当然这种比赛通常都针对企业的需求，难度较高，竞争也较为激烈。也有一些奖金较少的比赛，和没有奖金“练习赛“。基本上满足了各个水平阶段数据分析从业者的竞赛需求。Kaggle 社区中包含了讨论（Discussion）和学习（Learn）两个模块，作为日常学习的补充和提高都是不错的选择。根据维基百科的描述，Kaggle 在全球范围内拥有将近 20 万名数据科学家，所形成的社区拥有很好的学术氛围。',0,0,0,'Kaggle'),(7,'阿里天池','阿里天池',0,1,'2019-11-14','2019-11-06','阿里天池','阿里天池','阿里天池','2019-11-19','天池大数据竞赛由阿里巴巴于 2014 年发起，现在已经成为国内最具影响力的数据科学平台。天池一共有 5 类比赛，涉及算法，创新应用，传统程序设计（包括网络安全等），可视化竞赛，以及帮助新人培养兴趣和入门的新人赛。天池的比赛奖金丰厚，难度也较大，由于许多比赛面向全社会，有相当一部分企业组成参赛队伍，可以说非常具有挑战性。',2,1,0,'阿里天池'),(8,'Alexa Prize','Alexa Prize',0,1,'2019-11-27','2019-10-31','Alexa Prize','Alexa Prize','Alexa Prize','2019-11-12','Alexa Prize 是亚马逊组织的一个 NLP 比赛。其核心是构建基于 Alexa（亚马逊的只能语音助手）的一套系统，在 10 分钟内尽可能的与用户进行对话。目的有点类似于微软小冰。Alexa Prize 的有趣之处在于：在复审阶段，参赛者构建的系统会被随机发送到全美所有亚马逊语音助手的用户手上，用户在完成对话后，亚马逊会邀请用户给这次对话打分。最终的平均得分结果将决定前三名。也就是说，这套系统的优劣是完全基于用户评判的。亚马逊语音助手在全美的用户量极大，所有参赛队伍都要经历大量用户的考评，非常具有实际意义。',1,0,0,'Alexa Prize'),(9,'KDD CUP','KDD CUP',0,1,'2019-10-31','2019-11-19','KDD CUP','KDD CUP','KDD CUP','2019-11-13','SIGKDD 是数据挖掘领域的顶会，从 1997 年开始，每年都会举办国际知识发现和数据挖掘竞赛（KDD CUP），在数据挖掘领域，这个比赛的含金量相当高，可以说是目前是数据挖掘领域最有影响力的赛事之一。',0,0,0,'KDD CUP'),(11,'DRIVEN DATA','DRIVEN DATA',0,1,'2019-11-15','2019-11-20','DRIVEN DATA','DRIVEN DATA','DRIVEN DATA','2019-11-19','Driven Data 举办的数据科学比赛大部分都集中在医疗，教育，公共服务等领域。在暑假中，想让你的技能应用于实际领域，锻炼实际问题解决能力，同时为社会发展做出贡献，你可以参与到 Driven Data 的比赛当中。',0,0,0,'DRIVEN DATA'),(12,'广西第一届人工智能设计大赛','桂电组委会',0,1,'2019-11-13','2019-11-04','软件工程/计本/物联网','华为','桂电组委会','2019-06-13','1000',0,0,0,'陈聪'),(13,'的','d',0,1,'2019-11-29','2019-11-27','1','1','1','2019-12-25','1',0,0,0,'1'),(14,'2','2',0,1,'2019-12-27','2019-12-03','2','2','2','2019-12-03','2',0,0,0,'2'),(15,'5','5',0,1,'2019-12-05','2019-12-17','5','5','5','2019-12-25','5',0,0,0,'5'),(16,'5','5',0,1,'2019-12-05','2019-12-17','5','5','5','2019-12-25','5',2,1,0,'5'),(17,'teacher','teacher',0,2,'2019-12-20','2019-12-18','teacher','teacher','teacher','2019-12-06','在微服务的概念成型之前，绝大部分基于WEB的应用都是使用单体的风格来进行构建的。在单体架构中，应用程序作为单个可部署的软件制品交付，\n所有的UI(用户接口)、业务、数据库访问逻辑都被打包在一个应用程序中并且部署在一个应用服务器上。\n随着单体应用的规模和复杂度的增长，在该应用上进行开发的团队的沟通与合作成本没有减少。\n当各个团队需要修改代码时，整个应用程序都要重新构建、重新测试和部署。',2,0,0,'teacher'),(18,'teacher2','teacher2',0,2,'2019-12-03','2019-12-03','teacher2','teacher2','teacher2','2019-12-03','\ngRPC\n是一个高性能、开源和通用的 RPC 框架，面向移动和 HTTP/2 设计。目前提供 C、Java 和 Go 语言版本，分别是：grpc, grpc-java, grpc-go. 其中 C 版本支持 C, C++, Node.js, Python, Ruby, Objective-C, PHP 和 C# 支持.\n\ngRPC 基于 HTTP/2 标准设计，带来诸如双向流、流控、头部压缩、单 TCP 连接上的多复用请求等特。这些特性使得其在移动设备上表现更好，更省电和节省空间占用。',1,0,0,'teacher2'),(19,'ACM','ACM',1,1,'2020-03-19','2020-03-27','ACM','ACM','ACM','2020-03-11','11',0,0,0,'ACM'),(20,'ACM','ACM',1,1,'2020-03-06','2020-03-12','ACM','ACM','ACM','2020-03-05','ACM',0,0,0,'ACM');
/*!40000 ALTER TABLE `pm_item_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_item_info_retreat`
--

DROP TABLE IF EXISTS `pm_item_info_retreat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_item_info_retreat` (
  `retreat_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_info_id` int(11) DEFAULT NULL COMMENT '项目立项申请Id',
  `retreat_advise` text COMMENT '回退意见',
  `retreat_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`retreat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='项目立项回退表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_item_info_retreat`
--

LOCK TABLES `pm_item_info_retreat` WRITE;
/*!40000 ALTER TABLE `pm_item_info_retreat` DISABLE KEYS */;
INSERT INTO `pm_item_info_retreat` VALUES (1,3,'6666666666666666666666',0),(2,3,'dddddddddddd',0),(3,3,'111111111',0),(4,2,'9999999999999999999999990',0),(5,3,'经费不足，无法批准',0),(6,16,'经费不足',0),(7,NULL,'66666666666666666666666666666666666',0),(8,NULL,'66666666666666666666666666666666666',0),(9,17,'teacher',0);
/*!40000 ALTER TABLE `pm_item_info_retreat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_team_info`
--

DROP TABLE IF EXISTS `pm_team_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_team_info` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `team_code` varchar(1000) DEFAULT NULL COMMENT '团队编号',
  `item_info_id` varchar(1000) DEFAULT NULL COMMENT '立项id',
  `item_info_code` varchar(1000) DEFAULT NULL COMMENT '项目编号',
  `match_title` varchar(1000) DEFAULT NULL COMMENT '赛题',
  `sign_up_time` date DEFAULT NULL COMMENT '报名时间',
  `award_grade` varchar(1000) DEFAULT NULL COMMENT '获奖级别：国家级：区级',
  `award_info` varchar(1000) DEFAULT NULL COMMENT '获奖',
  `team_info_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  `user_id` int(11) DEFAULT NULL COMMENT '教师ID',
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='团队信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_team_info`
--

LOCK TABLES `pm_team_info` WRITE;
/*!40000 ALTER TABLE `pm_team_info` DISABLE KEYS */;
INSERT INTO `pm_team_info` VALUES (1,'001','3','001','001','2019-12-19','2','4',0,1),(2,'麦奇一队','3','麦奇一队','tensorflow学习','2019-12-12','2','6',0,1),(3,'222','16','222','2222','2019-12-10','1','1',0,1),(4,'阿姆斯特朗队','16','A002','阿姆斯特朗队回旋喷气式阿姆斯特朗加速炮','2019-12-27','1','1',0,1),(5,'teacher01','17','teacher01','teacher01','2019-12-03','1','3',0,2),(6,'teacher02','17','teacher02','teacher02','2019-12-19','2','4',0,2);
/*!40000 ALTER TABLE `pm_team_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pm_team_person_info`
--

DROP TABLE IF EXISTS `pm_team_person_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pm_team_person_info` (
  `person_info_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `person_team_info_id` int(11) DEFAULT NULL COMMENT '团队id',
  `person_code` varchar(1000) DEFAULT NULL COMMENT '学号',
  `person_name` varchar(1000) DEFAULT NULL COMMENT '姓名',
  `person_institute` varchar(1000) DEFAULT NULL COMMENT '学院',
  `person_class` varchar(1000) DEFAULT NULL COMMENT '班级',
  `person_grade` varchar(1000) DEFAULT NULL COMMENT '年级',
  `person_major` varchar(1000) DEFAULT NULL COMMENT '专业',
  `person_email` varchar(1000) DEFAULT NULL COMMENT '邮箱',
  `person_phone` varchar(1000) DEFAULT NULL COMMENT '电话',
  `person_info_is_del` int(11) DEFAULT '0' COMMENT '删除标识',
  PRIMARY KEY (`person_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='团队成员信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pm_team_person_info`
--

LOCK TABLES `pm_team_person_info` WRITE;
/*!40000 ALTER TABLE `pm_team_person_info` DISABLE KEYS */;
INSERT INTO `pm_team_person_info` VALUES (4,2,'麦奇一队','麦奇一队','麦奇一队','麦奇一队','麦奇一队','麦奇一队','麦奇一队','麦奇一队',0),(5,2,'麦奇2','麦奇2','麦奇2','麦奇2','麦奇2','麦奇2','麦奇2','麦奇2',0),(6,3,'222','222','222','222','22','222','22','222',0),(7,3,'adf','asdf','asdf','asdfa','asdf','sdf','asdf','asdf',0),(8,3,'ddd','ddd','ddd','ddd','ddd','ddd','ddd','ddd',0),(9,3,'fff','fff','fff','fff','fff','fff','fff','fff',0),(16,NULL,'4','4','4','4','4','4','4','4',0),(21,4,'2','2','2','2','2','2','2','2',0),(22,4,'3','3','3','3','3','3','3','3',0),(23,4,'4','4','4','4','4','4','4','4',0),(24,5,'teacher01','teacher01','teacher01','teacher01','teacher01','teacher01','teacher01','teacher01',0),(25,5,'teacher02','teacher02','teacher02','teacher02','teacher02','teacher02','teacher02','teacher02',0),(26,6,'teacher02','teacher02','teacher02','teacher02','teacher02','teacher02','teacher02','teacher02',0);
/*!40000 ALTER TABLE `pm_team_person_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_captcha`
--

DROP TABLE IF EXISTS `sys_captcha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_captcha` (
  `uuid` char(36) NOT NULL COMMENT 'uuid',
  `code` varchar(6) NOT NULL COMMENT '验证码',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统验证码';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_captcha`
--

LOCK TABLES `sys_captcha` WRITE;
/*!40000 ALTER TABLE `sys_captcha` DISABLE KEYS */;
INSERT INTO `sys_captcha` VALUES ('33f3a594-f3c2-408a-810f-f2d91e1cec8f','d8fgb','2019-11-26 23:24:56'),('40c66214-59b8-4a5d-8458-fe1a035ad6ba','6fb7g','2019-12-03 22:34:53'),('41a2caab-01b7-4d82-82eb-dbb01dc7f3ab','4xw4g','2019-12-03 08:22:11'),('4634b941-3bf5-4a3b-8551-6a2fa902fd85','dgbba','2019-11-30 21:53:30'),('500c5b36-d861-4e20-8b8a-6bd2514abd04','n6wab','2019-11-30 21:18:04'),('514b27ff-594f-4158-83b1-b56e5479f548','nem7c','2019-12-02 08:16:26'),('7e49689e-79b0-488b-8357-a9fac329c701','ffw7b','2019-11-26 23:15:17'),('96615bbc-e3fb-4659-817d-9dabcd60d11d','4n4pf','2019-11-27 21:07:18'),('9fa68cff-3753-4e96-8893-21faf9b5081f','56cn6','2019-11-30 21:18:13'),('a0713a5f-ead8-4285-8ae0-d9896990a137','a6nw7','2019-12-03 08:12:05'),('b3fb2474-fb6a-4270-867d-6e88ba2e7d8a','3xcdg','2019-11-30 21:23:16'),('c26ced2d-b85d-45d7-8beb-425266135b53','xbba8','2019-11-30 23:07:08'),('caaa1310-40e3-41cc-855e-da36085d1fdf','xn6aw','2019-12-01 22:32:17'),('ce270f4a-d97c-4291-81c9-20d869fb1dbd','n8cny','2019-11-30 21:18:26'),('d0272a28-63d3-481e-82e4-5bc418291229','7g2fd','2019-11-30 23:06:25'),('f0b10f5a-55d2-438c-8b88-cb75f6c57b94','ep7e5','2019-12-02 11:34:39'),('f1936cb0-aa13-408a-8c1a-aef2d50bea44','d6wm8','2019-11-27 13:57:09'),('fe6d1526-2dd1-4f97-8830-b01595557774','6f6dw','2019-11-30 20:54:27');
/*!40000 ALTER TABLE `sys_captcha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1,'admin','保存菜单','pmsocspsc.modules.sys.controller.SysMenuController.save()','[{\"menuId\":85,\"parentId\":1,\"name\":\"普罗米修斯\",\"url\":\"http://47.106.210.183:9090/targets\",\"perms\":\"\",\"type\":1,\"icon\":\"role\",\"orderNum\":0}]',13,'0:0:0:0:0:0:0:1','2020-03-20 12:33:01'),(2,'admin','保存菜单','pmsocspsc.modules.sys.controller.SysMenuController.save()','[{\"menuId\":86,\"parentId\":1,\"name\":\"石墨烯监控\",\"url\":\"http://47.106.210.183:3000/\",\"perms\":\"\",\"type\":1,\"icon\":\"job\",\"orderNum\":0}]',11,'0:0:0:0:0:0:0:1','2020-03-20 12:39:34'),(3,'admin','修改菜单','pmsocspsc.modules.sys.controller.SysMenuController.update()','[{\"menuId\":86,\"parentId\":1,\"name\":\"石墨烯监控\",\"url\":\"http://47.106.210.183:3000/login\",\"perms\":\"\",\"type\":1,\"icon\":\"job\",\"orderNum\":0}]',23,'0:0:0:0:0:0:0:1','2020-03-20 12:41:28');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COMMENT='菜单管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,0,'系统管理',NULL,NULL,0,'system',11),(2,1,'用户列表','sys/user',NULL,1,'admin',1),(3,1,'角色管理','sys/role',NULL,1,'role',2),(4,1,'菜单管理','sys/menu',NULL,1,'menu',3),(5,1,'SQL监控','http://127.0.0.1:8081/pmsocspscs/druid/login.html','sys:user:list,sys:user:info',1,'sql',4),(15,2,'查看',NULL,'sys:user:list,sys:user:info',2,NULL,0),(16,2,'新增',NULL,'sys:user:save,sys:role:select',2,NULL,0),(17,2,'修改',NULL,'sys:user:update,sys:role:select',2,NULL,0),(18,2,'删除',NULL,'sys:user:delete',2,NULL,0),(19,3,'查看',NULL,'sys:role:list,sys:role:info',2,NULL,0),(20,3,'新增',NULL,'sys:role:save,sys:menu:list',2,NULL,0),(21,3,'修改',NULL,'sys:role:update,sys:menu:list',2,NULL,0),(22,3,'删除',NULL,'sys:role:delete',2,NULL,0),(23,4,'查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0),(24,4,'新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0),(25,4,'修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0),(26,4,'删除',NULL,'sys:menu:delete',2,NULL,0),(29,1,'系统日志','sys/log','sys:log:list',1,'log',7),(31,72,'结题附件','pms/finish/pmfinishattach',NULL,1,'config',6),(32,31,'查看',NULL,'pms:pmfinishattach:list,pms:pmfinishattach:info',2,NULL,6),(33,31,'新增',NULL,'pms:pmfinishattach:save',2,NULL,6),(34,31,'修改',NULL,'pms:pmfinishattach:update',2,NULL,6),(35,31,'删除',NULL,'pms:pmfinishattach:delete',2,NULL,6),(36,72,'结题申请','pms/finish/pmfinishinfo-teacher',NULL,1,'config',6),(37,36,'查看',NULL,'pms:pmfinishinfo:list,pms:pmfinishinfo:info,pms:pmfinishinforetreat:list',2,NULL,6),(38,36,'新增',NULL,'pms:pmfinishinfo:save',2,NULL,6),(39,36,'修改',NULL,'pms:pmfinishinfo:update',2,NULL,6),(40,36,'删除',NULL,'pms:pmfinishinfo:delete',2,NULL,6),(41,71,'经费预算/实际支出信息表','pms/common/pmfundinfo',NULL,1,'config',6),(42,41,'查看',NULL,'pms:pmfundinfo:list,pms:pmfundinfo:info',2,NULL,6),(43,41,'新增',NULL,'pms:pmfundinfo:save',2,NULL,6),(44,41,'修改',NULL,'pms:pmfundinfo:update',2,NULL,6),(45,41,'删除',NULL,'pms:pmfundinfo:delete',2,NULL,6),(46,71,'附件表','pms/item/pmitemattach',NULL,1,'config',6),(47,46,'查看',NULL,'pms:pmitemattach:list,pms:pmitemattach:info',2,NULL,6),(48,46,'新增',NULL,'pms:pmitemattach:save',2,NULL,6),(49,46,'修改',NULL,'pms:pmitemattach:update',2,NULL,6),(50,46,'删除',NULL,'pms:pmitemattach:delete',2,NULL,6),(51,71,'项目立项申请','pms/item/pmiteminfo-teacher',NULL,1,'config',6),(52,51,'查看',NULL,'pms:pmiteminfo:list,pms:pmiteminfo:info,pms:pmiteminforetreat:list',2,NULL,6),(53,51,'新增',NULL,'pms:pmiteminfo:save',2,NULL,6),(54,51,'修改',NULL,'pms:pmiteminfo:update',2,NULL,6),(55,51,'删除',NULL,'pms:pmiteminfo:delete',2,NULL,6),(56,71,'项目立项回退表','pms/item/pmiteminforetreat',NULL,1,'config',6),(57,56,'查看',NULL,'pms:pmiteminforetreat:list,pms:pmiteminforetreat:info',2,NULL,6),(58,56,'新增',NULL,'pms:pmiteminforetreat:save',2,NULL,6),(59,56,'修改',NULL,'pms:pmiteminforetreat:update',2,NULL,6),(60,56,'删除',NULL,'pms:pmiteminforetreat:delete',2,NULL,6),(61,73,'参赛团队','pms/match/pmteaminfo',NULL,1,'config',6),(62,61,'查看',NULL,'pms:pmteaminfo:list,pms:pmteaminfo:info',2,NULL,6),(63,61,'新增',NULL,'pms:pmteaminfo:save',2,NULL,6),(64,61,'修改',NULL,'pms:pmteaminfo:update',2,NULL,6),(65,61,'删除',NULL,'pms:pmteaminfo:delete',2,NULL,6),(66,73,'团队成员信息','pms/match/pmteampersoninfo',NULL,1,'config',6),(67,66,'查看',NULL,'pms:pmteampersoninfo:list,pms:pmteampersoninfo:info',2,NULL,6),(68,66,'新增',NULL,'pms:pmteampersoninfo:save',2,NULL,6),(69,66,'修改',NULL,'pms:pmteampersoninfo:update',2,NULL,6),(70,66,'删除',NULL,'pms:pmteampersoninfo:delete',2,NULL,6),(71,0,'申请管理','','',0,'menu',0),(72,0,'结题管理','','',0,'menu',2),(73,0,'赛事报名','','',0,'menu',0),(74,71,'项目立项审批','pms/item/pmiteminfo-dean','',1,'log',0),(75,74,'查看','','pms:pmiteminfo:list,pms:pmiteminfo:info',2,'',0),(76,72,'结题审批','pms/finish/pmfinishinfo-dean','',1,'bianji',0),(77,76,'查看',NULL,'pms:pmfinishinfo:list,pms:pmfinishinfo:info,pms:pmfinishinforetreat:list',2,NULL,6),(78,74,'保存','','pms:pmiteminforetreat:save',2,'',0),(79,72,'结题回退表','pms/pmfinishinforetreat',NULL,1,'config',6),(80,79,'查看',NULL,'pms:pmfinishinforetreat:list,pms:pmfinishinforetreat:info',2,NULL,6),(81,79,'新增',NULL,'pms:pmfinishinforetreat:save',2,NULL,6),(82,79,'修改',NULL,'pms:pmfinishinforetreat:update',2,NULL,6),(83,79,'删除',NULL,'pms:pmfinishinforetreat:delete',2,NULL,6),(84,76,'审批','','pms:pmfinishinforetreat:save',2,NULL,6),(85,1,'普罗米修斯','http://47.106.210.183:9090/targets','',1,'role',0),(86,1,'石墨烯','http://47.106.210.183:3000/login','',1,'job',0);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'教师','教师',1,'2019-11-27 17:09:47'),(2,'二级学院','二级学院',1,'2019-11-27 17:10:18'),(3,'教务处','教务处',1,'2019-11-27 17:10:48');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8mb4 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (2,2,-666666),(130,3,74),(131,3,75),(132,3,78),(133,3,76),(134,3,77),(135,3,84),(136,3,-666666),(137,3,71),(138,3,72),(139,1,51),(140,1,52),(141,1,53),(142,1,54),(143,1,55),(144,1,36),(145,1,37),(146,1,38),(147,1,39),(148,1,40),(149,1,61),(150,1,62),(151,1,63),(152,1,64),(153,1,65),(154,1,-666666),(155,1,71),(156,1,72),(157,1,73);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d','YzcmCZNvbXocrsz9dm8e','root@renren.io','13612345678',1,1,'2016-11-11 11:11:11'),(2,'teacher','49238a76c6ef976b969d42744ca10ac43f2c6267aa4e18f825d13e80be6b4830','Jdd5ci76129g1QrVhDz0','teacher@edu.com','18276297824',1,1,'2019-11-30 22:52:41'),(3,'dean','3f3fb63f0645a8ba17862796bbe130f970a98cd85eeb06486b52050db0a5fd11','GjTcNLBuA1s4zrQ3tBcw','dean@edu.com','13123424945',1,1,'2019-11-30 22:53:29');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户与角色对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,2,1),(2,3,3);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_token`
--

DROP TABLE IF EXISTS `sys_user_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户Token';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_token`
--

LOCK TABLES `sys_user_token` WRITE;
/*!40000 ALTER TABLE `sys_user_token` DISABLE KEYS */;
INSERT INTO `sys_user_token` VALUES (1,'1c0b8536a1f1802de93b5dac3df3a8b1','2020-03-21 00:31:50','2020-03-20 12:31:50'),(2,'6774e73a394d90b5fda81c721122ea52','2019-12-04 20:37:08','2019-12-04 08:37:08'),(3,'7d165b30893f12cbdf9b0372fbc47134','2019-12-04 10:15:15','2019-12-03 22:15:15');
/*!40000 ALTER TABLE `sys_user_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-20 14:18:08
