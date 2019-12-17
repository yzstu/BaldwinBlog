CREATE TABLE `yz_users` (

 `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',

 `user_ip` varchar(20) NOT NULL COMMENT '用户IP',

 `user_name` varchar(20) NOT NULL COMMENT '用户名',

 `user_password` varchar(15) NOT NULL COMMENT '用户密码',

 `user_email` varchar(30) NOT NULL COMMENT '用户邮箱',

 `user_profile_photo` varchar(255) NOT NULL COMMENT '用户头像',

 `user_registration_time` datetime DEFAULT NULL COMMENT '注册时间',

 `user_birthday` date DEFAULT NULL COMMENT '用户生日',

 `user_age` tinyint(4) DEFAULT NULL COMMENT '用户年龄',

 `user_telephone_number` int(11) NOT NULL COMMENT '用户手机号',

 `user_nickname` varchar(20) NOT NULL COMMENT '用户昵称',

 PRIMARY KEY (`user_id`),

 KEY `user_name` (`user_name`),

 KEY `user_nickname` (`user_nickname`),

 KEY `user_email` (`user_email`),

 KEY `user_telephone_number` (`user_telephone_number`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `yz_articles` (

 `article_id` bigint(255) NOT NULL AUTO_INCREMENT COMMENT '博文ID',

 `user_id` bigint(20) NOT NULL COMMENT '发表用户ID',

 `article_title` text NOT NULL COMMENT '博文标题',

 `article_content` longtext NOT NULL COMMENT '博文内容',

 `article_views` bigint(20) NOT NULL COMMENT '浏览量',

 `article_comment_count` bigint(20) NOT NULL COMMENT '评论总数',

 `article_date` datetime DEFAULT NULL COMMENT '发表时间',

 `article_like_count` bigint(20) NOT NULL,

 PRIMARY KEY (`article_id`),

 KEY `user_id` (`user_id`),

 CONSTRAINT `yz_articles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `yz_users` (`user_id`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `yz_comments` (

 `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',

 `user_id` bigint(20) NOT NULL COMMENT '发表用户ID',

 `article_id` bigint(20) NOT NULL COMMENT '评论博文ID',

 `comment_like_count` bigint(20) NOT NULL COMMENT '点赞数',

 `comment_date` datetime DEFAULT NULL COMMENT '评论日期',

 `comment_content` text NOT NULL COMMENT '评论内容',

 `parent_comment_id` bigint(20) NOT NULL COMMENT '父评论ID',

 PRIMARY KEY (`comment_id`),

 KEY `article_id` (`article_id`),

 KEY `comment_date` (`comment_date`),

 KEY `parent_comment_id` (`parent_comment_id`)

) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `yz_labels` (

 `label_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签ID',

 `label_name` varchar(20) NOT NULL COMMENT '标签名称',

 `label_alias` varchar(15) NOT NULL COMMENT '标签别名',

 `label_description` text NOT NULL COMMENT '标签描述',

 PRIMARY KEY (`label_id`),

 KEY `label_name` (`label_name`),

 KEY `label_alias` (`label_alias`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `yz_set_artitle_label` (

 `article_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章ID',

 `label_id` bigint(20) NOT NULL,

 PRIMARY KEY (`article_id`),

 KEY `label_id` (`label_id`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `yz_set_artitle_sort` (

 `article_id` bigint(20) NOT NULL COMMENT '文章ID',

 `sort_id` bigint(20) NOT NULL COMMENT '分类ID',

 PRIMARY KEY (`article_id`,`sort_id`),

 KEY `sort_id` (`sort_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yz_sorts` (

 `sort_id` bigint(20) NOT NULL COMMENT '分类ID',

 `sort_name` varchar(50) NOT NULL COMMENT '分类名称',

 `sort_alias` varchar(15) NOT NULL COMMENT '分类别名',

 `sort_description` text NOT NULL COMMENT '分类描述',

 `parent_sort_id` bigint(20) NOT NULL COMMENT '父分类ID',

 PRIMARY KEY (`sort_id`),

 KEY `sort_name` (`sort_name`),

 KEY `sort_alias` (`sort_alias`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yz_user_friends` (

 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识ID',

 `user_id` bigint(20) NOT NULL COMMENT '用户ID',

 `user_friends_id` bigint(20) NOT NULL COMMENT '好友ID',

 `user_note` varchar(20) NOT NULL COMMENT '好友备注',

 `user_status` varchar(20) NOT NULL COMMENT '好友状态',

 PRIMARY KEY (`id`),

 KEY `user_id` (`user_id`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
