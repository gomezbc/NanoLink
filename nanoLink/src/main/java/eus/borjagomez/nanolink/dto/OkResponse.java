package eus.borjagomez.nanolink.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class OkResponse {

    private String statusCode;
    private String statusMsg;
}
