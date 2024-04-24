CREATE TABLE data_checklist(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    boolean active_flag
);

CREATE SEQUENCE data_checklist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE data_checklist_id_seq OWNED BY data_checklist.id;

ALTER TABLE ONLY data_checklist ALTER COLUMN id SET DEFAULT nextval('data_checklist_id_seq'::regclass);

ALTER TABLE ONLY data_checklist
    ADD CONSTRAINT data_checklist_pkey PRIMARY KEY (id);