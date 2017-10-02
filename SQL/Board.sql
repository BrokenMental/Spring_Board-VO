create table board(
  bno int AUTO_INCREMENT,
  title varchar(100),
  contents varchar(2000),
  root int DEFAULT 0,
  pno int DEFAULT 0,
  cno int DEFAULT 0,
  depth int DEFAULT 0,
  lvl int DEFAULT 1,
  id varchar(30),
  today DATETIME DEFAULT current_timestamp(),
  hit int DEFAULT 0,
  PRIMARY KEY (bno)
);