package bacarotech.serie.springboot;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

public record PaginationDTO<T>(
        @JsonProperty(value = "dtos", required = true)
        List<T> dtos,
        @JsonProperty(value = "page_size", required = true)
        int pageSize,
        @JsonProperty(value = "page_number", required = true)
        int pageNumber,
        @JsonProperty(value = "total_pages", required = true)
        long totalPages,
        @JsonProperty(value = "total_count", required = true)
        long totalCount
) {
    public static <T, U> PaginationDTO<T> fromPage(Page<U> page, Function<U, T> mapper) {
        return new PaginationDTO<>(
                page.getContent().stream().map(mapper).toList(),
                page.getSize(),
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements()
        );
    }
}
