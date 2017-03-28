############################## Create Tables ##############################

#################### Post Table ####################
DROP TABLE post;

CREATE TABLE post (
	postNo      INT PRIMARY KEY AUTO_INCREMENT,
	postTitle   VARCHAR(200) NOT NULL,
	postText    TEXT         NULL,
	postWriter  VARCHAR(50)  NOT NULL,
	postRegDate TIMESTAMP       DEFAULT now(),
	postRevDate TIMESTAMP       DEFAULT now(),
	postViewCnt INT             DEFAULT 0
);

#################### Reply Table ####################
DROP TABLE reply;

CREATE TABLE reply (
	replyNo      INT PRIMARY KEY AUTO_INCREMENT,
	postNo       INT         NOT NULL,
	FOREIGN KEY (postNo) REFERENCES post (postNo),
	replyText    TEXT        NULL,
	replyWriter  VARCHAR(50) NOT NULL,
	replyRegDate TIMESTAMP       DEFAULT now(),
	replyRevDate TIMESTAMP       DEFAULT now()
);

#################### Member Table ####################
CREATE TABLE member (
	memberId       VARCHAR(50) PRIMARY KEY,
	memberPassword VARCHAR(50)  NOT NULL,
	memberEmail    VARCHAR(100) NOT NULL UNIQUE
);

############################## Test Queries ##############################

#################### Post Table ####################
INSERT INTO post (postTitle, postText, postWriter)
VALUES ('제목01', '내용01', '작성자01');

INSERT INTO post (postTitle, postText, postWriter)
VALUES ('제목02', '내용02', '작성자02');

INSERT INTO post (postTitle, postText, postWriter)
VALUES ('제목03', '내용03', '작성자03');

INSERT INTO post (postTitle, postText, postWriter)
	SELECT postTitle, postText, postWriter
	FROM post;

SELECT *
FROM post;

#################### Reply Table ####################
INSERT INTO reply (postNo, replyText, replyWriter)
VALUES (1, '댓글01', '작성자01');

INSERT INTO reply (postNo, replyText, replyWriter)
VALUES (1, '댓글02', '작성자02');

INSERT INTO reply (postNo, replyText, replyWriter)
VALUES (1, '댓글03', '작성자03');

INSERT INTO reply (postNo, replyText, replyWriter)
	SELECT postNo, replyText, replyWriter
	FROM reply;

SELECT *
FROM reply;

#################### Member Table ####################
INSERT INTO member (userId, userPassword, userEmail)
VALUES ("a", "a", "a@a.com");

INSERT INTO member (userId, userPassword, userEmail)
VALUES ("b", "b", "b@b.com");

INSERT INTO member (userId, userPassword, userEmail)
VALUES ("c", "c", "c@c.com");

SELECT *
FROM member;

############################## MyBatis Queries ##############################

#################### Post Table ####################
# getAllPostList
SELECT *
FROM post
ORDER BY postNo DESC
LIMIT ?, ?;

# countAllPosts
SELECT count(postNo)
FROM post;

# getSearchPostList
SELECT *
FROM post
WHERE postNo > 0 AND postTitle LIKE concat('%', ?, '%')
ORDER BY postNo DESC
LIMIT ?, ?;

# countSearchPosts
SELECT count(postNo)
FROM post
WHERE postNo > 0 AND postTitle LIKE concat('%', ?, '%');

# getPost
SELECT *
FROM post
WHERE postNo = ?;

# writePost
INSERT INTO post (postTitle, postText, postWriter)
VALUES (?, ?, ?);

# revisePost
UPDATE post
SET postTitle = ?, postText = ?, postRevDate = ?
WHERE postNo = ?;

# deletePost
DELETE FROM post
WHERE postNo = ?;

# plusViewCount
UPDATE post
SET postViewCnt = postViewCnt + 1
WHERE postNo = ?;

#################### Reply Table ####################
# getAllReplyList
SELECT *
FROM reply
WHERE postNo = ?
ORDER BY replyNo DESC;

# countAllReplies
SELECT count(replyNo)
FROM reply
WHERE postNo = ?

# writeReply
INSERT INTO reply (postNo, replyText, replyWriter)
VALUES (?, ?, ?);

# reviseReply
UPDATE reply
SET replyText = ?, replyRevDate = ?
WHERE replyNo = ?;

# deleteReply
DELETE FROM reply
WHERE replyNo = ?;

#################### Member Table ####################
