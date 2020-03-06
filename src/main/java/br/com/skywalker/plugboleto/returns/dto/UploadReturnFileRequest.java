package br.com.skywalker.plugboleto.returns.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import retrofit2.Call;

@Getter
@Builder

public class UploadReturnFileRequest {
    @JsonProperty("arquivo")
    private String file;
}

/*
{
  "arquivo": [base64 file],
}
*/
