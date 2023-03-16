package numble.cryseller.backend.api.service;

import lombok.RequiredArgsConstructor;
import numble.cryseller.backend.api.dto.ItemRequestDto;
import numble.cryseller.backend.api.dto.ItemResponseDto;
import numble.cryseller.backend.domain.entity.Category;
import numble.cryseller.backend.domain.entity.Item;
import numble.cryseller.backend.domain.repository.CategoryRepository;
import numble.cryseller.backend.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    public ItemResponseDto.ItemInfoRes registerItem(ItemRequestDto.ItemInfoReq itemInfoReq) {
        Category category = categoryRepository.findByNo(itemInfoReq.getCategory_no());
        return new ItemResponseDto.ItemInfoRes(
                itemRepository.save(
                        Item.builder()
                                .category(category)
                                .name(itemInfoReq.getName())
                                .imgLink(itemInfoReq.getImgLink())
                                .quantity(itemInfoReq.getQuantity())
                                .price(itemInfoReq.getPrice())
                                .discountRate(itemInfoReq.getDiscountRate())
                                .info(itemInfoReq.getInfo())
                                .availableDateTime(itemInfoReq.getAvailableDateTime())
                                .build()
                )
        );
    }

    public ItemResponseDto.ItemInfoRes modifyItem(int no, ItemRequestDto.ItemInfoReq itemInfoReq) {
        Item item = itemRepository.findByNo(no);
        Category category = categoryRepository.findByNo(itemInfoReq.getCategory_no());
        return new ItemResponseDto.ItemInfoRes(
                itemRepository.save(
                        Item.builder()
                                .no(item.getNo())
                                .category(category)
                                .name(itemInfoReq.getName())
                                .imgLink(itemInfoReq.getImgLink())
                                .quantity(itemInfoReq.getQuantity())
                                .price(itemInfoReq.getPrice())
                                .discountRate(itemInfoReq.getDiscountRate())
                                .info(itemInfoReq.getInfo())
                                .registerDateTime(item.getRegisterDateTime()) // TODO: 이거 필요한가? 있어도 되는가? 없어도 되는가?
                                .availableDateTime(itemInfoReq.getAvailableDateTime())
                                .build()
                )
        );
    }

    @Transactional
    public void deleteItem(int no) {
        itemRepository.deleteByNo(no);
    }

    public List<ItemResponseDto.ItemInfoRes> getItemList() {
        List<ItemResponseDto.ItemInfoRes> itemInfoResList = new ArrayList<>();
        List<Item> itemList = itemRepository.findAll();
        for (Item item : itemList) {
            itemInfoResList.add(new ItemResponseDto.ItemInfoRes(item));
        }
        return itemInfoResList;
    }

    public ItemResponseDto.ItemInfoRes getItemDetail(int no) {
        return new ItemResponseDto.ItemInfoRes(
                itemRepository.findByNo(no)
        );
    }
}
