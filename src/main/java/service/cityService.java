package service;

import domain.COVID19;

public interface cityService {
    COVID19 findByCity(String city);
}
