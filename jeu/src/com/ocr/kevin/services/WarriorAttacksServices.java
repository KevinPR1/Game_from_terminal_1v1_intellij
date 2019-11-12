package com.ocr.kevin.services;

import com.ocr.kevin.characters.User;

public class WarriorAttacksServices implements WarriorSaervice{
    @Override
    public void performBasicAttack(User user,User userc) {
        user.setHealthpoint(user.getHealthpoint() - userc.getStrength());
    }

    @Override
    public void performSpecialAttack(User user,User userc) {
        user.setHealthpoint(user.getHealthpoint() - userc.getStrength()*2);
        userc.setHealthpoint(userc.getHealthpoint() - userc.getStrength()/2);
    }
}
