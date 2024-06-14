create sequence app_dietas.food_seq;

create table ngr_food
(
    id             BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('app_dietas.food_seq'),
    name           VARCHAR(100)   NOT NULL,
    grams          DECIMAL(10, 2) NOT NULL,
    carbohydrate   DECIMAL(10, 2) NOT NULL,
    protein        DECIMAL(10, 2) NOT NULL,
    fat            DECIMAL(10, 2) NOT NULL,
    total_calories DECIMAL(10, 2) NULL,
    company        VARCHAR(100)   NULL,
    created_by     VARCHAR(50)    NOT NULL,
    created_at     timestamp      NOT NULL             DEFAULT current_timestamp,
    updated_by     VARCHAR(50)    NULL,
    updated_at     timestamp      NULL
);

create sequence app_dietas.user_seq;

create table ngr_user
(
    id         BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('app_dietas.user_seq'),
    name       VARCHAR(100)   NOT NULL,
    email      VARCHAR(100)   NOT NULL,
    login      VARCHAR(100)   NOT NULL,
    password   VARCHAR(100)   NOT NULL,
    birth_date DATE           NULL,
    weight     DECIMAL(10, 2) NULL,
    height     DECIMAL(10, 2) NULL,
    gender     VARCHAR(20)    NULL,
    created_at timestamp      NOT NULL             DEFAULT current_timestamp,
    updated_by VARCHAR(50)    NULL,
    updated_at timestamp      NULL
);