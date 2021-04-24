/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : acs

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/04/2021 15:07:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exam_classes
-- ----------------------------
DROP TABLE IF EXISTS `exam_classes`;
CREATE TABLE `exam_classes`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exam_id` int NOT NULL COMMENT '考试id',
  `classes_id` int NOT NULL COMMENT '班级id',
  `release_date` datetime(0) NOT NULL COMMENT '发布时间',
  `start_date` datetime(0) NOT NULL COMMENT '开始时间',
  `deadline` datetime(0) NOT NULL COMMENT '结束时间',
  `publish_answer` int(10) UNSIGNED ZEROFILL NULL DEFAULT 0000000000 COMMENT '是否公布答案   0:不公布   1:公布答案',
  `publish_score` int(10) UNSIGNED ZEROFILL NULL DEFAULT 0000000000 COMMENT '是否公布分数   0:不公布   1:公布',
  `status` int NULL DEFAULT 0 COMMENT '状态 0:待批改 1:批改完成',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `exam_id`(`exam_id`) USING BTREE,
  INDEX `classes_id`(`classes_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for exam_topic
-- ----------------------------
DROP TABLE IF EXISTS `exam_topic`;
CREATE TABLE `exam_topic`  (
  `exam_id` int NOT NULL,
  `topic_id` int NOT NULL,
  PRIMARY KEY (`exam_id`, `topic_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int NOT NULL,
  `menu_id` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_classes
-- ----------------------------
DROP TABLE IF EXISTS `t_classes`;
CREATE TABLE `t_classes`  (
  `classes_id` int NOT NULL AUTO_INCREMENT,
  `classes_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_id` int NULL DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `people_num` int NULL DEFAULT NULL,
  PRIMARY KEY (`classes_id`) USING BTREE,
  INDEX `teacher_id`(`creator_id`) USING BTREE,
  CONSTRAINT `t_classes_ibfk_1` FOREIGN KEY (`creator_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_exam
-- ----------------------------
DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam`  (
  `exam_id` int NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `exam_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '试卷名称',
  `creator_id` int NOT NULL COMMENT '创建者id',
  `time` int UNSIGNED NULL DEFAULT NULL COMMENT '答题时间(分钟)',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `topic_num` int UNSIGNED NULL DEFAULT 0 COMMENT '题目数量',
  `total_score` float UNSIGNED NULL DEFAULT 0 COMMENT '总分',
  `pass_mark` float UNSIGNED NULL DEFAULT 0 COMMENT '及格分数',
  `permit_copy` int UNSIGNED NULL DEFAULT 1 COMMENT '是否允许复制  0:不允许  1:允许(默认)',
  `disrupt_order` int UNSIGNED NULL DEFAULT 0 COMMENT '是否打乱题目顺序 0:不打乱(默认) 1:打乱顺序',
  `repeat_test` int UNSIGNED NULL DEFAULT 1 COMMENT '允许考生考试次数 默认1',
  `auto_mack` int UNSIGNED NULL DEFAULT 1 COMMENT '是否自动评分 0:否   1:是(默认)',
  `required` int NULL DEFAULT 0 COMMENT '0: 非必填   1:必填',
  PRIMARY KEY (`exam_id`) USING BTREE,
  INDEX `creator_id`(`creator_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `parent_id` int NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `is_frame` int NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic`  (
  `topic_id` int NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目',
  `choice` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `topic_type` int NOT NULL COMMENT '题目类型  0:单选题 1:多选题 2:判断题 3:填空题 4:简答题',
  `correct_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '正确答案',
  `score` float NULL DEFAULT 0 COMMENT '分数',
  `difficulty` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '中等' COMMENT '难度  简单,中等(默认),困难',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案分析',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_classes
-- ----------------------------
DROP TABLE IF EXISTS `user_classes`;
CREATE TABLE `user_classes`  (
  `user_id` int NOT NULL,
  `classes_id` int NOT NULL,
  PRIMARY KEY (`user_id`, `classes_id`) USING BTREE,
  INDEX `classes_id`(`classes_id`) USING BTREE,
  CONSTRAINT `user_classes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_classes_ibfk_2` FOREIGN KEY (`classes_id`) REFERENCES `t_classes` (`classes_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_grade
-- ----------------------------
DROP TABLE IF EXISTS `user_grade`;
CREATE TABLE `user_grade`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NOT NULL COMMENT '用户id',
  `classes_id` int NOT NULL COMMENT '班级id',
  `exam_id` int NOT NULL COMMENT '考试id',
  `grade` double NULL DEFAULT NULL COMMENT '得分',
  `grade_auto` double NULL DEFAULT NULL COMMENT '得分(自动评分)',
  `answer_date` datetime(0) NULL DEFAULT NULL COMMENT '答题日期',
  `answer_time` int NULL DEFAULT NULL COMMENT '答题时长',
  `mark_status` int NULL DEFAULT 0 COMMENT '批改状态 0:待批改 1:批改完成',
  `exam_status` int NULL DEFAULT 0 COMMENT '试卷状态 0:未完成  1:已完成',
  `mark_date` datetime(0) NULL DEFAULT NULL COMMENT '批改日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `classes_id`(`classes_id`) USING BTREE,
  INDEX `exam_id`(`exam_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  INDEX `role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for user_topic
-- ----------------------------
DROP TABLE IF EXISTS `user_topic`;
CREATE TABLE `user_topic`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `classes_id` int NULL DEFAULT NULL COMMENT '班级id',
  `exam_id` int NULL DEFAULT NULL COMMENT '试卷id',
  `topic_id` int NULL DEFAULT NULL COMMENT '题目id',
  `user_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户答案',
  `user_score` double NULL DEFAULT NULL COMMENT '用户得分',
  `topic_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0:待批改 1:批改完成',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `classes_id`(`classes_id`) USING BTREE,
  INDEX `exam_id`(`exam_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 377 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
