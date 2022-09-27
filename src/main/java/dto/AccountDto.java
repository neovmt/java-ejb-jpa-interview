package dto;

public class AccountDto {

    private final Integer id;
    private final String name;
    private final Integer version;

    public AccountDto(Integer id, String name, Integer version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }
}
