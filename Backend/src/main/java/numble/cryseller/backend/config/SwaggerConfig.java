package numble.cryseller.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "CrySeller API 명세서",
                description = "Spring Boot로 타임딜 서버 만들기 챌린지",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    public GroupedOpenApi groupedOpenApi() {
        String[] paths = {"/v1/**"};
        return GroupedOpenApi.builder()
                .group("CrySeller API v1")
                .pathsToMatch(paths)
                .build();
    }
}
