package dao;

import domain.information;

import java.util.List;

public interface affectedPeopleDao {
    void saveAffectedPeople(information affected );
    List<information> getaffected(String page);
}
