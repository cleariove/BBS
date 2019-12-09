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

 Date: 10/12/2019 00:16:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  PRIMARY KEY (`sub_item_id`) USING BTREE,
  INDEX `item_id`(`item_id`) USING BTREE,
  INDEX `sub_item_manager`(`manager`) USING BTREE,
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sub_item_manager` FOREIGN KEY (`manager`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
