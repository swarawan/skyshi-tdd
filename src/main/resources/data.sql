DROP TABLE IF EXISTS user_data;

CREATE TABLE user_data (
  ud_id INT AUTO_INCREMENT  PRIMARY KEY,
  ud_fullname VARCHAR(250) NOT NULL,
  ud_password VARCHAR(250) NOT NULL,
  ud_updated_at DATETIME DEFAULT NULL ON UPDATE CURRENT_TIME,
  ud_created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO user_data (ud_fullname, ud_password) VALUES
  ('Folrunsho', 'Alakija');