package it.aulab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import it.aulab.Arm;
import it.aulab.Jeeg;
import it.aulab.Leg;
import it.aulab.repositories.JeegRepository;

// @Component("jeegService")
@Service("jeegService")
public class JeegServiceImpl implements JeegService {


    @Autowired
    private JeegRepository jeegRepository;

    // public JeegRepository getJeegRepository() {
    //     return jeegRepository;
    // }

    // public void setJeegRepository(JeegRepository jeegRepository) {
    //     this.jeegRepository = jeegRepository;
    // }

    // public JeegServiceImpl(JeegRepository jeegRepository) {
    //     this.jeegRepository = jeegRepository;
    // }

    @Override
    public void attack() {
        //System.out.println("Jeeg attacca!");

        Jeeg jeeg = jeegRepository.getJeeg();
        Arm armSx = jeeg.getArmSx();
        Arm armDx = jeeg.getArmDx();

        armSx.attack();
        armDx.attack();
    }

    @Override
    public void move() {
        //System.out.println("Jeeg cammina!");
        Jeeg jeeg = jeegRepository.getJeeg();
        Leg legSx = jeeg.getLegSx();
        Leg legDx = jeeg.getLegDx();

        legSx.walk();
        legDx.walk();
    }

}
