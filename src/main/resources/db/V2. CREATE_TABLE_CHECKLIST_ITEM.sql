CREATE TABLE checklist_item(
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL,
    id INT NOT NULL,
    boolean status,
    boolean active_flag
);

CREATE SEQUENCE checklist_item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE checklist_item_id_seq OWNED BY checklist_item.id;

ALTER TABLE ONLY checklist_item ALTER COLUMN id SET DEFAULT nextval('checklist_item_id_seq'::regclass);

ALTER TABLE ONLY checklist_item
    ADD CONSTRAINT checklist_item_pkey PRIMARY KEY (id);