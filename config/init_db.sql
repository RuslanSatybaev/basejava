CREATE TABLE resume
(
    uuid CHAR(36) NOT NULL CONSTRAINT resume_pk PRIMARY KEY,
    full_name TEXT NOT NULL
);

CREATE TABLE contact
(
    id SERIAL CONSTRAINT contact_pk PRIMARY KEY,
    resume_uuid CHAR(36) NOT NULL CONSTRAINT contact_resume_uuid_fk
        REFERENCES resume ON UPDATE RESTRICT ON DELETE CASCADE,
    type TEXT NOT NULL,
    value TEXT NOT NULL

);

CREATE UNIQUE INDEX contact_uuid_type_index ON contact (resume_uuid, type);

CREATE TABLE section
(
    id          SERIAL PRIMARY KEY,
    resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
    type        TEXT     NOT NULL,
    content     TEXT     NOT NULL
);
CREATE UNIQUE INDEX section_idx
ON section (resume_uuid, type);
