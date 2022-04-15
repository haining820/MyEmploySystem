/*
 Navicat Premium Data Transfer

 Source Server         : MySQL5.7
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3307
 Source Schema         : employsys

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 30/06/2021 16:14:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(10) NOT NULL AUTO_INCREMENT,
  `adminAccountNum` int(32) NOT NULL,
  `adminPwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `adminName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 666, '666', '于海洋');

-- ----------------------------
-- Table structure for comjob
-- ----------------------------
DROP TABLE IF EXISTS `comjob`;
CREATE TABLE `comjob`  (
  `comjobId` int(8) NOT NULL AUTO_INCREMENT,
  `jobId` int(8) NOT NULL,
  `comId` int(8) NOT NULL,
  `comjobIntro` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salary` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `workTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `workAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hireMaxNum` int(8) NOT NULL,
  `hiredNum` int(8) NOT NULL,
  `comjobCreateTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comjobId`) USING BTREE,
  INDEX `JobIdForeign`(`jobId`) USING BTREE,
  INDEX `ComIdForeign`(`comId`) USING BTREE,
  CONSTRAINT `ComIdForeign` FOREIGN KEY (`comId`) REFERENCES `company` (`comId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `JobIdForeign` FOREIGN KEY (`jobId`) REFERENCES `job` (`jobId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30018 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comjob
-- ----------------------------
INSERT INTO `comjob` VALUES (30001, 201, 10001, '岗位职责\r\n1、负责广告数据平台后台研发工作；\r\n2、支撑业务快速迭代，保证在线服务质量；\r\n3、负责在线系统稳定性优化，性能调优等工作；\r\n4、海量数据，分布式系统，系统在实时性和稳定性方面有很高要求；\r\n5、Java为开发语言；\r\n6、表现优异者有转正机会。\r\n岗位要求\r\n1、实习时间3个月以上，一周至少4天；\r\n2、良好的编程能力，扎实的数据结构和算法基础，热爱写代码和研究相关底层原理；\r\n3、ACMICPC，NOI/IOC, TopCoder等比赛获奖者优先考虑。\r\n\r\n熟悉任意一项有额外加分：\r\n1、 有机器学习工程实践相关经验；\r\n2、 有前端web开发经验。', '面议', '双休', '北京，上海', 25, 6, '2021-05-21 17:26:05');
INSERT INTO `comjob` VALUES (30002, 202, 10002, '岗位职责\r\n1、参与公司的后台研发工作；\r\n2、参与在线大流量高并发系统设计；\r\n3、持续优化系统，支撑业务快速发展。\r\n岗位要求\r\n1、本科及研究生在读生，能保证每周实习4天及以上；\r\n2、有扎实的数据结构和算法功底；\r\n3、熟悉C/C++/Java/Python/Golang中的至少一门语言；\r\n4、了解数据库相关知识和基础操作，至少熟练使用MySQL。', '1w~1.5w', '10:00~17:00', '北京，杭州', 12, 2, '2021-05-21 17:26:05');
INSERT INTO `comjob` VALUES (30003, 201, 10002, '岗位职责\r\n1、参与公司的后台研发工作；\r\n2、参与在线大流量高并发系统设计；\r\n3、持续优化系统，支撑业务快速发展。\r\n岗位要求\r\n1、本科及研究生在读生，能保证每周实习4天及以上；\r\n2、有扎实的数据结构和算法功底；\r\n3、熟悉C/C++/Java/Python/Golang中的至少一门语言；\r\n4、了解数据库相关知识和基础操作，至少熟练使用MySQL。', '面议', '双休', '杭州', 100, 6, '2021-05-21 17:26:05');
INSERT INTO `comjob` VALUES (30004, 205, 10006, '岗位职责\r\n研究装修自动化布局问题、及其工程实现\r\n装修领域图片搜索、NLP、搜索推荐等业务\r\n供应链、工程排期优化\r\n改进家具数据库的标签和评分系统\r\n\r\n岗位要求\r\n具有理工科本科及以上学历，计算机、电子、自动化、软件、数学等相关专业者加分；\r\n熟悉常用的机器学习方法，包括且不限于GBDT，深度神经网络，智能优化算法等；\r\n熟悉常用的数据结构和算法，有良好逻辑思维能力 ；\r\n具备扎实的工程能力，熟悉和掌握Python、Java或C/C++\r\n\r\n亮点：\r\n1. 有挑战的新领域、新问题\r\n2. 经验丰富的算法大牛指导\r\n3. 宽松向上的团队氛围\r\n\r\n工资福利：\r\n1.  外企风，不加班，10-7-5 （按个人意愿，可酌情周末带薪加班）\r\n2. 午餐餐补\r\n3. 有竞争力的薪酬\r\n\r\n公司简介：\r\ninDeco创立4年来，致力于用科技改变办公装修行业，在疫情下依然保持100%以上业务增速，并已于20年初完成C轮融资\r\n算法团队的负责人均毕业于清华、北航等名校，曾就职于阿里、滴滴、京东、Hulu等公司的核心算法团队', '面议', '大小周', '深圳', 10, 5, 'test');
INSERT INTO `comjob` VALUES (30005, 207, 10002, 'test', 'test', 'test', 'test', 100, 85, 'test');
INSERT INTO `comjob` VALUES (30006, 202, 10010, 'test', 'test', 'test', 'test', 65, 5, 'test');
INSERT INTO `comjob` VALUES (30007, 220, 10001, 'test', 'test', 'test', 'test', 98, 45, 'test');
INSERT INTO `comjob` VALUES (30008, 208, 10004, 'test', 'test', 'test', 'test', 25, 14, 'test');
INSERT INTO `comjob` VALUES (30009, 213, 10003, 'test', 'test', 'test', 'test', 500, 54, 'test');
INSERT INTO `comjob` VALUES (30010, 205, 10008, 'test', 'test', 'test', 'test', 545, 50, 'test');
INSERT INTO `comjob` VALUES (30011, 202, 10001, 'test', 'test', 'test', 'test', 20, 10, 'test');
INSERT INTO `comjob` VALUES (30012, 205, 10006, 'test', 'test', 'test', 'test', 44, 40, 'test');
INSERT INTO `comjob` VALUES (30013, 205, 10007, 'test', 'test', 'test', 'test', 70, 45, 'test');
INSERT INTO `comjob` VALUES (30014, 211, 10004, 'test', 'test', 'test', 'test', 14, 2, 'test');
INSERT INTO `comjob` VALUES (30015, 202, 10020, '666', 'test', 'test', 'test', 10, 2, 'test');
INSERT INTO `comjob` VALUES (30016, 205, 10008, 'test', 'test', 'test', 'test', 10, 1, 'test');
INSERT INTO `comjob` VALUES (30017, 208, 10028, 'test', 'test', 'test', 'test', 11, 3, 'test');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `comId` int(10) NOT NULL AUTO_INCREMENT,
  `comAccountNum` int(32) NOT NULL,
  `comPwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comUserName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comIntro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `comEmail` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comTel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comWeb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `comCreateTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10029 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (10001, 111111, '666', '小企鹅', '腾讯', '腾讯以技术丰富互联网用户的生活。通过通信及社交软件微信和 QQ 促进用户联系，并助其连接数字内容和生活服务，尽在弹指间。通过高效广告平台，协助品牌和市场营销者触达数以亿计的中国消费者。通过金融科技及企业服务，促进合作伙伴业务发展，助力实现数字化升级。我们大力投资于人才队伍和推动科技创新，积极参与互联网行业协同发展。腾讯于 1998 年11月在中国深圳成立，2004 年6月在香港联合交易所主板上市。666', '深圳市南山区海天二路33号腾讯滨海大厦', 'test@test.com', '123456', 'https://www.tencent.com/zh-cn', '2021-04-22 12:26:17');
INSERT INTO `company` VALUES (10002, 111112, '666', 'Alibaba', '阿里巴巴', '阿里巴巴集团控股有限公司（简称：阿里巴巴集团）是以曾担任英语教师的马云为首的18人于1999年在浙江省杭州市创立的公司。 阿里巴巴集团经营多项业务，另外也从关联公司的业务和服务中取得经营商业生态系统上的支援。业务和关联公司的业务包括：淘宝网、天猫、聚划算、全球速卖通、阿里巴巴国际交易市场、1688、阿里妈妈、阿里云、蚂蚁金服、菜鸟网络等。', '北京市海淀区知春路甲48号2号楼10A室', 'test@test.com', '95152', 'https://www.bytedance.com/zh', '2021-04-22 12:26:17');
INSERT INTO `company` VALUES (10003, 111113, '123', '小美', '美团', '美团的使命是“帮大家吃得更好，生活更好”。作中国领先的生活服务电子商务平台，公司拥有美团、大众点评、美团外卖等消费者熟知App，服务涵盖餐饮、外卖、生鲜零售、打车、共享单车、酒店旅游、电影、休闲娱乐等200多个品类，业务覆盖全国2800个县区市。', '北京市朝阳区望京东路4号恒基伟业大厦BC座', 'test@test.com', '010-57376600', 'https://campus.meituan.com/', '2021-04-22 12:26:17');
INSERT INTO `company` VALUES (10004, 111114, '123', '滴滴君', '滴滴', '滴滴出行是全球卓越的移动出行科技平台，在亚太、拉美、非洲和俄罗斯提供出租车召车、网约车、顺风车、公交、共享单车、共享电单车、代驾、汽车服务、配送、货运及物流、金融等多元化服务。', '北京市海淀区东北旺西路8号院35号楼5层501室', 'test@test.com', '400 0000 999', 'https://zhaopin.kuaishou.cn/', '2021-04-22 15:29:23');
INSERT INTO `company` VALUES (10005, 1111156, '123', '小度', '百度', '百度是拥有强大互联网基础的领先AI公司。百度愿景是：成为最懂用户，并能帮助人们成长的全球顶级高科技公司。', '北京市海淀区上地十街10号百度大厦', 'test@test.com', '(+86 10)5992 8888', 'https://talent.baidu.com/', '2021-04-22 15:38:22');
INSERT INTO `company` VALUES (10006, 111116, '123', '华为招聘', '华为', '华为的愿景与使命是把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界。', '中国广东省深圳市龙岗区坂田华为总部办公楼', 'test@test.com', '0755-22731198', 'https://career.huawei.com/', '2021-04-24 14:16:55');
INSERT INTO `company` VALUES (10007, 111117, '123', '字节招聘1', '字节跳动', '北京字节跳动科技有限公司，成立于2012年3月，是最早将人工智能应用于移动互联网场景的科技企业之一，是中国北京的一家信息科技公司，地址位于北京市海淀区知春路甲48号。公司以建设“全球创作与交流平台”为愿景。字节跳动的全球化布局始于2015年，“技术出海”是字节跳动全球化发展的核心战略，其旗下产品有今日头条，西瓜视频，抖音，火山小视频，皮皮虾，懂车帝，悟空问答等。', '北京市海淀区知春路甲48号', 'test@test.com', '400-601-0918', 'https://jobs.bytedance.com/', '2021-04-24 14:18:06');
INSERT INTO `company` VALUES (10008, 111118, '123', '字节招聘2', '字节跳动', '北京字节跳动科技有限公司，成立于2012年3月，是最早将人工智能应用于移动互联网场景的科技企业之一，是中国北京的一家信息科技公司，地址位于北京市海淀区知春路甲48号。公司以建设“全球创作与交流平台”为愿景。字节跳动的全球化布局始于2015年，“技术出海”是字节跳动全球化发展的核心战略，其旗下产品有今日头条，西瓜视频，抖音，火山小视频，皮皮虾，懂车帝，悟空问答等。', '北京市海淀区知春路甲48号', 'test@test.com', '400-601-0918', 'https://jobs.bytedance.com/', '2021-04-24 14:18:06');
INSERT INTO `company` VALUES (10010, 111120, '123', '字节招聘4', '字节跳动', '北京字节跳动科技有限公司，成立于2012年3月，是最早将人工智能应用于移动互联网场景的科技企业之一，是中国北京的一家信息科技公司，地址位于北京市海淀区知春路甲48号。公司以建设“全球创作与交流平台”为愿景。字节跳动的全球化布局始于2015年，“技术出海”是字节跳动全球化发展的核心战略，其旗下产品有今日头条，西瓜视频，抖音，火山小视频，皮皮虾，懂车帝，悟空问答等。', '北京市海淀区知春路甲48号', 'test@test.com', '400-601-0918', 'https://jobs.bytedance.com/', '2021-04-24 14:18:06');
INSERT INTO `company` VALUES (10012, 12134, '123', '字节招聘5', '字节跳动', '北京字节跳动科技有限公司，成立于2012年3月，是最早将人工智能应用于移动互联网场景的科技企业之一，是中国北京的一家信息科技公司，地址位于北京市海淀区知春路甲48号。公司以建设“全球创作与交流平台”为愿景。字节跳动的全球化布局始于2015年，“技术出海”是字节跳动全球化发展的核心战略，其旗下产品有今日头条，西瓜视频，抖音，火山小视频，皮皮虾，懂车帝，悟空问答等。', '北京市海淀区知春路甲48号', 'test@qq.com', '4006010918', 'https://jobs.bytedance.com/', '2021-04-24 14:20:08');
INSERT INTO `company` VALUES (10013, 111122, '123', '字节招聘6', '字节跳动', '北京字节跳动科技有限公司，成立于2012年3月，是最早将人工智能应用于移动互联网场景的科技企业之一，是中国北京的一家信息科技公司，地址位于北京市海淀区知春路甲48号。公司以建设“全球创作与交流平台”为愿景。字节跳动的全球化布局始于2015年，“技术出海”是字节跳动全球化发展的核心战略，其旗下产品有今日头条，西瓜视频，抖音，火山小视频，皮皮虾，懂车帝，悟空问答等。', '北京市海淀区知春路甲48号', 'test@test.com', '400-601-0918', 'https://jobs.bytedance.com/', '2021-04-24 14:20:08');
INSERT INTO `company` VALUES (10017, 111166, 'aaa77', '小T', '上汽通用', 'test test test test test test test test', '北京', '778899@163.com', '11151616', 'www.xabkx.com', '2021-04-27 20:18:37');
INSERT INTO `company` VALUES (10018, 1111888, '1234', '小c666', '科大讯飞', 'test test test test test test test test ', '合肥', 'test@163.com', '15615616', 'www.test.com', '2021-04-27 21:53:04');
INSERT INTO `company` VALUES (10020, 4324332, '55555', '搜狗招聘', '搜狗', 'test test test test test test test test ', '上海', 'test@test.com', '5785875', 'www.test.com', '2021-04-27 21:53:48');
INSERT INTO `company` VALUES (10021, 42432, '234234', '京东招聘', '京东', 'test test test test test test test test ', '北京', 'test@test.com', '57887858', 'www.test.com', '2021-04-27 21:54:12');
INSERT INTO `company` VALUES (10023, 111121, '3242342', 'test', 'test', 'test test test test test test test test ', 'test', 'test@test.com', '23432', 'www.test.com', '2021-04-27 21:56:44');
INSERT INTO `company` VALUES (10026, 123423, '132324', 'test', 'test', 'test test test test test test test test ', 'test', 'test6111@666.com', '123333', 'www.test.com', '2021-04-28 15:42:02');
INSERT INTO `company` VALUES (10028, 8883213, '232432', 'test', 'test', 'test test test test test test test test ', 'test', 'test@test.com', '2575785', 'www.test.com', '2021-05-21 17:26:05');

-- ----------------------------
-- Table structure for emjob
-- ----------------------------
DROP TABLE IF EXISTS `emjob`;
CREATE TABLE `emjob`  (
  `emjobId` int(8) NOT NULL AUTO_INCREMENT,
  `comjobId` int(8) NOT NULL,
  `emId` int(8) NOT NULL,
  `res` int(8) NOT NULL,
  `reply` int(8) NOT NULL,
  `emjobCreateTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emjobId`) USING BTREE,
  INDEX `comjobldForeign`(`comjobId`) USING BTREE,
  INDEX `emldForeign`(`emId`) USING BTREE,
  CONSTRAINT `comjobldForeign` FOREIGN KEY (`comjobId`) REFERENCES `comjob` (`comjobId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `emldForeign` FOREIGN KEY (`emId`) REFERENCES `employee` (`emId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40029 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emjob
-- ----------------------------
INSERT INTO `emjob` VALUES (40015, 30002, 50001, 1, 1, '2021-06-22 10:48:07');
INSERT INTO `emjob` VALUES (40016, 30003, 50001, 1, 1, '2021-06-22 10:48:26');
INSERT INTO `emjob` VALUES (40017, 30010, 50001, 0, 1, '2021-06-22 10:49:12');
INSERT INTO `emjob` VALUES (40018, 30001, 50002, 0, 0, '2021-06-22 11:01:02');
INSERT INTO `emjob` VALUES (40019, 30004, 50002, 0, 0, '2021-06-22 11:01:11');
INSERT INTO `emjob` VALUES (40020, 30002, 50002, 1, 1, '2021-06-22 11:01:17');
INSERT INTO `emjob` VALUES (40021, 30001, 50001, 1, 1, '2021-06-22 11:31:53');
INSERT INTO `emjob` VALUES (40023, 30003, 50025, 0, 0, '2021-06-24 13:08:53');
INSERT INTO `emjob` VALUES (40024, 30001, 50025, 1, 1, '2021-06-24 13:09:05');
INSERT INTO `emjob` VALUES (40025, 30002, 50025, 0, 0, '2021-06-24 13:09:12');
INSERT INTO `emjob` VALUES (40026, 30004, 50025, 0, 0, '2021-06-24 13:09:20');
INSERT INTO `emjob` VALUES (40027, 30004, 50001, 0, 0, '2021-06-26 18:09:50');
INSERT INTO `emjob` VALUES (40028, 30003, 50026, 1, 1, '2021-06-26 18:32:31');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emId` int(10) NOT NULL AUTO_INCREMENT,
  `emAccountNum` int(32) NOT NULL,
  `emPwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emUsername` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emSex` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emBirth` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emSchool` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emIntro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emEmail` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emTel` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emGraduateTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emCreateTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emFile` varchar(225) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50027 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (50001, 111, '666', '爱学习的小张', '张三', '女', '2000-12-20', '中国地质大学（武汉）', '两只老虎爱跳舞，小兔子乖乖拔萝卜，我和小鸭子学走路，童年是最美的礼物。', 'zhangsan@qq.com', '15912341234', '2022-9', '2021-04-22 12:26:17', 'f3b36384-046b-46be-b737-753eac17c45e_张三简历.pdf');
INSERT INTO `employee` VALUES (50002, 222, '666', '小李子', '李四', '男', '1995-08-6', '武汉大学', '两只老虎爱跳舞，小兔子乖乖拔萝卜', 'lisi@163.com', '15922222222', '2023-9', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50003, 111113, '414414', '刘玄德', '刘备', '女', '2000-9-4', '四川大学', '我是刘备', 'liubei@qq.com', '19648889555', '2021-7', '2021-04-22 12:26:17', NULL);
INSERT INTO `employee` VALUES (50006, 14666, '12666', '关云长', '关羽', '男', '1988-9-8', '中南大学', 'test', 'test@163.com', '15987455555', '2021-8', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50007, 228954, '12', '诸葛孔明', '诸葛亮', '男', '1996-12-8', '吉林大学', 'test', 'test@163.com', '14899995584', '2022-9', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50009, 489566, '12', '曹孟德', '曹操', '女', '1998-9-6', '北京大学', 'test', 'test@163.com', '15998774566', '2022-9', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50011, 1661633, '12', '花开富贵', '王五', '男', '2002-10-17', '吉林大学', 'test', 'test@163.com', '14888556666', '2022-7', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50012, 1516156, '12', '心想事成', '赵六', '女', '2005-9-3', '哈尔滨工业大学', 'test', 'test@163.com', '14898889999', '2023-9', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50013, 1651322, '12', '梦想成真', '陈七', '男', '2001-10-3', '武汉理工大学', 'test', 'test@sdasa.sad', '14559999557', '2022-10', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50014, 1516156, '12', '奥力给', '李老八', '男', '2000-9-17', '武汉理工大学', 'test1', 'test@163.com', '13698774568', '2022-9', '2021-04-22 12:26:17', '');
INSERT INTO `employee` VALUES (50016, 5153213, '999', '黑旋风', '李逵', '女', '1988-9-01', '武汉理工大学', '我和小鸭子学走路', 'likui@163.com', '13999998888', '2022-9', '2021-05-05 11:41:29', NULL);
INSERT INTO `employee` VALUES (50017, 156156, '2', '赵子龙', '赵云', '女', '2000-7-30', '四川大学', '这是test的自我介绍dede', 'test@qq.com', '15455987456', '2022-9', '2021-05-07 10:56:58', NULL);
INSERT INTO `employee` VALUES (50018, 1232131321, 'qwewq', 'Gambit', '董思邈', '男', '2001-3-9', '华中师范大学', 'testtesttesttesttesttesttesttest', 'test@qq.com', '15499996548', '2022-9', '2021-05-21 12:55:37', NULL);
INSERT INTO `employee` VALUES (50019, 132123, '213123', '汝忆', '赵硕', '男', '1999-9-8', '华中科技大学', 'testtesttest', 'test@test.test', '15146589954', '2024-8', '2021-05-31 20:32:51', NULL);
INSERT INTO `employee` VALUES (50020, 6868668, '3243234', 'DJ路', '赵宇思辰', '男', '32003-9-26', '哈尔滨工程大学', 'werwer', 'test@163.com', '15955469999', '2030-7', '2021-05-31 20:42:30', NULL);
INSERT INTO `employee` VALUES (50021, 32131321, 'dds', '水波不行', '张伟健', '男', '1996-9-8', '大连理工大学', 'testtest', 'testtest@testtest.testtest', '13789885489', '2021-8', '2021-05-31 21:00:11', NULL);
INSERT INTO `employee` VALUES (50022, 1151651, '111', 'astronauts', '刘康', '男', '2002-9-25', '西安航空学院', 'mytestmytest', 'mytest@qq.com', '13996548885', '2020-9', '2021-05-31 21:02:31', NULL);
INSERT INTO `employee` VALUES (50023, 88888888, '1234', 'Alexios', '杨钊', '男', '1999-9-9', '北京大学', '我是杨钊，于海宁是我好大哥！', 'yangzhao@163.com', '13698745655', '2021-6', '2021-06-03 19:13:00', NULL);
INSERT INTO `employee` VALUES (50025, 777, '777', 'dududu', '于海宁', '男', '2000-9-17', '中国地质大学', '本人性格开朗、稳重、有活力，待人热情、真诚；工作认真负责，积极主动，能吃苦耐劳，用于承受压力，勇于创新；有很强的组织能力和团队协作精神，具有较强的适应能力；纪律性强，工作积极配合；意志坚强，具有较强的无私奉献精神。666', 'hn0820@qq.com', '15927494456', '2021-8', '2021-06-24 12:57:40', 'abb38d28-2f37-4954-8283-60b91597b77e_Java后端开发_于海宁简历.pdf');
INSERT INTO `employee` VALUES (50026, 9696, '123', '嘟嘟嘟123', '张伟', '男', '2001-9-25', '中国地质大学（武汉）', '我是张伟', 'zhangwei@qq.com', '13912341234', '2021-10', '2021-06-26 18:27:36', 'f1c88bc8-33df-4beb-814a-992aba0dd0ba_张伟简历.pdf');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `jobId` int(8) NOT NULL AUTO_INCREMENT,
  `jobtypeId` int(8) NOT NULL,
  `jobName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jobCreateTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jobId`) USING BTREE,
  INDEX `jobForeign`(`jobtypeId`) USING BTREE,
  CONSTRAINT `jobForeign` FOREIGN KEY (`jobtypeId`) REFERENCES `jobtype` (`jobtypeId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 221 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (201, 101, 'Java后端开发', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (202, 101, '前端开发', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (203, 101, '测试开发', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (204, 102, '产品经理666', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (205, 102, '会计师', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (206, 102, '统计员', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (207, 102, '财务分析员', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (208, 102, '财务总监', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (211, 106, '通下水', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (212, 102, '财务助理', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (213, 103, '证券经理', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (215, 106, '开锁修锁换锁芯', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (216, 105, '换纱窗', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (217, 105, '销售经理', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (218, 101, '算法开发', '2021-05-31 15:59:58');
INSERT INTO `job` VALUES (220, 101, '架构师', '2021-05-31 15:59:58');

-- ----------------------------
-- Table structure for jobtype
-- ----------------------------
DROP TABLE IF EXISTS `jobtype`;
CREATE TABLE `jobtype`  (
  `jobtypeId` int(8) NOT NULL AUTO_INCREMENT,
  `jobtypeName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jobtypeCreateTime` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jobtypeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobtype
-- ----------------------------
INSERT INTO `jobtype` VALUES (101, '计算机/网络/通信', '2021-05-31 15:59:58');
INSERT INTO `jobtype` VALUES (102, '财务/审计/统计', '2021-05-31 15:59:58');
INSERT INTO `jobtype` VALUES (103, '金融/银行/证券/投资', '2021-05-31 15:59:58');
INSERT INTO `jobtype` VALUES (104, '广告/设计/咨询', '2021-05-31 15:59:58');
INSERT INTO `jobtype` VALUES (105, '市场营销/公关媒介', '2021-05-31 15:59:58');
INSERT INTO `jobtype` VALUES (106, '建筑/房产/装修/物业', '2021-05-31 15:59:58');

SET FOREIGN_KEY_CHECKS = 1;
