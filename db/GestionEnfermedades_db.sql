
DROP TABLE IF EXISTS Usuarios CASCADE;
DROP TABLE IF EXISTS Enfermedades CASCADE;

CREATE TABLE Usuarios (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(150) NOT NULL,
                          email VARCHAR(150) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          role VARCHAR(30) NOT NULL CHECK (role IN ('Administrador','Medico','Usuario'))
);

CREATE TABLE Enfermedades (
                              id SERIAL PRIMARY KEY,
                              nombre VARCHAR(100) NOT NULL UNIQUE,
                              nombreCientifico VARCHAR(100) NOT NULL,
                              nivelGravedad VARCHAR(20) NOT NULL CHECK (nivelGravedad IN('Leve', 'Moderada', 'Grave', 'Critica')),
                              sintomas VARCHAR(500) NOT NULL,
                              medicamentos VARCHAR(200) NOT NULL,
                              esContagiosa BOOLEAN NOT NULL DEFAULT FALSE,
                              esCubiertaPorPos BOOLEAN NOT NULL DEFAULT FALSE,
                              requiereIncapacidad BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO Usuarios (name, email, password, role) VALUES
                                                       ('Nathan Gama', 'nathan.gama@admin.com', 'admin', 'Administrador'),
                                                       ('Antonio Lopez', 'antonio.lopez@medico.com', 'medico123', 'Medico');

INSERT INTO Enfermedades
(nombre, nombreCientifico, nivelGravedad, sintomas, medicamentos, esContagiosa, esCubiertaPorPos, requiereIncapacidad)
VALUES
    ('Gripe común', 'Influenza', 'Leve', 'Fiebre, tos, congestión nasal, dolor de garganta', 'Paracetamol, Loratadina', TRUE, TRUE, FALSE),
    ('COVID-19', 'SARS-CoV-2', 'Grave', 'Fiebre, tos seca, dificultad respiratoria, anosmia', 'Paracetamol, Oxígeno suplementario', TRUE, TRUE, TRUE),
    ('Varicela', 'Varicella zoster', 'Moderada', 'Erupción cutánea, picazón, fiebre', 'Aciclovir, Antihistamínicos', TRUE, TRUE, TRUE),
    ('Hipertensión arterial', 'Hipertensión esencial', 'Moderada', 'Dolor de cabeza, mareo, zumbido en los oídos', 'Losartán, Enalapril', FALSE, TRUE, FALSE),
    ('Diabetes tipo 2', 'Diabetes mellitus tipo 2', 'Grave', 'Sed excesiva, fatiga, visión borrosa', 'Metformina, Insulina', FALSE, TRUE, TRUE),
    ('Resfriado común', 'Rhinovirus', 'Leve', 'Estornudos, congestión nasal, malestar leve', 'Descongestionante, Vitamina C', TRUE, FALSE, FALSE);