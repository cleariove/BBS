CREATE TABLE `bbs`.`user`  (
  `userID` int(11) NOT NULL COMMENT '用户编号',
  `userName` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `age` int(8) NULL COMMENT '年龄',
  `gender` varchar(255) NULL COMMENT '性别',
  `birthDay` varchar(255) NULL COMMENT '出生日期',
  `power` int(8) NOT NULL DEFAULT 1 COMMENT '权限',
  `integral` int(8) NULL COMMENT '积分',
  PRIMARY KEY (`userID`)
);