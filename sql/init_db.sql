CREATE TABLE IF NOT EXISTS worker (
id IDENTITY PRIMARY KEY,
name VARCHAR(1000) CHECK (LENGTH(name) >= 2) NOT NULL,
birthday DATE CHECK(birthday >= '1900-01-01'),
level VARCHAR(50),
salary INT CHECK (salary >= 100 AND salary <= 100000),
CONSTRAINT check_level CHECK (
LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')
)
);

CREATE TABLE IF NOT EXISTS client (
id IDENTITY PRIMARY KEY,
name VARCHAR(1000) CHECK (LENGTH(name) >= 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS project (
id IDENTITY PRIMARY KEY,
client_id INT,
start_date DATE,
finish_date DATE,
PRIMARY KEY (id),
FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS project_worker (
project_id INT,
worker_id INT,
PRIMARY KEY (project_id, worker_id),
FOREIGN KEY (project_id) REFERENCES project(id),
FOREIGN KEY (worker_id) REFERENCES worker(id)
);