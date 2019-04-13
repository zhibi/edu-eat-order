/*
 Navicat Premium Data Transfer

 Source Server         : zhibi
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 120.27.24.193:3306
 Source Schema         : edu-eat-order

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 14/04/2019 00:14:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `point_X` double(255, 2) NULL DEFAULT 0.00,
  `point_Y` double(255, 2) NULL DEFAULT 0.00,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `commend_num` int(11) NULL DEFAULT 0,
  `order_num` int(11) NULL DEFAULT 0,
  `start_num` int(11) NULL DEFAULT 0,
  `sort` int(11) NULL DEFAULT 0,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `trade_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------
INSERT INTO `business` VALUES (1, '测试商家', '川菜', '456788', '北京大桥', 116.40, 39.93, '', 3223, 3222, 0, 0, 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3590849871,3724521821&fm=27&gp=0.jpg', '');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT 0,
  `business_id` int(11) NULL DEFAULT 0,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `addtime` datetime NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `start` int(11) NULL DEFAULT 0,
  `dining_advice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `serve` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `environment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `taste` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, 1, 'fdfsdfs', '2019-04-13 21:06:35', 'dd fds fsdgs', 5, '121213', '131', '323214', '2413');
INSERT INTO `comment` VALUES (2, 3, 1, '', '2019-04-13 22:40:15', '', 5, '', '', '', '');
INSERT INTO `comment` VALUES (3, 3, 1, '', '2019-04-13 22:40:19', '', 5, '', '', '', '');
INSERT INTO `comment` VALUES (4, 3, 1, '<p>gsgfcvbcvbcvbcvb<img src=\"/upload/2019-04-14/00-1555171436413-078086.jpg\" title=\"00-1555171436413-078086.jpg\" alt=\"333 - 副本.jpg\"/></p>,<p>gsgfcvbcvbcvbcvb<img src=\"/upload/2019-04-14/00-1555171436413-078086.jpg\" title=\"00-1555171436413-078086.jpg\" alt=\"333 - 副本.jpg\"/></p>', '2019-04-14 00:03:58', '', 5, 'fdg', 'fgdfgd', 'vxgdfg', 'fgdfgdf');
INSERT INTO `comment` VALUES (5, 3, 1, '<ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\"><li><p>xcx<br/></p></li></ul>,<ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\"><li><p>xcx<br/></p></li></ul>', '2019-04-14 00:06:25', '', 5, 'cvx', 'fdfs', 'vcxcbx', 'bxcbx');

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT 0,
  `money` double(255, 2) NULL DEFAULT 0.00,
  `species` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `add_time` datetime NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `sort` int(11) NULL DEFAULT 0,
  `addtime` datetime NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `price` double(255, 2) NULL DEFAULT 0.00,
  `old_price` double(255, 2) NULL DEFAULT 0.00,
  `business_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (1, '', '', '', 0, NULL, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3240052967,3443336204&fm=27&gp=0.jpg', '333', 0.00, 0.00, 1);
INSERT INTO `food` VALUES (2, '', '', '', 0, NULL, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3240052967,3443336204&fm=27&gp=0.jpg', 'rrr', 0.00, 0.00, 1);
INSERT INTO `food` VALUES (3, '', '', '', 0, NULL, 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3240052967,3443336204&fm=27&gp=0.jpg', '9999', 123.00, 569.00, 1);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `add_time` datetime NULL DEFAULT NULL,
  `total` double(255, 2) NULL DEFAULT 0.00,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `user_id` int(11) NULL DEFAULT 0,
  `business_id` int(11) NULL DEFAULT 0,
  `pay_time` datetime NULL DEFAULT NULL,
  `order_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `num` int(11) NULL DEFAULT 0,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `coupon_id` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 'mQmyQfcAg', '2019-04-14 00:05:40', 0.00, '预约', 'dfsdfscvxcxbxcxb', 3, 1, NULL, '2019-04-14 上午', 1, '555', 0);
INSERT INTO `orders` VALUES (2, 'ChlqFJDFI', '2019-04-14 00:07:59', 0.00, '已支付', 'fsdsdf', 3, 1, '2019-04-14 00:14:09', '2019-04-14 上午', 1, 'ffff', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `wx` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `addtime` datetime NULL DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 's', 'afd fsdfs ', '孝感', '', '', '', '', '2019-04-13 21:08:00', 'user');
INSERT INTO `user` VALUES (2, '111', '111', '111', '698D51A19D8A121CE581499D7B701668', '', '', 'SUCCESS', '2019-04-13 22:36:09', '');
INSERT INTO `user` VALUES (3, '123', '123', '555', '202CB962AC59075B964B07152D234B70', 'fsdfsdfs@qq.com', 'fsd1', 'SUCCESS', '2019-04-13 22:37:54', 'user');

SET FOREIGN_KEY_CHECKS = 1;
