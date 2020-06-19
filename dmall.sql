/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : dmall

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-06-19 22:41:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receiverAddress` varchar(255) DEFAULT NULL,
  `receiverName` varchar(255) DEFAULT NULL,
  `receiverGender` varchar(255) DEFAULT NULL,
  `receiverPhone` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '北京市海淀区', '天使宝贝', '女', '18511336397', '7');
INSERT INTO `address` VALUES ('2', '上海市奉贤区', '天使大宝贝', '女', '18511336397', '7');
INSERT INTO `address` VALUES ('3', '深圳市南山区', '天使小宝贝', '女', '18511336397', '7');
INSERT INTO `address` VALUES ('4', '重庆市沙坪坝区', '杨颖', '女', '18511336397', '7');
INSERT INTO `address` VALUES ('11', '廊坊市', '哈利波特', '男', '18511336397', '8');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('5', '手机数码');
INSERT INTO `category` VALUES ('6', '家用电器');
INSERT INTO `category` VALUES ('7', '食品生鲜');
INSERT INTO `category` VALUES ('8', '酒水饮料');
INSERT INTO `category` VALUES ('9', '运动户外');
INSERT INTO `category` VALUES ('10', '图书文娱');

-- ----------------------------
-- Table structure for credit
-- ----------------------------
DROP TABLE IF EXISTS `credit`;
CREATE TABLE `credit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit
-- ----------------------------

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `pid` (`pid`),
  CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `favorite_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES ('1', '7', '1', '2020-04-18 23:41:07');
INSERT INTO `favorite` VALUES ('2', '7', '2', '2020-04-18 23:41:32');
INSERT INTO `favorite` VALUES ('3', '7', '3', '2020-04-18 23:41:40');
INSERT INTO `favorite` VALUES ('5', '7', '4', '2020-04-19 00:12:32');
INSERT INTO `favorite` VALUES ('6', '7', '5', '2020-04-19 00:14:06');
INSERT INTO `favorite` VALUES ('7', '2', '1', '2020-04-19 00:24:40');
INSERT INTO `favorite` VALUES ('8', '3', '1', '2020-04-19 13:03:34');
INSERT INTO `favorite` VALUES ('9', '3', '3', '2020-04-19 13:04:01');
INSERT INTO `favorite` VALUES ('10', '4', '1', '2020-04-19 13:04:18');
INSERT INTO `favorite` VALUES ('11', '4', '2', '2020-04-16 13:04:32');
INSERT INTO `favorite` VALUES ('12', '4', '3', '2020-04-19 13:04:56');
INSERT INTO `favorite` VALUES ('13', '4', '4', '2020-06-15 16:07:54');

-- ----------------------------
-- Table structure for helparticle
-- ----------------------------
DROP TABLE IF EXISTS `helparticle`;
CREATE TABLE `helparticle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(2550) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `helparticle_ibfk_1` (`cid`),
  CONSTRAINT `helparticle_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `newspapercategory` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of helparticle
-- ----------------------------
INSERT INTO `helparticle` VALUES ('1', '1', '用户协议', '123');
INSERT INTO `helparticle` VALUES ('2', '1', '交易条款', '123');
INSERT INTO `helparticle` VALUES ('3', '1', '购物流程', '123');
INSERT INTO `helparticle` VALUES ('4', '1', '促销咨询', '123');
INSERT INTO `helparticle` VALUES ('5', '2', '自营和非自营', '123');
INSERT INTO `helparticle` VALUES ('6', '2', '违规订单处理', '123');

-- ----------------------------
-- Table structure for helpcategory
-- ----------------------------
DROP TABLE IF EXISTS `helpcategory`;
CREATE TABLE `helpcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of helpcategory
-- ----------------------------
INSERT INTO `helpcategory` VALUES ('1', '购物指南');
INSERT INTO `helpcategory` VALUES ('2', '订单百事通');
INSERT INTO `helpcategory` VALUES ('3', '配送方式');
INSERT INTO `helpcategory` VALUES ('4', '支付问题');
INSERT INTO `helpcategory` VALUES ('5', '发票问题');
INSERT INTO `helpcategory` VALUES ('6', '售后服务');
INSERT INTO `helpcategory` VALUES ('7', '账户及会员');
INSERT INTO `helpcategory` VALUES ('8', '特色服务');

-- ----------------------------
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img
-- ----------------------------

-- ----------------------------
-- Table structure for newspaper
-- ----------------------------
DROP TABLE IF EXISTS `newspaper`;
CREATE TABLE `newspaper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `cid` (`cid`),
  CONSTRAINT `newspaper_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `newspaper_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `newspapercategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newspaper
-- ----------------------------
INSERT INTO `newspaper` VALUES ('1', '一标题', '文章一', '1', '7', '12', '2020-04-27 16:20:07');
INSERT INTO `newspaper` VALUES ('2', '二标题', '文章二', '1', '7', '120', '2020-04-27 16:20:17');
INSERT INTO `newspaper` VALUES ('3', '游戏手机不止黑鲨，这两款更给力', '游戏手机不止黑鲨，这两款更给力', '1', '7', '500', '2020-04-27 16:37:24');
INSERT INTO `newspaper` VALUES ('4', '机友很为难，这该怎么选', '123', '1', '7', null, null);
INSERT INTO `newspaper` VALUES ('5', '千元机也能流畅吃鸡', '123', '1', '7', '300', null);
INSERT INTO `newspaper` VALUES ('6', '黑科技来袭', '123', '2', '7', null, null);
INSERT INTO `newspaper` VALUES ('7', '贾跃亭造车终于成功', '123', '3', '7', null, null);
INSERT INTO `newspaper` VALUES ('8', '安踏推出虫洞跑鞋', '123', '4', '7', null, null);
INSERT INTO `newspaper` VALUES ('9', '想要传承潮人，学会这几招', '123', '5', '7', null, null);
INSERT INTO `newspaper` VALUES ('10', '看风格挑家具，让客厅立显高级感', '123', '6', '7', null, null);

-- ----------------------------
-- Table structure for newspapercategory
-- ----------------------------
DROP TABLE IF EXISTS `newspapercategory`;
CREATE TABLE `newspapercategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newspapercategory
-- ----------------------------
INSERT INTO `newspapercategory` VALUES ('1', '手机');
INSERT INTO `newspapercategory` VALUES ('2', '数码');
INSERT INTO `newspapercategory` VALUES ('3', '汽车');
INSERT INTO `newspapercategory` VALUES ('4', '运动');
INSERT INTO `newspapercategory` VALUES ('5', '型男');
INSERT INTO `newspapercategory` VALUES ('6', '家居');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `oid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oid` (`oid`),
  KEY `pid` (`pid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `orders` (`id`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1', '15', '2', '2');
INSERT INTO `orderitem` VALUES ('2', '15', '16', '3');
INSERT INTO `orderitem` VALUES ('3', '16', '2', '2');
INSERT INTO `orderitem` VALUES ('4', '16', '16', '3');
INSERT INTO `orderitem` VALUES ('5', '17', '2', '2');
INSERT INTO `orderitem` VALUES ('6', '17', '16', '3');
INSERT INTO `orderitem` VALUES ('7', '18', '2', '2');
INSERT INTO `orderitem` VALUES ('8', '18', '16', '3');
INSERT INTO `orderitem` VALUES ('9', '19', '2', '2');
INSERT INTO `orderitem` VALUES ('10', '19', '16', '3');
INSERT INTO `orderitem` VALUES ('11', '20', '2', '2');
INSERT INTO `orderitem` VALUES ('12', '20', '16', '3');
INSERT INTO `orderitem` VALUES ('13', '21', '2', '2');
INSERT INTO `orderitem` VALUES ('14', '21', '16', '3');
INSERT INTO `orderitem` VALUES ('15', '22', '18', '4');
INSERT INTO `orderitem` VALUES ('16', '22', '4', '2');
INSERT INTO `orderitem` VALUES ('17', '23', '1', '1');
INSERT INTO `orderitem` VALUES ('19', '24', '1', '1');
INSERT INTO `orderitem` VALUES ('21', '25', '2', '1');
INSERT INTO `orderitem` VALUES ('22', '25', '3', '1');
INSERT INTO `orderitem` VALUES ('23', '26', '18', '1');
INSERT INTO `orderitem` VALUES ('24', '27', '3', '1');
INSERT INTO `orderitem` VALUES ('25', '28', '1', '1');
INSERT INTO `orderitem` VALUES ('26', '29', '7', '1');
INSERT INTO `orderitem` VALUES ('27', '30', '6', '1');
INSERT INTO `orderitem` VALUES ('28', '31', '6', '1');
INSERT INTO `orderitem` VALUES ('29', '32', '18', '5');
INSERT INTO `orderitem` VALUES ('30', '32', '19', '5');
INSERT INTO `orderitem` VALUES ('31', '32', '20', '5');
INSERT INTO `orderitem` VALUES ('32', '33', '17', '3');
INSERT INTO `orderitem` VALUES ('33', '34', '3', '1');
INSERT INTO `orderitem` VALUES ('34', '35', '3', '1');
INSERT INTO `orderitem` VALUES ('35', '36', '3', '1');
INSERT INTO `orderitem` VALUES ('36', '37', '3', '1');
INSERT INTO `orderitem` VALUES ('37', '38', '3', '1');
INSERT INTO `orderitem` VALUES ('38', '39', '3', '1');
INSERT INTO `orderitem` VALUES ('39', '40', '18', '1');
INSERT INTO `orderitem` VALUES ('40', '41', '3', '2');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `money` double(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `deliveryTime` datetime DEFAULT NULL,
  `confirmTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `aid` (`aid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`aid`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('15', '2d589d1c-828f-42bb-bc02-97bc667834da', '7', '4', '498.10', '2', '2020-04-21 13:57:35', '2020-06-14 21:40:50', null, null);
INSERT INTO `orders` VALUES ('16', 'd7e360b5-37ea-4a45-babf-deb79f6e423d', '7', '4', '498.10', '1', '2020-04-21 14:00:07', null, null, null);
INSERT INTO `orders` VALUES ('17', '33cb9155-1374-4645-bdfc-e66fe93f473d', '7', '4', '498.10', '2', '2020-04-21 14:01:03', '2020-05-01 09:00:20', null, null);
INSERT INTO `orders` VALUES ('18', '32b09f1e-0649-4c48-bf8b-f994d266afdc', '7', '4', '498.10', '1', '2020-04-21 14:02:38', null, null, null);
INSERT INTO `orders` VALUES ('19', '3610815d-59c1-4346-8d1f-d8f4e78c8e72', '7', '4', '598.10', '5', '2020-04-21 14:02:56', '2020-06-14 22:24:26', null, '2020-06-14 22:25:18');
INSERT INTO `orders` VALUES ('20', '27c655b7-1724-4494-a270-c8d8b218f870', '7', '4', '498.10', '1', '2020-04-21 14:04:03', null, null, null);
INSERT INTO `orders` VALUES ('21', '96b4581c-7e54-43aa-808d-d0f34eb88757', '7', '4', '498.10', '4', '2020-04-21 14:04:18', '2020-04-23 13:21:23', null, '2020-04-23 14:43:10');
INSERT INTO `orders` VALUES ('22', 'ef2a3c05-b5dd-473b-8a70-383615c699e2', '7', '2', '597.60', '5', '2020-04-21 14:56:48', '2020-04-21 15:16:53', null, '2020-04-23 14:49:29');
INSERT INTO `orders` VALUES ('23', 'd52a90f3-ceaa-433a-905c-fe7fc48a9a5e', '8', '11', '328.99', '2', '2020-04-21 15:07:21', '2020-02-02 22:06:06', null, null);
INSERT INTO `orders` VALUES ('24', '2cebdc61-7369-450b-8b14-5aa1530a5cdf', '7', '11', '328.99', '3', '2020-04-21 15:11:29', null, null, '2020-06-14 16:34:28');
INSERT INTO `orders` VALUES ('25', '4b79a040-e3eb-48f2-a602-f8059e7a5215', '8', '11', '199.60', '5', '2020-04-21 15:20:04', null, null, '2020-04-23 14:51:54');
INSERT INTO `orders` VALUES ('26', '81df0c65-6743-4597-9fff-5cf2c15da5c8', '8', '11', '99.50', '4', '2020-04-21 15:25:11', null, null, null);
INSERT INTO `orders` VALUES ('27', '6cb5d1e0-2869-4628-9dd5-49d88345a35c', '8', '11', '99.80', '2', '2020-04-21 15:35:35', '2020-04-23 12:52:59', null, null);
INSERT INTO `orders` VALUES ('28', 'a315ce06-581c-47ff-8658-da2d5bcb5a50', '8', '11', '129.99', '1', '2020-04-21 15:38:45', null, null, null);
INSERT INTO `orders` VALUES ('29', '5ab3cb12-6468-40dc-b3c8-7a09f8476401', '7', '3', '99.50', '2', '2020-04-21 15:52:27', '2020-04-23 12:59:12', null, null);
INSERT INTO `orders` VALUES ('30', 'e0a7c859-0c87-433e-bb3c-f1ea817b0aaa', '7', '1', '99.50', '2', '2020-04-21 15:54:16', '2020-04-21 16:15:20', null, null);
INSERT INTO `orders` VALUES ('31', '388b0dbc-097b-4973-a29b-2395dfbbd46e', '7', '1', '99.50', '5', '2020-04-21 15:55:37', '2020-04-21 16:11:29', '2020-04-30 23:33:29', '2020-04-30 23:34:44');
INSERT INTO `orders` VALUES ('32', '8c6f862c-7870-4ba9-8a6b-e10fe6885159', '7', '4', '22992.50', '2', '2020-04-21 16:56:41', '2020-04-21 16:57:23', null, null);
INSERT INTO `orders` VALUES ('33', '34e3124a-fb01-4038-93fa-3c793f84e844', '8', '11', '298.50', '2', '2020-04-21 17:07:29', '2020-04-21 17:07:59', null, null);
INSERT INTO `orders` VALUES ('34', '45b62835-7788-4f27-9d1c-cb6cf55552d3', '7', '3', '99.80', '2', '2020-04-21 17:43:45', '2020-04-23 12:59:41', null, null);
INSERT INTO `orders` VALUES ('35', 'ddd3d5cb-91d7-449e-a119-3a8b7ea1b3cf', '7', '3', '99.80', '2', '2020-04-21 17:44:44', '2020-04-23 13:13:45', null, null);
INSERT INTO `orders` VALUES ('36', 'c6f4018e-ea1c-4e11-b692-1d187a441f0a', '7', '4', '99.80', '2', '2020-04-21 17:46:56', '2020-04-21 17:47:01', null, null);
INSERT INTO `orders` VALUES ('37', '1d05c27d-ae8e-4e89-a9e9-97daec4c53b6', '7', '1', '99.80', '2', '2020-04-21 19:09:20', '2020-04-21 19:09:29', null, null);
INSERT INTO `orders` VALUES ('38', '03c5ca1a-a01b-4d79-90a6-6a11e873851b', '7', '1', '99.80', '2', '2020-04-21 19:10:06', '2020-04-21 19:10:15', null, null);
INSERT INTO `orders` VALUES ('39', '65d52a19-ad8e-4a34-b01b-58f65d460fd1', '8', '11', '99.80', '2', '2020-04-22 23:55:28', '2020-04-22 23:55:35', null, null);
INSERT INTO `orders` VALUES ('40', '57056db9-f049-49ab-8a83-9b094b727dc6', '7', '1', '99.50', '2', '2020-06-15 15:08:49', '2020-06-15 15:12:45', null, null);
INSERT INTO `orders` VALUES ('41', '71696144-0d72-48ff-9d98-0a3b982bee7e', '7', '1', '199.60', '1', '2020-06-17 11:27:27', null, null, null);

-- ----------------------------
-- Table structure for privilege
-- ----------------------------
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privilege
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `subTitle` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `promotePrice` double(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_ibfk_1` (`cid`),
  KEY `product_ibfk_2` (`sid`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `seller` (`id`) ON DELETE CASCADE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '深入理解Java虚拟机', '印刷36次，销量超30万册，根据新版jdk全面升级，新增内容50%，原创计算机图书丰碑', '129.99', '99.59', '100', '10', '1', '2020-04-17 20:31:09');
INSERT INTO `product` VALUES ('2', '计算机网络：自顶向下方法', '以自顶向下的方式系统展现计算机网络的原理与结构，广受欢迎的计算机网络教材', '99.80', '89.00', '96', '10', '1', '2020-04-17 20:31:15');
INSERT INTO `product` VALUES ('3', '长安十二时辰', null, '99.80', '89.00', '93', '10', '1', null);
INSERT INTO `product` VALUES ('4', 'Spring技术内幕', null, '99.80', '89.00', '100', '10', '1', null);
INSERT INTO `product` VALUES ('5', '人类简史', null, '99.50', '55.00', '-71', '10', '1', null);
INSERT INTO `product` VALUES ('6', '时间简史', null, '99.50', '55.00', '100', '10', '1', null);
INSERT INTO `product` VALUES ('7', '世界简史', null, '99.50', '55.00', '99', '10', '1', null);
INSERT INTO `product` VALUES ('8', '计算机组成与设计', null, '99.50', '55.00', '100', '10', '1', null);
INSERT INTO `product` VALUES ('9', 'Spring微服务', null, '99.50', '55.00', '100', '10', '1', null);
INSERT INTO `product` VALUES ('10', '白话大数据与机器学习', null, '99.50', '55.00', '100', '10', '1', null);
INSERT INTO `product` VALUES ('16', '小米5', '小米5，一个不错的水桶机', '99.50', '55.00', '94', '5', '3', null);
INSERT INTO `product` VALUES ('17', '小米平板', '小米平板，永远滴神', '99.50', '55.00', '97', '5', '3', null);
INSERT INTO `product` VALUES ('18', '红米K20Pro', 'K20Pro，水桶机，你值得拥有', '99.50', '55.00', '94', '5', '3', null);
INSERT INTO `product` VALUES ('19', '红米K30Pro', '新一代水桶机', '1200.00', '999.00', '95', '5', '3', null);
INSERT INTO `product` VALUES ('20', '小米10Pro', '5G新机，快来买', '3299.00', '2599.00', '95', '5', '3', null);

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `property_ibfk_1` (`cid`),
  CONSTRAINT `property_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES ('11', '10', '作者');
INSERT INTO `property` VALUES ('12', '10', '出版社');
INSERT INTO `property` VALUES ('14', '10', '页数');
INSERT INTO `property` VALUES ('15', '10', '包装');
INSERT INTO `property` VALUES ('16', '10', '出版时间');
INSERT INTO `property` VALUES ('17', '10', '用纸');
INSERT INTO `property` VALUES ('18', '10', '丛书名');
INSERT INTO `property` VALUES ('19', '10', 'ISBN');

-- ----------------------------
-- Table structure for propertyvalue
-- ----------------------------
DROP TABLE IF EXISTS `propertyvalue`;
CREATE TABLE `propertyvalue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `ptid` int(11) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `propertyvalue_ibfk_1` (`pid`),
  KEY `propertyvalue_ibfk_2` (`ptid`),
  CONSTRAINT `propertyvalue_ibfk_2` FOREIGN KEY (`ptid`) REFERENCES `property` (`id`) ON DELETE CASCADE,
  CONSTRAINT `propertyvalue_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of propertyvalue
-- ----------------------------
INSERT INTO `propertyvalue` VALUES ('1', '2', '11', 'James.F');
INSERT INTO `propertyvalue` VALUES ('2', '2', '12', '机械工业出版社');
INSERT INTO `propertyvalue` VALUES ('4', '2', '14', '510');
INSERT INTO `propertyvalue` VALUES ('5', '2', '15', '平装');
INSERT INTO `propertyvalue` VALUES ('6', '2', '16', '2018-07-01');
INSERT INTO `propertyvalue` VALUES ('7', '2', '17', '胶版纸');
INSERT INTO `propertyvalue` VALUES ('8', '2', '18', '计算机科学丛书');
INSERT INTO `propertyvalue` VALUES ('9', '1', '11', '周志明');
INSERT INTO `propertyvalue` VALUES ('10', '1', '12', '机械工业出版社');
INSERT INTO `propertyvalue` VALUES ('12', '1', '14', '540');
INSERT INTO `propertyvalue` VALUES ('13', '1', '15', '精装');
INSERT INTO `propertyvalue` VALUES ('14', '1', '16', '2019-12-01');
INSERT INTO `propertyvalue` VALUES ('15', '1', '17', '胶版纸');
INSERT INTO `propertyvalue` VALUES ('16', '1', '18', '华章原创精品');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `pid` (`pid`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('6', '红米K20pro很好', '7', '18', '2020-04-23 14:45:27');
INSERT INTO `review` VALUES ('7', 'spring很重要', '7', '4', '2020-04-23 14:45:27');
INSERT INTO `review` VALUES ('8', '红米K20pro很好', '7', '18', '2020-04-23 14:49:29');
INSERT INTO `review` VALUES ('9', 'spring很重要', '7', '4', '2020-04-23 14:49:29');
INSERT INTO `review` VALUES ('10', '计算机网络123', '8', '2', '2020-04-23 14:51:54');
INSERT INTO `review` VALUES ('11', '长安十二时辰雷佳音演的太好了', '8', '3', '2020-04-23 14:51:54');
INSERT INTO `review` VALUES ('12', '长安十二时辰翻拍的剧还不错呦', '7', '3', '2020-04-23 16:35:22');
INSERT INTO `review` VALUES ('13', '时间简史很好啊', '7', '6', '2020-04-30 23:34:44');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户', null);
INSERT INTO `role` VALUES ('2', '管理员', null);
INSERT INTO `role` VALUES ('3', '超级管理员', null);

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES ('1', '机械工业出版社', '2695357', '北京市海淀区');
INSERT INTO `seller` VALUES ('2', '阿迪达斯', '2695357', '上海市浦东新区');
INSERT INTO `seller` VALUES ('3', '小米旗舰店', '2695357', '武汉市雷军家');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `activeCode` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `registTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '123', '张三弟弟', null, '123@qq.com', '18511336397', null, 'Y', '1', '2020-04-17 20:38:04');
INSERT INTO `user` VALUES ('2', 'lisi', '123', '李四弟弟', null, null, null, null, 'Y', '1', null);
INSERT INTO `user` VALUES ('3', 'wangwu', '123', '王五弟弟', null, null, null, null, 'Y', '2', null);
INSERT INTO `user` VALUES ('4', 'zhaoliu', '123', '赵六弟弟', null, null, null, null, 'Y', '2', null);
INSERT INTO `user` VALUES ('7', 'baby', '123', '天使宝贝', '女', '123@qq.com', '18511336397', null, 'Y', '3', null);
INSERT INTO `user` VALUES ('8', 'harry', '123', '哈利波特', '女', '123@qq.com', '18511336397', null, 'N', '3', null);
INSERT INTO `user` VALUES ('40', 'test1', '123', '89891212sadsd', '男', '123@qq.com', '2323asdad', null, 'Y', '1', '2020-05-24 23:54:20');
INSERT INTO `user` VALUES ('41', 'test2', '123', '小刚', '男', '123@qq.com', '2695357', null, 'Y', '1', '2020-05-25 14:41:06');
INSERT INTO `user` VALUES ('47', 'test3', '123', '22', '男', '123@qq.com', '18511336397', null, 'N', '1', '2020-05-25 19:07:06');
INSERT INTO `user` VALUES ('48', 'test4', '123', '11', '男', '111', '484968', null, 'N', '1', '2020-05-25 19:07:55');
