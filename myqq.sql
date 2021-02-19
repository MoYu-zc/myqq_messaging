/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : myqq

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 18/02/2021 17:28:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for msg
-- ----------------------------
DROP TABLE IF EXISTS `msg`;
CREATE TABLE `msg`  (
  `msg_id` int(11) NOT NULL AUTO_INCREMENT,
  `msg_content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msg_sendfrom` int(11) NULL DEFAULT NULL,
  `msg_sendto` int(11) NULL DEFAULT NULL,
  `msg_sendtime` datetime NULL DEFAULT NULL,
  `msg_remark` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msg_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`msg_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of msg
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_ip` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_gender` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_last_login` datetime NULL DEFAULT NULL,
  `u_last_exit` datetime NULL DEFAULT NULL,
  `u_remarke` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_signature` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_head_img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_birthday` date NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'zc', '123', '127.0.0.1', '-1', '男', 'jfs@qq.com', '2021-02-18 17:11:05', '2021-02-18 17:14:06', NULL, '大家好，我是小茗同学！', '0', NULL, '1992-07-28');
INSERT INTO `users` VALUES (2, 'zcc', '123', '127.0.0.1', '-1', '男', 'ss@qq.com', '2021-02-18 17:11:40', '2021-02-18 17:14:07', NULL, '哈哈，我是马化腾！', '3', NULL, '1992-07-28');
INSERT INTO `users` VALUES (3, 'ddd', '123', '172.16.4.97', '0', '男', 'fjs@qq.com ', '2015-04-21 18:01:57', NULL, NULL, '我与徐婷婷不得不说的事儿', '4', NULL, '1992-07-28');

SET FOREIGN_KEY_CHECKS = 1;
