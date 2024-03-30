package eus.borjagomez.nanolink.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table("url_mappings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlMapping {

    @PrimaryKey
    @Column("mapping_id")
    private String mappingId;
    @Column("long_url")
    private String longUrl;
    @Column("short_url")
    private String shortUrl;
    @Column("created_date")
    private Timestamp createdDate;
    @Column("updated_date")
    private Timestamp updatedDate;
    @Column("expiry_date")
    private Timestamp expiryDate;
    @Column("last_hit_date")
    private Timestamp lastHitDate;
    @Column("hit_count")
    private int hitCount;
    @Column("created_by")
    private String createdBy;
    @Column("updated_by")
    private String updatedBy;

}
