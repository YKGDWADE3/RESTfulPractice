CREATE TABLE Company(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    companyName VARCHAR(255),
    employeesNumber INT(11)
) engine=InnoDB DEFAULT CHARSET = gbk;