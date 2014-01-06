# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table proposal (
  id                        bigint auto_increment not null,
  title                     varchar(255),
  proposal                  varchar(1000),
  sesstype                  integer,
  keywords                  varchar(255),
  isapproved                tinyint(1) default 0,
  speaker_id                bigint,
  constraint ck_proposal_sesstype check (sesstype in (0,1)),
  constraint pk_proposal primary key (id))
;

create table speaker (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  bio                       varchar(1000),
  email                     varchar(255),
  twitterid                 varchar(255),
  pictureurl                varchar(255),
  constraint pk_speaker primary key (id))
;

alter table proposal add constraint fk_proposal_speaker_1 foreign key (speaker_id) references speaker (id) on delete restrict on update restrict;
create index ix_proposal_speaker_1 on proposal (speaker_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table proposal;

drop table speaker;

SET FOREIGN_KEY_CHECKS=1;

