package br.com.skywalker.plugboleto.assignor;

import br.com.skywalker.plugboleto.assignor.domain.ListedAssignor;
import br.com.skywalker.plugboleto.common.BasePageableService;
import br.com.skywalker.plugboleto.common.PagedResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

interface AssignorService extends BasePageableService {
    @GET(Endpoints.BASE)
    Call<PagedResponse<ListedAssignor>> findAll();
}
