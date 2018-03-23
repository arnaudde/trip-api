# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table airline_service (
  id                            bigint not null,
  departure_id                  bigint not null,
  arrival_id                    bigint not null,
  min_departure_time            integer not null,
  max_departure_time            integer not null,
  max_duration                  integer not null,
  month                         integer not null,
  exists                        boolean not null,
  constraint uq_airline_service_departure_id_arrival_id_month_min_depa_1 unique (departure_id,arrival_id,month,min_departure_time,max_departure_time,max_duration),
  constraint pk_airline_service primary key (id)
);
create sequence airline_service_seq;

create table city (
  id                            bigint not null,
  name                          varchar(250) not null,
  airport_code                  varchar(3) not null,
  b_code                        integer not null,
  h_code                        integer not null,
  type                          varchar(250) not null,
  b_type                        varchar(250) not null,
  latitude                      float not null,
  longitude                     float not null,
  country_id                    bigint not null,
  constraint uq_city_name unique (name),
  constraint uq_city_airport_code unique (airport_code),
  constraint uq_city_b_code unique (b_code),
  constraint uq_city_h_code unique (h_code),
  constraint pk_city primary key (id)
);
create sequence city_seq;

create table city_climate (
  id                            bigint not null,
  city_id                       bigint not null,
  month                         integer not null,
  mean_temperature              integer not null,
  min_mean_temperature          integer not null,
  max_mean_temperature          integer not null,
  precipitations                integer not null,
  number_days_of_rain           integer not null,
  score                         integer not null,
  constraint uq_city_climate_city_id_month unique (city_id,month),
  constraint pk_city_climate primary key (id)
);
create sequence city_climate_seq;

create table country (
  id                            bigint not null,
  name                          varchar(25) not null,
  budget                        float not null,
  constraint uq_country_name unique (name),
  constraint pk_country primary key (id)
);
create sequence country_seq;

create table flight (
  id                            bigint not null,
  departure                     varchar(3) not null,
  date                          date not null,
  created_on                    date not null,
  arrival                       varchar(3) not null,
  min_departure_time            varchar(4) not null,
  max_departure_time            varchar(4) not null,
  max_duration                  varchar(4) not null,
  price                         integer not null,
  constraint uq_flight_departure_arrival_date_min_departure_time_max_d_1 unique (departure,arrival,date,min_departure_time,max_departure_time,max_duration),
  constraint pk_flight primary key (id)
);
create sequence flight_seq;

alter table airline_service add constraint fk_airline_service_departure_id foreign key (departure_id) references city (id) on delete restrict on update restrict;
create index ix_airline_service_departure_id on airline_service (departure_id);

alter table airline_service add constraint fk_airline_service_arrival_id foreign key (arrival_id) references city (id) on delete restrict on update restrict;
create index ix_airline_service_arrival_id on airline_service (arrival_id);

alter table city add constraint fk_city_country_id foreign key (country_id) references country (id) on delete restrict on update restrict;
create index ix_city_country_id on city (country_id);

alter table city_climate add constraint fk_city_climate_city_id foreign key (city_id) references city (id) on delete restrict on update restrict;
create index ix_city_climate_city_id on city_climate (city_id);


# --- !Downs

alter table if exists airline_service drop constraint if exists fk_airline_service_departure_id;
drop index if exists ix_airline_service_departure_id;

alter table if exists airline_service drop constraint if exists fk_airline_service_arrival_id;
drop index if exists ix_airline_service_arrival_id;

alter table if exists city drop constraint if exists fk_city_country_id;
drop index if exists ix_city_country_id;

alter table if exists city_climate drop constraint if exists fk_city_climate_city_id;
drop index if exists ix_city_climate_city_id;

drop table if exists airline_service cascade;
drop sequence if exists airline_service_seq;

drop table if exists city cascade;
drop sequence if exists city_seq;

drop table if exists city_climate cascade;
drop sequence if exists city_climate_seq;

drop table if exists country cascade;
drop sequence if exists country_seq;

drop table if exists flight cascade;
drop sequence if exists flight_seq;

