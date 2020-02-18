package br.com.skywalker.plugboleto.assignor;

import br.com.skywalker.plugboleto.assignor.dto.ListedAssignor;
import br.com.skywalker.plugboleto.common.PagedResponse;

public class AssignorPagedResponse extends PagedResponse<ListedAssignor> {

    public AssignorPagedResponse(InternalAssignorService assignorService) {
        super(assignorService::getPage);
    }

}
