package br.com.skywalker.plugboleto.assignor;

import retrofit2.Retrofit;

public class AssignorResource {
    private AssignorService assignorService;

    public AssignorResource(Retrofit retrofit) {
        this.assignorService = retrofit.create(AssignorService.class);
    }

}
