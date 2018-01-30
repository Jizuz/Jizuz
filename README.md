# Jizuz
# springboot + thymeleaf + shiro + mybatis

# sql脚本
/*
Navicat MySQL Data Transfer

Source Server         : jizuz
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : jizuz

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-01-31 01:43:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `aid` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `star` int(32) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `type` varchar(2) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '', 'Jizuz', '2018-01-29', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('2', '', 'Jizuz', '2018-01-29', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('3', '', 'Jizuz', '2018-01-29', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('4', '苏宁', '<strong>苏宁金融</strong> 金融研发中心 <em>商旅产品开发部</em>', 'Jizuz', '2018-01-30', '0', 'A', '1');
INSERT INTO `t_article` VALUES ('5', 'python', '<strong>PYTHON</strong> 核心编程', 'Jizuz', '2018-01-30', '0', 'A', '2');

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
  `comments` varchar(255) DEFAULT NULL COMMENT '图片描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_photo
-- ----------------------------
INSERT INTO `t_photo` VALUES ('1', '1', '/img/bg.jpg', 'Jizuz', '2018-01-24', '背景');
INSERT INTO `t_photo` VALUES ('2', '2', 'img/photos/IMG_20180126141792512.JPG', 'Jizuz', '2018-01-24', '南京');
INSERT INTO `t_photo` VALUES ('3', '2', 'img/photos/IMG_20180126142032134.JPG', 'jizuz', '2018-01-24', '南京');
INSERT INTO `t_photo` VALUES ('4', '2', 'img/photos/IMG_20180126143108267.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('5', '3', 'img/photos/IMG_20180126143117687.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('6', '3', 'img/photos/IMG_20180130233111243.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('7', '4', 'img/photos/IMG_20180130233345658.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('8', '4', 'img/photos/IMG_20180130233452987.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('9', '4', 'img/photos/IMG_20180130233509876.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('10', '4', 'img/photos/IMG_20180130233634647.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('11', '4', 'img/photos/IMG_20180130233723257.jpg', 'Jizuz', '2018-01-25', null);
INSERT INTO `t_photo` VALUES ('12', '3', 'img/photos/IMG_20180130233836746.jpg', 'Jizuz', '2018-01-30', null);
INSERT INTO `t_photo` VALUES ('13', '3', 'img/photos/IMG_20180130233912547.jpg', 'Jizuz', '2018-01-30', null);
INSERT INTO `t_photo` VALUES ('17', '2', 'img/photos/IMG_20180131012056974.jpg', 'Jizuz', '2018-01-31', '新的');
INSERT INTO `t_photo` VALUES ('18', '2', 'img/photos/IMG_20180131012348392.jpg', 'Jizuz', '2018-01-31', '斯柯达');
INSERT INTO `t_photo` VALUES ('19', '2', 'img\\photos\\IMG_20180131012348392.jpg', 'Jizuz', '2018-01-31', '大学');
INSERT INTO `t_photo` VALUES ('20', '2', 'img\\photos\\IMG_20180131012348392.jpg', 'Jizuz', '2018-01-31', '当时');

-- ----------------------------
-- Table structure for t_photo_theme
-- ----------------------------
DROP TABLE IF EXISTS `t_photo_theme`;
CREATE TABLE `t_photo_theme` (
  `tid` bigint(32) NOT NULL,
  `theme` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_photo_theme
-- ----------------------------
INSERT INTO `t_photo_theme` VALUES ('1', '系统', 'A', null);
INSERT INTO `t_photo_theme` VALUES ('2', '南京', 'A', null);
INSERT INTO `t_photo_theme` VALUES ('3', '青海', 'A', null);
INSERT INTO `t_photo_theme` VALUES ('4', '镇江', 'A', null);

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
  `id` int(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `time_point` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_time_axis
-- ----------------------------
INSERT INTO `t_time_axis` VALUES ('1', '', '这是第一条！', 'Jizuz', '2018-01-17 23:02:43');
INSERT INTO `t_time_axis` VALUES ('2', '第二条', '这是第二条！', 'Jizuz', '2018-01-17 23:03:30');
INSERT INTO `t_time_axis` VALUES ('3', null, '这是第三条！', 'Jizuz', '2018-01-17 23:05:02');
INSERT INTO `t_time_axis` VALUES ('4', null, '这是第四条！', 'Jizuz', '2018-01-17 23:05:06');
INSERT INTO `t_time_axis` VALUES ('5', null, '这是第五条！', 'Jizuz', '2018-01-17 23:05:12');
INSERT INTO `t_time_axis` VALUES ('6', null, '这是第六条！', 'Jizuz', '2018-01-17 23:05:16');

-- ----------------------------
-- Table structure for u_permission
-- ----------------------------
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('1', 'view', '可查看');
INSERT INTO `u_permission` VALUES ('2', 'edit', '可编辑');
INSERT INTO `u_permission` VALUES ('3', 'delete', '可删除');
INSERT INTO `u_permission` VALUES ('4', 'add', '可增加');
INSERT INTO `u_permission` VALUES ('5', 'upload', '可上传');
INSERT INTO `u_permission` VALUES ('6', 'download', '可下载');

-- ----------------------------
-- Table structure for u_role
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
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
INSERT INTO `u_role_permission` VALUES ('1', '5', 'A', null);
INSERT INTO `u_role_permission` VALUES ('1', '6', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '1', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '2', 'A', null);
INSERT INTO `u_role_permission` VALUES ('2', '4', 'A', null);
INSERT INTO `u_role_permission` VALUES ('3', '1', 'A', null);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `uid` int(11) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
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
INSERT INTO `u_user` VALUES ('10001', 'Laoga', '葛沁阳', '111111', '1993-04-18', '男', '18251901682', 'ge.qinyang@zshoon.com', '江苏.常州', '江苏.南京', '亚信科技');

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
