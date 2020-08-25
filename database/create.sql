BEGIN TRANSACTION;

DROP TABLE IF EXISTS recipe CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS book CASCADE;
DROP TABLE IF EXISTS instruction CASCADE;
DROP TABLE IF EXISTS note CASCADE;
DROP TABLE IF EXISTS ingredient CASCADE;
DROP TABLE IF EXISTS recipe_category CASCADE;
DROP TABLE IF EXISTS recipe_book CASCADE;


CREATE extension IF NOT EXISTS "uuid-ossp";

CREATE TABLE recipe (
        recipe_id UUID DEFAULT uuid_generate_v4 (),
        recipe_name varchar NOT NULL,
        description varchar,
        minutes_to_create integer,
        num_servings decimal,
        date_created timestamp NOT NULL default CURRENT_TIMESTAMP,
        date_last_edited timestamp NOT NULL default CURRENT_TIMESTAMP,
        PRIMARY KEY (recipe_id),
        unique (recipe_name)
);

CREATE TABLE category (
        category_id UUID DEFAULT uuid_generate_v4 (),
        category_name varchar NOT NULL,
        PRIMARY KEY (category_id),
        unique (category_name)
);

CREATE TABLE book (
        book_id UUID DEFAULT uuid_generate_v4 (),
        book_name varchar NOT NULL,
        book_description varchar,
        PRIMARY KEY (book_id),
        unique (book_name)
);

CREATE TABLE instruction (
        instruction_id UUID DEFAULT uuid_generate_v4 (),
        recipe_id UUID NOT NULL,
        instruction_number integer NOT NULL,
        instruction_text varchar,
        PRIMARY KEY (instruction_id),
        unique (instruction_number)
);

CREATE TABLE note (
        note_id UUID DEFAULT uuid_generate_v4 (),
        recipe_id UUID NOT NULL,
        note_text varchar,
        date_created timestamp NOT NULL default CURRENT_TIMESTAMP,
        last_edited timestamp NOT NULL default CURRENT_TIMESTAMP,
        PRIMARY KEY (note_id)
);

CREATE TABLE ingredient (
        ingredient_id UUID DEFAULT uuid_generate_v4 (),
        recipe_id UUID NOT NULL,
        ingredient_name varchar NOT NULL,
        amount decimal NOT NULL,
        unit varchar,
        PRIMARY KEY (ingredient_id)


);

CREATE TABLE recipe_category (
        recipe_id UUID NOT NULL,
        category_id UUID NOT NULL,
        PRIMARY KEY(recipe_id, category_id),
        FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
        FOREIGN KEY (category_id) REFERENCES category(category_id)
);

CREATE TABLE recipe_book (
        recipe_id UUID NOT NULL,
        book_id UUID NOT NULL,
        PRIMARY KEY(recipe_id, book_id),
        FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id),
        FOREIGN KEY (book_id) REFERENCES book(book_id)
);

ALTER TABLE instruction
ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);

ALTER TABLE note
ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);

ALTER TABLE ingredient
ADD FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id);

COMMIT TRANSACTION;