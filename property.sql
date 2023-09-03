/*
Navicat MySQL Data Transfer

Source Server         : kazusa
Source Server Version : 80019
Source Host           : 127.0.0.1:3306
Source Database       : property

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2023-07-08 17:32:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rpms_build
-- ----------------------------
DROP TABLE IF EXISTS `rpms_build`;
CREATE TABLE `rpms_build` (
  `build_id` int NOT NULL AUTO_INCREMENT COMMENT '楼栋ID号',
  `build_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '楼栋名',
  `build_start` date NOT NULL COMMENT '开工时间',
  `build_finish` date NOT NULL COMMENT '竣工时间',
  `build_leak` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci DEFAULT NULL COMMENT '漏洞消息',
  `build_area` float NOT NULL COMMENT '建筑面积',
  `build_delete` int NOT NULL COMMENT '删除状态码',
  PRIMARY KEY (`build_id`),
  KEY `PK_buildId` (`build_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_build
-- ----------------------------
INSERT INTO `rpms_build` VALUES ('1', '御龙国际', '2020-01-14', '2023-07-20', null, '1000', '0');
INSERT INTO `rpms_build` VALUES ('2', '御龙国际', '2021-05-20', '2023-07-26', null, '1500', '0');
INSERT INTO `rpms_build` VALUES ('3', '碧园冲', '2022-05-25', '2023-07-27', null, '2500', '0');
INSERT INTO `rpms_build` VALUES ('4', '碧园冲', '2022-05-17', '2023-07-17', null, '3450', '0');
INSERT INTO `rpms_build` VALUES ('5', '御龙国际', '2021-06-29', '2023-06-19', null, '2540', '0');
INSERT INTO `rpms_build` VALUES ('6', '简单家', '2021-05-13', '2022-07-20', null, '2568', '0');
INSERT INTO `rpms_build` VALUES ('7', '碧荷园', '2020-12-24', '2020-12-28', 'chrismas', '200.2', '0');

-- ----------------------------
-- Table structure for rpms_charge
-- ----------------------------
DROP TABLE IF EXISTS `rpms_charge`;
CREATE TABLE `rpms_charge` (
  `chargeId` int NOT NULL AUTO_INCREMENT COMMENT '收费项目ID',
  `chargeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '收费项目名称',
  `chargeUnit` float NOT NULL COMMENT '收费标准',
  `chargeDelete` int NOT NULL COMMENT '删除状态码',
  PRIMARY KEY (`chargeId`)
) ENGINE=MyISAM AUTO_INCREMENT=10006 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_charge
-- ----------------------------
INSERT INTO `rpms_charge` VALUES ('1', '水电费', '10', '0');
INSERT INTO `rpms_charge` VALUES ('2', '物业费', '4', '0');
INSERT INTO `rpms_charge` VALUES ('3', '停车费', '5', '0');
INSERT INTO `rpms_charge` VALUES ('4', '管理费', '6', '0');
INSERT INTO `rpms_charge` VALUES ('5', '保护费', '3', '0');

-- ----------------------------
-- Table structure for rpms_details
-- ----------------------------
DROP TABLE IF EXISTS `rpms_details`;
CREATE TABLE `rpms_details` (
  `details_id` int NOT NULL AUTO_INCREMENT,
  `resource_id` int NOT NULL,
  `details_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`details_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of rpms_details
-- ----------------------------
INSERT INTO `rpms_details` VALUES ('1', '1', '只有管理员可以操控，能够对角色、权限、用户和数据等进行操作');
INSERT INTO `rpms_details` VALUES ('2', '2', '只有管理员可以操控，对楼栋进行增删查改等操作');
INSERT INTO `rpms_details` VALUES ('3', '3', '只有管理员可以操控，对房间进行增删查改等操作');
INSERT INTO `rpms_details` VALUES ('4', '4', '只有管理员和楼栋长可以操控，对业主进行增删查改等操作');
INSERT INTO `rpms_details` VALUES ('5', '5', '只有管理员和楼栋长以及业主代表可以操控，对业主成员进行增删查改等操作');
INSERT INTO `rpms_details` VALUES ('6', '6', '只有管理员和楼栋长以及业主代表可以操控，对收费项目进行增删查改等操作');
INSERT INTO `rpms_details` VALUES ('7', '7', '只有管理员和楼栋长以及业主代表可以操控，对业主缴费进行增删查改等操作');
INSERT INTO `rpms_details` VALUES ('8', '8', '只有管理员可以操控，对物资类别进行增删查改等操作');
INSERT INTO `rpms_details` VALUES ('9', '9', '只有管理员可以操控，对物资设备进行增删查改等操作');

-- ----------------------------
-- Table structure for rpms_material
-- ----------------------------
DROP TABLE IF EXISTS `rpms_material`;
CREATE TABLE `rpms_material` (
  `materialId` int NOT NULL AUTO_INCREMENT COMMENT '物资ID号',
  `materialName` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '物资名称',
  `materialCount` int NOT NULL COMMENT '数量',
  `materialPrice` float(50,0) NOT NULL COMMENT '单价',
  `typeId` int NOT NULL COMMENT '物资类别ID',
  `materialDate` varchar(255) COLLATE utf8_esperanto_ci NOT NULL COMMENT '入库时间',
  `materialOutDate` varchar(255) COLLATE utf8_esperanto_ci NOT NULL COMMENT '出库时间',
  `materialStat` int NOT NULL COMMENT '物资状态',
  `materialDelete` int NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`materialId`)
) ENGINE=MyISAM AUTO_INCREMENT=115 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_material
-- ----------------------------
INSERT INTO `rpms_material` VALUES ('112', '灭火器', '40', '60', '1', '2023-05-17 15:14:44', '2023-07-17 15:14:52', '1', '0');
INSERT INTO `rpms_material` VALUES ('113', '洗发水', '39', '67', '2', '2023-07-17 15:15:28', '2023-07-30 15:15:34', '1', '0');
INSERT INTO `rpms_material` VALUES ('114', '沐浴露', '56', '46', '3', '2023-07-04 15:38:30', '2023-07-27 15:38:34', '1', '0');

-- ----------------------------
-- Table structure for rpms_member
-- ----------------------------
DROP TABLE IF EXISTS `rpms_member`;
CREATE TABLE `rpms_member` (
  `member_id` int NOT NULL AUTO_INCREMENT COMMENT '业主成员ID',
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '成员姓名',
  `member_sex` int NOT NULL COMMENT '成员性别',
  `member_native` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '成员籍贯',
  `member_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci DEFAULT NULL COMMENT '联系方式',
  `member_comp` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci DEFAULT NULL COMMENT '工作单位',
  `room_id` int DEFAULT NULL,
  `build_id` int DEFAULT NULL COMMENT '业主ID',
  `member_delete` int NOT NULL COMMENT '删除状态码',
  PRIMARY KEY (`member_id`)
) ENGINE=MyISAM AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_member
-- ----------------------------
INSERT INTO `rpms_member` VALUES ('101', '每日一', '1', '湖北', null, null, '11', '1', '0');
INSERT INTO `rpms_member` VALUES ('103', '丰富', '1', '浙江', null, null, '15', '2', '0');
INSERT INTO `rpms_member` VALUES ('104', 'haruki', '1', 'tokyo', '13277113227', 'powder', '14', '3', '0');
INSERT INTO `rpms_member` VALUES ('111', 'haruki', '1', 'tokyo', '13277113227', 'snow', '12', '3', '0');
INSERT INTO `rpms_member` VALUES ('108', 'haruki', '1', 'tokyo', '13277113227', 'almost', '12', '4', '0');
INSERT INTO `rpms_member` VALUES ('109', 'kazusa', '1', 'tokyo', '13277113227', 'almost', '11', '1', '0');

-- ----------------------------
-- Table structure for rpms_owner
-- ----------------------------
DROP TABLE IF EXISTS `rpms_owner`;
CREATE TABLE `rpms_owner` (
  `owner_id` int NOT NULL AUTO_INCREMENT COMMENT '业主ID号',
  `owner_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '业主姓名',
  `owner_sex` int NOT NULL COMMENT '业主性别',
  `owner_native` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '业主籍贯',
  `owner_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci DEFAULT NULL COMMENT '业主联系电话',
  `owner_iden` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '身份证号',
  `owner_den` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '工作单位',
  `room_id` int NOT NULL COMMENT '房间ID号',
  `build_id` int NOT NULL COMMENT '角色ID号',
  `owner_delete` int NOT NULL COMMENT '删除状态码',
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`owner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1026 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_owner
-- ----------------------------
INSERT INTO `rpms_owner` VALUES ('1023', 'fanyi', '0', 'wing', '13277113227', '420625200111021512', 'china', '11', '1', '0', '12');
INSERT INTO `rpms_owner` VALUES ('1006', 'setsuna', '1', 'wing', '13277113227', '420625200111021512', 'asd', '12', '2', '0', '12');
INSERT INTO `rpms_owner` VALUES ('1007', 'kazusa', '1', 'asd', '13277113227', '420625200111021512', 'asd', '11', '3', '0', '11');
INSERT INTO `rpms_owner` VALUES ('1008', 'kazusa', '0', 'wing', '13277113227', '420625200111021512', 'asd', '13', '4', '0', '13');
INSERT INTO `rpms_owner` VALUES ('1020', 'setsuna', '1', 'wing', '13277113227', '420625200111021512', 'asd', '12', '6', '0', '14');
INSERT INTO `rpms_owner` VALUES ('1019', 'asahi', '1', 'wing', '13277113227', '420625200111021512', 'tyoko', '13', '2', '0', '11');
INSERT INTO `rpms_owner` VALUES ('1021', 'setsuna', '1', 'wing', '13277113227', '420625200111021512', 'asd', '11', '3', '0', '12');
INSERT INTO `rpms_owner` VALUES ('1022', '中一', '1', 'wing', '13277113227', '420625200111021512', 'tyoko', '11', '4', '0', '13');
INSERT INTO `rpms_owner` VALUES ('1018', 'kazusa', '0', 'wing', '13277113227', '420625200111021512', 'asd', '13', '5', '0', '14');
INSERT INTO `rpms_owner` VALUES ('1024', 'setsuna', '0', 'wing', '13277113227', '420625200111021512', 'asdad', '12', '2', '0', '5');
INSERT INTO `rpms_owner` VALUES ('1025', '纱', '0', 'wing', '13277113227', '420625200111021512', 'asd', '11', '3', '0', '11');

-- ----------------------------
-- Table structure for rpms_owner_room
-- ----------------------------
DROP TABLE IF EXISTS `rpms_owner_room`;
CREATE TABLE `rpms_owner_room` (
  `ownerRoomId` int NOT NULL AUTO_INCREMENT,
  `roomId` int NOT NULL COMMENT '房间ID',
  `ownerId` int NOT NULL COMMENT '业主ID',
  PRIMARY KEY (`ownerRoomId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_owner_room
-- ----------------------------
INSERT INTO `rpms_owner_room` VALUES ('1', '11', '1001');
INSERT INTO `rpms_owner_room` VALUES ('2', '12', '1002');
INSERT INTO `rpms_owner_room` VALUES ('3', '13', '1003');
INSERT INTO `rpms_owner_room` VALUES ('4', '14', '1004');
INSERT INTO `rpms_owner_room` VALUES ('5', '15', '1005');

-- ----------------------------
-- Table structure for rpms_pay
-- ----------------------------
DROP TABLE IF EXISTS `rpms_pay`;
CREATE TABLE `rpms_pay` (
  `payId` int NOT NULL AUTO_INCREMENT COMMENT '缴费单ID',
  `chargeId` int NOT NULL COMMENT '收费项目ID',
  `payMoney` float NOT NULL COMMENT '应收金额',
  `payReceive` float NOT NULL COMMENT '实收金额',
  `payLack` float NOT NULL COMMENT '欠费金额',
  `payDate` datetime NOT NULL COMMENT '收费时间',
  `ownerId` int NOT NULL COMMENT '业主ID号',
  `payState` int NOT NULL COMMENT '缴费状态',
  `payMonth` datetime NOT NULL COMMENT '缴费月份',
  PRIMARY KEY (`payId`)
) ENGINE=MyISAM AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_pay
-- ----------------------------
INSERT INTO `rpms_pay` VALUES ('111', '1', '1000', '900', '100', '2023-07-10 15:10:36', '1001', '0', '2023-07-19 15:11:39');
INSERT INTO `rpms_pay` VALUES ('112', '2', '300', '300', '0', '2023-06-27 15:12:03', '1002', '0', '2023-07-31 15:12:16');
INSERT INTO `rpms_pay` VALUES ('113', '3', '400', '200', '200', '2023-05-25 15:35:00', '1003', '0', '2023-07-11 15:35:17');
INSERT INTO `rpms_pay` VALUES ('114', '4', '200', '200', '0', '2023-07-10 00:00:00', '1004', '1', '2023-07-24 15:35:54');
INSERT INTO `rpms_pay` VALUES ('116', '1', '200', '0', '200', '2023-07-10 00:00:00', '1001', '0', '2023-07-10 00:00:00');

-- ----------------------------
-- Table structure for rpms_resource
-- ----------------------------
DROP TABLE IF EXISTS `rpms_resource`;
CREATE TABLE `rpms_resource` (
  `resource_id` int NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of rpms_resource
-- ----------------------------
INSERT INTO `rpms_resource` VALUES ('1', '管理员管理');
INSERT INTO `rpms_resource` VALUES ('2', '楼栋管理');
INSERT INTO `rpms_resource` VALUES ('3', '房间管理');
INSERT INTO `rpms_resource` VALUES ('4', '业主管理');
INSERT INTO `rpms_resource` VALUES ('5', '业主成员');
INSERT INTO `rpms_resource` VALUES ('6', '收费项目');
INSERT INTO `rpms_resource` VALUES ('7', '业主缴费');
INSERT INTO `rpms_resource` VALUES ('8', '物资类别');
INSERT INTO `rpms_resource` VALUES ('9', '物资设备');

-- ----------------------------
-- Table structure for rpms_role
-- ----------------------------
DROP TABLE IF EXISTS `rpms_role`;
CREATE TABLE `rpms_role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID号',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '角色类别',
  `role_resource` varchar(255) COLLATE utf8_esperanto_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `PK_roleId` (`role_id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_role
-- ----------------------------
INSERT INTO `rpms_role` VALUES ('11', '管理员', '012345678');
INSERT INTO `rpms_role` VALUES ('12', '租户', '56');
INSERT INTO `rpms_role` VALUES ('13', '员工', '45678');
INSERT INTO `rpms_role` VALUES ('14', '员工', '45678');
INSERT INTO `rpms_role` VALUES ('15', '业主', '56');

-- ----------------------------
-- Table structure for rpms_room
-- ----------------------------
DROP TABLE IF EXISTS `rpms_room`;
CREATE TABLE `rpms_room` (
  `room_id` int NOT NULL COMMENT '房间ID',
  `build_name` varchar(255) COLLATE utf8_esperanto_ci DEFAULT NULL,
  `build_id` int DEFAULT NULL,
  `room_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '房间名',
  `room_date` date DEFAULT NULL COMMENT '入住时间',
  `room_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci DEFAULT NULL COMMENT '房型',
  `room_use` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci DEFAULT NULL COMMENT '用途',
  `room_area` float NOT NULL COMMENT '建筑面积',
  `room_percent` float NOT NULL COMMENT '得房率',
  `room_delete` int NOT NULL COMMENT '删除状态码',
  PRIMARY KEY (`room_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_room
-- ----------------------------
INSERT INTO `rpms_room` VALUES ('11', '御龙国际', '1', '鹿鸣阁', '2023-07-03', null, null, '100', '80', '0');
INSERT INTO `rpms_room` VALUES ('12', '碧园冲', '2', '栖子堂', null, null, null, '110', '50', '0');
INSERT INTO `rpms_room` VALUES ('13', '碧园冲', '3', '凌烟阁', null, null, null, '235', '67', '0');
INSERT INTO `rpms_room` VALUES ('14', '简单家', '4', '悦仙楼', null, null, null, '230', '80', '0');
INSERT INTO `rpms_room` VALUES ('15', '--请选择--', '5', '惜云亭', '2020-12-24', '商品房', '居住', '30', '0.6', '0');

-- ----------------------------
-- Table structure for rpms_type
-- ----------------------------
DROP TABLE IF EXISTS `rpms_type`;
CREATE TABLE `rpms_type` (
  `typeId` int NOT NULL AUTO_INCREMENT COMMENT '物资类别ID号',
  `typeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '物资类别名',
  `typeDelete` int NOT NULL COMMENT '删除状态码',
  PRIMARY KEY (`typeId`),
  KEY `PK_typeId` (`typeId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_type
-- ----------------------------
INSERT INTO `rpms_type` VALUES ('2', '洗漱用品', '0');
INSERT INTO `rpms_type` VALUES ('1', '消防用品', '0');
INSERT INTO `rpms_type` VALUES ('3', '食用盐', '0');
INSERT INTO `rpms_type` VALUES ('4', '电脑', '0');

-- ----------------------------
-- Table structure for rpms_user
-- ----------------------------
DROP TABLE IF EXISTS `rpms_user`;
CREATE TABLE `rpms_user` (
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '用户名',
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_esperanto_ci NOT NULL COMMENT '密码',
  `owner_id` int NOT NULL COMMENT '业主ID',
  `role_id` int NOT NULL COMMENT '角色ID号',
  `user_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_id`,`role_id`,`owner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_esperanto_ci;

-- ----------------------------
-- Records of rpms_user
-- ----------------------------
INSERT INTO `rpms_user` VALUES ('admin', 'admin', '1001', '11', '1');
INSERT INTO `rpms_user` VALUES ('admin1', '123456', '1002', '12', '2');
INSERT INTO `rpms_user` VALUES ('admin2', '123', '1003', '13', '3');
INSERT INTO `rpms_user` VALUES ('admin3', '12', '1004', '14', '4');
INSERT INTO `rpms_user` VALUES ('add', '123456', '1001', '12', '5');
