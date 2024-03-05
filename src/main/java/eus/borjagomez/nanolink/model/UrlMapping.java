package eus.borjagomez.nanolink.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlMapping {

    @PrimaryKey
    private String mappingId;
    private String longUrl;
    private String shortUrl;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp expiryDate;
    private Timestamp lastHitDate;
    private int hitCount;
    private String createdBy;
    private String updatedBy;

}
