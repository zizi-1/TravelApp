//package Test.rest;
//
//import com.bae.Application;
//import com.bae.persistence.domain.Poi;
//import com.bae.persistence.repo.PoiRepo;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.assert.core.util.Arrays;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//@AutoConfigureMockMvc
//public class PoiControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mock;
//
//    @Autowired
//    private PoiRepo poiRepo;
//
//    private ObjectMapper mapper = new ObjectMapper();
//
//    private Poi poi;
//    private Poi poiId;
//    private long id;
//
//    @Before
//    public void init() {
//        this.poiRepo.deleteAll();
//        this.poi = new Poi("Poi name", "Poi link");
//        this.poiId = this.poiRepo.save(this.poi);
//        this.id = this.poiId.getId();
//    }
//
//    @Test
//    public void addPoiTest() throws Exception {
//        String result = this.mock
//                .perform(request(HttpMethod.POST, "/poi/add").contentType(MediaType.APPLICATION_JSON)
//                        .content(this.mapper.writeValueAsString(poi)).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//        assertEquals(this.mapper.writeValueAsString(poiId), result);
//    }
//
//    @Test
//    public void getAllPoiTest() throws Exception {
//        List<Poi> poiList = new ArrayList<>();
//        poiList.add(this.poiId);
//
//        String content = this.mock.perform(request(HttpMethod.GET, "/poi/all").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//
//        assertEquals(this.mapper.writeValueAsString(poiList), content);
//    }
//
//    @Test
//    public void getPoiTest() throws Exception {
//        this.mock.perform(request(HttpMethod.GET, "/poi/get/" + this.id)).andExpect(status().isOk());
//    }
//
//    @Test
//    public void updatePoiTest() throws Exception {
//        Poi newPoi = new Poi("updated name", "updated link");
//        Poi updatedPoi = new Poi(newPoi.getPoiName(), newPoi.getLink());
//        updatedPoi.setId(this.id);
//
//        String result = this.mock
//                .perform(request(HttpMethod.PUT, "/poi/update/" + this.id).accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newPoi)))
//                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//
//        assertEquals(this.mapper.writeValueAsString(updatedPoi), result);
//    }
//
//    @Test
//    public void deletePoiTest() throws Exception {
//        this.mock.perform(request(HttpMethod.DELETE, "/poi/delete/" + this.id)).andExpect(status().isOk());
//    }
//}