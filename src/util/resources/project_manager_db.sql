CREATE TABLE Program (
    ID_program INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    promotion ENUM('FULL_TIME', 'APPRENTICESHIP', 'CONTINUING_EDUCATION')
);

CREATE TABLE Project (
    ID_project INT AUTO_INCREMENT PRIMARY KEY,
    course VARCHAR(255),
    subject VARCHAR(255),
    deadline DATE
);

CREATE TABLE Student (
    ID_student INT AUTO_INCREMENT PRIMARY KEY,
    fullName VARCHAR(255) NOT NULL,
    dateOfBirth DATE,
    sex ENUM('MALE', 'FEMALE'),
    address VARCHAR(255),
    email VARCHAR(255),
    ID_program INT,
    FOREIGN KEY (ID_program) REFERENCES Program(ID_program)
) AUTO_INCREMENT = 1;

CREATE TABLE Team (
    ID_student1 INT,
    ID_student2 INT,
    ID_project INT,
    dateOfSubmit DATE,
    PRIMARY KEY (ID_student1, ID_student2, ID_project),
    FOREIGN KEY (ID_student1) REFERENCES Student(ID_student),
    FOREIGN KEY (ID_student2) REFERENCES Student(ID_student),
    FOREIGN KEY (ID_project) REFERENCES Project(ID_project)
);

CREATE TABLE Grade (
    ID_student1 INT,
    ID_student2 INT,
    ID_project INT,
    gradeEssay DECIMAL(4,2), 
    gradePresentation1 DECIMAL(4,2), 
    gradePresentation2 DECIMAL(4,2), 
		finalGrade1 DECIMAL(4,2),
    finalGrade2 DECIMAL(4,2),
    PRIMARY KEY (ID_student1, ID_student2, ID_project),
    FOREIGN KEY (ID_student1) REFERENCES Student(ID_student),
    FOREIGN KEY (ID_student2) REFERENCES Student(ID_student),
    FOREIGN KEY (ID_project) REFERENCES Project(ID_project)
);

INSERT INTO Program (name, promotion) VALUES
('MIAGE', 'FULL_TIME'),
('IDD', 'FULL_TIME');

INSERT INTO Student (fullName, dateOfBirth, sex, address, email, ID_program) VALUES
('Jean Dupont', '1998-05-15', 'MALE', '3 Rue de la Liberté', 'jean.dupont@email.com', 1),
('Marie Martin', '1999-03-20', 'FEMALE', '5 Avenue des Champs-Élysées', 'marie.martin@email.com', 2),
('Pierre Dubois', '1997-09-10', 'MALE', '8 Boulevard Haussmann', 'pierre.dubois@email.com', 1),
('Élise Lefèvre', '2000-02-28', 'FEMALE', '15 Place de la Bastille', 'elise.lefevre@email.com', 2),
('Jacques Bernard', '1996-12-05', 'MALE', '20 Rue de la Paix', 'jacques.bernard@email.com', 1),
('Sophie Laurent', '1995-07-18', 'FEMALE', '14 Avenue du Montparnasse', 'sophie.laurent@email.com', 2);

INSERT INTO Project (course, subject, deadline) VALUES
('Programmation Objet', 'Project Manager', '2023-12-31'),
('Machine Learning', 'Decision Trees', '2023-11-15'),
('Marketing', 'Market Research', '2023-12-20');

DELIMITER $$

CREATE TRIGGER team_insert_trigger
AFTER INSERT ON Team FOR EACH ROW
BEGIN
    INSERT INTO Grade (ID_student1, ID_student2, ID_project, gradeEssay, gradePresentation1, gradePresentation2, finalGrade1, finalGrade2)
    VALUES (NEW.ID_student1, NEW.ID_student2, NEW.ID_project, NULL, NULL, NULL, NULL, NULL);
END;
$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER team_delete_trigger
BEFORE DELETE ON Team FOR EACH ROW
BEGIN
    DELETE FROM Grade WHERE ID_student1 = OLD.ID_student1 AND ID_student2 = OLD.ID_student2 AND ID_project = OLD.ID_project;
END;
$$

DELIMITER ;

INSERT INTO Team (ID_student1, ID_student2, ID_project, dateOfSubmit) VALUES
(1, 2, 1, '2023-11-15'); -- Jean and Marie working on "Programmation Objet"

INSERT INTO Team (ID_student1, ID_student2, ID_project, dateOfSubmit) VALUES
(3, 4, 2, '2023-11-20'); -- Pierre and Élise working on "Machine Learning"

INSERT INTO Team (ID_student1, ID_student2, ID_project, dateOfSubmit) VALUES
(5, 6, 3, '2023-11-25'); -- Jacques and Sophie working on "Marketing"

INSERT INTO Team (ID_student1, ID_student2, ID_project, dateOfSubmit) VALUES
(4, 3, 1, '2023-12-31');