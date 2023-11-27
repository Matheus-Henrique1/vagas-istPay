CREATE TABLE candidato (
    id_candidato SERIAL PRIMARY KEY,
    nom_candidato VARCHAR(100),
    rg_candidato VARCHAR(20),
    cpf_candidato VARCHAR(20),
    dat_nas_candidato DATE,
    exp_pro_candidato TEXT
);

CREATE TABLE vaga (
    id_vaga SERIAL PRIMARY KEY,
    nom_emp_vaga VARCHAR(100),
    num_de_vag_vaga INTEGER,
    tit_vaga VARCHAR(100),
    des_vaga TEXT,
    req_vaga TEXT,
    niv_exp_vaga TEXT,
    dat_pub_vaga DATE,
    tip_con_vaga VARCHAR(50),
    obs_vaga TEXT,
    ati_vaga BOOLEAN
);

CREATE TABLE candidato_vaga (
    id_candidato INTEGER,
    id_vaga INTEGER,
    PRIMARY KEY (id_candidato, id_vaga)
);

ALTER TABLE IF EXISTS candidato_vaga ADD CONSTRAINT FK_candidato_vaga_2
    FOREIGN KEY (id_candidato)
    REFERENCES candidato;

ALTER TABLE IF EXISTS candidato_vaga ADD CONSTRAINT FK_candidato_vaga_3
    FOREIGN KEY (id_vaga)
    REFERENCES vaga;
