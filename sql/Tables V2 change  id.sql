/*
Navicat MySQL Data Transfer

Source Server         : form
Source Server Version : 50145
Source Host           : localhost:3306
Source Database       : form

Target Server Type    : MYSQL
Target Server Version : 50145
File Encoding         : 65001

Date: 2011-05-15 10:41:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `fp_company`
-- ----------------------------
DROP TABLE IF EXISTS `fp_company`;
CREATE TABLE `fp_company` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `FP_ID` varchar(20) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `fp_company_user`
-- ----------------------------
DROP TABLE IF EXISTS `fp_company_user`;
CREATE TABLE `fp_company_user` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) unsigned NOT NULL,
  `FIRST_NAME` varchar(20) NOT NULL,
  `MIDDLE_INITIAL` varchar(5) DEFAULT NULL,
  `LAST_NAME` varchar(20) NOT NULL,
  `TITLE` varchar(50) DEFAULT NULL,
  `STATUS` tinyint(4) NOT NULL,
  `TYPE` tinyint(4) NOT NULL,
  `FP_LOGIN_ID` varchar(20) NOT NULL,
  `FP_PASSWORD` varchar(20) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FP_USER_COMPANY_ID_IDX` (`COMPANY_ID`),
  CONSTRAINT `fp_company_user_ibfk_1` FOREIGN KEY (`COMPANY_ID`) REFERENCES `fp_company` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `fp_form_data`
-- ----------------------------
DROP TABLE IF EXISTS `fp_form_data`;
CREATE TABLE `fp_form_data` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `TEMPLATE_ID` bigint(20) unsigned DEFAULT NULL,
  `text_20_1` varchar(20) DEFAULT NULL,
  `text_20_2` varchar(20) DEFAULT NULL,
  `text_20_3` varchar(20) DEFAULT NULL,
  `text_20_4` varchar(20) DEFAULT NULL,
  `text_20_5` varchar(20) DEFAULT NULL,
  `text_20_6` varchar(20) DEFAULT NULL,
  `text_20_7` varchar(20) DEFAULT NULL,
  `text_20_8` varchar(20) DEFAULT NULL,
  `text_20_9` varchar(20) DEFAULT NULL,
  `text_20_10` varchar(20) DEFAULT NULL,
  `text_20_11` varchar(20) DEFAULT NULL,
  `text_20_12` varchar(20) DEFAULT NULL,
  `text_20_13` varchar(20) DEFAULT NULL,
  `text_20_14` varchar(20) DEFAULT NULL,
  `text_20_15` varchar(20) DEFAULT NULL,
  `text_20_16` varchar(20) DEFAULT NULL,
  `text_20_17` varchar(20) DEFAULT NULL,
  `text_20_18` varchar(20) DEFAULT NULL,
  `text_20_19` varchar(20) DEFAULT NULL,
  `text_20_20` varchar(20) DEFAULT NULL,
  `text_50_1` varchar(50) DEFAULT NULL,
  `text_50_2` varchar(50) DEFAULT NULL,
  `text_50_3` varchar(50) DEFAULT NULL,
  `text_50_4` varchar(50) DEFAULT NULL,
  `text_50_5` varchar(50) DEFAULT NULL,
  `text_50_6` varchar(50) DEFAULT NULL,
  `text_50_7` varchar(50) DEFAULT NULL,
  `text_50_8` varchar(50) DEFAULT NULL,
  `text_50_9` varchar(50) DEFAULT NULL,
  `text_50_10` varchar(50) DEFAULT NULL,
  `text_50_11` varchar(50) DEFAULT NULL,
  `text_50_12` varchar(50) DEFAULT NULL,
  `text_50_13` varchar(50) DEFAULT NULL,
  `text_50_14` varchar(50) DEFAULT NULL,
  `text_50_15` varchar(50) DEFAULT NULL,
  `text_50_16` varchar(50) DEFAULT NULL,
  `text_50_17` varchar(50) DEFAULT NULL,
  `text_50_18` varchar(50) DEFAULT NULL,
  `text_50_19` varchar(50) DEFAULT NULL,
  `text_50_20` varchar(50) DEFAULT NULL,
  `text_100_1` varchar(100) DEFAULT NULL,
  `text_100_2` varchar(100) DEFAULT NULL,
  `text_100_3` varchar(100) DEFAULT NULL,
  `text_100_4` varchar(100) DEFAULT NULL,
  `text_100_5` varchar(100) DEFAULT NULL,
  `text_100_6` varchar(100) DEFAULT NULL,
  `text_100_7` varchar(100) DEFAULT NULL,
  `text_100_8` varchar(100) DEFAULT NULL,
  `text_100_9` varchar(100) DEFAULT NULL,
  `text_100_10` varchar(100) DEFAULT NULL,
  `text_100_11` varchar(100) DEFAULT NULL,
  `text_100_12` varchar(100) DEFAULT NULL,
  `text_100_13` varchar(100) DEFAULT NULL,
  `text_100_14` varchar(100) DEFAULT NULL,
  `text_100_15` varchar(100) DEFAULT NULL,
  `text_100_16` varchar(100) DEFAULT NULL,
  `text_100_17` varchar(100) DEFAULT NULL,
  `text_100_18` varchar(100) DEFAULT NULL,
  `text_100_19` varchar(100) DEFAULT NULL,
  `text_100_20` varchar(100) DEFAULT NULL,
  `text_500_1` varchar(500) DEFAULT NULL,
  `text_500_2` varchar(500) DEFAULT NULL,
  `text_500_3` varchar(500) DEFAULT NULL,
  `text_500_4` varchar(500) DEFAULT NULL,
  `text_500_5` varchar(500) DEFAULT NULL,
  `text_500_6` varchar(500) DEFAULT NULL,
  `text_500_7` varchar(500) DEFAULT NULL,
  `text_500_8` varchar(500) DEFAULT NULL,
  `text_500_9` varchar(500) DEFAULT NULL,
  `text_500_10` varchar(500) DEFAULT NULL,
  `text_2000_1` varchar(2000) DEFAULT NULL,
  `text_2000_2` varchar(2000) DEFAULT NULL,
  `text_2000_3` varchar(2000) DEFAULT NULL,
  `text_2000_4` varchar(2000) DEFAULT NULL,
  `text_2000_5` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FP_FORM_DATA_IDX` (`TEMPLATE_ID`),
  CONSTRAINT `fp_form_data_ibfk_1` FOREIGN KEY (`TEMPLATE_ID`) REFERENCES `fp_form_template` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
-- ----------------------------
-- Table structure for `fp_form_template`
-- ----------------------------
DROP TABLE IF EXISTS `fp_form_template`;
CREATE TABLE `fp_form_template` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `COMPANY_ID` bigint(20) unsigned NOT NULL,
  `CREATED_BY` bigint(20) unsigned NOT NULL,
  `LAST_MODIFIED_BY` bigint(20) unsigned NOT NULL,
  `FORM_TITLE` varchar(50) NOT NULL,
  `FORM_DESCRIPTION` varchar(300) DEFAULT NULL,
  `STATUS` tinyint(4) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FP_FORM_COMPANY_ID_IDX` (`COMPANY_ID`),
  KEY `FP_FORM_CREATED_BY_IDX` (`CREATED_BY`),
  KEY `FP_FORM_LST_MOD_BY_IDX` (`LAST_MODIFIED_BY`),
  CONSTRAINT `fp_form_template_ibfk_1` FOREIGN KEY (`COMPANY_ID`) REFERENCES `fp_company` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `fp_form_template_ibfk_2` FOREIGN KEY (`CREATED_BY`) REFERENCES `fp_company_user` (`ID`),
  CONSTRAINT `fp_form_template_ibfk_3` FOREIGN KEY (`LAST_MODIFIED_BY`) REFERENCES `fp_company_user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;