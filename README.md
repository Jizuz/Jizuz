# Jizuz
# springboot + thymeleaf + shiro + mybatis

# sql脚本
/*
Navicat MySQL Data Transfer

Source Server         : zshoon
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : jizuz

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-01-24 18:07:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_photo
-- ----------------------------
DROP TABLE IF EXISTS `t_photo`;
CREATE TABLE `t_photo` (
  `oid` bigint(32) NOT NULL,
  `tid` bigint(32) NOT NULL COMMENT '主题',
  `path` varchar(255) DEFAULT NULL COMMENT '图片在服务器路径',
  `author` varchar(255) DEFAULT NULL COMMENT '图片作者',
  `date` date DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL COMMENT '图片描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_photo
-- ----------------------------
INSERT INTO `t_photo` VALUES ('1', '1', '/img/bg.jpg', 'Jizuz', '2018-01-24', '背景');
INSERT INTO `t_photo` VALUES ('2', '2', 'img/thumbnails/picjumbo.com_IMG_4566.jpg', 'Jizuz', '2018-01-24', '南京');
INSERT INTO `t_photo` VALUES ('3', '2', 'img/thumbnails/picjumbo.com_IMG_4566.jpg', 'jizuz', '2018-01-24', '南京');

-- ----------------------------
-- Table structure for t_photo_theme
-- ----------------------------
DROP TABLE IF EXISTS `t_photo_theme`;
CREATE TABLE `t_photo_theme` (
  `tid` bigint(32) NOT NULL,
  `theme` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_photo_theme
-- ----------------------------
INSERT INTO `t_photo_theme` VALUES ('1', '系统');
INSERT INTO `t_photo_theme` VALUES ('2', '南京');

-- ----------------------------
-- Table structure for t_state
-- ----------------------------
DROP TABLE IF EXISTS `t_state`;
CREATE TABLE `t_state` (
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_state
-- ----------------------------
INSERT INTO `t_state` VALUES ('A', '可用');
INSERT INTO `t_state` VALUES ('X', '失效');

-- ----------------------------
-- Table structure for t_time_axis
-- ----------------------------
DROP TABLE IF EXISTS `t_time_axis`;
CREATE TABLE `t_time_axis` (
  `id` bigint(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `time_point` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_time_axis
-- ----------------------------
INSERT INTO `t_time_axis` VALUES ('1', '', '这是第一条！', 'Jizuz', '2018-01-17 00:00:00.000000');
INSERT INTO `t_time_axis` VALUES ('2', '记录', '这是第二条！', 'Jizuz', '2018-01-17 00:08:00.000000');

-- ----------------------------
-- Table structure for u_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `pid` bigint(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('1', 'add', null);
INSERT INTO `u_permission` VALUES ('2', 'delete', null);
INSERT INTO `u_permission` VALUES ('3', 'query', null);
INSERT INTO `u_permission` VALUES ('4', 'view', null);
INSERT INTO `u_permission` VALUES ('5', 'edit', null);

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `rid` bigint(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `u_role` VALUES ('2', 'member', '会员');
INSERT INTO `u_role` VALUES ('3', 'visitor', '游客');

-- ----------------------------
-- Table structure for u_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role_permission
-- ----------------------------
INSERT INTO `u_role_permission` VALUES ('1', '1', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '2', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '3', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '4', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '1', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '2', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '5', 'A', null);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `uid` bigint(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `birthday` date DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `home_address` varchar(255) DEFAULT NULL,
  `now_address` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('10000', 'Jizuz', '仇鹏飞', '111111', '1992-07-04', '男', '18251901820', 'qpf123@outlook.com', '江苏.南通', '江苏.南京', '苏宁金融');
INSERT INTO `u_user` VALUES ('10001', 'LaoGa', '葛沁阳', '111111', '1993-04-18', '男', '18251901682', 'ge.qinyang@zshoon.com', '江苏.常州', '江苏.南京', '亚信科技');

-- ----------------------------
-- Table structure for u_user_role
-- ----------------------------
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_role
-- ----------------------------
INSERT INTO `u_user_role` VALUES ('10000', '1', 'A', '');
INSERT INTO `u_user_role` VALUES ('10001', '2', 'A', null);
