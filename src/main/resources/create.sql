CREATE TABLE aircraft (
    id int not null primary key,
    call_sign varchar(255),
    squawk varchar(255),
    reg varchar(255),
    flightno varchar(255),
    route varchar(255),
    type varchar(255),
    category varchar(255),
    altitude int,
    heading int,
    speed int,
    lat bigint,
    lon bigint,
    barometer bigint,
    vert_rate int,
    selected_altitude int,
    polar_distance bigint,
    polar_bearing bigint,
    isadsb tinyint default 0,
    is_on_ground tinyint default 0,
    last_seen_time varchar(255),
    pos_update_time varchar(255),
    bds40seen_time varchar(255)
);