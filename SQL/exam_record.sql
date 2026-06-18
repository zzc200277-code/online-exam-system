CREATE DATABASE IF NOT EXISTS `exam_system` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `exam_system`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `exam_record`;
CREATE TABLE `exam_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `exam_name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `total_score` double DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `submit_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `exam_record` (`id`, `user_id`, `exam_name`, `subject`, `score`, `total_score`, `status`, `submit_time`, `remark`) VALUES
(1, 100, 'Java 基础在线测试', 'Java', 86, 100, '已提交', '2026-06-10 09:30:00', '基础掌握较好'),
(2, 100, 'Spring Boot 阶段考试', 'Spring Boot', 78, 100, '已提交', '2026-06-12 15:20:00', '控制器部分需加强'),
(3, 100, '数据库应用测试', 'MySQL', 92, 100, '已提交', '2026-06-15 10:10:00', '表现优秀'),
(4, 200, 'Java 基础在线测试', 'Java', 69, 100, '已提交', '2026-06-10 09:45:00', '语法基础需巩固'),
(5, 200, 'Spring Boot 阶段考试', 'Spring Boot', 81, 100, '已提交', '2026-06-12 15:35:00', '整体完成较好'),
(6, 300, '数据库应用测试', 'MySQL', 0, 100, '未提交', NULL, '缺考');

SET FOREIGN_KEY_CHECKS = 1;
