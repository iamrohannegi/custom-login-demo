DROP DATABASE IF EXISTS `login-info-demo`;

CREATE DATABASE IF NOT EXISTS `login-info-demo`;
USE `login-info-demo`;

-- Following Spring Security Default Schema 
-- Two tables needed: `users` and `authorities`

-- Table `users`
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`(
	`username` varchar(50) NOT NULL,
    `password` char(68) NOT NULL,
    `enabled` tinyint(1) NOT NULL,
    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Adding users for the demo to test the functionality
-- Password Encryption by bcrypt
-- Default password: test123

INSERT INTO `users` 
VALUES 
('leslie','{bcrypt}$2y$12$thmECD0NN2Bq2JCDoKTVYunCjWo/7rWIrzinliRjBHzBsOWX5chki',1),
('ron','{bcrypt}$2y$12$thmECD0NN2Bq2JCDoKTVYunCjWo/7rWIrzinliRjBHzBsOWX5chki',1),
('andy','{bcrypt}$2y$12$thmECD0NN2Bq2JCDoKTVYunCjWo/7rWIrzinliRjBHzBsOWX5chki',1);



-- Table `authorities`
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`(
	`username` varchar(50) NOT NULL,
    `authority` varchar(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Adding data for the demo to test the functionality

INSERT INTO `authorities` 
VALUES 
('leslie','ROLE_DEPUTY_DIRECTOR'),
('ron','ROLE_DIRECTOR'),
('andy','ROLE_FBI_AGENT'),
('andy','ROLE_SHOE_SHINER');


