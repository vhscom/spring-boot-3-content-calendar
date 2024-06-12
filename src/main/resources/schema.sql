create table if not exists content (
    id serial primary key,
    title text not null,
    description text,
    status text not null,
    contentType text not null,
    date_created timestamp not null default current_timestamp,
    date_updated timestamp,
    url text
);
