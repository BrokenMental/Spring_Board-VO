create table reply(
  rno int AUTO_INCREMENT,
  bno int DEFAULT 0,
  replytext varchar(1000),
  replyer VARCHAR (50),
  regdate timestamp default now(),
  updatedate TIMESTAMP default now(),
  PRIMARY KEY (rno)
);

ALTER TABLE reply add CONSTRAINT fk_board
FOREIGN KEY (bno) REFERENCES setting(bno);