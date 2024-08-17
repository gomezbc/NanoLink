package eus.borjagomez.nanolink.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class UrlMapping {

    @Id
    private String mappingId;
    private String longUrl;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp createdDate;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp updatedDate;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp expiryDate;
    @Temporal(TemporalType.TIMESTAMP) private Timestamp lastHitDate;
    private long hitCount;
    private String createdBy;
    private String updatedBy;

    @Override
    public final boolean equals(Object o) {
        if (this.getClass() != o.getClass()) {
            return false;
        }
        if (this == o) return true;
        Class<?> oEffectiveClass = ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass();
        Class<?> thisEffectiveClass = ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UrlMapping that = (UrlMapping) o;
        return getMappingId() != null && Objects.equals(getMappingId(), that.getMappingId());
    }

    @Override
    public final int hashCode() {
        return ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode();
    }
}
