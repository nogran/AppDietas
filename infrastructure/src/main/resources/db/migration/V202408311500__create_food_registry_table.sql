create sequence app_dietas.ngr_food_registry_seq;
create table app_dietas.ngr_food_registry
(
    id             BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('app_dietas.ngr_food_registry_seq'),
    meal           VARCHAR(50)    NOT NULL,
    grams          DECIMAL(10, 2) NOT NULL,
    reference_date DATE           NOT NULL,
    created_by     VARCHAR(50)    NOT NULL,
    created_at     timestamp      NOT NULL             DEFAULT current_timestamp,
    updated_by     VARCHAR(50)    NULL,
    updated_at     timestamp      NULL,
    food_id        BIGINT         NOT NULL REFERENCES ngr_food (id),
    user_id        BIGINT         NOT NULL REFERENCES ngr_user (id)
);