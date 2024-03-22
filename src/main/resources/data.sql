INSERT INTO tourist_db.tag (id, name) VALUES (1, 'Forlystelse');
INSERT INTO tourist_db.tag (id, name) VALUES (2, 'Sport');
INSERT INTO tourist_db.tag (id, name) VALUES (3, 'Kultur');
INSERT INTO tourist_db.tag (id, name) VALUES (4, 'Shoppingcenter');
INSERT INTO tourist_db.tag (id, name) VALUES (5, 'Seværdighed');

INSERT INTO tourist_db.tourist_attraction (id, name, city, description) VALUES (1, 'Tivoli', 'København', 'Dyr forlystelsespark');
INSERT INTO tourist_db.tourist_attraction (id, name, city, description) VALUES (2, 'Fields', 'København', 'Et shoppingcenter');
INSERT INTO tourist_db.tourist_attraction (id, name, city, description) VALUES (3, 'Strøget', 'København', '');
INSERT INTO tourist_db.tourist_attraction (id, name, city, description) VALUES (4, 'Parken', 'København', 'Hala bel zahbe');

INSERT INTO tourist_db.tourist_attraction_tags (tags_id, tourist_attractiondb_id) VALUES (1, 1);
INSERT INTO tourist_db.tourist_attraction_tags (tags_id, tourist_attractiondb_id) VALUES (3, 1);
INSERT INTO tourist_db.tourist_attraction_tags (tags_id, tourist_attractiondb_id) VALUES (4, 2);
INSERT INTO tourist_db.tourist_attraction_tags (tags_id, tourist_attractiondb_id) VALUES (5, 3);
INSERT INTO tourist_db.tourist_attraction_tags (tags_id, tourist_attractiondb_id) VALUES (4, 3);
INSERT INTO tourist_db.tourist_attraction_tags (tags_id, tourist_attractiondb_id) VALUES (2, 4);
INSERT INTO tourist_db.tourist_attraction_tags (tags_id, tourist_attractiondb_id) VALUES (3, 4);


