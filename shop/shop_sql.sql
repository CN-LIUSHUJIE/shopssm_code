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
