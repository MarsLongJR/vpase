/*
Navicat MySQL Data Transfer

Source Server         : 101.132.101.73
Source Server Version : 50723
Source Host           : 101.132.101.73:3306
Source Database       : juice

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-03-15 16:23:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(20) DEFAULT NULL COMMENT '城市编号',
  `area_name` varchar(255) DEFAULT NULL COMMENT '城市名称（省/市/区/县）',
  `parent` varchar(20) DEFAULT NULL COMMENT '上级',
  `enable` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3225 DEFAULT CHARSET=utf8 COMMENT='城市表（省市区/县）';

-- ----------------------------
-- Table structure for sys_category
-- ----------------------------
DROP TABLE IF EXISTS `sys_category`;
CREATE TABLE `sys_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '类别名称',
  `code` varchar(11) NOT NULL COMMENT 'l类别编号',
  `parent` varchar(11) DEFAULT NULL COMMENT '父类',
  `enable` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='类别';

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sys_company`;
CREATE TABLE `sys_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `company_code` varchar(255) DEFAULT NULL COMMENT '公司系统编号',
  `link_man` varchar(255) DEFAULT NULL COMMENT '联系人',
  `link_tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `license` varchar(255) DEFAULT NULL COMMENT '营业执照',
  `create_time` datetime DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `modifier_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公司表';

-- ----------------------------
-- Table structure for sys_company_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_company_user`;
CREATE TABLE `sys_company_user` (
  `id` int(11) NOT NULL,
  `company_id` int(11) DEFAULT NULL COMMENT '公司',
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `name` varchar(256) DEFAULT NULL COMMENT '菜单名',
  `parent` int(11) DEFAULT NULL COMMENT '上级菜单',
  `url` varchar(256) DEFAULT NULL COMMENT '菜单路径',
  `icon` varchar(256) DEFAULT NULL COMMENT '菜单图标',
  `grade` int(11) DEFAULT NULL COMMENT '菜单等级',
  `level` int(11) DEFAULT NULL COMMENT '排序级别',
  `time` datetime DEFAULT NULL,
  `remark` varchar(256) DEFAULT NULL COMMENT '描述菜单的用途',
  `enable` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否启用 true 启用 false不启用',
  PRIMARY KEY (`id`),
  KEY `parent` (`parent`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `is_manager` bit(1) DEFAULT NULL COMMENT '是否是管理员',
  `type` smallint(6) DEFAULT NULL COMMENT '角色所属方 1-平台方 2-运营商 ',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(255) DEFAULT NULL,
  `user_code` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `open_id` varchar(20) DEFAULT NULL,
  `status` smallint(1) DEFAULT NULL COMMENT '登录状态',
  `create_time` datetime DEFAULT NULL,
  `create_id` varchar(255) DEFAULT NULL,
  `first_login` bit(1) DEFAULT NULL,
  `modifier_id` int(11) DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间s',
  `image_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `last_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `enable` bit(1) DEFAULT NULL COMMENT '账号是否启用  true：启用  false ：禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for sys_user_machine
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_machine`;
CREATE TABLE `sys_user_machine` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '用户id、',
  `machine_id` int(11) NOT NULL COMMENT '机器id',
  `distribute_id` int(11) NOT NULL COMMENT '分配人id',
  `distribute_time` datetime DEFAULT NULL COMMENT '分配时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for xbz_address
-- ----------------------------
DROP TABLE IF EXISTS `xbz_address`;
CREATE TABLE `xbz_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vip_id` int(11) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配送详细地址';

-- ----------------------------
-- Table structure for xbz_balance
-- ----------------------------
DROP TABLE IF EXISTS `xbz_balance`;
CREATE TABLE `xbz_balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '会员id',
  `price` decimal(10,2) DEFAULT NULL COMMENT '交易金额 ，充值为正数 ，购买为负数，退款为正数',
  `style` smallint(1) DEFAULT NULL COMMENT '方式  1:充值   2:购买 3:退款',
  `create_time` datetime DEFAULT NULL COMMENT '交易时间',
  `enable` bit(1) DEFAULT NULL COMMENT '是否存在',
  `source_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='会员账号余额表';

-- ----------------------------
-- Table structure for xbz_machine
-- ----------------------------
DROP TABLE IF EXISTS `xbz_machine`;
CREATE TABLE `xbz_machine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_name` varchar(255) NOT NULL COMMENT '机器名称',
  `machine_code` varchar(255) NOT NULL COMMENT '机器编号',
  `machine_type` smallint(6) DEFAULT NULL COMMENT '机器类型',
  `create_time` datetime DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL COMMENT '机器状态',
  `creator_id` int(11) DEFAULT NULL,
  `connect_status` bit(1) DEFAULT NULL COMMENT '连接状态 0:连接   1:断开',
  `
temperature_status` smallint(1) DEFAULT NULL COMMENT '温度状态 0:常温 1:制冷  2：制热',
  `address_id` int(11) DEFAULT NULL COMMENT '存放地址',
  `creator` varchar(50) DEFAULT NULL,
  `open_time` datetime DEFAULT NULL COMMENT '开机时间',
  `off_time` datetime DEFAULT NULL COMMENT '关机时间',
  `channel_num` int(11) DEFAULT NULL COMMENT '货道数量',
  `province` varchar(50) NOT NULL COMMENT '机器所在地址的省份',
  `city` varchar(50) NOT NULL COMMENT '机器所在地址的城市',
  `adress_detail` varchar(255) NOT NULL COMMENT '机器所在详细地址',
  `district` varchar(50) NOT NULL COMMENT '机器所在地址的区或县',
  `modifier` varchar(50) DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `modifier_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机器表';

-- ----------------------------
-- Table structure for xbz_order
-- ----------------------------
DROP TABLE IF EXISTS `xbz_order`;
CREATE TABLE `xbz_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) DEFAULT NULL COMMENT '订单编号 生成规则 支付方式+时间戳+6位随机数',
  `pickup_code` varchar(20) DEFAULT NULL COMMENT '取货码',
  `tel` varchar(13) DEFAULT NULL COMMENT '联系方式',
  `link_man` varchar(255) DEFAULT NULL,
  `total_price` decimal(8,2) NOT NULL COMMENT '订单价格',
  `order_type` int(1) DEFAULT NULL COMMENT '订单类型  1线上  2线下',
  `pay_price` decimal(10,2) DEFAULT NULL COMMENT '支付价格',
  `create_time` datetime DEFAULT NULL COMMENT '订单时间',
  `user_id` int(11) DEFAULT NULL COMMENT '会员id',
  `address_id` int(11) DEFAULT NULL COMMENT '配送地址',
  `enable` bit(1) DEFAULT NULL,
  `distribution_type` smallint(1) DEFAULT NULL COMMENT '配送方式 ：1.自提 2配送',
  `machine_code` varchar(11) DEFAULT NULL COMMENT '机器code（出自哪一台机器）',
  `pay_type` smallint(1) DEFAULT NULL COMMENT '支付方式  1：微信   2.支付宝   5提货码（线上）',
  `status` smallint(1) DEFAULT NULL COMMENT '1.未完成  2已完成 3退款',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单主表';

-- ----------------------------
-- Table structure for xbz_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `xbz_order_detail`;
CREATE TABLE `xbz_order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单主表的id',
  `store_id` int(11) NOT NULL,
  `count` smallint(6) DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `enable` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

-- ----------------------------
-- Table structure for xbz_order_line
-- ----------------------------
DROP TABLE IF EXISTS `xbz_order_line`;
CREATE TABLE `xbz_order_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单主表id',
  `status` smallint(2) NOT NULL COMMENT '订单状态  0：完成，订单结束  1：待付款    2：订单生成    3：订单失败   4：配货中   5：配送中   6:交易关闭  ',
  `processing_time` datetime NOT NULL COMMENT '处理时间',
  `user_id` int(20) DEFAULT NULL COMMENT '处理人id',
  `processor` varchar(255) DEFAULT NULL COMMENT '处理人',
  `processor_tel` varchar(255) DEFAULT NULL COMMENT '处理人联系方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单处理表';

-- ----------------------------
-- Table structure for xbz_recharge
-- ----------------------------
DROP TABLE IF EXISTS `xbz_recharge`;
CREATE TABLE `xbz_recharge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `accounts` decimal(20,2) NOT NULL,
  `status` smallint(2) DEFAULT NULL COMMENT '充值状态 1：充值成功  2：充值失败',
  `pay_type` smallint(1) DEFAULT NULL COMMENT '支付方式 1：现金  2：微信   3:支付宝',
  `recharge_time` datetime DEFAULT NULL COMMENT '充值时间',
  `enable` bit(1) DEFAULT NULL COMMENT '是否存在',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员充值表';

-- ----------------------------
-- Table structure for xbz_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `xbz_shopping_cart`;
CREATE TABLE `xbz_shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `store_id` int(11) DEFAULT NULL COMMENT '商品',
  `store_count` smallint(6) DEFAULT NULL COMMENT '商品数量',
  `userAccount` varchar(255) DEFAULT NULL COMMENT '用户账户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Table structure for xbz_store
-- ----------------------------
DROP TABLE IF EXISTS `xbz_store`;
CREATE TABLE `xbz_store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barcode` varchar(255) DEFAULT NULL COMMENT '商品条码',
  `store_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `sys_code` varchar(255) DEFAULT NULL COMMENT '自定义商品条码',
  `sys_name` varchar(255) DEFAULT NULL COMMENT '自定义商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `standard` varchar(255) DEFAULT NULL COMMENT '商品规格',
  `unit` varchar(5) DEFAULT NULL COMMENT '单位',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `create_id` int(11) DEFAULT NULL COMMENT '创建人的id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `length` double(20,4) DEFAULT NULL COMMENT '长',
  `length_unit` varchar(5) DEFAULT NULL COMMENT '长度单位',
  `wide` double(20,4) DEFAULT NULL COMMENT '商品宽',
  `wide_unit` varchar(5) DEFAULT NULL COMMENT '宽度单位',
  `height` double(20,4) DEFAULT NULL COMMENT '商品高度',
  `height_unit` varchar(5) DEFAULT NULL COMMENT '高度单位',
  `weight` double(20,4) DEFAULT NULL COMMENT '商品重量',
  `weight_unit` varchar(5) DEFAULT NULL COMMENT '重量单位',
  `enable` bit(1) DEFAULT NULL COMMENT '0:存在  1:不存在',
  `category_id` int(11) DEFAULT NULL COMMENT '商品种类id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for xbz_store_price_line
-- ----------------------------
DROP TABLE IF EXISTS `xbz_store_price_line`;
CREATE TABLE `xbz_store_price_line` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `store_id` bigint(11) NOT NULL,
  `price` decimal(12,2) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modifier_id` int(11) DEFAULT NULL COMMENT '修改人',
  `modification_time` datetime DEFAULT NULL COMMENT '修改时间',
  `enable` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品价格修改记录表';

-- ----------------------------
-- Table structure for xbz_vip
-- ----------------------------
DROP TABLE IF EXISTS `xbz_vip`;
CREATE TABLE `xbz_vip` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `vip_name` varchar(50) NOT NULL COMMENT '用户名',
  `vip_code` varchar(50) NOT NULL COMMENT '自动生成会员编码，规则',
  `wx_address` varchar(255) DEFAULT NULL COMMENT '微信地址',
  `tel` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '账号状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  `open_id` varchar(50) DEFAULT NULL COMMENT '微信openId',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `head_img` varchar(255) DEFAULT NULL COMMENT '头像',
  `vip_style` smallint(6) DEFAULT NULL COMMENT '会员类型 目前就一种会员 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息表，';
