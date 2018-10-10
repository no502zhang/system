SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dict_info
-- ----------------------------
DROP TABLE IF EXISTS `dict_info`;
CREATE TABLE `dict_info` (
  `id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `code` varchar(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `val` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8