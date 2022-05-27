create table moeda ( 
	id_moeda varchar(40) not null,
    tx_nome varchar(50) not null, 
    tx_simbolo varchar (5) not null,
    primary key pk_moeda (id_moeda)
);

create table cotacao ( 
	id_cotacao varchar(40) not null,
    id_moeda varchar(50) not null, 
    dt_data datetime not null,
    vr_valor decimal (14,4)  null,
    primary key pk_cotacao (id_cotacao)
);