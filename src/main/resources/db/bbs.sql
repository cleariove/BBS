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

 Date: 11/12/2019 21:40:26
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
  CONSTRAINT `comment_from` FOREIGN KEY (`comment_from`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_to` FOREIGN KEY (`comment_to`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topic_id` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '栏目ID',
  `item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栏目名称',
  `item_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '栏目描述',
  `manager` int(11) NULL DEFAULT NULL COMMENT '栏目管理员ID',
  `item_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`item_id`) USING BTREE,
  INDEX `item_manager`(`manager`) USING BTREE,
  CONSTRAINT `item_manager` FOREIGN KEY (`manager`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sub_comment
-- ----------------------------
DROP TABLE IF EXISTS `sub_comment`;
CREATE TABLE `sub_comment`  (
  `sub_comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '子评论id',
  `sub_comment_from` int(11) NULL DEFAULT NULL COMMENT '谁的子评论',
  `sub_comment_to` int(11) NULL DEFAULT NULL COMMENT '对谁的子评论',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `comment_id` int(11) NULL DEFAULT NULL COMMENT '所属评论id',
  PRIMARY KEY (`sub_comment_id`) USING BTREE,
  INDEX `sub_comment_from`(`sub_comment_from`) USING BTREE,
  INDEX `sub_comment_to`(`sub_comment_to`) USING BTREE,
  INDEX `comment_id`(`comment_id`) USING BTREE,
  CONSTRAINT `comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sub_comment_from` FOREIGN KEY (`sub_comment_from`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sub_comment_to` FOREIGN KEY (`sub_comment_to`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sub_item
-- ----------------------------
DROP TABLE IF EXISTS `sub_item`;
CREATE TABLE `sub_item`  (
  `sub_item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '子栏目id',
  `sub_item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子栏目名称',
  `sub_item_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子栏目描述',
  `manager` int(11) NULL DEFAULT NULL COMMENT '子栏目管理员',
  `item_id` int(11) NOT NULL COMMENT '所属栏目id',
  `sub_item_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`sub_item_id`) USING BTREE,
  INDEX `item_id`(`item_id`) USING BTREE,
  INDEX `sub_item_manager`(`manager`) USING BTREE,
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sub_item_manager` FOREIGN KEY (`manager`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子id',
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
  INDEX `sub_item_id`(`sub_item_id`) USING BTREE,
  INDEX `topic_manager`(`manager`) USING BTREE,
  CONSTRAINT `sub_item_id` FOREIGN KEY (`sub_item_id`) REFERENCES `sub_item` (`sub_item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `topic_manager` FOREIGN KEY (`manager`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `age` int(8) NULL DEFAULT NULL COMMENT '年龄',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `power` int(8) NOT NULL DEFAULT 1 COMMENT '权限',
  `integral` int(8) NULL DEFAULT NULL COMMENT '积分',
  `user_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
