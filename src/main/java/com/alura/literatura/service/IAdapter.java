package com.alura.literatura.service;

public interface IAdapter {
    <T> T getDataFromJson(String json, Class<T> clase);

}
