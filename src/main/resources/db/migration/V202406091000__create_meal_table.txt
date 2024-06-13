create
sequence app_dietas.meal_seq;

create table mealAggregateDTO
(
    id             BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('app_dietas.meal_seq'),
    type           VARCHAR(100)   NOT NULL,
    food_id        BIGINT         NOT NULL,
    reference_date DATE           NOT NULL,
    created_by     VARCHAR(50)    NOT NULL,
    created_at     timestamp      NOT NULL             DEFAULT current_timestamp,
    updated_by     VARCHAR(50) NULL,
    updated_at     timestamp NULL
);