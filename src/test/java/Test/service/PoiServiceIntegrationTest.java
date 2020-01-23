//package Test.service;
//
//import com.bae.Application;
//import com.bae.Service.PoiService;
//import com.bae.exceptions.PoiNotFoundException;
//import com.bae.persistence.domain.Poi;
//import com.bae.persistence.repo.PoiRepo;
//
//import org.assertj.core.util.Arrays;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class PoiServiceIntegrationTest {
//
//    @Autowired
//    private PoiService poiService;
//
//    @Autowired
//    private PoiRepo poiRepo;
//
//    private Poi poi;
//    private Poi poiId;
//
//    @Before
//    public void init() {
//        this.poi = new Poi("psit name", "psit link");
//
//        this.poiRepo.deleteAll();
//        this.poiId = this.poiRepo.save(this.poi);
//    }
//    @Test
//    public void AddPoiTest() {
//        assertEquals(this.poiId, this.poiService.addNewPoi(poi));
//    }
//
//    @Test
//    public void deletePoiTest() throws PoiNotFoundException {
//        assertThat(this.poiService.deletePoi(this.poiId.getId())).isFalse();
//    }
//
//    @Test
//    public void FindPoiByIDTest() {
//
//        assertThat(this.poiService.findPoiById(this.poiId.getId())).isEqualTo(this.poiId);
//    }
//
//    @Test
//    public void allPoiTest() {
//        assertThat(this.poiService.getAllPoi()).isEqualTo(Arrays.asList(new Poi[] { this.poiId }));
//    }
//
//    @Test
//    public void updatePoiTest() {
//        Poi newDuck = new Poi("updated name", "updated link");
//        Poi updatedDuck = new Poi(newDuck.getPoiName(), newDuck.getLink());
//        updatedDuck.setId(this.poiId.getId());
//
//        assertThat(this.poiService.updatePoi(this.poiId.getId(), newDuck)).isEqualTo(updatedDuck);
//    }
//
//}
