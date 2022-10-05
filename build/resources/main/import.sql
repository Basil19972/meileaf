

/*ROLES */
insert into roles (id, name) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'USER');
insert into roles (id, name) values ('4d0f7301-c123-4189-9636-066531275bf4', 'DEV');
insert into roles (id, name) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'ADMIN');


/*AUTHORITIES */
insert into authorities (id, name) values ('4ab22cdc-0cf9-4354-92ab-68702d54ffd0', 'USER_READ');
insert into authorities (id, name) values ('d1519f54-f849-4543-816b-b24f4c5173e9', 'USER_MODIFY');
insert into authorities (id, name) values ('c1e9ccd6-1d29-40a1-a544-f133a14dc246', 'USER_DELETE');

insert into authorities (id, name) values ('b7a6d679-9ebc-4f8a-b5be-52aa35a2285c', 'PRODUCT_READ');
insert into authorities (id, name) values ('85248618-f314-4e25-ae50-ba7341c146ef', 'CATEGORY_READ');
insert into authorities (id, name) values ('fd22ce26-6e5a-45a7-ab37-2c5e0ca83777', 'ORDER_WRITE');
insert into authorities (id, name) values ('52b6c76f-3749-4494-9c91-1c311a544776', 'ORDER_READ');
insert into authorities (id, name) values ('041ac4c7-3de5-4872-8059-bc9664a9de0a', 'CAN_SEE_STATISTICS');





/*USER */
insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '4ab22cdc-0cf9-4354-92ab-68702d54ffd0');

insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'b7a6d679-9ebc-4f8a-b5be-52aa35a2285c');
insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '85248618-f314-4e25-ae50-ba7341c146ef');
insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'fd22ce26-6e5a-45a7-ab37-2c5e0ca83777');
insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '52b6c76f-3749-4494-9c91-1c311a544776');

/*DEV */
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '4ab22cdc-0cf9-4354-92ab-68702d54ffd0');
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'd1519f54-f849-4543-816b-b24f4c5173e9');
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'c1e9ccd6-1d29-40a1-a544-f133a14dc246');

insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'b7a6d679-9ebc-4f8a-b5be-52aa35a2285c');
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '85248618-f314-4e25-ae50-ba7341c146ef');
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'fd22ce26-6e5a-45a7-ab37-2c5e0ca83777');
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '52b6c76f-3749-4494-9c91-1c311a544776');


/*ADMIN*/
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '4ab22cdc-0cf9-4354-92ab-68702d54ffd0');
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'd1519f54-f849-4543-816b-b24f4c5173e9');
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'c1e9ccd6-1d29-40a1-a544-f133a14dc246');

insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'b7a6d679-9ebc-4f8a-b5be-52aa35a2285c');
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '85248618-f314-4e25-ae50-ba7341c146ef');
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'fd22ce26-6e5a-45a7-ab37-2c5e0ca83777');
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '52b6c76f-3749-4494-9c91-1c311a544776');

insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '041ac4c7-3de5-4872-8059-bc9664a9de0a');






insert into countries(id,countryname) values ('61def168-6e1e-4d05-a077-a34fc7567351','China');
insert into countries(id,countryname) values ('3334fe2f-0f05-49db-8d55-07ebaec0069c','Taiwan');
insert into countries(id,countryname) values ('4bed491d-c09a-4286-9843-ce282c953212','Japan');
insert into countries(id,countryname) values ('b993964d-05cc-448f-9a7f-e4fefe302faa','Indien');

insert into rank(id, discount_in_percent, needed_seed_for_rank, rankname, default_rank) values ('0c555398-a391-428f-ad90-3345e30c5a2c',0,0,'Bronze', true);
insert into rank(id, discount_in_percent, needed_seed_for_rank, rankname, default_rank) values ('7eaac34f-d135-4123-be7d-3eea11190d40',4,20,'Silver', false);
insert into rank(id, discount_in_percent, needed_seed_for_rank, rankname, default_rank) values ('3f0816d5-f55c-4aee-819c-af5ae60b1d8f',7,60,'Gold', false);
insert into rank(id, discount_in_percent, needed_seed_for_rank, rankname, default_rank) values ('40cc3701-674c-4119-bde3-4eb03af4eac5',9,140,'Platinum', false);
insert into rank(id, discount_in_percent, needed_seed_for_rank, rankname, default_rank) values ('cd170d78-6728-4356-8ff5-7139275b85a7',10,300,'Diamond', false);

insert into categories(id, name, min_user_rank_required_rank_id, required_age) values ('df4cba5c-9722-481f-a03b-463688b71d9a','White','0c555398-a391-428f-ad90-3345e30c5a2c',0);
insert into categories(id, name, min_user_rank_required_rank_id, required_age) values ('4ca45fb3-4a70-4a61-aefa-71f61bcf87bd','Green','0c555398-a391-428f-ad90-3345e30c5a2c',0);
insert into categories(id, name, min_user_rank_required_rank_id, required_age) values ('cf455fd4-fded-41f9-bcf9-66815d4441b4','Medicinal Herbs','0c555398-a391-428f-ad90-3345e30c5a2c',18);
insert into categories(id, name, min_user_rank_required_rank_id, required_age) values ('55dd144d-ea05-49d7-a5bb-a023f98b5359','Raw Puerh','40cc3701-674c-4119-bde3-4eb03af4eac5',0);
insert into categories(id, name, min_user_rank_required_rank_id, required_age) values ('31258b76-4878-4bda-8990-c905e91299a5','Oolong','40cc3701-674c-4119-bde3-4eb03af4eac5',0);





insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('df12bf6e-0511-4fe6-bb26-56701eb23401',10,'ab Diamond','2022-08-09',20,'55dd144d-ea05-49d7-a5bb-a023f98b5359','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('02d7e89e-047b-4c4b-97c3-f3a51344c574',10,'ab Diamond','2022-08-09',20,'31258b76-4878-4bda-8990-c905e91299a5','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('01448200-629f-4c6f-8502-8b27a091310d',10,'MediWeed','2022-08-09',20,'cf455fd4-fded-41f9-bcf9-66815d4441b4','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('aa997b32-b308-4af5-a7a2-db5dd0eb9db3',10,'HUSO','2022-08-09',20,'df4cba5c-9722-481f-a03b-463688b71d9a','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('3ac4f653-1833-4ea6-99a0-1674fb5b25be',10,'HUSO','2022-08-09',20,'df4cba5c-9722-481f-a03b-463688b71d9a','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('3d4e15e6-311a-4dfb-948c-48cea3ff3f5a',10,'HUSO','2022-08-09',20,'df4cba5c-9722-481f-a03b-463688b71d9a','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('87633d6d-e0bb-4a73-a9ca-cf75039fb0bb',10,'HUSO','2022-08-09',20,'df4cba5c-9722-481f-a03b-463688b71d9a','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('c38452c6-8ae7-43b1-92e8-5db2f2b4a459',10,'HUSO','2022-08-09',20,'df4cba5c-9722-481f-a03b-463688b71d9a','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('8ece025c-0d4f-4a02-a2b4-3c2f3038113f',10,'HUSO','2022-08-09',20,'df4cba5c-9722-481f-a03b-463688b71d9a','61def168-6e1e-4d05-a077-a34fc7567351',10);
insert into products(id, buyingprice100g, description, harvestdate, sellingprice100g, category_id, country_id, nummber) values ('10e3e447-a7e5-41a3-8855-ee828798bb53',10,'HUSO','2022-08-09',20,'df4cba5c-9722-481f-a03b-463688b71d9a','61def168-6e1e-4d05-a077-a34fc7567351',10);





