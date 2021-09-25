package service;

import domain.message;

import java.util.List;

public interface IndexService {
    public List<message> findMessages(String address);
}