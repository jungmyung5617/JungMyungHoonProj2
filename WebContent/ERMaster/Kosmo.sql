
/* Drop Tables */

DROP TABLE BBS CASCADE CONSTRAINTS;
DROP TABLE MEMBER CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE BBS
(
	no number NOT NULL,
	id nvarchar2(15) NOT NULL,
	title nvarchar2(50) NOT NULL,
	content nvarchar2(2000) NOT NULL,
	visitcount number,
	postdate date DEFAULT SYSDATE,
	PRIMARY KEY (no)
);


CREATE TABLE MEMBER
(
	id nvarchar2(15) NOT NULL,
	pwd nvarchar2(15) NOT NULL,
	name nvarchar2(10) NOT NULL,
	age number NOT NULL,
	address nvarchar2(100) NOT NULL,
	email nvarchar2(30) NOT NULL,
	phonenumber number NOT NULL,
	gender nvarchar2(10) NOT NULL,
	grade nvarchar2(10) NOT NULL,
	postdate date DEFAULT SYSDATE,
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE BBS
	ADD FOREIGN KEY (id)
	REFERENCES MEMBER (id)
;



