# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table artworks (
  artid                     bigint auto_increment not null,
  uid                       bigint,
  file_path                 varchar(255),
  title                     varchar(255),
  votes                     integer,
  constraint pk_artworks primary key (artid))
;

create table comments (
  comment_id                bigint auto_increment not null,
  uid                       bigint,
  artid                     bigint,
  content                   varchar(255),
  constraint pk_comments primary key (comment_id))
;

create table users (
  uid                       bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  votes                     integer,
  constraint pk_users primary key (uid))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table artworks;

drop table comments;

drop table users;

SET FOREIGN_KEY_CHECKS=1;

