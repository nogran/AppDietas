create sequence ngr_food_seq;
create table ngr_food
(
    id             BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('ngr_food_seq'),
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


create sequence ngr_user_seq;
create table ngr_user
(
    id          BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('ngr_user_seq'),
    name        VARCHAR(100)   NOT NULL,
    email       VARCHAR(100)   NOT NULL UNIQUE,
    login       VARCHAR(100)   NOT NULL UNIQUE,
    password    VARCHAR(100)   NOT NULL,
    user_status VARCHAR(15)    NOT NULL,
    birth_date  DATE           NULL,
    weight      DECIMAL(10, 2) NULL,
    height      DECIMAL(10, 2) NULL,
    gender      VARCHAR(20)    NULL,
    created_by  VARCHAR(50)    NOT NULL,
    created_at  timestamp      NOT NULL             DEFAULT current_timestamp,
    updated_by  VARCHAR(50)    NULL,
    updated_at  timestamp      NULL
);


create sequence ngr_user_verification_seq;
create table ngr_user_verification
(
    id              BIGINT      NOT NULL PRIMARY KEY DEFAULT NEXTVAL('ngr_user_verification_seq'),
    uuid            UUID        NOT NULL,
    user_id         BIGINT      NOT NULL UNIQUE,
    created_by      VARCHAR(50) NOT NULL,
    expiration_date timestamp   NOT NULL,
    created_at      timestamp   NOT NULL             DEFAULT current_timestamp,
    updated_by      VARCHAR(50) NULL,
    updated_at      timestamp   NULL
);