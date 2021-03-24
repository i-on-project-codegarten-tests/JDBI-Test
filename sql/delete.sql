-- Delete table entries
DELETE FROM USER_CLASSROOM;
DELETE FROM CLASSROOM;
DELETE FROM USERS;

-- Restart identity columns
ALTER SEQUENCE USERS_uid_seq restart;
ALTER SEQUENCE CLASSROOM_cid_seq restart;