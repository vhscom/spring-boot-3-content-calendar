create table if not exists content
(
    id           serial primary key,
    title        text      not null,
    description  text,
    status       text      not null,
    content_type text      not null,
    date_created timestamp not null default current_timestamp,
    date_updated timestamp,
    url          text
);

insert into content (title, description, status, content_type, date_created)
values ('How to make a cake', 'This is a recipe for a cake', 'IDEA', 'ARTICLE', current_timestamp);
