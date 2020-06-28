package tesst;

import dao.ItemsDao;
import dao.impl.ItemsDaoImpl;
import domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao dao = new ItemsDaoImpl();
        List<Items> list = dao.findAll();

        for (Items items : list) {
            System.out.println(items.getId());
            System.out.println(items.getUsername());
            System.out.println(items.getPassword());
        }
    };
}