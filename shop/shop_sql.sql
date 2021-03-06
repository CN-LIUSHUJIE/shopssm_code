use shop;
/*创建区域表*/
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` int(5) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) NOT NULL,
  `area_desc` varchar(1000) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/**
  插入数据
 */
INSERT INTO `tb_area` VALUES (3,'东苑','东苑',12,'2017-06-04 19:12:58','2017-06-04 19:12:58'),
                             (4,'南苑','南苑',10,'2017-06-04 19:13:09','2017-06-04 19:13:09'),
                             (5,'西苑','西苑',9,'2017-06-04 19:13:18','2017-06-04 19:13:18'),
                             (6,'北苑','北苑',7,'2017-06-04 19:13:29','2017-06-04 19:13:29');

/**
  创建  tb_local_auth 表
  */
DROP TABLE IF EXISTS `tb_local_auth`;
CREATE TABLE `tb_local_auth` (
                                 `local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
                                 `user_id` int(10) DEFAULT NULL,
                                 `user_name` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
                                 `password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
                                 `create_time` datetime DEFAULT NULL,
                                 `last_edit_time` datetime DEFAULT NULL,
                                 PRIMARY KEY (`local_auth_id`),
                                 UNIQUE KEY `uk_local_profile` (`user_name`),
                                 KEY `fk_local_profile` (`user_id`),
                                 CONSTRAINT `fk_local_profile` FOREIGN KEY (`user_id`) REFERENCES `tb_person_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
LOCK TABLES `tb_local_auth` WRITE;
/*!40000 ALTER TABLE `tb_local_auth` DISABLE KEYS */;
INSERT INTO `tb_local_auth` VALUES (6,8,'xiangze','s05bse6q2qlb9qblls96s592y55y556s','2017-06-04 19:09:51','2017-06-04 19:09:51'),(7,9,'test','s05bse6q2qlb9qblls96s592y55y556s','2017-06-05 22:05:13','2017-06-05 22:05:13');
/*!40000 ALTER TABLE `tb_local_auth` ENABLE KEYS */;
UNLOCK TABLES;



DROP TABLE IF EXISTS `tb_person_info`;
CREATE TABLE `tb_person_info` (
                                  `user_id` int(10) NOT NULL AUTO_INCREMENT,
                                  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
                                  `birthday` datetime DEFAULT NULL,
                                  `gender` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
                                  `phone` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
                                  `email` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
                                  `profile_img` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
                                  `customer_flag` int(2) NOT NULL DEFAULT '0',
                                  `shop_owner_flag` int(2) NOT NULL DEFAULT '0',
                                  `admin_flag` int(2) NOT NULL,
                                  `create_time` datetime DEFAULT NULL,
                                  `last_edit_time` datetime DEFAULT NULL,
                                  `enable_status` int(2) NOT NULL DEFAULT '0',
                                  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/**
  插入数据到 tb_person_info 表
 */
LOCK TABLES `tb_person_info` WRITE;
INSERT INTO `tb_person_info` VALUES (8,'李翔',NULL,'1',NULL,NULL,'http://wx.qlogo.cn/mmopen/XZumId0qMA815ApfWI2zibDnRMahic6SU0wHib2HgGJj5narL2ymRaI4Kn2Tx2Q8UfkicibvjVicu3De6fDYRMfo0uGW0SGicibxVnJ9/0',1,1,1,'2017-06-04 19:01:09','2017-06-04 19:01:09',1),(9,'龙州一条街客服',NULL,'1',NULL,NULL,'http://wx.qlogo.cn/mmopen/icF4iau8Sj7b0FiakC6ibBoTPmkvLpIX9YhWkNyEIGYfzYyqBiag2M3q2rnxSlXAh95UDHdWgywvEW5bN5FBzFPFazxBzqHTRqNwn/0',1,1,0,'2017-06-04 21:20:43','2017-06-04 21:20:43',1),(10,'king',NULL,'2',NULL,NULL,'http://wx.qlogo.cn/mmopen/XZumId0qMA815ApfWI2zibDLckaAaV6QgcBJP0saJSDTuicZBd35HzPXUebLPSlexCIPJsLs3w6lG0xmwn3EZNicj04dJh4We7C/0',1,1,0,'2017-06-07 01:36:16','2017-06-07 01:36:16',1),(11,'音策',NULL,'2',NULL,NULL,'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKCWfIBicEwS3U0legxxQd5XFpZibBXVPyz0wphvvtaXqiblzQF2GqE28c7j8FGpuYqBCg1QRJThEzuw/0',1,1,0,'2017-09-18 23:39:38','2017-09-18 23:39:38',1);
UNLOCK TABLES;


DROP TABLE IF EXISTS `tb_shop`;

CREATE TABLE `tb_shop` (
                           `shop_id` int(10) NOT NULL AUTO_INCREMENT,
                           `owner_id` int(10) NOT NULL COMMENT '店铺创建人',
                           `area_id` int(5) DEFAULT NULL,
                           `shop_category_id` int(11) DEFAULT NULL,
                           `parent_category_id` int(11) DEFAULT NULL,
                           `shop_name` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
                           `shop_desc` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
                           `shop_addr` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
                           `phone` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
                           `shop_img` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
                           `longitude` double(16,12) DEFAULT NULL,
                           `latitude` double(16,12) DEFAULT NULL,
                           `priority` int(3) DEFAULT '0',
                           `create_time` datetime DEFAULT NULL,
                           `last_edit_time` datetime DEFAULT NULL,
                           `enable_status` int(2) NOT NULL DEFAULT '0',
                           `advice` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
                           PRIMARY KEY (`shop_id`),
                           KEY `fk_shop_profile` (`owner_id`),
                           KEY `fk_shop_area` (`area_id`),
                           KEY `fk_shop_shopcate` (`shop_category_id`),
                           KEY `fk_shop_parentcate` (`parent_category_id`),
                           CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),
                           CONSTRAINT `fk_shop_parentcate` FOREIGN KEY (`parent_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`),
                           CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`),
                           CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

LOCK TABLES `tb_shop` WRITE;
/*!40000 ALTER TABLE `tb_shop` DISABLE KEYS */;
INSERT INTO `tb_shop` VALUES (15,8,3,14,10,'二手车辆','二手汽车、摩托车、电车等交通工具交易信息。','面向全市','0000000','/upload/images/item/shop/15/2017060522042982266.png',NULL,NULL,100,'2017-06-05 22:04:29','2017-08-25 10:50:16',1,NULL),(16,8,3,15,10,'旧书籍交易','旧书籍交易信息','旧书籍交易板块','0000000','/upload/images/item/shop/16/2017060608534289617.png',NULL,NULL,99,'2017-06-06 08:53:42','2017-06-06 08:54:40',1,NULL),(17,8,3,17,11,'靓仔靓妹美容护理中心','二十年手艺，专业护理秀发受损头发。美容美发首选。','东苑北面二号门','4445556','/upload/images/item/shop/17/2017060609084595067.jpg',NULL,NULL,0,'2017-06-06 09:08:45','2017-06-06 09:45:32',1,NULL),(18,8,3,18,11,'一剪没理发中心','专业洗剪吹，又好又便宜。','东苑北面3号门面','9998887','/upload/images/item/shop/18/2017060609110899956.jpg',NULL,NULL,0,'2017-06-06 09:11:08','2017-06-06 09:45:38',1,NULL),(19,8,4,20,12,'吃得饱大排档','吃得好又吃得饱，朋友聚会好地方。可预约。','南苑东面10号门面','1234567','/upload/images/item/shop/19/2017060609140699548.jpg',NULL,NULL,0,'2017-06-06 09:14:06','2017-06-06 09:45:43',1,NULL),(20,8,4,22,12,'香喷喷奶茶店','鲜榨果汁、奶茶等饮品。','南苑东面5号门面','77788444','/upload/images/item/shop/20/2017060609163395401.jpg',NULL,NULL,30,'2017-06-06 09:16:33','2017-06-07 16:24:07',1,'\"\"'),(21,8,5,25,13,'海陆空量贩KTV','订包厢电话：8889997。节假日请预约。','西苑1号门面','8889997','/upload/images/item/shop/21/2017060609194286080.jpg',NULL,NULL,0,'2017-06-06 09:19:42','2017-06-06 09:45:59',1,NULL),(22,8,5,24,13,'幽城室逃生娱乐城','考验你的智商，和小伙伴们一起来挑战吧。','西苑3号楼第二层','6666333','/upload/images/item/shop/22/2017060609223853062.jpg',NULL,NULL,0,'2017-06-06 09:22:38','2017-06-06 09:46:04',1,NULL),(23,8,6,29,27,'威水程序设计培训教育','保教抱会，前途无量。','北苑2栋5楼','66633111','/upload/images/item/shop/23/2017060609275777519.png',NULL,NULL,0,'2017-06-06 09:27:57','2017-06-06 09:46:09',1,NULL),(24,8,6,30,27,'武林风舞蹈培训','专业培训舞蹈，声乐。','北苑9懂10楼','5555555','/upload/images/item/shop/24/2017060609354459045.png',NULL,NULL,0,'2017-06-06 09:35:44','2017-06-06 09:46:13',1,NULL),(25,8,6,14,28,'易行交通工具租赁服务中心','本店租赁各种汽车，摩托车等。详情请拨打电话咨询。电话：2222222','1栋3号4号门面','2222222','/upload/images/item/shop/25/2017060609381150709.png',NULL,NULL,40,'2017-06-06 09:38:11','2017-06-06 19:58:32',1,NULL),(26,8,6,31,28,'有声有色','出租各种演出道具，乐器，服装等。','北苑15号门面','7777777','/upload/images/item/shop/26/2017060609431259039.png',NULL,NULL,41,'2017-06-06 09:43:12','2017-06-06 19:58:45',1,NULL),(27,8,3,22,12,'冰冻夏天奶茶店','本店出售各种冷饮，奶茶，冰花，鲜榨果汁。','东苑7懂2号门面','8889999','/upload/images/item/shop/27/2017060715512185473.jpg',NULL,NULL,10,'2017-06-07 15:51:21','2017-06-07 16:22:28',1,'\"\"'),(28,9,3,14,10,'test','dfafaf','sdafafafa','3424242','/upload/images/item/shop/28/2017082500103690946.png',NULL,NULL,0,'2017-08-25 00:10:36','2017-08-25 00:10:36',0,NULL);
/*!40000 ALTER TABLE `tb_shop` ENABLE KEYS */;
UNLOCK TABLES;




DROP TABLE IF EXISTS `tb_shop_category`;
CREATE TABLE `tb_shop_category` (
                                    `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
                                    `shop_category_name` varchar(100) NOT NULL DEFAULT '',
                                    `shop_category_desc` varchar(1000) DEFAULT '',
                                    `shop_category_img` varchar(2000) DEFAULT NULL,
                                    `priority` int(2) NOT NULL DEFAULT '0',
                                    `create_time` datetime DEFAULT NULL,
                                    `last_edit_time` datetime DEFAULT NULL,
                                    `parent_id` int(11) DEFAULT NULL,
                                    PRIMARY KEY (`shop_category_id`),
                                    KEY `fk_shop_category_self` (`parent_id`),
                                    CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

LOCK TABLES `tb_shop_category` WRITE;
/*!40000 ALTER TABLE `tb_shop_category` DISABLE KEYS */;
INSERT INTO `tb_shop_category` VALUES (10,'二手市场','二手商品交易','/upload/images/item/shopcategory/2017061223272255687.png',100,'2017-06-04 20:10:58','2017-06-12 23:27:22',NULL),(11,'美容美发','美容美发','/upload/images/item/shopcategory/2017061223273314635.png',99,'2017-06-04 20:12:57','2017-06-12 23:27:33',NULL),(12,'美食饮品','美食饮品','/upload/images/item/shopcategory/2017061223274213433.png',98,'2017-06-04 20:15:21','2017-06-12 23:27:42',NULL),(13,'休闲娱乐','休闲娱乐','/upload/images/item/shopcategory/2017061223275121460.png',97,'2017-06-04 20:19:29','2017-06-12 23:27:51',NULL),(14,'旧车','旧车','/upload/images/item/shopcategory/2017060420315183203.png',80,'2017-06-04 20:31:51','2017-06-04 20:31:51',10),(15,'二手书籍','二手书籍','/upload/images/item/shopcategory/2017060420322333745.png',79,'2017-06-04 20:32:23','2017-06-04 20:32:23',10),(17,'护理','护理','/upload/images/item/shopcategory/2017060420372391702.png',76,'2017-06-04 20:37:23','2017-06-04 20:37:23',11),(18,'理发','理发','/upload/images/item/shopcategory/2017060420374775350.png',74,'2017-06-04 20:37:47','2017-06-04 20:37:47',11),(20,'大排档','大排档','/upload/images/item/shopcategory/2017060420460491494.png',59,'2017-06-04 20:46:04','2017-06-04 20:46:04',12),(22,'奶茶店','奶茶店','/upload/images/item/shopcategory/2017060420464594520.png',58,'2017-06-04 20:46:45','2017-06-04 20:46:45',12),(24,'密室逃生','密室逃生','/upload/images/item/shopcategory/2017060420500783376.png',56,'2017-06-04 20:50:07','2017-06-04 21:45:53',13),(25,'KTV','KTV','/upload/images/item/shopcategory/2017060420505834244.png',57,'2017-06-04 20:50:58','2017-06-04 20:51:14',13),(27,'培训教育','培训教育','/upload/images/item/shopcategory/2017061223280082147.png',96,'2017-06-04 21:51:36','2017-06-12 23:28:00',NULL),(28,'租赁市场','租赁市场','/upload/images/item/shopcategory/2017061223281361578.png',95,'2017-06-04 21:53:52','2017-06-12 23:28:13',NULL),(29,'程序设计','程序设计','/upload/images/item/shopcategory/2017060421593496807.png',50,'2017-06-04 21:59:34','2017-06-04 21:59:34',27),(30,'声乐舞蹈','声乐舞蹈','/upload/images/item/shopcategory/2017060421595843693.png',49,'2017-06-04 21:59:58','2017-06-04 21:59:58',27),(31,'演出道具','演出道具','/upload/images/item/shopcategory/2017060422114076152.png',45,'2017-06-04 22:11:40','2017-06-04 22:11:40',28),(32,'交通工具','交通工具','/upload/images/item/shopcategory/2017060422121144586.png',44,'2017-06-04 22:12:11','2017-06-04 22:12:11',28);
/*!40000 ALTER TABLE `tb_shop_category` ENABLE KEYS */;
UNLOCK TABLES;

