package br.com.skywalker.plugboleto.account;

import br.com.skywalker.plugboleto.account.dto.ListedAccount;
import br.com.skywalker.plugboleto.common.PagedResponse;

public class AccountPagedResponse extends PagedResponse<ListedAccount> {
    public AccountPagedResponse(InternalAccountService accountService) {
        super(accountService::getPage);
    }
}
