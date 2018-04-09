CREATE TABLE Employee(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    age INT,
    gender VARCHAR(10),
    companyId INT(11),
    salary INT,
    constraint `company_id_for` FOREIGN KEY (`companyId`) REFERENCES `Company` (`id`) on delete cascade on update cascade
) engine=InnoDB DEFAULT CHARSET = utf8;