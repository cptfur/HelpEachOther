package dao;

import domain.COVID19;

public interface cityDao {
    COVID19 findCovid19(String city);
}
