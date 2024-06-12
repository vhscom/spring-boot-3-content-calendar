create table if not exists content (
    id serial primary key,
    title text not null,
    description text not null,
    status text not null,
    contentType text not null,
    created_at timestamp not null default current_timestamp,
    updated_at timestamp not null default current_timestamp
);
