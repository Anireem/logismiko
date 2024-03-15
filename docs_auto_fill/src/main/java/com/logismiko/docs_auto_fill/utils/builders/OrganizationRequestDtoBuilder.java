package com.logismiko.docs_auto_fill.utils.builders;

import com.logismiko.docs_auto_fill.api.models.requests.OrganizationRequestDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

public final class OrganizationRequestDtoBuilder {
    private @Schema(description = "Комментарий", example = "Не приоритетный клиент") String comment;
    private @Schema(description = "Имя контакта", example = "Миллер Алексей") String contactName;
    private @Email(message = "Email должен быть в правильном формате")
    @Schema(description = "Email", example = "mail@gazprom.ru") String email;
    private @Schema(description = "ИНН", example = "7736050003") String inn;
    private @Schema(description = "КПП", example = "781401001") String kpp;
    private @Schema(
        description = "Полное имя",
        example = "ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"ГАЗПРОМ\""
    ) String longName;
    private @Schema(description = "ОГРН", example = "1027700070518") String ogrn;
    private @Schema(description = "ОКПО", example = "00040778") String okpo;
    private @Schema(description = "ОКВЭД", example = "46.71") String okved;
    private @Schema(description = "Телефон", example = "8-495-464-41-12") String phone;
    private @Schema(description = "Сокращенное имя", example = "ПАО \"Газпром\"") String shortName;
    private @NotBlank(message = "Vue - обязательно к заполнению") @NotNull(message = "Vue - обязательно к заполнению")
    @Schema(
        description = "Представление",
        example = "Газпром",
        requiredMode = REQUIRED
    ) String view;

    private OrganizationRequestDtoBuilder() {
    }

    public static OrganizationRequestDtoBuilder anOrganizationRequestDto() {
        return new OrganizationRequestDtoBuilder();
    }

    public OrganizationRequestDtoBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public OrganizationRequestDtoBuilder withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public OrganizationRequestDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public OrganizationRequestDtoBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public OrganizationRequestDtoBuilder withKpp(String kpp) {
        this.kpp = kpp;
        return this;
    }

    public OrganizationRequestDtoBuilder withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    public OrganizationRequestDtoBuilder withOgrn(String ogrn) {
        this.ogrn = ogrn;
        return this;
    }

    public OrganizationRequestDtoBuilder withOkpo(String okpo) {
        this.okpo = okpo;
        return this;
    }

    public OrganizationRequestDtoBuilder withOkved(String okved) {
        this.okved = okved;
        return this;
    }

    public OrganizationRequestDtoBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public OrganizationRequestDtoBuilder withShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public OrganizationRequestDtoBuilder withView(String view) {
        this.view = view;
        return this;
    }

    public OrganizationRequestDto build() {
        return new OrganizationRequestDto(comment, contactName, email, inn, kpp, longName, ogrn, okpo, okved, phone, shortName, view);
    }
}
