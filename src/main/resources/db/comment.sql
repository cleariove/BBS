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

 Date: 10/12/2019 00:15:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `comment_from` int(11) NULL DEFAULT NULL COMMENT '评论者的ID',
  `comment_to` int(11) NULL DEFAULT NULL COMMENT '被评论的ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '所属帖子的ID',
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `topic_id`(`topic_id`) USING BTREE,
  INDEX `comment_from`(`comment_from`) USING BTREE,
  INDEX `comment_to`(`comment_to`) USING BTREE,
  CONSTRAINT `topic_id` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_from` FOREIGN KEY (`comment_from`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_to` FOREIGN KEY (`comment_to`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
