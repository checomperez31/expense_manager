CREATE DATABASE expense_manager
    DEFAULT CHARACTER SET = 'utf8mb4';


    -- Active: 1636313947133@@127.0.0.1@3306@expense_manager
CREATE TABLE expense_type(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    description VARCHAR(300) COMMENT 'Description',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    create_user VARCHAR(36) COMMENT 'Create user',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Update Time',
    update_user VARCHAR(36) COMMENT 'Update user'
) COMMENT 'Expenses types';

-- Active: 1636313947133@@127.0.0.1@3306@expense_manager
CREATE TABLE account_type(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    description VARCHAR(300) COMMENT 'Description',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    create_user VARCHAR(36) COMMENT 'Create user',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Update Time',
    update_user VARCHAR(36) COMMENT 'Update user'
) COMMENT 'Account types';

CREATE TABLE account(
    id VARCHAR(36) NOT NULL PRIMARY KEY COMMENT 'Primary Key',
    name VARCHAR(300) COMMENT 'Description',
    amount DECIMAL(10,2) COMMENT 'Ammount of money' DEFAULT 0.00,
    type_id INT COMMENT 'Type of account',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    create_user VARCHAR(36) COMMENT 'Create user',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Update Time',
    update_user VARCHAR(36) COMMENT 'Update user'
) COMMENT 'Accounts';

ALTER TABLE account ADD CONSTRAINT FOREIGN KEY(type_id) REFERENCES account_type(id);

CREATE TABLE period(
    id VARCHAR(36) NOT NULL PRIMARY KEY COMMENT 'Primary Key',
    description VARCHAR(300) COMMENT 'Description',
    init_date DATETIME COMMENT 'Init date',
    finish_date DATETIME COMMENT 'Finish Time',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    create_user VARCHAR(36) COMMENT 'Create user',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Update Time',
    update_user VARCHAR(36) COMMENT 'Update user'
) COMMENT 'Periods';

CREATE TABLE expense(
    id VARCHAR(36) NOT NULL PRIMARY KEY COMMENT 'Primary Key',
    account_id VARCHAR(36) COMMENT 'Account',
    description VARCHAR(300) COMMENT 'Description',
    type_id INT COMMENT 'Type of expense',
    parent_id VARCHAR(36) COMMENT 'Expense parent',
    amount DECIMAL(10, 2) COMMENT 'Ammount of money' DEFAULT 0.00,
    movement_type VARCHAR(1) COMMENT 'Movement type' DEFAULT 'G',
    impact BOOLEAN COMMENT 'Impact account' DEFAULT true,
    period_id VARCHAR(36) COMMENT 'Period',
    expense_date DATETIME COMMENT 'Expense Time',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Create Time',
    create_user VARCHAR(36) COMMENT 'Create user',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT 'Update Time',
    update_user VARCHAR(36) COMMENT 'Update user'
) COMMENT 'Expenses';

ALTER TABLE expense ADD COLUMN origin_id VARCHAR(36) COMMENT 'Expense origin when expense is a transaction';

ALTER TABLE expense ADD CONSTRAINT FOREIGN KEY(account_id) REFERENCES account(id);
ALTER TABLE expense ADD CONSTRAINT FOREIGN KEY(type_id) REFERENCES expense_type(id);
ALTER TABLE expense ADD CONSTRAINT FOREIGN KEY(parent_id) REFERENCES expense(id);
ALTER TABLE expense ADD CONSTRAINT FOREIGN KEY(origin) REFERENCES expense(id);
ALTER TABLE expense ADD CONSTRAINT FOREIGN KEY(period_id) REFERENCES period(id);

INSERT INTO account_type(description) VALUES('Credito');
INSERT INTO account_type(description) VALUES('Debito');
INSERT INTO account_type(description) VALUES('Ahorro');

INSERT INTO expense_type(description) VALUES('Gasolina');
INSERT INTO expense_type(description) VALUES('Despensa');
INSERT INTO expense_type(description) VALUES('Medicina');
INSERT INTO expense_type(description) VALUES('Medico');
INSERT INTO expense_type(description) VALUES('Servicios');
INSERT INTO expense_type(description) VALUES('Comida');
INSERT INTO expense_type(description) VALUES('Tanda');
INSERT INTO expense_type(description) VALUES('Ahorro');
INSERT INTO expense_type(description) VALUES('Servicios basicos');
INSERT INTO expense_type(description) VALUES('Tiempo aire');
INSERT INTO expense_type(description) VALUES('Quincena');
INSERT INTO expense_type(description) VALUES('Renta');
INSERT INTO expense_type(description) VALUES('Recargas');
INSERT INTO expense_type(description) VALUES('Pago Tarjeta Credito');