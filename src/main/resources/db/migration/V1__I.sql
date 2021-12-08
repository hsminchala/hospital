CREATE TABLE IF NOT EXISTS doctor (
    id serial primary key,
    nombre VARCHAR(45) NOT NULL,
    especialidad VARCHAR(45) NOT NULL
    );

CREATE TABLE IF NOT EXISTS paciente (
    id serial primary key,
    nombre VARCHAR(45) NOT NULL,
    edad VARCHAR(15) NOT NULL,
    doctor_id int,
    foreign key (doctor_id) references doctor(id)
    );

CREATE TABLE IF NOT EXISTS tratamiento (
    id serial primary key,
    descripcion VARCHAR(45) NOT NULL,
    paciente_id int,
    foreign key (paciente_id) references paciente(id)
    );