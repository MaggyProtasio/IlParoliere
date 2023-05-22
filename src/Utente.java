/**
 * Copyright (c) 2023, Anastasiya Kozemko, Alice Minuzzo, Brend Margarette Protasio
 * All rights reserved.
 *
 * This file is part of the WordCraft project.
 */

public class Utente {
    private String nickname;
    public Utente(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
