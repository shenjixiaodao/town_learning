CREATE SCHEMA `iintelligence` DEFAULT CHARACTER SET utf8 ;
USE `iintelligence`;

CREATE TABLE `ii_user_device` (
  `uid` VARCHAR(45) NOT NULL COMMENT '用户ID',
  `device_id` VARCHAR(45) NOT NULL COMMENT '设备ID',
  `device_type` VARCHAR(10) NOT NULL COMMENT '设备类型',
  `binding_status` VARCHAR(10) NOT NULL COMMENT '设备绑定状态',
  `gmt_create` DATETIME NOT NULL,
  `gmt_modified` DATETIME NOT NULL,
  UNIQUE INDEX `device_id_UNIQUE` (`device_id` ASC));

