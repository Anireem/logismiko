package com.logismiko.docs_auto_fill.api.models.requests;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

/**
 * OrganizationEntity request declaration.
 */
public record OrganizationRequestDto(
    @Schema(description = "Комментарий", example = "Не приоритетный клиент")
    String comment,

    @Schema(description = "Имя контакта", example = "Миллер Алексей")
    String contactName,

    @Schema(description = "Email", example = "mail@gazprom.ru")
    String email,

    @Schema(description = "ИНН", example = "7736050003")
    String inn,

    @Schema(description = "КПП", example = "781401001")
    String kpp,

    @Schema(
        description = "Полное имя",
        example = "ПУБЛИЧНОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО \"ГАЗПРОМ\""
    )
    String longName,

    @Schema(description = "ОГРН", example = "1027700070518")
    String ogrn,

    @Schema(description = "ОКПО", example = "00040778")
    String okpo,

    @Schema(description = "ОКВЭД", example = "46.71")
    String okved,

    @Schema(description = "Телефон", example = "8-495-464-41-12")
    String phone,

    @Schema(description = "Сокращенное имя", example = "ПАО \"Газпром\"")
    String shortName,

    @NotBlank(message = "Vue is required field")
    @NotNull(message = "Vue is required field")
    @Schema(
        description = "Представление",
        example = "Газпром",
        requiredMode = REQUIRED
    )
    String view
) {
}
