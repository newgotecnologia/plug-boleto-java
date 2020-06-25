package br.com.skywalker.plugboleto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagedResponseMetadata {

    @JsonProperty("_itens_por_pagina")
    private int pageSize;

    @JsonProperty("_total")
    private int total;

    private String nextPageUrl;
    private String previousPageUrl;

    public boolean hasNext() {
        return null != nextPageUrl;
    }

    public boolean hasPrevious() {
        return null != previousPageUrl;
    }

    @JsonProperty("_paginacao")
    private void unpackPagination(Map<String, Object> pagination) {
        Object next = pagination.getOrDefault("_proximo", null);
        Object previous = pagination.getOrDefault("_anterior", null);

        if (next instanceof String) {
            this.nextPageUrl = (String) next;
        }

        if (previous instanceof String) {
            this.previousPageUrl = (String) previous;
        }
    }
}
