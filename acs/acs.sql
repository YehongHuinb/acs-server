/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : acs

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 06/04/2021 16:57:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `classes_id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`classes_id`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE,
  CONSTRAINT `classes_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '软件工程课程设计', 50, 2);

-- ----------------------------
-- Table structure for exam_paper
-- ----------------------------
DROP TABLE IF EXISTS `exam_paper`;
CREATE TABLE `exam_paper`  (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT,
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NOT NULL COMMENT '老师id',
  `classes_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`paper_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `classes_id`(`classes_id`) USING BTREE,
  CONSTRAINT `exam_paper_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `exam_paper_ibfk_2` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`classes_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of exam_paper
-- ----------------------------
INSERT INTO `exam_paper` VALUES (1, '试卷示例1', '2021-04-06 13:45:54', 2, 1);

-- ----------------------------
-- Table structure for paper_question
-- ----------------------------
DROP TABLE IF EXISTS `paper_question`;
CREATE TABLE `paper_question`  (
  `paper_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `score` double NULL DEFAULT NULL,
  PRIMARY KEY (`paper_id`, `question_id`) USING BTREE,
  INDEX `question_id`(`question_id`) USING BTREE,
  CONSTRAINT `paper_question_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `exam_paper` (`paper_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_question_ibfk_2` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of paper_question
-- ----------------------------
INSERT INTO `paper_question` VALUES (1, 1, 5);
INSERT INTO `paper_question` VALUES (1, 2, 5);

-- ----------------------------
-- Table structure for paper_student
-- ----------------------------
DROP TABLE IF EXISTS `paper_student`;
CREATE TABLE `paper_student`  (
  `paper_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '学生id',
  `score` double NULL DEFAULT NULL,
  PRIMARY KEY (`paper_id`, `user_id`) USING BTREE,
  INDEX `paper_student_ibfk_2`(`user_id`) USING BTREE,
  CONSTRAINT `paper_student_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `exam_paper` (`paper_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `paper_student_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of paper_student
-- ----------------------------
INSERT INTO `paper_student` VALUES (1, 3, 10);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `describe` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `standard_ans` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category` int(255) NOT NULL,
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '1+1=?α1β2β3β4', '2', 1);
INSERT INTO `question` VALUES (2, '哪些是水果？α椅子β苹果β梨β易拉罐', '6', 2);
INSERT INTO `question` VALUES (3, '2的3次方为___，3的2次方为___。', '8δ9', 3);
INSERT INTO `question` VALUES (4, '请简单描述一下数列极限。', '如果一个数列无限接近于A，但永远超不过A，则A是此数列的极限。', 4);

-- ----------------------------
-- Table structure for question_student
-- ----------------------------
DROP TABLE IF EXISTS `question_student`;
CREATE TABLE `question_student`  (
  `question_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '学生id',
  `student_ans` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `student_score` int(255) NULL DEFAULT NULL COMMENT '学生该题得分',
  PRIMARY KEY (`question_id`, `user_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `question_student_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `question_student_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of question_student
-- ----------------------------
INSERT INTO `question_student` VALUES (1, 3, '2', 5);
INSERT INTO `question_student` VALUES (2, 3, '6', 5);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `rid` int(11) NOT NULL,
  `pid` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for student_classes
-- ----------------------------
DROP TABLE IF EXISTS `student_classes`;
CREATE TABLE `student_classes`  (
  `user_id` int(11) NOT NULL,
  `classes_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `classes_id`) USING BTREE,
  INDEX `classes_id`(`classes_id`) USING BTREE,
  CONSTRAINT `student_classes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_classes_ibfk_2` FOREIGN KEY (`classes_id`) REFERENCES `classes` (`classes_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_classes
-- ----------------------------
INSERT INTO `student_classes` VALUES (3, 1);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员');
INSERT INTO `t_role` VALUES (2, '教师');
INSERT INTO `t_role` VALUES (3, '学生');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nike_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '管理员', '123456', '111222', '男', NULL, NULL);
INSERT INTO `t_user` VALUES (2, 'teacher', '老师', '123456', '333444', '女', NULL, NULL);
INSERT INTO `t_user` VALUES (3, 'student', '学生', '123456', '555666', '男', NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  INDEX `role_id`(`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (2, 2);
INSERT INTO `user_role` VALUES (3, 3);

-- ----------------------------
-- View structure for classpaper
-- ----------------------------
DROP VIEW IF EXISTS `classpaper`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `classpaper` AS select `classes`.`classes_id` AS `class_id`,`classes`.`teacher_id` AS `teacher_id`,`exam_paper`.`paper_id` AS `paper_id` from (`classes` join `exam_paper`) where (`classes`.`teacher_id` = `exam_paper`.`user_id`);

-- ----------------------------
-- View structure for stuclass
-- ----------------------------
DROP VIEW IF EXISTS `stuclass`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `stuclass` AS select `student_classes`.`user_id` AS `stu_id`,`student_classes`.`classes_id` AS `class_id`,`classes`.`classes_name` AS `class_name`,`classes`.`number` AS `num_students`,(select `t_user`.`nike_name` from (`t_user` join `classes`) where (`classes`.`teacher_id` = `t_user`.`user_id`)) AS `teacher_name` from (`student_classes` join `classes`) where (`student_classes`.`classes_id` = `classes`.`classes_id`);

-- ----------------------------
-- View structure for stuexampaper
-- ----------------------------
DROP VIEW IF EXISTS `stuexampaper`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `stuexampaper` AS select `question`.`question_id` AS `q_id`,`paper_question`.`paper_id` AS `paper_id`,`paper_student`.`user_id` AS `stu_id`,`question`.`describe` AS `q_desc`,`question`.`standard_ans` AS `std_ans`,`question_student`.`student_ans` AS `stu_ans`,`paper_question`.`score` AS `q_score`,`question_student`.`student_score` AS `stu_score` from (((`question` join `paper_question`) join `paper_student`) join `question_student`) where ((`paper_question`.`question_id` = `question`.`question_id`) and (`paper_question`.`question_id` = `question_student`.`question_id`) and (`paper_student`.`paper_id` = `paper_question`.`paper_id`));

-- ----------------------------
-- View structure for teacherclass
-- ----------------------------
DROP VIEW IF EXISTS `teacherclass`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `teacherclass` AS select `classes`.`teacher_id` AS `teacher_id`,`classes`.`classes_id` AS `class_id`,`classes`.`classes_name` AS `class_name`,`classes`.`number` AS `num_students` from (`classes` join `t_user`) where (`classes`.`teacher_id` = `t_user`.`user_id`);

SET FOREIGN_KEY_CHECKS = 1;
