CREATE TABLE IF NOT EXISTS url_mappings (
    mapping_id TEXT PRIMARY KEY,
    long_url TEXT,
    short_url TEXT,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    expiry_date TIMESTAMP,
    last_hit_date TIMESTAMP,
    hit_count INT,
    created_by TEXT,
    updated_by TEXT
);
