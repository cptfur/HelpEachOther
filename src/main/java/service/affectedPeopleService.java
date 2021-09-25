package service;

import domain.information;

import java.util.List;

public interface affectedPeopleService {
    void saveAffected(information information);
    List<information> getAffected(String page);

}
