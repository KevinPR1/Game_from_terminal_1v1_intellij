package com.ocr.kevin.services;

import com.ocr.kevin.characters.User;

public class ArcherAttacksServices implements ArcherService{
    @Override
    public void performBasicAttack(User user,User userc) {
        user.setHealthpoint(user.getHealthpoint()-userc.getAgility());
    }

    @Override
    public void performSpecialAttack(User user) {
        user.setAgility(user.getAgility() + user.getLevel()/2);
    }
}
