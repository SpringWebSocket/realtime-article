/*
Navicat PGSQL Data Transfer

Source Server         : Localhost
Source Server Version : 90303
Source Host           : localhost:5432
Source Database       : dbArticleRealtime
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90303
File Encoding         : 65001

Date: 2016-11-22 22:35:10
*/


-- ----------------------------
-- Sequence structure for tbarticle_id_seq
-- ----------------------------
DROP SEQUENCE "tbarticle_id_seq";
CREATE SEQUENCE "tbarticle_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 53
 CACHE 1;
SELECT setval('"public"."tbarticle_id_seq"', 53, true);

-- ----------------------------
-- Sequence structure for tbcategory_id_seq
-- ----------------------------
DROP SEQUENCE "tbcategory_id_seq";
CREATE SEQUENCE "tbcategory_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."tbcategory_id_seq"', 1, true);

-- ----------------------------
-- Sequence structure for tbuser_id_seq
-- ----------------------------
DROP SEQUENCE "tbuser_id_seq";
CREATE SEQUENCE "tbuser_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
SELECT setval('"public"."tbuser_id_seq"', 1, true);

-- ----------------------------
-- Table structure for tbarticle
-- ----------------------------
DROP TABLE IF EXISTS "tbarticle";
CREATE TABLE "tbarticle" (
"id" int4 NOT NULL,
"title" varchar(300) COLLATE "default",
"description" text COLLATE "default",
"content" text COLLATE "default",
"thumbnail" text COLLATE "default",
"category_id" int4,
"user_id" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbarticle
-- ----------------------------
BEGIN;
INSERT INTO "tbarticle" VALUES ('52', 'test', 'test', 'TEST', 'thumb.jpg', '1', '1');
INSERT INTO "tbarticle" VALUES ('53', 'test', 'test', 'TEST', 'thumb.jpg', '1', '1');
COMMIT;

-- ----------------------------
-- Table structure for tbcategory
-- ----------------------------
DROP TABLE IF EXISTS "tbcategory";
CREATE TABLE "tbcategory" (
"id" int4 DEFAULT nextval('tbcategory_id_seq'::regclass) NOT NULL,
"name" varchar(30) COLLATE "default",
"icon" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbcategory
-- ----------------------------
BEGIN;
INSERT INTO "tbcategory" VALUES ('1', 'Technology', 'Technology');
COMMIT;

-- ----------------------------
-- Table structure for tbimage
-- ----------------------------
DROP TABLE IF EXISTS "tbimage";
CREATE TABLE "tbimage" (
"article_id" int4,
"image" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbimage
-- ----------------------------
BEGIN;
INSERT INTO "tbimage" VALUES ('52', '1.jpg');
INSERT INTO "tbimage" VALUES ('52', '2.jpg');
INSERT INTO "tbimage" VALUES ('52', '3.jpg');
INSERT INTO "tbimage" VALUES ('53', '1.jpg');
INSERT INTO "tbimage" VALUES ('53', '2.jpg');
INSERT INTO "tbimage" VALUES ('53', '3.jpg');
COMMIT;

-- ----------------------------
-- Table structure for tbuser
-- ----------------------------
DROP TABLE IF EXISTS "tbuser";
CREATE TABLE "tbuser" (
"id" int4 DEFAULT nextval('tbuser_id_seq'::regclass) NOT NULL,
"name" varchar(30) COLLATE "default",
"gender" varchar(10) COLLATE "default",
"image" text COLLATE "default",
"role" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbuser
-- ----------------------------
BEGIN;
INSERT INTO "tbuser" VALUES ('1', 'phearun', 'male', 'https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAihAAAAJGUwYjY5NWRiLWFjNTctNDI4OC04NmYxLWZlMGIwNzI4MjA1Mw.jpg', 'admin');
COMMIT;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "tbarticle_id_seq" OWNED BY "tbarticle"."id";
ALTER SEQUENCE "tbcategory_id_seq" OWNED BY "tbcategory"."id";
ALTER SEQUENCE "tbuser_id_seq" OWNED BY "tbuser"."id";

-- ----------------------------
-- Primary Key structure for table tbarticle
-- ----------------------------
ALTER TABLE "tbarticle" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tbcategory
-- ----------------------------
ALTER TABLE "tbcategory" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tbuser
-- ----------------------------
ALTER TABLE "tbuser" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "tbarticle"
-- ----------------------------
ALTER TABLE "tbarticle" ADD FOREIGN KEY ("category_id") REFERENCES "tbuser" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "tbarticle" ADD FOREIGN KEY ("user_id") REFERENCES "tbcategory" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "tbimage"
-- ----------------------------
ALTER TABLE "tbimage" ADD FOREIGN KEY ("article_id") REFERENCES "tbarticle" ("id") ON DELETE CASCADE ON UPDATE CASCADE;
