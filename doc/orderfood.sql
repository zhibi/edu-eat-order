/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : orderfood

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-04-28 16:08:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `notice` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `free` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('1', 'admin', '1234', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `oldprice` decimal(10,0) DEFAULT NULL,
  `descript` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `sort` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `times` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '鼎折覆餗发发生的方式大概是5', '99', '刚放电饭锅电饭锅电饭锅电饭锅5', '干果', '2', '2017-03-09 08:51:04', '1', 'jpg/6/1/6287b7f359a1476cbae4952405cd1a61.jpg', '破洞男裤2', '27.00', '0');
INSERT INTO `food` VALUES ('2', '<img src=\"/data/jpg/4/4/42f78fcf511a42818d95260fd4cb4dc4.jpg\" alt=\"\" />', null, 'fdsdfs3', '盖饭', '9', '2017-03-17 19:51:06', '1', 'jpg/b/0/b231a318b9d2414399b43ee965419a40.jpg', 'sss3', '26.00', '0');
INSERT INTO `food` VALUES ('3', 'dasdasda', null, 'dsds', '炒菜', null, '2017-03-28 21:02:17', '1', 'jpg/c/2/c6a6e7a6db1b41e7bc51f866e8cba822.jpg', '123', '333.00', '0');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ORDERNO` varchar(64) DEFAULT NULL,
  `ADDTIME` datetime DEFAULT NULL,
  `TOTAL` decimal(65,2) DEFAULT NULL COMMENT '总价格',
  `STATUS` int(11) DEFAULT '1' COMMENT '0取消 1发起 2代付款 3待评价 4订单完成',
  `REMARK` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT '0',
  `paytime` datetime DEFAULT NULL,
  `Receiveuser` varchar(255) DEFAULT NULL,
  `Receiveaddress` varchar(255) DEFAULT NULL,
  `sendtime` datetime DEFAULT NULL,
  `receivetime` datetime DEFAULT NULL,
  `ids` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('9', 'f8f002e1703281515745694', '2017-03-28 19:33:28', '273.00', '1', 'e', '8', '2017-03-28 19:33:28', 'q', 'w', null, null, '1,2,');
INSERT INTO `orders` VALUES ('10', 'ee282b11703291099707389', '2017-03-29 20:04:11', '445.00', '1', '456', '8', '2017-03-29 20:04:11', '123', '345', null, null, '5,4,3,');
INSERT INTO `orders` VALUES ('11', '9e9efe71-7c45-47b2-a968-ae0bd1deb342', '2018-04-14 05:09:55', '28.00', '1', '1', '10', '2018-04-14 05:09:55', 'fffw', '1', null, null, '6,');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `food_id` int(11) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` int(255) DEFAULT '0',
  `addtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('1', '2', '236', '9', '8', '1', '2017-03-27 19:47:28');
INSERT INTO `order_item` VALUES ('2', '1', '27', '1', '8', '1', '2017-03-27 19:23:09');
INSERT INTO `order_item` VALUES ('3', '1', '81', '3', '8', '1', '2017-03-29 20:03:01');
INSERT INTO `order_item` VALUES ('4', '3', '333', '1', '8', '1', '2017-03-29 20:03:26');
INSERT INTO `order_item` VALUES ('5', '2', '26', '1', '8', '1', '2017-03-29 20:03:28');
INSERT INTO `order_item` VALUES ('6', '1', '27', '1', '10', '1', '2018-04-14 05:09:34');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `PHONE` varchar(11) DEFAULT NULL,
  `USERNAME` varchar(25) DEFAULT NULL COMMENT '别名',
  `PASSWORD` varchar(32) NOT NULL,
  `STATUS` int(11) DEFAULT '1' COMMENT '1正常  0 锁定 ',
  `ADDTIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8', '15302074359', 'admin', '1234', '1', '2017-03-09 08:41:26');
INSERT INTO `user` VALUES ('10', '17346512586', '执笔2', '1234', '1', '2018-04-14 04:54:41');
