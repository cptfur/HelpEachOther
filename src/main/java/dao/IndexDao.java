package dao;

import domain.message;

import java.util.List;

public interface IndexDao {
    List<message> findMessage(String address);
}
