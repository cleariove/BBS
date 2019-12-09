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

 Date: 09/12/2019 20:49:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for subitem
-- ----------------------------
DROP TABLE IF EXISTS `subitem`;
CREATE TABLE `subitem`  (
  `sub_item_id` int(11) NOT NULL COMMENT '子栏目id',
  `sub_item_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子栏目名称',
  `sub_item_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '子栏目描述',
  `manager` int(11) NULL DEFAULT NULL COMMENT '子栏目管理员',
  `item_id` int(11) NOT NULL COMMENT '所属栏目id',
  PRIMARY KEY (`sub_item_id`) USING BTREE,
  INDEX `subManager`(`manager`) USING BTREE,
  INDEX `subItemID`(`item_id`) USING BTREE,
  CONSTRAINT `subItemID` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subManager` FOREIGN KEY (`manager`) REFERENCES `user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
