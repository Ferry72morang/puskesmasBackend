--Init sql untuk create table awal
-- V1__baseline.sql
-- Create baseline schema history table
CREATE TABLE IF NOT EXISTS history_tabel_flyway (
    installed_rank INT NOT NULL,
    version VARCHAR(50),
    description VARCHAR(200) NOT NULL,
    type VARCHAR(20) NOT NULL,
    script VARCHAR(1000) NOT NULL,
    checksum INT,
    installed_by VARCHAR(100) NOT NULL,
    installed_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    execution_time INT NOT NULL,
    success BOOLEAN NOT NULL
);

-- Insert baseline record
INSERT INTO history_tabel_flyway (
    installed_rank, version, description, type, script, checksum,
    installed_by, installed_on, execution_time, success
) VALUES (
    1, '1.0', 'Baseline', 'BASELINE', 'V1__baseline.sql', NULL,
    'admin', CURRENT_TIMESTAMP, 0, true
);