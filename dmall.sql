CREATE TABLE `address` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`receiverAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`receiverName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`receiverGender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`receiverPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`uid` int(11) NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `uid` (`uid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `category` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `credit` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`uid` int(11) NULL DEFAULT NULL,
`pid` int(11) NULL DEFAULT NULL,
`score` int(11) NULL DEFAULT NULL,
`state` int(11) NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `favorite` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`uid` int(11) NULL DEFAULT NULL,
`pid` int(11) NULL DEFAULT NULL,
`time` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `uid` (`uid` ASC) USING BTREE,
INDEX `pid` (`pid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `helparticle` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`cid` int(11) NULL DEFAULT NULL,
`title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`content` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `helparticle_ibfk_1` (`cid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `helpcategory` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `img` (
`id` int(11) NOT NULL AUTO_INCREMENT,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `newspaper` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`content` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`cid` int(11) NULL DEFAULT NULL,
`uid` int(11) NULL DEFAULT NULL,
`count` int(11) NULL DEFAULT NULL,
`createTime` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `uid` (`uid` ASC) USING BTREE,
INDEX `cid` (`cid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `newspapercategory` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `orderitem` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`oid` int(11) NULL DEFAULT NULL,
`pid` int(11) NULL DEFAULT NULL,
`number` int(11) NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `oid` (`oid` ASC) USING BTREE,
INDEX `pid` (`pid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `orders` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`orderCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`uid` int(11) NULL DEFAULT NULL,
`aid` int(11) NULL DEFAULT NULL,
`money` double(11,2) NULL DEFAULT NULL,
`status` int(11) NULL DEFAULT NULL,
`createTime` datetime NULL DEFAULT NULL,
`payTime` datetime NULL DEFAULT NULL,
`deliveryTime` datetime NULL DEFAULT NULL,
`confirmTime` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `uid` (`uid` ASC) USING BTREE,
INDEX `aid` (`aid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `privilege` (
`id` int(11) NOT NULL,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `product` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`subTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`price` double(10,2) NULL DEFAULT NULL,
`promotePrice` double(10,2) NULL DEFAULT NULL,
`stock` int(11) NULL DEFAULT NULL,
`cid` int(11) NULL DEFAULT NULL,
`sid` int(11) NULL DEFAULT NULL,
`createTime` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `product_ibfk_1` (`cid` ASC) USING BTREE,
INDEX `product_ibfk_2` (`sid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `property` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`cid` int(11) NULL DEFAULT NULL,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `property_ibfk_1` (`cid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 22
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `propertyvalue` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`pid` int(11) NULL DEFAULT NULL,
`ptid` int(11) NULL DEFAULT NULL,
`value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `propertyvalue_ibfk_1` (`pid` ASC) USING BTREE,
INDEX `propertyvalue_ibfk_2` (`ptid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `review` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`uid` int(11) NULL DEFAULT NULL,
`pid` int(11) NULL DEFAULT NULL,
`createTime` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `uid` (`uid` ASC) USING BTREE,
INDEX `pid` (`pid` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `role` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `seller` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;

CREATE TABLE `user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`activeCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`role_id` int(11) NULL DEFAULT NULL,
`registTime` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) ,
INDEX `role_id` (`role_id` ASC) USING BTREE
)
ENGINE = InnoDB
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
ROW_FORMAT = Compact;


ALTER TABLE `address` ADD CONSTRAINT `address_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `favorite` ADD CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `favorite` ADD CONSTRAINT `favorite_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `helparticle` ADD CONSTRAINT `helparticle_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `newspapercategory` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE `newspaper` ADD CONSTRAINT `newspaper_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `newspaper` ADD CONSTRAINT `newspaper_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `newspapercategory` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `orderitem` ADD CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `orders` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `orderitem` ADD CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `orders` ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `orders` ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`aid`) REFERENCES `address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `product` ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `seller` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE `product` ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE `property` ADD CONSTRAINT `property_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE `propertyvalue` ADD CONSTRAINT `propertyvalue_ibfk_2` FOREIGN KEY (`ptid`) REFERENCES `property` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE `propertyvalue` ADD CONSTRAINT `propertyvalue_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT;
ALTER TABLE `review` ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `review` ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `user` ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

