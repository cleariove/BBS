/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 06/12/2019 14:46:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentID` int(11) NOT NULL COMMENT '评论ID',
  `commentFrom` int(11) NULL DEFAULT NULL COMMENT '评论者的ID',
  `commentTo` int(11) NULL DEFAULT NULL COMMENT '被评论的ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `topicID` int(11) NULL DEFAULT NULL COMMENT '所属帖子的ID',
  PRIMARY KEY (`commentID`) USING BTREE,
  INDEX `commentFrom`(`commentFrom`) USING BTREE,
  INDEX `commentTo`(`commentTo`) USING BTREE,
  INDEX `commentID`(`topicID`) USING BTREE,
  CONSTRAINT `commentFrom` FOREIGN KEY (`commentFrom`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentID` FOREIGN KEY (`topicID`) REFERENCES `topic` (`topicID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentTo` FOREIGN KEY (`commentTo`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `itemID` int(11) NOT NULL COMMENT '栏目ID',
  `itemName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栏目名称',
  `itemDescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栏目描述',
  `manager` int(11) NULL DEFAULT NULL COMMENT '栏目管理员ID',
  PRIMARY KEY (`itemID`) USING BTREE,
  INDEX `manager`(`manager`) USING BTREE,
  CONSTRAINT `manager` FOREIGN KEY (`manager`) REFERENCES `user` (`userID`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for subitem
-- ----------------------------
DROP TABLE IF EXISTS `subitem`;
CREATE TABLE `subitem`  (
  `subItemID` int(11) NOT NULL COMMENT '子栏目id',
  `subItemName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子栏目名称',
  `itemID` int(11) NOT NULL COMMENT '所属栏目id',
  `itemDescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子栏目描述',
  `manager` int(11) NULL DEFAULT NULL COMMENT '子栏目管理员',
  PRIMARY KEY (`subItemID`) USING BTREE,
  INDEX `subManager`(`manager`) USING BTREE,
  INDEX `subItemID`(`itemID`) USING BTREE,
  CONSTRAINT `subManager` FOREIGN KEY (`manager`) REFERENCES `user` (`userID`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `subItemID` FOREIGN KEY (`itemID`) REFERENCES `item` (`itemID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topicID` int(11) NOT NULL COMMENT '帖子id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子内容',
  `topicManager` int(11) NOT NULL COMMENT '贴主',
  `date` datetime(0) NOT NULL COMMENT '发帖时间',
  `browse` int(11) NULL DEFAULT NULL COMMENT '浏览数',
  `integral` int(8) NULL DEFAULT NULL COMMENT '积分情况',
  `help` tinyint(1) NULL DEFAULT NULL COMMENT '是否为求助帖',
  `elite` tinyint(1) NULL DEFAULT NULL COMMENT '是否为加精贴',
  `onPageTop` tinyint(1) NULL DEFAULT NULL COMMENT '是否置顶',
  `subItemID` int(11) NULL DEFAULT NULL COMMENT '子栏目ID',
  PRIMARY KEY (`topicID`) USING BTREE,
  INDEX `topicID`(`subItemID`) USING BTREE,
  INDEX `topicManager`(`topicManager`) USING BTREE,
  CONSTRAINT `topicID` FOREIGN KEY (`subItemID`) REFERENCES `subitem` (`subItemID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topicManager` FOREIGN KEY (`topicManager`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userID` int(11) NOT NULL COMMENT '用户编号',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `age` int(8) NULL DEFAULT NULL COMMENT '年龄',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthDay` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `power` int(8) NOT NULL DEFAULT 1 COMMENT '权限',
  `integral` int(8) NULL DEFAULT NULL COMMENT '积分',
  PRIMARY KEY (`userID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
