-- ================================================================
-- HEALTH CLINIC MANAGEMENT SYSTEM — DATABASE SCRIPT
-- ================================================================
DROP DATABASE IF EXISTS health_clinic_db;
CREATE DATABASE health_clinic_db;
USE health_clinic_db;

-- ----------------------------------------------------------------
-- 1. PATIENTS
-- ----------------------------------------------------------------
CREATE TABLE patients (
                          patient_id INT AUTO_INCREMENT PRIMARY KEY,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          date_of_birth DATE,
                          gender ENUM('Male','Female','Other'),
                          phone_number VARCHAR(15) UNIQUE,
                          email VARCHAR(100) UNIQUE,
                          is_active BOOLEAN DEFAULT TRUE,
                          registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- ----------------------------------------------------------------
-- 2. DOCTORS
-- ----------------------------------------------------------------
CREATE TABLE doctors (
                         doctor_id INT AUTO_INCREMENT PRIMARY KEY,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         phone_number VARCHAR(15) UNIQUE,
                         email VARCHAR(100) UNIQUE,
                         is_active BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB;

-- ----------------------------------------------------------------
-- 3. SPECIALIZATIONS
-- ----------------------------------------------------------------
CREATE TABLE specializations (
                                 specialization_id INT AUTO_INCREMENT PRIMARY KEY,
                                 name VARCHAR(100) NOT NULL UNIQUE,
                                 description VARCHAR(255)
) ENGINE=InnoDB;

-- ----------------------------------------------------------------
-- 4. DOCTOR <-> SPECIALIZATION (Many-to-Many)
-- ----------------------------------------------------------------
CREATE TABLE doctor_specializations (
                                        doctor_id INT,
                                        specialization_id INT,
                                        PRIMARY KEY (doctor_id, specialization_id),
                                        FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE CASCADE,
                                        FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- ----------------------------------------------------------------
-- 5. APPOINTMENTS
-- ----------------------------------------------------------------
CREATE TABLE appointments (
                              appointment_id INT AUTO_INCREMENT PRIMARY KEY,
                              patient_id INT NOT NULL,
                              doctor_id INT NOT NULL,
                              appointment_date DATETIME NOT NULL,
                              status ENUM('Scheduled','Completed','Cancelled') DEFAULT 'Scheduled',
                              FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
                              FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
                              INDEX idx_patient_id (patient_id),
                              INDEX idx_doctor_date (doctor_id, appointment_date)
) ENGINE=InnoDB;

-- ----------------------------------------------------------------
-- 6. BILLING
-- ----------------------------------------------------------------
CREATE TABLE billing (
                         bill_id INT AUTO_INCREMENT PRIMARY KEY,
                         appointment_id INT NOT NULL UNIQUE,
                         amount DECIMAL(10,2) NOT NULL,
                         payment_status ENUM('Pending','Paid','Refunded') DEFAULT 'Pending',
                         billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
) ENGINE=InnoDB;

-- ----------------------------------------------------------------
-- 7. VISIT HISTORY
-- ----------------------------------------------------------------
CREATE TABLE visit_history (
                               visit_id INT AUTO_INCREMENT PRIMARY KEY,
                               appointment_id INT NOT NULL UNIQUE,
                               diagnosis VARCHAR(255),
                               prescription VARCHAR(255),
                               visit_notes TEXT,
                               FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
) ENGINE=InnoDB;

-- ----------------------------------------------------------------
-- 8. AUDIT LOG + TRIGGERS
-- ----------------------------------------------------------------
CREATE TABLE audit_log (
                           audit_id INT AUTO_INCREMENT PRIMARY KEY,
                           table_name VARCHAR(50),
                           action VARCHAR(20),
                           record_id INT,
                           action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB;

DELIMITER //
CREATE TRIGGER trg_appointment_audit_insert
    AFTER INSERT ON appointments
    FOR EACH ROW
BEGIN
    INSERT INTO audit_log (table_name, action, record_id)
    VALUES ('appointments', 'INSERT', NEW.appointment_id);
END //

CREATE TRIGGER trg_appointment_audit_update
    AFTER UPDATE ON appointments
    FOR EACH ROW
BEGIN
    INSERT INTO audit_log (table_name, action, record_id)
    VALUES ('appointments', 'UPDATE', NEW.appointment_id);
END //
DELIMITER ;

-- ----------------------------------------------------------------
-- 9. APPLICATION USER
-- ----------------------------------------------------------------
CREATE USER IF NOT EXISTS 'clinic_app_user'@'localhost' IDENTIFIED BY 'StrongPassword123!';
GRANT SELECT, INSERT, UPDATE, DELETE ON health_clinic_db.* TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;

-- ----------------------------------------------------------------
-- 10. SAMPLE DATA
-- ----------------------------------------------------------------
INSERT INTO specializations (name, description) VALUES
                                                    ('Cardiology', 'Heart-related treatment'),
                                                    ('Pediatrics', 'Child healthcare'),
                                                    ('Orthopedics', 'Bone and joint care');

INSERT INTO doctors (first_name, last_name, phone_number, email) VALUES
                                                                     ('Anjali', 'Rao', '9123456780', 'dr.rao@clinic.com'),
                                                                     ('Vikram', 'Iyer', '9123456781', 'dr.iyer@clinic.com');

INSERT INTO doctor_specializations (doctor_id, specialization_id) VALUES
                                                                      (1, 1),
                                                                      (2, 2);

INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email) VALUES
                                                                                             ('Ramesh', 'Kumar', '1979-05-14', 'Male', '9876543210', 'ramesh@email.com'),
                                                                                             ('Sita', 'Sharma', '1990-08-21', 'Female', '9876543211', 'sita@email.com');

INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES
                                                                               (1, 1, '2026-08-10 10:00:00', 'Scheduled'),
                                                                               (2, 2, '2026-08-11 11:30:00', 'Scheduled');