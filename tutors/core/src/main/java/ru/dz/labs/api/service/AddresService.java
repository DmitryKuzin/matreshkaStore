package ru.dz.labs.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dz.labs.api.domain.Addres;
import ru.dz.labs.api.repository.AddressRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kuzin on 13.12.2015.
 */
@Service
public class AddresService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void addAddres(Addres addres){
        addressRepository.addAddres(addres);
    }
    @Transactional
    public void deleteAddres(Addres addres){
        addressRepository.deleteAddres(addres);
    }
    @Transactional
    public void updateAddres(Addres addres){
        addressRepository.updateAddres(addres);
    }
    @Transactional
    public Addres getAddresById(Long id){
        return addressRepository.getAddresById(id);
    }
    @Transactional
    public List<Addres> getAllAddresses(){
        return addressRepository.getAllAddresses();
    }

}
