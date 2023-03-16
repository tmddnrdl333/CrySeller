package numble.cryseller.backend.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.ItemRequestDto;
import numble.cryseller.backend.api.dto.ItemResponseDto;
import numble.cryseller.backend.api.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "상품관리", description = "상품관리 API 입니다.")
@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @Operation(summary = "상품등록", description = "상품의 상세정보를 입력하여 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = ItemResponseDto.ItemInfoRes.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @PostMapping("/register")
    public ResponseEntity<ItemResponseDto.ItemInfoRes> registerItem(@RequestBody ItemRequestDto.ItemInfoReq itemInfoReq) {
        ItemResponseDto.ItemInfoRes itemInfoRes = itemService.registerItem(itemInfoReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemInfoRes);
    }

    @Operation(summary = "상품수정", description = "상품의 상세정보를 입력내용으로 변경합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ItemResponseDto.ItemInfoRes.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @PostMapping("/modify/{no}")
    public ResponseEntity<ItemResponseDto.ItemInfoRes> modifyItem(@Parameter(name = "no") @PathVariable("no") int no, @RequestBody ItemRequestDto.ItemInfoReq itemInfoReq) {
        ItemResponseDto.ItemInfoRes itemInfoRes = itemService.modifyItem(no, itemInfoReq);
        return ResponseEntity.status(HttpStatus.OK).body(itemInfoRes);
    }


    @Operation(summary = "상품삭제", description = "(관리자/판매자)상품을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @GetMapping("/delete/{no}")
    public ResponseEntity<Object> deleteItem(@Parameter(name = "no") @PathVariable("no") int no) {
        itemService.deleteItem(no);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @Operation(summary = "상품목록 조회", description = "상품의 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @GetMapping
    public ResponseEntity<List<ItemResponseDto.ItemInfoRes>> getItemList() {
        List<ItemResponseDto.ItemInfoRes> itemInfoResList = itemService.getItemList();
        return ResponseEntity.status(HttpStatus.OK).body(itemInfoResList);
    }

    @Operation(summary = "상품정보 조회", description = "특정 상품의 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ItemResponseDto.ItemInfoRes.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Object.class))),
    })
    @GetMapping("/{no}")
    public ResponseEntity<ItemResponseDto.ItemInfoRes> getItemDetail(@Parameter(name = "no") @PathVariable("no") int no) {
        ItemResponseDto.ItemInfoRes itemInfoRes = itemService.getItemDetail(no);
        return ResponseEntity.status(HttpStatus.OK).body(itemInfoRes);
    }
}
