
DROP TABLE IF EXISTS aircraft;

CREATE TABLE aircraft (
    id bigint not null primary key,
    call_sign varchar(7),
    squawk varchar(4),
    reg varchar(6),
    flightno varchar(10),
    route varchar(25),
    type varchar(4),
    category varchar(2),
    altitude int,
    heading int,
    speed int,
    vert_rate int,
    selected_altitude int,
    lat double,
    lon double,
    barometer double,
    polar_distance double,
    polar_bearing double,
    isadsb tinyint default 0,
    is_on_ground tinyint default 0,
    last_seen_time timestamp,
    pos_update_time timestamp,
    bds40seen_time timestamp
);