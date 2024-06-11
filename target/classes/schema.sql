CREATE TABLE IF NOT EXISTS supplements (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    benefits VARCHAR(255),
    evidence VARCHAR(255),
    FULLTEXT INDEX(name)
);
