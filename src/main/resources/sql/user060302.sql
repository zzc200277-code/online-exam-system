CREATE DATABASE IF NOT EXISTS `person` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `person`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `status` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `user` (`id`, `username`, `password`, `nickname`, `mail`, `phone`, `avatar`, `createTime`, `updateTime`, `status`, `userid`) VALUES
(1, 'aa', '123', '张三', 'aa@example.com', '13800000001', NULL, NOW(), NOW(), 1, 100),
(2, 'bb', '789', '李四', 'bb@example.com', '13800000002', NULL, NOW(), NOW(), 1, 200),
(3, 'cc', '123', '王五', 'cc@example.com', '13800000003', NULL, NOW(), NOW(), 0, 300),
(4, 'dd', '123', '赵六', 'dd@example.com', '13800000004', NULL, NOW(), NOW(), 2, 400),
(5, 'ee', '123', '钱七', 'ee@example.com', '13800000005', NULL, NOW(), NOW(), 1, 500);

SET FOREIGN_KEY_CHECKS = 1;
