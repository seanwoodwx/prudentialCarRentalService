SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL default '' comment 'name',
  `password` varchar(100) NOT NULL default '' comment 'pwd',
  `role` varchar(15) NOT NULL default '' comment 'role',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'alex', 'alex', 'admin');
INSERT INTO `user` VALUES ('2', 'user', 'user', 'user');
INSERT INTO `user` VALUES ('3', '1', '1', 'admin');
INSERT INTO `user` VALUES ('4', '2', '2', 'admin');
INSERT INTO `user` VALUES ('22', '3', '3', 'user');
INSERT INTO `user` VALUES ('25', '4', '4', 'user');


DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL default '' comment 'car name',
  `totalCount` int(10) NOT NULL default '0' comment 'company total car',
  `currentCount` int(10) NOT NULL default '0' comment 'role',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1', 'Toyota Camry', '2', '1');
INSERT INTO `car` VALUES ('2', 'BMW 650', '2', '2');




DROP TABLE IF EXISTS `user_car`;
CREATE TABLE `user_car` (
  `userId` int(10) NOT NULL default '0' comment 'user table primary key',
  `carId` int(10) NOT NULL default '0' comment 'car table primary key',
  `count` int(10)NOT NULL default '0' comment 'car count'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_car
-- ----------------------------
INSERT INTO `user_car` VALUES ('1', '1', '1');