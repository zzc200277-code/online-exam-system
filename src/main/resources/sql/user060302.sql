CREATE DATABASE IF NOT EXISTS `exam_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `exam_system`;

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
(1, 'student01', '123456', '张三', 'student01@example.com', '13800000001', NULL, NOW(), NOW(), 1, 100),
(2, 'student02', '123456', '李四', 'student02@example.com', '13800000002', NULL, NOW(), NOW(), 1, 200),
(3, 'student03', '123456', '王五', 'student03@example.com', '13800000003', NULL, NOW(), NOW(), 0, 300),
(4, 'teacher01', '123456', '管理员', 'teacher01@example.com', '13800000004', NULL, NOW(), NOW(), 1, 900);

SET FOREIGN_KEY_CHECKS = 1;
