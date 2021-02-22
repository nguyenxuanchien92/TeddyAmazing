package com.cg.teddyamazing.model.account;

public enum LevelRole {
    ROLE_USER(2L), ROLE_ADMIN(1L);
    public final Long value;

    private LevelRole(Long value) {
        this.value = value;
    }
}
