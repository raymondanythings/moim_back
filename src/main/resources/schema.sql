CREATE TABLE study
(
    study_seq              BIGINT AUTO_INCREMENT PRIMARY KEY            NOT NULL COMMENT '스터디 PK',
    title                  VARCHAR(20)                                  NOT NULL COMMENT '제목',
    content                VARCHAR(2000)                                NOT NULL COMMENT '내용',
    password               VARCHAR(250)                                 NULL COMMENT '패스워드',
    participation_fee_type ENUM ('FREE', 'CHARGED')                     NOT NULL COMMENT '요금 타입(무료/유료)',
    place_seq              BIGINT                                       NULL COMMENT '장소(스터디 카페) PK',
    point                  GEOMETRY                                     NOT NULL COMMENT '좌표(x,y)',
    price                  DECIMAL(38, 2)                               NULL COMMENT '가격',
    min_study_member_count INT                                          NOT NULL COMMENT '최소 스터디 인원',
    max_study_member_count INT                                          NOT NULL COMMENT '최대 스터디 인원',
    study_status           ENUM ('RECRUITING', 'CANCELLED', 'FINISHED') NOT NULL COMMENT '스터디 상태(모집 중/취소/종료)',
    user_seq               BIGINT                                       NOT NULL COMMENT '회원 PK(스터디 개설자)',
    created_at             DATETIME(6)                                  NOT NULL COMMENT '생성일',
    last_modified_at       DATETIME(6)                                  NULL COMMENT '최종 수정일',
    deleted                BOOLEAN                                      NOT NULL COMMENT '삭제 유무(참(1)/거짓(0))'
) ENGINE = InnoDB COMMENT '스터디';

CREATE TABLE study_member
(
    study_member_seq  BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '스터디 회원 PK',
    study_seq         BIGINT                            NOT NULL COMMENT '스터디 PK',
    user_seq          BIGINT                            NOT NULL COMMENT '회원 PK',
    study_member_role ENUM ('LEADER', 'NORMAL')         NOT NULL COMMENT '스터디 참여 회원 역할(리더/일반 참가자)',
    deleted           BOOLEAN                           NOT NULL COMMENT '삭제 유무(참(1)/거짓(0))',

    CONSTRAINT fk_study_study_seq FOREIGN KEY (study_seq) REFERENCES study (study_seq)
) ENGINE = InnoDB COMMENT '스터디 참여 회원';

CREATE TABLE study_hashtag
(
    study_hashtag_seq BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '스터디 해시태그 PK',
    study_seq         BIGINT                            NOT NULL COMMENT '스터디 PK',
    hashtag_seq       BIGINT                            NOT NULL COMMENT '해시태그 PK',
    created_at        DATETIME(6)                       NOT NULL COMMENT '생성일',
    last_modified_at  DATETIME(6)                       NULL COMMENT '최종 수정일',
    deleted           BOOLEAN                           NOT NULL COMMENT '삭제 유무(참(1)/거짓(0))',

    CONSTRAINT fk_study_study_seq FOREIGN KEY (study_seq) REFERENCES study (study_seq),
    CONSTRAINT fk_hashtag_hashtag_seq FOREIGN KEY (hashtag_seq) REFERENCES hashtag (hashtag_seq)
) ENGINE = InnoDB COMMENT '스터디 해시태그';

CREATE TABLE hashtag
(
    hashtag_seq       BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '해시태그 PK',
    hashtag_group_seq BIGINT                            NULL NULL COMMENT '해시태그 그룹 PK',
    tag_name          VARCHAR(15)                       NOT NULL COMMENT '태그명',
    created_at        DATETIME(6)                       NOT NULL COMMENT '생성일',
    last_modified_at  DATETIME(6)                       NULL COMMENT '최종 수정일'
) ENGINE = InnoDB COMMENT '해시태그';

CREATE TABLE hashtag_group
(
    hashtag_group_seq BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '해시태그 그룹 PK',
    hashtag_seq       BIGINT                            NOT NULL COMMENT '해시태그 PK',
    tag_group_seq     BIGINT                            NOT NULL COMMENT '태그 그룹 PK',
    group_name        VARCHAR(15)                       NOT NULL COMMENT '해시태그 그룹 이름',
    created_at        DATETIME(6)                       NOT NULL COMMENT '생성일',
    last_modified_at  DATETIME(6)                       NULL COMMENT '최종 수정일',

    CONSTRAINT fk_hashtag_hashtag_seq FOREIGN KEY (hashtag_seq) REFERENCES hashtag (hashtag_seq),
    CONSTRAINT fk_tag_group_tag_group_seq FOREIGN KEY (tag_group_seq) REFERENCES tag_group (tag_group_seq)
) ENGINE = InnoDB COMMENT '해시태그 그룹';


CREATE TABLE tag_group
(
    tag_group_seq    BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '태그 그룹 PK',
    group_name       VARCHAR(15)                       NOT NULL COMMENT '태그 그룹 이름',
    mobile_image_url VARCHAR(1500)                     NULL COMMENT '모바일/패드 이미지',
    pc_image_url     VARCHAR(1500)                     NULL COMMENT 'PC 이미지',
    created_at       DATETIME(6)                       NOT NULL COMMENT '생성일',
    last_modified_at DATETIME(6)                       NULL COMMENT '최종 수정일'
) ENGINE = InnoDB COMMENT '태그 그룹';

CREATE TABLE study_bookmark
(
    study_bookmark_seq BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT '스터디 북마크 PK',
    study_seq          BIGINT                            NOT NULL COMMENT '스터디 PK',
    user_seq           BIGINT                            NOT NULL COMMENT '회원 PK',
    created_at         DATETIME(6)                       NOT NULL COMMENT '생성일',
    last_modified_at   DATETIME(6)                       NULL COMMENT '최종 수정일',
    deleted            BOOLEAN                           NOT NULL COMMENT '삭제 유무(참(1)/거짓(0))',

    CONSTRAINT fk_study_study_seq FOREIGN KEY (study_seq) REFERENCES study (study_seq)
) ENGINE = InnoDB COMMENT '스터디 북마크';
