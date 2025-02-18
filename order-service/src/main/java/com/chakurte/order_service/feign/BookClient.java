package com.chakurte.order_service.feign;

import com.chakurte.order_service.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="book-service")
public interface BookClient {
    @GetMapping("/api/book/id")
    Book getBookById(@RequestParam int id);

}
