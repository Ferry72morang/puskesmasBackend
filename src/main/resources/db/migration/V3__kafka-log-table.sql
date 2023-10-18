CREATE TABLE IF NOT EXISTS kafka_log_table (
    id BIGSERIAL PRIMARY KEY,
    action varchar(255),
    from_table varchar(20),
    log TEXT NULL,
    created_by VARCHAR(15) DEFAULT 'SYSTEM',
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(15) DEFAULT 'SYSTEM',
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);