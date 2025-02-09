CREATE TABLE student (
                         student_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         gender VARCHAR(50) NOT NULL,
                         age int not null,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         mobile_number VARCHAR(50) NOT NULL,
                         status BOOLEAN NOT NULL DEFAULT TRUE,
                         joining_date DATE NOT NULL,
                         created_on DATE,
                         last_updated_on DATE
);
