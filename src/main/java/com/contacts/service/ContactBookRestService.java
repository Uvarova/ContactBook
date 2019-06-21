package com.contacts.service;
/*
 * created by ellen
 * created on 21.06.2019
 * class created for project ContactBook
 */

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface ContactBookRestService {
        HttpEntity setHeaders();
        String sendGetRequest(String url, Map<String, String> param);
        String sendGetRequest(String url);
        String sendPostRequest(String url, String body);
        String sendPatchRequest(String url);
        String sendPatchRequest(String url, String body);
        String sendDeleteRequest(String url);
}
