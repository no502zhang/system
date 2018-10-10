SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account_info
-- ----------------------------
DROP TABLE IF EXISTS `account_info`;
CREATE TABLE `account_info` (
  `id` varchar(32) NOT NULL,
  `typ` tinyint(3) NOT NULL,
  `owner_type` tinyint(3) NOT NULL,
  `owner_id` varchar(32) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;