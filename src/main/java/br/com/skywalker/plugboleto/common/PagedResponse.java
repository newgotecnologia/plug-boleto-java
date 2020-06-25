package br.com.skywalker.plugboleto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import retrofit2.Call;

import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PagedResponse<T> extends Response<List<T>> {

    private Function<String, Call<? extends PagedResponse<T>>> pageProvider;

    @Getter
    @JsonProperty("_meta")
    private PagedResponseMetadata metadata;

    public PagedResponse(Function<String, Call<? extends PagedResponse<T>>> pageProvider){
        this.pageProvider = pageProvider;
    }

    public PagedResponse(ResponseStatus status, String message, List<T> data, Function<String, Call<? extends PagedResponse<T>>> pageProvider) {
        super(status, message, data);
        this.pageProvider = pageProvider;
    }

    public Request<? extends PagedResponse<T>> next() throws IllegalStateException {
        if (!this.getMetadata().hasNext()) throw new IllegalStateException("There is no next page");
        return new Request<>(pageProvider.apply(this.getMetadata().getNextPageUrl()));
    }

    public Request<? extends PagedResponse<T>> previous() throws IllegalStateException {
        if (!this.getMetadata().hasPrevious()) throw new IllegalStateException("There is no previous page");
        return new Request<>(pageProvider.apply(this.getMetadata().getPreviousPageUrl()));
    }

}
