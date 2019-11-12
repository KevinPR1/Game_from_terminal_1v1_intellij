package com.ocr.kevin.services;

import com.ocr.kevin.characters.User;

public class WizardAttacksServices implements WizardService{
    @Override
    public void performBasicAttack(User user,User userc) {
        user.setHealthpoint(user.getHealthpoint() - userc.getIntelligence());
    }

    @Override
    public void performSpecialAttack(User user) {
        if (user.getHealthpoint() < user.getLevel()*5 && (user.getHealthpoint() + user.getIntelligence() * 2) <= user.getLevel()*5) {
            user.setHealthpoint(user.getHealthpoint() + user.getIntelligence() * 2);
        }
    }
}
