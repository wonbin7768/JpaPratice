package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {
    /**
     * 에러남 해결해보자
     */
    @Autowired
    ItemService itemService;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    public void saveItem(Item item) throws Exception {
        //given
        Album album = new Album();
        album.setArtist("bin");
        album.setEtc("tdd hi");
        em.flush();
        //when
        itemService.saveItem(album);
        //then
        List<Item> items = itemService.findItems();
        for (Item item1 : items) {
            System.out.println("item1 = " + item1);
        }
    }

}