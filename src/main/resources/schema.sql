CREATE TABLE url_mapping
(
    mapping_id    VARCHAR(255) NOT NULL,
    long_url      VARCHAR(255),
    created_date  TIMESTAMP WITHOUT TIME ZONE,
    updated_date  TIMESTAMP WITHOUT TIME ZONE,
    expiry_date   TIMESTAMP WITHOUT TIME ZONE,
    last_hit_date TIMESTAMP WITHOUT TIME ZONE,
    hit_count     BIGINT       NOT NULL,
    created_by    VARCHAR(255),
    updated_by    VARCHAR(255),
    CONSTRAINT pk_urlmapping PRIMARY KEY (mapping_id)
);