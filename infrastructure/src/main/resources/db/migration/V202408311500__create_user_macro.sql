create sequence app_dietas.ngr_user_macro_seq;
create table app_dietas.ngr_user_macro
(
    id                  BIGINT         NOT NULL PRIMARY KEY DEFAULT NEXTVAL('app_dietas.ngr_user_macro_seq'),
    carbohydrate_target DECIMAL(10, 2) NOT NULL,
    protein_target      DECIMAL(10, 2) NOT NULL,
    fat_target          DECIMAL(10, 2) NOT NULL,
    calories_target     DECIMAL(10, 2) NOT NULL,
    reference_date      DATE           NOT NULL,
    created_by          VARCHAR(50)    NOT NULL,
    created_at          timestamp      NOT NULL             DEFAULT current_timestamp,
    updated_by          VARCHAR(50)    NULL,
    updated_at          timestamp      NULL
);