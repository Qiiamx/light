--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-04-19 13:22:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 16388)
-- Name: light; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA light;


ALTER SCHEMA light OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 223 (class 1259 OID 16418)
-- Name: audit_record; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.audit_record (
    id bigint NOT NULL,
    game_id bigint,
    report_id bigint,
    verify_user_id bigint,
    verify_status smallint,
    audit_time timestamp without time zone,
    verify_time timestamp without time zone,
    audit_user_id bigint,
    audit_status smallint
);


ALTER TABLE light.audit_record OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16401)
-- Name: credit; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.credit (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    score smallint NOT NULL
);


ALTER TABLE light.credit OWNER TO postgres;

--
-- TOC entry 4938 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE credit; Type: COMMENT; Schema: light; Owner: postgres
--

COMMENT ON TABLE light.credit IS '信用表';


--
-- TOC entry 219 (class 1259 OID 16394)
-- Name: credit_record; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.credit_record (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    score smallint NOT NULL,
    rmks text,
    create_time timestamp without time zone
);


ALTER TABLE light.credit_record OWNER TO postgres;

--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 219
-- Name: TABLE credit_record; Type: COMMENT; Schema: light; Owner: postgres
--

COMMENT ON TABLE light.credit_record IS '信用变更记录';


--
-- TOC entry 225 (class 1259 OID 16437)
-- Name: game; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.game (
    id bigint NOT NULL,
    name character varying(50)
);


ALTER TABLE light.game OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16411)
-- Name: report_record; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.report_record (
    id bigint NOT NULL,
    game_id bigint,
    report_time timestamp without time zone,
    report_url text,
    report_remark text,
    report_user_id bigint,
    report_status smallint,
    verify_status smallint,
    name character varying(50)
);


ALTER TABLE light.report_record OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16406)
-- Name: share; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.share (
    id bigint NOT NULL,
    valid_type smallint NOT NULL,
    valid_time timestamp without time zone NOT NULL,
    share_type smallint NOT NULL,
    share_user_id bigint NOT NULL,
    valid_count smallint
);


ALTER TABLE light.share OWNER TO postgres;

--
-- TOC entry 4940 (class 0 OID 0)
-- Dependencies: 221
-- Name: TABLE share; Type: COMMENT; Schema: light; Owner: postgres
--

COMMENT ON TABLE light.share IS '邀请表';


--
-- TOC entry 224 (class 1259 OID 16426)
-- Name: share_record; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.share_record (
    id bigint NOT NULL,
    share_id bigint NOT NULL,
    use_user_id bigint NOT NULL,
    use_time timestamp without time zone
);


ALTER TABLE light.share_record OWNER TO postgres;

--
-- TOC entry 4941 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE share_record; Type: COMMENT; Schema: light; Owner: postgres
--

COMMENT ON TABLE light.share_record IS '邀请记录表';


--
-- TOC entry 218 (class 1259 OID 16389)
-- Name: sys_user; Type: TABLE; Schema: light; Owner: postgres
--

CREATE TABLE light.sys_user (
    id bigint NOT NULL,
    nick_name character varying(20) NOT NULL,
    user_type smallint NOT NULL,
    third_id character varying(50),
    third_type character varying(10),
    enable smallint
);


ALTER TABLE light.sys_user OWNER TO postgres;

--
-- TOC entry 4942 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE sys_user; Type: COMMENT; Schema: light; Owner: postgres
--

COMMENT ON TABLE light.sys_user IS '系统用户';


--
-- TOC entry 4781 (class 2606 OID 16422)
-- Name: audit_record audit_record_dto_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.audit_record
    ADD CONSTRAINT audit_record_dto_pkey PRIMARY KEY (id);


--
-- TOC entry 4775 (class 2606 OID 16405)
-- Name: credit credit_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.credit
    ADD CONSTRAINT credit_pkey PRIMARY KEY (id);


--
-- TOC entry 4773 (class 2606 OID 16400)
-- Name: credit_record credit_record_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.credit_record
    ADD CONSTRAINT credit_record_pkey PRIMARY KEY (id);


--
-- TOC entry 4787 (class 2606 OID 16441)
-- Name: game game_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.game
    ADD CONSTRAINT game_pkey PRIMARY KEY (id);


--
-- TOC entry 4779 (class 2606 OID 16417)
-- Name: report_record report_record_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.report_record
    ADD CONSTRAINT report_record_pkey PRIMARY KEY (id);


--
-- TOC entry 4777 (class 2606 OID 16410)
-- Name: share share_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.share
    ADD CONSTRAINT share_pkey PRIMARY KEY (id);


--
-- TOC entry 4783 (class 2606 OID 16430)
-- Name: share_record share_record_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.share_record
    ADD CONSTRAINT share_record_pkey PRIMARY KEY (id);


--
-- TOC entry 4785 (class 2606 OID 16436)
-- Name: share_record share_record_unique; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.share_record
    ADD CONSTRAINT share_record_unique UNIQUE (share_id, use_user_id);


--
-- TOC entry 4943 (class 0 OID 0)
-- Dependencies: 4785
-- Name: CONSTRAINT share_record_unique ON share_record; Type: COMMENT; Schema: light; Owner: postgres
--

COMMENT ON CONSTRAINT share_record_unique ON light.share_record IS '单个邀请\单个用户只能用一次';


--
-- TOC entry 4771 (class 2606 OID 16393)
-- Name: sys_user sys_user_pkey; Type: CONSTRAINT; Schema: light; Owner: postgres
--

ALTER TABLE ONLY light.sys_user
    ADD CONSTRAINT sys_user_pkey PRIMARY KEY (id);


-- Completed on 2025-04-19 13:22:29

--
-- PostgreSQL database dump complete
--

