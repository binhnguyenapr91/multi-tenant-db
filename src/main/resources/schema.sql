create table adapter
(
    id            varchar(10)  not null,
    adapter_id    varchar(128) null,
    adapter_name  varchar(128) null,
    created_time  timestamp    null,
    created_by    varchar(10)  null,
    modified_time timestamp    null,
    modified_by   varchar(10)  null,
    constraint adapter_id_uindex
        unique (id)
);

alter table adapter
    add primary key (id);