/*
 Navicat Premium Data Transfer

 Source Server         : dingdan
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : studyabroadhelp

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 04/04/2024 04:18:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for applyfor
-- ----------------------------
DROP TABLE IF EXISTS `applyfor`;
CREATE TABLE `applyfor`  (
  `applyforid` int(11) NOT NULL AUTO_INCREMENT COMMENT '申请id',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `institutionId` int(11) NULL DEFAULT NULL COMMENT '院校id',
  `schedule` int(2) NULL DEFAULT NULL COMMENT '进度',
  PRIMARY KEY (`applyforid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of applyfor
-- ----------------------------
INSERT INTO `applyfor` VALUES (1, 1711962408710, 1, 3);
INSERT INTO `applyfor` VALUES (2, 1711962408710, 4, 2);
INSERT INTO `applyfor` VALUES (3, 1711962408710, 8, 3);
INSERT INTO `applyfor` VALUES (4, 1712050600142, 10, 4);
INSERT INTO `applyfor` VALUES (5, 1712052024658, 5, 1);

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `adminid` bigint(20) NULL DEFAULT NULL COMMENT '管理员id',
  `ask` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '提问',
  `reply` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复',
  `isreply` int(11) NULL DEFAULT NULL COMMENT '是否回复',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1712108159624 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '在线客服' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of chat
-- ----------------------------

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `collectId` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `institutionId` int(11) NULL DEFAULT NULL COMMENT '院校id',
  `userId` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `collectFlag` int(1) NULL DEFAULT NULL COMMENT '是否收藏',
  PRIMARY KEY (`collectId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, 1, 1711962408710, 1);
INSERT INTO `collect` VALUES (2, 3, 1711962408710, 1);
INSERT INTO `collect` VALUES (3, 6, 1712050600142, 1);
INSERT INTO `collect` VALUES (4, 8, 1711962408710, 1);
INSERT INTO `collect` VALUES (5, 2, 1711962408710, 1);

-- ----------------------------
-- Table structure for collegemajor
-- ----------------------------
DROP TABLE IF EXISTS `collegemajor`;
CREATE TABLE `collegemajor`  (
  `collegeMajor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '院校专业',
  `institutionId` int(11) NOT NULL COMMENT '院校Id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collegemajor
-- ----------------------------
INSERT INTO `collegemajor` VALUES ('Computer Science', 10);
INSERT INTO `collegemajor` VALUES ('Computer Science', 6);
INSERT INTO `collegemajor` VALUES ('Computer Science', 1);
INSERT INTO `collegemajor` VALUES ('Computer Science', 2);
INSERT INTO `collegemajor` VALUES ('Computer Science', 3);
INSERT INTO `collegemajor` VALUES ('Computer Science', 5);
INSERT INTO `collegemajor` VALUES ('Computer Science', 7);
INSERT INTO `collegemajor` VALUES ('Computer Science', 4);
INSERT INTO `collegemajor` VALUES ('Computer Science', 8);
INSERT INTO `collegemajor` VALUES ('Computer Science', 9);
INSERT INTO `collegemajor` VALUES ('Computer Science', 11);
INSERT INTO `collegemajor` VALUES ('Computer Science', 12);
INSERT INTO `collegemajor` VALUES ('Computer Science', 13);
INSERT INTO `collegemajor` VALUES ('Computer Science', 14);
INSERT INTO `collegemajor` VALUES ('Computer Science', 15);
INSERT INTO `collegemajor` VALUES ('Computer Science', 16);
INSERT INTO `collegemajor` VALUES ('Computer Science', 17);
INSERT INTO `collegemajor` VALUES ('Computer Science', 18);
INSERT INTO `collegemajor` VALUES ('Computer Science', 19);
INSERT INTO `collegemajor` VALUES ('Computer Science', 20);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 1);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 2);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 3);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 4);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 5);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 6);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 7);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 8);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 9);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 10);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 21);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 22);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 23);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 24);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 25);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 26);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 26);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 27);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 28);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 29);
INSERT INTO `collegemajor` VALUES ('Accounting & Finance', 30);
INSERT INTO `collegemajor` VALUES ('Mathematics', 11);
INSERT INTO `collegemajor` VALUES ('Mathematics', 12);
INSERT INTO `collegemajor` VALUES ('Mathematics', 13);
INSERT INTO `collegemajor` VALUES ('Mathematics', 14);
INSERT INTO `collegemajor` VALUES ('Mathematics', 15);
INSERT INTO `collegemajor` VALUES ('Mathematics', 16);
INSERT INTO `collegemajor` VALUES ('Mathematics', 17);
INSERT INTO `collegemajor` VALUES ('Mathematics', 18);
INSERT INTO `collegemajor` VALUES ('Mathematics', 19);
INSERT INTO `collegemajor` VALUES ('Mathematics', 20);
INSERT INTO `collegemajor` VALUES ('Mathematics', 21);
INSERT INTO `collegemajor` VALUES ('Mathematics', 22);
INSERT INTO `collegemajor` VALUES ('Mathematics', 23);
INSERT INTO `collegemajor` VALUES ('Mathematics', 24);
INSERT INTO `collegemajor` VALUES ('Mathematics', 25);
INSERT INTO `collegemajor` VALUES ('Mathematics', 26);
INSERT INTO `collegemajor` VALUES ('Mathematics', 27);
INSERT INTO `collegemajor` VALUES ('Mathematics', 28);
INSERT INTO `collegemajor` VALUES ('Mathematics', 29);
INSERT INTO `collegemajor` VALUES ('Mathematics', 30);

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, 'picture1', 'upload/1712156974777.jpg');
INSERT INTO `config` VALUES (2, 'picture2', 'upload/1712156987174.jpg');
INSERT INTO `config` VALUES (3, 'picture3', 'upload/1712156997853.png');

-- ----------------------------
-- Table structure for counseloruser
-- ----------------------------
DROP TABLE IF EXISTS `counseloruser`;
CREATE TABLE `counseloruser`  (
  `counseloruserid` int(11) NOT NULL AUTO_INCREMENT COMMENT '顾问用户表id',
  `counselorid` bigint(20) NULL DEFAULT NULL COMMENT '顾问Id',
  `userid` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`counseloruserid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of counseloruser
-- ----------------------------
INSERT INTO `counseloruser` VALUES (1, 1711962408711, 1711962408710);
INSERT INTO `counseloruser` VALUES (2, 1712051235733, 1712050600142);
INSERT INTO `counseloruser` VALUES (3, 1711962408711, 1712052024658);

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '帖子内容',
  `parentid` bigint(20) NULL DEFAULT NULL COMMENT '父节点id',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `avatarurl` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `isdone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1712052067768 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '论坛交流' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES (1711989306326, '2024-04-02 00:35:05', 'Which university has the best computer science major', '<p>Hello everyone, I am a college student who loves learning very much. I would like to know which university has the best computer science major. I will refer to it for reference. Thank you all</p>', 0, 1711962408710, 'zhangsan', NULL, 'Open');
INSERT INTO `forum` VALUES (1711990752033, '2024-04-02 00:59:11', NULL, 'Is there anyone kind-hearted to tell me.', 1711989306326, 1711962408710, 'zhangsan', 'upload/1711962403567.jpg', NULL);
INSERT INTO `forum` VALUES (1712052067767, '2024-04-02 18:01:07', NULL, 'Stanford seems to be very good', 1711989306326, 1712052024658, 'xiaosong', 'upload/1712052022957.jpg', NULL);

-- ----------------------------
-- Table structure for institution
-- ----------------------------
DROP TABLE IF EXISTS `institution`;
CREATE TABLE `institution`  (
  `institutionId` int(11) NOT NULL AUTO_INCREMENT COMMENT '院校Id',
  `institutionRanking` int(11) NULL DEFAULT NULL COMMENT '院校排名',
  `institutionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校名称',
  `institutionPicture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校头像地址',
  `institutionUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校官网地址',
  `institutionAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '院校地址',
  PRIMARY KEY (`institutionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of institution
-- ----------------------------
INSERT INTO `institution` VALUES (1, 1, 'Massachusetts Institute of Technology (MIT)', 'https://www.qschina.cn/sites/default/files/massachusetts-institute-of-technology-mit_410_small.jpg', 'https://web.mit.edu/', '');
INSERT INTO `institution` VALUES (2, 2, 'University of Cambridge', 'https://www.qschina.cn/sites/default/files/university-of-cambridge_95_small.jpg', 'https://www.cam.ac.uk/', '');
INSERT INTO `institution` VALUES (3, 3, 'University of Oxford', '	https://www.qschina.cn/sites/default/files/university-of-oxford_478_small.jpg', 'https://www.ox.ac.uk/', '');
INSERT INTO `institution` VALUES (4, 4, 'Harvard University', 'https://www.qschina.cn/sites/default/files/harvard-university_253_small.jpg', 'https://www.harvard.edu/', '');
INSERT INTO `institution` VALUES (5, 5, 'Stanford University', '	https://www.qschina.cn/sites/default/files/stanford-university_573_small.jpg', 'https://www.stanford.edu/', '');
INSERT INTO `institution` VALUES (6, 6, 'Imperial College London', 'https://www.qschina.cn/sites/default/files/imperial-college-london_592560cf2aeae70239af4be8_small.jpg', 'https://www.imperial.ac.uk/', '');
INSERT INTO `institution` VALUES (7, 7, 'ETH Zurich – Swiss Federal Institute of Technology', 'https://www.qschina.cn/sites/default/files/eth-zurich-swiss-federal-institute-of-technology_201_small.jpg', 'https://ethz.ch/en.html', '');
INSERT INTO `institution` VALUES (8, 8, 'National University of Singapore (NUS)', 'https://www.qschina.cn/sites/default/files/national-university-of-singapore-nus_443_small.jpg', 'https://nus.edu.sg/', '');
INSERT INTO `institution` VALUES (9, 9, 'University College London (UCL)', 'https://www.qschina.cn/sites/default/files/ucl_592560cf2aeae70239af4bf1_small.jpg', 'https://www.ucl.ac.uk/', '');
INSERT INTO `institution` VALUES (10, 10, 'University of California, Berkeley (UCB)', 'https://www.qschina.cn/sites/default/files/university-of-california-berkeley-ucb_84_small.jpg', 'https://www.berkeley.edu/', '');
INSERT INTO `institution` VALUES (11, 11, 'University of Chicago', 'https://www.qschina.cn/sites/default/files/university-of-chicago_120_small.jpg', 'https://www.uchicago.edu/', NULL);
INSERT INTO `institution` VALUES (12, 12, 'University of Pennsylvania', 'https://www.qschina.cn/sites/default/files/university-of-pennsylvania_495_small.jpg', 'https://www.upenn.edu/', NULL);
INSERT INTO `institution` VALUES (13, 13, 'Cornell University', 'https://www.qschina.cn/sites/default/files/cornell-university_143_small.jpg', 'https://www.cornell.edu/', NULL);
INSERT INTO `institution` VALUES (14, 14, 'The University of Melbourne', 'https://www.qschina.cn/sites/default/files/the-university-of-melbourne_399_small.jpg', 'https://www.unimelb.edu.au/', NULL);
INSERT INTO `institution` VALUES (15, 15, 'California Institute of Technology (Caltech)', 'https://www.qschina.cn/sites/default/files/california-institute-of-technology-caltech_94_small.jpg', 'https://www.caltech.edu/', NULL);
INSERT INTO `institution` VALUES (16, 16, 'Yale University', 'https://www.qschina.cn/sites/default/files/yale-university_684_small.jpg', 'https://www.yale.edu/', NULL);
INSERT INTO `institution` VALUES (17, 17, 'Peking University', '	https://www.qschina.cn/sites/default/files/peking-university_50_small.jpg', 'https://www.pku.edu.cn/', NULL);
INSERT INTO `institution` VALUES (18, 18, 'Princeton University', 'https://www.qschina.cn/sites/default/files/princeton-university_508_small.jpg', 'https://www.princeton.edu/', NULL);
INSERT INTO `institution` VALUES (19, 19, 'The University of New South Wales (UNSW Sydney)', 'https://www.qschina.cn/sites/default/files/the-university-of-new-south-wales-unsw-sydney_447_small.jpg', 'https://www.unsw.edu.au/', NULL);
INSERT INTO `institution` VALUES (20, 20, 'The University of Sydney', 'https://www.qschina.cn/sites/default/files/the-university-of-sydney_592560cf2aeae70239af4cd0_small.jpg', 'https://www.sydney.edu.au/', NULL);
INSERT INTO `institution` VALUES (21, 21, 'University of Toronto', 'https://www.qschina.cn/sites/default/files/university-of-toronto_619_small.jpg', 'https://www.utoronto.ca/', NULL);
INSERT INTO `institution` VALUES (22, 22, 'The University of Edinburgh', 'https://www.qschina.cn/sites/default/files/the-university-of-edinburgh_180_small.jpg', 'https://www.ed.ac.uk/', NULL);
INSERT INTO `institution` VALUES (23, 23, 'Columbia University', 'https://www.qschina.cn/sites/default/files/columbia-university_138_small.jpg', 'https://www.columbia.edu/', NULL);
INSERT INTO `institution` VALUES (24, 24, 'University of Michigan', 'https://www.qschina.cn/sites/default/files/university-of-michigan_403_small.jpg', 'https://umich.edu/', NULL);
INSERT INTO `institution` VALUES (25, 25, 'Tsinghua University', '	https://www.qschina.cn/sites/default/files/tsinghua-university_626_small.jpg', 'https://www.tsinghua.edu.cn/en/', NULL);
INSERT INTO `institution` VALUES (26, 26, 'Nanyang Technological University, Singapore (NTU Singapore)', 'https://www.qschina.cn/sites/default/files/nanyang-technological-university-singapore-ntu_592560cf2aeae70239af4c32_small.jpg', 'https://www.ntu.edu.sg/', NULL);
INSERT INTO `institution` VALUES (27, 27, 'The University of Hong Kong', '	https://www.qschina.cn/sites/default/files/the-university-of-hong-kong_268_small.jpg', 'https://www.hku.hk/', NULL);
INSERT INTO `institution` VALUES (28, 28, 'Johns Hopkins University', '	https://www.qschina.cn/sites/default/files/johns-hopkins-university_305_small.jpg', 'https://www.jhu.edu/', NULL);
INSERT INTO `institution` VALUES (29, 29, 'The University of Tokyo', 'https://www.qschina.cn/sites/default/files/the-university-of-tokyo_615_small.jpg', 'https://www.u-tokyo.ac.jp/en/', NULL);
INSERT INTO `institution` VALUES (30, 30, 'University of California, Los Angeles (UCLA)', 'https://www.qschina.cn/sites/default/files/university-of-california-los-angeles-ucla_87_small.jpg', 'https://www.ucla.edu/', NULL);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `introduction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1672050808172 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '网站公告' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (82, '2022-12-26 18:29:39', 'System upgrade', 'The system is about to upgrade, please stay tuned!', 'upload/news_picture2.jpg', '<p>This system will be maintained and upgraded at 10pm sharp. Please save your data to avoid any inconvenience</p>');

-- ----------------------------
-- Table structure for relevantinformation
-- ----------------------------
DROP TABLE IF EXISTS `relevantinformation`;
CREATE TABLE `relevantinformation`  (
  `relevantInformationId` int(11) NOT NULL AUTO_INCREMENT COMMENT '相关信息Id',
  `relevantInformationPicture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关信息图片',
  `relevantInformationTitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关信息标题',
  `relevantInformationContent` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关信息内容',
  `releaseTime` datetime NULL DEFAULT NULL COMMENT '相关信息发布时间',
  PRIMARY KEY (`relevantInformationId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of relevantinformation
-- ----------------------------
INSERT INTO `relevantinformation` VALUES (1, 'https://proxyimg.sucai999.com/preimg/123D82/700/123D82/100/5a9c4050e147459a4ce31fa0c06fa82c.jpg', 'Scholarship related notices', 'This is about scholarship information', '2024-04-02 10:15:27');
INSERT INTO `relevantinformation` VALUES (2, 'https://www.qschina.cn/sites/default/files/university-of-oxford_478_small.jpg', 'Visa information related notices', 'This is the latest information about visas', '2024-04-02 10:15:30');

-- ----------------------------
-- Table structure for storeup
-- ----------------------------
DROP TABLE IF EXISTS `storeup`;
CREATE TABLE `storeup`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `refid` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `tablename` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片',
  `type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '类型(1:收藏,21:赞,22:踩,31:竞拍参与,41:关注)',
  `inteltype` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐类型',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1712112472677 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of storeup
-- ----------------------------
INSERT INTO `storeup` VALUES (1712112464505, '2024-04-03 10:47:44', 1711962408710, 28, 'shiwuzhaoling', 'title8', 'upload/shiwuzhaoling_wupintupian8.jpg', '1', NULL, NULL);
INSERT INTO `storeup` VALUES (1712112472676, '2024-04-03 10:47:52', 1711962408710, 28, 'shiwuzhaoling', 'title8', 'upload/shiwuzhaoling_wupintupian8.jpg', '1', NULL, NULL);

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'admin', 'users', 'Administrator', 'ilgdfrpfv7ogsvgmshkykgs3zxecl4f7', '2022-12-26 18:30:56', '2024-04-04 05:12:02');
INSERT INTO `token` VALUES (5, 1711962408710, 'zhangsan', 'yonghu', 'user', 'q0vkwl83jhi75dzux2dnbc0hlqrw5bl7', '2024-04-01 17:54:02', '2024-04-04 05:18:14');
INSERT INTO `token` VALUES (6, 1711962408711, 'wanger', 'yonghu', 'user', '82p8g94r1s30t5u7uyq4qs1cyw02gchh', '2024-04-02 11:45:17', '2024-04-04 05:01:20');
INSERT INTO `token` VALUES (7, 1712050659489, 'xiaomei', 'yonghu', 'user', 'tuz25tgdedf2o0zdkeencwh78lt34f7n', '2024-04-02 17:52:56', '2024-04-02 20:30:46');
INSERT INTO `token` VALUES (8, 1712051895560, 'xiaohuang', 'yonghu', 'user', '43g5nch8u172g9ezgm9p1mb6yx77t6xr', '2024-04-02 17:58:40', '2024-04-02 18:58:41');
INSERT INTO `token` VALUES (9, 1712052024658, 'xiaosong', 'yonghu', 'user', '4oe37tgcssnoupg7bgpx8e05uqqaya6s', '2024-04-02 18:00:36', '2024-04-03 04:45:32');
INSERT INTO `token` VALUES (10, 1712050600142, 'lisi', 'yonghu', 'user', 'o3b6k4e8w9gkfld75drhycxn59fzqo1d', '2024-04-02 23:47:38', '2024-04-03 14:31:11');
INSERT INTO `token` VALUES (11, 1711962408711, 'wanger', 'guwen', 'Counselor', 'apf8ycbffbo0diltavl2nvqjbkhcrwjw', '2024-04-03 00:50:17', '2024-04-04 05:13:54');
INSERT INTO `token` VALUES (12, 1712051235733, 'xiaozhang', 'guwen', 'Counselor', 'bfpbw9gy5ymgkztts3ml3davu5t45gzu', '2024-04-03 03:47:29', '2024-04-03 04:47:30');
INSERT INTO `token` VALUES (13, 1712110867046, 'xiaoliang', 'yonghu', 'user', '93hqu41y3obhvywbb7ckcolylgdtq1el', '2024-04-03 10:21:39', '2024-04-03 11:21:40');
INSERT INTO `token` VALUES (14, 1711962408711, 'wanger', 'yonghu', 'user', '9241jbltc82gu4f1c9tomdpfwwn5mk54', '2024-04-04 00:15:44', '2024-04-04 01:15:45');
INSERT INTO `token` VALUES (15, 1711962408710, 'zhangsan', 'yonghu', 'user', '2vdgbv5jaem3v9upy70re0z865smhjgx', '2024-04-04 00:15:54', '2024-04-04 03:52:56');
INSERT INTO `token` VALUES (16, 1711962408711, 'wanger', 'guwen', 'Counselor', 'vfzdygalx1mufitu9ots5t3hfuw5brhm', '2024-04-04 00:16:10', '2024-04-04 02:13:28');
INSERT INTO `token` VALUES (17, 1, 'admin', 'users', 'Administrator', '86zrssf10iu92qz9yyz2bppdkcuetqqx', '2024-04-04 01:15:26', '2024-04-04 02:15:27');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123456', 'Administrator', '2022-12-26 18:29:39');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `zhanghao` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `mima` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `xingming` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `nianling` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `xingbie` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `shouji` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `touxiang` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `undergraduateinstitution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本科院校',
  `divideequally` int(11) NULL DEFAULT NULL COMMENT '均分',
  `ieltsscore` int(11) NULL DEFAULT NULL COMMENT '雅思成绩',
  `sfsh` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '审核回复',
  `counselor` int(1) NULL DEFAULT 1 COMMENT '是否为顾问',
  `counselorinstitution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '顾客机构',
  `workingyears` int(2) NULL DEFAULT NULL COMMENT '工作年限',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `zhanghao`(`zhanghao`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1712110867047 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (1711962408710, '2024-04-01 17:06:48', 'zhangsan', '123456', 'zhangsan', 22, 'male', '18888888888', 'upload/1711962403567.jpg', '123456@qq.com', 'Xi\'an University of Electronic Science and Technology', 95, 310, 'yes', '', 1, NULL, NULL);
INSERT INTO `yonghu` VALUES (1711962408711, '2024-04-02 11:43:53', 'wanger', '123456', 'wanger', 23, 'male', '19999999999', 'upload/1672050719413.jpg', '123456@qq.com', NULL, NULL, NULL, 'yes', NULL, 0, 'XX study abroad institution', 3);
INSERT INTO `yonghu` VALUES (1712050600142, '2024-04-02 17:36:40', 'lisi', '123456', 'lisi', 25, 'male', '17777777777', 'upload/1712050598437.jpg', '123456@qq.com', 'Xi\'an Engineering University', 96, 315, 'yes', NULL, 1, NULL, NULL);
INSERT INTO `yonghu` VALUES (1712050659489, '2024-04-02 17:37:39', 'xiaomei', '123456', 'xiaomei', 18, 'female', '16666666666', 'upload/1712050651557.jpg', '111@qq.com', NULL, NULL, NULL, 'yes', NULL, 0, 'XX study abroad institution', 2);
INSERT INTO `yonghu` VALUES (1712050911554, '2024-04-02 17:41:51', 'xiaoli', '123456', 'xiaoli', 19, 'female', '15555555555', 'upload/1712050909706.jpg', '123456@qq.com', NULL, NULL, NULL, 'yes', NULL, 0, 'XX study abroad institution', 3);
INSERT INTO `yonghu` VALUES (1712051235733, '2024-04-02 17:47:15', 'xiaozhang', '123456', 'xiaozhang', 23, 'male', '14444444444', 'upload/1712051233667.jpg', '123456@qq.com', NULL, NULL, NULL, 'yes', NULL, 0, 'XX study abroad institution', 5);
INSERT INTO `yonghu` VALUES (1712051895560, '2024-04-02 17:58:15', 'xiaohuang', '123456', 'xiaohuang', 26, 'male', '13333333333', 'upload/1712051869314.jpg', '6666667@qq.com', NULL, NULL, NULL, 'yes', NULL, 0, 'XX study abroad institution', 1);
INSERT INTO `yonghu` VALUES (1712052024658, '2024-04-02 18:00:24', 'xiaosong', '123456', 'xiaosong', 27, 'male', '12222222222', 'upload/1712052022957.jpg', '4444@qq.com', 'Northwestern Polytechnical University', 97, 320, 'yes', NULL, 1, NULL, NULL);
INSERT INTO `yonghu` VALUES (1712110867046, '2024-04-03 10:21:07', 'xiaoliang', '123456', 'xiaoliang', 19, 'female', '11111111111', 'upload/1712110860073.jpg', '123@qq.com', 'Shaanxi University of Science and Technology', 98, 325, 'yes', NULL, 1, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
