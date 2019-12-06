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

 Date: 06/12/2019 14:48:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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

SET FOREIGN_KEY_CHECKS = 1;
