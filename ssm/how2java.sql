/*
Navicat MySQL Data Transfer

Source Server         : how2java
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : how2java

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2018-02-12 09:04:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category_
-- ----------------------------
DROP TABLE IF EXISTS `category_`;
CREATE TABLE `category_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_
-- ----------------------------
INSERT INTO `category_` VALUES ('1', 'category1修改');
INSERT INTO `category_` VALUES ('2', 'category2修改');
INSERT INTO `category_` VALUES ('3', 'category3修改');
INSERT INTO `category_` VALUES ('4', '测试1修改');
INSERT INTO `category_` VALUES ('5', '测试1修改');
INSERT INTO `category_` VALUES ('6', '测试1');
INSERT INTO `category_` VALUES ('7', '测试1');
INSERT INTO `category_` VALUES ('8', '测试1');
INSERT INTO `category_` VALUES ('9', '测试1');
INSERT INTO `category_` VALUES ('10', '测试1');
INSERT INTO `category_` VALUES ('11', '测试1');
INSERT INTO `category_` VALUES ('12', '测试1');
INSERT INTO `category_` VALUES ('13', '测试1');
INSERT INTO `category_` VALUES ('14', '测试1');
INSERT INTO `category_` VALUES ('15', '测试1');
INSERT INTO `category_` VALUES ('16', '测试1');
INSERT INTO `category_` VALUES ('17', '测试1');
INSERT INTO `category_` VALUES ('18', '测试1');
INSERT INTO `category_` VALUES ('19', null);
INSERT INTO `category_` VALUES ('20', null);
INSERT INTO `category_` VALUES ('21', null);
INSERT INTO `category_` VALUES ('22', null);
INSERT INTO `category_` VALUES ('23', null);
INSERT INTO `category_` VALUES ('24', null);
INSERT INTO `category_` VALUES ('25', null);
INSERT INTO `category_` VALUES ('26', null);
INSERT INTO `category_` VALUES ('27', null);
INSERT INTO `category_` VALUES ('43', '1234');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123');
