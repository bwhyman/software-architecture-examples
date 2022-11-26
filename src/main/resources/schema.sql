/*
 用户表，一对多地址表
 登录密码应加密编码后存储
 */
create table if not exists `user`
(
    id int primary key auto_increment,
    account varchar(11) not null ,
    password varchar(40) not null ,
    role int not null ,

    unique (account)
);
/*
 地址表，一对一用户表
 用户表主键未设为外键，添加索引用于检索
 */
create table if not exists `address`
(
    id int primary key auto_increment,
    detail varchar(40) not null,
    user_id int not null ,

    index (user_id)
);