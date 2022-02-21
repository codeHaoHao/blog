/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50642
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50642
File Encoding         : 65001

Date: 2020-03-19 10:15:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `author` varchar(40) CHARACTER SET utf8 DEFAULT '程序员小浩',
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `content` text CHARACTER SET utf8,
  `create_date` bigint(20) DEFAULT NULL,
  `update_date` bigint(20) DEFAULT NULL,
  `likes` int(11) DEFAULT '0',
  `readings` int(11) DEFAULT '0',
  `sort` int(11) DEFAULT '5',
  `status` int(11) DEFAULT '0' COMMENT '0 禁用 1 正常',
  `summary` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

Create table if not exists website(
	id int(11) primary key not null auto_increment,
	title varchar(100) not null,
	logo varchar(100) not null,
	keywords text,
	description text,
	copyright text
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('19', '0', '程序员小浩', '小心踩雷，一次Java内存泄漏排查实战', null, '<p><img alt=\"\" src=\"http://localhost:8080/showImage.html?fileName=829730fcb52943edb2ddff8d572e00af.png\" style=\"height:355px; width:679px\" /></p>\r\n', '1583650746618', '1583650746618', '0', '2324', '5', '1', '个人博客，用来做什么？我刚开始就把它当做一个我吐槽心情的地方，也就相当于一个网络记事本，写上一些关于自己生活工作中的小情小事，也会放上一些照片，音乐。每天工作回家后就能访问自己的网站，一边听着音乐，一边写写文章。');
INSERT INTO `article` VALUES ('20', '0', '程序员小浩', '通过反射机制实现一个完美的策略模式', null, '<p>通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式</p>\r\n', '1583655389643', '1583655389643', '0', '243', '5', '1', '通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式');
INSERT INTO `article` VALUES ('21', '0', '程序员小浩', '通过反射机制实现一个完美的策略模式', null, '<p>通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式</p>\r\n', '1583655465285', '1583655465285', '0', '565', '5', '1', '通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式通过反射机制实现一个完美的策略模式');
INSERT INTO `article` VALUES ('22', '0', '程序员小浩', '小心踩雷，一次Java内存泄漏排查实战', null, '<p>小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战</p>\r\n', '1583655719165', '1583655719165', '0', '76', '5', '1', '小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战');
INSERT INTO `article` VALUES ('23', '0', '程序员小浩', '小心踩雷，一次Java内存泄漏排查实战', null, '<p>小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战</p>\r\n', '1583655741300', '1583655741300', '0', '0', '5', '1', '小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战');
INSERT INTO `article` VALUES ('24', '0', '程序员小浩', '小心踩雷，一次Java内存泄漏排查实战', null, '<p>小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战</p>\r\n', '1583655928679', '1583655928679', '0', '0', '5', '1', '小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战小心踩雷，一次Java内存泄漏排查实战');
INSERT INTO `article` VALUES ('26', '0', '程序员小浩', '小心踩雷，一次Java内存泄漏排查实战', null, '<p>sfsfsfsfs</p>\r\n', '1584178704137', '1584178704137', '0', '0', '5', '1', 'sfsfsfsfs');
INSERT INTO `article` VALUES ('27', '0', '程序员小浩', 'Git分支命名规范', null, '<table align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\">\r\n	<tbody>\r\n		<tr>\r\n			<td>分支</td>\r\n			<td>命名</td>\r\n			<td>说明</td>\r\n		</tr>\r\n		<tr>\r\n			<td>主分支</td>\r\n			<td>master</td>\r\n			<td>主分支，所有提供给用户使用的正式版本，都在这个主分支上发布</td>\r\n		</tr>\r\n		<tr>\r\n			<td>开发主分支&nbsp;</td>\r\n			<td>dev</td>\r\n			<td>开发分支，永远是功能最新最全的分支</td>\r\n		</tr>\r\n		<tr>\r\n			<td>功能分支</td>\r\n			<td>feature-*</td>\r\n			<td>新功能分支，某个功能点正在开发阶段</td>\r\n		</tr>\r\n		<tr>\r\n			<td>发布版本</td>\r\n			<td>release-*</td>\r\n			<td>发布定期要上线的功能</td>\r\n		</tr>\r\n		<tr>\r\n			<td>修复发布版本分支</td>\r\n			<td>bugfix-release-*</td>\r\n			<td>修复测试bug</td>\r\n		</tr>\r\n		<tr>\r\n			<td>紧急修复分支</td>\r\n			<td>bugfix-master-*</td>\r\n			<td>\r\n			<p>紧急修复线上代码的 bug</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2>主分支 Master</h2>\r\n\r\n<p>代码库应该有一个、且仅有一个主分支。所有提供给用户使用的正式版本，都在这个主分支上发布。</p>\r\n\r\n<p>主分支必须是可用的、稳定的、可直接发布的版本，不能直接在主分支上开发。</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2>开发主分支Dev</h2>\r\n\r\n<p>Master主分支只用来发布重大版本，日常开发应该在另一个分支上完成，我们把开发用的分支，叫做Dev。</p>\r\n\r\n<p>这个分支可以用来生成代码的最新隔夜版本（nightly）。</p>\r\n\r\n<p>如果想正式对外发布，就在Master分支上对Dev分支进行合并（merge）。</p>\r\n\r\n<p>Dev分支代码永远是最新的，所有新功能以这个分支来创建自己的开发分支，该分支只做合并操作，不能直接在该分支上开发。</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2>功能分支Feature</h2>\r\n\r\n<p>功能分支的名字，可以采用feature-*的形式命名，以自己开发的功能命名。</p>\r\n\r\n<p>功能分支是分配开发不同的功能用的，从Dev创建功能分支，然后完成相应功能开发后合并回Dev分支并删除该功能分支</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2>预发布分支Release</h2>\r\n\r\n<p>预发布分支名字，可以采用release-*的形式命名</p>\r\n\r\n<p>预发布分支是指发布正式版本之前（即合并到Master分支之前），我们可能需要有一个预发布的版本进行测试。</p>\r\n\r\n<p>预发布分支是从Dev分支上分出来的，预发布结束之后（即测试没有问题之后），必须合并进Dev和Master。</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2><strong>修复预发布分支Release-bug</strong></h2>\r\n\r\n<p>修复预发布分支的bug，可以采用release-bug-*的形式命名</p>\r\n\r\n<p>在预发布版本测试出现bug时，从release分支创建分支进行bug修复，bug修复完成后在合并会release分支</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2>紧急修补分支Bug</h2>\r\n\r\n<p>修补分支的名字，可以采用bugfix-master-*的形式。</p>\r\n\r\n<p>该分支是为了紧急修复线上的bug。</p>\r\n\r\n<p>软件正式发布之后，难免会出现bug。这时就需要创建一个分支，进行bug修补。</p>\r\n\r\n<p>修补bug分支是从Master分支上面分出来的。修补结束之后，再合并进Master和Dev分支。</p>\r\n\r\n<p><strong>尽量避免线上问题的出现</strong></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>注：一个分支尽量开发一个功能模块，不要多个功能模块在一个分支上开发</p>\r\n\r\n<p>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; feature分支申请合并之前，最好先pull一下dev分支下来，看一下有没有冲突，如果有冲突就先解决冲突后再合并回dev</p>\r\n\r\n<p>&nbsp;</p>\r\n', '1584258709566', '1584258709566', '0', '0', '5', '1', 'Git分支命名规范');

-- ----------------------------
-- Table structure for article_tags
-- ----------------------------
DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `tags_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_tags
-- ----------------------------
INSERT INTO `article_tags` VALUES ('7', '4', '1');
INSERT INTO `article_tags` VALUES ('8', '1', '1');
INSERT INTO `article_tags` VALUES ('9', '1', '1');
INSERT INTO `article_tags` VALUES ('10', '1', '1');
INSERT INTO `article_tags` VALUES ('11', '1', '1');
INSERT INTO `article_tags` VALUES ('12', '1', '1');
INSERT INTO `article_tags` VALUES ('13', '1', '1');
INSERT INTO `article_tags` VALUES ('14', '1', '1');
INSERT INTO `article_tags` VALUES ('15', '1', '1');
INSERT INTO `article_tags` VALUES ('16', '1', '1');
INSERT INTO `article_tags` VALUES ('17', '1', '1');
INSERT INTO `article_tags` VALUES ('18', '1', '1');
INSERT INTO `article_tags` VALUES ('19', '1', '1');
INSERT INTO `article_tags` VALUES ('20', '1', '1');
INSERT INTO `article_tags` VALUES ('21', '1', '1');
INSERT INTO `article_tags` VALUES ('22', '1', '1');
INSERT INTO `article_tags` VALUES ('23', '1', '1');
INSERT INTO `article_tags` VALUES ('24', '1', '1');
INSERT INTO `article_tags` VALUES ('25', '1', '1');
INSERT INTO `article_tags` VALUES ('26', '1', '1');
INSERT INTO `article_tags` VALUES ('27', '1', '1');
INSERT INTO `article_tags` VALUES ('28', '25', '1');
INSERT INTO `article_tags` VALUES ('29', '26', '1');
INSERT INTO `article_tags` VALUES ('30', '26', '2');
INSERT INTO `article_tags` VALUES ('60', '19', '1');
INSERT INTO `article_tags` VALUES ('61', '19', '2');
INSERT INTO `article_tags` VALUES ('64', '27', '1');
INSERT INTO `article_tags` VALUES ('65', '27', '1');

-- ----------------------------
-- Table structure for frend_link
-- ----------------------------
DROP TABLE IF EXISTS `frend_link`;
CREATE TABLE `frend_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of frend_link
-- ----------------------------
INSERT INTO `frend_link` VALUES ('5', '程序员小浩ddfsfs', 'jdbc:h2:file:C:/Users/Administrator/Desktop/localData/.h2/postgres', '1584174381143');

-- ----------------------------
-- Table structure for leave_message
-- ----------------------------
DROP TABLE IF EXISTS `leave_message`;
CREATE TABLE `leave_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `wechat` varchar(30) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `visitor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of leave_message
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `statistics_category` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  `date` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_statistics_category` (`statistics_category`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of statistics
-- ----------------------------
INSERT INTO `statistics` VALUES ('1', '1', 'Total Views', '0', '1582992000000');
INSERT INTO `statistics` VALUES ('2', '2', 'Total Article', '0', '1582992000000');
INSERT INTO `statistics` VALUES ('3', '3', 'Total Message', '0', '1582992000000');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `weight` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES ('1', 'java', '0');
INSERT INTO `tags` VALUES ('2', 'haha', '0');
INSERT INTO `tags` VALUES ('3', 'sfsfs', '0');
INSERT INTO `tags` VALUES ('4', 'html', '0');
INSERT INTO `tags` VALUES ('5', 'mysql', '0');
INSERT INTO `tags` VALUES ('6', 'spring', '0');
INSERT INTO `tags` VALUES ('7', 'springboot', '0');
INSERT INTO `tags` VALUES ('8', 'redis', '0');
INSERT INTO `tags` VALUES ('9', '算法', '0');
INSERT INTO `tags` VALUES ('10', 'tata', '0');
INSERT INTO `tags` VALUES ('11', 'git', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `profession` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `introduction` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wechat` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` bigint(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `recentlyLanded` bigint(255) DEFAULT NULL,
  `aboutMe` text CHARACTER SET utf8,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0', '15138931676@163.com', 'edc8364288e2290c7885e704ede2e4ca', 'Frank | 李佳浩', 'java开发工程师', '96后程序猿一枚！19年入行。一直潜心研究java后端开发，一边工作一边积累经验，分享一些个人博客观点，以及一些生活日常等。sfsf', 'lijiahao88866', null, '/showImage.html?fileName=769d7efb04f2463c964eace1c5727b7c.jpg', null, '15138931676@163.com', null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(30) DEFAULT NULL,
  `visit_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_visit_time` (`visit_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of visitor
-- ----------------------------

-- ----------------------------
-- Table structure for visitor_url
-- ----------------------------
DROP TABLE IF EXISTS `visitor_url`;
CREATE TABLE `visitor_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` int(11) NOT NULL,
  `url_path` varchar(255) DEFAULT NULL,
  `visitor_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_visitor_id` (`visitor_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of visitor_url
-- ----------------------------
