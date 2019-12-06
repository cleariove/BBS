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

 Date: 06/12/2019 14:48:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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

SET FOREIGN_KEY_CHECKS = 1;
