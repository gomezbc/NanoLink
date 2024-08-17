package eus.borjagomez.nanolink.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUrlMappingRequest {

    @NotNull
    @Size(min = 1, max = 2048)
    private String mappingId;
    @NotNull
    @Size(min = 1, max = 2048)
    private String longUrl;
    private Timestamp expiryDate;
    @NotNull
    @NotEmpty
    private String createdBy;
}
