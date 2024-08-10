package eus.borjagomez.nanolink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Data
@ToString
public class UrlMapping {

    @Id
    private String mappingId;
    private String longUrl;
    private String shortUrl;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp createdDate;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp updatedDate;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp expiryDate;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp lastHitDate;
    private long hitCount;
    private String createdBy;
    private String updatedBy;

}
