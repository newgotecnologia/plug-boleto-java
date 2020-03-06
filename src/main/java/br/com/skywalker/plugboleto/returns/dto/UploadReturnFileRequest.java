package br.com.skywalker.plugboleto.returns.dto;

import br.com.skywalker.plugboleto.common.Request;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import retrofit2.Call;

@Getter
@Builder

public class UploadReturnFileRequest extends Request<UploadReturnFileRequest> {
    @JsonProperty("arquivo")
    private String file;

    public UploadReturnFileRequest(Call<UploadReturnFileRequest> call) {
        super(call);
    }
}

/*
{
  "arquivo": [base64 file],
}
*/
