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

 Date: 09/12/2019 20:49:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topic_id` int(11) NOT NULL COMMENT '帖子id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子内容',
  `manager` int(11) NOT NULL COMMENT '贴主',
  `date` datetime(0) NOT NULL COMMENT '发帖时间',
  `browse` int(11) NULL DEFAULT NULL COMMENT '浏览数',
  `integral` int(8) NULL DEFAULT NULL COMMENT '积分情况',
  `help` tinyint(1) NULL DEFAULT NULL COMMENT '是否为求助帖',
  `elite` tinyint(1) NULL DEFAULT NULL COMMENT '是否为加精贴',
  `on_page_top` tinyint(1) NULL DEFAULT NULL COMMENT '是否置顶',
  `sub_item_id` int(11) NULL DEFAULT NULL COMMENT '子栏目ID',
  PRIMARY KEY (`topic_id`) USING BTREE,
  INDEX `topicID`(`sub_item_id`) USING BTREE,
  INDEX `topicManager`(`manager`) USING BTREE,
  CONSTRAINT `topicID` FOREIGN KEY (`sub_item_id`) REFERENCES `subitem` (`sub_item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topicManager` FOREIGN KEY (`manager`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
