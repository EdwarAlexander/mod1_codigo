package com.codigo.edwar_moran.service;

import java.util.List;

public interface CrudService<RQ,RS,ID>{
    RS create(RQ request);
    RS update(RQ request, ID id);
    RS findByID(ID id);
    List<RS> findAll();
    void delete(ID id);
}
