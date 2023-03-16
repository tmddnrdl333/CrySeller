package numble.cryseller.backend.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.CategoryResponseDto;
import numble.cryseller.backend.api.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "카테고리", description = "카테고리 관련 API 입니다.")
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @Operation(summary = "카테고리 목록조회", description = "전체 카테고리의 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto.NoAndNameRes>> getCategoryList() {
        List<CategoryResponseDto.NoAndNameRes> noAndNameResList = categoryService.getCategoryList();
        return ResponseEntity.status(HttpStatus.OK).body(noAndNameResList);
    }

    @Operation(summary = "카테고리 상세조회", description = "카테고리 번호로 상세 내용을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CategoryResponseDto.NoAndNameRes.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @GetMapping("/{no}")
    public ResponseEntity<CategoryResponseDto.NoAndNameRes> getCategoryDetail(@Parameter(name = "no") @PathVariable("no") int no) {
        CategoryResponseDto.NoAndNameRes noAndNameRes = categoryService.getCategoryDetail(no);
        return ResponseEntity.status(HttpStatus.OK).body(noAndNameRes);
    }
}
