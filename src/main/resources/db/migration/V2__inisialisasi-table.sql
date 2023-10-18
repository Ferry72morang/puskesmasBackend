CREATE TABLE IF NOT EXISTS personal (
	personal_id bigserial NOT NULL,
	personal_name varchar(255) NULL,
	personal_birth_date timestamp(6) NULL,
	personal_birth_place varchar(255) NULL,
	personal_phone_number varchar(255) NULL,
	personal_is_active bool NULL,
	CONSTRAINT personal_pk PRIMARY KEY (personal_id)
);

CREATE TABLE IF NOT EXISTS pemeriksaan (
	id bigserial NOT NULL,
	nama_pemeriksaan varchar(255) NULL,
	id_pasien int8 NULL,
	CONSTRAINT pemeriksaan_fk FOREIGN KEY (id_pasien) REFERENCES test.personal(personal_id)
);