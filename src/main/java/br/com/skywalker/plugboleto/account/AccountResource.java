package br.com.skywalker.plugboleto.account;

import br.com.skywalker.plugboleto.Registry;
import br.com.skywalker.plugboleto.account.dto.CreateAccountRequest;
import br.com.skywalker.plugboleto.account.dto.CreateAccountResponse;
import br.com.skywalker.plugboleto.common.Request;
import retrofit2.Retrofit;

class AccountResource {
    public static final String ACCOUNT_SERVICE_KEY = "ACCOUNT_SERVICE";

    public AccountResource(Retrofit retrofit) {
        Registry.set(ACCOUNT_SERVICE_KEY, retrofit.create(AccountService.class));
    }

    public Request<AccountPagedResponse> findAll() {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, AccountService.class).findAll());
    }

    public Request<AccountPagedResponse> findAll(long pageNum, long pageSize) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, AccountService.class).findAll());
    }

    public Request<AccountPagedResponse> findById(Long id) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, AccountService.class).findAll());
    }

    public Request<CreateAccountResponse> create(CreateAccountRequest request, String assignorFederalId) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, AccountService.class).create(request, assignorFederalId));
    }

    public Request<CreateAccountResponse> update(CreateAccountRequest request, String assignorFederalId, long id) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, AccountService.class).update(request, assignorFederalId, id));
    }

    public Request<?> delete(String assignorFederalId, long id) {
        return new Request<>(Registry.get(ACCOUNT_SERVICE_KEY, AccountService.class).delete(assignorFederalId, id));
    }
}
