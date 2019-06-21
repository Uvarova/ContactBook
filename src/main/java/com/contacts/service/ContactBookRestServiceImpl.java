package com.contacts.service;
/*
 * created by ellen
 * created on 21.06.2019
 * class created for project ContactBook
 */

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ContactBookRestServiceImpl implements ContactBookRestService {

    private RestTemplate template = new RestTemplate();

    @Override
    public HttpEntity setHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity(null, httpHeaders);
    }

    @Override
    public String sendGetRequest(String url, Map<String, String> param) {
        return null;
    }

    @Override
    public String sendGetRequest(String url) {
        return null;
    }

    @Override
    public String sendPostRequest(String url, String body) {
        return null;
    }

    @Override
    public String sendPatchRequest(String url) {
        String result=null;
        ResponseEntity<String> entity =null;
        try {
            entity = template.exchange(url, HttpMethod.PATCH, new HttpEntity<>("", setHeaders().getHeaders()), String.class);
            System.out.println(entity.getStatusCode());
            result = entity.getBody();
        } catch(HttpClientErrorException e){
           // new StatusCodeFactory().exceptionFactory(e.getStatusCode().value());
        }
        return result;
    }

    @Override
    public String sendPatchRequest(String url, String body) {
        String result=null;
        ResponseEntity<String> entity =null;
        try {
            entity = template.exchange(url, HttpMethod.PATCH, new HttpEntity<>(body, setHeaders().getHeaders()), String.class);
            System.out.println(entity.getStatusCode());
            result = entity.getBody();
        } catch(HttpClientErrorException e){
           // new StatusCodeFactory().exceptionFactory(e.getStatusCode().value());
        }
        return result;
    }

    @Override
    public String sendDeleteRequest(String url) {
        return null;
    }
}
