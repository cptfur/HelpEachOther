package dao;

import domain.information;

import java.util.List;

public interface helperDao {
    void saveHelper(information heler );
    List<information> getahelper(String page);
}
