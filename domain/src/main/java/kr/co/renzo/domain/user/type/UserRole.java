package kr.co.renzo.domain.user.type;

import kr.co.renzo.core.type.EnumType;
import lombok.Getter;

@Getter
public enum UserRole implements EnumType {
    ADMIN("관리자"), USER("회원");

    private String description;

    UserRole(String description) {
        this.description = description;
    }

    @Override
    public String getValue() {
        return this.name();
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
