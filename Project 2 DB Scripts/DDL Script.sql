--DDL


--Users
CREATE table users (
u_id INT PRIMARY KEY,
f_name VARCHAR2(50) NOT NULL ,
l_name VARCHAR2(50) NOT NULL,
username VARCHAR2(50) UNIQUE NOT NULL,
password VARCHAR2(20) NOT NULL,
pos_id INT NOT NULL,
FOREIGN KEY (pos_id) references position (pos_id)
);

--page

CREATE TABLE page (
page_id INT  PRIMARY KEY,
comment_id INT,
u_id INT NOT NULL,
pic_id INT NOT NULL,
summary CLOB NOT NULL,
body CLOB NOT NULL,
tag_id INT NOT NULL,
page_status_id INT NOT NULL,
timesubmission TIMESTAMP,
FOREIGN KEY (comment_id) references comment(comment_id),
FOREIGN KEY (u_id) references users(u_id),
FOREIGN KEY (pic_id) references picture(pic_id),
Foreign Key (page_status_id) references page_status(page_status_id)
);


-- COMMENT

CREATE TABLE comment (
comment_id INT PRIMARY KEY,
u_id INT NOT NULL,
timesubmission TIMESTAMP,
page_id INT NOT NULL,
content VARCHAR2 (4000) NOT NULL,
comment_status_id NOT NULL,
FOREIGN KEY (u_id) references users(u_id),
FOREIGN KEY (page_id) references page(page_id),
FOREIGN KEY (comment_status_id) references comment_status(comment_status_id)
);


--PROFILE

CREATE TABLE profile(
profile_id INT PRIMARY KEY,
u_id INT NOT NULL,
FOREIGN KEY (u_id) references users(u_id)
);


--POSITION

CREATE TABLE position(
pos_id INT PRIMARY KEY,
pos_type VARCHAR2(100) NOT NULL
);

--COMMENT STATUS
CREATE TABLE comment_status (
comment_status_id INT PRIMARY KEY,
comment_status_name VARCHAR2(100) NOT NULL
);


--PAGE STATUS
CREATE TABLE page_status (
page_status_id INT PRIMARY KEY,
page_status_name VARCHAR2(100) NOT NULL
);

--TAG

CREATE TABLE tag (
tag_id INT PRIMARY KEY,
tag_name VARCHAR2(100) NOT NULL
);


--PICS
CREATE TABLE picture (
pic_id INT PRIMARY KEY,
pic BLOB NOT NULL
);
































