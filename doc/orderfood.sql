/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : orderfood

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-05-02 06:11:41
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
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES ('1', 'admin', '1234', null, null, null, null, null, null, null);
INSERT INTO `business` VALUES ('2', 'b1', '1234', '1.sddd\r\n2.dasdas\r\n3。打撒所多', '测试商家', '2018-05-02 03:23:37', '15302074359', '20.0', '北京小胡同', null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '盖饭');
INSERT INTO `category` VALUES ('3', '稀饭');
INSERT INTO `category` VALUES ('4', '饮料');

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
  `businessid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('4', null, '99', null, '稀饭', '0', '2018-05-02 03:56:54', '1', '/data/c6e2fc9b-421e-44a0-a0f1-59d60bdad308.JPG', '测试', '888.00', '0', '2');

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
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('12', '0816730d-4549-42a7-bf80-0cc0dd9a03ca', '2018-05-02 05:35:21', '1778.00', '1', '4', '8', '2018-05-02 05:35:21', '1', '3', null, null, '7,', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('7', '4', '1776', '2', '8', '1', '2018-05-02 05:12:31');

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
INSERT INTO `user` VALUES ('8', '15302074359', 'test', '1234', '1', '2017-03-09 08:41:26');
INSERT INTO `user` VALUES ('10', '17346512586', '执笔2', '1234', '1', '2018-04-14 04:54:41');
